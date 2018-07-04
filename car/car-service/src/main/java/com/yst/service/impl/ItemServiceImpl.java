package com.yst.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yst.common.pojo.EasyUIDataGridResult;
import com.yst.mapper.ItemMapper;
import com.yst.mapper.ItemSpecificationMapper;
import com.yst.model.ItemResultModel;
import com.yst.pojo.Item;
import com.yst.pojo.ItemBrandModel;
import com.yst.pojo.ItemDesc;
import com.yst.pojo.ItemExample;
import com.yst.pojo.ItemSpecification;
import com.yst.pojo.Label;
import com.yst.service.ItemBrandModelService;
import com.yst.service.ItemService;
import com.yst.service.LableService;
import com.yst.mapper.ItemDescMapper;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemSpecificationMapper itemSpecificationMapper;
	@Autowired
	private ItemDescMapper ItemDescMapper;
	
	@Autowired
	private ItemBrandModelService itemBrandModelService;
	@Autowired
	private LableService labelService;
	
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//设置分页信息
		if(page!=0&&rows!=0){
			PageHelper.startPage(page, rows);
		}
		//执行查询
		ItemExample itemExample=new ItemExample();
		List<Item> itemList = itemMapper.selectByExample(itemExample);
		List<ItemResultModel> resultList=new ArrayList<ItemResultModel>();
		for(Item item:itemList){
			//查询品牌-型号
			ItemResultModel itemResultModel = new ItemResultModel();
			String brandName=itemBrandModelService.getBrandName(item.getBrandModleId());
			ItemBrandModel itemBrandModel=itemBrandModelService.selectByPrimaryKey(item.getBrandModleId());
			itemResultModel.setItem(item);
			itemResultModel.setBrandName(brandName);
			if(itemBrandModel!=null){
				itemResultModel.setModelName(itemBrandModel.getName());
			}
			//查询标签
			String labelName=labelService.getNameStrByIdStr(item.getLabels());
			itemResultModel.setLabelName(labelName);
			resultList.add(itemResultModel);
		}
		
		//取查询结果
		PageInfo<ItemResultModel> pageInfo = new PageInfo<ItemResultModel>(resultList);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(resultList);
		result.setTotal(pageInfo.getTotal());

		return result;
	}

	@Override
	public void addItem(Item item,List<ItemSpecification> specList, ItemDesc desc) {
		//首先插入item表，插入之前需要将默认配置插入item表，这里取第一个规格的参数，需要返回item_id
		if(specList.size()>0){
			ItemSpecification spec = specList.get(0);
			item.setImgStr(spec.getImgStr());
			
			BigDecimal min=spec.getNowPrice();
			BigDecimal max=spec.getNowPrice();
			for(ItemSpecification specification:specList){
				if(min.compareTo(specification.getNowPrice())!=-1){
					min=specification.getNowPrice();
				}
				if(max.compareTo(specification.getNowPrice())!=1){
					max = specification.getNowPrice();
				}
				
			}
			item.setPriceLow(min);
			item.setPriceHigh(max);
		}
		itemMapper.insertSelective(item);
		//循环插入item_specification表,取item_id
		int itemId=item.getId();
		for(ItemSpecification specification:specList){
			specification.setItemId(itemId);
			itemSpecificationMapper.insertSelective(specification);
		}
		//插入item_desc表
		desc.setItemId(itemId);
		ItemDescMapper.insertSelective(desc);
	}

}
