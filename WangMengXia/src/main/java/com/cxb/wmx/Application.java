package com.cxb.wmx;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
//@EnableAuthorizationServer
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		
	}

}
