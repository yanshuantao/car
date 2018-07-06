package com.yst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yst.mapper.ItemSpecificationMapper;
import com.yst.pojo.ItemSpecification;
import com.yst.pojo.ItemSpecificationExample;
import com.yst.pojo.ItemSpecificationExample.Criteria;
import com.yst.service.ItemSpecService;

@Service
public class ItemSpecServiceImpl implements ItemSpecService{

	@Autowired
	private ItemSpecificationMapper mapper;
	@Override
	public List<ItemSpecification> getSpecListByItemId(Integer itemId) {
		ItemSpecificationExample example=new ItemSpecificationExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		return mapper.selectByExampleWithBLOBs(example);
	}

}
