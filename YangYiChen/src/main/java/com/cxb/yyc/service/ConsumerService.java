package com.cxb.yyc.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cxb.yyc.entity.Permission;
/**
 * 
 * @Description:   
 * @ClassName:     ConsumerService.java
 * @author         ChenYongJia
 * @Date           2018年12月09日 下午9:38:05
 * @Email          867647213@qq.com
 */
@FeignClient("chenyongjia")
public interface ConsumerService {
	
	/**
	 * 查询chenyongjia服务数据库权限
	 * @return
	 */
	@RequestMapping(value="/ChenYongJia/permission/queryAll",method=RequestMethod.POST)
	public List<String> queryAll();
	
	/**
	 * 向chenyongjia服务数据库添加权限
	 * @return
	 */
	@RequestMapping(value="/ChenYongJia/permission/batchInsert",method=RequestMethod.POST)
	public Integer batchInsert(@RequestBody List<Permission> pList);
	
	
	/**
	 * 执行向chenyongjia服务数据库添加权限
	 * @return
	 */
	@RequestMapping(value="/ChenYongJia/permission/updatePermission",method=RequestMethod.POST)
	public String updatePermission(@RequestParam(value="ks")int ks);
	
}
