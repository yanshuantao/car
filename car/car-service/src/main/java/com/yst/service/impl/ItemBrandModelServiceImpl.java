package com.yst.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yst.common.pojo.EasyUITreeNode;
import com.yst.mapper.ItemBrandModelMapper;
import com.yst.pojo.ItemBrandModel;
import com.yst.pojo.ItemBrandModelExample;
import com.yst.pojo.ItemBrandModelExample.Criteria;
import com.yst.service.ItemBrandModelService;

@Service
public class ItemBrandModelServiceImpl implements ItemBrandModelService{

	@Autowired
	private ItemBrandModelMapper mapper;
	
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		//根据父节点id查询子节点列表
		ItemBrandModelExample example = new ItemBrandModelExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		//设置parentid
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<ItemBrandModel> list = mapper.selectByExample(example);
		//转换成EasyUITreeNode列表
		List<EasyUITreeNode> resultList = new ArrayList<>();
		for (ItemBrandModel tbItemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			//如果节点下有子节点“closed”，如果没有子节点“open”
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			//添加到节点列表
			resultList.add(node);
		}

		return resultList;
	}

	@Override
	public String getBrandName(long id) {
		return mapper.getBrandName(id);
	}

	@Override
	public ItemBrandModel selectByPrimaryKey(long id) {
		return mapper.selectByPrimaryKey(id);
	}

}
