package com.landasoft.excelcontactsorcl.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * excel操作工具类
 * @author zhaoyuan
 * @date 2020,June 30
 */
public class ExcelUtils {

    /**
     * 获取工作表
     * @param filepath
     * @return
     */
    public static Workbook getWorkBook(String filepath){
        File file = new File(filepath);

        Workbook workbook = null;
        InputStream inputStream = null;
        //判断文件是否存在
        /*if(!file.exists()){
            throw new RuntimeException("File is not found,"+filepath);
        }*/

        //获得后缀名
        String fileType = filepath.substring(filepath.lastIndexOf("."));

        try {
            inputStream = new FileInputStream(file);
            if(".xls".equals(fileType)){
                workbook = new HSSFWorkbook(inputStream);
            }else if(".xlsx".equals(fileType)){
                workbook = new XSSFWorkbook(inputStream);
            }else{
                throw new RuntimeException("File type error!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return workbook;
    }

    /**
     * 获取excel title字段集合
     * @param filepath
     * @return
     */
    public static List<String> getExcelTitle(String filepath){
        Workbook workBook = getWorkBook(filepath);

        Sheet sheet = workBook.getSheetAt(0);

        //获取首行
        Row row = sheet.getRow(0);

        //首行一共多少列
        short cellNum = row.getLastCellNum();

        //结果集
        List<String> list = new ArrayList<String>();

        for (int i = 0;i<cellNum;i++){
            Cell cell = row.getCell(i);
            list.add(cell.toString());
        }

        return list;
    }
}
