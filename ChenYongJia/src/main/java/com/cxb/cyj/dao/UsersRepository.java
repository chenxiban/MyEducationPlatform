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
	 * 根据专业id查询用户
	 * 
	 * @param college
	 * @return
	 */
	@Query(value = "SELECT user_id,user_creat_time,user_is_lookout,user_last_login_time,user_lock_time,user_password,user_protectemail,user_protectmtel,user_psd_wrong_time,user_stu_no,user_update_time,user_name,user_college_id FROM tb_user WHERE user_college_id=:collegeId LIMIT :page"
			+ "," + ":rows", nativeQuery = true)
	List<User> findCollegeId(@Param(value = "collegeId") Integer collegeId, @Param(value = "page") Integer page,
			@Param(value = "rows") Integer rows);

	/**
	 * 根据专业id查询用户
	 * 
	 * @param college
	 * @return
	 */
	@Query(value = "SELECT user_id,user_creat_time,user_is_lookout,user_last_login_time,user_lock_time,user_password,user_protectemail,user_protectmtel,user_psd_wrong_time,user_stu_no,user_update_time,user_name,user_college_id FROM tb_user WHERE user_college_id=:collegeId", nativeQuery = true)
	List<User> findCollegeId(@Param(value = "collegeId") Integer collegeId);

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
	List<Integer> getUserRole(@Param(value = "usersId") Integer userId);

	/**
	 * 查询用户权限
	 * 
	 * @param id
	 * @return
	 * @author Chenyongjia
	 */
	@Query(value = "SELECT permission_value FROM tb_permission WHERE permission_id IN(SELECT permission_id FROM tb_rolepermission WHERE role_id IN(SELECT role_id FROM tb_userroles WHERE users_id =:id)) ", nativeQuery = true)
	List<String> queryPermissionValueByUserId(Integer id);

	/**
	 * 根据老师id查询为绑定的老师
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT user_id,user_creat_time,user_name FROM tb_user LEFT JOIN tb_userroles ON users_id=user_id WHERE roles_id=:rolesId LIMIT :page"
			+ "," + ":rows", nativeQuery = true)
	List<User> getUserTeacher(@Param(value = "rolesId") Integer rolesId, @Param(value = "page") Integer page,
			@Param(value = "rows") Integer rows);

	/**
	 * 根据老师id和未绑定的老师查询老师
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT user_id,user_creat_time,user_is_lookout,user_last_login_time,user_lock_time,user_password,user_protectemail,user_protectmtel,user_psd_wrong_time,user_stu_no,user_update_time,user_name,user_college_id FROM tb_user LEFT JOIN tb_userroles ON users_id=user_id WHERE roles_id=:rolesId AND user_college_id IS NULL LIMIT :page"
			+ "," + ":rows", nativeQuery = true)
	List<User> getUserTeacherAndUserId(@Param(value = "rolesId") Integer rolesId, @Param(value = "page") Integer page,
			@Param(value = "rows") Integer rows);

	/**
	 * 根据老师id和未绑定的老师查询老师
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT user_id,user_creat_time,user_is_lookout,user_last_login_time,user_lock_time,user_password,user_protectemail,user_protectmtel,user_psd_wrong_time,user_stu_no,user_update_time,user_name,user_college_id FROM tb_user LEFT JOIN tb_userroles ON users_id=user_id WHERE roles_id=:rolesId AND user_college_id IS NULL", nativeQuery = true)
	List<User> getUserTeacherAndUserId(@Param(value = "rolesId") Integer rolesId);

	/**
	 * 修改老师的专业
	 * 
	 * @param userId
	 * @param collegeId
	 * @author 陈永佳
	 * @return
	 */
	@Query(value = "UPDATE tb_user SET user_college_id=:collegeId WHERE user_id=:userId", nativeQuery = true)
	@Modifying
	@Transactional
	Integer updateUser(@Param(value = "userId") Integer userId, @Param(value = "collegeId") Integer collegeId);

	/**
	 * 根据班级id查询已绑定学生
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT user_id,user_creat_time,user_is_lookout,user_last_login_time,user_lock_time,user_password,user_protectemail,user_protectmtel,user_psd_wrong_time,user_stu_no,user_update_time,user_name,user_college_id FROM tb_user LEFT JOIN tb_userclazz ON users_id=user_id WHERE clazz_id=:classId", nativeQuery = true)
	List<Integer> getUserClassId(@Param(value = "classId") Integer classId);

	/**
	 * 根据班级id查询已绑定学生
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT user_id,user_creat_time,user_is_lookout,user_last_login_time,user_lock_time,user_password,user_protectemail,user_protectmtel,user_psd_wrong_time,user_stu_no,user_update_time,user_name,user_college_id FROM tb_user LEFT JOIN tb_userclazz ON users_id=user_id WHERE clazz_id=:classId LIMIT :page"
			+ "," + ":rows", nativeQuery = true)
	List<User> getUserClassId(@Param(value = "classId") Integer classId, @Param(value = "page") Integer page,
			@Param(value = "rows") Integer rows);

	/**
	 * 根据班级id查询已绑定学生
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT users_id FROM tb_userclazz", nativeQuery = true)
	List<Integer> getUserAndClazz();

	/**
	 * 根据用户id集合查询未绑定学生
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT user_id,user_creat_time,user_is_lookout,user_last_login_time,user_lock_time,user_password,user_protectemail,user_protectmtel,user_psd_wrong_time,user_stu_no,user_update_time,user_name,user_college_id FROM tb_user LEFT JOIN tb_userroles ON users_id=user_id WHERE roles_id=:rolesId AND user_id NOT IN (:list)", nativeQuery = true)
	List<User> findUserNotId(@Param(value = "rolesId") Integer rolesId, @Param(value = "list") List<Integer> list);

	/**
	 * 根据用户id集合查询未绑定学生
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT user_id,user_creat_time,user_is_lookout,user_last_login_time,user_lock_time,user_password,user_protectemail,user_protectmtel,user_psd_wrong_time,user_stu_no,user_update_time,user_name,user_college_id FROM tb_user LEFT JOIN tb_userroles ON users_id=user_id WHERE roles_id=:rolesId AND user_id NOT IN (:list) LIMIT :page"
			+ "," + ":rows", nativeQuery = true)
	List<User> findUserNotId(@Param(value = "rolesId") Integer rolesId, @Param(value = "list") List<Integer> list,
			@Param(value = "page") Integer page, @Param(value = "rows") Integer rows);

	/**
	 * 为学生绑定班级
	 * 
	 * @param userId
	 * @param classId
	 * @return
	 */
	@Query(value = "INSERT INTO tb_userclazz (users_id,clazz_id) VALUES (:userId,:classId)", nativeQuery = true)
	@Modifying
	@Transactional
	Integer addUserClazz(@Param(value = "userId") Integer userId, @Param(value = "classId") Integer classId);

	/**
	 * 为学生解除绑定班级
	 * 
	 * @param userId
	 * @param classId
	 * @return
	 */
	@Query(value = "DELETE FROM tb_userclazz WHERE clazz_id=:classId AND users_id=:userId", nativeQuery = true)
	@Modifying
	@Transactional
	Integer delUserClazz(@Param(value = "userId") Integer userId, @Param(value = "classId") Integer classId);

	/**
	 * 根据角色id查询老师id
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT users_id FROM tb_userroles WHERE roles_id=:roleId", nativeQuery = true)
	List<Integer> getUserAndRoleId(@Param(value = "roleId") Integer roleId);
	
	/**
	 * 根据班级id和老师id
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT users_id,clazz_id FROM tb_userclazz WHERE clazz_id=:classId AND users_id IN (:userId)", nativeQuery = true)
	List<Integer> getUserIdAndClassId(@Param(value = "classId") Integer classId,@Param(value = "userId") List<Integer> userId);
		
}
