package com.cxb.yyc.service;

import org.springframework.data.repository.query.Param;

import com.cxb.yyc.entity.TfngAnswer;

/**
 * 教师设置判断题答案
 * @author dell
 *
 */
public interface TeacherSetTfngAnswerService{

	/**
	 * 教师添加判断题答案
	 * @param tfngAnswer
	 * @return
	 */
	TfngAnswer insertTfngAnswer(TfngAnswer tfngAnswer);
	/**
	 * 根据判断题主键删除判断题
	 * @param tfngId
	 */
	int deleteTfngAnswer(Integer tfngAnswerId);
	/**
	 * 根据判断题答案主键修改答案
	 * @param tfngAnswer
	 * @return
	 */
	int updateTfngAnswer(TfngAnswer tfngAnswer);

}
