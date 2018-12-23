package com.cxb.yyc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.yyc.entity.Gapfilling;
/**
 * 教师设置填空题问题
 * @author dell
 *
 */
public interface TeacherSetGapfillingQuestionRepository extends JpaRepository<Gapfilling, Integer>{
	
	@Query(value="DELETE FROM gapfillingtb WHERE gapfilling_id=?1",nativeQuery=true)
	@Modifying
	int deleteGapfilling(Integer gapfillingId);
	
	/**
	 * 根据主键修改填空题
	 * @param gapfilling
	 * @return
	 */
	@Query(value="UPDATE gapfillingtb SET gapfilling_imgurl=:#{#gapfilling.gapfillingImgurl},gapfilling_question=:#{#gapfilling.gapfillingQuestion},gapfilling_score=:#{#gapfilling.gapfillingScore} WHERE gapfilling_id=:#{#gapfilling.gapfillingId}",nativeQuery=true)
	@Modifying
	int updateGapfillingQuestion(@Param("gapfilling") Gapfilling gapfilling);
	/**
	 * 根据章节Id和课程Id查询填空题问题
	 * @param chapterId
	 * @param courseId
	 * @return
	 */
	@Query(value="SELECT * FROM gapfillingtb WHERE gapfilling_chapter_id=?1 ",nativeQuery=true)
	List<Gapfilling> queryGapfilling(Integer chapterId);

	@Query(value="SELECT COUNT(gapfilling_question) FROM gapfillingtb WHERE gapfilling_chapter_id=?1 AND gapfilling_course_id=?2",nativeQuery=true)
	int queryGapfillingNumber(Integer chapterId,Integer courseId);
	
	/**
	 * @Description: 根据章节Id查询对应章节的判断题数目
	 * @ClassName: selectCountByGapfillingChapterId.method
	 * @author yyc
	 * @Date 2018年12月22日 下午18:07
	 * @Email yangyichenshuai@163.com
	 * @param chapterId 章节Id
	 * @return
	 */
	@Query(value=" SELECT COUNT(*) FROM gapfillingtb WHERE gapfilling_chapter_id = ?1 ",nativeQuery=true)
	int selectCountByGapfillingChapterId(Integer chapterId);
}
