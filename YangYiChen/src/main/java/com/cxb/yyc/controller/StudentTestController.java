package com.cxb.yyc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.yyc.entity.ChoiceQuestion;
import com.cxb.yyc.entity.Gapfilling;
import com.cxb.yyc.entity.QuestionOption;
import com.cxb.yyc.entity.StudentTest;
import com.cxb.yyc.entity.Tfng;
import com.cxb.yyc.service.StudentTestService;
import com.cxb.yyc.service.TeacherSetChoiceQuestionService;
import com.cxb.yyc.service.TeacherSetGapfillingQuestionService;
import com.cxb.yyc.service.TeacherSetOptionService;
import com.cxb.yyc.service.TeacherSetTfngQuestionService;

@CrossOrigin
@RestController
@RequestMapping(value="/studentTest",name="记录学生测试结果")
public class StudentTestController {
	
	@Autowired
	private StudentTestService studentTestService;
	/**
	 * 教师设置选择题接口
	 */
	@Autowired
	private TeacherSetChoiceQuestionService choiceQuestionService;
	/**
	 * 教师设置选择题选项的接口
	 */
	@Autowired
	private TeacherSetOptionService optionService;
	/**
	 * 填空題接口
	 */
	@Autowired
	private TeacherSetGapfillingQuestionService gapfillingQuestionService;
	/**
	 * 判断题接口
	 */
	@Autowired
	private TeacherSetTfngQuestionService tfngQuestionService;
	
	
	/**
	 * 记录学生测试，当学生点击测试提交按钮后，将该学生测试的相关信息存到数据库
	 * 同时给学生测试记录表中的外键赋值
	 * http://localhost:3060/YangYiChen/studentTest/insertStudnetTest?studenttestScore=80&studenttestNumber=1&studenttestChapterId=1&studenttestStudentId=1&studenttestDeadlineTime=2018-12-31 12:12:12
	 * @param studentTest
	 * @return
	 */
	@PostMapping(value="/insertStudnetTest",name="记录学生测试")
	public Object insertStudnetTest(@RequestBody StudentTest studentTest) {
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
	
	/**
	 * 根据章节ID和课程ID查询学生做的测试题
	 * http://localhost:3060/YangYiChen/studentTest/queryQuestion?chapterId=1&courseId=1
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value="/queryQuestion",name="学生的测试题",method=RequestMethod.GET)
	public Object queryQuestion(@RequestParam(value="chapterId",required=false) Integer chapterId,@RequestParam(value="courseId",required=false) Integer courseId) {
		ArrayList<Object> list=new ArrayList<Object>();
		//选择题、选项集合
		List<QuestionOption> list1=choiceQuestionService.queryChoiceQuestion(chapterId, courseId); 
		list.add(list1);
		//填空题集合
		List<Gapfilling> list2=gapfillingQuestionService.queryGapfilling(chapterId, courseId);
		list.add(list2);
		//判断题集合
		List<Tfng> list3=tfngQuestionService.queryTfng(chapterId, courseId);
		System.out.println(list3);
		list.add(list3);
		return list;
	}
	

}
