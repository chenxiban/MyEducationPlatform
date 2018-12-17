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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.wmx.entity.Post;
import com.cxb.wmx.entity.Result;
import com.cxb.wmx.service.PostService;

@RestController
@RequestMapping(value="/post")
public class PostController {

	@Autowired
	private PostService postService;
	private Date date = new Date();
	@SuppressWarnings("unused")
	private Timestamp timestamp = new Timestamp(date.getTime());
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/queryPost
	 * 动态查询贴吧分类(分页)
	 * @author 王梦霞
	 * @param postSearch
	 * @return
	 */
	/*@RequestMapping(value="/queryPost")
	public Object queryPost(PostSearch post) {
		Pageable pageable = PageRequest.of(post.getPage() - 1, post.getRows(), Sort.Direction.ASC,
				"postId");
		Page<Post> page = postService.sreachByPost(post, pageable);
		System.out.println("page======>" + page);
		Long total = page.getTotalElements();
		List<Post> list = page.getContent();
		System.out.println("list======>" + list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		System.out.println("total 总数为===>" + map.get("total"));
		System.out.println("rows 数据为===>" + map.get("rows"));
		return map;
	}*/
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/queryAllPage
	 * @param id
	 * @return Post
	 * @author 王梦霞
	 * 连表动态查询分页
	 */
	@RequestMapping(value="/queryAllPage",method=RequestMethod.GET)
	public Object queryAllPage(String postName,String barCategory, int page,int rows) {
		Post post = new Post();
		post.setPostName(postName);
		post.setBarCategory(barCategory);
		Pageable pageable = PageRequest.of((page-1), rows, Sort.Direction.ASC,
				"postId");
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
	 * http://localhost:3011/wangmengxia/WangMengXia/post/deletePostById
	 * 删除帖子
	 * @author 王梦霞
	 * @param postId
	 * @return
	 */
	@RequestMapping(value="/deletePostById",method=RequestMethod.POST)
	public Object deletePostById(Integer postId) {
		return postService.deletePostById(postId);
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/queryByBarId
	 * 是否置顶,以及取消置顶
	 * @author 王梦霞
	 * @param postId
	 * @param barId
	 * @param allTop
	 * @return
	 */
	@RequestMapping(value="/queryByBarId",method=RequestMethod.POST)
	public Object queryByBarId(Integer postId, Integer barId, Integer allTop,Integer p) {
		if (p==1) {
			if (postService.queryByBarId(postId, barId, allTop)) {
				return new Result(true,"设置帖子置顶成功");
			} else {
				return new Result(false,"设置帖子置顶失败");
			}
		} else {
			if (postService.queryByPostId(postId)) {
				return new Result(true,"帖子取消置顶成功");
			} else {
				return new Result(false,"帖子取消置顶失败");
			}
		}
		
	}
	
	/**
	 * 查询评论前二十的帖子
	 * http://localhost:3011/wangmengxia/WangMengXia/post/queryByTop
	 * @return
	 */
	@RequestMapping(value="/queryByTop",method=RequestMethod.GET)
	public Map<String, Object> queryByTop(@RequestParam(value="page")Integer page,@RequestParam(value="rows")Integer rows) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", postService.queryPageTop(page,rows).size());
		map.put("rows", postService.queryPageTop(page,rows));
		return map;
	}
	
	/**
	 * 查询点赞前二十的帖子
	 * http://localhost:3011/wangmengxia/WangMengXia/post/selectPostListByTopD
	 * @return
	 */
	@RequestMapping(value="/selectPostListByTopD",method=RequestMethod.GET)
	public Map<String, Object> selectPostListByTopD(@RequestParam(value="page")Integer page,@RequestParam(value="rows")Integer rows) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", postService.selectPostListByTopD(page,rows).size());
		map.put("rows", postService.selectPostListByTopD(page,rows));
		return map;
	}
	
	/**
	 * 查询踩赞前二十的帖子
	 * http://localhost:3011/wangmengxia/WangMengXia/post/selectPostListByTopC
	 * @return
	 */
	@RequestMapping(value="/selectPostListByTopC",method=RequestMethod.GET)
	public Map<String, Object> selectPostListByTopC(@RequestParam(value="page")Integer page,@RequestParam(value="rows")Integer rows) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", postService.selectPostListByTopC(page,rows).size());
		map.put("rows", postService.selectPostListByTopC(page,rows));
		return map;
	}
}
