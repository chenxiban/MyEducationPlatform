/**
 * 注意:本插件依赖Jquery;所以请先引入jquery环境
 * data-require-permission 1.0.0 
 * 作者:MaShuai
 * 日期:2018-05-11 21:28:27
 * 简介:该JS是LiuGeTu整套权限管理解决方案的前端部分
 * 本插件使用规则非常简单,使用步骤如下:
 * 
 * 1.首先在需要使用本插件的页面引入 data-require-permission.js 权限环境
 * 
 * 2.当前用户前端登录成功时,即可从后台返回当前登录用户的角色数组role,权限数组permission
 * 此时调用LiuGeTu.setRole(role);即可在H5缓存中存储当前用户所拥有的角色
 * 此时调用LiuGeTu.setPermission(permission);即可在H5缓存中存储当前用户所拥有的权限
 * 
 * 3 对于需要访问权限才能访问的元素只需给其加上data-require-permission属性,属性值指明访问此元素必须具有的权限.
 * 举个栗子:如下是指'新增用户'操作按钮需要具有user:insert权限的用户才能访问
 * <button data-require-permission="user:insert">新增用户</button>
 * 
 * 附: 对于需要某种角色才能访问的元素只需给其加上data-require-role属性,属性值指明访问此元素必须具有的角色.
 * 举个栗子:如下是指'删除模块'操作按钮需要具有'管理员'角色的用户才能访问
 * <button data-require-role="管理员">删除模块</button>
 *
 */

/**
 * sessionStorage 作用域在本次回话之内,类似session作用域,必须页面连续跳转
 * localStorage 作用域在本电脑,类似cookie作用域
 */
