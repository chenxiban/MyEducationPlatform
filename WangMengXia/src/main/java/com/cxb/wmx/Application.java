package com.cxb.wmx;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringCloudApplication
//@EnableAuthorizationServer
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		
	}

}
