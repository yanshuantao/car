package com.yst.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yst.common.pojo.EasyUIDataGridResult;
import com.yst.common.pojo.JsonResult;
import com.yst.pojo.Label;
import com.yst.service.LableService;

@Controller
public class LableController {

	@Autowired
	private LableService lableService;
	
	@RequestMapping("/lable/start.action")
	@ResponseBody
	public ModelAndView start(){
		ModelAndView modle=new ModelAndView();
		modle.setViewName("lable-list");
		return modle;
	}
	
	@RequestMapping("/lable/list.action")
	@ResponseBody
	public EasyUIDataGridResult getLableList(Integer page, Integer rows){
		EasyUIDataGridResult result = lableService.getLabelList(page, rows);
		return result;
	}
	@RequestMapping("/lable/edit.action")
	public ModelAndView edit(){
		ModelAndView modle=new ModelAndView();
		modle.setViewName("lable-edit");
		return modle;
	}
	@RequestMapping("/lable/add.action")
	public ModelAndView add(){
		ModelAndView modle=new ModelAndView();
		modle.setViewName("lable-add");
		return modle;
	}
	@RequestMapping(value="/lable/addDo.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult addDo( Label lable){
		JsonResult result = lableService.addDo(lable);
		return result;
	}
	@RequestMapping(value="/lable/delete.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult delete( String ids){
		JsonResult result = lableService.deleteByIds(ids);
		return result;
	}
}
