package com.yst.model;

import java.io.Serializable;

import com.yst.pojo.Item;

public class ItemResultModel implements Serializable{

	/**
	 * 供商品列表table页面使用
	 */
	private static final long serialVersionUID = -7375578368154714165L;
	

	private Item item;
	
	//标签名称
	private String labelName;
	//品牌名称
	private String brandName;
	//型号名称
	private String modelName;
	
	
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

}
