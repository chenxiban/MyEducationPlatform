package com.cxb.zbq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.zbq.entity.Chapter;
import com.cxb.zbq.service.ChapterService;
import com.cxb.zbq.utils.Result;

@RestController
@RequestMapping("/chapter")
@CrossOrigin
public class ChapterController {
	@Autowired
	private ChapterService sChapte;
	
	@RequestMapping(value = "/getChapterByCurrId", name = "李海潮组调用的数据-------根据课程id返回章节课时的集合数据")
	public Object getChapterByCurrId(Integer curriculumId) {
		return sChapte.getChapterByCurrId(curriculumId);
	}

	@RequestMapping(value = "/queryId", name = "查询章节树形数据")
	public Object queryTreeGrid(Integer curriculumId,String chapterName) {
		if(chapterName==null || "".equals(chapterName)){
			List<Chapter> list = sChapte.queryTreeGrid(curriculumId);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getParentId() == 0) {
					list.get(i).setIconCls("icon-zhangjie");
				}
				List<Chapter> childrenList = list.get(i).getChildren();
				if (childrenList != null) {

					for (int j = 0; j < childrenList.size(); j++) {
						childrenList.get(j).setIconCls("icon-keshi");
					}
				}

			}
			return list;
		}else{
			List<Chapter> list =sChapte.queryTreeGrid(curriculumId, chapterName);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getParentId() == 0) {
					list.get(i).setIconCls("icon-zhangjie");
				}
				List<Chapter> childrenList = list.get(i).getChildren();
				if (childrenList != null) {

					for (int j = 0; j < childrenList.size(); j++) {
						childrenList.get(j).setIconCls("icon-keshi");
					}
				}
			}
			return list; 
		}
	}

	@RequestMapping(value = "/add", name = "添加章节课时")
	public Object addChapte(Chapter chapter) {
		if (chapter != null) {
			if (sChapte.insertChapte(chapter) != null) {
				return new Result("添加成功", 1);
			} else {
				return new Result("添加失败", 0);
			}
		}
		return new Result("后台未接收到前台传来的值", 0);
	}
	@RequestMapping(value = "/update", name = "修改章节课时")
	public Object updateChapte(Chapter chapter) {
		if (chapter != null) {
			if (sChapte.updateChapter(chapter)>0) {
				return new Result("修改成功", 1);
			} else {
				return new Result("修改失败", 0);
			}
		}
		return new Result("后台未接收到前台传来的值", 0);

	}
	@RequestMapping(value = "/delete", name = "删除章节课时")
	public Object deleteChapte(Integer chapterId) {
		System.out.println("==================》"+chapterId);
		if (chapterId != null) {
			// 根据章节Id查询模块父Id,父id为0时证明该章节是父节点，再判断其有没有孩子
			Integer parentId=sChapte.queryParentIdByChapterId(chapterId);
			System.out.println("其父id为=1=================》"+parentId);
			if(parentId==0) {//父节点
				// 根据父章节ID查询出该父章节有没有孩子，没有可直接删除，有的话提醒有孩子不允许删除
				if(sChapte.findChapterChildrenById(chapterId).size()==0) {
					System.out.println("其父id为0时有没有孩子==================》"+sChapte.findChapterChildrenById(parentId));
					if(sChapte.deleteChapter(chapterId)>0) {
						return new Result("该章节没有子节点，删除成功", 1);
					}else {
						return new Result("删除失败", 0);
					}
				}else {
					return new Result("该章节有子菜单，请您先删除其子菜单", 0);
				}
			}else {//子节点
				System.out.println("=================》"+sChapte.findChapterChildrenById(chapterId));
				//当前章节id为子节点的话，可以直接删除，但是其下的课件也要一起删除，删除前依然进行判断看其下属有没有子节点
				if(sChapte.findChapterChildrenById(chapterId).size()==0) {
					System.out.println("其父id不为0时有没有孩子==================》"+sChapte.findChapterChildrenById(chapterId));
                  //加上一个并且同时删除课件
					if(sChapte.deleteChapter(chapterId)>0) {
						return new Result("该章节没有子节点，删除成功", 1);
					}else {
						return new Result("删除失败", 0);
					}
				}else {
					return new Result("该子菜单还有有子菜单，请您先删除其子菜单", 0);
				}
			}
		}
		return new Result("后台未接收到前台传来的值", 0);
	}

}
