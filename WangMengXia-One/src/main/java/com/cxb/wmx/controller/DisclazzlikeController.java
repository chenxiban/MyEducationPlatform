package com.cxb.wmx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.service.DisclazzlikeService;

@RestController
@RequestMapping(value="/disclasslike")
public class DisclazzlikeController {

	@Autowired
	private DisclazzlikeService dlSer;
	

	/**
	 * @author sun 给帖子评论点赞
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/disclasslike/insertCommitLike?userId=1&discommitId=1
	 *         http://localhost:3031/WangMengXia-One/disclasslike/insertCommitLike?userId=1&discommitId=1
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value = "/insertCommitLike")
	public Object insertCommitLike(Integer userId, Integer discommitId) {
		Integer n=0;
		  int nn=dlSer.seleteUserWhetherLikeThis(discommitId, userId); 
		  int dn=dlSer.seleteUserWhetherDisLikeThis(discommitId, userId);
		  if(nn>0) {//当该用户点过赞,取消点赞
		  n=dlSer.updateCancelLike(userId, discommitId);
		  }else if(dn>0) {//当用户点过踩,将踩状态改为赞
			 n= dlSer.updateCommitLike(userId, discommitId);
		  }else {//当用户没对该讨论点赞或者点踩,直接点赞
			 n= dlSer.insertCommitLike(userId, discommitId);
		  }
		 
		 return n;

	}
	/**
	 * @author sun
	 * 给帖子点踩
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/disclasslike/insertCommitDisLike?userId=1&discommitId=1
	 * http://localhost:3031/WangMengXia-One/disclasslike/insertCommitDisLike?userId=1&discommitId=1
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value="/insertCommitDisLike")
	public Object insertCommitDisLike(Integer userId, Integer discommitId) {
		Integer n=0;
		  int nn=dlSer.seleteUserWhetherLikeThis(discommitId, userId); 
		  int dn=dlSer.seleteUserWhetherDisLikeThis(discommitId, userId);
		  if(dn>0) {//当该用户点过踩,取消点踩
			  System.out.println("当该用户点过踩,取消点踩");
		  n=dlSer.updateCancelLike(userId, discommitId);
		  
		  
		  }else if(nn>0) {//当用户点过赞,将赞状态改为踩
			  System.out.println("当用户点过赞,将赞状态改为踩");
			 n= dlSer.updateCommitOut(userId, discommitId);
		  }else {//当用户没对该讨论点赞或者点踩,直接点踩
			  System.out.println("当用户没对该讨论点赞或者点踩,直接点踩");
			 n= dlSer.insertCommitOut(userId, discommitId);
		  }
		 
		 return n;
	}
	
	
	/**
	 * @author sun
	 * 查询该帖子评论点赞数
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/disclasslike/selectCommitLikeCount
	 * http://localhost:3031/WangMengXia-One/disclasslike/selectCommitLikeCount?discommitId=1
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value="/selectCommitLikeCount")
	public Object selectCommitLikeCount(Integer discommitId) {
		return dlSer.selectCommitLikeCount(discommitId);
	}
	
	/**
	 * @author sun
	 * 查询该帖子评论点踩数
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/disclasslike/selectCommitDisLikeCount
	 * http://localhost:3031/WangMengXia-One/disclasslike/selectCommitDisLikeCount?discommitId=1
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value="/selectCommitDisLikeCount")
	public Object selectCommitDisLikeCount(Integer discommitId) {
		return dlSer.selectCommitDisLikeCount(discommitId);
	}

	
}
