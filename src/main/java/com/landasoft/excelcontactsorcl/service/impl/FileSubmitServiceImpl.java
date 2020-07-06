package com.landasoft.excelcontactsorcl.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.landasoft.excelcontactsorcl.common.pojo.Comments;
import com.landasoft.excelcontactsorcl.common.pojo.SDMapping;
import com.landasoft.excelcontactsorcl.common.storage.TableComments;
import com.landasoft.excelcontactsorcl.config.SpringContextUtils;
import com.landasoft.excelcontactsorcl.constant.CategoryConstant;
import com.landasoft.excelcontactsorcl.mapper.TFileImportHistoryMapper;
import com.landasoft.excelcontactsorcl.mapper.TFileInfoMapper;
import com.landasoft.excelcontactsorcl.mapper.TFileSheetMapper;
import com.landasoft.excelcontactsorcl.common.pojo.LayuiTransferResult;
import com.landasoft.excelcontactsorcl.mapper.TItemInfoMapper;
import com.landasoft.excelcontactsorcl.mymapper.CommentsMapper;
import com.landasoft.excelcontactsorcl.pojo.*;
import com.landasoft.excelcontactsorcl.service.FileSubmitService;
import com.landasoft.excelcontactsorcl.thread.ImportWorkThread;
import com.landasoft.excelcontactsorcl.util.ExcelUtils;
import com.landasoft.excelcontactsorcl.util.IDUtils;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 文件提交Service接口实现
 * @author zhaoyuan
 * @date 2020,May 24 2:23 pm
 */
@Service
public class FileSubmitServiceImpl implements FileSubmitService {

    private static final Logger log = Logger.getLogger(FileSubmitServiceImpl.class);

    @Autowired
    private TFileInfoMapper fileInfoMapper;
    @Autowired
    private TFileSheetMapper fileSheetMapper;
    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private TItemInfoMapper itemInfoMapper;
    @Autowired
    private TFileImportHistoryMapper fileImportHistoryMapper;

    @Value("${IMPORT_THREAD_EXEC_NUM}")
    private String IMPORT_THREAD_EXEC_NUM;

    //导入成功的记录数
    public static AtomicInteger IMPORT_SUCCESS_NUM = new AtomicInteger(0);
    //导入失败的记录数
    public static AtomicInteger IMPORT_ERROR_NUM = new AtomicInteger(0);

    @Override
    public MyResult getFileSheetListByFileId(String fileId) {
        //判断必传参数
        if(StringUtils.isBlank(fileId)){
            throw new RuntimeException("Must param file id is null!");
        }

        //结果容器
        List<LayuiTransferResult> list = new ArrayList<LayuiTransferResult>();

        TFileInfoExample example = new TFileInfoExample();
        TFileInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(fileId);
        List<TFileInfo> fileInfoList = fileInfoMapper.selectByExample(example);

        //没有查询到记录
        if(null == fileInfoList || 0 == fileInfoList.size()){
            return MyResult.build(505,"No record was found according to fileid！");
        }

        TFileInfo fileInfo = fileInfoList.get(0);
        String filePath = fileInfo.getFilePath().replace("\\","/");
        log.info("获取sheet时，文件的存储路径"+filePath);

        //获取Sheet
        //FileInputStream fileInputStream = null;

        //fileInputStream = new FileInputStream(filePath);
        //HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        Workbook workBook = ExcelUtils.getWorkBook(filePath);
        int sheetNumbers = workBook.getNumberOfSheets();

        for(int i = 0 ;i < sheetNumbers;i++){
            Sheet sheet = workBook.getSheetAt(i);
            String sheetName = sheet.getSheetName();

            LayuiTransferResult layuiTransferResult = new LayuiTransferResult();
            String value = DigestUtils.md5DigestAsHex(sheetName.getBytes(Charset.forName("UTF-8")));
            layuiTransferResult.setValue(value);
            layuiTransferResult.setTitle(sheetName);
            list.add(layuiTransferResult);
        }


        return MyResult.ok(list);
    }

