package com.landasoft.excelcontactsorcl;

import com.landasoft.excelcontactsorcl.common.pojo.LayuiTransferResult;
import com.landasoft.excelcontactsorcl.service.FileSubmitService;
import com.landasoft.excelcontactsorcl.util.ExcelUtils;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件相关测试类
 * @author zhaoyuan
 * @date 2020,May 24 9:46 pm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFile {

    @Autowired
    private FileSubmitService fileSubmitService;

    @Test
    public void testGetExcelSheet(){
        MyResult myResult = fileSubmitService.getFileSheetListByFileId("27dc9e058e4c48039bca35c0f0dd8392");
        System.out.println(myResult.getStatus());
    }

    @Test
    public void testViewExcel(){
        //参数
        List<LayuiTransferResult> list = new ArrayList<LayuiTransferResult>();
        LayuiTransferResult layuiTransferResult0 = new LayuiTransferResult();
        layuiTransferResult0.setTitle("tb_item");
        layuiTransferResult0.setValue("aaabbbccc");
        LayuiTransferResult layuiTransferResult1 = new LayuiTransferResult();
        layuiTransferResult1.setTitle("Sheet1");
        layuiTransferResult1.setValue("dddeeefff");
        list.add(layuiTransferResult0);
        //list.add(layuiTransferResult1);

        fileSubmitService.showViewExcel("bc7138422e7c4203accfa21e1d8bf396","5",list);
    }

    @Test
    public void testGetExcelTitle(){
        List<String> excelTitleList = ExcelUtils.getExcelTitle("G:\\file\\tj\\1593591281578455.xlsx");
        System.out.println(excelTitleList.size());
    }

    @Test
    public void testGetSDFieldList(){
        MyResult myResult = fileSubmitService.getSourceAndDbField("b8e7406250b44c1598b72ec6bf99196d");
    }

}
