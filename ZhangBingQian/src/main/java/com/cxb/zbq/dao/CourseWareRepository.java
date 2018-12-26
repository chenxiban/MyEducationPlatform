package com.cxb.zbq.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.zbq.entity.CourseWare;

public interface CourseWareRepository extends JpaRepository<CourseWare, String>{
    List<CourseWare> findByClassHourId(Integer classHourId);//根据课时id获取所有课件信息
    
    @Query(value="DELETE FROM course_ware_tb WHERE course_ware_id=?1",nativeQuery=true)
    @Transactional@Modifying
    int deleteCourseWare(Integer cId);//根据课件id删除课件信息
    @Query(value="update CourseWare c set c.coursewareDescription=?2 where c.courseWareId=?1")
    @Transactional
    @Modifying
    int updateCourseWare(String courseWareId,String coursewareDescription);//根据课件id,修改课件信息
}
