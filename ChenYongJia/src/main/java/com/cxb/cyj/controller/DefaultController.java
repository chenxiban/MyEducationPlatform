package com.cxb.cyj.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @Description:   默认控制器
 * @ClassName:     DefaultController.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Controller
public class DefaultController {

	/**
	 * http://localhost:3011/chenyongjia/ChenYongJia/
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/clazz")
	public String adminlogin() {
		return "clazz";
	}

	@GetMapping("/course")
	public String course() {
		return "course";
	}
	
	@GetMapping("/jdgl")
	public String jdgl() {
		return "jdgl";
	}
	@GetMapping("/mian")
	public String mian() {
		return "mian";
	}
	
	@GetMapping("/modules")
	public String modules() {
		return "modules";
	}
	
	@GetMapping("/organization")
	public String organization() {
		return "organization";
	}
	
	@GetMapping("/permission")
	public String permission() {
		return "permission";
	}
	
	@GetMapping("/post")
	public String post() {
		return "post";
	}
	
	@GetMapping("/yh")
	//public String yh(HttpServletResponse response) {
	public String yh(HttpServletResponse response) {
		//response.addHeader("x-frame-options","SAMEORIGIN");
		//response.setHeader("x-frame-options","SAMEORIGIN");
		return "yh";
	}

}
