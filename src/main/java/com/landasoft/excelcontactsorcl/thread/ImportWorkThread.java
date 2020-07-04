package com.landasoft.excelcontactsorcl.thread;

import com.landasoft.excelcontactsorcl.service.FileSubmitService;
import com.landasoft.excelcontactsorcl.service.impl.FileSubmitServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * 导入工作线程
 * @author zhaoyuan
 * @date 2020,July 4 3:43 pm
 */
public class ImportWorkThread implements Runnable{

    //Excel 文件sheet
    private Sheet sheet;
    //工作线程开始读的sheet中的行数
    private Integer readStartIndex;
    //工作线程结束读的sheet中的行数
    private Integer readEndIndex;
    //导入批次
    private String drpc;
    //文件Id
    private String fileId;
    //计数器
    private CountDownLatch countDownLatch;

    //读取规则
    private Map<Integer,String> readRuleMap;

    private FileSubmitService fileSubmitService;

    public ImportWorkThread() {
    }

    public ImportWorkThread(Sheet sheet, Integer readStartIndex, Integer readEndIndex, String drpc, String fileId, CountDownLatch countDownLatch, Map<Integer, String> readRuleMap, FileSubmitService fileSubmitService) {
        this.sheet = sheet;
        this.readStartIndex = readStartIndex;
        this.readEndIndex = readEndIndex;
        this.drpc = drpc;
        this.fileId = fileId;
        this.countDownLatch = countDownLatch;
        this.readRuleMap = readRuleMap;
        this.fileSubmitService = fileSubmitService;
    }

    @Override
    public void run() {

        //循环readStartIndex到readEndIndex
        for(int i = readStartIndex;i <= readEndIndex;i++){
            //用于最终导入的容器
            Map<String,String> tjMap = new HashMap<String, String>();
            tjMap.put("drpc",drpc);
            tjMap.put("fileId",fileId);

            //根据sheet获取行
            Row row = sheet.getRow(i);

            //处理行中单元格
            //遍历读取规格
            for(Integer key : readRuleMap.keySet()){
                Cell cell = row.getCell(key);
                if(cell != null){
                    String dbColume = readRuleMap.get(key);
                    tjMap.put(dbColume,cell.toString());
                }

            }

            //插入数据库
            int iResult = fileSubmitService.importDb(tjMap);

            if(1 == iResult){
                FileSubmitServiceImpl.IMPORT_SUCCESS_NUM.incrementAndGet();
            }else if (0 == iResult){
                FileSubmitServiceImpl.IMPORT_ERROR_NUM.incrementAndGet();
            }
        }

        //计数器减1
        countDownLatch.countDown();

    }
}
