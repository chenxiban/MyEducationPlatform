package com.cxb.wmx.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.ReplylikeRpostiory;
import com.cxb.wmx.service.ReplyLikeService;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;

@Service
public class ReplyLikeServiceImpl implements ReplyLikeService{

	@Autowired
	private ReplylikeRpostiory replylikeRpostiory;
	@Override
	public boolean addReplylikeDz(Integer replyId, Integer userId) {
		return replylikeRpostiory.addReplylikeDz(replyId, userId)>0?true:false;
	}

	@Override
	public boolean addReplylikeCz(Integer replyId, Integer userId) {
		return replylikeRpostiory.addReplylikeCz(replyId, userId)>0?true:false;
	}

	@Override
	public boolean deleteReplylikeDz(Integer replyId, Integer userId) {
		return replylikeRpostiory.deleteReplylikeDz(replyId, userId)>0?true:false;
	}

	@Override
	public boolean deleteReplylikeCz(Integer replyId, Integer userId) {
		return replylikeRpostiory.deleteReplylikeCz(replyId, userId)>0?true:false;
	}

	@Override
	public boolean updateReplylikeDz(Integer replyId, Integer userId) {
		return replylikeRpostiory.updateReplylikeDz(replyId, userId)>0?true:false;
	}

	@Override
	public boolean updateReplylikeCz(Integer replyId, Integer userId) {
		return replylikeRpostiory.updateReplylikeCz(replyId, userId)>0?true:false;
	}


}
