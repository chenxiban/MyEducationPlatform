package com.cxb.wmx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cxb.wmx.entity.Bar;
import com.cxb.wmx.entitysearch.BarSearch;

public interface BarService {
	
	/**
	 * 查询所有贴吧分类
	 * 王梦霞
	 * @return
	 */
	public List<Bar> selectAllBar();
	
	/**
	 * 添加
	 * @param bar
	 * @return
	 */
	public boolean addBar(Bar bar);
	
	
	/**
	 * 修改
	 * @param bar
	 * @return
	 */
	public Bar queryBarId(Integer bId);
	public boolean updateBar(Bar bar);
	
	/**
	 * 删除
	 * @param bid
	 * @return
	 */
	public boolean deleteBar(Integer bid);
	public boolean deleteBarByIds(List<String> list);
	
	/**
	 * 查询贴吧分类名称
	 * @param barName
	 * @return
	 */
	public Bar findByBarCategory(String barName);
	
	/**
	 * 动态查询条件的排序分页
	 * 王梦霞
	 * @param barSearch
	 * @param pageable
	 * @return
	 */
	public Page<Bar> sreachByBar(BarSearch barSearch, Pageable pageable);
	
}
