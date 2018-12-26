package com.cxb.zbq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.zbq.entity.Curriculum;
import com.cxb.zbq.entity.ScoringStandard;
import com.cxb.zbq.service.CurriculumService;
import com.cxb.zbq.service.ScoringStandardService;
import com.cxb.zbq.utils.Result;

@RestController
@RequestMapping("/scoringStandard")
@CrossOrigin
public class ScoringStandardController {
	@Autowired
	private ScoringStandardService scStandardService;
	@Autowired
	private CurriculumService curriculumService;
	
	@RequestMapping(value="insertScStan",name="添加评分标准")
	public Object insertScStan(ScoringStandard standard) {
		if(scStandardService.findByCurriculumId(standard.getCurriculumId())!=null)
			return new Result("该课程评分标准已经存在,如有变动请前往更改", 0);
		if(scStandardService.insertScStan(standard)!=null)
			return new Result("评分标准添加成功", 1);
		return new Result("评分标准添加失败", 0); 
	}
	
	@RequestMapping(value="",name="修改评分标准")
	public Object updateScStan(ScoringStandard scoringStandard) {
		//???????调用杨毅晨组查询该课程有没有添加期末考试信息,如果有,不允许修改???????
		if(scStandardService.findByScoringStandardId(scoringStandard.getScoringStandardId()).getUpdateCount()!=0)
			return new Result("很抱歉,该课程评分标准更改次数已达上限", 0);
		if(scStandardService.updateScStan(scoringStandard)>0)
			return new Result("课程评分标准修改成功", 1);
		return new Result("课程评分标准修改失败,请稍后再试", 0);
	}
	@RequestMapping(value="queryAll",name="根据登录的老师id查询出所有课程的评分标准")
	public Object queryAll(Integer teacherId) {
		//先获取老师所拥有的所有课程id
		List<Integer> listId=curriculumService.queryCurriculumIdByTeacherId(teacherId);
		//根据获取到的课程id的集合获取评分标准集合
		List<ScoringStandard> listScoring=scStandardService.queryScoringStandardBycurriculumId(listId);
		for (int i = 0; i < listScoring.size(); i++) {
			listScoring.get(i).setCurriculumName(curriculumService.findBycurriculumId(listScoring.get(i).getCurriculumId()).getCurriculumName());
			listScoring.get(i).setExam(100-listScoring.get(i).getProportion());
		}
		return listScoring;
	}
	@RequestMapping(value="updateScStanById",name="根据id修改一条信息")
	public Object updateScStanById(Integer scoringStandardId,Integer proportion) {
		return scStandardService.updateScStan(scoringStandardId, proportion);
	}
	@RequestMapping(value="insert",name="添加一条信息")
	public Object insertScStandard(ScoringStandard s) {
		if(scStandardService.insertScoringStandard(s)!=null) {
			return 1;
		}
		return 0;
	}
	
	

}
