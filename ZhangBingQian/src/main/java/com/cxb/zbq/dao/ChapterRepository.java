package com.cxb.zbq.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.zbq.entity.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

	@Query(value = "SELECT chapter_id FROM chapter_tb WHERE curriculum_id=?1", nativeQuery = true)
	List<Integer> getChapterIdListByCurriculumId(Integer CurriculumId);// 查询课程下对应的章节id集合

	List<Chapter> findByCurriculumId(Integer currId);// 根据课程id获取所有章节课时信息

//---------------刘宇超-------------------------------------
	// 查询出一门课程下的所有父章节对象,参数条件为课程ID
	@Query(value = "SELECT c FROM Chapter c WHERE curriculumId=?1 and parentId=?2")
	List<Chapter> findChapterById(Integer curriculumId, Integer parentId);

	// 根据父章节ID查询出该父章节所有子课时的对象
	@Query(value = "SELECT c FROM Chapter c WHERE parentId=?1")
	List<Chapter> findChapterChildrenById(Integer parentId);

	// 根据模块名称模糊查询
	@Query(value = "SELECT c.chapterId FROM Chapter c WHERE c.curriculumId=:curriculumId and c.chapterName LIKE %:chapterName%")
	List<Integer> findChapterIdsByChapterNameLike(@Param("curriculumId") Integer curriculumId,
			@Param("chapterName") String chapterName);

	// 根据模块Id查询模块父Id
	@Query(value = "SELECT c.parentId FROM Chapter c WHERE c.chapterId=?1")
	Integer queryParentIdByChapterId(Integer chapterId);

	// 根据ID查询出所有孩子
	@Query(value = "SELECT c FROM Chapter c WHERE c.chapterId IN(:rootIds)")
	List<Chapter> treeGridByChapterids(@Param("rootIds") Set<Integer> rootIds);

	// 根据章节id修改章节信息
	@Query(value = "UPDATE Chapter c SET c.chapterName=:#{#chapter.chapterName},c.chapterDescription=:#{#chapter.chapterDescription} WHERE c.chapterId=:#{#chapter.chapterId}")
	@Modifying
	@Transactional
	int updateChapter(@Param("chapter") Chapter chapter);

	// 删除章节课时
	@Query(value = "delete from Chapter c where c.chapterId=?1")
	@Modifying
	@Transactional
	int deleteChapter(Integer chapterId);
	
	//根据章节课时id查询出章节名称
	@Query(value="select c.chapterName from Chapter c where c.chapterId=?1")
	String queryChapterIdBychapterName(Integer chapterId);
	
	// 查询出一门课程下的所有父章节对象,参数条件为课程ID
		@Query(value="SELECT c.chapter_id AS chapterId,c.chapter_name AS chapterName,c.* FROM chapter_tb c WHERE c.parent_id=0 AND c.curriculum_id=?1",nativeQuery=true)
		List<Object[]> findChapterById(Integer curriculumId);
}
