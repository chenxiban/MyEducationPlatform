package com.cxb.wmx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Bar;
import com.cxb.wmx.entity.Postlike;
import com.cxb.wmx.entitysearch.BarSearch;

public interface PostLikeService {

	/**
	 * 前10的总点赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	public List<Postlike> selectPostListByTopD();
	/**
	 * 前10的总踩赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	public List<Postlike> selectPostListByTopC();
	
	/**
	 * 用户给帖子点赞
	 * @param postId
	 * @return
	 */
	public boolean addPostlikeDz(Integer postId,Integer userId);
	
	/**
	 * 用户给帖子踩赞
	 * @param postId
	 * @return
	 */
	public boolean addPostlikeCz(Integer postId,Integer userId);
	
	public boolean deletePostlikeDz(Integer postId,Integer userId);
	public boolean deletePostlikeCz(Integer postId,Integer userId);
	public boolean updatePostlikeDz(Integer postId,Integer userId);
	public boolean updatePostlikeCz(Integer postId,Integer userId);
}
