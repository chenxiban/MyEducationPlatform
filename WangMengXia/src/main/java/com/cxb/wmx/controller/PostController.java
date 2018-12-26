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

import com.cxb.wmx.dao.PostBar;
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
	 * http://localhost:3011/wangmengxia/WangMengXia/post/findByPostId
	 * 根据id查详细信息
	 * @author 王梦霞
	 * @param postId
	 * @return
	 */
	@RequestMapping(value="/findByPostId",method=RequestMethod.GET)
	public Object findByPostId(Integer postId) {
		return postService.findByPostId(postId);
	}
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
		@SuppressWarnings("unused")
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
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/delPostById
	 * @param postId
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/delPostById")
	public Object delPostById(Integer postId) {
		if (postService.delPostById(postId)) {
			return new Result(true, "帖子删除成功");
		} else {
			return new Result(false, "该帖子未被举报,或未举报成功,帖子删除失败");
		}
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/findByPostReport?page=1&size=5
	 * @param postId
	 * 查询位举报的帖子
	 * @author 王梦霞
	 * @return
	 */
	@RequestMapping(value="/findByPostReport",method=RequestMethod.GET)
	public Object findByPostReport(Integer postReport,@RequestParam("page") Integer page,@RequestParam("size") Integer size){
		
		Map<String, Object> map=new HashMap<String, Object>();
		Pageable pageable=PageRequest.of(page-1, size);
		Page<Post> list=postService.findByPostReport(0,pageable);
		
		List<Post> list2=list.getContent();
		long count=list.getTotalElements();
		for (int i = 0; i < list2.size(); i++) {
			// 用于存储点赞数
			list2.get(i).setPostLikeNum(postService.queryPostLikeByPidDz(list2.get(i).getPostId()));
			// 用于存储评论数
			list2.get(i).setPostCommitNume(postService.queryPostComByPid(list2.get(i).getPostId()));
		}
		
		map.put("total", count);
		map.put("rows", list2);
		return map;
	}
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/queryPage
	 * http://localhost:3030/WangMengXia/post/queryPage
	 * 查询个人中心讨论(主题分页)
	 * @author 刘森川
	 * @param postSearch
	 * @return
	 */
	@RequestMapping(value="/queryPage")
    public Object queryPage(Integer page,Integer size) {
    	Page<Post> pageList= null;
    	pageList = postService.queryAllPage(1, 10);//第2页,每页3条;第几页从零开始,每页显示几条.
    	System.out.println("queryPage page=>"+page);
    	Long total = pageList.getTotalElements();
    	List<Post> list = pageList.getContent();
    	Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
    }
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/selectPostCount?userId=1
	 * 查询讨论主题总数
	 * @author 刘森川
	 * @param postName
	 * @return
	 */
	@RequestMapping(value="/selectPostCount")
	public Object selectPostCount(Integer userId) {
		return postService.selectPostCount(userId);
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/selectPostA?userId=1
	 * http://localhost:3030/WangMengXia/post/selectPostA?userId=1
	 * 查询发表主题的标题，部分内容，用户，时间, 分类
	 * @author 刘森川
	 * @param postName
	 * @return
	 */
	@RequestMapping(value="/selectPostA")
	public List<PostBar> selectPostA(Integer userId){
		return postService.selectPostA(userId);
	}
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/selectPostCommit?userId=1
	 *  http://localhost:3011/WangMengXia/post/selectPostCommit?userId=1
	 * 查询发表主题的总评论数
	 * @author 刘森川
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectPostCommit")
	public Object selectPostCommit(Integer userId) {
		return postService.selectPostCommit(userId);
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/selectPostDZ?postId=1
	 * 查询主题总点赞数
	 * @author 刘森川
	 * @param postId
	 * @return
	 */
	@RequestMapping(value="/selectPostDZ")
	public Object selectPostDZ(Integer postId) {
		return postService.selectPostDZ(postId);
	}
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/post/selectPostCom?postId=1
	 * http://localhost:3011/WangMengXia/post/selectPostCom?postId=1
	 * 查询该主题的评论数
	 * @author 刘森川
	 * @param postId
	 * @return
	 */
	@RequestMapping(value="/selectPostCom")
	public Object selectPostCom(Integer postId) {
		return postService.selectPostCom(postId);
	}
}
