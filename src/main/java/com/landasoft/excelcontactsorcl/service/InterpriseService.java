package com.landasoft.excelcontactsorcl.service;

import com.landasoft.excelcontactsorcl.pojo.TInterprise;
import com.landasoft.excelcontactsorcl.pojo.TInterpriseCtrl;

import java.util.List;

public interface InterpriseService {

    /**
     *
     * @return
     */
    public List<TInterprise> getInterpriseList();

    /**
     *
     * @param flag
     * @param interpriseCtrl
     */
    public void insertInterpriseCtrl(int flag,TInterpriseCtrl interpriseCtrl);

    void updateInterprise(String id,String same_person);
}
