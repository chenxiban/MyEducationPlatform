package com.cxb.mzl.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cxb.mzl.entity.User;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午5:51:32
*类说明 获取用户信息业务类  
*注：无Users实体类
*/
@FeignClient("chenyongjia") 
public interface UserService {
	@RequestMapping(value="/ChenYongJia/user/getUserInfo",method=RequestMethod.GET)
	public List <User> getUserInfo();

}
