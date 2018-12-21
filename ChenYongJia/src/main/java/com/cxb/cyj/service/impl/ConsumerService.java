package com.cxb.cyj.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @Description:   调用oauth2.0的fegin类
 * @ClassName:     ConsumerServiceTwo.java
 * @author         ChenYongJia
 * @Date           2018年12月09日 下午9:38:05
 * @Email          867647213@qq.com
 */
@FeignClient("chenyongjia-oauth")
public interface ConsumerService {
	
	/**
	 * 登录获取token
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/oauth/token")
	public Object getToken(@RequestParam(value="grant_type")String grant_type,@RequestParam(value="username")String username,@RequestParam(value="password")String password,@RequestParam(value="client_id")String client_id,@RequestParam(value="client_secret")String client_secret,@RequestParam(value="scope")String scope);
	
	/**
	 * 验证token有效性
	 * @param token
	 * @return
	 */
	@RequestMapping("/oauth/check_token")
	public Object checkToken(@RequestParam(value="token") String token);
	
	
	/**
	 * 刷新token,即退出注销
	 * @param token
	 * @return
	 */
	@RequestMapping("/oauth/token")
	public Object refreshToken(@RequestParam(value="grant_type")String grant_type,@RequestParam(value="refresh_token")String refresh_token,@RequestParam(value="client_id")String client_id,@RequestParam(value="client_secret")String client_secret);
	
}
