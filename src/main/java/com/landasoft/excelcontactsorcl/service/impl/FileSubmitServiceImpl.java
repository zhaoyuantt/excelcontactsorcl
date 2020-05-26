package com.landasoft.excelcontactsorcl.service.impl;

import com.landasoft.excelcontactsorcl.mapper.TFileInfoMapper;
import com.landasoft.excelcontactsorcl.mapper.TFileSheetMapper;
import com.landasoft.excelcontactsorcl.mypojo.LayuiTransferAllResult;
import com.landasoft.excelcontactsorcl.mypojo.LayuiTransferResult;
import com.landasoft.excelcontactsorcl.pojo.TFileInfo;
import com.landasoft.excelcontactsorcl.pojo.TFileInfoExample;
import com.landasoft.excelcontactsorcl.pojo.TFileSheet;
import com.landasoft.excelcontactsorcl.pojo.TFileSheetExample;
import com.landasoft.excelcontactsorcl.service.FileSubmitService;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public MyResult getFileSheetListByFileId(String fileId) {
        if(StringUtils.isBlank(fileId)){
            throw new RuntimeException("文件Id为blank");
        }

        LayuiTransferAllResult layuiTransferAllResult = new LayuiTransferAllResult();

        //首先判断有没有进行过选择sheet操作
        List<TFileSheet> tFileSheetList = getFileSheet(fileId);
        if(null != tFileSheetList){
            String values[] = new String[tFileSheetList.size()];
            for (int i = 0; i < tFileSheetList.size(); i++) {
                TFileSheet fileSheet =  tFileSheetList.get(i);
                String value = fileSheet.getValue();
                values[i] = value;
            }
            layuiTransferAllResult.setValue(values);
        }


        //结果容器
        List<LayuiTransferResult> list = new ArrayList<LayuiTransferResult>();

        TFileInfoExample example = new TFileInfoExample();
        TFileInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(fileId);
        List<TFileInfo> fileInfoList = fileInfoMapper.selectByExample(example);

        //没有查询到记录
        if(null == fileInfoList || 0 == fileInfoList.size()){
            return MyResult.build(501,"数据库查询异常");
        }

        TFileInfo fileInfo = fileInfoList.get(0);
        String filePath = fileInfo.getFilePath().replace("\\","/");
        log.info("获取sheet时，文件的存储路径");

        //获取Sheet
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            //HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            int sheetNumbers = workbook.getNumberOfSheets();

            for(int i = 0 ;i < sheetNumbers;i++){
                XSSFSheet sheet = workbook.getSheetAt(i);
                String sheetName = sheet.getSheetName();

                LayuiTransferResult layuiTransferResult = new LayuiTransferResult();
                String value = DigestUtils.md5DigestAsHex(sheetName.getBytes(Charset.forName("UTF-8")));
                layuiTransferResult.setValue(value);
                layuiTransferResult.setTitle(sheetName);
                list.add(layuiTransferResult);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        layuiTransferAllResult.setData(list);

        return MyResult.ok(layuiTransferAllResult);
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
}
