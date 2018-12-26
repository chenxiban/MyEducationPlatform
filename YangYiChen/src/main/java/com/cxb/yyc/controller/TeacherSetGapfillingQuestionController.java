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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.yyc.entity.Gapfilling;
import com.cxb.yyc.entity.GapfillingAnswer;
import com.cxb.yyc.service.TeacherSetGapfillingAnswerService;
import com.cxb.yyc.service.TeacherSetGapfillingQuestionService;
import com.cxb.yyc.service.TeacherSetTestService;

/**
 * 教师设置测试题==>填空题
 * @author dell
 *
 */
@RestController
@RequestMapping(value="/gapfillingQuestion",name="教师设置填空题")
@CrossOrigin
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
	
	@Autowired
	private TeacherSetTestService teacherSetTestService;
	
	/**
	 * 教师添加填空题及答案
	 * 根据页面设计，需要同时添加问题及答案
	 * 1.首先添加填空题问题
	 * 2.添加填空题问题答案
	 * 
	 * http://localhost:3060/YangYiChen/gapfillingQuestion/insertGapfillingQuestion
	 * 
	 * http://localhost:3060/YangYiChen/choiceQuestion/updateChoiceQuestion?optionId=11&optiona=A:Yes&optionb=B:No&optionc=C:很好&optiond=D:No&gapfillingCourseId=2&gapfillingChapterId=3
	 * @param gapfilling
	 * @param gapfillingAnswer
	 * @return
	 */
	@RequestMapping(value="/insertGapfillingQuestion",name="添加填空题及答案",method = RequestMethod.POST)
	public Object insertGapfillingQuestion(@RequestParam(value="gapfillingQuestion")String gapfillingQuestion,
			@RequestParam(value="gapfillinganswerAnswer")String gapfillinganswerAnswer,
			@RequestParam(value="gapfillingScore")Integer gapfillingScore,
			@RequestParam(value="gapfillingChapterId")Integer gapfillingChapterId,
			@RequestParam(value="gapfillingCourseId")Integer gapfillingCourseId) {
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		Gapfilling gapfilling=new Gapfilling();
		gapfilling.setGapfillingQuestion(gapfillingQuestion);
		gapfilling.setGapfillingScore(gapfillingScore);
		gapfilling.setGapfillingChapterId(gapfillingChapterId);
		gapfilling.setGapfillingCourseId(gapfillingCourseId);
		gapfilling.setGapfillingCreateDateTime(new Date());
		
		GapfillingAnswer gapfillingAnswer=new GapfillingAnswer();
		gapfillingAnswer.setGapfillinganswerAnswer(gapfillinganswerAnswer);
		gapfillingAnswer.setGapfilling(gapfilling);
		gapfillingAnswer.setGapfillinganswerCreateDateTime(new Date());
		if (gapfillingQuestionService.insertGapfilling(gapfilling)!=null&&gapfillingAnswerService.insertGapfillingAnswer(gapfillingAnswer)!=null) {
			int num=gapfillingQuestionService.selectCountByGapfillingChapterId(gapfillingChapterId);
			int n=teacherSetTestService.updateGapfillingNumByChapterId(num, gapfillingChapterId);
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
	 * 根据填空题主键删除问题及答案
	 * 1.删除填空题
	 * 2.删除填空题答案
	 * http://localhost:3060/YangYiChen/gapfillingQuestion/insertGapfillingQuestion
	 * @param gapfillingId 填空题主键
	 * @return
	 */
	@RequestMapping(value="/deleteGapfilling",name="删除填空题及答案",method=RequestMethod.DELETE)
	public Object deleteGapfilling(@RequestParam(value="gapfillingId",required=false)Integer gapfillingId) {
		Map<String, Object> map=new HashMap<String, Object>();
		//删除填空题问题答案
		if (gapfillingAnswerService.deleteGapfillingAnswer(gapfillingId)>0) {
			//删除填空题问题
			if (gapfillingQuestionService.deleteGapfilling(gapfillingId)>0) {
				map.put("success", true);
				map.put("msg", "删除成功,请重新查看试题");
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
	@PutMapping(value="/updateGapfilling",name="修改填空题问题及答案")
	public Object updateGapfilling(@RequestBody Gapfilling gapfilling,@RequestBody GapfillingAnswer gapfillingAnswer) {
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
	//@GetMapping(value="/queryGapfilling",name="预览填空题问题")
	/*public Object queryGapfilling(@RequestParam(value="chapterId",required=false)Integer chapterId,@RequestParam(value="courseId",required=false)Integer courseId,@RequestParam(value="state",required=false)Integer state) {
		List<Gapfilling> list=gapfillingQuestionService.queryGapfilling(chapterId, courseId);
		if (state==0) {
			return list;
		}else {
			Collections.shuffle(list);
			return list;
		}
		
	}*/

}
