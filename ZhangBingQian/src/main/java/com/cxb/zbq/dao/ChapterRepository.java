package com.cxb.zbq.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cxb.zbq.entity.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Integer>{

	@Query(value = "SELECT chapter_id,chapter_description,chapter_name,creation_time,curriculum_id,end_time,last_updte_time,opening_hours,parent_id FROM chapter_tb WHERE curriculum_id=?1", nativeQuery = true)
	List<Chapter> getChapterListByCurriculumId(Integer CurriculumId);// 查询课程下对应的章节信息集合
}
