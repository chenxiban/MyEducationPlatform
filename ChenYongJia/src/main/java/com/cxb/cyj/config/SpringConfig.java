package com.cxb.cyj.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @Description:   
 * @ClassName:     SpringConfig.java
 * @author         Mashuai
 * @Date           2018年8月22日 下午9:37:42
 * @Email          1119616605@qq.com
 */
@Configuration
public class SpringConfig {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	

}
