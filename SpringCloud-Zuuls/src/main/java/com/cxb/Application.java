package com.cxb;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 启动类
 * @Description:
 * @ClassName: Application.java
 * @author Chenyongjia
 * @Date 2018年12月03日 晚上20:29:06
 * @Email 867647213@qq.com
 */
@EnableZuulProxy
@SpringCloudApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
