package com.cxb.yyc.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.yyc.entity.Gapfilling;
import com.cxb.yyc.entity.GapfillingAnswer;
import com.cxb.yyc.service.TeacherSetGapfillingAnswerService;
import com.cxb.yyc.service.TeacherSetGapfillingQuestionService;

/**
 * 教师设置测试题==>填空题
 * @author dell
 *
 */
@RestController
@RequestMapping(value="gapfillingQuestion",name="教师设置填空题")
public class TeacherSetGapfillingQuestionController {
	
	/**
	 * 填空题问题业务接口
	 */
	@Autowired 
	private TeacherSetGapfillingQuestionService gapfillingQuestionService;
	/**
	 * 填空题答案业务接口
	 */
	@Autowired
	private TeacherSetGapfillingAnswerService gapfillingAnswerService;
	/**
	 * 教师添加填空题及答案
	 * 根据页面设计，需要同时添加问题及答案
	 * 1.首先添加填空题问题
	 * 2.添加填空题问题答案
	 * http://localhost:3060/YangYiChen/gapfillingQuestion/insertGapfillingQuestion?gapfillingQuestion=你好吗?&gapfillingScore=5&gapfillinganswerAnswer=很好,谢谢关心
	 * http://localhost:3060/YangYiChen//choiceQuestion/updateChoiceQuestion?optionId=11&optiona=A:Yes&optionb=B:No&optionc=C:很好&optiond=D:No&gapfillingCourseId=2&gapfillingChapterId=3
	 * @param gapfilling
	 * @param gapfillingAnswer
	 * @return
	 */
	@RequestMapping(value="/insertGapfillingQuestion",name="添加填空题及答案")
	public Object insertGapfillingQuestion(Gapfilling gapfilling,GapfillingAnswer gapfillingAnswer) {
		Map<String, Object> map=new HashMap<String, Object>();
		//获取添加填空题问题的当前时间
		gapfilling.setGapfillingCreateDateTime(new Date());
		if (gapfillingQuestionService.insertGapfilling(gapfilling)!=null) {
			//获取添加填空题答案的当前时间
			gapfillingAnswer.setGapfillinganswerCreateDateTime(new Date());
			//根据当前添加填空题的问题获取问题主键添加该问题的答案
			gapfillingAnswer.setGapfilling(gapfilling);
			if (gapfillingAnswerService.insertGapfillingAnswer(gapfillingAnswer)!=null) {
				map.put("success", true);
				map.put("msg", "填空题设置成功");
			}else {
				map.put("success", false);
				map.put("msg", "填空题设置失败");
			}
		}
		return map;
	}
	
	/**
	 * 根据填空题主键删除问题及答案
	 * 1.删除填空题
	 * 2.删除填空题答案
	 * @param gapfillingId 填空题主键
	 * @return
	 */
	@RequestMapping(value="/deleteGapfilling",name="删除填空题及答案")
	public Object deleteGapfilling(Integer gapfillingId,Integer gapfillingAnswerId) {
		Map<String, Object> map=new HashMap<String, Object>();
		//删除填空题问题答案
		if (gapfillingAnswerService.deleteGapfillingAnswer(gapfillingId)>0) {
			//删除填空题问题
			if (gapfillingQuestionService.deleteGapfilling(gapfillingId)>0) {
				map.put("success", true);
				map.put("msg", "删除成功");
			}else {
				map.put("success", false);
				map.put("msg", "删除失败");
			}
		}		
		return map;
	}
	/**
	 * 根据填空题主键修改问题及答案
	 * 1.先修改填空题问题
	 * 2.修改问题答案
	 * http://localhost:3060/YangYiChen/gapfillingQuestion/updateGapfilling?gapfillingImgurl=1.pfg&gapfillingQuestion=How are you?&gapfillingScore=5&gapfillingId=11&gapfillinganswerAnswer=I am fine!&gapfillinganswerId=11&gapfillingChapterId=2&fillingChapterId=3
	 * @param gapfilling
	 * @param gapfillingAnswer
	 * @return
	 */
	@RequestMapping(value="/updateGapfilling",name="修改填空题问题及答案")
	public Object updateGapfilling(Gapfilling gapfilling,GapfillingAnswer gapfillingAnswer) {
		Map<String, Object> map=new HashMap<String, Object>();
		if (gapfilling.getGapfillingId()!=null && gapfilling.getGapfillingId()!=0 && gapfillingAnswer.getGapfillinganswerId()!=null && gapfillingAnswer.getGapfillinganswerId()!=0) {
			if (gapfillingQuestionService.updateGapfillingQuestion(gapfilling)>0) {
				if (gapfillingAnswerService.updateGapfillingAnswer(gapfillingAnswer)>0) {
					map.put("success", true);
					map.put("msg", "填空题修改成功");
				}else {
					map.put("success", false);
					map.put("msg", "填空题修改失败");
				}
			}
		}else if (gapfilling.getGapfillingId()!=null && gapfilling.getGapfillingId()!=0) {
			//修改问题
			if (gapfillingQuestionService.updateGapfillingQuestion(gapfilling)>0) {
				map.put("success", true);
				map.put("msg", "填空题问题修改成功");
			}else {
				map.put("success", false);
				map.put("msg", "填空题问题修改失败");
			}
		}else if(gapfillingAnswer.getGapfillinganswerId()!=null && gapfillingAnswer.getGapfillinganswerId()!=0) {
			//根据修改的问题获取主键并修改该问题的答案
			gapfillingAnswer.setGapfilling(gapfilling);
			if (gapfillingAnswerService.updateGapfillingAnswer(gapfillingAnswer)>0) {
				map.put("success", true);
				map.put("msg", "填空题答案修改成功");
			}else {
				map.put("success", false);
				map.put("msg", "填空题答案修改失败");
			}
		}
		return map;		
	}
	/**
	 * 根据章节Id和课程Id查询填空题问题
	 * http://localhost:3060/YangYiChen/gapfillingQuestion/queryGapfilling?chapterId=1&courseId=1
	 * @param chapterId
	 * @param courseId
	 * @param state 0：顺序 1：随机试题
	 * @return
	 */
	@RequestMapping(value="/queryGapfilling",name="预览填空题问题")
	public Object queryGapfilling(Integer chapterId,Integer courseId,Integer state) {
		List<Gapfilling> list=gapfillingQuestionService.queryGapfilling(chapterId, courseId);
		if (state==0) {
			return list;
		}else {
			Collections.shuffle(list);
			return list;
		}
		
	}

}
