package com.landasoft.excelcontactsorcl;

import com.landasoft.excelcontactsorcl.pojo.TItemInfo;
import com.landasoft.excelcontactsorcl.service.TjService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void testGetItemInfo(){
        List<TItemInfo> itemInfoList = tjService.getItemInfo();
        if(null != itemInfoList)
            System.out.println(itemInfoList.size());
    }
}
