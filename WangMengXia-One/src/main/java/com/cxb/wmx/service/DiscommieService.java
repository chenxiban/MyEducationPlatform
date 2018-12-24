package com.cxb.wmx.service;

import java.util.List;

import com.cxb.wmx.entity.Discommit;
import com.cxb.wmx.entity.Dispost;

public interface DiscommieService {
	public Integer selectCommentLikeCount(Integer dispostId);
	public Integer insertCommentFromTheme(String discommitCount,String discommitName,Integer userId,Integer dispostId);
	public Integer updateCommentByCommentId(String discommitCount, int discommitId);
	public List<Discommit> selectDiscommentByDispostIdOrderByDiscommitCreatetime(Integer discommitId,int page,int rows);
	//public Integer deleteCommentByDiscommentId(Integer discommitId);
	public List<Discommit> selectDiscommentHot();
	public List<Dispost> seleteDispostByCommentIdPage(Integer page,Integer rows);
	/*public List<Dispost> selectDispostHot(int page,int rows);*/
}
