package com.cxb.yyc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.yyc.entity.ChoiceQuestion;
import com.cxb.yyc.entity.QuestionOption;
/**
 * 教师录入测试题==》选择题
 * @author dell
 *
 */
public interface TeacherSetChoiceQuestionRepository extends JpaRepository<ChoiceQuestion, Integer>{
	
	/**
	 * 根据问题Id主键删除问题
	 * @param questionId
	 * @return
	 */
	@Query(value="DELETE FROM choicequestiontb WHERE choicequestion_id=?1",nativeQuery=true)
	@Modifying
	int deleteChoiceQuestion(Integer questionId);
	
	/**
	 * 根据问题主键可修改选择问题
	 * @param choicequestion_id
	 * @param choicequestion_imgurl 问题图片
	 * @param choicequestion_question 问题
	 * @param choicequestion_score 每道选择问题的分数
	 * @param choicequestiontb_issingleselection 问题的类型
	 * @return
	 */
	@Query(value="UPDATE choicequestiontb SET choicequestion_imgurl=?2,choicequestion_question=?3,choicequestion_score=?4,choicequestiontb_issingleselection=?5 WHERE choicequestion_id=?1",nativeQuery=true)
	@Modifying
	int updateChoiceQuestion(Integer choicequestion_id,String choicequestion_imgurl,String choicequestion_question,Integer choicequestion_score,Integer choicequestiontb_issingleselection);
	/**
	 * 根据章节Id和课程Id查询问题及选项
	 * 使用自定义工具类转换时原生SQL结果集与实体类只需要字段顺序一致即可.不需要字段名称一致
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	@Query(value="SELECT a.choicequestiontb_issingleselection as otherState,a.choicequestion_question as otherQuestion,a.choicequestion_score as otherScore,a.choicequestion_imgurl as otherImgurl,a.choicequestion_course_id as otherCourseId,a.choicequestion_chapter_id as otherChapterId,\r\n"
			+ "b.optiona as otherA,b.optionb as otherB,b.optionc as otherC,b.optiond as otherD FROM choicequestiontb a,optiontb b WHERE a.choicequestion_id=b.option_choicequestion_id AND a.choicequestion_course_id=:courseId AND a.choicequestion_chapter_id=:chapterId",nativeQuery=true)
	List<QuestionOption> queryChoiceQuestion(@Param("chapterId")Integer chapterId,@Param("courseId")Integer courseId);
	/**
	 * 根据章节Id和课程Id查询选择题问题
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	@Query(value="SELECT * FROM choicequestiontb WHERE choicequestion_chapter_id=?1 AND choicequestion_course_id=?2",nativeQuery=true)
	List<ChoiceQuestion> queryChoiceQuestions(Integer chapterId,Integer courseId);
}
