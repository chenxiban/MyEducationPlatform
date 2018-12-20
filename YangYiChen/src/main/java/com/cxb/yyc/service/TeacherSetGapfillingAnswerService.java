package com.cxb.yyc.service;

import com.cxb.yyc.entity.GapfillingAnswer;

/**
 * 教师设置填空题答案
 * @author dell
 *
 */
public interface TeacherSetGapfillingAnswerService{
	
	/**
	 * 教师添加填空题答案
	 * @param gapfillingAnswer
	 * @return
	 */
	GapfillingAnswer insertGapfillingAnswer(GapfillingAnswer gapfillingAnswer);
	/**
	 * 根据答案外键（填空题主键)删除答案
	 * @param gapfillingId
	 */
	int deleteGapfillingAnswer(Integer gapfillingAnswerId);
	/**
	 * 根据填空题主键修改该问题的答案
	 * @param gapfillingAnswer
	 * @param gapfillingId 填空题主键
	 * @return
	 */
	int updateGapfillingAnswer(GapfillingAnswer gapfillingAnswer);

}
