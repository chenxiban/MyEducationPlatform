var outstr, count;
var results, pageIndex = 1,
	pageSize = 10,
	//初始化 
	outstr = "";

function getTotalPage(num, pageSize) {
	var a = num / pageSize;
	if(num % pageSize > 0) {
		return parseInt(a) + 1;
	} else {
		return a;
	}
}

function setpage(obj_id, total, cpage, pageSize) {
	var totalpage = getTotalPage(total, pageSize);
	var next = cpage + 1 >= totalpage ? totalpage : cpage + 1;
	if(totalpage <= 10) { //总页数小于十页
		for(count = 1; count <= totalpage; count++) {
			if(count != cpage) {
				outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage(" + count + ")'>" + count + "</a>";
			} else {
				outstr = outstr + "<span class='current' >" + count + "</span>";
			}
		}
	}
	if(totalpage > 10) { //总页数大于十页 
		if(parseInt((cpage - 1) / 10) == 0) {
			for(count = 1; count <= 10; count++) {
				if(count != cpage) {
					outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage(" + count + ")'>" + count + "</a>";
				} else {
					outstr = outstr + "<span class='current'>" + count + "</span>";
				}
			}
			outstr = outstr + "<a href='javascript:void(0)' style='width: 40px' onclick='gotopage(" + next + ")'> 下一页 </a>";
		} else if(parseInt((cpage - 1) / 10) == parseInt(totalpage / 10)) {
			outstr = outstr + "<a href='javascript:void(0)' style='width: 40px' onclick='gotopage(" + (parseInt((cpage - 1) / 10) * 10) + ")'>上一页</a>";
			for(count = parseInt(totalpage / 10) * 10 + 1; count <= totalpage; count++) {
				if(count != cpage) {
					outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage(" + count + ")'>" + count + "</a>";
				} else {
					outstr = outstr + "<span class='current'>" + count + "</span>";
				}
			}
		} else {
			outstr = outstr + "<a href='javascript:void(0)' style='width: 40px' onclick='gotopage(" + (parseInt((cpage - 1) / 10) * 10) + ")'>上一页</a>";
			for(count = parseInt((cpage - 1) / 10) * 10 + 1; count <= parseInt((cpage - 1) / 10) * 10 + 10; count++) {
				if(count != cpage) {
					outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage(" + count + ")'>" + count + "</a>";
				} else {
					outstr = outstr + "<span class='current'>" + count + "</span>";
				}
			}
			outstr = outstr + "<a href='javascript:void(0)' style='width: 40px' onclick='gotopage(" + next + ")'> 下一页 </a>";
		}
	}
	document.getElementById(obj_id).innerHTML = "<div id='page'><span id='info'>共" + totalpage + "页|第" + cpage + "页<\/span>" + outstr + "<\/div>";
	outstr = "";
}
-- -- -- -- -- -- -- -- -- -- -
作者： 熊猫天下
来源： CSDN
原文： https: //blog.csdn.net/baidu_29119747/article/details/51424845 
	版权声明： 本文为博主原创文章， 转载请附上博文链接！