package com.cxb.cyj.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.MyToken;
import com.cxb.cyj.entity.Result;
import com.cxb.cyj.service.MyTokenService;
import com.cxb.cyj.util.IsEmptyUtils;

/**
 * 
 * @Description: Token控制器
 * @ClassName: MyTokenController.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@RestController
@RequestMapping(value = "/tokens", name = "Token模块")
public class MyTokenController {
	
	@Autowired
	private MyTokenService myTokenService;
	
	/**
	 * 添加token的存储信息
	 * http://localhost:3011/chenyongjia/ChenYongJia/tokens/saveMyToken?usersName=郭士才7&usersStuNo=123456
	 * 
	 * @author GuoShiCai
	 * @param myToken
	 * @return
	 */
	@RequestMapping(value = "/saveMyToken", method = RequestMethod.PUT)
	public Object saveMyToken(MyToken myToken) {
		myToken.setTokenCreatTime(new Date());
		MyToken mylist = myTokenService.findByTokenAcc(myToken.getTokenAcc());
		if (IsEmptyUtils.isEmpty(mylist)) {
			if (myTokenService.saveMyToken(myToken)) {
				return new Result(true, "token添加成功");
			} else {
				return new Result(false, "token添加失败");
			}
		} else {
			return new Result(false, "token名重复,存储失败");
		}
	}
	
}
