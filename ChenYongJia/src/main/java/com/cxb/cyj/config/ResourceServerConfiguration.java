package com.cxb.cyj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	// @EnableResourceServer 开启资源服务中心,一般配置在网关.
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// 对 api/order 请求进行拦截 验证 accessToken
		http.authorizeRequests().antMatchers("/api/order/**").authenticated();
	}
	// public
	// 拦截资源 网关里面做 开放接口和内部接口一定要独立出来可以封转该业务逻辑相同

}
