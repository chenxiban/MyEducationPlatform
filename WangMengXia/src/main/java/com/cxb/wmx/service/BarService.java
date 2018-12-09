package com.cxb.wmx.service;

import java.util.List;

import com.cxb.wmx.entity.Bar;

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
	public boolean updateBar(Bar bar);
	
	/**
	 * 删除
	 * @param bid
	 * @return
	 */
	public boolean deleteBar(Integer bid);
}
