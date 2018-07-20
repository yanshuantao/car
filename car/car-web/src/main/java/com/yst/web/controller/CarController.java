package com.yst.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yst.pojo.Item;
import com.yst.pojo.ItemExample;
import com.yst.pojo.ItemExample.Criteria;
import com.yst.service.ItemService;

@Controller
public class CarController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/car-list.action")
	public ModelAndView list(){
		ModelAndView model = new ModelAndView();
		ItemExample example=new ItemExample();
		Criteria criteria = example.createCriteria();
		List<Item> carList = itemService.getItemListByexample(example);
		model.addObject("carList", carList);
		model.setViewName("index");
		return model;

	}
	

}
