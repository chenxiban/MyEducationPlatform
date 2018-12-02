package com.cxb.cyj;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.cxb.cyj.Application;

/**
 * 
 * @Description:
 * @ClassName: Application.java
 * @author ChenYongJia
 * @Date 2018年12月01日 晚上22：54
 * @Email chen87647213@163.com
 */
//@EnableHystrix  === ( @EnableCircuitBreaker )
//@EnableEurekaClient === ( @EnableDiscoveryClient )
//@SpringBootApplication
//@SpringCloudApplication //=== ( @SpringBootApplication + @EnableDiscoveryClient + @EnableCircuitBreaker)
@SpringCloudApplication // ===( @EnableEurekaClient + @EnableHystrix + @SpringBootApplication
						// )pom.xml必须引Eureka、Hystrix依赖
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
