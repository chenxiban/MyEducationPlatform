package com.cxb.lhc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.lhc.entity.StuCourseComment;
import com.cxb.lhc.entity.StuGivePraise;

/**
 * 
 * @Description:   学生对所选课程评价进行点/踩赞
 * @ClassName:     StuGivePraiseService
 * @author         liu
 * @Date           2018年12月10日 下午9:37:42
 * @Email          1273822019@qq.com
 */
		
public interface StuGivePraiseService {
	/**
	 * 点/取消赞或踩/取消赞
	 * 都要先根据学生id和评价id判断该学生对该评价
	 * 是否点过赞踩过赞
	 * @param commentId
	 * @param StudentId
	 * @return
	 */
	
	StuGivePraise queryGiveParisByStuIdAndCommId(Integer commentId,Integer studentId);

	/**
	 *  给课程评价进行点赞 
	 *  向点赞表中添加一条数据
	 * @param commentId
	 * @param givePraiseState
	 * @param notPraiseState
	 * @param studentId
	 * @param stucoursecomment_stugivepraise_id
	 * @return
	 */
	@Transactional
	 Integer saveStuGivePraise(Integer givePraiseState,Integer studentId,Integer commentId);
	/**
	  *根据学生id和评价id
	 * 取消对该评价的点赞
	 * @param studentId
	 * @param commentId
	 * @param givePraiseState
	 * @return
	 */
	@Transactional
	Integer updPariseState(Integer studentId,Integer commentId,Integer givePraiseState);
	/**
	 * 根据学生id和评价id
	 * 对该评价进行点赞
	 * @param studentId
	 * @param commentId
	 * @param givePraiseState
	 * @return
	 */
	@Transactional
	Integer updGivePariseState(Integer studentId,Integer commentId,Integer givePraiseState);
	

	/**
	  *根据学生id和评价id
	 * 取消对该评价的踩赞
	 * @param studentId
	 * @param commentId
	 * @param givePraiseState
	 * @return
	 */
	@Transactional
	Integer updNoState(Integer studentId,Integer commentId,Integer notPraiseState);
	
	/**
	 * 根据学生id和评价id
	 * 对该评价进行踩赞
	 * @param studentId
	 * @param commentId
	 * @param givePraiseState
	 * @return
	 */
	@Transactional
	Integer updNoPariseState(Integer studentId,Integer commentId,Integer notPraiseState);
	
	
	
	
	
	
	}
		
	