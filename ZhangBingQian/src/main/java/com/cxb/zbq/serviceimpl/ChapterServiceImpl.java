package com.cxb.zbq.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.zbq.OtherEntity.CurriculumChapter;
import com.cxb.zbq.dao.ChapterRepository;
import com.cxb.zbq.entity.Chapter;
import com.cxb.zbq.service.ChapterService;
import com.cxb.zbq.utils.JpaObjectsToEntity;

@Service
public class ChapterServiceImpl implements ChapterService {
	@Autowired
	private ChapterRepository chapterRepository;

	@Override
	public List<Chapter> findByCurriculumId(Integer currId) {
		return chapterRepository.findByCurriculumId(currId);
	}

	@Override
	public List<Integer> getChapterIdListByCurriculumId(Integer CurriculumId) {
		return chapterRepository.getChapterIdListByCurriculumId(CurriculumId);
	}

//---------------刘宇超-------------------------------------
	@Override
	public Chapter insertChapte(Chapter chapter) {
		// TODO Auto-generated method stub
		return chapterRepository.save(chapter);
	}

//--------------------------当前课程下的所有章节课时TreeGrid-------------------------------------------
	@Override
	public List<Chapter> queryTreeGrid(Integer curriculumId) {
		// 查询出所有根菜单
		List<Chapter> rootList = chapterRepository.findChapterById(curriculumId, 0);
		// 递归设置子菜单
		this.setTreeGridChildrens(rootList);
		return rootList;
	}

	/**
	 * TreeGrid 给菜单模块 设置孩子
	 * 
	 * @param parentList
	 */
	private void setTreeGridChildrens(List<Chapter> parentList) {
		for (Chapter m : parentList) {

			// 查询出子菜单
			List<Chapter> childrenList = this.queryTreeGridChildrenById(m.getChapterId());
			// System.out.println("*****************************************************设置子菜单=>"+m.getModuleName());
			// 如果没有子菜单则递归结束
			if (childrenList != null && !childrenList.isEmpty()) {// 有子菜单
				// 设置子菜单
				// System.out.println("设置的子菜单是=>" + childrenList);
				m.setChildren(childrenList);
				// 如果有子菜单则继续递归设置子菜单
				this.setTreeGridChildrens(childrenList);
			}
		}
	}

	/**
	 * TreeGrid 查询模块表格 TreeGrid 查询孩子菜单
	 */
	private List<Chapter> queryTreeGridChildrenById(Integer parentId) {
		return chapterRepository.findChapterChildrenById(parentId);
	}

//----------------------------treeGrid模糊查询--------------------------
	@Override
	public List<Chapter> queryTreeGrid(Integer curriculumId, String chapterName) {
		// 查询所有满足条件的模块Id
		List<Integer> likeList = chapterRepository.findChapterIdsByChapterNameLike(curriculumId, chapterName);

		// 找到这些模块的根模块,去重复
		Set<Integer> rootIds = new HashSet<Integer>();
		for (Integer id : likeList) {
			rootIds.add(this.queryParentIdUntilZero(id));//
		}
		List<Chapter> rootList = chapterRepository.treeGridByChapterids(rootIds);
		// 递归设置子菜单
		this.setTreeGridChildrens(rootList);
		return rootList;

	}

	/**
	 * 找根模块 找父亲id为零的根模块 如果父Id不为零,则一直找
	 * 
	 * @param moduleId
	 * @return
	 */
	private Integer queryParentIdUntilZero(Integer chapterId) {
		Integer parentId = chapterRepository.queryParentIdByChapterId(chapterId);// 查找父亲id
		if (parentId == 0) {// 如果该模块父亲id为零,则该模块为根模块,则返回该模块id
			return chapterId;
		} else {
			return this.queryParentIdUntilZero(parentId);// 如果该模块不是根模块,则继续找上一级模块的父Id
		}
	}

	@Override
	public List<Chapter> getChapterByCurrId(Integer curriculumId) {
		// TODO Auto-generated method stub
		return chapterRepository.findByCurriculumId(curriculumId);
	}

	@Override
	public int updateChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		return chapterRepository.updateChapter(chapter);
	}

	@Override
	public Integer queryParentIdByChapterId(Integer chapterId) {
		// TODO Auto-generated method stub
		return chapterRepository.queryParentIdByChapterId(chapterId);
	}

	@Override
	public List<Chapter> findChapterChildrenById(Integer parentId) {
		// TODO Auto-generated method stub
		return chapterRepository.findChapterChildrenById(parentId);
	}

	@Override
	public int deleteChapter(Integer chapterId) {
		// TODO Auto-generated method stub
		return chapterRepository.deleteChapter(chapterId);
	}

	@Override
	public String queryChapterIdBychapterName(Integer chapterId) {
		// TODO Auto-generated method stub
		return chapterRepository.queryChapterIdBychapterName(chapterId);
	}

	@Override
	public List<CurriculumChapter> findChapterById(Integer curriculumId) {
		// TODO Auto-generated method stub
				List<Object[]> rootList=chapterRepository.findChapterById(curriculumId);
				List<CurriculumChapter> curriculumChapter=(List<CurriculumChapter>) JpaObjectsToEntity.jpaResultToObjectList(rootList,CurriculumChapter.class); 
				return curriculumChapter;
	}

}
