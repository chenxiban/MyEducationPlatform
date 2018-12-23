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
import org.w3c.dom.ls.LSInput;

import com.alibaba.fastjson.JSONObject;
import com.cxb.yyc.entity.ChoiceQuestion;
import com.cxb.yyc.entity.StudentTestRecord;
import com.cxb.yyc.service.StudentSetTestRecordService;
import com.cxb.yyc.service.TeacherSetChoiceQuestionAnswerService;
import com.cxb.yyc.service.TeacherSetGapfillingAnswerService;
import com.cxb.yyc.service.TeacherSetTestService;
import com.cxb.yyc.service.TeacherSetTfngAnswerService;
import com.mysql.fabric.xmlrpc.base.Array;

@CrossOrigin
@RestController
@RequestMapping(value = "/studentTestRecord", name = "记录学生测试题")
public class StudentSetTestRecordController {

	@Autowired
	private StudentSetTestRecordService studentTestRecordService;
	// 选择题问题答案接口
	@Autowired
	private TeacherSetChoiceQuestionAnswerService choiceAnswerService;
	// 判断题答案接口
	@Autowired
	private TeacherSetTfngAnswerService tfngAnswerService;
	// 填空题答案接口
	@Autowired
	private TeacherSetGapfillingAnswerService gapfillingAnswerService;

	/**
	 * 添加学生测试题及答案
	 * http://localhost:3060/YangYiChen/studentTestRecord/insertStudentTestRecord
	 * ?studenttestrecordQuestions=大数据的起源是()? &studenttestrecordAnswers=C:谷歌
	 * &studenttestrecordCourseId=1 &studenttestrecordChapterId=1
	 * &studenttestrecordStudentId=1 &studenttestrecordStudenttestId=1
	 *
	 * @param studentTestRecord
	 * @param choice            单选、判断题、答案及分数
	 * @param twinchoice        多选、答案及分数
	 * @param                   gap填空题、答案
	 * @param gapScore          填空题分数
	 * @param twinScore         多选题分数
	 * @return
	 */
	@RequestMapping(value = "/insertStudentTestRecord", name = "添加学生做的测试题及答案",method=RequestMethod.POST)
	public Object insertStudentTestRecord(@RequestParam(value = "choice", required = false) String choice,
			@RequestParam(value = "twinchoice", required = false) String twinchoice,
			@RequestParam(value = "gap", required = false) String gap,
			@RequestParam(value = "twinScore", required = false) Integer twinScore,
			@RequestParam(value = "tfng", required = false) String tfng) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("11111111>>>>" + choice);
		System.out.println("66666===>" + tfng);
		System.out.println("2222>>>>>" + twinchoice);
		System.out.println("3333>>>>" + gap);
//------------------------------------------------------------
		// 单选题的处理
		String regex = "^,*|,*$";
		Integer sum = 0;// 总分
		Integer sumScore = 0;// 单选分数
		Integer sumScore1 = 0;// 判断分数
		Integer sumScore2 = 0;// 填空分数
		Integer sumScore3 = 0;// 多选分数

