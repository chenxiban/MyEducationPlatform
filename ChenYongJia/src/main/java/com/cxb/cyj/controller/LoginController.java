package com.cxb.cyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.service.impl.ConsumerService;

/**
 * 
 * @Description: 登录控制器
 * @ClassName: UserController.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@RestController
public class LoginController {

	@Autowired
	private ConsumerService consumerService;

	/**
	 * http://localhost:3011/chenyongjia/ChenYongJia/oauth/token?username=user_1&password=123456
	 * 登录获取Token
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping("/oauth/token")
	public Object getToken(String username, String password) {
		return consumerService.getToken(username, password);
	}
	
	/**
	 * http://localhost:3011/chenyongjia/ChenYongJia/oauth/check_token?token=a18b696b-4943-483a-8e16-f80885b3c2df
	 * 验证token是否有效
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping("/oauth/check_token")
	public Object checkToken(String token) {
		System.out.println("用于验证的token为=======>"+token);
		return consumerService.checkToken(token);
	}
	
	/**
	 * http://localhost:3011/chenyongjia/ChenYongJia/oauth/check_token?refresh_token=token
	 * 注销token
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping("/oauth/check_token")
	public Object refreshToken(String token) {
		System.out.println("用于注销的token为=======>"+token);
		return consumerService.refreshToken(token);
	}

}
