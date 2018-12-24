package com.cxb.wmx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.DisclazzlikeRepository;
import com.cxb.wmx.service.DisclazzlikeService;
@Service
public class DisclazzlikeServiceImpl implements DisclazzlikeService{

	@Autowired
	private DisclazzlikeRepository dlRep;
	
	@Override
	public Integer insertCommitLike(Integer userId, Integer discommitId) {
		return dlRep.insertCommitLike(userId, discommitId);
	}

	@Override
	public Integer insertCommitOut(Integer userId, Integer discommitId) {
		// TODO Auto-generated method stub
		return dlRep.insertCommitOut(userId, discommitId);
	}

	@Override
	public Integer seleteUserWhetherLikeThis(Integer discommitId, Integer userId) {
		// TODO Auto-generated method stub
		return dlRep.seleteUserWhetherLikeThis(discommitId, userId);
	}

	@Override
	public Integer seleteUserWhetherDisLikeThis(Integer discommitId, Integer userId) {
		// TODO Auto-generated method stub
		return dlRep.seleteUserWhetherDisLikeThis(discommitId, userId);
	}

	@Override
	public Integer updateCancelLike(Integer userId, Integer discommitId) {
		// TODO Auto-generated method stub
		return dlRep.updateCancelLike(userId, discommitId);
	}

	@Override
	public Integer updateCommitLike(Integer userId, Integer discommitId) {
		// TODO Auto-generated method stub
		return dlRep.updateCommitLike(userId, discommitId);
	}

	@Override
	public Integer updateCommitOut(Integer userId, Integer discommitId) {
		// TODO Auto-generated method stub
		return dlRep.updateCommitOut(userId, discommitId);
	}

	@Override
	public Integer selectCommitLikeCount(Integer discommitId) {
		// TODO Auto-generated method stub
		return dlRep.selectCommitLikeCount(discommitId);
	}

	@Override
	public Integer selectCommitDisLikeCount(Integer discommitId) {
		// TODO Auto-generated method stub
		return dlRep.selectCommitDisLikeCount(discommitId);
	}

}
