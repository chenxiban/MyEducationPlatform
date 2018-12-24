package com.cxb.wmx.service;

public interface DislikeService {

	public Integer insertThemeLike(Integer userId,Integer dispostId);
	public Integer insertThemeOut(Integer userId,Integer dispostId);
	public Integer seleteUserWhetherLikeThis(Integer dispostId,Integer userId);
	public Integer seleteUserWhetherDisLikeThis(Integer dispostId,Integer userId);
	public Integer updateCancelLike(Integer userId,Integer dispostId);
	public Integer updateThemeLike(Integer userId,Integer dispostId);
	public Integer updateThemeOut(Integer userId,Integer dispostId);
	
	public Integer selectThemeLikeCount(Integer dispostId);
	public Integer selectThemeDisLikeCount(Integer dispostId);
}
