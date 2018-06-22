package com.yst.common.pojo;

import java.io.Serializable;

public class JsonObjectResult <T extends Serializable> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5381530848138746111L;
	
	private int code=0000;
	private String resultStr = "";
	private T t;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getResultStr() {
		return resultStr;
	}
	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
}
