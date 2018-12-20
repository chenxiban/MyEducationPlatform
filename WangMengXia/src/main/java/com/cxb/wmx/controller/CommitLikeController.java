package com.cxb.wmx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.service.CommitLikeService;

/**
 * 评论点赞踩赞控制层
 * @author 王梦霞
 *
 */
@RestController
@RequestMapping(value="/comLike")
public class CommitLikeController {

	@Autowired
	private CommitLikeService commitLikeService;
	

	/**
	 * 用户个评论点赞
	 * http://localhost:3011/wangmengxia/WangMengXia/comLike/addPostComlikeDz?commitId=2&userId=2
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/addPostComlikeDz")
	public Object addPostComlikeDz(Integer commitId,Integer userId) {
		return commitLikeService.addPostComlikeDz(commitId,userId);
	}
	
	/**
	 * 用户个评论踩赞
	 * http://localhost:3011/wangmengxia/WangMengXia/comLike/addPostComlikeCz?commitId=2&userId=22
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/addPostComlikeCz")
	public Object addPostComlikeCz(Integer commitId,Integer userId) {
		return commitLikeService.addPostComlikeDz(commitId,userId);
	}
	
	/**
	 * 用户给评论取消点赞
	 * http://localhost:3011/wangmengxia/WangMengXia/comLike/deletePostComlikeDz?commitId=2&userId=2
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/deletePostComlikeDz")
	public Object deletePostComlikeDz(Integer commitId,Integer userId) {
		return commitLikeService.deletePostComlikeDz(commitId, userId);
	}
	
	/**
	 * 用户个评论取消踩赞
	 * http://localhost:3011/wangmengxia/WangMengXia/comLike/deletePostComlikeCz?commitId=2&userId=22
	 * @author 王梦霞
	 * @returnupdatePostlikeCz
	 */
	@RequestMapping(value="/deletePostComlikeCz")
	public Object deletePostComlikeCz(Integer commitId,Integer userId) {
		return commitLikeService.deletePostComlikeCz(commitId, userId);
	}
	
	/**
	 * 用户给评论点赞后进行踩赞的操作
	 * http://localhost:3011/wangmengxia/WangMengXia/comLike/updatePostComlikeDz?commitId=2&userId=22
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/updatePostComlikeDz")
	public Object updatePostComlikeDz(Integer commitId,Integer userId) {
		return commitLikeService.updatePostComlikeDz(commitId, userId);
	}
	
	/**
	 * 用户给评论踩赞后进行点赞的操作
	 * http://localhost:3011/wangmengxia/WangMengXia/comLike/updatePostComlikeCz?commitId=2&userId=22
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/updatePostComlikeCz")
	public Object updatePostComlikeCz(Integer commitId,Integer userId) {
		return commitLikeService.updatePostComlikeCz(commitId, userId);
	}
}
