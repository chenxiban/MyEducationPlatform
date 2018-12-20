package com.cxb.yyc.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
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
	 * 教师添加选择题 1.教师首先向选择题题库中添加问题 2.向选项表中添加选择题的选项，至少有四个选项 3.向正确选择题答案表中添加选择题对应的正确答案
	 * http://localhost:3060/YangYiChen/choiceQuestion/insertChoiceQuestion?choicequestionQuestion=你好吗?&choicequestiontbIssingleselection=0&choicequestionScore=2&optionA=A:yes&optionB=B:no&optionC=C:很好&optionD=D:NO&choicequestionanswerAnswer=C:很好&choicequestionCourseId=2&choicequestionChapterId=3
	 * 
	 * @param choiceQuestion
	 * @param courseid       课程id
	 * @param chapterid      章节id
	 * @return
	 */
	@RequestMapping(value = "/insertChoiceQuestion", name = "添加选择题")
	public Object insertChoiceQuestion(ChoiceQuestion choiceQuestion, Option option,
			ChoiceQuestionAnswer questionAnswer) {
		Map<String, Object> map = new HashMap<String, Object>();
		choiceQuestion.setChoicequestionCreateDateTime(new Date());// 获取问题的创建时间
		option.setOptionCreateDateTime(new Date());// 获取选项创建的当前时间
		questionAnswer.setChoicequestionanswerCreateDateTime(new Date());// 获取创建问题答案的当前时间
		if (choiceQuestionService.insertChoiceQuestion(choiceQuestion) != null) {// 添加问题
			option.setChoiceQuestion(choiceQuestion);// 通过添加的问题获取到问题主键给选项问题的外键赋值
		
			if (optionService.insertOption(option) != null) {
				questionAnswer.setChoiceQuestion(choiceQuestion);// 通过添加的问题获取到问题主键给选项问题对应的答案的外键赋值
				if (questionAnswerService.insertChoiceQuestionAnswer(questionAnswer) != null) {
					map.put("success", true);
					map.put("msg", "添加成功");
				} else {
					map.put("success", false);
					map.put("msg", "添加失败");
				}
			}
		}
		return map;
	}

	/**
	 * 删除问题 根据问题主键可删除问题，问题选项，问题答案 
	 * 1.先删除问题的正确答案 
	 * 2.删除选项 
	 * 3.删除问题
	 * http://localhost:3060/YangYiChen/choiceQuestion/deleteChoiceQuestion?questionId=11&option=11&answerId=11	
	 * @param choicequestionId
	 * @return
	 */
	@RequestMapping(value="/deleteChoiceQuestion",name="删除选择题")
	public Object deleteChoiceQuestion(Integer questionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 删除正确答案
		if (questionAnswerService.deleteChoiceQuestionAnswer(questionId)>0) {
			// 删除问题选项
			if (optionService.deleteOption(questionId)>0) {
				// 删除问题
				if (choiceQuestionService.deleteChoiceQuestion(questionId)>0) {
					map.put("success", true);
					map.put("msg", "删除成功");
				}else {
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
	 *http://localhost:3060/yangyichen/YangYiChen/choiceQuestion/updateChoiceQuestion?optionId=11&optiona=A:Yes&optionb=B:No&optionc=C:很好&optiond=D:No&choicequestionCourseId=2&choicequestionChapterId=3
	 * @param questionId
	 * @param choicequestion_imgurl
	 * @param choicequestion_question
	 * @param choicequestion_score
	 * @param choicequestiontb_issingleselection
	 * @return
	 */
	@RequestMapping(value = "/updateChoiceQuestion", name = "修改问题、选项、答案")
	public Object updateChoiceQuestion(Integer questionId, String choicequestion_imgurl, String choicequestion_question,
			Integer choicequestion_score, Integer choicequestiontb_issingleselection, Integer optionId, String optiona,
			String optionb, String optionc, String optiond, Integer answerId, String answer) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (questionId != null && questionId != 0 && optionId != null && optionId != 0) {
			int choiceQuestion = choiceQuestionService.updateChoiceQuestion(questionId, choicequestion_imgurl,
					choicequestion_question, choicequestion_score, choicequestiontb_issingleselection);
			if (choiceQuestion > 0) {
				int option = optionService.updateOption(optionId, optiona, optionb, optionc, optiond);
				if (option > 0) {
					map.put("success", true);
					map.put("msg", "选择题修改成功");
				}else {
					map.put("success", false);
					map.put("msg", "选择题修改失败");
				}
			}
		}else if (questionId != null && questionId != 0) {
			int choiceQuestion = choiceQuestionService.updateChoiceQuestion(questionId, choicequestion_imgurl,
					choicequestion_question, choicequestion_score, choicequestiontb_issingleselection);
			if (choiceQuestion > 0) {
				map.put("success", true);
				map.put("msg", "问题修改成功");
			} else {
				map.put("success", false);
				map.put("msg", "问题修改失败");
			}
		}else if (optionId != null && optionId != 0) {
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
	 * @param chapterId
	 * @param courseId
	 * @param state state 0:顺序预览选择题，1：随机
	 * @return
	 */
	@RequestMapping(value="/queryChoiceQuestionAndOption",name="预览问题及选项")
	public Object queryChoiceQuestionAndOption(Integer chapterId,Integer courseId,Integer state) {
		ArrayList<Object> list=new ArrayList<Object>();
		//选择题集合
		List<QuestionOption> list1=choiceQuestionService.queryChoiceQuestion(chapterId, courseId);
		list.add(list1);
		//填空题集合
		List<Gapfilling> list2=gapfillingQuestionService.queryGapfilling(chapterId, courseId);
		list.add(list2);
		//判断题集合
		List<Tfng> list3=tfngQuestionService.queryTfng(chapterId, courseId);
		list.add(list3);
		if (state==1) {
			//将集合中的对象打乱顺序
			 Collections.shuffle(list1);
			 Collections.shuffle(list2);
			 Collections.shuffle(list3);
			 return list;
		}else {
			return list;
		}
	}

}
