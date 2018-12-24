package com.cxb.wmx.util;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;


/**
 * 系统权限工具类
 * 
 */
@SuppressWarnings("unused")
public class SysUtils {
	
	/**
	 * 类型: SysUser
	 * Session中的当前用户对象
	 */
	public static final String CURRENTUSER ="currentUser";//Session中的当前用户对象
	/**
	 * 类型: List<String> 字符串集合
	 * Session中当前用户拥有的角色集合
	 */
	public static final String CURRENTROLE = "currentRole";//Session中当前用户拥有的角色集合
	/**
	 * 类型: List<String> 字符串集合
	 * Session中当前用户拥有的权限集合
	 */
	public static final String CURRENTPERMISSION = "currentPermission";//Session中当前用户拥有的权限集合
	public static final String SYSSTR = "sys";//系统操作的命名空间
	public static final String LOGINSTR = "login";//登录操作的方法名
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(mvc)|(app)|(weixin)|(static)|(main)|(websocket)).*";	//不对匹配该值的访问路径拦截（正则）
	
	
	
	/**
	 * 从请求映射方法上取出权限字符串
	 * @param method 请求映射方法
	 * @return 权限字符串
	 */
	public static String method2PermissionValue(HandlerMethod method){
		String permissionValue = null;//请求映射方法上的权限字符串
		RequestMapping anno = method.getMethodAnnotation(RequestMapping.class);//从控制器映射方法上取出@RequestMapper注解对象
		//PreAuthorize pre=method.getMethodAnnotation(PreAuthorize.class);//从控制器映射方法上取出@PreAuthorize注解对象
		//@RequestMapper注解有没有name备注是作为一个权限的标志
		if( !"".equals(anno.name()) ){//@RequestMapper注解写了name属性才做权限收集：所以@RequestMapper注解有没有name备注是作为一个权限的标志
			RequestMapping namespaceMapping = method.getBeanType().getAnnotation(RequestMapping.class);//带有@RequestMapper注解的方法所在控制器类上的RequestMapping注解对象
			String namespace =  namespaceMapping.value()[0];//得到RequestMapping注解的value值,即命名空间,即模块
			permissionValue = (namespace+":"+anno.value()[0]).replace("/", "");//得到权限 ,例如：user:delete 用户模块的删除权限
			System.out.println("得到权限=>"+permissionValue +"权限说明:"+anno.name());
			//构造权限对象,三个参数:权限,模块说明,权限说明
//			permission = new SysPermission(permissionValue,namespaceMapping.name(), anno.name());//把权限控制注解@Permission解析为权限控制对象SysPermission,方便插入数据库权限表
		}
//		System.out.println("从请求映射方法上取出权限对象=>"+permission);
		return permissionValue;
	}
	
	/**
	 * 从请求映射方法上取出权限对象
	 * @param method 请求映射方法
	 * @return 权限对象
	 */
	public static SysPermission method2Permission(HandlerMethod method){
		SysPermission permission = null;//请求映射方法上的权限对象
		RequestMapping anno = method.getMethodAnnotation(RequestMapping.class);//从控制器映射方法上取出@RequestMapper注解对象
		//@RequestMapper注解有没有name备注是作为一个权限的标志
		if( !"".equals(anno.name()) ){//@RequestMapper注解写了name属性才做权限收集：所以@RequestMapper注解有没有name备注是作为一个权限的标志
			RequestMapping namespaceMapping = method.getBeanType().getAnnotation(RequestMapping.class);//带有@RequestMapper注解的方法所在控制器类上的RequestMapping注解对象
			String namespace =  namespaceMapping.value()[0];//得到RequestMapping注解的value值,即命名空间,即模块
			String permissionValue = (namespace+":"+anno.value()[0]).replace("/", "");//得到权限 ,例如：user:delete 用户模块的删除权限
//			System.out.println("得到权限 ,例如：user:delete 用户模块的删除权限=>"+permissionValue +"权限说明:"+anno.name());
			//构造权限对象,三个参数:权限,模块说明,权限说明
			permission = new SysPermission(permissionValue,namespaceMapping.name(), anno.name());//把权限控制注解@Permission解析为权限控制对象SysPermission,方便插入数据库权限表
		}
//		System.out.println("从请求映射方法上取出权限对象=>"+permission);
		return permission;
	}
	
	

}
