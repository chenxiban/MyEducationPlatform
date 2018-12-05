package com.cxb.cyj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @Description:   登录实体类
 * @ClassName:     User.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Getter
@Setter
@AllArgsConstructor // 自动所有参数的构造方法方法
@NoArgsConstructor // 自动无参的构造方法方法
@Builder // 使用建造模型
@ToString
public class Login {
	
	private String grant_type="password";
	private String username;
	private String password;
	private String client_id="client_1";
	private String client_secret="123456";
	private String scope="all";
	
	public static void main(String[] args) {
		Login login=new Login();
		login.setGrant_type("password");
		System.out.println(login);
	}
	
}
