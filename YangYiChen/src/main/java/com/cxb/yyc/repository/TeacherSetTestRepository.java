package com.cxb.yyc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.yyc.entity.TeacherCreateTest;

/**
 * 教师发起测试
 * @author dell
 *
 */
public interface TeacherSetTestRepository extends JpaRepository<TeacherCreateTest, Integer>{

	/**
	 * 根据教师Id查询教师发起的测试
	 * @param tid
	 * @return
	 */
	@Query(value="SELECT * FROM teachercreatetesttb WHERE teachercreatetest_teacher_id=?1",nativeQuery=true)
	List<TeacherCreateTest> queryTeacherCreateTest(Integer tid);
	/**
	 * 根据教师发起测试主键将发布状态未发布修改已发布状态 0-->1
	 * @param testId
	 * @return
	 */
	@Query(value="UPDATE teachercreatetesttb SET teachercratetest_state=1 WHERE teachercreatetest_id=?1",nativeQuery=true)
	@Modifying
	int updateTeacherCreateTestState(Integer testId);
	
	/**
	 * 根据教师发起测试主键将已发布状态未发布修改未发布状态1--->0
	 * @param testId
	 * @return
	 */
	@Query(value="UPDATE teachercreatetesttb SET teachercratetest_state=0 WHERE teachercreatetest_id=?1",nativeQuery=true)
	@Modifying
	int updateTeacherCreateTestStateForZero(Integer testId);
	
	/**
	 * 在main.html页面当中教师删除创建的测试题
	 * @param testId
	 * @return
	 */
	@Query(value=" DELETE FROM teachercreatetesttb WHERE teachercreatetest_id =?1 ",nativeQuery=true)
	@Modifying
	int deleteTest(Integer testId);
	
	
	/**
	 * @Description: 根据章节Id修改对应章节的判断题数目
	 * @ClassName: updateTfngNumByChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param num 数量
	 * @param chapterId 章节Id
	 * @return
	 */
	@Query(value=" UPDATE teachercreatetesttb SET teachercratetest_tfngnum = ?1 WHERE teachercreatetest_chapter_id = ?2 ",nativeQuery=true)
	@Modifying
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
	@Query(value=" UPDATE teachercreatetesttb SET teachercratetest_gapfillingnum = ?1 WHERE teachercreatetest_chapter_id = ?2 ",nativeQuery=true)
	@Modifying
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
	@Query(value=" UPDATE teachercreatetesttb SET teachercratetest_choicenum = ?1 WHERE teachercreatetest_chapter_id = ?2 ",nativeQuery=true)
	@Modifying
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
	@Query(value=" SELECT teachercreatetest_chapter_id FROM teachercreatetesttb WHERE teachercreatetest_id = ?1 ",nativeQuery=true)
	int selectByTestIdForChapterId(Integer testId);
	
}
