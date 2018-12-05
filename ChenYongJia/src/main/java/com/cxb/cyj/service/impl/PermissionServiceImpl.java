package com.cxb.cyj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.PermissionRepository;
import com.cxb.cyj.entity.Permission;
import com.cxb.cyj.service.PermissionService;

/**
 * 
 * @Description:   权限业务实现类
 * @ClassName:     PermissionServiceImpl.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	/**
	 * 查询所有权限集合
	 * @return 权限字符串集合
	 * @author Chenyongjia
	 */
	@Override
	public List<String> queryAll() {
		List<String> pList=new ArrayList<String>();
		List<Permission> list=permissionRepository.findAll();
		for (int i = 0; i < list.size(); i++) {
			pList.add(list.get(i).getPermissionValue());
		}
		return pList;
	}

	/**
	 * 批量插入权限数据
	 * @param pList
	 * @return 成功插入的权限数据条数
	 * @author Chenyongjia
	 */
	@Override
	public Integer batchInsert(List<Permission> pList) {
		Integer num=0;
		for (int i = 0; i < pList.size(); i++) {
			Permission entity=pList.get(i);
			if (permissionRepository.save(entity) != null) {
				num+=1;
			} 
		}
		return num;
	}

}
