package com.cxb.wmx;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
//@EnableAuthorizationServer
public class Application {

	public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		
	}

}
