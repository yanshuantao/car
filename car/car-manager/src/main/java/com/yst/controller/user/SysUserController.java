package com.yst.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yst.common.pojo.JsonResult;
import com.yst.pojo.SysUser;
import com.yst.service.UserService;

/**
 * 注解详解
	我们所要获取的前端传递参数大概可以分为以下四类：
	requet uri 部分的注解：@PathVariable
	request header部分的注解：@RequestHeader, @CookieValue
	request body部分的注解：@RequestParam,  @RequestBody
	attribute 类型是注解： @SessionAttributes, @ModelAttribute
 * @author yanshuantao
 *
 */
@Controller
public class SysUserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/login.action")
	public ModelAndView login(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	@SuppressWarnings("unused")
	@RequestMapping(value="/loginDo.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult loginDo(@RequestParam("username")  String username,@RequestParam  String password,HttpSession session ){
		JsonResult result=new JsonResult();
		SysUser userInfo = userService.loginDo(username, password);
		userInfo.setPwd("");
		if(userInfo!=null){
			session.setAttribute("userInfo", userInfo);
		}else{
			result.setCode(0001);
			result.setResultStr("用户名密码错误");
		}
		return result;
	}
	@RequestMapping("/index.action")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public SysUser getItemById(@PathVariable int userId) {
		//根据商品id查询商品信息
		SysUser user = userService.selectByPrimaryKey(userId);
		
	
		return user;
	}


}
