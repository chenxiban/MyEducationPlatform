package com.cxb.zbq.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.zbq.entity.StudentCredit;

public interface StudentCreditRepository extends JpaRepository<StudentCredit, Integer>{
	
	@Query(value="INSERT INTO student_credit_tb (credit,curriculum_id,student_id)VALUES (?1,?2,?3)",nativeQuery=true)
	@Transactional@Modifying
	int insertStudentCredit(Double credit,Integer currId,Integer stuId);//添加学生学分信息
	
	StudentCredit findByCurriculumIdAndStudentId(Integer curriculumId,Integer studentId);//根据课程id和学生id查询对应学分对象
	
	@Query(value="SELECT SUM(credit) FROM student_credit_tb WHERE student_id=?1",nativeQuery=true)
	double getSumCredit(Integer stuId);//获取该学生总学分
	
	@Query(value="UPDATE student_credit_tb SET credit=?1 WHERE curriculum_id=?2 AND student_id=?3",nativeQuery=true)
	@Transactional@Modifying
	int updateStudentCredit(Double credit,Integer currId,Integer stuId);//修改学生学分信息
	
	List<StudentCredit> findByStudentId(Integer studentId);//根据学生id获取学分对象集合

}
