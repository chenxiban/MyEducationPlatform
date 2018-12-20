package com.cxb;  
     
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringCloudApplication // ===( @EnableEurekaClient + @EnableHystrix + @SpringBootApplication
// )pom.xml必须引Eureka、Hystrix依赖
@EnableFeignClients
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
