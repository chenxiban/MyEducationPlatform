package com.cxb.yyc.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.yyc.entity.Tfng;
import com.cxb.yyc.entity.TfngAnswer;
import com.cxb.yyc.service.TeacherSetTestService;
import com.cxb.yyc.service.TeacherSetTfngAnswerService;
import com.cxb.yyc.service.TeacherSetTfngQuestionService;

/**
 * 教师设置判断题
 * 
 * @author dell
 *
 */
@RestController
@RequestMapping(value = "tfngQuestion", name = "教师设置判断题")
@CrossOrigin
public class TeacherSetTfngQuestionController {

	/**
	 * 判断题问题业务接口
	 */
	@Autowired
	private TeacherSetTfngQuestionService tfngQuestionService;
	/**
	 * 判断题答案业务接口
	 */
	@Autowired
	private TeacherSetTfngAnswerService tfngAnswerService;
	
	@Autowired
	private TeacherSetTestService teacherSetTestService;

	/**
	 * 教师添加判断题 1.先添加判断题问题 2.添加判断题答案
	 * http://localhost:3060/YangYiChen/tfngQuestion/insertTfngQuestion?tfngQuestion=天气晴朗&tfngScore=2&tfnganswerAnswer=1&tfngCourseId=2&tfngChapterId=3
	 * 
	 * @param tfng
	 * @param tfngAnswer
	 * @return
	 */
	
	@RequestMapping(value = "/insertTfngQuestion", name = "添加判断题问题及答案",method=RequestMethod.POST)
	public Object insertTfngQuestion(@RequestParam("tfngQuestion")String tfngQuestion,
			@RequestParam("tfnganswerAnswer")Integer tfnganswerAnswer,
			@RequestParam("tfngScore")Integer tfngScore,
			@RequestParam("tfngChapterId")Integer tfngChapterId,
			@RequestParam("tfngCourseId")Integer tfngCourseId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Tfng tfng=new Tfng();
		tfng.setTfngQuestion(tfngQuestion);
		tfng.setTfngScore(tfngScore);
		tfng.setTfngCourseId(tfngCourseId);
		tfng.setTfngChapterId(tfngChapterId);
		tfng.setTfngCreateDateTime(new Date());
		TfngAnswer tfngAnswer=new TfngAnswer();
		tfngAnswer.setTfng(tfng);
		tfngAnswer.setTfnganswerAnswer(tfnganswerAnswer);
		tfngAnswer.setTfnganswerCreateDateTime(new Date());
		if (tfngQuestionService.insertTfng(tfng)!=null&&tfngAnswerService.insertTfngAnswer(tfngAnswer)!=null) {
			int num=tfngQuestionService.selectCountByTfngChapterId(tfngChapterId);
			int n=teacherSetTestService.updateTfngNumByChapterId(num, tfngChapterId);
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
	 * 根据判断题主键删除判断题 1.先删除判断题答案 2.删除判断题
	 * http://localhost:3060/YangYiChen/tfngQuestion/deleteTfng?tfngId=12&tfngAnswerId=12
	 * 
	 * @param tfngId 判断题主键
	 * @return
	 */
	@DeleteMapping(value = "/deleteTfng", name = "删除判断题及答案")
	public Object deleteTfng(@RequestParam(value="tfngId",required=false)Integer tfngId, @RequestParam(value="tfngAnswerId",required=false)Integer tfngAnswerId) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 删除判断题
		if (tfngAnswerService.deleteTfngAnswer(tfngAnswerId) > 0) {
			// 删除判断题答案
			if (tfngQuestionService.deleteTfng(tfngId) > 0) {
				map.put("success", true);
				map.put("msg", "判断题删除成功");
			} else {
				map.put("success", false);
				map.put("msg", "判断题删除失败");
			}
		}
		return map;
	}

	/**
	 * 根据判断题主键、答案主键修改判断题及答案 1.修改判断题及答案 ①先修改判断题 ②修改答案 2.只修改判断题 3.只修改答案
	 * http://localhost:3060/YangYiChen/tfngQuestion/updateTfng?tfnganswerAnswer=0&tfnganswerId=11&tfngCourseId=2&tfngChapterId=3
	 * 
	 * @param tfng
	 * @param tfngAnswer
	 * @return
	 */
	@PutMapping(value = "/updateTfng", name = "修改判断题及答案")
	public Object updateTfng(@RequestBody Tfng tfng, @RequestBody TfngAnswer tfngAnswer) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (tfng.getTfngId() != null && tfng.getTfngId() != 0 && tfngAnswer.getTfnganswerId() != null
				&& tfngAnswer.getTfnganswerId() != 0) {
			if (tfngQuestionService.updateTfng(tfng) > 0) {
				if (tfngAnswerService.updateTfngAnswer(tfngAnswer) > 0) {
					map.put("success", true);
					map.put("msg", "判断题修改成功");
				} else {
					map.put("success", false);
					map.put("msg", "判断题修改失败");
				}
			}
		} else if (tfng.getTfngId() != null && tfng.getTfngId() != 0) {
			if (tfngQuestionService.updateTfng(tfng) > 0) {
				map.put("success", true);
				map.put("msg", "问题修改成功");
			} else {
				map.put("success", false);
				map.put("msg", "问题修改失败");
			}
		} else if (tfngAnswer.getTfnganswerId() != null && tfngAnswer.getTfnganswerId() != 0) {
			if (tfngAnswerService.updateTfngAnswer(tfngAnswer) > 0) {
				map.put("success", true);
				map.put("msg", "答案修改成功");
			} else {
				map.put("success", false);
				map.put("msg", "答案修改失败");
			}
		}
		return map;
	}

}
