package com.cxb.yyc.service;

import com.cxb.yyc.entity.Option;

/**
 * 教师设置选择题的选项
 * @author dell
 *
 */
public interface TeacherSetOptionService{
	/**
	 * 教师设置选择题的选项
	 * @param option
	 * @return
	 */
	Option insertOption(Option option);
	/**
	 * 根据问题主键，删除问题的所有选项
	 * @param questionId
	 */
	int deleteOption(Integer questionId);
	/**
	 * 根据选项主键修改问题选项
	 * @param optionId
	 * @param optiona
	 * @param optionb
	 * @param optionc
	 * @param optiond
	 * @return
	 */
	int updateOption(Integer optionId,String optiona,String optionb,String optionc,String optiond);
	
}
