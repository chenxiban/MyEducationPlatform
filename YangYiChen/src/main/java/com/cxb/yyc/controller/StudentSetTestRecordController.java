package com.cxb.yyc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.yyc.entity.StudentTestRecord;
import com.cxb.yyc.service.StudentSetTestRecordService;

@RestController
@RequestMapping(value="/studentTestRecord",name="记录学生测试题")
public class StudentSetTestRecordController {
	
	@Autowired
	private StudentSetTestRecordService studentTestRecordService;
	/**
	 * 添加学生测试题及答案
	 * http://localhost:3060/YangYiChen/studentTestRecord/insertStudentTestRecord?studenttestrecordQuestions=大数据的起源是()?&studenttestrecordAnswers=C:谷歌&studenttestrecordCourseId=1&studenttestrecordChapterId=1&studenttestrecordStudentId=1&studenttestrecordStudenttestId=1
	 * @param studentTestRecord
	 * @return
	 */
	@RequestMapping(value="/insertStudentTestRecord",name="添加学生测试题及答案")
	public Object insertStudentTestRecord(StudentTestRecord studentTestRecord) {
		Map<String, Object> map=new HashMap<String, Object>();
		studentTestRecord.setStudenttestrecordCreateDateTime(new Date());
		StudentTestRecord record=studentTestRecordService.insertStudentTestRecord(studentTestRecord);
		if (record!=null) {
			map.put("success", true);
			map.put("msg", "添加成功");
		}else {
			map.put("success", false);
			map.put("msg", "添加失败");
		}
		return map;
	}
	/**
	 * 当点击查看时
	 * 根据测试记录的外键（测试的主键）查询
	 * http://localhost:3060/YangYiChen/studentTestRecord/queryStudentTestRecord?studentTestId=1
	 * http://localhost:3011/yangyichen/YangYiChen/studentTestRecord/queryStudentTestRecord?studentTestId=1
	 * @param studentTestId
	 * @return
	 */
	@RequestMapping(value="/queryStudentTestRecord",name="查看测试")
	public Object queryStudentTestRecord(Integer studentTestId) {
		return studentTestRecordService.queryStudentTestRecord(studentTestId);
	}

}
