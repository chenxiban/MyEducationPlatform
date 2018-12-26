package com.cxb.wmx.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Bar;
import com.cxb.wmx.entity.Result;
import com.cxb.wmx.entitysearch.BarSearch;
import com.cxb.wmx.service.BarService;
import com.cxb.wmx.util.IsEmptyUtils;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value="/bar")
public class BarController {

	@Autowired
	private BarService barService;
	private Date date = new Date();
	private Timestamp timestamp = new Timestamp(date.getTime());
	/**
	 * 查询所有贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/bar/selectAllBar
	 * http://localhost:3030/WangMengXia/bar/selectAllBar
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/selectAllBar",method=RequestMethod.GET)
	public Object selectAllBar() {
		return barService.selectAllBar();
	}
	
	
	/**
	 * 添加贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/bar/addBar?barCategory=c哈哈
	 * http://localhost:3030/WangMengXia/bar/addBar?barCategory=王哈哈
	 * @param bar
	 * @return
	 * @author 王梦霞
	 */
	@RequestMapping(value="/addBar",method=RequestMethod.PUT)
	public Object addBar(Bar bar) {
		Bar bar2 =barService.findByBarCategory(bar.getBarCategory());
		bar.setBarCreatetime(new Date());
		if (IsEmptyUtils.isEmpty(bar2)) {
			if (barService.addBar(bar)) {
				return new Result(true, "分类添加成功");
			} else {
				return new Result(false, "分类添加失败");
			}
		} else {
			return new Result(false, "该分类已经存在,不能重复添加");
		}
	}
	
	/**
	 * 修改贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/bar/updateBar
	 * http://localhost:3030/WangMengXia/bar/updateBar?barCategory=王哈&barId=11
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/updateBar",method=RequestMethod.POST)
	public Object updateBar(Bar bar) {
		Bar bar2 =barService.queryBarId(bar.getBarId());
		bar2.setBarCategory(bar.getBarCategory());
		if (barService.updateBar(bar2)) {
			return new Result(true, "修改成功");
		} else {
			return new Result(false, "修改失败");
		}
	}
	
	/**
	 * 删除贴吧分类
	 * http://localhost:3011/wangmengxia/WangMengXia/bar/addBar
	 * http://localhost:3030/WangMengXia/bar/deleteBar?bid=11
	 * @param bar
	 * @return
	 * 王梦霞
	 */
	@RequestMapping(value="/deleteBar",method=RequestMethod.DELETE)
	public Object deleteBar(Integer bid) {
		return barService.deleteBar(bid);
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/bar/deleteBarByIds
	 * @author 王梦霞
	 * @param barId
	 * @return
	 */
	@RequestMapping(value="/deleteBarByIds",method=RequestMethod.POST)
	public Object deleteBarByIds(String barId) {
		List<String> list = new ArrayList<String>();
		String[] ids = barId.split(",");
		for (String dids : ids) {
			list.add(dids);
		}
		if (barService.deleteBarByIds(list)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/bar/queryBar
	 * 动态查询贴吧分类(分页)
	 * @author 王梦霞
	 * @param barSearch
	 * @return
	 */
	@RequestMapping(value="/queryBar",method=RequestMethod.GET)
	public Object queryBar(BarSearch barSearch) {
		Pageable pageable = PageRequest.of(barSearch.getPage() - 1, barSearch.getRows(), Sort.Direction.ASC,
				"barId");
		Page<Bar> page = barService.sreachByBar(barSearch, pageable);
		System.out.println("page======>" + page);
		Long total = page.getTotalElements();
		List<Bar> list = page.getContent();
		System.out.println("list======>" + list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		System.out.println("total 总数为===>" + map.get("total"));
		System.out.println("rows 数据为===>" + map.get("rows"));
		return map;
	}

}
