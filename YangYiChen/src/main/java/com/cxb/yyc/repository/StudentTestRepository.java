package com.cxb.yyc.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cxb.yyc.entity.StudentTest;

/**
 * 记录学生测试次数
 * @author dell
 *
 */
public interface StudentTestRepository extends JpaRepository<StudentTest, Integer>{
	
	/**
	 * 向学生测试记录表中添加数据
	 * @param courseId
	 * @param chapterId
	 * @param endTime
	 * @param testScore
	 * @param createTime
	 * @return
	 */
	@Query(value="INSERT INTO studenttesttb(studenttest_chapter_id,studenttest_deadline_time,studenttest_score,studenttest_course_id,studenttest_number,studenttest_create_date_time)VALUES(?2,?3,?4,?1,?5,NOW())",nativeQuery=true)
	@Modifying
	int insertStudentTest(Integer courseId,Integer chapterId,String endTime,Integer testScore,Integer num);
	/**
	 * 根据课程Id和章节Id查询该学生已经测试的次数
	 * @param courseId
	 * @param chapterId
	 * @return
	 */
	@Query(value="SELECT MAX(studenttest_number) FROM studenttesttb WHERE studenttest_course_id=?1 AND studenttest_chapter_id=?2 AND studenttest_student_id=?3",nativeQuery=true)
	int queryStudentTestNum(Integer courseId,Integer chapterId,Integer studentId);

}
