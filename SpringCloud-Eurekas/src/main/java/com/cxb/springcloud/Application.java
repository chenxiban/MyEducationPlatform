package com.cxb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.cxb.springcloud.Application;

/**
 * 
 * @Description:
 * @ClassName: Application.java
 * @author ChenYongJia
 * @Date 2018年12月01日 晚上22：54
 * @Email chen87647213@163.com 
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
