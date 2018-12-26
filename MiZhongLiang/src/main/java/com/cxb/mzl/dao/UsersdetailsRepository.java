package com.cxb.mzl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.mzl.entity.Usersdetails;


/**
*@author 作者 E-mail 谢立博 13837051752@163.com
*@version 创建时间:2018年12月20日下午9:57:18
*类说明  用户详情Dao接口
*/
public interface UsersdetailsRepository extends JpaRepository<Usersdetails, Integer>, JpaSpecificationExecutor<Usersdetails>  {
	/**
	 * 根据ID查询用户详情
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT* FROM usersdetailstb WHERE users_id=:usersId ",nativeQuery=true)
	@Modifying
	@Transactional
	List<Integer> getUserDeteils(@Param(value = "usersId") Integer userId);
	/**
	 * 查询所有老师id以及名字
	 * */
	@Query(value = "SELECT users_id,users_name FROM usersdetailstb WHERE users_identitytype=0 ",nativeQuery=true)
	@Modifying
	@Transactional
	List <Usersdetails> queryTeacherIdAndName();
	/**
	 * 查询所有学生id以及名字
	 * */
	@Query(value = "SELECT users_id,users_name FROM usersdetailstb WHERE users_identitytype=1 ",nativeQuery=true)
	@Modifying
	@Transactional
	List <Usersdetails> queryStudentIdAndName();
	 
}
