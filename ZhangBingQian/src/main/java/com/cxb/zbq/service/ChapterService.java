package com.cxb.zbq.service;

import java.util.List;

import com.cxb.zbq.entity.Chapter;

public interface ChapterService {
	
	List<Chapter> getChapterListByCurriculumId(Integer CurriculumId);// 查询课程下对应的章节信息集合

}
