package com.cxb.yyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cxb.yyc.entity.Option;
/**
 * 教师设置选择题的选项
 * @author dell
 *
 */
public interface TeacherSetOptionRepository extends JpaRepository<Option, Integer>{
	
	/**
	 * 根据选项主键删除选项
	 * @param optionId
	 * @return
	 */
	@Query(value="DELETE FROM optiontb WHERE option_choicequestion_id=?1",nativeQuery=true)
	@Modifying
	int deleteOption(Integer questionId);
	/**
	 * 修改选项，主要修改问题的选项
	 * @param optionId
	 * @param optiona
	 * @param optionb
	 * @param optionc
	 * @param optiond
	 * @return
	 */
	@Query(value="UPDATE optiontb SET optiona=?2,optionb=?3,optionc=?4,optiond=?5 WHERE option_id=?1",nativeQuery=true)
	@Modifying
	int updateOption(Integer optionId,String optiona,String optionb,String optionc,String optiond);
	
	
}
