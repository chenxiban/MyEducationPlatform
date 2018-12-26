package com.cxb.wmx.service;

import java.util.List;

import com.cxb.wmx.entity.Commitreport;
import com.cxb.wmx.entity.Postreplyreport;

/**
 * 回复举报表service层
 * @author 王梦霞
 *
 */
public interface RrplypostService {

	/**
	 * 根据回复id添加回复举报信息
	 * @author 王梦霞
	 * @param p
	 * @param postreplyId
	 * @return
	 */
	public boolean savePostreply(Postreplyreport p,int postreplyId);
	
	/**
	 * 根据状态查询举报
	 * @param Postreplyreport
	 * @return
	 */
	Integer countPostreplyreport(Integer postreplyreportStuts);
	
	/**
	 * 根据状态查询举报
	 * @param postreportStuts
	 * @return
	 */
	List<Postreplyreport> findByPostreplyreportStuts(Integer postreplyreportStuts);
	
	
	/**
	 * 修改举报信息
	 * @param p
	 * @return
	 */
	boolean updPostreplyreport(Postreplyreport p);
	
}
