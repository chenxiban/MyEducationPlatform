package com.cxb.wmx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.service.DispostService;

@RestController
@RequestMapping(value="/dispost")
public class DispostController {

	@Autowired
	private DispostService dispostService;
	
	/**
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/dispost/selectListDispostById?pid=1,2,3
	 * 给陈永佳组提供的数据,用pid查询课程讨论详情
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="/selectListDispostById")
	public Map<String, Object> selectListDispostById(@RequestBody List<Integer> pid){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", dispostService.selectListDispostById(pid).size());
		map.put("rows", dispostService.selectListDispostById(pid));
		return map;
		
	}
	
	/**
	 * @author 王梦霞
	 * 查询评论前二十的帖子
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/dispost/queryDisByTop?page=0&rows=1
	 * @return
	 */
	@RequestMapping(value="/queryDisByTop")
	public Map<String, Object> queryDisByTop(@RequestParam(value="page")Integer page,@RequestParam(value="rows")Integer rows) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", dispostService.queryPageTop(page,rows).size());
		map.put("rows", dispostService.queryPageTop(page,rows));
		return map;
	}
	
	/**
	 * @author 王梦霞
	 * 查询点赞前二十的帖子
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/dispost/selectDisPostListByTopD?page=0&rows=1
	 * @return
	 */
	@RequestMapping(value="/selectDisPostListByTopD")
	public Object selectDisPostListByTopD(@RequestParam(value="page")Integer page,@RequestParam(value="rows")Integer rows) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", dispostService.selectPostListByTopD(page,rows).size());
		map.put("rows", dispostService.selectPostListByTopD(page,rows));
		return map;
	}
	
	/**
	 * 查询踩赞前二十的帖子
	 * @author 王梦霞
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/dispost/selectDisPostListByTopC?page=0&rows=1
	 * @return
	 */
	@RequestMapping(value="/selectDisPostListByTopC")
	public Object selectDisPostListByTopC(@RequestParam(value="page")Integer page,@RequestParam(value="rows")Integer rows) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", dispostService.selectPostListByTopC(page,rows).size());
		map.put("rows", dispostService.selectPostListByTopC(page,rows));
		return map;
	}
}
