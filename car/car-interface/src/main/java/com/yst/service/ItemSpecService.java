package com.yst.service;

import java.util.List;

import com.yst.pojo.ItemSpecification;

public interface ItemSpecService {
	
	List<ItemSpecification> getSpecListByItemId(Integer itemId);

}
