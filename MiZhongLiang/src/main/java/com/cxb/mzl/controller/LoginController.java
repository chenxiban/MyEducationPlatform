package com.cxb.mzl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.mzl.service.LoginService;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午5:12:03
*类说明 登陆控制器
*/
@RestController
@RequestMapping(value = "/login", name = "登陆模块")
public class LoginController {
	@Autowired
	private LoginService loginService;
	/**
	 * http://locahost:3011/mizhongliang/MiZhongLiang/login/getUserIdByToken
	 * */
	@RequestMapping(value = "/getUserIdByToken", name = "通过token换取用户信息", method = RequestMethod.GET)
	public Object getUserIdByToken(String token) {
		return loginService.getUserIdByToken(token);
	}
	/**
	 * 退出
	 * http://locahost:3011/mizhongliang/MiZhongLiang/login/oauth/refresh_Token
	 * */
	@RequestMapping(value = "/oauth/refresh_Token", method = RequestMethod.POST)
	public boolean refreshToken(@RequestParam(value="token") String token) {
		return loginService.refreshToken(token);
		
	}

}
