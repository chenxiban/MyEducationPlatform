package com.cxb.wmx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.service.ReplyLikeService;

@RestController
@RequestMapping(value="/replyLike")
public class ReplyLikeController {

	@SuppressWarnings("unused")
	@Autowired
	private ReplyLikeService replyLikeService;
	
	/**
	 * 用户个评论点赞
	 * http://localhost:3011/wangmengxia/WangMengXia/replyLike/addReplylikeDz?replyId=2&userId=2
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/addReplylikeDz")
	public Object addReplylikeDz(Integer replyId,Integer userId) {
		return replyLikeService.addReplylikeDz(replyId, userId);
	}
	
	/**
	 * 用户个评论踩赞
	 * http://localhost:3011/wangmengxia/WangMengXia/replyLike/addReplylikeCz?replyId=2&userId=22
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/addReplylikeCz")
	public Object addReplylikeCz(Integer commitId,Integer userId) {
		return replyLikeService.addReplylikeDz(commitId,userId);
	}
	
	/**
	 * 用户给评论取消点赞
	 * http://localhost:3011/wangmengxia/WangMengXia/replyLike/deleteReplylikeDz?replyId=2&userId=2
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/deleteReplylikeDz")
	public Object deleteReplylikeDz(Integer replyId,Integer userId) {
		return replyLikeService.deleteReplylikeDz(replyId, userId);
	}
	
	/**
	 * 用户个评论取消踩赞
	 * http://localhost:3011/wangmengxia/WangMengXia/replyLike/deleteReplylikeCz?replyId=2&userId=22
	 * @author 王梦霞
	 * @returnupdatePostlikeCz
	 */
	@RequestMapping(value="/deleteReplylikeCz")
	public Object deleteReplylikeCz(Integer replyId,Integer userId) {
		return replyLikeService.deleteReplylikeDz(replyId, userId);
	}
	
	/**
	 * 用户给评论点赞后进行踩赞的操作
	 * http://localhost:3011/wangmengxia/WangMengXia/replyLike/updateReplylikeDz?replyId=2&userId=22
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/updateReplylikeDz")
	public Object updateReplylikeDz(Integer replyId,Integer userId) {
		return replyLikeService.updateReplylikeDz(replyId, userId);
	}
	
	/**
	 * 用户给评论踩赞后进行点赞的操作
	 * http://localhost:3011/wangmengxia/WangMengXia/replyLike/updateReplylikeCz?replyId=2&userId=22
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/updateReplylikeCz")
	public Object updateReplylikeCz(Integer replyId,Integer userId) {
		return replyLikeService.updateReplylikeCz(replyId, userId);
	}
}
