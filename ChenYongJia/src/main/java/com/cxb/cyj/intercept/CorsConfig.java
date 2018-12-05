package com.cxb.cyj.intercept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 允许任何域名使用 允许任何头 允许任何方法（post、get等）
 * 
 * @Description:允许任何域名使用 允许任何头 允许任何方法（post、get等）
 * @ClassName: CorsConfig.java
 * @author ChenYongJia
 * @Date 2018年12月02日 晚上22：54
 * @Email chen87647213@163.com
 */
@Configuration
public class CorsConfig {
	
	// 构建配置
	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*"); // 1
		corsConfiguration.addAllowedHeader("*"); // 2
		corsConfiguration.addAllowedMethod("*"); // 3
		return corsConfiguration;
	}

	@Bean
	// 歌珥过滤器
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig()); // 4
		return new CorsFilter(source);
	}

}
