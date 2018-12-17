package com.cxb.lhc.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.lhc.entity.StuCourseComment;
import com.cxb.lhc.entity.queryCountAndAvgState;

/**
 * 
 * @Description: 学生对所选课程进行评价
 * @ClassName: StuCourseCommentRepository
 * @author liu
 * @Date 2018年12月10日 下午9:37:42
 * @Email 1273822019@qq.com
 */
public interface StuCourseCommentRepository extends JpaRepository<StuCourseComment, Integer> {
	/**
	 * 根据课程id 分页查询出该课程下所有的学生评价信息
	 * 
	 * @param courseId
	 * @param page
	 * @param size
	 * @return
	 */
	Page<StuCourseComment> findByCourseId(Integer courseId, Pageable pageable);

	
	/**
	 * 根据课程id 该课程的评价总条数
	 * 
	 * @param courseId
	 * @return
	 */
	@Query(value = "SELECT COUNT(student_id) FROM stucoursecomment WHERE course_id=?1", nativeQuery = true)
	Integer queryCountNum(Integer courseId);

	/**
	 * 根据课程id 
	 * 查询出该课程的平均评价星级
	 * @param courseId
	 * @return
	 */
	@Query(value = "SELECT AVG(comment_start) FROM stucoursecomment WHERE course_id=?1", nativeQuery = true)
	double queryCommentStart(Integer courseId);

	/**
	 * 学生评价课程 向课程评价表中添加一条数据
	 * 
	 * @param commentContext
	 * @param commentStart
	 * @param courseCount
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	@Query(value = "INSERT INTO stucoursecomment(comment_context,comment_start,comment_time,course_id,student_id) VALUES(?1,?2,?3,?4,?5)", nativeQuery = true)
	@Modifying
	Integer saveStuCourseComment(String commentContext, Integer commentStart, Date commentTime, Integer courseId,
			Integer studentId);

	/**
	 * 学生根据评价id(主键) 对其课程评价进行编辑
	 * 
	 * @param commentContext
	 * @param commentStart
	 * @param commentId
	 * @return
	 */
	@Query(value = "UPDATE stucoursecomment SET comment_context=:commentContext,comment_start=:commentStart  WHERE comment_id=:commentId", nativeQuery = true)
	@Modifying
	Integer upDateStuCourseComment(@Param("commentContext") String commentContext,
			@Param("commentStart") Integer commentStart, @Param("commentId") Integer commentId);

	/**
	 * 1.删除自己评价之前要先查询评价下是否有赞
	 * 
	 * @param commentId
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM stugivepraise WHERE comment_id=?1", nativeQuery = true)

	Integer queryCoursePraiseByCommentId(Integer commentId);

	/**
	 * 2.有赞或踩的话先删除
	 * 
	 * @param commentId
	 * @return
	 */
	@Query(value = "DELETE FROM stugivepraise WHERE comment_id=?1", nativeQuery = true)
	@Modifying
	Integer delCoursePraiseByCommentId(Integer commentId);

	/**
	 * 3.根据评价id(主键) 删除自己的评价
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	@Query(value = "DELETE FROM stucoursecomment WHERE comment_id=?1", nativeQuery = true)
	@Modifying
	Integer delStuCourseComment(Integer commentId);

}
