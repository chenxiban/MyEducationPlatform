package com.cxb.wmx.fegin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/usersdetails")
public class UserControllerMi {

	@Autowired
	private UserServiceMi uServiceMi;
	
	/**
	 * http://localhost:3011/wangmengxia/WangMengXia/usersdetails/getUserDeteils?userId=1
	 * @author 王梦霞
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/getUserDeteils")
	public List<Integer> getUserDeteils(Integer userId){
		return uServiceMi.getUserDeteils(userId);
	}
}
