package com.yst.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yst.common.pojo.EasyUIDataGridResult;
import com.yst.common.pojo.EasyUITreeNode;
import com.yst.common.pojo.JsonResult;
import com.yst.service.ItemBrandModelService;

@Controller
public class ItemBrandModelController {
	
	@Autowired
	private ItemBrandModelService itemBrandModelService;
	
	@RequestMapping("/item/brandModel/start.action")
	@ResponseBody
	public ModelAndView start(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("brand-list");
		return mv;
	}
	
	@RequestMapping("/item/brandModel/list.action")
	@ResponseBody
	public List<EasyUITreeNode> list(@RequestParam(name="id", defaultValue="0")Long parentId){
		List<EasyUITreeNode> list = itemBrandModelService.getItemCatList(parentId);
		return list;
	}
	@RequestMapping("/item/brandModel/getList.action")
	@ResponseBody
	public EasyUIDataGridResult getList(){
		EasyUIDataGridResult result = itemBrandModelService.getAllBrand();
		return result;
	}
	@RequestMapping(value="/item/brandModel/updateDo.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult updateDo(Long id,Long parentId,String name){
		JsonResult result=new JsonResult();
		try {
			int code = itemBrandModelService.updateDo(parentId,id,name);
			if(code==-1){
				result.setCode(0002);
				result.setResultStr("数据重复，请更改名称");
			}
		} catch (Exception e) {
			result.setCode(0001);
			result.setResultStr("更新失败！");
		}
		return result;
	}
	@RequestMapping("/item/brandModel/add.action")
	@ResponseBody
	public ModelAndView add(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("brand-add");
		return mv;
	}
	@RequestMapping(value="/item/brandModel/addDo.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult addDo(Long parentId,String name){
		JsonResult result=new JsonResult();
		try {
			int code = itemBrandModelService.addModel(parentId,name,false);
			if(code==-1){
				result.setCode(0002);
				result.setResultStr("型号已存在！");
			}
		} catch (Exception e) {
			result.setCode(0001);
			result.setResultStr("添加失败！");
		}
		return result;
	}

}
