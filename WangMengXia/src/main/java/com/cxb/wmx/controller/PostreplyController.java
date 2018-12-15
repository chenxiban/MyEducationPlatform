package com.cxb.wmx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Bar;
import com.cxb.wmx.entity.Postreply;
import com.cxb.wmx.entitysearch.BarSearch;
import com.cxb.wmx.entitysearch.PostreplySearch;
import com.cxb.wmx.service.PostreplyService;

@RestController
@RequestMapping(value="/postReply")
public class PostreplyController {

	@Autowired
	private PostreplyService postreplyService;
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postReply/queryPostreply
	 * 动态查询贴吧分类(分页)
	 * @author 王梦霞
	 * @param barSearch
	 * @return
	 */
	@RequestMapping(value="/queryPostreply",method=RequestMethod.GET)
	public Object queryPostreply(PostreplySearch postreplySearch) {
		Pageable pageable = PageRequest.of(postreplySearch.getPage() - 1, postreplySearch.getRows(), Sort.Direction.ASC,
				"postreplyId");
		Page<Postreply> page = postreplyService.sreachByPostreply(postreplySearch, pageable);
		System.out.println("page======>" + page);
		Long total = page.getTotalElements();
		List<Postreply> list = page.getContent();
		System.out.println("list======>" + list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		System.out.println("total 总数为===>" + map.get("total"));
		System.out.println("rows 数据为===>" + map.get("rows"));
		return map;
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postReply/deletePostRepById
	 * 删除
	 * @author 王梦霞
	 * @param prId
	 * @return
	 */
	@RequestMapping(value="/deletePostRepById",method=RequestMethod.POST)
	public Object deletePostRepById(Integer hfId) {
		if (postreplyService.deletePostreplyById(hfId)) {
			return true;
		} else {
			return false;
		}
	} 
}
