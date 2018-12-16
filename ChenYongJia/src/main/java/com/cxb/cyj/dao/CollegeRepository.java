package com.cxb.cyj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cxb.cyj.entity.College;

/**
 * 
 * @Description: 机构设置Dao接口
 * @ClassName: CollegeRepository.java
 * @author Chenyongjia
 * @Date 2018年11月12日 下午22:01
 * @Email 867647213@qq.com
 */
public interface CollegeRepository extends JpaRepository<College, Integer>, JpaSpecificationExecutor<College> {
	
	/**
	 * 根据collegeRmark=2查询
	 * 
	 * @param collegeRmark
	 * @return
	 * @author Chenyongjia
	 */
	List<College> findByCollegeRmark(Integer collegeRmark);
	
	/**
	 * 根据根节点查询
	 * @param id
	 * @author Chenyongjia
	 * @return
	 */
	@Query(value = "SELECT college_id,college_creat_time,college_founder,college_name,college_parent_id,college_path,college_rmark,college_update_man,college_update_time,college_weight,college_organization_id FROM tb_college WHERE college_parent_id=:parentId", nativeQuery = true)
	List<College> queryChildren(@Param("parentId") Integer parentId);
	
}
