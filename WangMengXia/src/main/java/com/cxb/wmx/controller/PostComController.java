package com.cxb.wmx.controller;

import java.sql.Timestamp;
import java.util.Date;
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

import com.cxb.wmx.entity.Postcommit;
import com.cxb.wmx.entitysearch.PostComSearch;
import com.cxb.wmx.service.PostComService;

@RestController
@RequestMapping(value="/postCom")
public class PostComController {

	@Autowired
	private PostComService postComService;
	private Date date = new Date();
	private Timestamp timestamp = new Timestamp(date.getTime());
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postCom/queryPostCom
	 * 动态查询贴吧分类(分页)
	 * @author 王梦霞
	 * @param barSearch
	 * @return
	 */
	@RequestMapping(value="/queryPostCom",method=RequestMethod.GET)
	public Object queryPostCom(PostComSearch postComSearch) {
		Pageable pageable = PageRequest.of(postComSearch.getPage() - 1, postComSearch.getRows(), Sort.Direction.ASC,
				"postcommitId");
		Page<Postcommit> page = postComService.sreachByPostCom(postComSearch, pageable);
		System.out.println("page======>" + page);
		Long total = page.getTotalElements();
		List<Postcommit> list = page.getContent();
		System.out.println("list======>" + list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		System.out.println("total 总数为===>" + map.get("total"));
		System.out.println("rows 数据为===>" + map.get("rows"));
		return map;
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postCom/deletePostCommitById
	 * 删除
	 * @author 王梦霞
	 * @param prId
	 * @return
	 */
	@RequestMapping(value="/deletePostCommitById",method=RequestMethod.POST)
	public Object deletePostCommitById(Integer postcommitId) {
		System.out.println("当前要删除的评论id为====>"+postcommitId);
		return postComService.deletePostCommitById(postcommitId);
	} 
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postCom/deleteUserPostComByPid
	 * 删除
	 * @author 王梦霞
	 * @param prId
	 * @return
	 */
	@RequestMapping(value="/deleteUserPostComByPid",method=RequestMethod.POST)
	public Object deleteUserPostComByPid(Integer postcommitId) {
		System.out.println("当前要删除的评论id为====>"+postcommitId);
		if (postComService.deleteUserPostComByPid(postcommitId)) {
			return true;
		} else {
			return false;
		}
	} 
	/**
	 * 根据某个评论的回复点赞,以及踩赞总数
	 * http://localhost:3011/wangmengxia/WangMengXia/postCom/queryPostReplyByPid?pid=1
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="/queryPostReplyByPid")
	public Object queryPostReplyByPid(Integer pid) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<Postcommit> pid1=postComService.selectPostCommitByPid(pid);
		map.put("replyCount",postComService.queryPostReplyByPid(pid));
		map.put("commitLike", postComService.queryPostReplyLikeByPidDz(pid));
		map.put("commitDisLike",postComService.queryPostReplyLikeByPidCz(pid));
		return map;
	}
	
	/**
	 *  http://localhost:3011/wangmengxia/WangMengXia/postCom/selectPostComPage
	 *  http://localhost:3011/WangMengXia/postCom/queryPage
	 * 查询个人中心讨论(评论分页)
	 * @author 刘森川
	 * @param postSearch
	 * @return
	 */
	@RequestMapping(value="/selectPostComPage")
    public Object selectPostComPage(Integer page,Integer rows) {
    	Page<Postcommit> pageList= null;
    	pageList = postComService.selectPostComPage(1, 10);//第2页,每页3条;第几页从零开始,每页显示几条.
    	System.out.println("queryPage page=>"+page);
    	Long total = pageList.getTotalElements();
    	List<Postcommit> list = pageList.getContent();
    	Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
    }
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postCom/selectPostComByUser?userId=1
	 * 查询所有评论
	 * @author 刘森川
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectPostComByUser")
	public Object selectPostComByUser(Integer userId) {
		return postComService.selectPostComByUser(userId);
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postCom/selectPostCommitCount?userId=1
	 * 查询讨论评论总数
	 * @author 刘森川
	 * @param postcommitName
	 * @return
	 */
	@RequestMapping(value="/selectPostCommitCount")
	public Object selectPostCommitCount(Integer userId) {
		return postComService.selectPostCommitCount(userId);
	}
	
	/**
	 *http://localhost:3011/wangmengxia/WangMengXia/postCom/selectPostCommitCtime?userId=1
	 * http://localhost:3011/WangMengXia/postCom/selectPostCommitCtime?userId=1
	 * 查询发表评论的时间,内容,帖子id
	 * @author 刘森川
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectPostCommitCtime")
	public Object selectPostCommitCtime(Integer userId) {
		return postComService.selectPostCommitCtime(userId);
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/postCom/selectPostCommitPost?postId=1
	 * http://localhost:3011/WangMengXia/postCom/selectPostCommitPost?userId=1
	 * 根据主题id查询主题
	 * @author 刘森川
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectPostCommitPost")
	public Object selectPostCommitPost(Integer postId) {
		return postComService.selectPostCommitPost(postId);
	}

}
