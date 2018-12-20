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
	
	/**
	 * 用户个帖子点赞
	 * http://localhost:3011/wangmengxia/WangMengXia/postlike/addPostlikeDz?postId=2&userId=2
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/addPostlikeDz")
	public Object addPostlikeDz(Integer postId,Integer userId) {
		return postLikeService.addPostlikeDz(postId,userId);
	}
	
	/**
	 * 用户个帖子踩赞
	 * http://localhost:3011/wangmengxia/WangMengXia/postlike/addPostlikeCz?postId=2&userId=22
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/addPostlikeCz")
	public Object addPostlikeCz(Integer postId,Integer userId) {
		return postLikeService.addPostlikeDz(postId,userId);
	}
	
	/**
	 * 用户给帖子取消点赞
	 * http://localhost:3011/wangmengxia/WangMengXia/postlike/deletePostlikeDz?postId=2&userId=22
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/deletePostlikeDz")
	public Object deletePostlikeDz(Integer postId,Integer userId) {
		return postLikeService.deletePostlikeDz(postId, userId);
	}
	
	/**
	 * 用户个帖子取消踩赞
	 * http://localhost:3011/wangmengxia/WangMengXia/postlike/deletePostlikeCz?postId=2&userId=22
	 * @author 王梦霞
	 * @returnupdatePostlikeCz
	 */
	@RequestMapping(value="/deletePostlikeCz")
	public Object deletePostlikeCz(Integer postId,Integer userId) {
		return postLikeService.deletePostlikeCz(postId, userId);
	}
	
	/**
	 * 用户给帖子点赞后进行踩赞的操作
	 * http://localhost:3011/wangmengxia/WangMengXia/postlike/updatePostlikeDz?postId=2&userId=22
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/updatePostlikeDz")
	public Object updatePostlikeDz(Integer postId,Integer userId) {
		return postLikeService.updatePostlikeDz(postId, userId);
	}
	
	/**
	 * 用户给帖子踩赞后进行点赞的操作
	 * http://localhost:3011/wangmengxia/WangMengXia/postlike/updatePostlikeCz?postId=2&userId=22
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/updatePostlikeCz")
	public Object updatePostlikeCz(Integer postId,Integer userId) {
		return postLikeService.updatePostlikeCz(postId, userId);
	}
}
