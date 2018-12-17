package com.cxb; 
  
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;


@SpringCloudApplication
//@EnableFeignClients
public class Application { 
    public static void main(String[] args) { 
        SpringApplication.run(Application.class,args);// 程序启动入口 	启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
    }
}