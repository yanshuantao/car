package com.yst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yst.common.util.Md5Util;
import com.yst.mapper.SysUserMapper;
import com.yst.pojo.SysUser;
import com.yst.pojo.SysUserExample;
import com.yst.pojo.SysUserExample.Criteria;
import com.yst.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	private SysUserMapper userMapper;
	@Override
	public SysUser selectByPrimaryKey(int id) {
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public SysUser loginDo(String username, String pwd) {
		SysUserExample example=new SysUserExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andUnameEqualTo(username);
		criteria.andPwdEqualTo(Md5Util.encode(pwd));
		List<SysUser> list = userMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
