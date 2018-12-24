package com.cxb.wmx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.DisreplylikeRepository;
import com.cxb.wmx.service.DisreplylikeService;

@Service
public class DisreplylikeServiceImpl implements DisreplylikeService{

	@Autowired
	private DisreplylikeRepository dlRep;
	
	public Integer insertReplyLike(Integer userId, Integer dispostreplyId) {
		return dlRep.insertReplyLike(userId, dispostreplyId);
	}

	public Integer insertReplyOut(Integer userId, Integer dispostreplyId) {
		// TODO Auto-generated method stub
		return dlRep.insertReplyOut(userId, dispostreplyId);
	}

	public Integer seleteUserWhetherLikeThis(Integer dispostreplyId, Integer userId) {
		// TODO Auto-generated method stub
		return dlRep.seleteUserWhetherLikeThis(dispostreplyId, userId);
	}

	public Integer seleteUserWhetherDisLikeThis(Integer dispostreplyId, Integer userId) {
		// TODO Auto-generated method stub
		return dlRep.seleteUserWhetherDisLikeThis(dispostreplyId, userId);
	}

	public Integer updateCancelLike(Integer userId, Integer dispostreplyId) {
		// TODO Auto-generated method stub
		return dlRep.updateCancelLike(userId, dispostreplyId);
	}

	public Integer updateReplyLike(Integer userId, Integer dispostreplyId) {
		// TODO Auto-generated method stub
		return dlRep.updateReplyLike(userId, dispostreplyId);
	}

	public Integer updateReplyOut(Integer userId, Integer dispostreplyId) {
		// TODO Auto-generated method stub
		return dlRep.updateReplyOut(userId, dispostreplyId);
	}

	@Override
	public Integer selectReplyLikeCount(Integer dispostreplyId) {
		// TODO Auto-generated method stub
		return dlRep.selectReplyLikeCount(dispostreplyId);
	}

	@Override
	public Integer selectReplyDisLikeCount(Integer dispostreplyId) {
		// TODO Auto-generated method stub
		return dlRep.selectReplyDisLikeCount(dispostreplyId);
	}

}
