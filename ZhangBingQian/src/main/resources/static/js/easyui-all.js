const GlobalConst = {
	server:"",//111
	//client:"http://127.0.0.1:8020/static/",
	client:"",
	themes: "metro-gray",
	//从H5缓存中取出Token,返回例如  token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjY2NzQzNTAsInN1YiI6IntcInVzZXJcIjp7XCJ1c2VySWRcIjoxLFwidXNlck5hbWVcIjpcIumprOW4hVwiLFwidXNlclBhc3NXb3JkXCI6XCJmMjlmZjdkMDI5YjgzOGY3NmJlZWE1Y2I4NWI5YzJmNVwiLFwidXNlcklzTG9ja291dFwiOmZhbHNlLFwidXNlclVwZGF0ZVRpbWVcIjpcIjIwMTgtMDUtMTggMjI6NTU6NDRcIixcInVzZXJDcmVhdGVUaW1lXCI6XCIyMDE4LTA1LTEwIDEyOjUzOjM5XCIsXCJ1c2VyTGFzdExvZ2luVGltZVwiOlwiMjAxOC0wNS0xMCAxMjo1MzozOVwiLFwidXNlckxhc3RMb2dpbklwXCI6XCIxOTIuMTY4LjAuMVwiLFwidXNlclBhc3NXcm9uZ0NvdXRcIjowLFwidXNlckxvY2tvdXRUaW1lXCI6XCIyMDE4LTA1LTEwIDEyOjUzOjM5XCIsXCJ1c2VyRW1haWxcIjpcIjExMTk2MTY2MDVAcXEuY29tXCIsXCJ1c2VyVGVsZXBob25lXCI6XCIxODMzNjMyODU1N1wifSxcInBlcm1pc3Npb25WYWx1ZUxpc3RcIjpbXCJ1c2VyOmluc2VydFwiLFwidXNlcjpkZWxldGVcIl19In0.WEt6eRgb_7KugtTvG6VZDXhH8cxBj-5CnYj-yfGaeHY"
	getToken (){
		return window.localStorage.getItem("token");
	},
	//从H5缓存中取出当前登录的用户名
	getUserName (){
		return window.localStorage.getItem("userName");
	},
	//从H5缓存中取出角色Id数组,返回例如 obj = [1,2]
	getRoleIds (){
		return JSON.parse(window.localStorage.getItem("roleIds"));
	},//从H5缓存中取出权限数组,返回例如 obj = ["user:insert","user:query"]
	getPermission (){
		return JSON.parse(window.localStorage.getItem("permission"));
	},
	getUserId(){
		return window.localStorage.getItem("userId");
	},
	getDname(){
		return window.localStorage.getItem("dname");
	},
	getRname(){
		return window.localStorage.getItem("rname");
	},
	//从H5缓存中取出角色Id数组,返回例如 obj = [1,2]
	getRoleIds (){
		return JSON.parse(window.localStorage.getItem("roleIds"));
	},//从H5缓存中取出权限数组,返回例如 obj = ["user:insert","user:query"]
	getPermission (){
		return JSON.parse(window.localStorage.getItem("permission"));
	},

	
	//退出登录
	loginOut(){
		window.localStorage.removeItem("token");
		window.localStorage.removeItem("userName");
		window.localStorage.removeItem("role");
		window.localStorage.removeItem("roleIds");
		window.localStorage.removeItem("permission");
	},
	
	//表单序列化以后去掉表单中值为空的参数
	serializeNotNull(serStr){
	    return serStr.split("&").filter(function(str){return !str.endsWith("=")}).join("&");
	},
	//获取表单中的参数,并附加token令牌
	parseFormAddToken(formId){
		let formParam = GlobalConst.serializeNotNull($('#'+formId).serialize());
		console.log(`加入token的表单参数=>${formParam}`);
		return formParam;
	}
};
//写入EesyUI环境
document.write('<link id="myTheme" rel="stylesheet" href="'+GlobalConst.client+'js/easyui/themes/'+GlobalConst.themes+'/easyui.css" type="text/css"/>');
document.write('<link rel="stylesheet" href="'+GlobalConst.client+'js/easyui/themes/icon.css" type="text/css"/>');
document.write('<script type="text/javascript" src="'+GlobalConst.client+'js/easyui/jquery.min.js" ></script>');
document.write('<script type="text/javascript" src="'+GlobalConst.client+'js/easyui/jquery.easyui.min.js" ></script>');
document.write('<script src="'+GlobalConst.client+'js/easyui/locale/easyui-lang-zh_CN.js"></script>');
//Editable DataGrid（可编辑数据表格）
document.write('<script src="'+GlobalConst.client+'js/easyui/jquery.edatagrid.js"></script>');
//EasyUI自定义校验规则
document.write('<script src="'+GlobalConst.client+'js/easyUIvalidate.js"></script>');