    @Override
    public List<TFileSheet> getFileSheet(String fileId) {
        TFileSheetExample fileSheetExample = new TFileSheetExample();
        TFileSheetExample.Criteria criteria = fileSheetExample.createCriteria();
        criteria.andFileIdEqualTo(fileId);
        List<TFileSheet> fileSheetList = fileSheetMapper.selectByExample(fileSheetExample);

        if(null == fileSheetList || 0 == fileSheetList.size()){
            return null;
        }

        return fileSheetList;
    }

    @Override
    @Transactional
    public int saveFileSheet(TFileSheet fileSheet) {
        return 0;
    }

    @Override
    @Transactional
    public int saveFileSheet(List<TFileSheet> fileSheetList) {
        return 0;
    }

    @Override
    public MyResult showViewExcel(String fileId, String viewNum,List<LayuiTransferResult> layuiTransferResultList) {
        //校验必传参数
        if(StringUtils.isBlank(fileId)){
            throw new RuntimeException("Must param file id is null!");
        }
        if(StringUtils.isBlank(viewNum)){
            throw new RuntimeException("Must param viewNum is null!");
        }

        //获得文件路径
        TFileInfoExample example = new TFileInfoExample();
        TFileInfo fileInfo = fileInfoMapper.selectByPrimaryKey(fileId);

        if(null == fileInfo){
            return MyResult.build(505,"No record was found according to fileid！");
        }

        String filePath = fileInfo.getFilePath();

        StringBuffer sb = new StringBuffer();

        try {
            //获得工作表
            Workbook workBook = ExcelUtils.getWorkBook(filePath);

            for (int i = 0; i < layuiTransferResultList.size(); i++) {
                LayuiTransferResult layuiTransferResult = layuiTransferResultList.get(i);
                String title = layuiTransferResult.getTitle();
                Sheet sheet = workBook.getSheet(title);

                //行数
                int rowNum = sheet.getLastRowNum();

                Integer viewNum_i = Integer.valueOf(viewNum);

                sb.append("<table border=\"1\">");

                for(int j = 0;j < rowNum;j++){
                    //当前行
                    Row row = sheet.getRow(j);

                    //当前行的列数
                    short cellNum = row.getLastCellNum();

                    sb.append("<tr>");

                    for(int z = 0;z < cellNum;z++){
                        Cell cell = row.getCell(z);


                        if(null == cell){
                            if(0 == z){
                                sb.append("<th>"+j+"</th>");
                            }
                            sb.append("<td>null</td>");
                            System.out.print("null          ");
                        }else{

                            if(0 == j){//标题行
                                if(0 == z){
                                    sb.append("<th>#</th>");
                                }
                                sb.append("<th>"+cell.toString()+"</th>");
                            }else{
                                if(0 == z){
                                    sb.append("<th>"+j+"</th>");
                                }
                                sb.append("<td>"+cell.toString()+"</td>");
                            }

                            System.out.print(cell.toString()+"          ");
                        }
                    }

                    sb.append("</tr>");

                    System.out.println();

                    //成立终止
                    if(j == viewNum_i){
                        break;
                    }
                }
                    sb.append("</table>");
            }
        } catch (NumberFormatException e) {
            log.error("Read excel is error!" );
            e.printStackTrace();
            return MyResult.build(501,"Read excel is error!");
        }

        return MyResult.ok(sb.toString());
    }

    @Override
    public MyResult getSourceAndDbField(String fileId) {
        if(StringUtils.isBlank(fileId)){
            throw new RuntimeException("Must param file id is null!");
        }
        //得到文件储存路径
        TFileInfo fileInfo = fileInfoMapper.selectByPrimaryKey(fileId);

        if(null == fileInfo){
            return MyResult.build(502,"NullPointException error!");
        }

        String filePath = fileInfo.getFilePath();

        //获取excel title字段
        List<String> excelTitleList = ExcelUtils.getExcelTitle(filePath);

        //获取表字段注释
        List<Comments> columnList = commentsMapper.getTableColumnList("T_ITEM_INFO");

        //存放表字段注释信息，用于导入读取规格
        Map<String, String> itemComments = TableComments.itemComments;
        for (int i = 0; i < columnList.size(); i++) {
            Comments comments =  columnList.get(i);
            itemComments.put(comments.getComments(),comments.getColumnName());
        }

        //返回结果集容器
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("SFIELDL",excelTitleList);
        jsonObject.put("DFIELDL",columnList);

        return MyResult.ok(jsonObject);
    }

