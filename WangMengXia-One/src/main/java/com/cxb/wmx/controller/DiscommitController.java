package com.cxb.wmx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Discommit;
import com.cxb.wmx.service.DiscommieService;
import com.cxb.wmx.service.DispostreplyService;

@RestController
@RequestMapping(value = "/discommit")
public class DiscommitController {

	@Autowired
	private DiscommieService dSer;

	@Autowired
	private DispostreplyService drSer;

	/**
	 * @author sun 查询帖子评价数
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/selectCommentLikeCount
	 *         http://localhost:3031/WangMengXia-One/discommit/selectCommentLikeCount?dispostId=1
	 * @param dispostId
	 * @return
	 */
	@RequestMapping("/selectCommentLikeCount")
	public Object selectCommentLikeCount(Integer dispostId) {
		return dSer.selectCommentLikeCount(dispostId);
	}

	/**
	 * @author sun 给帖子添加一条评论
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/insertCommentFromTheme?discommitCount=评论2&discommitName=用户1&userId=1&dispostId=1
	 *         http://localhost:3031/WangMengXia-One/discommit/insertCommentFromTheme?discommitCount=评论2&discommitName=用户1&userId=1&dispostId=1
	 * @param discommitCount
	 * @param discommitName
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value = "/insertCommentFromTheme")
	public Object insertCommentFromTheme(String discommitCount, String discommitName, Integer userId,
			Integer dispostId) {
		return dSer.insertCommentFromTheme(discommitCount, discommitName, userId, dispostId);
	}

	/**
	 * @author sun 修改评论
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/updateCommentByCommentId?discommitCount=修改&discommitId=1
	 *         http://localhost:3031/WangMengXia-One/discommit/updateCommentByCommentId?discommitCount=修改&discommitId=1
	 * @param discommitCount
	 * @param discommitId
	 * @return
	 */
	@RequestMapping(value = "/updateCommentByCommentId")
	public Object updateCommentByCommentId(String discommitCount, int discommitId) {
		return dSer.updateCommentByCommentId(discommitCount, discommitId);
	}

	/**
	 * @author sun 分页查询帖子评论根据评论时间降序排列
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/selectDiscommentByDispostIdOrderByDiscommitCreatetime?discommitId=1&page=1&rows=2
	 *         http://localhost:3031/WangMengXia-One/discommit/selectDiscommentByDispostIdOrderByDiscommitCreatetime?discommitId=1&page=1&rows=2
	 * @param discommitId
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/selectDiscommentByDispostIdOrderByDiscommitCreatetime")
	public Object selectDiscommentByDispostIdOrderByDiscommitCreatetime(Integer discommitId, int page, int rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", dSer.selectDiscommentByDispostIdOrderByDiscommitCreatetime(discommitId, page, rows).size());
		map.put("rows", dSer.selectDiscommentByDispostIdOrderByDiscommitCreatetime(discommitId, page, rows));
		return map;
	}

	/*
	 * public Object deleteCommentByDiscommentId(Integer discommitId) {
	 * 
	 * return null; }
	 */
	/**
	 * @author sun
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/seleteDispostByCommentIdPage?page=1&rows=2
	 *         http://localhost:3031/WangMengXia-One/discommit/seleteDispostByCommentIdPage?list=1page=1&rows=2
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/seleteDispostByCommentIdPage")
	public Map<String, Object> seleteDispostByCommentIdPage(Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", dSer.seleteDispostByCommentIdPage(page, rows).size());
		map.put("rows", dSer.seleteDispostByCommentIdPage(page, rows));
		return map;
	}

	/**
	 * @author sun 删除评论
	 *         http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/deleteCommentByCommentId?discommentId=1&userId=2
	 *         http://localhost:3031/WangMengXia-One/discommit/deleteCommentByCommentId?discommentId=1&userId=2
	 * @param discommentId
	 * @param userId
	 * @return
	 */
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

	}

}
