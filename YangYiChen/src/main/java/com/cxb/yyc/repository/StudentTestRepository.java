package com.cxb.yyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cxb.yyc.entity.StudentTest;

/**
 * 记录学生测试次数
 * @author dell
 *
 */
public interface StudentTestRepository extends JpaRepository<StudentTest, Integer>{
	

}
