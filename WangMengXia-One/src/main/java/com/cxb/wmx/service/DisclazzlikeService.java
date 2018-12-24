package com.cxb.wmx.service;

public interface DisclazzlikeService {
	public Integer insertCommitLike(Integer userId,Integer discommitId);
	public Integer insertCommitOut(Integer userId,Integer discommitId);
	public Integer seleteUserWhetherLikeThis(Integer discommitId,Integer userId);
	public Integer seleteUserWhetherDisLikeThis(Integer discommitId,Integer userId);
	public Integer updateCancelLike(Integer userId,Integer discommitId);
	public Integer updateCommitLike(Integer userId,Integer discommitId);
	public Integer updateCommitOut(Integer userId,Integer discommitId);
	
	
	public Integer selectCommitLikeCount(Integer discommitId);
	public Integer selectCommitDisLikeCount(Integer discommitId);
}
