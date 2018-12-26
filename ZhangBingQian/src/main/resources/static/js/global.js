var globalData = {
	server:"http://localhost:8080/crm_zlss",
	pre:"http://127.0.0.1:8020/EasyUI/",
	myToken:"ff6c341e-fd11-4bad-baa2-e63cb2bacd12",
	myTheme: "metro-gray",	
	setUserInfo:function (uid,uname,roleNames){
		sessionStorage.setItem("uid",uid);
		sessionStorage.setItem("uname",uname);
		sessionStorage.setItem("roleNames",roleNames);	
	},
	getCurUid: function (){
		return sessionStorage.getItem("uid");
	},
	getCurUName:function (){
		return sessionStorage.getItem("uname");
	},
	getCurRoleNames:function (){
		var rs = sessionStorage.getItem("roleNames");
		var arr = rs.split(",");
		var data = "[";
		for(var i=0;i<arr.length;i++){
			arr[i]= "\'"+arr[i]+"\'"; 
		}		
		return eval("["+arr.join()+"]");		
	}
};
document.write('<link id="myTheme" rel="stylesheet" href="'+globalData.pre+'js/easyui/themes/'+globalData.myTheme+'/easyui.css" type="text/css"/>');
document.write('<link rel="stylesheet" href="'+globalData.pre+'js/easyui/themes/icon.css" type="text/css"/>');
document.write('<script type="text/javascript" src="'+globalData.pre+'js/jquery-1.8.2.min.js" ></script>');
document.write('<script type="text/javascript" src="'+globalData.pre+'js/easyui/jquery.easyui.min.js" ></script>');
document.write('<script src="'+globalData.pre+'js/easyui/locale/easyui-lang-zh_CN.js"></script>');
document.write('<script src="'+globalData.pre+'js/easyUIvalidate.js"></script>');
document.write('<script src="'+globalData.pre+'js/data-require-permission.js" type="text/javascript" charset="utf-8"></script>');

