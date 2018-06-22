package com.yst.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yst.common.pojo.EasyUITreeNode;
import com.yst.service.ItemBrandModelService;

@Controller
public class ItemBrandModelController {
	
	@Autowired
	private ItemBrandModelService itemBrandModelService;
	
	
	@RequestMapping("/item/brandModel/list.action")
	@ResponseBody
	public List<EasyUITreeNode> list(@RequestParam(name="id", defaultValue="0")Long parentId){
		List<EasyUITreeNode> list = itemBrandModelService.getItemCatList(parentId);
		return list;
	}
	

}
