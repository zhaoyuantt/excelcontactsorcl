package com.landasoft.excelcontactsorcl.mypojo;

import java.util.Map;

/**
 * Layui 多文件上传返回结果
 * @author zhaoyuan
 * @date 2020,May 23 6:22 pm
 */
public class LayuiUploadResult {

    //code=0代表上传成功
    private int code;

    //总文件数
    private int total;

    //请求成功的文件数
    private int successful;

    //请求失败的文件数
    private int aborted;

    private String msg;

    private Map<Object,Object> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSuccessful() {
        return successful;
    }

    public void setSuccessful(int successful) {
        this.successful = successful;
    }

    public int getAborted() {
        return aborted;
    }

    public void setAborted(int aborted) {
        this.aborted = aborted;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<Object, Object> getData() {
        return data;
    }

    public void setData(Map<Object, Object> data) {
        this.data = data;
    }
}
