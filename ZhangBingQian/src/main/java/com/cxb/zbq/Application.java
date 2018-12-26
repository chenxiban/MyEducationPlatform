package com.cxb.zbq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * nihaoya
 * @Description:       
 * @ClassName:     Application.java
 * @author         Mashuai  
 * @Date           2018年8月22日 下午9:37:22
 * @Email          1119616605@qq.com
 */
@EnableFeignClients
@SpringCloudApplication //===( @EnableEurekaClient + @EnableHystrix + @SpringBootApplication )pom.xml必须引Eureka、Hystrix依赖
//@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages="com.cxb.zbq.entity")
@EnableJpaRepositories(basePackages="com.cxb.zbq.dao")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
