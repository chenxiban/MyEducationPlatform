package com.cxb.wmx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Dispost;
import com.cxb.wmx.service.DisbarService;
import com.cxb.wmx.service.ThemeDetailsService;

@RestController
@RequestMapping(value="/disbar")
public class DisbarController {

	@Autowired
	private DisbarService disbarService;
	
	@Autowired
	private ThemeDetailsService tdSer;
	
	
	
	/**
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/disbar/selectAll
	 * http://localhost:3031/WangMengXia-One/disbar/selectAll
	 * @author 
	 * @return
	 */
	@RequestMapping(value="/selectAll")
	public Object selectAll() {
		System.out.println(".........===>"+disbarService.selectAll());
		return disbarService.selectAll();
	}
	
	//http://localhost:3031/WangMengXia-One/disbar/addPost?userId=1&dispostchaId=1&dispostName=wa&dispostTitle=as&dispostCount=wew&dispostFightouts=10&dispostReport=1&dispostCreatetime=2012-01-01&dispostUpdatetime=2012-01-01
	@RequestMapping(value="/addPost")
	public Object addPost(Dispost post) {
		return tdSer.addPost(post);
	}
}
