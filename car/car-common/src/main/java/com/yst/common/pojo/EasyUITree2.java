package com.yst.common.pojo;

import java.io.Serializable;

public class EasyUITree2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5695025237042250202L;
	
	private long id;
	private String name;
	private long _parentId;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long get_parentId() {
		return _parentId;
	}
	public void set_parentId(long _parentId) {
		this._parentId = _parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
