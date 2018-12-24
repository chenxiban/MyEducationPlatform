package com.cxb.zbq.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.zbq.entity.CoverMap;

public interface CoverMapRepository extends JpaRepository<CoverMap, String>{
	
	/*@Query(value="",nativeQuery=true)
	@Transactional@Modifying
	Integer deleteCoverMap(String covermapId);//根据id删除课程封面图信息
*/
}
