package com.cxb.yyc.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.yyc.entity.Tfng;
import com.cxb.yyc.entity.TfngAnswer;
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

	/**
	 * 教师添加判断题 1.先添加判断题问题 2.添加判断题答案
	 * http://localhost:3060/YangYiChen/tfngQuestion/insertTfngQuestion?tfngQuestion=天气晴朗&tfngScore=2&tfnganswerAnswer=1&tfngCourseId=2&tfngChapterId=3
	 * 
	 * @param tfng
	 * @param tfngAnswer
	 * @return
	 */
	@RequestMapping(value = "/insertTfngQuestion", name = "添加判断题问题及答案")
	public Object insertTfngQuestion(Tfng tfng, TfngAnswer tfngAnswer) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取添加判断题问题的当前时间
		tfng.setTfngCreateDateTime(new Date());
		if (tfngQuestionService.insertTfng(tfng) != null) {
			// 获取添加判断题答案的当前时间
			tfngAnswer.setTfnganswerCreateDateTime(new Date());
			// 根据当前添加的判断题添加对应的答案
			tfngAnswer.setTfng(tfng);
			if (tfngAnswerService.insertTfngAnswer(tfngAnswer) != null) {
				map.put("success", true);
				map.put("msg", "判断题添加成功");
			} else {
				map.put("success", false);
				map.put("msg", "判断题添加失败");
			}
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
	@RequestMapping(value = "/deleteTfng", name = "删除判断题及答案")
	public Object deleteTfng(Integer tfngId, Integer tfngAnswerId) {
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
	@RequestMapping(value = "/updateTfng", name = "修改判断题及答案")
	public Object updateTfng(Tfng tfng, TfngAnswer tfngAnswer) {
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

	/**
	 * 根据章节Id和课程Id查询判断题
	 * http://localhost:3060/YangYiChen/tfngQuestion/queryTfng?chapterId=1&courseId=1
	 * 
	 * @param chapterId
	 * @param courseId
	 * @param state 0:顺序 1：随机试题
	 * @return
	 */
	@RequestMapping(value = "/queryTfng", name = "预览判断题")
	public Object queryTfng(Integer chapterId, Integer courseId, Integer state) {
		List<Tfng> list = tfngQuestionService.queryTfng(chapterId, courseId);
		if (state == 0) {
			return list;
		} else {
			Collections.shuffle(list);
			return list;
		}
	}
}
