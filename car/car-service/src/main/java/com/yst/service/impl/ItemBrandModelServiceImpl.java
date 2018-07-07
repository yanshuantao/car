package com.yst.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yst.common.pojo.EasyUIDataGridResult;
import com.yst.common.pojo.EasyUITree;
import com.yst.common.pojo.EasyUITree2;
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

	@Override
	public EasyUIDataGridResult getAllBrand() {
		EasyUIDataGridResult result=new EasyUIDataGridResult();
		ItemBrandModelExample example = new ItemBrandModelExample();
		List<ItemBrandModel> list=mapper.selectByExample(example);
		List treeList=new ArrayList();
		for(ItemBrandModel model:list){
			if(!model.getIsParent()){
				EasyUITree2 tree=new EasyUITree2();
				tree.setName(model.getName());
				tree.setId(model.getId());
				tree.set_parentId(model.getParentId());
				treeList.add(tree);

			}else{
				EasyUITree tree=new EasyUITree();
				tree.setName(model.getName());
				tree.setId(model.getId());
				tree.setIconCls("icon-ok");
				treeList.add(tree);
			}
		}
		result.setRows(treeList);
		return result;
	}

	@Override
	public int updateDo(Long parentId,Long id, String name) {
		int result=0;
		List<ItemBrandModel> exsistBrandList = getListByName (parentId,name);
		if(exsistBrandList.size()>0){
			if(exsistBrandList.get(0).getId()!=id){
				result = -1;
			}
		}
		if(result!=-1){
			ItemBrandModel brand=new ItemBrandModel();
			brand.setId(id);
			brand.setName(name);
			mapper.updateByPrimaryKeySelective(brand);
		}
		return result;
	}
	
	public List<ItemBrandModel> getListByName (long parentId,String name){
		ItemBrandModelExample example=new ItemBrandModelExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andParentIdEqualTo(parentId);
		List<ItemBrandModel> exsistBrandList=mapper.selectByExample(example);
		return exsistBrandList;
	}
	@Override
	public int addModel(Long parentId, String name,boolean isParent) {
		int result=0;
		List<ItemBrandModel> list = getListByName (parentId,name);
		if(list.size()>0){
			result=-1;
		}
		if(result==0){
			ItemBrandModel model=new ItemBrandModel();
			model.setIsParent(isParent);
			model.setName(name);
			model.setParentId(parentId);
			mapper.insertSelective(model);
		}
		return result;
	}
	

}
