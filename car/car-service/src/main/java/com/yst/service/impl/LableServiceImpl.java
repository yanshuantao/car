package com.yst.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jboss.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yst.common.pojo.EasyUIDataGridResult;
import com.yst.common.pojo.JsonResult;
import com.yst.mapper.ItemMapper;
import com.yst.mapper.LabelMapper;
import com.yst.pojo.Item;
import com.yst.pojo.ItemExample;
import com.yst.pojo.Label;
import com.yst.pojo.LabelExample;
import com.yst.pojo.LabelExample.Criteria;
import com.yst.service.LableService;

@Service
public class LableServiceImpl implements LableService{

	@Autowired
	private LabelMapper lableMapper;
	@Autowired
	private ItemMapper itemMapper;
	@Override
	public EasyUIDataGridResult getLabelList(int page, int rows) {
		//设置分页信息
		if(page!=0&&rows!=0){
			PageHelper.startPage(page, rows);
		}
		//执行查询
		LabelExample example = new LabelExample();
		List<Label> list = lableMapper.selectByExample(example);
		//取查询结果
		PageInfo<Label> pageInfo = new PageInfo<Label>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		//返回结果
		return result;
	}
	@Override
	public JsonResult addDo(Label lable) {
		JsonResult jsonResult=new JsonResult();
		LabelExample example = new LabelExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(lable.getName());
		int count = lableMapper.countByExample(example);
		if(count>0){
			jsonResult.setCode(0001);
			jsonResult.setResultStr("标签名称已存在！");
			return jsonResult;
		}
		try {
			lableMapper.insert(lable);
		} catch (Exception e) {
			jsonResult.setCode(0002);
			jsonResult.setResultStr("标签添加失败！");
		}
		return jsonResult;
	}
	@Override
	public JsonResult deleteByIds(String ids) {
		JsonResult result = new JsonResult();
		if(StringUtils.isNotEmpty(ids)){
			String arry[]=ids.split(",");
			List list=Arrays.asList(arry);
			//删除lable表
			LabelExample example = new LabelExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(list);
			lableMapper.deleteByExample(example);
			//更新item表
			//拼装查询like条件
			ItemExample itemExample = new ItemExample();
			com.yst.pojo.ItemExample.Criteria criteria2 = itemExample.createCriteria();
			for(Object idStr:list){
				criteria2.andLabelsLike("%"+idStr.toString()+"%");
				itemExample.or(criteria2);
				
				
			}
			//查询疑似商品
			List<Item> itemList = itemMapper.selectByExample(itemExample);
			
			for(Item item:itemList){
				//获取疑似商品的lable集合
				String itemIdArray[] = item.getLabels().split(",");
				String itemIdArray2[]=itemIdArray;
				int len=itemIdArray.length;
				int j=0;
				for(int i=0;i<len;i++){
					for(Object idStr:list){
						if(idStr.equals(itemIdArray[i])){
							itemIdArray2 = ArrayUtils.remove(itemIdArray2, i-j);
							j++;
						}
					}
				}
				String newLabels="";
				if(itemIdArray2.length>0){
					newLabels = ArrayUtils.toString(itemIdArray2).substring(1, ArrayUtils.toString(itemIdArray2).length()-1);
				}
				
				//更新记录，将item的labels字段更新为buffer
				item.setLabels(newLabels);
				itemMapper.updateByPrimaryKey(item);
				
			}
		}
		return result;
	}
	@Override
	public String getNameStrByIdStr(String ids) {
		StringBuffer buffer=new StringBuffer();
		if(StringUtils.isNoneEmpty(ids)){
			String idArray[]=ids.split(",");
			List<Label> list=lableMapper.getListByIdStr(idArray);
			for(int i=0;i<list.size()-1;i++){
				Label label =list.get(i);
				buffer.append(label.getName()+",");
			}
			buffer.append(list.get(list.size()-1).getName());
		}
		return buffer.toString();
	}
	public static void main(String[] args) {
		String array[]={"1","2","3","4","5","6"};
		String str=ArrayUtils.toString(array);
		System.out.println(str);
		String newLabels = ArrayUtils.toString(array).substring(1, ArrayUtils.toString(array).length()-1);
		System.out.println(newLabels);
		String array2[]=array;
		int j=0;
		for(int i=0;i<array.length;i++){
			if("3".equals(array[i])||"4".equals(array[i])){
				array=ArrayUtils.remove(array, i-j);
				j++;
			}
		}
		for(String str2:array){
			System.out.println(str2);
		}
	}

}
