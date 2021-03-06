package com.landasoft.excelcontactsorcl;

import com.landasoft.excelcontactsorcl.config.SpringContextUtils;
import com.landasoft.excelcontactsorcl.constant.CategoryConstant;
import com.landasoft.excelcontactsorcl.pojo.TItemInfo;
import com.landasoft.excelcontactsorcl.service.FileImportHistoryService;
import com.landasoft.excelcontactsorcl.service.FileSubmitService;
import com.landasoft.excelcontactsorcl.service.TjService;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 测试Spring的环境
 * @author zhaoyuan
 * @date 2020,May 22 11:34 pm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEnvironment {

    @Autowired
    private TjService tjService;
    @Autowired
    private FileImportHistoryService fileImportHistoryService;


    @Test
    public void testGetItemInfo(){
        List<TItemInfo> itemInfoList = tjService.getItemInfo();
        if(null != itemInfoList)
            System.out.println(itemInfoList.size());
    }

    @Test
    public void testMd5DigestAsHex(){
        String hex = DigestUtils.md5DigestAsHex("索菲亚".getBytes(Charset.forName("UTF-8")));
        System.out.println(hex);
    }
    
    @Test
    public void  testGetBean(){
        FileSubmitService fileSubmitService = SpringContextUtils.getBean(FileSubmitService.class);
    }

    @Test
    public void testGetFileImportHistory(){
        fileImportHistoryService.getFileImportHistory(null,1,10);
    }

    @Test
    public void getConstantGetName(){
        String name = CategoryConstant.getName("item_info");
        System.out.println(name);
    }


}