    @Override
    public Map<Integer,String> importBefore(String fileId, List<LayuiTransferResult> sheetList, List<SDMapping> sdMappingList) {
        //校验参数
        if(StringUtils.isBlank(fileId)){
            throw new RuntimeException("Must param file id is null!");
        }

        //根据fileId确定excel文件title字段与cell的对应关系
        TFileInfo fileInfo = fileInfoMapper.selectByPrimaryKey(fileId);

        if(null == fileInfo){
            throw  new RuntimeException("No record was found according to fileid！");
        }

        String filePath = fileInfo.getFilePath();

        List<String> excelTitleList = ExcelUtils.getExcelTitle(filePath);

        //存放title与cell的对应关系
        Map<String,Integer> titleCellMap = new HashMap<String, Integer>();

        for (int i = 0; i < excelTitleList.size(); i++) {
            String title =  excelTitleList.get(i);
            titleCellMap.put(title,i);
        }

        //构建读取规则
        Map<Integer,String> readRuleMap = new HashMap<Integer, String>();

        for(int i = 0;i<sdMappingList.size();i++){
            SDMapping sdMapping = sdMappingList.get(i);

            String valueS = sdMapping.getValueS();
            String valueD = sdMapping.getValueD();

            readRuleMap.put(titleCellMap.get(valueS),TableComments.itemComments.get(valueD));

        }

        //返回结果
        return readRuleMap;
    }

