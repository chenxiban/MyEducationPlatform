package com.cxb.wmx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.service.DislikeService;

@RestController
@RequestMapping(value = "/dislike")
public class DislikeController {

	@Autowired
	private DislikeService dlSer;

	/**
	 * @author sun 给帖子点赞
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/dislike/insertThemeLike
	 *         http://localhost:3031/WangMengXia-One/dislike/insertThemeLike?userId=1&dispostId=1
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value = "/insertThemeLike")
	public Object insertThemeLike(Integer userId, Integer dispostId) {
		Integer n=0;
		  int nn=dlSer.seleteUserWhetherLikeThis(dispostId, userId); 
		  int dn=dlSer.seleteUserWhetherDisLikeThis(dispostId, userId);
		  if(nn>0) {//当该用户点过赞,取消点赞
		  n=dlSer.updateCancelLike(userId, dispostId);
		  }else if(dn>0) {//当用户点过踩,将踩状态改为赞
			 n= dlSer.updateThemeLike(userId, dispostId);
		  }else {//当用户没对该讨论点赞或者点踩,直接点赞
			 n= dlSer.insertThemeLike(userId, dispostId);
		  }
		 
		 return n;

	}
	/**
	 * @author sun
	 * 给帖子点踩
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/dislike/insertThemeDisLike
	 * http://localhost:3031/WangMengXia-One/dislike/insertThemeDisLike?userId=1&dispostId=1
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value="/insertThemeDisLike")
	public Object insertThemeDisLike(Integer userId, Integer dispostId) {
		Integer n=0;
		  int nn=dlSer.seleteUserWhetherLikeThis(dispostId, userId); 
		  int dn=dlSer.seleteUserWhetherDisLikeThis(dispostId, userId);
		  if(dn>0) {//当该用户点过踩,取消点踩
			  System.out.println("当该用户点过踩,取消点踩");
		  n=dlSer.updateCancelLike(userId, dispostId);
		  
		  
		  }else if(nn>0) {//当用户点过赞,将赞状态改为踩
			  System.out.println("当用户点过赞,将赞状态改为踩");
			 n= dlSer.updateThemeOut(userId, dispostId);
		  }else {//当用户没对该讨论点赞或者点踩,直接点踩
			  System.out.println("当用户没对该讨论点赞或者点踩,直接点踩");
			 n= dlSer.insertThemeOut(userId, dispostId);
		  }
		 
		 return n;
	}
	
	/**
	 * @author sun
	 * 查询该帖子点赞数
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/dislike/selectThemeLikeCount
	 * http://localhost:3031/WangMengXia-One/dislike/selectThemeLikeCount?dispostId=1
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value="/selectThemeLikeCount")
	public Object selectThemeLikeCount(Integer dispostId) {
		return dlSer.selectThemeLikeCount(dispostId);
	}
	
	/**
	 * @author sun
	 * 查询该帖子点踩数
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/dislike/selectThemeDisLikeCount
	 * http://localhost:3031/WangMengXia-One/dislike/selectThemeDisLikeCount?dispostId=1
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value="/selectThemeDisLikeCount")
	public Object selectThemeDisLikeCount(Integer dispostId) {
		return dlSer.selectThemeDisLikeCount(dispostId);
	}

	
}
