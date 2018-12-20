package com.cxb.cyj.service;

import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.MyToken;

/**
 * 
 * @Description: 我的token存储业务类
 * @ClassName: MyTokenService.java
 * @author Chenyongjia
 * @Date 2018年12月10日 下午14:41
 * @Email 867647213@qq.com
 */
@Service
public interface MyTokenService {
	
	/**
	 * 根据token获取用户信息
	 * @param token
	 * @author Chenyongjia
	 * @return
	 */
	MyToken findByTokenAcc(String tokenAcc);
	
	/**
	 * 删除token信息
	 * 
	 * @param token
	 * @author Chenyongjia
	 * @return
	 */
	boolean deleteBatch(String token);
	
	/**
	 * 添加信息
	 * @param myToken
	 * @author Chenyongjia
	 * @return
	 */
	boolean saveMyToken(MyToken myToken);
	
	/**
	 * 根据userId查询myToken
	 * @param userId
	 * @author Chenyongjia
	 * @return
	 */
	MyToken findByIds(Integer userId);
	
}
