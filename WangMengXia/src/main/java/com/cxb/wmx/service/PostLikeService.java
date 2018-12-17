package com.cxb.wmx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

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
	//public Page<Postlike> sreachByPostLike(BarSearch barSearch, Pageable pageable);
	/**
	 * 前10的总踩赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	public List<Postlike> selectPostListByTopC();
}
