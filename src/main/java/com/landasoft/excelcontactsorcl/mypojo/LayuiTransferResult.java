package com.landasoft.excelcontactsorcl.mypojo;

import java.util.List;
import java.util.Map;

/**
 * Layui穿梭框返回结果
 * @author zhaoyuan
 * @date 2020,May 25 6:52 pm
 */
public class LayuiTransferResult {

    private List<Map<Object,String>> data;

    public List<Map<Object, String>> getData() {
        return data;
    }

    public void setData(List<Map<Object, String>> data) {
        this.data = data;
    }
}
