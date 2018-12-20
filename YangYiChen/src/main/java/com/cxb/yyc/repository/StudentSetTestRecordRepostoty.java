package com.cxb.yyc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cxb.yyc.entity.StudentTestRecord;

/**
 * 学生做测试题并将测试题和答案存到数据库中
 * @author dell
 *
 */
public interface StudentSetTestRecordRepostoty extends JpaRepository<StudentTestRecord, Integer>{
	
	/**
	 * 根据测试记录的外键（测试的主键）查询
	 * @param studentTestId
	 * @return
	 */
	@Query(value="SELECT * FROM studenttestrecordtb WHERE studenttestrecord_studenttest_id=?1",nativeQuery=true)
	List<StudentTestRecord> queryStudentTestRecord(Integer studentTestId);
	

}
