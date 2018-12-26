package com.cxb.zbq.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxb.zbq.OtherEntity.Usersdetails;

@FeignClient(value="mizhongliang/MiZhongLiang")
public interface MiFeign {
	
	@RequestMapping(value="/usersdetails/queryTeacherIdAndName")
	public List<Usersdetails> queryTeacherIdAndName();

	@RequestMapping(value="/usersdetails/queryStudentIdAndName")
	public List<Usersdetails> queryStudentIdAndName();
}
