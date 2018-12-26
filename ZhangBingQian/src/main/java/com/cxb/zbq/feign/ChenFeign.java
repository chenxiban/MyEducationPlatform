package com.cxb.zbq.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cxb.zbq.OtherEntity.College;


@FeignClient(value="chenyongjia/ChenYongJia")
public interface ChenFeign {
	
	@RequestMapping(value="/college/getCollegeInfos",method=RequestMethod.GET)
	public List<College> getCollegeInfos();

}
