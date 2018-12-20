package com.cxb.wmx.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.cxb.wmx.entity.Postreply;
import com.cxb.wmx.entitysearch.PostreplySearch;

public interface PostreplyService {

	/**
	 * 动态查询条件的排序分页
	 * 王梦霞
	 * @param barSearch
	 * @param pageable
	 * @return
	 */
	public Page<Postreply> sreachByPostreply(PostreplySearch postreplySearch, Pageable pageable);
	
	/**
	 * 删除
	 * @param barId
	 * @return
	 */
	public boolean deletePostreplyById(Integer hfId);
	
	/**
	 * @author 王梦霞
	 * 用户删除自己的回复
	 * @param hfId
	 * @return
	 */
	public boolean deleteUserPostreplyById(Integer hfId);
}
