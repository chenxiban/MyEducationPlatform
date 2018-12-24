package com.cxb.wmx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.DiscommitRepository;
import com.cxb.wmx.entity.Discommit;
import com.cxb.wmx.entity.Dispost;
import com.cxb.wmx.service.DiscommieService;

@Service
public class DiscommitServiceImpl implements DiscommieService{

	@Autowired
	private DiscommitRepository dRep;
	
	@Override
	public Integer selectCommentLikeCount(Integer dispostId) {
		return dRep.selectCommentLikeCount(dispostId);
	}

	@Override
	public Integer insertCommentFromTheme(String discommitCount, String discommitName, Integer userId,
			Integer dispostId) {
		return dRep.insertCommentFromTheme(discommitCount, discommitName, userId, dispostId);
	}

	@Override
	public Integer updateCommentByCommentId(String discommitCount,int discommitId) {
		// TODO Auto-generated method stub
		return dRep.updateCommentByCommentId(discommitCount, discommitId);
	}

	@Override
	public List<Discommit> selectDiscommentByDispostIdOrderByDiscommitCreatetime(Integer discommitId, int page,
			int rows) {
		return dRep.selectDiscommentByDispostIdOrderByDiscommitCreatetime(discommitId,(page-1)*rows, rows);
	}

	@Override
	public List<Discommit> selectDiscommentHot() {
		return dRep.selectDiscommentHot();
	}

	public List<Dispost> seleteDispostByCommentIdPage(Integer page,Integer rows) {
			List<Discommit> list=dRep.selectDiscommentHot();
			List<Integer> list2=new ArrayList<Integer>();
			for (int i = 0; i < list.size(); i++) {
				list2.add(list.get(i).getDispost().getDispostId());
			}
			List<Dispost> list3=dRep.seleteDispostByCommentIdPage(list2, page, rows);
			return list3;
	
	}
	/*
	@Override
	public List<Dispost> selectDispostHot(int page, int rows) {
		List<Discommit> list=dRep.selectDiscommentHot();
		List<Integer> list2=new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			list2.add(list.get(i).getDispost().getDispostId());
		}
		
		List<Dispost> list3=dRep.seleteDispostByCommentIdPage(list2, (page-1)*rows, rows);
		return list3;
	}*/

/*	@Override
	public Integer deleteCommentByDiscommentId(Integer discommitId) {
		try {
			dRep.deleteById(discommitId);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}*/

}
