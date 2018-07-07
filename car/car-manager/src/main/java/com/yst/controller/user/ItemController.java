package com.yst.controller.user;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yst.common.pojo.EasyUIDataGridResult;
import com.yst.common.pojo.JsonResult;
import com.yst.model.ItemModel;
import com.yst.model.ItemSpecificationModel;
import com.yst.pojo.Item;
import com.yst.pojo.ItemDesc;
import com.yst.pojo.ItemSpecification;
import com.yst.service.ItemService;
import com.yst.service.ItemSpecService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemSpecService itemSpecService;
	
	@RequestMapping("/item/start.action")
	@ResponseBody
	public ModelAndView start(){
		ModelAndView modle=new ModelAndView();
		modle.setViewName("item-list");
		return modle;
	}
	
	@RequestMapping("/item/list.action")
	@ResponseBody
	public EasyUIDataGridResult list(@RequestParam (value="page", defaultValue="0") Integer page,
			@RequestParam (value="rows", defaultValue="0")Integer rows){
		return itemService.getItemList(page, rows);
	}
	
	@RequestMapping("/item/add.action")
	@ResponseBody
	public ModelAndView add(){
		ModelAndView modle=new ModelAndView();
		modle.setViewName("item-add");
		return modle;
	}
	@RequestMapping("/item/addDo.action")
	@ResponseBody
	public JsonResult addDo(ItemModel model){
		JsonResult result = new JsonResult();

		Item item=model.getItem();
		ItemSpecificationModel specModel=model.getSpecModel();
		ItemDesc desc=model.getDesc();
	    List<ItemSpecification> specList = convertSpecModel2SpecList(specModel);
	    try {
	    	itemService.addItem(item,specList, desc);
		} catch (Exception e) {
			result.setCode(0001);
			result.setResultStr("添加失败！");
		}
		
		return result;
	}
	@RequestMapping(value="/item/specDetail/{itemId}.action",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView specDetail(@PathVariable("itemId") Integer itemId){
		ModelAndView modle=new ModelAndView();
		List<ItemSpecification> specList = itemSpecService.getSpecListByItemId(itemId);
		ItemDesc itemDesc = itemService.getDescByItemId(itemId);
		modle.addObject("specList",specList);
		modle.addObject("itemDesc",itemDesc);
		modle.setViewName("item-specDetail");
		return modle;
	}
	@RequestMapping(value="/item/enable.action",method = RequestMethod.POST)
	@ResponseBody
	public JsonResult enable(String ids){
		JsonResult result = new JsonResult();
		try {
			itemService.enable(ids);
		} catch (Exception e) {
			result.setCode(0001);
		}
		return result;
	}
	/**
	 * 禁用
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/item/disable.action",method = RequestMethod.POST)
	@ResponseBody
	public JsonResult disable(String ids){
		JsonResult result = new JsonResult();
		try {
			itemService.disable(ids);
		} catch (Exception e) {
			result.setCode(0001);
		}
		return result;
	}


	public List<ItemSpecification> convertSpecModel2SpecList(ItemSpecificationModel specModel){
		List<ItemSpecification> list = new ArrayList<ItemSpecification>();
		String specNameStr = specModel.getConfigurationName();
		String fixPriceStr = specModel.getFixPriceStr();
		String nowPriceStr = specModel.getNowPriceStr();
		String displacementStr = specModel.getDisplacementStr();
		String energyStr = specModel.getEnergyStr();
		String seatNumberStr = specModel.getSeatNumberStr();
		String stockStr = specModel.getStockStr();
		String colorStr=specModel.getColor();
		String oilWearStr=specModel.getOilWear();
		
		String specNameArray[]=null;
		String fixPriceArray[]=null;
		String nowPriceArray[]=null;
		String displacementArray[]=null;
		String energyArray[]=null;
		String seatNumberArray[]=null;
		String stockArray[]=null;
		String colorArray[]=null;
		String oilWearArray[]=null;
		
		if(StringUtils.isNotEmpty(specNameStr)){
			specNameArray = specNameStr.split(",");
		}
		if(StringUtils.isNotEmpty(fixPriceStr)){
			fixPriceArray = fixPriceStr.split(",");
		}
		if(StringUtils.isNotEmpty(nowPriceStr)){
			nowPriceArray = nowPriceStr.split(",");
		}
		if(StringUtils.isNotEmpty(displacementStr)){
			displacementArray = displacementStr.split(",");
		}
		if(StringUtils.isNotEmpty(energyStr)){
			energyArray = energyStr.split(",");
		}
		if(StringUtils.isNotEmpty(seatNumberStr)){
			seatNumberArray = seatNumberStr.split(",");
		}
		if(StringUtils.isNotEmpty(stockStr)){
			stockArray = stockStr.split(",");
		}
		if(StringUtils.isNotEmpty(oilWearStr)){
			oilWearArray = oilWearStr.split(",");
		}
		if(StringUtils.isNotEmpty(colorStr)){
			colorArray = colorStr.split(",");
		}
		for(int i=0;i<specNameArray.length;i++){
			ItemSpecification spec=new ItemSpecification();
			String specName = specNameArray[i];
			spec.setConfigurationName(specName);
			if(fixPriceArray!=null){
				if(StringUtils.isNotEmpty(fixPriceArray[i])){
					spec.setFixPrice(new BigDecimal(fixPriceArray[i]));
				}
			}
			if(nowPriceArray!=null){
				if(StringUtils.isNotEmpty(nowPriceArray[i])){
					spec.setNowPrice(new BigDecimal(nowPriceArray[i]));
				}
			}
			if(displacementArray!=null){
				if(StringUtils.isNotEmpty(displacementArray[i])){
					spec.setDisplacement(Double.valueOf(displacementArray[i]));
				}
			}
			if(energyArray!=null){
				if(StringUtils.isNotEmpty(energyArray[i])){
					spec.setEnergy(Integer.valueOf(energyArray[i]));
				}
			}
			if(seatNumberArray!=null){
				if(StringUtils.isNotEmpty(seatNumberArray[i])){
					spec.setSeatNumber(Integer.valueOf(seatNumberArray[i]));
				}
			}
			if(stockArray!=null){
				if(StringUtils.isNotEmpty(stockArray[i])){
					spec.setStock(Integer.valueOf(stockArray[i]));
				}
			}
			if(colorArray!=null){
				if(StringUtils.isNotEmpty(colorArray[i])){
					spec.setColor(colorArray[i]);
				}
			}
			if(oilWearArray!=null){
				if(StringUtils.isNotEmpty(oilWearArray[i])){
					spec.setOilWear(oilWearArray[i]);
				}
			}
			list.add(spec);
		}
		
		return list;
	}

}
