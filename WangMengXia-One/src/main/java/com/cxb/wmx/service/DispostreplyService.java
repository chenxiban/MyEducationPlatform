package com.cxb.wmx.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.cxb.wmx.entity.Dispostreply;

public interface DispostreplyService {

	public Dispostreply insertReplyFromComment(Dispostreply dispostreply);
	public Integer updateReplyByDispostreplyId(String dispostreplyName,int dispostreplyId);
	//public List<Dispostreply> selectReplyByCommentId(Integer discommitId);
	
	public List<Dispostreply> selectReplyByCommentId(Integer discommitId,int page,int rows);
	public Integer deleteReplyByDispostreplyId(@RequestParam(value="dispostreplyId")List<Integer> dispostreplyId);
	public Integer selectDisreplyWhetherLike(List<Integer> dispostreplyId);
	public Integer deleteDisreplyLike(List<Integer> dispostreplyId);
	
	public List<Integer> selectDiscommentWhetherReply(Integer discommentId);
	public Integer deleteReplyByDiseplyIdList(List<Integer> list);
	public Integer deleteReplyByDispostreplyIdAndUserId(List<Integer> dispostreplyId, Integer userId);
}
