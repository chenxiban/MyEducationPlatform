package com.cxb.cyj.fegin;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @Description:   调用王梦霞组的fegin类
 * @ClassName:     ConsumerServiceWang.java
 * @author         ChenYongJia
 * @Date           2018年12月09日 下午9:38:05
 * @Email          867647213@qq.com
 */
@FeignClient("wangmengxia")
public interface ConsumerServiceWang {
	
	/**
	 * 根据推荐id查询帖子信息
	 * @param postId
	 * @return
	 */
	@RequestMapping(value="/WangMengXia/post/selectPostListByPostId",method=RequestMethod.GET)
	public Map<String,Object> selectPostListByPostId(@RequestParam(value="postId")List<Integer> postId);
	
	/**
	 * 评论最多帖子前20条
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/WangMengXia/post/queryByTop",method=RequestMethod.GET)
	public Map<String,Object> queryByTop(@RequestParam(value="page")Integer page,@RequestParam(value="rows")Integer rows);
	
	/**
	 * 点赞最多帖子前20条
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/WangMengXia/post/selectPostListByTopD",method=RequestMethod.GET)
	public Map<String,Object> selectPostListByTopD(@RequestParam(value="page")Integer page,@RequestParam(value="rows")Integer rows);
	
	/**
	 * 踩赞最多帖子前20条
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/WangMengXia/post/selectPostListByTopC",method=RequestMethod.GET)
	public Map<String,Object> selectPostListByTopC(@RequestParam(value="page")Integer page,@RequestParam(value="rows")Integer rows);
	
}

