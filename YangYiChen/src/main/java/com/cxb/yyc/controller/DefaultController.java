package com.cxb.yyc.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @Description:   默认控制器
 * @ClassName:     DefaultController.java
 * @author         yyc
 * @Date           2018年12月04日 下午20:40:56
 * @Email          yangyichenshuai@163.com
 */
@Controller
public class DefaultController {

	/**
	 * http://localhost:3011/yangyichen/YangYiChen/main.html
	 * @return
	 */
	@GetMapping("/main")
	public String main() {//管理页面
		return "main";
	}
	
	@GetMapping("/preview")
	public String preview() {//查看试题
		return "preview";
	}
	
	@GetMapping("/choicequestion")
	public String choicequestion() {//选择题
		return "choicequestion";
	}

	@GetMapping("/tfng")
	public String tfng() {//判断题
		return "tfng";
	}
	
	@GetMapping("/gap")
	public String gap() {//填空题
		return "gap";
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
