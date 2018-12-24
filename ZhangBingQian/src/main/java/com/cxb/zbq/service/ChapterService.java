package com.cxb.zbq.service;

import java.util.List;

import com.cxb.zbq.entity.Chapter;

public interface ChapterService {

	List<Integer> getChapterIdListByCurriculumId(Integer CurriculumId);// 查询课程下对应的章节id集合

	List<Chapter> findByCurriculumId(Integer currId);// 根据课程id获取所有章节课时信息
//---------------刘宇超-------------------------------------	
	// 李海潮组调用的数据-------根据课程id返回章节课时的集合数据

	List<Chapter> getChapterByCurrId(Integer curriculumId);

	// 显示当前课程的所有章节和课时
	List<Chapter> queryTreeGrid(Integer curriculumId);

	List<Chapter> queryTreeGrid(Integer curriculumId, String chapterName);

	// 添加章节(父)与课时(子)
	Chapter insertChapte(Chapter chapter);

	// 根据章节id修改章节信息
	public int updateChapter(Chapter chapter);

	// 删除章节课时
	int deleteChapter(Integer chapterId);

	// 根据模块Id查询模块父Id
	Integer queryParentIdByChapterId(Integer chapterId);

	// 根据父章节ID查询出该父章节所有子课时的对象
	List<Chapter> findChapterChildrenById(Integer parentId);
}
