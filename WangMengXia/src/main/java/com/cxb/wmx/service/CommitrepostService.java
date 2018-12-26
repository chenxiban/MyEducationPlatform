package com.cxb.wmx.service;

import java.util.List;

import com.cxb.wmx.entity.Commitreport;

/**
 * 评论举报表
 * @author 王梦霞
 *
 */
public interface CommitrepostService {

	/**
	 * 根据评论id添加评论举报信息
	 * @author 王梦霞
	 * @param c
	 * @param postcommitId
	 * @return
	 */
	public boolean saveComreport(Commitreport c,int postcommitId);
	/**
	 * 根据状态查询举报
	 * @param postreportStuts
	 * @return
	 */
	Integer countCommitreport(Integer commitreportStuts);
	
	/**
	 * 根据状态查询举报
	 * @param postreportStuts
	 * @return
	 */
	List<Commitreport> findByCommitreportStuts(Integer commitreportStuts);
	
	
	/**
	 * 修改举报信息
	 * @param p
	 * @return
	 */
	boolean updCommitreport(Commitreport c);
}
