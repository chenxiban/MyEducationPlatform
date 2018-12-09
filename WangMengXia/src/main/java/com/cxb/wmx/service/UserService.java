package com.cxb.wmx.service;

import com.cxb.wmx.entity.Users;

public interface UserService {

	/**
	 * 查询用户名称
	 * @param userName
	 * @return
	 * 王梦霞
	 */
	public Users findByUserName(String userName);
	
	/**
	 * 管理员登录
	 * @param userName
	 * @param userPwd
	 * @return
	 * 王梦霞
	 */
	public boolean findByUserNameAndUserPwd(String userName,String userPwd);
}
