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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Post;
import com.cxb.wmx.entity.Result;
import com.cxb.wmx.service.PostService;
import com.cxb.wmx.service.UserService;

@RestController
@RequestMapping(value = "/post")
public class PostController {

	@Autowired
	private PostService postService;
	@SuppressWarnings("unused")
	@Autowired
	private UserService userService;
	private Date date = new Date();
	@SuppressWarnings("unused")
	private Timestamp timestamp = new Timestamp(date.getTime());

	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/queryAllPage
	 * 
	 * @param id
	 * @return Post
	 * @author 王梦霞 连表动态查询分页
	 */
	@RequestMapping(value = "/queryAllPage", method = RequestMethod.GET)
	public Object queryAllPage(String postName, String barCategory, int page, int rows) {
		Post post = new Post();
		post.setPostName(postName);
		post.setBarCategory(barCategory);
		Pageable pageable = PageRequest.of((page - 1), rows, Sort.Direction.ASC, "postId");
		Page<Post> page1 = postService.queryAllPage(post, pageable);
		System.out.println("page======>" + page);
		Long total = page1.getTotalElements();
		List<Post> list = page1.getContent();
		System.out.println("list======>" + list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		System.out.println("total 总数为===>" + map.get("total"));
		System.out.println("rows 数据为===>" + map.get("rows"));
		return map;
	}

	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/deletePostById 删除帖子
	 * 
	 * @author 王梦霞
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = "/deletePostById", method = RequestMethod.POST)
	public Object deletePostById(Integer postId) {
		return postService.deletePostById(postId);
	}

	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/queryByBarId 是否置顶,以及取消置顶
	 * 
	 * @author 王梦霞
	 * @param postId
	 * @param barId
	 * @param allTop
	 * @return
	 */
	@RequestMapping(value = "/queryByBarId", method = RequestMethod.POST)
	public Object queryByBarId(Integer postId, Integer barId, Integer allTop, Integer p) {
		if (p == 1) {
			if (postService.queryByBarId(postId, barId, allTop)) {
				return new Result(true, "设置帖子置顶成功");
			} else {
				return new Result(false, "设置帖子置顶失败");
			}
		} else {
			if (postService.queryByPostId(postId)) {
				return new Result(true, "帖子取消置顶成功");
			} else {
				return new Result(false, "帖子取消置顶失败");
			}
		}

	}

	/**
	 * @author 王梦霞 查询评论前二十的帖子
	 *         http://localhost:3011/wangmengxia/WangMengXia/post/queryByTop
	 * @return
	 */
	@RequestMapping(value = "/queryByTop", method = RequestMethod.GET)
	public Map<String, Object> queryByTop(@RequestParam(value = "page") Integer page,
			@RequestParam(value = "rows") Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", postService.queryPageTop(page, rows).size());
		map.put("rows", postService.queryPageTop(page, rows));
		return map;
	}

	/**
	 * @author 王梦霞 查询点赞前二十的帖子
	 *         http://localhost:3011/wangmengxia/WangMengXia/post/selectPostListByTopD
	 * @return
	 */
	@RequestMapping(value = "/selectPostListByTopD", method = RequestMethod.GET)
	public Map<String, Object> selectPostListByTopD(@RequestParam(value = "page") Integer page,
			@RequestParam(value = "rows") Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", postService.selectPostListByTopD(page, rows).size());
		map.put("rows", postService.selectPostListByTopD(page, rows));
		return map;
	}

	/**
	 * 查询踩赞前二十的帖子
	 * 
	 * @author 王梦霞
	 *         http://localhost:3011/wangmengxia/WangMengXia/post/selectPostListByTopC
	 * @return
	 */
	@RequestMapping(value = "/selectPostListByTopC", method = RequestMethod.GET)
	public Map<String, Object> selectPostListByTopC(@RequestParam(value = "page") Integer page,
			@RequestParam(value = "rows") Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", postService.selectPostListByTopC(page, rows).size());
		map.put("rows", postService.selectPostListByTopC(page, rows));
		return map;
	}

	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/deleteUserPostByPid?pid=29
	 * 用户删除自己发的帖子
	 * 
	 * @author 王梦霞
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/deleteUserPostByPid")
	public Object deleteUserPostByPid(Integer pid) {
		if (postService.deleteUserPostByPid(pid)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据某个帖子的评论,点赞,以及踩赞总数
	 * http://localhost:3011/wangmengxia/WangMengXia/post/queryPostComByPid?pid=1
	 * 
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/queryPostComByPid")
	public Object queryPostComByPid(Integer pid) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Post> pid1 = postService.selectPostByPid(pid);
		map.put("postCmmit", postService.queryPostComByPid(pid));
		map.put("postLike", postService.queryPostLikeByPidDz(pid));
		map.put("postDisLike", postService.queryPostLikeByPidCz(pid));
		return map;
	}

	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/queryPostTimeDesc
	 * 按照时间对帖子进行排序未分页
	 * 
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value = "/queryPostTimeDesc")
	public Object queryPostTimeDesc() {
		return postService.queryPostTimeDesc();
	}

	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/selectPostListByPostId?postId=1,2,3
	 * 给陈永佳组提供的查询帖子详情的方法
	 * 
	 * @author 王梦霞
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = "/selectPostListByPostId")
	public Map<String, Object> selectPostListByPostId(@RequestBody List<Integer> postId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", postService.selectPostListByPostId(postId).size());
		map.put("rows", postService.selectPostListByPostId(postId));
		return map;
	}

	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/addLayuiPost 发帖人进行发帖
	 * 
	 * @author 王梦霞
	 * @param post
	 * @return
	 */
	@RequestMapping(value = "/addLayuiPost")
	public Object addLayuiPost(Post post) {
		post.setPostCreatetime(new Date());
		post.setUserId(1);// 这个值到时候用token换取
		post.setPostName("王哈哈");// 这个值也是用token换取来的用户id去调用芈忠良的接口获得用户昵称
		post.setPostReport(0);// 默认为0不置顶
		if (postService.addLauyiPost(post)) {
			return new Result(true, "帖子发表成功");
		} else {
			return new Result(false, "帖子发表失败");
		}
	}
}
