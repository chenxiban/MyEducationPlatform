package com.cxb.wmx.service;

import java.util.List;

import com.cxb.wmx.entity.Dispostreply;

public interface DispostreplyService {

	public Dispostreply insertReplyFromComment(Dispostreply dispostreply);
	public Integer updateReplyByDispostreplyId(String dispostreplyName,int dispostreplyId);
	//public List<Dispostreply> selectReplyByCommentId(Integer discommitId);
	
	public List<Dispostreply> selectReplyByCommentId(Integer discommitId,int page,int rows);
}
