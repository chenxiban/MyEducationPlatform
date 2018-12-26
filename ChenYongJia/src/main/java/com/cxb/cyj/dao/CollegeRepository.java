package com.cxb.cyj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.cyj.entity.College;
import com.cxb.cyj.entity.Organization;

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
	 * 根据organization查询
	 * @param organization
	 * @return
	 */
	List<College> findByOrganization(Organization organization);
	
	/**
	 * 根据id查询
	 * @param collegeId
	 * @return
	 */
	College findByCollegeId(Integer collegeId);
	
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
	
	/**
	 * 批量删除机构信息
	 * 
	 * @param stuList
	 * @return
	 */
	@Query(value = "DELETE FROM tb_college WHERE college_id IN (:stuList)", nativeQuery = true)
	@Modifying
	@Transactional
	Integer deleteBatch(@Param(value = "stuList") List<String> stuList);
	
	/**
	 * 根据父id查询子菜单
	 * @param parentId
	 * @return
	 */
	@Query(value = "SELECT college_id FROM tb_college WHERE college_parent_id IN(:parentId)", nativeQuery = true)
	List<Integer> getChildrenByParentId(@Param("parentId") List<String> parentId);
	
	/**
	 * 根据父id查询孙子菜单
	 * @param parentId
	 * @return
	 */
	@Query(value = "SELECT college_id FROM tb_college WHERE college_parent_id IN(SELECT college_id FROM tb_college WHERE college_parent_id IN (:parentId))", nativeQuery = true)
	List<Integer> getChildrenByParentIds(@Param("parentId") List<String> parentId);
	
}
