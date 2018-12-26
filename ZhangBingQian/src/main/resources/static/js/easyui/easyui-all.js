var GlobalConst = {
	server:"http://localhost:8080/liugetusimple/",
	client:"http://127.0.0.1:8020/liugetujs/",
	themes: "black"
};
//写入EesyUI环境
document.write('<link id="myTheme" rel="stylesheet" href="'+GlobalConst.client+'js/easyui/themes/'+GlobalConst.themes+'/easyui.css" type="text/css"/>');
document.write('<link rel="stylesheet" href="'+GlobalConst.client+'js/easyui/themes/icon.css" type="text/css"/>');
document.write('<script type="text/javascript" src="'+GlobalConst.client+'js/easyui/jquery.min.js" ></script>');
document.write('<script type="text/javascript" src="'+GlobalConst.client+'js/easyui/jquery.easyui.min.js" ></script>');
document.write('<script src="'+GlobalConst.client+'js/easyui/locale/easyui-lang-zh_CN.js"></script>');
