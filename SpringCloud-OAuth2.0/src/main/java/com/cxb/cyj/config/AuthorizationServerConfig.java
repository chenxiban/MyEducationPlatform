package com.cxb.cyj.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import com.cxb.cyj.service.impl.CustomUserServiceImpl;

/**
 * 
 * @Description: 授权认证服务中心配置 
 * @ClassName: AuthorizationServerConfig.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
    private CustomUserServiceImpl userDetailsService;
	
	static final Logger logger = LoggerFactory.getLogger(AuthorizationServerConfig.class);

    /*@Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Bean // 声明 ClientDetails实现
    public ClientDetailsService clientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }*/
    
	// @EnableAuthorizationServer 开启 授权认证服务中心
	// accessToken 有效期 2小时
	private static final int ACCESSTOKENVALIDITYSECONDS = 7200;// 两小时
	private static final int REFRESHTOKENVALIDITYSECONDS = 7200;// 两小时
	// 配置 appid、appkey 、回调地址、token有效期

	// 思考问题：accessToken 怎么办？ 使用刷新令牌获取新的accessToken 至少提前10分钟调用刷新令牌接口进行刷新
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		// 思考： 如果合作机构需要做oauth2认证的话 第一步操作的是什么？
		// 1.申请获取到appid 和 appkey 写死的
		clients.inMemory().withClient("client_1").secret(passwordEncoder().encode("123456"))
				.redirectUris("http://www.mayikt.com") // 授权码授权模式下的回调地址
				.authorizedGrantTypes("authorization_code", "password", "refresh_token").scopes("all")
				.accessTokenValiditySeconds(ACCESSTOKENVALIDITYSECONDS)
				.refreshTokenValiditySeconds(REFRESHTOKENVALIDITYSECONDS);// 授权类型
	}

	// 设置token类型
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.authenticationManager(authenticationManager()).allowedTokenEndpointRequestMethods(HttpMethod.GET,
				HttpMethod.POST);
		// 必须加上他，不然刷新令牌接口会报错
		endpoints.authenticationManager(authenticationManager());
		endpoints.userDetailsService(userDetailsService);// 从数据库取值
		// 之前的accessToken b55c980c-31f7-4498-a783-bd905608fb18
		// 刷新之后accessToken d40f7915-dd06-4503-83c8-2815915c9368
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
		// 允许表单认证
		//oauthServer.tokenKeyAccess("permitAll()");
		oauthServer.allowFormAuthenticationForClients();
		// 允许check_token访问
		oauthServer.checkTokenAccess("permitAll()");
	}
	
	/**
	 * 用户自定义
	 */
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);//.passwordEncoder(passwordEncoder());
	}

	@Bean
	AuthenticationManager authenticationManager() {
		AuthenticationManager authenticationManager = new AuthenticationManager() {

			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				return daoAuhthenticationProvider().authenticate(authentication);
			}
		};
		return authenticationManager;
	}

	@Bean
	public AuthenticationProvider daoAuhthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

	// 设置添加用户信息,正常应该从数据库中读取
	/*@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		userDetailsService.createUser(User.withUsername("user_1").password(passwordEncoder().encode("123456"))
				.authorities("ROLE_USER").build());
		userDetailsService.createUser(User.withUsername("user_2").password(passwordEncoder().encode("1234567"))
				.authorities("ROLE_USER").build());
		return new CustomUserServiceImpl;
	}*/

	@Bean
	static
	PasswordEncoder passwordEncoder() {
		// 加密方式
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
    /*@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

}
