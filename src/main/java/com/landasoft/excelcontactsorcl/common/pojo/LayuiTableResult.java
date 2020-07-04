package com.landasoft.excelcontactsorcl.common.pojo;

import java.util.List;

/**
 * layui数据表格响应格式
 * @author zhaoyaun
 * @date 2020,Feb 13 11:50 am
 */
public class LayuiTableResult {

	private int code;
	
	private String msg;
	
	private int count;
	
	private List<?> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "LayuiTableResult [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	
}
