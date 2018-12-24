package com.cxb.wmx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Discommit;
import com.cxb.wmx.service.DiscommieService;

@RestController
@RequestMapping(value="/discommit")
public class DiscommitController {

	@Autowired
	private DiscommieService dSer;
	
	/**
	 * @author sun
	 * 查询帖子评价数
	 *  http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/selectCommentLikeCount
	 * http://localhost:3031/WangMengXia-One/discommit/selectCommentLikeCount?dispostId=1
	 * @param dispostId
	 * @return
	 */
	@RequestMapping("/selectCommentLikeCount")
	public Object selectCommentLikeCount(Integer dispostId) {
		return dSer.selectCommentLikeCount(dispostId);
	}
	
	/**
	 * @author sun
	 * 给帖子添加一条评论
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/insertCommentFromTheme?discommitCount=评论2&discommitName=用户1&userId=1&dispostId=1
	 * http://localhost:3031/WangMengXia-One/discommit/insertCommentFromTheme?discommitCount=评论2&discommitName=用户1&userId=1&dispostId=1
	 * @param discommitCount
	 * @param discommitName
	 * @param userId
	 * @param dispostId
	 * @return
	 */
	@RequestMapping(value="/insertCommentFromTheme")
	public Object insertCommentFromTheme(String discommitCount,String discommitName,Integer userId,Integer dispostId) {
		return dSer.insertCommentFromTheme(discommitCount, discommitName, userId, dispostId);
	}
	
	/**
	 * @author sun
	 * 修改评论
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/updateCommentByCommentId?discommitCount=修改&discommitId=1
	 * http://localhost:3031/WangMengXia-One/discommit/updateCommentByCommentId?discommitCount=修改&discommitId=1
	 * @param discommitCount
	 * @param discommitId
	 * @return
	 */
	@RequestMapping(value="/updateCommentByCommentId")
	public Object updateCommentByCommentId(String discommitCount,int discommitId) {
		return dSer.updateCommentByCommentId(discommitCount, discommitId);
	}
	
	/**
	 * @author sun
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/selectDiscommentByDispostIdOrderByDiscommitCreatetime?discommitId=1&page=1&rows=2
	 * http://localhost:3031/WangMengXia-One/discommit/selectDiscommentByDispostIdOrderByDiscommitCreatetime?discommitId=1&page=1&rows=2
	 * @param discommitId
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/selectDiscommentByDispostIdOrderByDiscommitCreatetime")
	public Object selectDiscommentByDispostIdOrderByDiscommitCreatetime(Integer discommitId,int page,int rows){
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("total", dSer.selectDiscommentByDispostIdOrderByDiscommitCreatetime(discommitId, page, rows).size());
		map.put("rows", dSer.selectDiscommentByDispostIdOrderByDiscommitCreatetime(discommitId, page, rows));
		return map;
	}
	
/*	
	public Object deleteCommentByDiscommentId(Integer discommitId) {
		
		return null;
	}*/
	/**
	 * @author sun
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/discommit/seleteDispostByCommentIdPage?page=1&rows=2
	 * http://localhost:3031/WangMengXia-One/discommit/seleteDispostByCommentIdPage?list=1page=1&rows=2
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/seleteDispostByCommentIdPage")
	public Map<String,Object> seleteDispostByCommentIdPage(Integer page,Integer rows){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total",dSer.seleteDispostByCommentIdPage(page,rows).size());
		map.put("rows", dSer.seleteDispostByCommentIdPage(page, rows));
		return map;
	}

}
