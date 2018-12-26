package com.cxb.lhc.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxb.lhc.entity.StuCourseComment;

import com.cxb.lhc.repository.StuCourseCommentRepository;
import com.cxb.lhc.service.StuCourseCommentClient;
import com.cxb.lhc.service.StuCourseCommentService;
/**
 * 
 * @Description:   学生对所选课程进行评价
 * @ClassName:     StuCourseCommentServiceImpl
 * @author         liu
 * @Date           2018年12月10日 下午9:37:42
 * @Email          1273822019@qq.com
 */
@Service
public class StuCourseCommentServiceImpl implements StuCourseCommentService{

	@Autowired
	private StuCourseCommentRepository stuCommentRepository;
	
	
	@Autowired
	private StuCourseCommentClient stuCourseCommentClient;
	
	
	
	/**
	 * 根据课程id
	 * 分页查询出该课程下所有的学生评价信息
	 * @param courseId
	 * @param page
	 * @param size
	 * @return
	 */
public Page<StuCourseComment> findByCourseId(Integer courseId,Pageable pageable){
	
		return stuCommentRepository.findByCourseId(courseId, pageable);
	};
		
	/**
	 * 根据课程id查询出
	 * 订阅该课程的所有学生id集合
	 * @param courseId
	 * @return
	 */

public	List<Integer> selStudentIdByCourseId(Integer courseId){
	return stuCommentRepository.selStudentIdByCourseId(courseId);
};
		
	
	/**
	 * 根据课程id
	 * 该课程的评价总条数
	 * @param courseId
	 * @return
	 */
 public	Integer queryCountNum(Integer courseId) {
	 return stuCommentRepository.queryCountNum(courseId);
 };
	
 /**
	 * 根据课程id 
	 * 查询出该课程的平均评价星级
	 * @param courseId
	 * @return
	 */
public double queryCommentStart(Integer courseId) {
	return stuCommentRepository.queryCommentStart(courseId);
};
	

/**
 * 根据评价id查询出评价对象
 * @param commentId
 * @return
 */

public StuCourseComment queryStuCourseCommentByCommentId(Integer commentId) {
	return stuCommentRepository.queryStuCourseCommentByCommentId(commentId);
};





	/**学生对自己所选课程进行评价
	 * 向学生评价表中添加一条数据
	 * @param commentContext
	 * @param commentStart
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	@Override
	public StuCourseComment saveStuCourseComment(StuCourseComment stuCourseComment) {
		
		return stuCommentRepository.save(stuCourseComment);
	}
	/**
	 * 学生根据评价id(主键)
	 * 对其课程评价进行编辑
	 * @param commentContext
	 * @param commentStart
	 * @param commentId
	 * @return
	 */
	@Override
	public Integer upDateStuCourseComment(String commentContext,Integer commentStart,Integer commentId) {
		
		return stuCommentRepository.upDateStuCourseComment(commentContext, commentStart,commentId);
	}

	/**
	 * 1.删除自己评价之前要先查询评价下是否有赞
	 * @param commentId
	 * @return
	 */
	
public	Integer queryCoursePraiseByCommentId(Integer commentId) {
		return stuCommentRepository.queryCoursePraiseByCommentId(commentId);
	};
	/**
	 * 2.有赞或踩的话先删除
	 * @param commentId
	 * @return
	 */
	
public	Integer delCoursePraiseByCommentId(Integer commentId) {
	return stuCommentRepository.delCoursePraiseByCommentId(commentId);
};
	
	/**3.根据评价id(主键)
	 * 删除自己的评价 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	
public	Integer delStuCourseComment(Integer commentId) {
		return stuCommentRepository.delStuCourseComment(commentId);
	};
	/**
	 * 调用小米组的方法 
	 * 根据老师id查询出该门课的老师信息
	 * @param teacherId
	 * @return
	 */	
public 	Object queryTeacherByTeacherId(Integer teacherId) {
	return stuCourseCommentClient.queryTeacherByTeacherId(teacherId);
};
}
