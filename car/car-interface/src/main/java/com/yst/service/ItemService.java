package com.yst.service;

import com.yst.common.pojo.EasyUIDataGridResult;
import com.yst.pojo.Item;
import com.yst.pojo.ItemDesc;

public interface ItemService {
	
	EasyUIDataGridResult getItemList();
	
	int addItem(Item item,ItemDesc desc);

}
