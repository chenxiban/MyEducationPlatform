package com.cxb.wmx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Bar;
import com.cxb.wmx.service.BarService;

@RestController
@RequestMapping(value="/bar",name="贴吧分类")
public class BarController {

	@Autowired
	private BarService barService;
	
	/**
	 * 查询所有贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/bar/selectAllBar
	 * http://localhost:3030/WangMengXia/bar/selectAllBar
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/selectAllBar")
	public Object selectAllBar() {
		return barService.selectAllBar();
	}
	
	
	/**
	 * 添加贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/bar/addBar
	 * http://localhost:3030/WangMengXia/bar/addBar?barCategory=王哈哈
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/addBar")
	public Object addBar(Bar bar) {
		return barService.addBar(bar);
	}
	
	
	/**
	 * 修改贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/bar/addBar
	 * http://localhost:3030/WangMengXia/bar/updateBar?barCategory=王哈&barId=11
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/updateBar")
	public Object updateBar(Bar bar) {
		return barService.addBar(bar);
	}
	
	/**
	 * 删除贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/bar/addBar
	 * http://localhost:3030/WangMengXia/bar/deleteBar?bid=11
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/deleteBar")
	public Object deleteBar(Integer bid) {
		return barService.deleteBar(bid);
	}
}