    @Override
    @Transactional
    public int importDb(Map<String, String> tjMap) {
        if(null == tjMap || 0 == tjMap.size()){
            return 0;
        }

        TItemInfoExample itemInfoExample = new TItemInfoExample();
        TItemInfo itemInfo = new TItemInfo();

        int iResult = 0;

        //处理参数
        try {
            String title = tjMap.get("TITLE");//商品标题
            if(StringUtils.isNotBlank(title)){
                itemInfo.setTitle(title);
            }

            String sellPoint = tjMap.get("SELL_POINT");//商品卖点
            if(StringUtils.isNotBlank(sellPoint)){
                itemInfo.setSellPoint(sellPoint);
            }

            String price = tjMap.get("PRICE");//商品价格
            if(StringUtils.isNotBlank(price)){
                itemInfo.setPrice(BigDecimal.valueOf(Long.valueOf(price.replace(".0",""))));
            }

            String num = tjMap.get("NUM");//商品数量
            if(StringUtils.isNotBlank(num)){
                itemInfo.setNum(BigDecimal.valueOf(Long.valueOf(num.replace(".0",""))));
            }

            String barcode = tjMap.get("BARCODE");//商品条形码
            if(StringUtils.isNotBlank(barcode)){
                itemInfo.setBarcode(barcode);
            }

            String image = tjMap.get("IMAGE");//商品图片
            if(StringUtils.isNotBlank(image)){
                itemInfo.setImage(image);
            }

            String cid = tjMap.get("CID");//所属类目，叶子类目
            if(StringUtils.isNotBlank(cid)){
                itemInfo.setCid(cid);
            }

            String cname = tjMap.get("CNAME");//类目名称
            if(StringUtils.isNotBlank(cname)){
                itemInfo.setCname(cname);
            }
            
            //其他属性
            String drpc = tjMap.get("drpc");//导入批次
            if(StringUtils.isNotBlank(drpc)){
                itemInfo.setImportNum(Short.valueOf(drpc));
            }

            String fileId = tjMap.get("fileId");
            if(StringUtils.isNotBlank(fileId)){
                itemInfo.setFileId(fileId);
            }

            itemInfo.setStatus((short) 1);//商品状态，1-正常，2-下架，3-删除

            itemInfo.setCreated(new Date());
            itemInfo.setUpdated(new Date());

            itemInfo.setId(IDUtils.getGeneId());

            //执行插入
            iResult = itemInfoMapper.insert(itemInfo);


        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

        return iResult;
    }

    @Override
    public MyResult importMidele(String fileId,List<LayuiTransferResult> sheetList, String drpc, Map<Integer, String> readRuleMap) {

        long startTime = System.currentTimeMillis();

        JSONObject jsonObject = new JSONObject();

        String filePath = getFilePathByFileId(fileId);
        Workbook workBook = ExcelUtils.getWorkBook(filePath);

        int total = 0;

        try {
            for (int i = 0; i < sheetList.size(); i++) {
                LayuiTransferResult layuiTransferResult =  sheetList.get(i);
                String title = layuiTransferResult.getTitle();
                Sheet sheet = workBook.getSheet(title);

                //计算核心线程数、readInDdex、endIndex

                //总共多少行
                int totalRowNum = sheet.getLastRowNum();
                total = total+totalRowNum;
                Integer threadReadNum = Integer.valueOf(IMPORT_THREAD_EXEC_NUM);

                //核心线程数
                int coreSize = 0;

                if(0 == totalRowNum%threadReadNum){
                    coreSize = totalRowNum/threadReadNum;
                }else{
                    coreSize = (totalRowNum/threadReadNum)+1;
                }

                //最大线程数
                int maxSize = coreSize + 5;

                //等待工具类
                CountDownLatch countDownLatch = new CountDownLatch(coreSize);

                //前方高能，将开辟线程
                ExecutorService pool = new ThreadPoolExecutor(
                        coreSize,
                        maxSize,
                        3,
                        TimeUnit.NANOSECONDS,
                        new ArrayBlockingQueue<Runnable>(20),
                        new ThreadPoolExecutor.DiscardOldestPolicy()
                );

                for(int j = 1;j < totalRowNum ; j=j+threadReadNum){
                    int readIndex = j;
                    int endIndex = j+threadReadNum;
                    if(totalRowNum < endIndex){
                        endIndex = totalRowNum;
                    }

                    ImportWorkThread worker =  new
                            ImportWorkThread(sheet,readIndex,endIndex,drpc,fileId,countDownLatch,readRuleMap, SpringContextUtils.getBean(FileSubmitService.class));

                    pool.execute(worker);
                }

                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            long endTime = System.currentTimeMillis();

            jsonObject.put("TOTAL",total);
            jsonObject.put("SUCCESS",IMPORT_SUCCESS_NUM);
            jsonObject.put("ERROR",IMPORT_ERROR_NUM);
            jsonObject.put("TIME",endTime-startTime);

            //制空计数器
            IMPORT_SUCCESS_NUM = new AtomicInteger(0);
            IMPORT_ERROR_NUM = new AtomicInteger(0);

            //返回结果之前记录导入历史
            TFileImportHistory fileImportHistory = new TFileImportHistory();
            fileImportHistory.setId(IDUtils.getGeneId());
            fileImportHistory.setFileName(getFileNameByFileId(fileId));
            fileImportHistory.setFileRowNum(String.valueOf(total));
            fileImportHistory.setFileImportNum(Short.valueOf(drpc));
            fileImportHistory.setFileId(fileId);
            fileImportHistory.setCatagory(CategoryConstant.getName("item_info"));
            fileImportHistory.setCreated(new Date());
            fileImportHistory.setUpdated(new Date());

            int iResult = fileImportHistoryMapper.insert(fileImportHistory);

            if(0 == iResult){
                return MyResult.build(101,"Add excel import history is error!");
            }

            return MyResult.ok(jsonObject);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return MyResult.build(888,e.getMessage());
        }
    }

    String getFilePathByFileId(String fileId){
        TFileInfo fileInfo = fileInfoMapper.selectByPrimaryKey(fileId);
        return fileInfo.getFilePath();
    }

    String getFileNameByFileId(String fileId){
        TFileInfo fileInfo = fileInfoMapper.selectByPrimaryKey(fileId);
        return fileInfo.getFileName();
    }
}
