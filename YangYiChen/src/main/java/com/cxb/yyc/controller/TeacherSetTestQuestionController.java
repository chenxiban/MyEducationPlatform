package com.cxb.yyc.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.yyc.entity.ChoiceQuestion;
import com.cxb.yyc.entity.ChoiceQuestionAnswer;
import com.cxb.yyc.entity.Gapfilling;
import com.cxb.yyc.entity.Option;
import com.cxb.yyc.entity.QuestionOption;
import com.cxb.yyc.entity.Tfng;
import com.cxb.yyc.repository.TeacherSetGapfillingQuestionRepository;
import com.cxb.yyc.service.TeacherSetChoiceQuestionAnswerService;
import com.cxb.yyc.service.TeacherSetChoiceQuestionService;
import com.cxb.yyc.service.TeacherSetGapfillingQuestionService;
import com.cxb.yyc.service.TeacherSetOptionService;
import com.cxb.yyc.service.TeacherSetTestService;
import com.cxb.yyc.service.TeacherSetTfngQuestionService;

/**
 * 教师设置测试题选择题
 * 
 * @author dell
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/choiceQuestion", name = "教师设置选择题")
public class TeacherSetTestQuestionController {

	/**
	 * 教师发起测试接口
	 */
	@Autowired
	private TeacherSetTestService teacherSetTestService;
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
	 * 教师设置选择题正确答案的接口
	 */
	@Autowired
	private TeacherSetChoiceQuestionAnswerService questionAnswerService;
	/**
	 * 填空题接口
	 */
	@Autowired
	private TeacherSetGapfillingQuestionService gapfillingQuestionService;
	/**
	 * 判断题接口
	 */
	@Autowired
	private TeacherSetTfngQuestionService tfngQuestionService;

	/**
	 * 教师添加选择题 1.教师首先向选择题题库中添加问题 2.向选项表中添加选择题的选项，至少有四个选项 3.向正确选择题答案表中添加选择题对应的正确答案
	 * http://localhost:3060/YangYiChen/choiceQuestion/insertChoiceQuestion?choicequestionQuestion=你好吗?&choicequestiontbIssingleselection=0&choicequestionScore=2&optionA=A:yes&optionB=B:no&optionC=C:很好&optionD=D:NO&choicequestionanswerAnswer=C:很好&selectedChapterAndCourseIds=1,2
	 * 
	 * @param choiceQuestion
	 * @param courseid       课程id
	 * @param chapterid      章节id
	 * @return
	 */
	@RequestMapping(value = "/insertChoiceQuestion", name = "添加选择题",method=RequestMethod.POST)
	public Object insertChoiceQuestion(@RequestParam("choicequestionQuestion")String choicequestionQuestion,
			@RequestParam("choicequestionScore")Integer choicequestionScore,
			@RequestParam("choicequestiontbIssingleselection")Integer choicequestiontbIssingleselection,
			@RequestParam("choicequestionChapterId")Integer choicequestionChapterId,
			@RequestParam("choicequestionCourseId")Integer choicequestionCourseId,
			@RequestParam("selectA")String selectA,
			@RequestParam("selectB")String selectB,
			@RequestParam("selectC")String selectC,
			@RequestParam("selectD")String selectD,
			@RequestParam("optionA")String optionA,
			@RequestParam("optionB")String optionB,
			@RequestParam("optionC")String optionC,
			@RequestParam("optionD")String optionD,
			@RequestParam("trueA")String trueA,
			@RequestParam("trueB")String trueB,
			@RequestParam("trueC")String trueC,
			@RequestParam("trueD")String trueD) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		ChoiceQuestion choiceQuestion=new ChoiceQuestion();
		choiceQuestion.setChoicequestionQuestion(choicequestionQuestion);
		choiceQuestion.setChoicequestionScore(choicequestionScore);
		choiceQuestion.setChoicequestiontbIssingleselection(choicequestiontbIssingleselection);
		choiceQuestion.setChoicequestionChapterId(choicequestionChapterId);
		choiceQuestion.setChoicequestionCourseId(choicequestionCourseId);
		choiceQuestion.setChoicequestionCreateDateTime(new Date());
		
		Option option=new Option();
		option.setOptionA(optionA);
		option.setOptionB(optionB);
		option.setOptionC(optionC);
		option.setOptionD(optionD);
		option.setOptionCreateDateTime(new Date());
		option.setChoiceQuestion(choiceQuestion);
		
		if (choiceQuestionService.insertChoiceQuestion(choiceQuestion)!=null&&optionService.insertOption(option)!=null) {
			if (selectA!="") {
				ChoiceQuestionAnswer choiceQuestionAnswer=new ChoiceQuestionAnswer();
				choiceQuestionAnswer.setChoicequestionanswerAnswer(trueA);
				choiceQuestionAnswer.setChoiceQuestion(choiceQuestion);
				choiceQuestionAnswer.setChoicequestionanswerCreateDateTime(new Date());
				questionAnswerService.insertChoiceQuestionAnswer(choiceQuestionAnswer);
				System.out.println("添加A正确答案成功");
			}
			if (selectB!="") {
				ChoiceQuestionAnswer choiceQuestionAnswer=new ChoiceQuestionAnswer();
				choiceQuestionAnswer.setChoicequestionanswerAnswer(trueB);
				choiceQuestionAnswer.setChoiceQuestion(choiceQuestion);
				choiceQuestionAnswer.setChoicequestionanswerCreateDateTime(new Date());
				questionAnswerService.insertChoiceQuestionAnswer(choiceQuestionAnswer);
				System.out.println("添加B正确答案成功");
			}
			if (selectC!="") {
				ChoiceQuestionAnswer choiceQuestionAnswer=new ChoiceQuestionAnswer();
				choiceQuestionAnswer.setChoicequestionanswerAnswer(trueC);
				choiceQuestionAnswer.setChoiceQuestion(choiceQuestion);
				choiceQuestionAnswer.setChoicequestionanswerCreateDateTime(new Date());
				questionAnswerService.insertChoiceQuestionAnswer(choiceQuestionAnswer);
				System.out.println("添加C正确答案成功");
			}
			if (selectD!="") {
				ChoiceQuestionAnswer choiceQuestionAnswer=new ChoiceQuestionAnswer();
				choiceQuestionAnswer.setChoicequestionanswerAnswer(trueD);
				choiceQuestionAnswer.setChoiceQuestion(choiceQuestion);
				choiceQuestionAnswer.setChoicequestionanswerCreateDateTime(new Date());
				questionAnswerService.insertChoiceQuestionAnswer(choiceQuestionAnswer);
				System.out.println("添加D正确答案成功");
			}
			int num=choiceQuestionService.selectCountByChoiceChapterId(choicequestionChapterId);
			int n=teacherSetTestService.updateChoiceNumByChapterId(num, choicequestionChapterId);
			if (n>0) {
				map.put("success", true);
				map.put("msg", "添加问题成功！");
			}
		}else {
			map.put("success", false);
			map.put("msg", "添加问题失败！");
		}
		return map;
	}

	/**
	 * 删除问题 根据问题主键可删除问题，问题选项，问题答案 1.先删除问题的正确答案 2.删除选项 3.删除问题
	 * http://localhost:3060/YangYiChen/choiceQuestion/deleteChoiceQuestion?questionId=11&option=11&answerId=11
	 * 
	 * @param choicequestionId
	 * @return
	 */
	@RequestMapping(value = "/deleteChoiceQuestion", name = "删除选择题",method=RequestMethod.DELETE)
	public Object deleteChoiceQuestion(@RequestParam(value="questionId",required=false)Integer questionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 删除正确答案
		if (questionAnswerService.deleteChoiceQuestionAnswer(questionId) > 0) {
			// 删除问题选项
			if (optionService.deleteOption(questionId) > 0) {
				// 删除问题
				if (choiceQuestionService.deleteChoiceQuestion(questionId) > 0) {
					map.put("success", true);
					map.put("msg", "删除成功,请重新查看试题");
				} else {
					map.put("success", false);
					map.put("msg", "删除失败");
				}
			}
		}
		return map;
	}

	/**
	 * 根据问题主键可修改选择问题 由于修改这一操作，修改三张表的内容，但触发同一个按钮，所以根据判断主键值是否为0， 对不同的表进行修改操作
	 * http://localhost:3060/YangYiChen/choiceQuestion/updateChoiceQuestion?optionId=11&optiona=A:Yes&optionb=B:No&optionc=C:很好&optiond=D:No&choicequestionCourseId=2&choicequestionChapterId=3
	 * http://localhost:3060/yangyichen/YangYiChen/choiceQuestion/updateChoiceQuestion?optionId=11&optiona=A:Yes&optionb=B:No&optionc=C:很好&optiond=D:No&choicequestionCourseId=2&choicequestionChapterId=3
	 * 
	 * @param questionId
	 * @param choicequestion_imgurl
	 * @param choicequestion_question
	 * @param choicequestion_score
	 * @param choicequestiontb_issingleselection
	 * @return
	 */
	@PutMapping(value = "/updateChoiceQuestion", name = "修改问题、选项、答案")
	public Object updateChoiceQuestion(@RequestParam(value="questionId",required=false)Integer questionId, @RequestParam(value="choicequestion_imgurl",required=false)String choicequestion_imgurl, @RequestParam(value="choicequestion_question",required=false)String choicequestion_question,
			@RequestParam(value="choicequestion_score",required=false)Integer choicequestion_score, @RequestParam(value="choicequestiontb_issingleselection",required=false)Integer choicequestiontb_issingleselection, @RequestParam(value="optionId",required=false)Integer optionId, @RequestParam(value="optiona",required=false)String optiona,
			@RequestParam(value="optionb",required=false)String optionb, @RequestParam(value="optionc",required=false)String optionc, @RequestParam(value="optiond",required=false)String optiond, @RequestParam(value="answerId",required=false)Integer answerId, @RequestParam(value="answer",required=false)String answer) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (questionId != null && questionId != 0 && optionId != null && optionId != 0) {
			int choiceQuestion = choiceQuestionService.updateChoiceQuestion(questionId, choicequestion_imgurl,
					choicequestion_question, choicequestion_score, choicequestiontb_issingleselection);
			if (choiceQuestion > 0) {
				int option = optionService.updateOption(optionId, optiona, optionb, optionc, optiond);
				if (option > 0) {
					map.put("success", true);
					map.put("msg", "选择题修改成功");
				} else {
					map.put("success", false);
					map.put("msg", "选择题修改失败");
				}
			}
		} else if (questionId != null && questionId != 0) {
			int choiceQuestion = choiceQuestionService.updateChoiceQuestion(questionId, choicequestion_imgurl,
					choicequestion_question, choicequestion_score, choicequestiontb_issingleselection);
			if (choiceQuestion > 0) {
				map.put("success", true);
				map.put("msg", "问题修改成功");
			} else {
				map.put("success", false);
				map.put("msg", "问题修改失败");
			}
		} else if (optionId != null && optionId != 0) {
			int option = optionService.updateOption(optionId, optiona, optionb, optionc, optiond);
			if (option > 0) {
				map.put("success", true);
				map.put("msg", "选项修改成功");
			} else {
				map.put("success", false);
				map.put("msg", "选项修改失败");
			}
		} else if (answerId != null && answerId != 0) {
			int answers = questionAnswerService.updateChoiceQuestionAnswer(answerId, answer);
			if (answers > 0) {
				map.put("success", true);
				map.put("msg", "问题答案修改成功");
			} else {
				map.put("success", false);
				map.put("msg", "问题答案修改失败");
			}
		}
		return map;
	}

	/**
	 * 根据课程Id和章节Id查询问题及选项
	 * http://localhost:3060/YangYiChen/choiceQuestion/queryChoiceQuestionAndOption?chapterId=1&courseId=1&state=0
	 * http://localhost:3011/yangyichen/YangYiChen/choiceQuestion/queryChoiceQuestionAndOption?chapterId=1&courseId=1&state=0
	 * 
	 * @param chapterId
	 * @param state     state 0:顺序预览选择题，1：随机
	 * @return
	 */
	@RequestMapping(value = "/queryChoiceQuestionAndOption", name = "预览问题及选项",method=RequestMethod.GET)
	public Object queryChoiceQuestionAndOption(@RequestParam(value="chapterId",required=false)Integer chapterId,@RequestParam(value="state",required=false)String state) {
		System.out.println("chapterId=>"+chapterId);
		ArrayList<Object> list = new ArrayList<Object>();
		// 选择题集合
		List<QuestionOption> list1 = choiceQuestionService.queryChoiceQuestion(chapterId);
		list.add(list1);
		// 填空题集合
		List<Gapfilling> list2 = gapfillingQuestionService.queryGapfilling(chapterId);
		list.add(list2);
		// 判断题集合
		List<Tfng> list3 = tfngQuestionService.queryTfng(chapterId);
		list.add(list3);
		if (state == "是") {
			// 将集合中的对象打乱顺序
			Collections.shuffle(list1);
			Collections.shuffle(list2);
			Collections.shuffle(list3);
			return list;
		} else {
			return list;
		}
	}

}
