package com.landasoft.excelcontactsorcl.common.pojo;

/**
 * 用于描述表字段注释集合
 * @author zhaoyuan
 * @date 2020,July 2
 */
public class Comments {
    //列名
    private String columnName;

    //列注释
    private String comments;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
