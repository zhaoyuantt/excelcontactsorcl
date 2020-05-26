package com.landasoft.excelcontactsorcl.mypojo;

import java.util.List;

/**
 * Layui 穿梭框初始右侧数据返回结果
 * @author zhaoyuan
 * @date 2020,May 26 10:30 pm
 * transfer.render({
 *     elem: '#test3'
 *     ,data: data2
 *     ,value: ["1", "3", "5", "7", "9", "11"]
 *   })
 */
public class LayuiTransferAllResult {
    private List<LayuiTransferResult> data;
    private String[] value;

    public List<LayuiTransferResult> getData() {
        return data;
    }

    public void setData(List<LayuiTransferResult> data) {
        this.data = data;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }
}
