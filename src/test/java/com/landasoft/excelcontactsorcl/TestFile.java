package com.landasoft.excelcontactsorcl;

import com.landasoft.excelcontactsorcl.service.FileSubmitService;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
