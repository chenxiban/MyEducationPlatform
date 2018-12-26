package com.cxb.yyc.service;


import java.util.List;

import org.springframework.data.repository.query.Param;

import com.cxb.yyc.entity.ChoiceQuestion;
import com.cxb.yyc.entity.QuestionOption;
/**
 * 教师录入测试题==》选择题
 * @author dell
 *
 */
public interface TeacherSetChoiceQuestionService {
	
	/**
	 * 教师添加一道选择题
	 * @param choiceQuestion
	 * @return
	 */
	ChoiceQuestion insertChoiceQuestion(ChoiceQuestion choiceQuestion);

	/**
	 * 根据问题主键删除问题
	 * @param questionId
	 */
	int deleteChoiceQuestion(Integer questionId);
	/**
	 * 根据问题主键修改问题
	 * @param choicequestion_id
	 * @param choicequestion_imgurl 问题图片
	 * @param choicequestion_question 问题
	 * @param choicequestion_score每道题分数
	 * @param choicequestiontb_issingleselection 问题类型
	 * @return
	 */
	int updateChoiceQuestion(Integer choicequestion_id,String choicequestion_imgurl,String choicequestion_question,Integer choicequestion_score,Integer choicequestiontb_issingleselection);
	/**
	 * 查询问题和选项，需要根据章节id和课程id
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	public List<QuestionOption> queryChoiceQuestion(Integer chapterId);
	/**
	 * 根据章节Id和课程Id查询选择题问题
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	List<ChoiceQuestion> queryChoiceQuestions(Integer chapterId,Integer courseId);
	
	/**
	 * 根据章节Id和课程Id查询选择题的数量
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	int queryChoiceQuestionNumber(Integer chapterId,Integer courseId);

	/**
	 * @Description: 根据章节Id查询对应章节的选择题数目
	 * @ClassName: selectCountByChoiceChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param chapterId
	 * @return
	 */
	int selectCountByChoiceChapterId(Integer chapterId);
	
	/**
	 * 根据章节Id和课程Id查询问题及选项
	 * 使用自定义工具类转换时原生SQL结果集与实体类只需要字段顺序一致即可.不需要字段名称一致
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	List<QuestionOption> queryChoiceQuestion(Integer chapterId,Integer courseId);

}
