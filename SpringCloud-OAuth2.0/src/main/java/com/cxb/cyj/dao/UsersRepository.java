package com.cxb.cyj.dao;

import java.util.Date;
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

}
