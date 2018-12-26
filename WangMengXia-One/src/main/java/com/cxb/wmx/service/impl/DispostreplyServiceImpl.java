package com.cxb.wmx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

	@Override
	public Integer deleteReplyByDispostreplyIdAndUserId(@RequestParam(value="dispostreplyId")List<Integer> dispostreplyId, Integer userId) {
		// TODO Auto-generated method stub
		return dRep.deleteReplyByDispostreplyIdAndUserId(dispostreplyId, userId);
	}

	/**
	 * @author sun
	 * 删除回复时查看该回复是否有点赞踩
	 */
	@Override
	public Integer selectDisreplyWhetherLike(List<Integer> dispostreplyId) {
		return dRep.selectDisreplyWhetherLike(dispostreplyId);
	}

	@Override
	public Integer deleteDisreplyLike(List<Integer> dispostreplyId) {
		// TODO Auto-generated method stub
		return dRep.deleteDisreplyLike(dispostreplyId);
	}

	
	
	/**
	 * @author sun
	 * 获取评论下回复的所有id
	 */
		@Override
		public List<Integer> selectDiscommentWhetherReply(Integer discommentId) {
			List<Dispostreply> list=dRep.selectDiscommentWhetherReply(discommentId);
			List<Integer> list2=new ArrayList<Integer>();
			for (int i = 0; i < list.size(); i++) {
				list2.add(list.get(i).getDispostreplyId());
			}
			
			return list2;
		}

	@Override
	public Integer deleteReplyByDiseplyIdList(@RequestParam(value="discommentId")List<Integer> discommentId) {
		return dRep.deleteReplyByDiseplyIdList(discommentId);
	}

	@Override
	public Integer deleteReplyByDispostreplyId(List<Integer> dispostreplyId) {
		// TODO Auto-generated method stub
		return dRep.deleteReplyByDispostreplyId(dispostreplyId);
	}



}
