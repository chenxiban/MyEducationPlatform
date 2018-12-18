package com.cxb.cyj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.cyj.entity.MyToken;

/**
 * 
 * @Description: 我的token存储表Dao接口
 * @ClassName: MyTokenRepository.java
 * @author Chenyongjia
 * @Date 2018年12月10日 下午14:41
 * @Email 867647213@qq.com
 */
public interface MyTokenRepository extends JpaRepository<MyToken, Integer>, JpaSpecificationExecutor<MyToken>  {
	
	/**
	 * 根据userid查询mytoken
	 * @param userId
	 * @author Chenyongjia
	 * @return
	 */
	MyToken findByUserId(Integer userId);
	
	/**
	 * 根据tokenAcc查询
	 * 
	 * @param tokenAcc
	 * @return
	 * @author Chenyongjia
	 */
	@Query(value = "SELECT token_id,user_id,token_acc,token_creat_time,token_update_time FROM tb_token WHERE token_acc=:tokenAcc", nativeQuery = true)
	MyToken findsTokenAcc(@Param(value="tokenAcc") String tokenAcc);
	
	/**
	 * 删除token信息
	 * 
	 * @param token
	 * @return
	 * @author Chenyongjia
	 */
	@Query(value = "DELETE FROM tb_token WHERE token_acc=:token ", nativeQuery = true)
	@Modifying
	@Transactional
	Integer deleteBatch(@Param(value = "token") String token);
	
}
