package com.cxb.wmx.service;

public interface DisreplylikeService {

	public Integer insertReplyLike(Integer userId,Integer dispostreplyId);
	public Integer insertReplyOut(Integer userId,Integer dispostreplyId);
	public Integer seleteUserWhetherLikeThis(Integer dispostreplyId,Integer userId);
	public Integer seleteUserWhetherDisLikeThis(Integer dispostreplyId,Integer userId);
	public Integer updateCancelLike(Integer userId,Integer dispostreplyId);
	public Integer updateReplyLike(Integer userId,Integer dispostreplyId);
	public Integer updateReplyOut(Integer userId,Integer dispostreplyId);
	
	public Integer selectUserWhetherSet(Integer userId, Integer dispostreplyId);
	
	public Integer selectReplyLikeCount(Integer dispostreplyId);
	public Integer selectReplyDisLikeCount(Integer dispostreplyId);
}
