	package com.cxb.wmx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Postreply;
import com.cxb.wmx.entitysearch.PostreplySearch;
import com.cxb.wmx.service.PostreplyService;

/**
 * 回复控制层
 * @author 王梦霞
 *
 */
@RestController
@RequestMapping(value="/postReply")
public class PostreplyController {

	@Autowired
	private PostreplyService postreplyService;
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postReply/queryPostreply
	 * 动态查询贴吧分类(分页)
	 * @author 王梦霞
	 * @param barSearch
	 * @return
	 */
	@RequestMapping(value="/queryPostreply",method=RequestMethod.GET)
	public Object queryPostreply(PostreplySearch postreplySearch) {
		Pageable pageable = PageRequest.of(postreplySearch.getPage() - 1, postreplySearch.getRows(), Sort.Direction.ASC,
				"postreplyId");
		Page<Postreply> page = postreplyService.sreachByPostreply(postreplySearch, pageable);
		System.out.println("page======>" + page);
		Long total = page.getTotalElements();
		List<Postreply> list = page.getContent();
		System.out.println("list======>" + list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		System.out.println("total 总数为===>" + map.get("total"));
		System.out.println("rows 数据为===>" + map.get("rows"));
		return map;
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postReply/deletePostRepById
	 * 删除
	 * @author 王梦霞
	 * @param prIddeleteUserPostreplyById
	 * @return
	 */
	@RequestMapping(value="/deletePostRepById")
	public Object deletePostRepById(Integer hfId) {
		return postreplyService.deletePostreplyById(hfId);
	} 
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postReply/deleteUserPostreplyById
	 * 删除
	 * @author 王梦霞
	 * @param prId
	 * @return
	 */
	@RequestMapping(value="/deleteUserPostreplyById",method=RequestMethod.POST)
	public Object deleteUserPostreplyById(Integer hfId) {
		if (postreplyService.deleteUserPostreplyById(hfId)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postReply/selectAllRepByhfId?hfId=1
	 * 根据回复id,查询回复下的点赞,踩赞总数
	 * @author 王梦霞
	 * @param hfId
	 * @return
	 */
	@RequestMapping(value="/selectAllRepByhfId")
	public Object selectAllRepByhfId(Integer hfId) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<Postreply> rid=postreplyService.selectAllRelByhfId(hfId);
		map.put("replyLike", postreplyService.queryPostReplyLikeByhfIdDz(hfId));
		map.put("replyDisLike", postreplyService.queryPostReplyLikeByhfIdCz(hfId));
		return map;
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postReply/selectPageByPostreply?userName=倾宸
	 * 动态查询个人中心讨论(回复分页)
	 * @author 刘森川
	 * @param barSearch
	 * @return
	 */
/*	@RequestMapping(value="/selectPageByPostreply")
	public Object selectPageByPostreply(PostreplySearch postreplySearch) {
		Pageable pageable = PageRequest.of(postreplySearch.getPage(), postreplySearch.getRows(), Sort.Direction.ASC,"postreplyId");
		Page<Postreply> page = postreplyService.selectPageByPostreply(postreplySearch, pageable);
		System.out.println("page======>" + page);
		Long total = page.getTotalElements();
		List<Postreply> list = page.getContent();
		System.out.println("list======>" + list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		System.out.println("total 总数为===>" + map.get("total"));
		System.out.println("rows 数据为===>" + map.get("rows"));
		return map;
	}*/
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postReply/selectPostReplyCount?userId=1
	 * 查询讨论总回复数
	 * @author 刘森川
	 * @param postName
	 * @return
	 */
	@RequestMapping(value="/selectPostReplyCount")
	public Object selectPostReplyCount(Integer userId) {
		return postreplyService.selectPostReplyCount(userId);
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postReply/queryPage
	 * http://localhost:3030/WangMengXia/postReply/queryPage
	 * 查询个人中心讨论(回复分页)
	 * @author 刘森川
	 * @param postSearch
	 * @return
	 */
	@RequestMapping(value="/queryPage")
    public Object queryPage(Integer page,Integer size) {
    	Page<Postreply> pageList= null;
    	pageList = postreplyService.queryAllPage(1, 10);//第2页,每页3条;第几页从零开始,每页显示几条.
    	System.out.println("queryPage page=>"+page);
    	Long total = pageList.getTotalElements();
    	List<Postreply> list = pageList.getContent();
    	Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
    }
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postReply/selectPostReplyCtime?userId=1
	 * 查询发表回复的时间,内容,帖子id
	 * @author 刘森川
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectPostReplyCtime")
	public Object selectPostReplyCtime(Integer userId) {
		return postreplyService.selectPostReplyCtime(userId);
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postReply/selectPostReplyPostCom?postId=1
	 * 查询发表回复的时间,内容,帖子id
	 * @author 刘森川
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectPostReplyPostCom")
	public Object selectPostReplyPostCom(Integer postId) {
		return postreplyService.selectPostReplyPostCom(postId);
	}
	
}
