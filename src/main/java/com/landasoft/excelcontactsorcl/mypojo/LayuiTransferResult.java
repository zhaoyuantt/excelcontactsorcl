package com.landasoft.excelcontactsorcl.mypojo;

/**
 * Layui穿梭框返回结果
 * @author zhaoyuan
 * @date 2020,May 25 6:52 pm
 * 模拟数据
 *   var data1 = [
 *     {"value": "1", "title": "李白"}
 *     ,{"value": "2", "title": "杜甫"}
 *     ,{"value": "3", "title": "苏轼"}
 *     ,{"value": "4", "title": "李清照"}
 *     ,{"value": "5", "title": "鲁迅", "disabled": true}
 *     ,{"value": "6", "title": "巴金"}
 *     ,{"value": "7", "title": "冰心"}
 *     ,{"value": "8", "title": "矛盾"}
 *     ,{"value": "9", "title": "贤心"}
 *   ]
 */
public class LayuiTransferResult {

    private String value;
    private String title;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
