package com.cxb.wmx.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.UserRrpository;
import com.cxb.wmx.entity.Users;
import com.cxb.wmx.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRrpository uDao;
	/**
	 * 查询用户名称
	 * @param userName
	 * @return
	 * 王梦霞
	 */
	@Override
	public Users findByUserName(String userName) {
		return uDao.findByUserName(userName);
	}

	/**
	 * 管理员登录
	 * @param userName
	 * @param userPwd
	 * @return
	 * 王梦霞
	 */
	@Override
	public boolean findByUserNameAndUserPwd(String userName, String userPwd) {
		try {
			uDao.findByUserNameAndUserPwd(userName, userPwd);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
