package com.cxb.wmx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.service.DisreplylikeService;

@RestController
@RequestMapping(value = "/disreplylike")
public class DisreplylikeController {
	@Autowired
	private DisreplylikeService dlSer;

	/**
	 * @author sun 给帖子评论回复点赞
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/disreplylike/insertReplyLike?userId=1&dispostreplyId=1
	 *         http://localhost:3031/WangMengXia-One/disreplylike/insertReplyLike?userId=1&dispostreplyId=1
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value = "/insertReplyLike")
	public Object insertReplyLike(Integer userId, Integer dispostreplyId) {
		Integer n = 0;
		int whether = dlSer.selectUserWhetherSet(userId, dispostreplyId);
		int nn = dlSer.seleteUserWhetherLikeThis(dispostreplyId, userId);
		System.out.println("nn==" + nn);
		if (whether > 0) {
			if (nn > 0) {// 当该用户点过赞,取消点赞
				n = dlSer.updateCancelLike(userId, dispostreplyId);
				System.out.println("n==" + n);
			} else {// 当用户没对该讨论点赞或者点踩,直接点赞
					// 查看是否有点赞踩记录
				n = dlSer.updateReplyLike(userId, dispostreplyId);
				System.out.println("n==" + n);
			}
		} else {
			n = dlSer.insertReplyLike(userId, dispostreplyId);
		}

		return n;

	}

	/**
	 * @author sun 给帖子评论的回复点踩
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/disreplylike/insertReplyDisLike?userId=1&dispostreplyId=1
	 *         http://localhost:3031/WangMengXia-One/disreplylike/insertReplyDisLike?userId=1&dispostreplyId=1
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value = "/insertReplyDisLike")
	public Object insertReplyDisLike(Integer userId, Integer dispostreplyId) {
		Integer n = 0;
		int whether = dlSer.selectUserWhetherSet(userId, dispostreplyId);
		int dn = dlSer.seleteUserWhetherDisLikeThis(dispostreplyId, userId);
		if (whether > 0) {
			if (dn > 0) {// 当该用户点过踩,取消点踩
				System.out.println("当该用户点过踩,取消点踩");
				n = dlSer.updateCancelLike(userId, dispostreplyId);

			} else {// 当用户没对该讨论点赞或者点踩,直接点踩
				System.out.println("当用户没对该讨论点赞或者点踩,直接点踩");
				n = dlSer.updateReplyOut(userId, dispostreplyId);
			}
		}else {
			n = dlSer.insertReplyOut(userId, dispostreplyId);
		}
		

		return n;
	}

	/**
	 * @author sun 查询该帖子评论回复点赞数
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/disclasslike/selectReplyLikeCount
	 *         http://localhost:3031/WangMengXia-One/disclasslike/selectReplyLikeCount?discommitId=1
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value = "/selectReplyLikeCount")
	public Object selectReplyLikeCount(Integer dispostreplyId) {
		return dlSer.selectReplyLikeCount(dispostreplyId);
	}

	/**
	 * @author sun 查询该帖子评论回复点踩数
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/disclasslike/selectReplyDisLikeCount
	 *         http://localhost:3031/WangMengXia-One/disclasslike/selectReplyDisLikeCount?dispostreplyId=1
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value = "/selectReplyDisLikeCount")
	public Object selectReplyDisLikeCount(Integer dispostreplyId) {
		return dlSer.selectReplyDisLikeCount(dispostreplyId);
	}

}
