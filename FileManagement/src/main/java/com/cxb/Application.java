package com.cxb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 
 * @Description: SpringCloud微服务启动类
 * @ClassName: Application.java
 * @author ChenYongJia
 * @Date 2018年12月01日 晚上22：54
 * @Email chen87647213@163.com
 */
@SpringCloudApplication // ===( @EnableEurekaClient + @EnableHystrix + @SpringBootApplication
// )pom.xml必须引Eureka、Hystrix依赖
@EnableFeignClients
@MapperScan("com.cxb.cyj.dao")// 指定扫描的mapper接口所在的包
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
