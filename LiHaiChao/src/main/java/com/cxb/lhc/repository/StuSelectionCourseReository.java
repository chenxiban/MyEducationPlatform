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
      * 学生选课 向选课表中添加一条数据
      * @param courseId
      * @param studentId
      * @return
      */
	@Query(value="INSERT INTO stuselectioncourse(course_id,student_id)VALUE(?1,?2)",nativeQuery=true)
    @Modifying
	Integer saveStucourse(Integer courseId,Integer studentId);
	
	/**
     * 查询改学生是否有学习记录
     * @param courseId
     * @param studentId
     * @return
     */
	@Query(value="SELECT * FROM studentrecord WHERE student_id=?1 AND unit_course_id=?2",nativeQuery=true)
	Integer SelStucourse(Integer courseId,Integer studentId);
	
	/**
     * 学生学习过后，修改学生学习记录表
     * @param courseId
     * @param studentId
     * @return
     */
	@Query(value="UPDATE studentrecord SET student_state=?1,video_exit_time=?2,video_studenting_time=?3 WHERE student_id =?4 AND unit_course_id =?5",nativeQuery=true)
  	@Modifying
	Integer UpStucourse(Integer studentState,Double videoExitTime,Integer videoStudentingTime,Integer studentId,Integer unitCourseId);
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
