package com.cxb.cyj.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.MyToken;
import com.cxb.cyj.entity.Result;
import com.cxb.cyj.entity.User;
import com.cxb.cyj.service.MyTokenService;
import com.cxb.cyj.service.UserService;

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

	@Autowired
	private UserService userService;

	/**
	 * 添加token的存储信息
	 * http://localhost:3011/chenyongjia/ChenYongJia/tokens/saveMyToken?
	 * 
	 * @author GuoShiCai
	 * @param myToken
	 * @return
	 */
	@RequestMapping(value = "/saveMyToken", name = "添加token的存储信息", method = RequestMethod.PUT)
	public Object saveMyToken(@RequestBody MyToken myToken, @RequestParam(value = "usersName") String usersName) {
		User user = userService.findsLoginName(usersName);
		myToken.setUserId(user.getUserId());
		myToken.setTokenCreatTime(new Date());

		MyToken myToken2 = myTokenService.findByIds(user.getUserId());

		if (myToken2.getTokenAcc().equals(myToken.getTokenAcc())) {
			return new Result(false, "token已存储,存储失败");
		} else {
			if (myTokenService.deleteBatch(myToken2.getTokenAcc())) {// 根据失效的不相等的删除
				if (myTokenService.saveMyToken(myToken)) {
					return new Result(true, "token添加成功");
				} else {
					return new Result(false, "token添加失败");
				}
			} else {
				return new Result(false, "token存储数据删除失败");
			}
		}

	}

}
