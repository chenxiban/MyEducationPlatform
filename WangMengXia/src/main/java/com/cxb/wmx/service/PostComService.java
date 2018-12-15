package com.cxb.wmx.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Post;
import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entitysearch.PostComSearch;

public interface PostComService {

	/**
	 * 动态查询条件的排序分页
	 * 王梦霞
	 * @param postSearch
	 * @param pageable
	 * @return
	 */
	public Page<Postcommit> sreachByPostCom(PostComSearch postComSearch, Pageable pageable);
	
	/**
	 * 删除评论,回复
	 * @param postcommitId
	 * @return
	 */
	public Object deletePostCommitById(Integer postcommitId);
}
