/**
 * 注意:本插件依赖Jquery;所以请先引入jquery环境
 * login-permission-interceptor.js 
 * 作者:MaShuai
 * 日期:2018-05-11 21:28:27
 * 简介:该JS是页面加载完成自动执行判断当前token是否有效,无效则重定向到登录页面
 * /



/**
 * 页面加载完成自动执行
 * 使用权限控制元素的访问
 */
$(() => {

	//获取H5缓存的token
	//获取H5缓存的token
	let localToken = window.localStorage.getItem("token");
	console.log("获取H5缓存的token执行判断是否有效=>"+localToken);
	if(localToken == null){
//	window.top.location.href=GlobalConst.client+"login.html";//如果已经引入过easyui-all.js
//	window.top.location.href="http://127.0.0.1:8020/liugetujs/login.html";
	}else{//如果token不为空,则执行token校验
		$.ajax({
		url: "http://localhost:8080/crm_zlss/login/testToken",
		data: {token:localToken},
		type: "POST",
		dataType: "json",
		success(result) {
			console.log("result=>" + JSON.stringify(result));
			if(result.state == 0) { //请求失败 : token无效
				console.log("请求失败 : token无效=>"+result.msg);
//				window.top.location.href=GlobalConst.client+"login.html";//如果已经引入过easyui-all.js
//				window.top.location.href="http://127.0.0.1:8020/liugetujs/login.html";
			}
		}
	});
	}
	
	
});