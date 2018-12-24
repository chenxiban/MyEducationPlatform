package com.cxb.wmx.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Dispost;
import com.cxb.wmx.service.ThemeDetailsService;

@RestController
@RequestMapping(value="/themedetails")
public class ThemeDetailsController {

	@Autowired
	private ThemeDetailsService tdSer;
	
	/**
	 * 作者:孙可欣
	 * 查询指定的帖子详情
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/themedetails/selectDispostById?dispostId=1
	 * @param dispostId
	 * @return
	 * http://localhost:3031/WangMengXia-One/themedetails/selectDispostById?dispostId=1
	 */
	@RequestMapping(value="/selectDispostById")
	public Object selectDispostById(Integer dispostId) {
		Dispost dispost=tdSer.selectDispostById(dispostId);
		return dispost;
	}
	
	/**
	 * http://localhost:3031/WangMengXia-One/themedetails/getAllPost
	 * @return
	 */
	@RequestMapping("/getAllPost")
	public Object getAllPost() {
		return tdSer.getAllPost();
	}
	
	/**
	 * @author sun
	 * 修改评论
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/themedetails/updateThemeByDispostId?dispostTitle=修改标题&dispostCount=修改&dispostId=1
	 * http://localhost:3031/WangMengXia-One/themedetails/updateThemeByDispostId?dispostTitle=修改标题&dispostCount=修改&dispostId=1
	 * @param discommitCount
	 * @param discommitId
	 * @return
	 */
	@RequestMapping(value="/updateThemeByDispostId")
	public Object updateThemeByDispostId(String dispostTitle,String dispostCount, int dispostId) {
		return tdSer.updateThemeByDispostId(dispostTitle,dispostCount, dispostId);
	}

}
