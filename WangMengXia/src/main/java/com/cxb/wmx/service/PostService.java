package com.cxb.wmx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Post;
import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entitysearch.PostComSearch;
import com.cxb.wmx.entitysearch.PostSearch;

public interface PostService {
	/**
	 * 动态查询条件的排序分页
	 * 王梦霞
	 * @param postSearch
	 * @param pageable
	 * @return
	 */
	public Page<Post> sreachByPost(PostSearch post, Pageable pageable);
	
	public Object deletePostById(Integer postId);
	
}