		if (choice != null && choice != "" && !"".equals(choice)) {
			String choice1 = choice.replaceAll(regex, "");
			String[] questions = choice1.split("==");// 每道选择题
			for (int i = 0; i < questions.length; i++) {
				String[] choices = questions[i].split("。");// 选择题的选项、问题、分数
				String choiceQuestion = null;// 选择题问题
				Integer choiceScore = 0;// 选择题分数
				String choiceOption = null;// 选择题选项
				for (int j = 0; j < choices.length; j++) {
					choiceOption = choices[0].replaceAll(regex, "");// 单选题的选项
					choiceQuestion = choices[1];// 单选题的问题
					choiceScore = Integer.parseInt(choices[2]);// 单选题的分数
				}
				StudentTestRecord record = new StudentTestRecord();
				record.setStudenttestrecordCreateDateTime(new Date());
				record.setStudenttestrecordQuestions(choiceQuestion);
				record.setStudenttestrecordAnswers(choiceOption);
				record.setStudenttestrecordCourseId(1);
				record.setStudenttestrecordChapterId(1);
				record.setStudenttestrecordStudentId(1);
				record.setStudenttestrecordStudenttestId(1);
				if (studentTestRecordService.insertStudentTestRecord(record) != null) {
					List<String> answer = choiceAnswerService.queryChoiceQuestionAnswer(choiceQuestion);
					for (int j = 0; j < answer.size(); j++) {
						String an = answer.get(j);
						if (an.equals(choiceOption)) {
							sumScore += choiceScore;
						} else {
							sumScore += 0;
						}
					}

					// map.put("sumScore", sumScore);
				} else {
					// map.put("success", false);
					// map.put("msg", "添加失败");
				}
			}
		}
		// --------------------------------------------------------------------
		// 判断题的处理
		if (tfng != null && !"".equals(tfng)) {
			String tfng1 = tfng.replaceAll(regex, "");// 去掉开始的','
			String[] tfngs = tfng1.split("==");// 获取整个判断题
			for (int i = 0; i < tfngs.length; i++) {
				String[] singTfng = tfngs[i].split("。");// 获取一个判断题的答案、问题、选项
				String tfngQuestion = null;
				// String tfngAnswers=null;
				String tfngAnswer = null;
				Integer tfngScore = 0;
				for (int j = 0; j < singTfng.length; j++) {
					tfngAnswer = singTfng[0].replaceAll(regex, "");// 判断题的答案
					tfngQuestion = singTfng[1];// 判断题的问题
					tfngScore = Integer.parseInt(singTfng[2]);// 判断题的分数
				}
				StudentTestRecord record1 = new StudentTestRecord();
				record1.setStudenttestrecordCreateDateTime(new Date());
				record1.setStudenttestrecordQuestions(tfngQuestion);
				record1.setStudenttestrecordAnswers(tfngAnswer);
				record1.setStudenttestrecordCourseId(1);
				record1.setStudenttestrecordChapterId(1);
				record1.setStudenttestrecordStudentId(1);
				record1.setStudenttestrecordStudenttestId(1);
				if (studentTestRecordService.insertStudentTestRecord(record1) != null) {
					String tfngTrueAnswer = tfngAnswerService.queryTfngAnswer(tfngQuestion);
					if (tfngTrueAnswer.equals(tfngAnswer)) {
						sumScore1 += tfngScore;
					} else {
						sumScore1 += 0;
					}
					// map.put("sumScore", sumScore);
				} else {
					// map.put("success", false);
				}
				System.out.println("判断问题=>" + tfngQuestion + "答案=>" + tfngAnswer + "分数=>" + tfngScore);
			}
		}
//-------------------------------------------------------------------------
		// 填空题处理
		if (gap != null && !"".equals(gap)) {
			String gap1 = gap.replaceAll(regex, "");// 去掉开始的逗号
			String gaps[] = gap1.split("==");// 获取所有填空题对象

			for (int i = 0; i < gaps.length; i++) {
				String[] gap2 = gaps[i].split("。");// 获取其中一个问题、答案、分数
				String gapAnswer = null;
				String gapQuestion = null;
				Integer gapScore = 0;
				for (int j = 0; j < gap2.length; j++) {
					gapAnswer = gap2[0].replaceAll(regex, "");// 填空题填写的答案
					gapQuestion = gap2[1];// 填空题问题
					gapScore = Integer.parseInt(gap2[2]);// 填空题分数
				}
				StudentTestRecord record2 = new StudentTestRecord();
				record2.setStudenttestrecordCreateDateTime(new Date());
				record2.setStudenttestrecordAnswers(gapAnswer);
				record2.setStudenttestrecordQuestions(gapQuestion);
				record2.setStudenttestrecordCourseId(1);
				record2.setStudenttestrecordChapterId(1);
				record2.setStudenttestrecordStudentId(1);
				record2.setStudenttestrecordStudenttestId(1);
				if (studentTestRecordService.insertStudentTestRecord(record2) != null) {
					String gapTrueAnswer = gapfillingAnswerService.queryGapfillingAnswer(gapQuestion);
					if (gapTrueAnswer.equals(gapAnswer)) {
						sumScore2 += gapScore;
					} else {
						sumScore2 += 0;
					}
					// map.put("sumScore", sumScore);
				} else {
					// map.put("success", false);
				}

			}

		}

		// 多选题处理
		if (twinchoice != null && !"".equals(twinchoice)) {
			String twinchoice1 = twinchoice.replaceAll(regex, "");// 去掉开始的逗号
			String[] twinChoice = twinchoice1.split("==");// 截取整个对象
			for (int i = 0; i < twinChoice.length; i++) {
				String[] choices = twinChoice[i].split("。");// 获取该对象的问题、答案、分数
				String choiceAnswer = null;
				String choiceQuestion = null;
				Integer choiceScore = 0;
				for (int j = 0; j < choices.length; j++) {
					choiceQuestion = choices[0].replaceAll(regex, "");// 获取多选的问题
					choiceAnswer = choices[1];// 获取多选的答案
					choiceScore = Integer.parseInt(choices[2]);// 获取多选的分数
				}
				StudentTestRecord record3 = new StudentTestRecord();
				record3.setStudenttestrecordCreateDateTime(new Date());
				record3.setStudenttestrecordAnswers(choiceAnswer);
				record3.setStudenttestrecordQuestions(choiceQuestion);
				record3.setStudenttestrecordCourseId(1);
				record3.setStudenttestrecordChapterId(1);
				record3.setStudenttestrecordStudentId(1);
				record3.setStudenttestrecordStudenttestId(1);
				Integer score = 0;
				if (studentTestRecordService.insertStudentTestRecord(record3) != null) {
					List<String> answer = choiceAnswerService.queryChoiceQuestionAnswer(choiceQuestion);
					for (int j = 0; j < answer.size(); j++) {
						if (answer.get(j).equals(choiceAnswer)) {
							score += choiceScore;
						} else {
							sumScore += 0;
						}
						sumScore3 = score / choiceAnswer.length();
					}

					map.put("sumScore", sumScore);
				} else {
					// map.put("success", false);
				}
			}
		}
		sum = sumScore + sumScore1 + sumScore2 + sumScore3;
		map.put("sum", sum);
		return map;
	}

	/**
	 * 当点击查看时 根据测试记录的外键（测试的主键）查询
	 * http://localhost:3060/YangYiChen/studentTestRecord/queryStudentTestRecord?studentTestId=1
	 * http://localhost:3011/yangyichen/YangYiChen/studentTestRecord/queryStudentTestRecord?studentTestId=1
	 * 
	 * @param studentTestId
	 * @return
	 */
	/*@GetMapping(value = "/queryStudentTestRecord", name = "查看测试")
	public Object queryStudentTestRecord(@RequestParam(value = "studentId", required = false) Integer studentId,
			@RequestParam(value = "courseId", required = false) Integer courseId,
			@RequestParam(value="chapterId",required=false) Integer chapterId) {
		return studentTestRecordService.queryStudentTestRecord(studentId,courseId,chapterId);
	}*/

}
