package com.yst.service;

import java.util.List;

import com.yst.common.pojo.EasyUIDataGridResult;
import com.yst.common.pojo.EasyUITreeNode;
import com.yst.pojo.ItemBrandModel;


public interface ItemBrandModelService {
	
	List<EasyUITreeNode> getItemCatList(long parentId);
	
	String getBrandName(long id);
	
	ItemBrandModel selectByPrimaryKey(long id);
	
	EasyUIDataGridResult getAllBrand();
	
	int updateDo(Long id,String name);
	
}