const LiuGeTu = {
	//设置权限数组到H5缓存中,参数例如 obj = ["user:insert","user:query"]
	setPermission (obj){
		window.localStorage.setItem("permission",( typeof(obj)== "string" ) ? obj:JSON.stringify(obj));
	},
	//从H5缓存中取出权限数组,返回例如 obj = ["user:insert","user:query"]
	getPermission (){
		return JSON.parse(window.localStorage.getItem("permission"));
	},
	//设置角色数组到H5缓存中,参数例如 obj = ["系统管理员","财务主管"]
	setRole (obj){
		window.localStorage.setItem("role",( typeof(obj)== "object" ) ? JSON.stringify(obj):obj);
	},
	//从H5缓存中取出角色数组,返回例如 obj = ["系统管理员","财务主管"]
	getRole (){
		return JSON.parse(window.localStorage.getItem("role"));
	},
	//设置角色Id数组到H5缓存中,参数例如 obj = [1,2]
	setRoleIds (obj){
		window.localStorage.setItem("roleIds",( typeof(obj)== "object" ) ? JSON.stringify(obj):obj);
	},
	//从H5缓存中取出角色Id数组,返回例如 obj = [1,2]
	getRoleIds (){
		return JSON.parse(window.localStorage.getItem("roleIds"));
	},
	//设置Token到H5缓存中,参数例如 token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjY2NzQzNTAsInN1YiI6IntcInVzZXJcIjp7XCJ1c2VySWRcIjoxLFwidXNlck5hbWVcIjpcIumprOW4hVwiLFwidXNlclBhc3NXb3JkXCI6XCJmMjlmZjdkMDI5YjgzOGY3NmJlZWE1Y2I4NWI5YzJmNVwiLFwidXNlcklzTG9ja291dFwiOmZhbHNlLFwidXNlclVwZGF0ZVRpbWVcIjpcIjIwMTgtMDUtMTggMjI6NTU6NDRcIixcInVzZXJDcmVhdGVUaW1lXCI6XCIyMDE4LTA1LTEwIDEyOjUzOjM5XCIsXCJ1c2VyTGFzdExvZ2luVGltZVwiOlwiMjAxOC0wNS0xMCAxMjo1MzozOVwiLFwidXNlckxhc3RMb2dpbklwXCI6XCIxOTIuMTY4LjAuMVwiLFwidXNlclBhc3NXcm9uZ0NvdXRcIjowLFwidXNlckxvY2tvdXRUaW1lXCI6XCIyMDE4LTA1LTEwIDEyOjUzOjM5XCIsXCJ1c2VyRW1haWxcIjpcIjExMTk2MTY2MDVAcXEuY29tXCIsXCJ1c2VyVGVsZXBob25lXCI6XCIxODMzNjMyODU1N1wifSxcInBlcm1pc3Npb25WYWx1ZUxpc3RcIjpbXCJ1c2VyOmluc2VydFwiLFwidXNlcjpkZWxldGVcIl19In0.WEt6eRgb_7KugtTvG6VZDXhH8cxBj-5CnYj-yfGaeHY"
	setToken (token){
		window.localStorage.setItem("token",token);
	},
	//从H5缓存中取出Token,返回例如  token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjY2NzQzNTAsInN1YiI6IntcInVzZXJcIjp7XCJ1c2VySWRcIjoxLFwidXNlck5hbWVcIjpcIumprOW4hVwiLFwidXNlclBhc3NXb3JkXCI6XCJmMjlmZjdkMDI5YjgzOGY3NmJlZWE1Y2I4NWI5YzJmNVwiLFwidXNlcklzTG9ja291dFwiOmZhbHNlLFwidXNlclVwZGF0ZVRpbWVcIjpcIjIwMTgtMDUtMTggMjI6NTU6NDRcIixcInVzZXJDcmVhdGVUaW1lXCI6XCIyMDE4LTA1LTEwIDEyOjUzOjM5XCIsXCJ1c2VyTGFzdExvZ2luVGltZVwiOlwiMjAxOC0wNS0xMCAxMjo1MzozOVwiLFwidXNlckxhc3RMb2dpbklwXCI6XCIxOTIuMTY4LjAuMVwiLFwidXNlclBhc3NXcm9uZ0NvdXRcIjowLFwidXNlckxvY2tvdXRUaW1lXCI6XCIyMDE4LTA1LTEwIDEyOjUzOjM5XCIsXCJ1c2VyRW1haWxcIjpcIjExMTk2MTY2MDVAcXEuY29tXCIsXCJ1c2VyVGVsZXBob25lXCI6XCIxODMzNjMyODU1N1wifSxcInBlcm1pc3Npb25WYWx1ZUxpc3RcIjpbXCJ1c2VyOmluc2VydFwiLFwidXNlcjpkZWxldGVcIl19In0.WEt6eRgb_7KugtTvG6VZDXhH8cxBj-5CnYj-yfGaeHY"
	getToken (){
		return window.localStorage.getItem("token");
	},
	//设置当前登录用户名
	setUserName (name){
		window.localStorage.setItem("userName",name);
	},
	//从H5缓存中取出当前登录的用户名
	getUserName (){
		return window.localStorage.getItem("userName");
	},
	
	setUserId(userId){
		window.localStorage.setItem("userId",userId);
	},
	getUserId(){
		return window.localStorage.getItem("userId");
	},
	setDname(dname){
		window.localStorage.setItem("dname",dname);
	},
	getDname(){
		return window.localStorage.getItem("dname");
	},
	setRname(rname){
		window.localStorage.setItem("rname",rname);
	},
	getRname(){
		return window.localStorage.getItem("rname");
	},
	setDepartmentId(departmentId){
		window.localStorage.setItem("departmentId",departmentId);
	},
	getDepartmentId(){
		return window.localStorage.getItem("departmentId");
	},
    setAid(aid){
		window.localStorage.setItem("aid",aid);
	},
	getAid(){
		return window.localStorage.getItem("aid");
	},
	
	//退出登录
	loginOut(){
		window.localStorage.removeItem("token");
		window.localStorage.removeItem("userName");
		window.localStorage.removeItem("userId");
		window.localStorage.removeItem("role");
		window.localStorage.removeItem("roleIds");
		window.localStorage.removeItem("permission");
	}
}


function haha(){
	//	console.log('权限控制插件data-require-permission.js加载成功!');
	let permission = LiuGeTu.getPermission();//从session缓存中取出权限数组
//	console.log("权限控制插件permission=>"+permission);
	$("*[data-require-permission]").map((i,ele)=>{
		let elePer = $(ele).attr('data-require-permission');
//		console.log("elePer=>"+elePer);
		let requireRemove = true;
		for(p of permission){
			if(  elePer == p )requireRemove = false;
		}
		if(requireRemove) $(ele).remove();
	});
}
/**
 * 页面加载完成自动执行
 * 使用权限控制元素的访问
 */
$(() => {
haha();
});

/**
 * 页面加载完成自动执行
 * 使用角色控制元素的访问
 */
$(() => {
//	console.log('角色控制插件data-require-permission.js加载成功!');
	let role = LiuGeTu.getRole();//从session缓存中取出角色数组
//	console.log("角色控制插件role=>"+role);
	$("*[data-require-role]").map((i,ele)=>{
		let elePer = $(ele).attr('data-require-role');
//		console.log("elePer=>"+elePer);
		let requireRemove = true;
		for(p of role){
			if(  elePer == p )requireRemove = false;
		}
		if(requireRemove) $(ele).remove();
	});
});
