package com.cxb.cyj;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
