package com.cxb.mzl.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cxb.mzl.entity.Clazz;
import com.cxb.mzl.entity.College;

/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午9:20:12
*类说明   获取用户学院/院系/专业/班级的业务类
*注：无Class实体类 无College实体类
*/
@FeignClient("chenyongjia")
public interface ClazzService {
	@RequestMapping("/ChenYongJia/clazz/getClassInfo") 
	public List<Clazz> getClassInfo(@RequestParam(value="userId") Integer userId);
	@RequestMapping(value="/ChenYongJia/college/getCollegeInfo",method=RequestMethod.GET)
	public List<College> getCollegeInfo(@RequestParam(value="userId") Integer userId);
	/**
	 * 推荐课程:推荐的十二个 id
	 * */
	@RequestMapping("/ChenYongJia/course/getCourseId") 
	public List <Integer> getCourseId();
	/**
	 * 推荐帖子:推荐的十个 id
	 * */
	@RequestMapping("/ChenYongJia/post/getPostId") 
	public List <Integer> getPostId(); 
}
