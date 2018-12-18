package com.cxb.cyj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.MyTokenRepository;
import com.cxb.cyj.entity.MyToken;
import com.cxb.cyj.service.MyTokenService;

/**
 * 
 * @Description: 我的token存储业务实现类
 * @ClassName: MyTokenServiceImpl.java
 * @author Chenyongjia
 * @Date 2018年12月10日 下午14:41
 * @Email 867647213@qq.com
 */
@Service
public class MyTokenServiceImpl implements MyTokenService {
	
	@Autowired
	private MyTokenRepository myTokenRepository;

	/**
	 * 根据token获取用户信息
	 * @param token
	 * @return
	 */
	@Override
	public MyToken findByTokenAcc(String tokenAcc) {
		return myTokenRepository.findsTokenAcc(tokenAcc);
	}

	/**
	 * 删除token信息
	 * 
	 * @param token
	 * @author Chenyongjia
	 * @return
	 */
	@Override
	public boolean deleteBatch(String token) {
		return myTokenRepository.deleteBatch(token)>0?true:false;
	}

	/**
	 * 添加信息
	 * @param myToken
	 * @author Chenyongjia
	 * @return
	 */
	@Override
	public boolean saveMyToken(MyToken myToken) {
		try {
			myTokenRepository.save(myToken);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 根据userId查询myToken
	 * @param userId
	 * @author Chenyongjia
	 * @return
	 */
	@Override
	public MyToken findByIds(Integer userId) {
		return myTokenRepository.findByUserId(userId);
	}
	
}
