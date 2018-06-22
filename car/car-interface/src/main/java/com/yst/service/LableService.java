package com.yst.service;

import com.yst.common.pojo.EasyUIDataGridResult;
import com.yst.common.pojo.JsonResult;
import com.yst.pojo.Label;

public interface LableService{
	
	EasyUIDataGridResult getLabelList(int page,int rows);
	
	JsonResult addDo(Label lable);
	
	JsonResult deleteByIds(String ids);
	
	/*@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//取查询结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		//返回结果
		return result;
	}*/
}
