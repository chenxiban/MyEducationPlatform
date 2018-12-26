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
	List<Gapfilling> queryGapfilling(Integer chapterId);

	/**
	 * 根据章节Id和课程Id查询填空题的数量
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	int queryGapfillingNumber(Integer chapterId,Integer courseId);

	/**
	 * @Description: 根据章节Id查询对应章节的判断题数目
	 * @ClassName: selectCountByGapfillingChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param chapterId 章节Id
	 * @return
	 */
	int selectCountByGapfillingChapterId(Integer chapterId);
	
	/**
	 * 根据章节Id和课程Id查询填空题问题
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	List<Gapfilling> queryGapfilling(Integer chapterId,Integer courseId);

}
