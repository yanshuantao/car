package com.yst.service;

import java.util.List;

import com.yst.common.pojo.EasyUIDataGridResult;
import com.yst.pojo.Item;
import com.yst.pojo.ItemDesc;
import com.yst.pojo.ItemSpecification;

public interface ItemService {
	
	EasyUIDataGridResult getItemList(int page, int rows);
	
	void addItem(Item item,List<ItemSpecification> specList,ItemDesc desc);

}
