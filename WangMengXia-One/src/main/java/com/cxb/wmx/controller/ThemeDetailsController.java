package com.cxb.wmx.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Dispost;
import com.cxb.wmx.service.ThemeDetailsService;

@RestController
@RequestMapping(value="/themedetails")
public class ThemeDetailsController {

	@Autowired
	private ThemeDetailsService tdSer;
	
	/**
	 * 作者:孙可欣
	 * 查询指定的帖子详情
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/themedetails/selectDispostById?dispostId=1
	 * @param dispostId
	 * @return
	 * http://localhost:3031/WangMengXia-One/themedetails/selectDispostById?dispostId=1
	 */
	@RequestMapping(value="/selectDispostById")
	public Object selectDispostById(Integer dispostId) {
		Dispost dispost=tdSer.selectDispostById(dispostId);
		return dispost;
	}
	
	/**
	 * http://localhost:3031/WangMengXia-One/themedetails/getAllPost
	 * @return
	 */
	@RequestMapping("/getAllPost")
	public Object getAllPost() {
		return tdSer.getAllPost();
	}
	
	/**
	 * @author sun
	 * 修改评论
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/themedetails/updateThemeByDispostId?dispostTitle=修改标题&dispostCount=修改&dispostId=1
	 * http://localhost:3031/WangMengXia-One/themedetails/updateThemeByDispostId?dispostTitle=修改标题&dispostCount=修改&dispostId=1
	 * @param discommitCount
	 * @param discommitId
	 * @return
	 */
	@RequestMapping(value="/updateThemeByDispostId")
	public Object updateThemeByDispostId(String dispostTitle,String dispostCount, int dispostId) {
		return tdSer.updateThemeByDispostId(dispostTitle,dispostCount, dispostId);
	}
	
/*	
	@RequestMapping(value="/deleteDispostByDispostId")
	public Object deleteDispostByDispostId(Integer dispostId,Integer userId) {
		int tbd=tdSer.selectThemeByDispostId(dispostId);//查看帖子是否存在
		if(tbd>0) {
			int dwl=tdSer.selectDispostWhetherLike(dispostId);//查看帖子是否有点踩赞
			if(dwl>0) {//如果帖子有踩赞记录
					tdSer.deleteDislikeByDispostId(dispostId);
			}
			
			//查看帖子是否有评论
		}else {
			System.out.println("帖子不存在");
		}
		return 0;
	}*/
	
/*	*//**
	 * @author sun 删除评论
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/deleteCommentByCommentId?discommentId=1&userId=2
	 *         http://localhost:3031/WangMengXia-One/discommit/deleteCommentByCommentId?discommentId=1&userId=2
	 * @param discommentId
	 * @param userId
	 * @return
	 *//*
	@RequestMapping(value = "/deleteCommentByCommentId")
	public Object deleteCommentByCommentId(Integer discommentId,Integer userId) {
		int n = 0;
		int dbd=dSer.selectDiscommentByDiscommentId(discommentId);
		System.out.println("dbd=="+dbd);
		if(dbd>0) {//如果评论存在
			int dcwl = dSer.selectDiscommentWhetherLike(discommentId);// 查看评论是否有点踩赞
			System.out.println("dcwl==" + dcwl);
			if (dcwl > 0) {// 如果评论有点踩赞
				dSer.deleteDisclazzlikeByCommentId(discommentId);// 删除评论点踩赞
			}
			
			List<Integer> dwr = drSer.selectDiscommentWhetherReply(discommentId);// 查找评论下回复的DispostreplyId
			System.out.println("dwr==" + dwr);
			
			if (!dwr.isEmpty()) {// 查找评论是否有回复
				
				int dwl = drSer.selectDisreplyWhetherLike(dwr);// 查看dwr这些回复是否有点赞踩
				System.out.println("dwl==" + dwl);
				if (dwl > 0) {// 回覆是否有點踩贊
					drSer.deleteDisreplyLike(dwr);// 删除回复的点踩赞记录
					drSer.deleteReplyByDispostreplyId(dwr);// 然后删除该回复
					n = dSer.deleteDiscommentByDiscommentIdList(discommentId, userId);// 最后删除评论
					System.out.println("n==" + n);
				} else {
					drSer.deleteReplyByDispostreplyId(dwr);// 然后删除该回复
					n = dSer.deleteDiscommentByDiscommentIdList(discommentId, userId);// 最后删除评论
					System.out.println("n==" + n);
				}
			}else {
				n = dSer.deleteDiscommentByDiscommentIdList(discommentId, userId);// 最后删除评论
				System.out.println("n==" + n);
			}
			
		}else {
			System.out.println("评论不存在");
		}
		return n;

	}*/

}
