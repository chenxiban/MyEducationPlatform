package com.cxb.wmx.service;

import org.springframework.stereotype.Service;

/**
 * 评论点赞踩赞service
 * @author 王梦霞
 *
 */
@Service
public interface CommitLikeService {
	
	

	public boolean addPostComlikeDz(Integer commitId,Integer userId);
	public boolean addPostComlikeCz(Integer commitId,Integer userId);
	public boolean deletePostComlikeDz(Integer commitId,Integer userId);
	public boolean deletePostComlikeCz(Integer commitId,Integer userId);
	public boolean updatePostComlikeDz(Integer commitId,Integer userId);
	public boolean updatePostComlikeCz(Integer commitId,Integer userId);
}
