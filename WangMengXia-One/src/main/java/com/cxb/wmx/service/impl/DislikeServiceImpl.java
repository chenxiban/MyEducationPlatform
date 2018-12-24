package com.cxb.wmx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.DislikeRepository;
import com.cxb.wmx.service.DislikeService;

@Service
public class DislikeServiceImpl implements DislikeService{

	@Autowired
	private DislikeRepository dlRep;
	

	@Override
	public Integer insertThemeLike(Integer userId, Integer dispostId) {
		return dlRep.insertThemeLike(userId, dispostId);
	}


	@Override
	public Integer seleteUserWhetherLikeThis(Integer dispostId, Integer userId) {
		return dlRep.seleteUserWhetherLikeThis(dispostId, userId);
	}


	@Override
	public Integer updateCancelLike(Integer userId, Integer dispostId) {
		return dlRep.updateCancelLike(userId, dispostId);
	}


	@Override
	public Integer seleteUserWhetherDisLikeThis(Integer dispostId, Integer userId) {
		return dlRep.seleteUserWhetherDisLikeThis(dispostId, userId);
	}


	@Override
	public Integer updateThemeLike(Integer userId, Integer dispostId) {
		return dlRep.updateThemeLike(userId, dispostId);
	}


	@Override
	public Integer updateThemeOut(Integer userId, Integer dispostId) {
		// TODO Auto-generated method stub
		return dlRep.updateThemeOut(userId, dispostId);
	}


	@Override
	public Integer insertThemeOut(Integer userId, Integer dispostId) {
		return dlRep.insertThemeOut(userId, dispostId);
	}


	@Override
	public Integer selectThemeLikeCount(Integer dispostId) {
		// TODO Auto-generated method stub
		return dlRep.selectThemeLikeCount(dispostId);
	}


	@Override
	public Integer selectThemeDisLikeCount(Integer dispostId) {
		// TODO Auto-generated method stub
		return dlRep.selectThemeDisLikeCount(dispostId);
	}

}
