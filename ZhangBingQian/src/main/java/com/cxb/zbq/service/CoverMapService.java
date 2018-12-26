package com.cxb.zbq.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cxb.zbq.entity.CoverMap;

public interface CoverMapService {
	
	CoverMap insertCoverMap(CoverMap coverMap);//添加课程封面图信息

	/*Integer deleteCoverMap(String covermapId);//根据id删除课程封面图信息
*/	
	List<CoverMap> getAllCovermap();//获取所有课程封面图

}
