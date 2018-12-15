package com.cxb.cyj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.cyj.entity.User;

/**
 * 
 * @Description: 用户Dao接口
 * @ClassName: UsersRepository.java
 * @author Chenyongjia
 * @Date 2018年11月12日 下午22:01
 * @Email 867647213@qq.com
 */
public interface UsersRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	/**
	 * 根据姓名查询
	 * 
	 * @param usersName
	 * @return
	 * @author Chenyongjia
	 */
	User findByUserName(String userName);
	
	/**
	 * 根据userId查询
	 * 
	 * @param userId
	 * @return
	 * @author Chenyongjia
	 */
	User findByUserId(Integer userId);
	
	/**
	 * 批量删除用户信息
	 * 
	 * @param stuList
	 * @return
	 * @author Chenyongjia
	 */
	@Query(value = "DELETE FROM tb_user WHERE user_id IN (:stuList)", nativeQuery = true)
	@Modifying
	@Transactional
	Integer deleteBatch(@Param(value = "stuList") List<String> stuList);
	
	/**
	 * 根据ID查询用户角色
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT roles_id FROM tb_userroles WHERE users_id=:usersId ", nativeQuery = true)
	public List<Integer> getUserRole(@Param(value = "usersId") Integer userId);
	
	/**
	 * 查询用户权限
	 * 
	 * @param id
	 * @return
	 * @author Chenyongjia
	 */
	@Query(value = "SELECT permission_value FROM tb_permission WHERE permission_id IN(SELECT permission_id FROM tb_rolepermission WHERE role_id IN(SELECT role_id FROM tb_userroles WHERE users_id =:id)) ", nativeQuery = true)
	List<String> queryPermissionValueByUserId(Integer id);

}
