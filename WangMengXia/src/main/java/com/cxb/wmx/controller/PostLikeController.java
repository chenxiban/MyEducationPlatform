package com.cxb.wmx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.service.PostLikeService;

@RestController
@RequestMapping(value="/postlike")
public class PostLikeController {

	@Autowired
	private PostLikeService postLikeService;
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postlike/getPostLikeByTopD
	 * http://localhost:3030/WangMengXia/postlike/getPostLikeByTopD
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/getPostLikeByTopD",method=RequestMethod.GET)
	public Object getPostLikeByTopD() {
		return postLikeService.selectPostListByTopD();
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postlike/getPostLikeByTopC
	 * http://localhost:3030/WangMengXia/postlike/getPostLikeByTopC
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/getPostLikeByTopC",method=RequestMethod.GET)
	public Object getPostLikeByTopC() {
		return postLikeService.selectPostListByTopC();
	}
}
