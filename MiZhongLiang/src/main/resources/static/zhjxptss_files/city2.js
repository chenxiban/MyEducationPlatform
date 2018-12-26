var site_cityUtil=(function(){var y={};var l={};var v={1:["华东",[310000,320000,330000,340000,360000]],2:["华北",[110000,120000,140000,370000,130000,150000]],3:["华中",[430000,420000,410000]],4:["华南",[440000,450000,350000,460000]],5:["东北",[210000,220000,230000]],6:["西北",[610000,650000,620000,640000,630000]],7:["西南",[500000,530000,520000,540000,510000]],8:["港澳台",[810000,820000,710000]],9:["海外",[990000]]};var c={1:["A-G",[340000,820000,110000,500000,350000,620000,440000,450000,520000]],2:["H-K",[460000,130000,230000,410000,420000,430000,320000,360000,220000]],3:["L-S",[210000,150000,640000,630000,370000,310000,140000,610000,510000]],4:["T-Z",[120000,710000,650000,540000,810000,530000,330000]],5:["OS",[990000]]};var g,k;var r=function(B){var C=[];$.each(c,function(D,E){$.each(E[1],function(G,F){C.push(F+"")})});var A=u(C,B);if(B==2052||B==1028){g=A}else{k=A}};var h=function(A){var B=[];$.ajax({url:"../ajax/city_h.jsp?cmd=getAllCityInfo",type:"POST",async:false,success:function(C){C=$.parseJSON(C);if(C.success){if(A==2052||A==1028){y=C.cityInfoList}else{l=C.cityInfoList}B=C.cityInfoList}}});return B};var u=function(C,A){var B=[];$.ajax({url:"../ajax/city_h.jsp?cmd=getCityInfo&Lcid="+A+"&cityCodeList="+Fai.encodeUrl($.toJSON(C)),type:"POST",async:false,success:function(D){D=$.parseJSON(D);if(D.success){$.each(D.cityInfoList,function(E,F){if(A==2052||A==1028){y[F.cityCode]=F.cityInfo}else{l[F.cityCode]=F.cityInfo}});B=D.cityInfoList}}});return B};var x=function(E,A,D){if(!E||isNaN(E)||E<=0){return[]}var C=[];if(A==2052||A==1028){C=y}else{C=l}if((typeof C[E]=="undefined")||(C[E]==null)){if(typeof E!=="string"){E=E+""}u(new Array(E),A)}var B=C[E][2];if(B){if(B.length==0){if(D=="street"){B=undefined}}else{if(D=="cityOrCounty"&&B[0].id.length>6){B=undefined}}}if(!B){$.ajax({url:"../ajax/city_h.jsp?cmd=cityGetChildren&type="+D+"&Lcid="+A+"&code="+E,type:"POST",async:false,success:function(F){F=$.parseJSON(F);if(F.success){B=F.childList;C[E][2]=B;$.each(B,function(H,I){var G=[];G.push(I.name);G.push(I.parentid);C[I.id]=G})}else{B=[]}},error:function(F){B=[]}})}return B};var f=function(E,G){G?(g=g||[]):(k=k||[]);var D=G?g:k;var C=G?2052:1033;if(!D.length){$.ajax({url:"../ajax/city_h.jsp?cmd=getProvinceInfo&Lcid="+C,type:"POST",async:false,success:function(J){J=$.parseJSON(J);if(J.success){for(var I=0,H=J.provinceInfoList.length;I<H;I++){D.push(J.provinceInfoList[I])}}}})}try{var B=v[E][1];var A=[];$.each(D,function(I,H){if($.inArray(parseInt(H.id),B)>=0){A.push(H)}});return A}catch(F){return D}};var m=function(A){if(typeof A!=="string"){A=A+""}if(y[A]==""||y[A]=="undefined"||y[A]==null){u(new Array(A),2052)}if(y[A]&&y[A][1]==="1"){return true}return false};var q=function(B,A){if(typeof B!=="string"){B=B+""}if(y[B]==""||y[B]=="undefined"||y[B]==null){u(new Array(B),2052)}if(A){if(typeof A!=="string"){A=A+""}if(y[A]==""||y[A]=="undefined"||y[A]==null){u(new Array(A),2052)}if(y[B]&&y[B][1]===A&&m(A)){return true}}else{if(y[B]&&y[B][1]!=="1"){return true}}return false};var b=function(A){if(!A){return}if(A.length<=3){if(A.slice(A.length-1,A.length)=="市"||A.slice(A.length-1,A.length)=="县"||A.slice(A.length-1,A.length)=="盟"){return A.slice(0,A.length-1)}}var B;B=A.slice(A.length-9);if(B=="群岛的岛礁及其海域"){return A.slice(0,A.length-9)}B=A.slice(A.length-8);if(B=="土家族苗族自治州"||B=="傣族景颇族自治州"||B=="哈尼族彝族自治州"||B=="布依族苗族自治州"||B=="蒙古族藏族自治州"){return A.slice(0,A.length-8)}B=A.slice(A.length-7);if(B=="藏族羌族自治州"||B=="壮族苗族自治州"||B=="黎族苗族自治县"||B=="苗族侗族自治州"){return A.slice(0,A.length-7)}B=A.slice(A.length-6);if(B=="傈僳族自治州"||B=="哈萨克自治州"){return A.slice(0,A.length-6)}B=A.slice(A.length-5);if(B=="彝族自治州"||B=="藏族自治州"||B=="白族自治州"||B=="傣族自治州"||B=="黎族自治县"||B=="回族自治州"||B=="蒙古自治州"){return A.slice(0,A.length-5)}B=A.slice(A.length-4);if(B==""){return A.slice(0,A.length-4)}B=A.slice(A.length-3);if(B=="蒙古族"||B=="自治州"){return A.slice(0,A.length-3)}B=A.slice(A.length-2);if(B=="群岛"||B=="地区"||B=="林区"){return A.slice(0,A.length-2)}if(A.slice(A.length-1,A.length)=="市"||A.slice(A.length-1,A.length)=="县"||A.slice(A.length-1,A.length)=="盟"){return A.slice(0,A.length-1)}return A};var i=function(A){return f(A,true)};var z=function(A){return x(A,2052,"cityOrCounty")};var j=function(A){return x(A,2052,"street")};var p=function(D){if(!D){return{id:D,name:"",parentId:0}}var A=y[D];if(A){return{id:D,name:A[0],parentId:A[1]}}else{if(typeof D!=="string"){D=D+""}var C=u(new Array(D),2052);var B=C[0]||{};A=B.cityInfo;if(A){return{id:D,name:A[0],parentId:A[1]}}else{return{id:D,name:"",parentId:0}}}};var e=function(A){if(!A){return}if(A.length==3&&A.slice(A.length-1,A.length)=="省"){return A.slice(0,A.length-1)}var B=A.slice(A.length-6);if(B=="维吾尔自治区"){return A.slice(0,A.length-6)}B=A.slice(A.length-5);if(B=="特别行政区"||B=="壮族自治区"||B=="回族自治区"){return A.slice(0,A.length-5)}B=A.slice(A.length-3);if(B=="自治区"){return A.slice(0,A.length-3)}if(A.slice(A.length-1,A.length)=="省"){return A.slice(0,A.length-1)}return A};var n=function(A){return f(A,false)};var w=function(A){return x(A,1033,"cityOrCounty")};var o=function(A){return x(A,1033,"street")};var d=function(D){if(!D){return{id:D,name:"",parentId:0}}var A=l[D];if(A){return{id:D,name:A[0],parentId:A[1]}}else{if(typeof D!=="string"){D=D+""}var C=u(new Array(D),1033);var B=C[0]||{};A=B.cityInfo;if(A){return{id:D,name:A[0],parentId:A[1]}}else{return{id:D,name:"",parentId:0}}}};var a=function(A){if(!A){return}if(A.slice(A.length-29,A.length)=="Special Administrative Region"){A=A.slice(0,A.length-30)}if(A.slice(A.length-17,A.length)=="Autonomous Region"){A=A.slice(0,A.length-18)}if(A.slice(A.length-8,A.length)=="Province"||A.slice(A.length-8,A.length)=="province"){A=A.slice(0,A.length-9)}if(A.slice(A.length-6,A.length)=="Zhuang"){A=A.slice(0,A.length-7)}if(A.slice(A.length-5,A.length)=="Uygur"){A=A.slice(0,A.length-6)}if(A.slice(A.length-3,A.length)=="Hui"){A=A.slice(0,A.length-4)}return A};var t=function(A){if(!A){return}if(A.slice(A.length-29,A.length)=="Tibetan Autonomous Prefecture"){A=A.slice(0,A.length-30)}if(A.slice(A.length-22,A.length)=="Li and Miao Autonomous"){A=A.slice(0,A.length-23)}if(A.slice(A.length-13,A.length)=="Li Autonomous"){A=A.slice(0,A.length-14)}if(A.slice(A.length-10,A.length)=="Prefecture"){A=A.slice(0,A.length-11)}if(A.slice(A.length-9,A.length)=="Mongolian"){A=A.slice(0,A.length-10)}if(A.slice(A.length-6,A.length)=="County"){A=A.slice(0,A.length-7)}if(A.slice(A.length-4,A.length)=="City"){A=A.slice(0,A.length-5)}return A};var s=function(A,D){var C=[];var B=[];if(A==2052||A==1028){C=y}else{C=l}$.each(C,function(E,G){var F={};if(G[1]==D){F.id=E;F.name=G[0];F.parentid=G[1];B.push(F)}});return B};return{getAreaGroups:function(){return v},getAreaGroupsPinYin:function(){return c},getProvince:function(A){return i(A)},getCities:function(A){return z(A)},getCounty:function(A){return z(A)},getStreet:function(A){return j(A)},getInfo:function(A){return p(A)},simpleProvinceName:function(A){$.each(A,function(B,C){A[B].name=e(A[B].name)})},simpleProvinceNameStr:function(A){return e(A)},simpleCityName:function(A){$.each(A,function(B,C){A[B].name=b(A[B].name)})},simpleCityNameStr:function(A){return b(A)},simpleProvinceNameEn:function(A){$.each(A,function(B,C){A[B].name=a(A[B].name)})},simpleCityNameEn:function(A){$.each(A,function(B,C){A[B].name=t(A[B].name)})},simpleCityNameStrEn:function(A){return t(A)},simpleProvinceNameStrEn:function(A){return a(A)},getProvinceEn:function(A){return n(A)},getCitiesEn:function(A){return w(A)},getCountyEn:function(A){return w(A)},getStreetEn:function(A){return o(A)},getInfoEn:function(A){return d(A)},simpleCityListStr:function(E){if(!E||E.length<=0){return"未添加地区"}var C={};$.each(E,function(F,H){if((""+H).length<6){return}var G=p(H);if(C[G.parentId]){C[G.parentId].count++}else{C[G.parentId]={count:1,objs:[]}}C[G.parentId].objs.push(G)});var D=[];var B=[];$.each(C,function(F,G){var H=s(2052,F);if(H.length==G.count){D.push(e(p(F).name));D.push("、")}else{$.each(G.objs,function(I,J){B.push(b(J.name));B.push("、")})}});var A=D.join("")+B.join("");return A.slice(0,A.length-1)},isValidProvince:function(A){return m(A)},isValidCity:function(B,A){return q(B,A)},getCityList:function(B,A){return u(B,A)},getAllCityInfo:function(A){return h(A)},initProvinces:function(A){return r(A)},getCityFormJScache:function(A,B){return s(A,B)}}}());