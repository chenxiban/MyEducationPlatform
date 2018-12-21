package com.cxb.yyc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.yyc.entity.Tfng;
/**
 * 教师设置判断题问题
 * @author dell
 *
 */
public interface TeacherSetTfngQuestionRepository extends JpaRepository<Tfng, Integer>{
	
	/**
	 * 根据问题判断题Id删除问题
	 * @param tfngId
	 * @return
	 */
	@Query(value="DELETE FROM tfngtb WHERE tfng_id=?1",nativeQuery=true)
	@Modifying
	int deleteTfng(Integer tfngId);
	/**
	 * 根据问题主键修改问题
	 * @param tfng
	 * @return
	 */
	@Query(value="UPDATE tfngtb SET tfng_imgurl=:#{#tfng.tfngImgurl},tfng_question=:#{#tfng.tfngQuestion},tfng_score=:#{#tfng.tfngScore} WHERE tfng_id=:#{#tfng.tfngId}",nativeQuery=true)
	@Modifying
	int updateTfng(@Param("tfng")Tfng tfng);
	/**
	 * 根据章节Id和课程Id查询判断题问题
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	@Query(value="select * from tfngtb where tfng_chapter_id=1 and tfng_course_id=1",nativeQuery=true)
	List<Tfng> queryTfng(Integer chapterId,Integer courseId);

}