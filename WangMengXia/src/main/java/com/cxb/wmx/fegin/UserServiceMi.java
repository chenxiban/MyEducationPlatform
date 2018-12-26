package com.cxb.wmx.fegin;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @Description:   调用芈忠良组的fegin类
 * @ClassName:     UserServiceMi.java
 * @author         王梦霞
 */
@FeignClient("mizhongliang")
public interface UserServiceMi {
	
	/**
	 * 根据uId查询用户的详细信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/MiZhongLiang/usersdetails/getUserDeteils")
	public List<Integer> getUserDeteils(Integer userId);
}
