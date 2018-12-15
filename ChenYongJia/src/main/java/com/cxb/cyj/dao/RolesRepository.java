package com.cxb.cyj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.cyj.entity.Permission;
import com.cxb.cyj.entity.Roles;

/**
 * 
 * @Description: 用户Dao接口
 * @ClassName: RolesRepository.java
 * @author Chenyongjia
 * @Date 2018年11月12日 下午22:01
 * @Email 867647213@qq.com
 */
public interface RolesRepository extends JpaRepository<Roles, Integer>,JpaSpecificationExecutor<Roles> {
	
	/**
	 * 根据姓名查询
	 * 
	 * @param rolesName
	 * @return
	 */
	@Query("FROM Roles r WHERE r.rolesName= :rolesName")
	public Roles getAllRoles(String rolesName);
	
	/**
	 * 根据角色id查询角色拥有的权限
	 * 
	 * @param id
	 * @return
	 */
	@Query(value="SELECT p.permission_module FROM tb_permission p LEFT JOIN tb_rolepermission rp ON rp.permission_id=p.permission_id WHERE rp.role_id=:rid",nativeQuery=true)
	public List<Permission> getRolesPermission(@Param("rid")Integer id);
	
	/**
	 * 根据id获取用户表未被设置的角色信息
	 * @param id
	 * @return
	 */
	@Query(value="SELECT roles_id,roles_creat_time,roles_explain,roles_update_time,roles_name,roles_ename FROM tb_roles WHERE roles_id NOT IN (:ids)",nativeQuery=true)
	public List<Roles> getRolesList(@Param("ids") List<Integer> id);
	
	/**
	 * 根据用户id查询该用户拥有的角色
	 * @param id
	 * @return
	 */
	@Query(value="SELECT * FROM tb_roles r LEFT JOIN tb_userroles u ON u.roles_id=r.roles_id WHERE u.users_id=:userId",nativeQuery=true)
	public List<Roles> getUserRolesByUserId(@Param("userId")Integer userId);
	
	/**
	 * 批量删除角色信息
	 * 
	 * @param stuList
	 * @return
	 */
	@Query(value = "DELETE FROM tb_roles WHERE roles_id IN (:stuList)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer deleteBatch(@Param(value = "stuList") List<String> stuList);
	
	/**
	 * 添加角色
	 * 
	 * @param stuList
	 * @return
	 */
	@Query(value = "INSERT INTO tb_userroles (roles_id,users_id) VALUES(:roleId,:userId)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer addByRole(@Param(value = "roleId") Integer roleId,@Param(value = "userId") Integer userId);
	
	/**
	 * 删除角色
	 * 
	 * @param stuList
	 * @return
	 */
	@Query(value = "DELETE FROM tb_userroles WHERE roles_id=:roleId AND users_id=:userId", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer deleteByRoleId(@Param(value = "roleId") Integer roleId,@Param(value = "userId") Integer userId);
	
	/**
	 * 设置模块
	 * @param roleId
	 * @param userId
	 * @return
	 */
	@Query(value = "INSERT INTO tb_rolemodules(role_id,modules_id) VALUES(:roleId,:moduleId)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer setRoleModule(@Param(value = "roleId") Integer roleId,@Param(value = "moduleId") Integer moduleIds);

	/**
	 * 移除角色模块
	 * @param roleId
	 * @return
	 */
	@Query(value = "DELETE FROM tb_rolemodules WHERE role_id=:roleId", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer  delRoleModule(@Param(value = "roleId") Integer roleId);
	
}
