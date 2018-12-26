package com.cxb.lhc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.lhc.entity.StuCourseComment;



/**
 * 
 * @Description:   学生对所选课程进行评价
 * @ClassName:     StuCourseCommentService
 * @author         liu
 * @Date           2018年12月10日 下午9:37:42
 * @Email          1273822019@qq.com
 */

public interface StuCourseCommentService {
	/**
	 * 根据课程id
	 * 分页查询出该课程下所有的学生评价信息
	 * @param courseId
	 * @param page
	 * @param size
	 * @return
	 */
	Page<StuCourseComment> findByCourseId(Integer courseId,Pageable pageable);
	
	/**
	 * 2.根据课程id查询出
	 * 订阅该课程的所有学生id集合
	 * @param courseId
	 * @return
	 */

	List<Integer> selStudentIdByCourseId(Integer courseId);
	
	
	/**
	 * 根据课程id
	 * 该课程的评价总条数
	 * @param courseId
	 * @return
	 */
	Integer queryCountNum(Integer courseId);
	/**
	 * 根据课程id 
	 * 查询出该课程的平均评价星级
	 * @param courseId
	 * @return
	 */
	double queryCommentStart(Integer courseId);
	
	
	/**
	 * 根据评价id查询出评价对象
	 * @param commentId
	 * @return
	 */
	
	StuCourseComment queryStuCourseCommentByCommentId(Integer commentId);
	
	
	
	
	/**
	 * 向学生评价表中添加一条数据
	 * @param commentContext
	 * @param commentStart
	 * @param courseCount
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	
	StuCourseComment saveStuCourseComment(StuCourseComment stuCourseComment);
		
	/**
	 * 学生根据评价id(主键)
	 * 对其课程评价进行编辑
	 * @param commentContext
	 * @param commentStart
	 * @param commentId
	 * @return
	 */
	
	@Transactional
	Integer upDateStuCourseComment(String commentContext,Integer commentStart,Integer commentId);
		
	/**
	 * 1.删除自己评价之前要先查询评价下是否有赞
	 * @param commentId
	 * @return
	 */
	@Transactional
	Integer queryCoursePraiseByCommentId(Integer commentId);
	/**
	 * 2.有赞或踩的话先删除
	 * @param commentId
	 * @return
	 */
	@Transactional
	Integer delCoursePraiseByCommentId(Integer commentId);
	/**3.根据评价id(主键)
	 * 删除自己的评价 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	@Transactional
	Integer delStuCourseComment(Integer commentId);
	
}
