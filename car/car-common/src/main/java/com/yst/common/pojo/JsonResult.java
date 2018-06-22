package com.yst.common.pojo;

import java.io.Serializable;

/**
 * 封装返回json结果
 * @author user
 *
 */
public class JsonResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6194861879609995515L;
	
	private int code=0000;
	private String resultStr = "";
	
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
}
