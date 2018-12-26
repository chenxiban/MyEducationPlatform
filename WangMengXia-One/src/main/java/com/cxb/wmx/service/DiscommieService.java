package com.cxb.wmx.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

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
	
	public Integer deleteDiscommentByDiscommentIdList(@RequestParam(value="discommentId")Integer discommentId,@RequestParam(value="userId")Integer userId);
	public Integer selectDiscommentWhetherLike(@RequestParam(value="discommentId")Integer discommentId);

	public Integer deleteDisclazzlikeByCommentId(@RequestParam(value="discommentId")Integer discommentId);
	
	public Integer selectDiscommentByDiscommentId(Integer discommentId);
}
