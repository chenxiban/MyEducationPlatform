package com.cxb.yyc.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.cxb.yyc.entity.Tfng;

/**
 * 教师设置判断题
 * @author dell
 *
 */
public interface TeacherSetTfngQuestionService{
	
	/**
	 * 教师添加判断题问题
	 * @param tfng
	 * @return
	 */
	Tfng insertTfng(Tfng tfng);
	/**
	 * 根据判断题主键删除判断题
	 * @param tfngId
	 */
	int deleteTfng(Integer tfngId);
	/**
	 * 根据问题主键修改问题
	 * @param tfng
	 * @return
	 */
	int updateTfng(Tfng tfng);
	/**
	 * 根据章节Id和课程Id查询判断题问题
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	List<Tfng> queryTfng(Integer chapterId);

	/**
	 * 根据章节Id和课程Id查询判断题的数量
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	int queryTfngNumber(Integer chapterId,Integer courseId);
	
	/**
	 * @Description: 根据章节Id查询对应章节的判断题数目
	 * @ClassName: selectCountByTfngChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param chapterId
	 * @return
	 */
	int selectCountByTfngChapterId(Integer chapterId);

	/**
	 * 根据章节Id和课程Id查询判断题问题
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	List<Tfng> queryTfng(Integer chapterId,Integer courseId);
}
