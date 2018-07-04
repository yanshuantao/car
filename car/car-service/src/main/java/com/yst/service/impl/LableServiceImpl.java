package com.yst.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jboss.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yst.common.pojo.EasyUIDataGridResult;
import com.yst.common.pojo.JsonResult;
import com.yst.mapper.LabelMapper;
import com.yst.pojo.Label;
import com.yst.pojo.LabelExample;
import com.yst.pojo.LabelExample.Criteria;
import com.yst.service.LableService;

@Service
public class LableServiceImpl implements LableService{

	@Autowired
	private LabelMapper lableMapper;
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
			LabelExample example = new LabelExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(list);
			lableMapper.deleteByExample(example);
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

}
