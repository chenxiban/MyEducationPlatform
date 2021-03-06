package com.cxb.mzl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月19日下午5:44:47
*类说明  允许任何域名使用 允许任何头 允许任何方法（post、get等）
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
			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			final CorsConfiguration config = new CorsConfiguration();
			config.setAllowCredentials(true);
			config.addAllowedOrigin("*");
			config.addAllowedHeader("*");
			config.addAllowedMethod("*");
			config.setMaxAge(18000L);
			config.addAllowedMethod("OPTIONS");// 允许提交请求的方法，*表示全部允许
			config.addAllowedMethod("GET");// 允许Get的请求方法
			config.addAllowedMethod("PUT");
			config.addAllowedMethod("POST");
			config.addAllowedMethod("DELETE");
			source.registerCorsConfiguration("/**", config);
			return new CorsFilter(source);
		}


}
