package com.cxb.zbq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.zbq.entity.Curriculum;
import com.cxb.zbq.entity.ScoringStandard;
import com.cxb.zbq.entity.StudentCredit;
import com.cxb.zbq.entityquery.CurriculumQuery;
import com.cxb.zbq.entityquery.StudentCreditQuery;
import com.cxb.zbq.service.ScoringStandardService;
import com.cxb.zbq.service.StudentCreditService;
import com.cxb.zbq.utils.Result;

@RestController
@RequestMapping("studentCredit")
@CrossOrigin
public class StudentCreditController {
	@Autowired
	private StudentCreditService stuService;
	@Autowired
	private ScoringStandardService scStanService;
	
	//http://localhost:3050/ZhangBingQian/studentCredit/queryStudentCredits?studentId=1
	@RequestMapping(value="queryStudentCredits",name="多条件检索学分信息")
	public Object queryStudentCredits(StudentCreditQuery sQuery) {
		List<StudentCredit> pages=stuService.getStudentCredits(sQuery);
		return pages;
	}
	
//http://localhost:3050/ZhangBingQian/studentCredit/insertStudentCredit?currId=1&stuId=1&testScore=80&examinationScore=90
	@RequestMapping(value = "insertStudentCredit", name = "添加学分信息")
	public Object insertStudentCredit(Integer currId, Integer stuId, Integer testScore, Integer examinationScore) {
		double score = this.calculateCredit(currId, testScore, examinationScore);// 计算课程学分
		int number = 0;
		if (stuService.findByCurriculumIdAndStudentId(currId, stuId) != null)
			number = stuService.updateStudentCredit(score, currId, stuId);
		else
		number = stuService.insertStudentCredit(score, currId, stuId);
		if (number > 0)
			return new Result("学分信息更新成功", 1);
		return new Result("学分信息更新失败", 0);
	}

	/**
	 * 服务提供：查询学生总学分
	 * 
	 * @param studentId 学生id
	 * @return 学分double
	 */
	@RequestMapping(value = "getStudentCredit", name = "查询学生总学分")
	public double getStudentCredit(Integer studentId) {
		if (stuService.findByStudentId(studentId) != null)
			return stuService.getSumCredit(studentId);
		return -1;
	}

	/**
	 * 服务提供：根据课程查询学生学分
	 * @param currId    课程id
	 * @param studentId 学生id
	 * @return 学分 double
	 */
	@RequestMapping(value = "getStudentCreditByCurrId", name = "根据课程查询学生学分")
	public double getStudentCreditByCurrId(Integer currId, Integer studentId) {
		StudentCredit sCredit = stuService.findByCurriculumIdAndStudentId(currId, studentId);
		if (sCredit != null)
			return sCredit.getCredit();
		return -1;
	}

	/**
	 * 计算学分
	 * 
	 * @param currId           课程id
	 * @param testScore        章节测验成绩
	 * @param examinationScore 考试成绩
	 * @return 该课程最终学分
	 */
	public double calculateCredit(Integer currId, Integer testScore, Integer examinationScore) {
		ScoringStandard standard = scStanService.findByCurriculumId(currId);// 获取课程评分标准
		double score = -1;// 学分
		int testStandard =0;
		int examinationStandard=0;
		if (standard != null) {
			testStandard = standard.getProportion();// 获取章节测验的评分标准值
			examinationStandard = 100 - testStandard;// 获取考试的评分标准值
			score = testScore * (testStandard *0.01) + examinationScore * (examinationStandard *0.01);// 计算学分
		}
		return score;
	}

}
