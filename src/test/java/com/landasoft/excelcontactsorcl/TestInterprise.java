package com.landasoft.excelcontactsorcl;

import com.landasoft.excelcontactsorcl.pojo.TInterprise;
import com.landasoft.excelcontactsorcl.service.InterpriseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestInterprise {
    
    @Autowired
    private InterpriseService interpriseService;

    @Test
    public void testGetInterpriseList(){
        List<TInterprise> interpriseList = interpriseService.getInterpriseList();
    }

    @Test
    public void testUpdateInterprise(){
        interpriseService.updateInterprise("","");
    }
}
