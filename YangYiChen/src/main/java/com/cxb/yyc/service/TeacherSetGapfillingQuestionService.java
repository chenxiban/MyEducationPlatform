package com.cxb.yyc.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.cxb.yyc.entity.Gapfilling;

/**
 * 教师设置填空题
 * @author dell
 *
 */
public interface TeacherSetGapfillingQuestionService{
	
	/**
	 * 教师设置填空题
	 * @param gapfilling
	 * @return
	 */
	Gapfilling insertGapfilling(Gapfilling gapfilling);
	/**
	 * 根据填空题主键删除填空题
	 * @param gapfillingId
	 */
	int deleteGapfilling(Integer gapfillingId);
	/**
	 * 根据主键修改填空题
	 * @param gapfilling
	 * @return
	 */
	int updateGapfillingQuestion(Gapfilling gapfilling);
	/**
	 * 通过章节Id和课程Id查询填空题问题
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	List<Gapfilling> queryGapfilling(Integer chapterId,Integer courseId);


	

}
