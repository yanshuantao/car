package com.yst.common.pojo;

import java.io.Serializable;

public class EasyUITree implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2093557049532054030L;
	private long id;
	private String name;
	private String iconCls;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

}
