package com.cxb.mzl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.mzl.entity.User;
import com.cxb.mzl.service.UserService;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午5:58:18
*类说明
*/
@RestController
@RequestMapping(value = "/user", name = "获取用户信息")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/user/getUserInfo
	 * */
	@RequestMapping(value="/getUserInfo",method=RequestMethod.GET)
	public List <User> getUserInfo(){
		return userService.getUserInfo();
		
	}

}
