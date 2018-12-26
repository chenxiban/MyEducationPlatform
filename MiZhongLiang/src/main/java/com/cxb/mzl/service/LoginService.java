package com.cxb.mzl.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午4:54:18
*类说明  登陆  获取用户 id 信息和 退出业务类
*/
@FeignClient("chenyongjia")
public interface LoginService {
	@RequestMapping("/ChenYongJia/user/getUserIdByToken") 
	public Object getUserIdByToken(String token);
	@RequestMapping(value="/ChenYongJia/oauth/refresh_Token",method=RequestMethod.POST) 
	public boolean refreshToken(@RequestParam(value="token") String token); 
	

}
