package com.yst.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yst.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/item/start.action")
	@ResponseBody
	public ModelAndView start(){
		ModelAndView modle=new ModelAndView();
		modle.setViewName("item-list");
		return modle;
	}
	
	@RequestMapping("/item/list.action")
	@ResponseBody
	public ModelAndView list(){
		ModelAndView mv=new ModelAndView();
		return mv;
	}
	
	@RequestMapping("/item/add.action")
	@ResponseBody
	public ModelAndView add(){
		ModelAndView modle=new ModelAndView();
		modle.setViewName("item-add");
		return modle;
	}

}
