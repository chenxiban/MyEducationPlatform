package com.cxb.wmx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.DispostreplyRepository;
import com.cxb.wmx.entity.Dispostreply;
import com.cxb.wmx.service.DispostreplyService;
@Service
public class DispostreplyServiceImpl implements DispostreplyService{

	@Autowired
	private DispostreplyRepository dRep;
	
	@Override
	public Dispostreply insertReplyFromComment(Dispostreply dispostreply) {
		return dRep.save(dispostreply);
	}

	@Override
	public Integer updateReplyByDispostreplyId(String dispostreplyName, int dispostreplyId) {
		// TODO Auto-generated method stub
		return dRep.updateReplyByDispostreplyId(dispostreplyName, dispostreplyId);
	}
/*
	@Override
	public Integer selectReplyByCommentId(Integer discommitId) {
		return dRep.findById(id);
	}*/

	@Override
	public List<Dispostreply> selectReplyByCommentId(Integer discommitId,int page,int rows) {
		// TODO Auto-generated method stub
		return dRep.selectReplyByCommentId(discommitId,(page-1)*rows,rows);
	}

}
