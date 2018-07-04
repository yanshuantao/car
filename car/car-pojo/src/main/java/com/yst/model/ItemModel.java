package com.yst.model;

import java.io.Serializable;

import com.yst.pojo.Item;
import com.yst.pojo.ItemDesc;

public class ItemModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5097539954526880612L;
	
	private Item item;
	
	private ItemSpecificationModel specModel;
	
	private ItemDesc desc;
	
	public ItemSpecificationModel getSpecModel() {
		return specModel;
	}

	public void setSpecModel(ItemSpecificationModel specModel) {
		this.specModel = specModel;
	}

	public ItemDesc getDesc() {
		return desc;
	}

	public void setDesc(ItemDesc desc) {
		this.desc = desc;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	

}
