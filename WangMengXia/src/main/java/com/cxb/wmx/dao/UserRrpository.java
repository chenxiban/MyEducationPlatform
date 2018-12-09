package com.cxb.wmx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cxb.wmx.entity.Users;


public interface UserRrpository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users>{

	/**
	 * 查询用户的名称
	 * @param userName
	 * @return
	 * 王梦霞
	 */
	Users findByUserName(String userName);
	
	/**
	 * 贴吧管理员登录功能
	 * 王梦霞
	 * @param userName
	 * @param userPwd
	 * @return
	 */
    Users findByUserNameAndUserPwd(String userName, String userPwd);
}
