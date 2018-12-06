package com.cxb.cyj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @Description:   
 * @ClassName:     ConsumerService.java
 * @author         ChenYongJia
 * @Date           2018年12月06日 下午9:38:05
 * @Email          867647213@qq.com
 */
@Service
public class ConsumerService {
	
	@Autowired 
	private RestTemplate restTemplate;
	
	/**
	 * 登录获取token
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/oauth/token")
	public Object getToken(String username,String password) {
		return restTemplate.getForObject("http://chenyongjia-oauth/oauth/token?grant_type=password&username="+username+"&password="+password+"&client_id=client_1&client_secret=123456&scope=all", Object.class);
	}
	
	/**
	 * 验证token有效性
	 * @param token
	 * @return
	 */
	@RequestMapping("/oauth/check_token")
	public Object checkToken(String token) {
		return restTemplate.getForObject("http://chenyongjia-oauth/oauth/check_token?token="+token, Object.class);
	}
	
	/**
	 * 刷新token,即退出注销
	 * @param token
	 * @return
	 */
	@RequestMapping("/oauth/token")
	public Object refreshToken(String token) {
		return restTemplate.getForObject("http://chenyongjia-oauth/oauth/token?grant_type=refresh_token&refresh_token="+token+"&client_id=client_1&client_secret=123456", Object.class);
	}
			
}
