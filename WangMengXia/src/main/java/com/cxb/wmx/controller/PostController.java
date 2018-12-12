package com.cxb.wmx.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Bar;
import com.cxb.wmx.entity.Post;
import com.cxb.wmx.entitysearch.BarSearch;
import com.cxb.wmx.entitysearch.PostSearch;
import com.cxb.wmx.service.PostService;

@RestController
@RequestMapping(value="/post")
public class PostController {

	@Autowired
	private PostService postService;
	private Date date = new Date();
	@SuppressWarnings("unused")
	private Timestamp timestamp = new Timestamp(date.getTime());
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/queryPost
	 * 动态查询贴吧分类(分页)
	 * @author 王梦霞
	 * @param postSearch
	 * @return
	 */
	@RequestMapping(value="/queryPost")
	public Object queryPost(PostSearch postSearch) {
		Pageable pageable = PageRequest.of(postSearch.getPage() - 1, postSearch.getRows(), Sort.Direction.ASC,
				"postId");
		Page<Post> page = postService.sreachByPost(postSearch, pageable);
		System.out.println("page======>" + page);
		Long total = page.getTotalElements();
		List<Post> list = page.getContent();
		System.out.println("list======>" + list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		System.out.println("total 总数为===>" + map.get("total"));
		System.out.println("rows 数据为===>" + map.get("rows"));
		return map;
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/deletePostById
	 * 删除帖子
	 * @author 王梦霞
	 * @param postId
	 * @return
	 */
	@RequestMapping(value="/deletePostById")
	public Object deletePostById(Integer postId) {
		return postService.deletePostById(postId);
	}
}
