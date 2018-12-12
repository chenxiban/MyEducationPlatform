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

import com.cxb.wmx.dao.PostComRpository;
import com.cxb.wmx.entity.Bar;
import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entitysearch.BarSearch;
import com.cxb.wmx.entitysearch.PostComSearch;
import com.cxb.wmx.service.PostComService;

@RestController
@RequestMapping(value="/postCom")
public class PostComController {

	@Autowired
	private PostComService postComService;
	private Date date = new Date();
	private Timestamp timestamp = new Timestamp(date.getTime());
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postCom/queryPostCom
	 * 动态查询贴吧分类(分页)
	 * @author 王梦霞
	 * @param barSearch
	 * @return
	 */
	@RequestMapping(value="/queryPostCom")
	public Object queryPostCom(PostComSearch postComSearch) {
		Pageable pageable = PageRequest.of(postComSearch.getPage() - 1, postComSearch.getRows(), Sort.Direction.ASC,
				"postcommitId");
		Page<Postcommit> page = postComService.sreachByPostCom(postComSearch, pageable);
		System.out.println("page======>" + page);
		Long total = page.getTotalElements();
		List<Postcommit> list = page.getContent();
		System.out.println("list======>" + list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		System.out.println("total 总数为===>" + map.get("total"));
		System.out.println("rows 数据为===>" + map.get("rows"));
		return map;
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postCom/deletePostCommitById
	 * 删除
	 * @author 王梦霞
	 * @param prId
	 * @return
	 */
	@RequestMapping(value="/deletePostCommitById")
	public Object deletePostCommitById(Integer postcommitId) {
		System.out.println("当前要删除的评论id为====>"+postcommitId);
		return postComService.deletePostCommitById(postcommitId);
	} 
}