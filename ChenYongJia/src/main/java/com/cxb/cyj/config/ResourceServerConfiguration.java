package com.cxb.cyj.config;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 
 * @Description: 资源服务器
 * @ClassName: ResourceServerConfiguration.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	// @EnableResourceServer 开启资源服务中心,一般配置在网关.
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// 对 api/order 请求进行拦截 验证 accessToken,需要携带token的方法
		http.authorizeRequests()
				.antMatchers("/user/addUserClazz", "/user/getByTeacher", "/user/getAllPageUsers", "/user/addUsers",
						"/user/delUsers", "/user/updUsers", "/user/lockUsers", "/user/clearUsers", "/user/getRolesList",
						"/user/updateUser", "/college/delCollege", "/college/getCollege", "/college/addCollege",
						"/college/updateCollege", "/clazz/addClazzs", "/clazz/getAllPageClazz", "/clazz/delClazz",
						"/clazz/updClazz", "/roles/getAllPageRoles", "/roles/setRolePermission",
						"/roles/getRolesPermissionByRoleId", "/roles/getUserRolesByUserId", "/roles/addRoles",
						"/roles/delRoles", "/roles/updRoles", "/roles/setRoleModule", "/roles/addByRole",
						"/roles/delRolesId", "/roles/getAllRoles", "/organization/getAllOrganization",
						"/organization/queryAllOrganization", "/organization/delOrganization",
						"/organization/saveOrganization", "/organization/updOrganization")
				.authenticated().and().headers().frameOptions().sameOrigin();
	}
	// public
	// 拦截资源 网关里面做 开放接口和内部接口一定要独立出来可以封转该业务逻辑相同

}
