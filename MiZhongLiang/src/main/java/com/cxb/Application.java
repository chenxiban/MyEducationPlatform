package com.cxb;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

   
/**
*@author作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月22日下午4:34:07
*类说明
*/
@SpringCloudApplication 
@EnableFeignClients
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
