package com.cxb.cyj.fegin;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @Description:   调用王梦霞组的fegin类
 * @ClassName:     ConsumerServiceWang.java
 * @author         ChenYongJia
 * @Date           2018年12月09日 下午9:38:05
 * @Email          867647213@qq.com
 */
@FeignClient("zhangbingqian")
public interface ConsumerServiceZhang {
	
	/**
	 * 根据推荐id查询帖子信息
	 * @param postId
	 * @return
	 */
	@RequestMapping(value="/ZhangBingQian/curriculum/getCurrIdBySubscriptionNum",method=RequestMethod.GET)
	public Map<String,Object> getCurrIdBySubscriptionNum();
	
}

