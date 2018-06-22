package com.yst.service;

import com.yst.pojo.SysUser;

public interface UserService {
	
	int loginDo(String username,String pwd);
	
	SysUser selectByPrimaryKey(int id);
	

}
