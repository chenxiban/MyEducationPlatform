package com.cxb.wmx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Dispostreply;
import com.cxb.wmx.service.DispostreplyService;

@RestController
@RequestMapping(value="/dispostreply")
public class DispostreplyController {

	@Autowired
	private DispostreplyService dSer;
	
	/**
	 * @author sun
	 * 给评论添加回复
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/dispostreply/insertReplyFromComment?dispostreplyName=回复2&userId=1&discommit=1
	 * http://localhost:3031/WangMengXia-One/dispostreply/insertReplyFromComment?dispostreplyName=回复2&userId=1&discommit=1
	 * @param dispostreply
	 * @return
	 */
	@RequestMapping(value="/insertReplyFromComment")
	public Object insertReplyFromComment(Dispostreply dispostreply) {
		return dSer.insertReplyFromComment(dispostreply);
	}
	
	
	/**
	 * @author sun
	 * 修改评论
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/dispostreply/updateReplyByDispostreplyId?dispostreplyName=修改回复&dispostreplyId=1
	 * http://localhost:3031/WangMengXia-One/dispostreply/updateReplyByDispostreplyId?dispostreplyName=修改回复&dispostreplyId=1
	 * @param discommitCount
	 * @param discommitId
	 * @return
	 */
	@RequestMapping(value="/updateReplyByDispostreplyId")
	public Object updateReplyByDispostreplyId(String dispostreplyName,int dispostreplyId) {
		return dSer.updateReplyByDispostreplyId(dispostreplyName, dispostreplyId);
	}
	
	/**
	 * @author sun
	 * 查询所有回复根据评论Id
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/dispostreply/selectReplyByCommentId?discommitId=1
	 * http://localhost:3031/WangMengXia-One/dispostreply/selectReplyByCommentId?discommitId=1
	 * @param discommitId
	 * @return
	 */
	@RequestMapping(value="/selectReplyByCommentId")
	public Object selectReplyByCommentId(Integer discommitId,int page,int rows) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", dSer.selectReplyByCommentId(discommitId,page,rows).size());
		map.put("rows", dSer.selectReplyByCommentId(discommitId,page,rows));
		return map;
	}
	
	/**
	 * @author sun
	 * 删除回复
	 * http://localhost:3011/wangmengxia-one/WangMengXia-One/dispostreply/deleteReplyByDispostreplyId?dispostreplyId=1&userId=1
	 * http://localhost:3031/WangMengXia-One/dispostreply/deleteReplyByDispostreplyId?dispostreplyId=1&userId=1
	 * @param dispostreplyId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/deleteReplyByDispostreplyId")
	public Object deleteReplyByDispostreplyId(@RequestParam(value="dispostreplyId")List<Integer> dispostreplyId,Integer userId) {
		System.out.println("dispostreplyId==="+dispostreplyId);
		System.out.println("userId==="+userId);
		int nn=dSer.selectDisreplyWhetherLike(dispostreplyId);//查看该回复是否有点赞踩
		System.out.println("nn=="+nn);
		int n;
		if(nn>0) {//有点赞或点踩
			dSer.deleteDisreplyLike(dispostreplyId);//删除回复的点踩赞记录
			n=dSer.deleteReplyByDispostreplyIdAndUserId(dispostreplyId, userId);//然后删除该回复
			System.out.println("n=="+n);
		}else {//没有点赞或点踩
			n=dSer.deleteReplyByDispostreplyIdAndUserId(dispostreplyId, userId);//直接删除该回复
			System.out.println("n=="+n);
		}
		return n;
	}
	
}
