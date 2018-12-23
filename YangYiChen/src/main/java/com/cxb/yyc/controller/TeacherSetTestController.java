package com.cxb.yyc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cxb.yyc.entity.TeacherCreateTest;
import com.cxb.yyc.service.TeacherSetChoiceQuestionService;
import com.cxb.yyc.service.TeacherSetGapfillingQuestionService;
import com.cxb.yyc.service.TeacherSetTestService;
import com.cxb.yyc.service.TeacherSetTfngQuestionService;

@RestController
@RequestMapping(value="/teacherTest",name="发起测试")
@CrossOrigin
public class TeacherSetTestController {
	/**
	 * 教师测试业务实现类接口
	 */
	@Autowired
	private TeacherSetTestService testService;
	
	@Autowired
	private TeacherSetChoiceQuestionService teacherSetChoiceQuestionService;
	
	@Autowired
	private TeacherSetTfngQuestionService teacherSetTfngQuestionService;
	
	@Autowired
	private TeacherSetGapfillingQuestionService teacherSetGapfillingQuestionService;
	/**
	 * 教师发起测试
	 * http://localhost:3060/YangYiChen/teacherTest/insertTeacherCreateTest?teachercratetestChoicenum=2&teachercratetestTestname=第一次章节测试 &teachercreatetestTesttime=30min&teachercreatetestEndtime=2019-01-12 00:00:00&teachercreatetestNumber=3&teachercratetestRandom=是&teachercreatetestExplain=测试学生对之前内容的掌握程度&teachercreatetestChapterId=1&teachercreatetestTeacherId=1
	 * @param teacherCreateTest
	 * @return
	 */
	@RequestMapping(value="/insertTeacherCreateTest",name="教师发起测试",method=RequestMethod.POST)
	public Object insertTeacherCreateTest(@RequestBody TeacherCreateTest teacherCreateTest) {
		Map<String, Object> map = new HashMap<String, Object>();
		teacherCreateTest.setTeachercratetestState(0);
		if (testService.insertTeacherCreateTest(teacherCreateTest)!=null) {
			map.put("success", true);
			map.put("msg", "添加成功");
		}else {
			map.put("success", false);
			map.put("msg", "添加失败");
		}
		return map;
	}
	/**
	 * 根据教师Id查询教师发起的测试
	 * http://localhost:3060/YangYiChen/teacherTest/queryTeacherCreateTest?teacherId=1
	 * http://localhost:3011/yangyichen/YangYiChen/teacherTest/queryTeacherCreateTest?teacherId=1
	 * @param teacherId
	 * @return
	 */
	@RequestMapping(value="/queryTeacherCreateTest",name="教师查询测试",method=RequestMethod.GET)
	public Object queryTeacherCreateTest(Integer teacherId) {
		return testService.queryTeacherCreateTest(teacherId);
	}
	
	/**
	 * 根据教师发布测试主键发布测试
	 * http://localhost:3060/YangYiChen/teacherTest/updateTeacherCreateTestState?testId=24&state=0
	 * http://localhost:3011/yangyichen/YangYiChen/teacherTest/updateTeacherCreateTestState?testId=1&state=1
	 * @param testId
	 * @param state
	 * @return
	 */
	@RequestMapping(value="/updateTeacherCreateTestState",name="发布测试",method=RequestMethod.PUT)
	public Object updateTeacherCreateTestState(@RequestParam(value="testId",required=false)Integer testId,@RequestParam(value="state",required=false)Integer state) {
			Map<String, Object> map=new HashMap<String, Object>();
			if (state==0) {
				if (testService.updateTeacherCreateTestState(testId)>0) {
					map.put("success", true);
					map.put("msg", "该测试发布成功");
				}else {
					map.put("success", false);
					map.put("msg", "该测试发布失败");
				}
			}else{
				map.put("success", false);
				map.put("msg", "该测试您已经发布成功，请勿重复操作");
			}
			return map;
	}
	/**
	 * 根据教师发布测试主键取消测试
	 * http://localhost:3060/YangYiChen/teacherTest/updateTeacherCreateTestState?testId=24&state=1
	 * http://localhost:3011/yangyichen/YangYiChen/teacherTest/updateTeacherCreateTestStateForZero?testId=1&state=1
	 * @param testId
	 * @param state
	 * @return
	 */
	@RequestMapping(value="/updateTeacherCreateTestStateForZero",name="取消发布",method=RequestMethod.PUT)
	public Object updateTeacherCreateTestStateForZero(@RequestParam(value="testId",required=false)Integer testId,@RequestParam(value="state",required=false)Integer state) {
			Map<String, Object> map=new HashMap<String, Object>();
			if (state==1) {
				if (testService.updateTeacherCreateTestStateForZero(testId)>0) {
					map.put("success", true);
					map.put("msg", "该测试取消发布成功");
				}else {
					map.put("success", false);
					map.put("msg", "该测试取消发布失败");
				}
			}else{
				map.put("success", false);
				map.put("msg", "该测试您已经取消发布，请勿重复操作");
			}
			return map;
	}
	
	/**
	 * 在main.html页面当中教师删除创建的测试题
	 * http://localhost:3060/YangYiChen/teacherTest/deleteTest?testId=1
	 * @param testId
	 * @return
	 */
	@RequestMapping(value="/deleteTest",name="删除自己创建的测试题",method=RequestMethod.DELETE)
	public Object deleteTest(@RequestParam(value="testId",required=false) Integer testId) {
		Map<String, Object> map=new HashMap<String, Object>();
		int chapterId=testService.selectByTestIdForChapterId(testId);
		int n1=teacherSetChoiceQuestionService.selectCountByChoiceChapterId(chapterId);
		int n2=teacherSetTfngQuestionService.selectCountByTfngChapterId(chapterId);
		int n3=teacherSetGapfillingQuestionService.selectCountByGapfillingChapterId(chapterId);
		if (n1==0&&n2==0&&n3==0) {
			if (testService.deleteTest(testId)>0) {
				map.put("success", true);
				map.put("msg", "删除成功！");
			}else {
				map.put("success", false);
				map.put("msg", "删除失败！");
			}
		}else {
			map.put("success", false);
			map.put("msg", "该测试题下还有题型未删除完，请先删除所有题型！");
		}
		return map;
		
	}
	

}
