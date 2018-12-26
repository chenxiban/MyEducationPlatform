package com.cxb.mzl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月26日下午3:56:40
*类说明  默认控制器
*/

@Controller
public class DefaultController {
	/**
	 * http://localhost:3011/mizhongliang/MiZhongLiang/
	 * @return
	 */
	
	@GetMapping("/head")
	public String head() {
		return "head";
	}
	@GetMapping("/index")
	public String index() {
		return "index";}
	
	@GetMapping("/homePage")
	public String homePage() {
		return "homePage";
	}
	@GetMapping("/search")
	public String search() {
		return "search";
	}
	@GetMapping("/peoperCenter")
	public String peoperCenter() {
		return "peoperCenter";
	}

}
