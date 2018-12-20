package com.cxb.yyc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.yyc.entity.StudentTest;
import com.cxb.yyc.service.StudentTestService;

@RestController
@RequestMapping(value="/studentTest",name="记录学生测试结果")
public class StudentTestController {
	
	@Autowired
	private StudentTestService studentTestService;
	
	/**
	 * 记录学生测试，当学生点击测试提交按钮后，将该学生测试的相关信息存到数据库
	 * 
	 * 
	 * 
	 * 
	 * 同时给学生测试记录表中的外键赋值
	 * http://localhost:3060/YangYiChen/studentTest/insertStudnetTest?studenttestScore=80&studenttestNumber=1&studenttestChapterId=1&studenttestStudentId=1&studenttestDeadlineTime=2018-12-31 12:12:12
	 * @param studentTest
	 * @return
	 */
	@RequestMapping(value="/insertStudnetTest",name="记录学生测试")
	public Object insertStudnetTest(StudentTest studentTest) {
		Map<String, Object> map=new HashMap<String, Object>();
		studentTest.setStudenttestCreateDateTime(new Date());
		StudentTest test=studentTestService.insertStudentTestRecord(studentTest);
		if (test!=null) {
			map.put("success", true);
			map.put("msg", "添加成功");
		}else {
			map.put("success", false);
			map.put("msg", "添加失败");
		}
		return map;
	}
	

}
