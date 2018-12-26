package com.cxb.yyc.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cxb.yyc.entity.TeacherCreateTest;
/**
 * 记录教师发起的测试题
 * @author dell
 *
 */
public interface TeacherSetTestService {
	
	
	/**
	 * 教师发起测试，向教师发起测试表中添加一条数据
	 * @param teacherCreateTest
	 * @return
	 */
	TeacherCreateTest insertTeacherCreateTest(TeacherCreateTest teacherCreateTest);
	/**
	 * 根据教师Id查询教师发起的测试
	 * @param tid
	 * @return
	 */
	List<TeacherCreateTest> queryTeacherCreateTest(Integer tid);
	/**
	 * 根据教师发起测试主键将发布状态未发布修改已发布状态 0-->1
	 * @param testId
	 * @return
	 */
	int updateTeacherCreateTestState(Integer testId);
	/**
	 * 根据教师发起测试主键将发布状态未发布修改已发布状态 1-->0
	 * @param testId
	 * @return
	 */
	int updateTeacherCreateTestStateForZero(Integer testId);

	/**
	 * 在main.html页面当中教师删除创建的测试题
	 * @param testId
	 * @return
	 */
	int deleteTest(Integer testId);
	
	/**
	 * @Description: 根据章节Id修改对应章节的判断题数目
	 * @ClassName: selectCountByTfngChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param num 数量
	 * @param chapterId 章节Id
	 * @return
	 */
	int updateTfngNumByChapterId(Integer num,Integer chapterId);
	
	/**
	 * @Description: 根据章节Id修改对应章节的判断题数目
	 * @ClassName: updateGapfillingNumByChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param num 数量
	 * @param chapterId 章节Id
	 * @return
	 */
	int updateGapfillingNumByChapterId(Integer num,Integer chapterId);
	
	/**
	 * @Description: 根据章节Id修改对应章节的判断题数目
	 * @ClassName: updateChoiceNumByChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param num 数量
	 * @param chapterId 章节Id
	 * @return
	 */
	int updateChoiceNumByChapterId(Integer num,Integer chapterId);

	/**
	 * @Description: 根据测试Id查询
	 * @ClassName: selectByTestId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param testId 数量
	 * @return
	 */
	int selectByTestIdForChapterId(Integer testId);

	/**
	 * 根据课程Id章节Id查询测试结束时间
	 * @param courseId
	 * @param chapterId
	 * @return
	 */
	String queryTestEndTime(Integer courseId,Integer chapterId);
	
	/**
	 * 根据章节Id和课程Id查询测试可以测试的次数
	 * @param courseId
	 * @param chapterId
	 * @return
	 */
	int querytestMaxNum(Integer courseId,Integer chapterId);


}
