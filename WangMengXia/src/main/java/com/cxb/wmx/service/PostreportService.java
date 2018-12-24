package com.cxb.wmx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cxb.wmx.entity.Postreport;

@Service
public interface PostreportService {
	
	/**
	 * 根据状态查询举报
	 * @param postreportStuts
	 * @return
	 */
	Integer countPostreport(Integer postreportStuts);
	
	/**
	 * 根据状态查询举报
	 * @param postreportStuts
	 * @return
	 */
	List<Postreport> findByPostreportStuts(Integer postreportStuts);
	
	/**
	 * 添加举报信息
	 * @param p
	 * @return
	 */
	boolean savePostreport(Postreport p,int postId);
	
	/**
	 * 修改举报信息
	 * @param p
	 * @return
	 */
	boolean updPostreport(Postreport p);
	
}
