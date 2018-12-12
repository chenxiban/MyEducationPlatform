package com.cxb.cyj.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @Description:   
 * @ClassName:     SpringConfig.java 
 * @author         Chenyongjia
 * @Date           2018年12月06日 下午16:20:42
 * @Email          867647213@qq.com
 */
@Configuration
public class SpringConfig {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	

}
