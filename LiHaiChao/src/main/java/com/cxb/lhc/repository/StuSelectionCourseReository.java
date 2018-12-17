package com.cxb.lhc.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.lhc.entity.StuSelectionCourse;

/**
 * 
 * @Description:   学生进行选课操作的Dao接口
 * @ClassName:     StuSelectionCourseReository
 * @author         liu
 * @Date           2018年12月14日 下午16:43
 * @Email          1273822019@qq.com
 */

public interface StuSelectionCourseReository extends JpaRepository<StuSelectionCourse, Integer>{ 
	
	/**
	 * 
	 * 获取首页点击课程服务
	 * 根据课程ID获取课程信息
	 * @param courseId
	 * @return 
	 */
	Object getCourseByCourseId(Integer courseId);
	
	
	/**
      * 学生选课 向选课表中添加一条数据
      * @param courseId
      * @param studentId
      * @return
      */
	@Query(value="INSERT INTO stuselectioncourse(course_id,student_id)VALUE(?1,?2)",nativeQuery=true)
    @Modifying
	Integer saveStucourse(Integer courseId,Integer studentId);
	/**
	 * 学生在个人中心进行退课操作
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	@Query(value="DELETE FROM stuselectioncourse WHERE course_id=?1 AND student_id=?2",nativeQuery=true)
	@Modifying
	Integer delStuCourseByStuCourseId(Integer courseId,Integer studentId);
	
	

}
