package com.yst.service;

import com.yst.pojo.SysUser;

public interface UserService {
	
	SysUser loginDo(String username,String pwd);
	
	SysUser selectByPrimaryKey(int id);
	
	int updatePassword(String newPassword,Integer id);

}
