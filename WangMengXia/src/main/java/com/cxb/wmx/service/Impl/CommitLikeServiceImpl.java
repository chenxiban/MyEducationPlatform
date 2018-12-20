package com.cxb.wmx.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.PostComLikeRpository;
import com.cxb.wmx.service.CommitLikeService;

/**
 * 点赞踩赞实现层
 * @author 王梦霞
 *
 */
@Service
public class CommitLikeServiceImpl implements CommitLikeService{

	@Autowired
	private PostComLikeRpository commitRpository;

	@Override
	public boolean addPostComlikeDz(Integer commitId, Integer userId) {
		return commitRpository.addPostComlikeDz(commitId, userId)>0?true:false;
	}

	@Override
	public boolean addPostComlikeCz(Integer commitId, Integer userId) {
		return commitRpository.addPostComlikeCz(commitId, userId)>0?true:false;
	}

	@Override
	public boolean deletePostComlikeDz(Integer commitId, Integer userId) {
		return commitRpository.deletePostComlikeDz(commitId, userId)>0?true:false;
	}

	@Override
	public boolean deletePostComlikeCz(Integer commitId, Integer userId) {
		return commitRpository.deletePostComlikeCz(commitId, userId)>0?true:false;
	}

	@Override
	public boolean updatePostComlikeDz(Integer commitId, Integer userId) {
		return commitRpository.updatePostComlikeDz(commitId, userId)>0?true:false;
	}

	@Override
	public boolean updatePostComlikeCz(Integer commitId, Integer userId) {
		 return commitRpository.updatePostComlikeCz(commitId, userId)>0?true:false;
	}

	
}
