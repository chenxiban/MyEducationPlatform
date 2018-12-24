package com.cxb.wmx.service;

import java.util.List;

import com.cxb.wmx.entity.Dispost;

public interface DispostService {

	/**
	 * @author 王梦霞
	 * 给陈永佳组提供的根据pid查询课程讨论的帖子详情
	 * @param pid
	 * @return
	 */
	public List<Dispost> selectListDispostById(List<Integer> pid);
	
	/**
	 * @author 王梦霞
	 * 查询前20评论最多的帖子分页
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Dispost> queryPageTop(Integer page,Integer rows);
	
	/**
	 * @author 王梦霞
	 * 前10的总点赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	public List<Dispost> selectPostListByTopD(Integer page,Integer rows);
	/**
	 * @author 王梦霞
	 * 前10的总踩赞最多的帖子
	 * @author 王梦霞
	 * @return
	 */
	public List<Dispost> selectPostListByTopC(Integer page,Integer rows);
}
