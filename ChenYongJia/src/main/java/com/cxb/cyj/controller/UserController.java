package com.cxb.cyj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @Description:   
 * @ClassName:     UserController.java
 * @author         Mashuai
 * @Date           2018年8月22日 下午9:36:56
 * @Email          1119616605@qq.com
 */
@RestController
public class UserController {
	
	@Value("${server.port}")
	private String serverPort;

	/**
	 * http://localhost:8002/getFuture
	 * @return
	 */
	@RequestMapping("/getFuture")
	public List<String> getFuture() {
		List<String> list = new ArrayList<>();
		list.add("不积跬步，无以至千里；");
		list.add("不积小流，无以成江海。");
		list.add("出自端口号:"+serverPort);
		return list;
	}

}
