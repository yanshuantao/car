package com.yst.service;

import java.util.List;

import com.yst.common.pojo.EasyUITreeNode;


public interface ItemBrandModelService {
	
	List<EasyUITreeNode> getItemCatList(long parentId);

}
