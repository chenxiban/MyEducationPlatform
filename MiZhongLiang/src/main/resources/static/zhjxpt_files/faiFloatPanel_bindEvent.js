Site.bindEventToFloatPanel = function(d) {
	var at = d,
		aj = true,
		ar, A, z = Fai.top._panelOptionData.allowedStyle || (top._templateType != Fai.top._panelOptionData.templateType_free),
		aC = !Fai.top._panelOptionData.allowedStyle && (top._templateType == Fai.top._panelOptionData.templateType_free),
		aV = 1,
		al = "#000",
		aK = "#000",
		ay = "#000",
		q = "#000",
		ac = "#000",
		c = "#000",
		t = "#000",
		Z = "#000",
		aq = "#000",
		aL = "#000",
		h = "#000",
		ao = 0;

	function T(a0) {
		var aY = Site.getWebBackgroundData(),
			aZ = aY.sw;
		$("body").data("fk-initSiteBgWidth", aZ)
	}

	function D() {
		var aZ = (Fai.top._aid % 2 === 0),
			aY = Site.getWebBackgroundData(),
			a0 = aY.sw;
		if(a0 === -1) {
			return
		}
		if(aZ) {
			return
		}
		if(a0 > 1200) {
			Fai.ing("主流屏幕尺寸不超过1200px，网站宽度超过1200px将影响观看体验", true, 4000)
		}
	}
	Fai.top.faiFullmeasureEdit = false;
	$(window).resize(function() {
		Site.refreshPanelStyle()
	});
	var X;
	var ai = false;
	at.mouseleave(function() {
		X = setTimeout(function() {}, 100);
		Fai.top.$(".colorpanel").mouseenter(function() {
			clearTimeout(X)
		})
	}).mouseover(function() {
		clearTimeout(X);
		ai = true
	});
	at.find("select").mousedown(function() {
		clearTimeout(X);
		ai = false
	}).focusin(function() {
		clearTimeout(X);
		ai = false
	});
	at.find(".faiButton").mousedown(function() {
		ai = false
	});
	var g = at.find("#addModuleContentContainer");
	var F = at.find("#setSiteStyleContentContainer");
	var aB = at.find("#addModuleContentContainerTopLine");
	var aT = at.find("#setSiteStyleContentContainerTopLine");
	var C = at.find("#setSiteStyleMenuList").children("li");
	var V = F.find(".panelItemContainer");
	var aw, R;
	C.eq(0).addClass("on");
	C.children(".menu").hover(function() {
		$(this).parent().addClass("hover")
	}, function() {
		$(this).parent().removeClass("hover")
	}).click(function() {
		R = $(this).parent();
		aw = C.filter(".on").index() - R.index();
		C.removeClass("on");
		R.addClass("on");
		if(Fai.isIE6() || Fai.isIE7()) {
			F.scrollTop(0).scrollTop(at.find("#" + $(this).attr("nav")).offset().top - aT.offset().top)
		} else {
			Site.switchTabAnimate("#" + $(this).attr("nav"), true, aw)
		}
	});
	var af = at.find("#addModuleMenuList").children("li");
	af.eq(0).addClass("on");
	af.children(".menu").hover(function() {
		$(this).parent().addClass("hover")
	}, function() {
		$(this).parent().removeClass("hover")
	}).click(function() {
		af.removeClass("on");
		$(this).parent().addClass("on");
		if(Fai.isIE6() || Fai.isIE7()) {
			g.scrollTop(0).scrollTop(at.find("#" + $(this).attr("nav")).offset().top - aB.offset().top)
		} else {
			g.mCustomScrollbar("scrollTo", "#" + $(this).attr("nav") + "", {
				scrollInertia: 0
			})
		}
	});
	var P = at.find("#sectionModuleMenuList").children("li");
	P.eq(0).addClass("on");
	at.find("#" + P.eq(0).children(".menu").attr("nav")).show().siblings().hide();
	P.children(".menu").hover(function() {
		$(this).parent().addClass("hover")
	}, function() {
		$(this).parent().removeClass("hover")
	}).click(function() {
		P.removeClass("on");
		$(this).parent().addClass("on");
		at.find("#" + $(this).attr("nav")).show().siblings().hide()
	});
	if(Fai.isIE6() || Fai.isIE7()) {
		g.scroll(function() {
			var aY = aB.offset().top - 20;
			$.each(Fai.top.$("#addModuleContentContainer .splitLine"), function(aZ, a0) {
				if(($(a0).offset().top - aY) > 0) {
					af.removeClass("on").eq(aZ).addClass("on");
					return false
				}
			})
		});
		F.scroll(function() {
			var aY = aT.offset().top - 20;
			$.each(Fai.top.$("#setSiteStyleContentContainer .splitLine"), function(aZ, a0) {
				if(($(a0).offset().top - aY) > 0) {
					C.removeClass("on").eq(aZ).addClass("on");
					return false
				}
			})
		})
	}
	var aM = g.find(".panelModuleIcon");
	aM.click(function() {
		ai = false
	});
	Fai.top.panelFunc = {};
	Fai.top.panelFunc.changeSiteWidth = function(aZ, a0) {
		var aY;
		aY = Site.getWebBackgroundData();
		if(aZ == 0) {
			$("#setBackgroundWidth-box").hide();
			aY.sw = -1;
			Site.removeSiteWidth()
		} else {
			aY.sw = ar;
			Site.setSiteWidth(ar);
			$("#setBackgroundWidth-box").show();
			if(ao == 1) {
				ao = 2
			}
		}
		if(a0) {
			if(aZ == 0) {
				Site.averageMulMColContent()
			} else {
				Site.averageMulMColContent(aY.sw);
				D()
			}
		}
		if(!a0) {
			T()
		}
		if(!aj) {
			Site.saveWebBackgroundData(aY);
			B();
			Site.logDog(100080, 1)
		}
		Site.fixSiteWidth(Fai.top._manageMode);
		Site.showNavItemContainer();
		Site.adjustBannerWidth();
		Site.adjustPhotoCard();
		Site.adjustPhotoNewCard();
		Site.adjustPhotoMoreCard();
		if(ao == 0) {
			ao = 1
		} else {
			if(ao == 1 && aZ == 0) {
				ao = 3
			} else {
				if(ao == 2) {
					ao = 3
				} else {
					if(ao == 3) {
						Site.LayoutMiddleLeftRightReset()
					}
				}
			}
		}
	};
	Fai.top.panelFunc.changeWebBg = function(aZ) {
		var aY;
		aY = Site.getWebBackgroundData();
		if(aZ == 1) {
			Site.hideSiteBg();
			aY.h = true;
			aY.s = false;
			$("#cusPanel").hide()
		} else {
			if(aZ == 2) {
				var a0 = "";
				$("#cusPanel").show();
				aY.h = false;
				aY.s = false;
				if(aY.o == "") {
					aY.o = "#fff"
				}
				if(aY.r == -1) {
					$("#bgEffect").hide();
					a0 = j(aY);
					Site.setSiteBg(a0, aY.o)
				} else {
					$("#bgEffect").show();
					if(aY.e == 0) {
						$("#scrollEffect").click()
					} else {
						$("#fixedEffect").click()
					}
				}
			} else {
				Site.removeSiteBg();
				aY.h = false;
				aY.s = true;
				$("#cusPanel").hide()
			}
		}
		Site.saveWebBackgroundData(aY);
		if(!aj) {
			B();
			Site.logDog(100080, 2)
		}
	};
	Fai.top.panelFunc.changeWebBgEffect = function(aZ) {
		var aY;
		var a0 = "";
		aY = Site.getWebBackgroundData();
		a0 = j(aY);
		aY.e = aZ;
		Site.saveWebBackgroundData(aY);
		if(aZ == 0) {
			a0 += " scroll"
		}
		Site.setSiteBg(a0, aY.o, aZ);
		B();
		if(!aj) {}
	};
	Fai.top.panelFunc.bgDisplayChange = function(a0) {
		var aY;
		aY = Site.getWebBackgroundData();
		var a1 = "";
		var aZ = $("#bgDisplay").val();
		aZ = parseInt(aZ);
		aY.r = aZ;
		if(aY.r == -1) {
			$("#bgEffect").hide();
			a1 = j(aY);
			Site.setSiteBg(a1, aY.o);
			B()
		} else {
			$("#bgEffect").show();
			if(aY.e == 0) {
				$("#scrollEffect").click()
			} else {
				$("#fixedEffect").click()
			}
		}
		if(!aY.p) {
			if(a0.value != -1) {
				Fai.ing("请先添加背景图片。", true);
				return
			}
		}
		Site.showRepeatTip(aZ);
		aY.s = false;
		Site.saveWebBackgroundData(aY)
	};
	Fai.top.panelFunc.view = function(aY) {
		var aZ = "../view.jsp?fileID=" + aY;
		window.open(aZ)
	};
	Fai.top.panelFunc.changeBlockStatus = function(aY, aZ) {
		aY ? $("#" + aZ).show() : $("#" + aZ).hide()
	};
	Fai.top.panelFunc.refreshHeaderTop = function() {
		if($("#topStyleCustom").attr("checked")) {
			var aY = parseInt($("#settingHeightInput").val());
			if(aY === "" || isNaN(aY)) {
				Fai.ing("高度设置不能为空", true);
				return
			} else {
				if(aY < 0 || aY > 1000) {
					Fai.ing("只能设置0~1000的高度", true);
					return
				} else {
					if(!Fai.isNumber(aY)) {
						Fai.ing("只能输入数字", true);
						$("#settingHeightInput").val("");
						return
					}
				}
			}
			if(!isNaN(parseInt(aY))) {
				Site.setHeaderTopHeight(aY)
			}
		} else {
			Site.autoHeaderTopHeight()
		}
		if(!aj) {
			aO();
			Site.logDog(100080, 3)
		}
	};
	Fai.top.panelFunc.changeHeadBgType = function(aY) {
		if(aY == 1) {
			$("#headBgCus").hide()
		} else {
			if(aY == 2) {
				$("#headBgCus").show()
			} else {
				$("#headBgCus").hide()
			}
		}
		if(aj) {
			return
		}
		var aZ;
		aZ = Site.getHeaderStyleData();
		if(aY == 1) {
			aZ.y = 1;
			Site.hideHeaderBg();
			aO()
		} else {
			if(aY == 2) {
				aZ.y = 2;
				ap();
				aO()
			} else {
				aZ.y = 0;
				Site.removeHeaderBg();
				aO()
			}
		}
		if(!aj) {
			Site.logDog(100080, 4)
		}
	};
	Fai.top.panelFunc.headBgRepeatChange = function(aZ) {
		var aY;
		aY = Site.getHeaderStyleData();
		var a0 = parseInt($("#headBgRepeat").val());
		aY.r = a0;
		if(!aY.f) {
			if(aZ.value != -1) {
				Fai.ing("请先添加背景图片。", true);
				return
			}
		}
		Site.showRepeatTip(a0);
		ap();
		aO()
	};
	Fai.top.panelFunc.changeTopBorderAddition = function(aZ) {
		var aY;
		Fai.top._Global._useTemplateBackground ? aY = Fai.top._headerTopStyle : aY = Fai.top._customHeaderTopStyle;
		switch(aZ) {
			case 1:
				u(aY);
				break;
			case 2:
				y(aY);
				break;
			default:
				u(aY);
				y(aY)
		}
	};

	function u(aZ) {
		var a0 = aZ.bb,
			a1 = Fai.top.$("#panelItemContainer_top"),
			aY = a1.find(".J_TopBorderAdditionContent");
		if($("#J_TopBorderAddition_cus").prop("checked")) {
			aY.find(".J_borderSet").show();
			a0.y = 2;
			a0.w ? a0.w : a0.w = 1;
			if(typeof a0.w != "undefined") {
				aY.find(".J_width").val(a0.w)
			}
		} else {
			if($("#J_TopBorderAddition_hide").prop("checked")) {
				aY.find(".J_borderSet").hide();
				a0.y = 1
			} else {
				if($("#J_TopBorderAddition_sys").prop("checked")) {
					aY.find(".J_borderSet").hide();
					a0.y = 0
				}
			}
		}
		if($("#J_TopBorderAddition_cusColor").prop("checked")) {
			aY.find(".J_color").show();
			if(!a0.c) {
				a0.c = "transparent"
			}
		} else {
			if($("#J_TopBorderAddition_sysColor").prop("checked")) {
				aY.find(".J_color").hide();
				if(typeof a0.c != "undefined") {
					delete a0.c
				}
				aY.find(".J_color").css("background-color", "transparent")
			}
		}
		Site.addInputEventUnit("#J_topBorderWidth");
		Site.refreshTopBorder();
		aO()
	}

	function y(aZ) {
		var a2 = aZ.bb,
			a3 = Fai.top.$("#panelItemContainer_top"),
			aY = a3.find(".J_TopBorderAdditionContent"),
			a1 = parseInt(aY.find(".J_width").val()),
			a0 = parseInt(aY.find(".J_style").val());
		if(a1 >= 0 && a1 <= 99) {
			a2.w = parseInt(a1)
		} else {
			Fai.ing("请输入0到99之间的数值", true);
			if(!Fai.top.isNaN(a1)) {
				aY.find(".J_width").val(a2.w)
			}
			return
		}
		if(a0 != "undefined") {
			a2.s = a0
		} else {
			delete a2.s
		}
		Site.refreshTopBorder();
		aO()
	}
	Fai.top.panelFunc.refreshBannerBgHeight = function() {
		var aZ = Site.getWebBackgroundData();
		if($("#topBannerCustom").attr("checked")) {
			var aY = parseInt($("#settingBannerHeightInput").val() || 0);
			if(aY === "" || isNaN(aY)) {
				Fai.ing("高度设置不能为空", true);
				return
			} else {
				if(aY < 0 || aY > 1000) {
					Fai.ing("只能设置0~1000的高度", true);
					return
				} else {
					if(!Fai.isNumber(aY)) {
						Fai.ing("只能输入数字", true);
						$("#settingBannerHeightInput").val("");
						return
					}
				}
			}
			if(!isNaN(parseInt(aY))) {
				aZ.wbh = parseInt(aY);
				Site.setWebBannerHeight(aY)
			}
			Site.addInputEventUnit("#settingBannerHeightInput")
		} else {
			aZ.wbh = -1;
			var a0 = Fai.top.$("#banner");
			a0.css({
				height: a0.attr("normalheight") + "px"
			});
			Site.autoWebBannerHeight()
		}
		Site.saveWebBackgroundData(aZ);
		B("banner");
		if(!aj) {
			Site.logDog(100080, 5);
			Site.refreshBanner()
		}
	};
	Fai.top.panelFunc.changeBannerWidth = function(aZ) {
		var aY;
		aY = Site.getWebBackgroundData();
		if(aZ == 0) {
			aY.wbws = 0;
			$("#setBannerWidth-box").hide();
			aY.wbw = -1;
			Site.autoWebBannerWidth()
		} else {
			if(aZ == 1) {
				aY.wbw = A;
				aY.wbws = 1;
				Site.setWebBannerWidth(A);
				$("#setBannerWidth-box").show()
			} else {
				aY.wbws = 2;
				aY.wbw = A;
				Site.setWideBannerWidth();
				$("#setBannerWidth-box").hide()
			}
		}
		Site.adjustBannerWidth();
		if(!aj) {
			Site.saveWebBackgroundData(aY);
			B("banner");
			Site.refreshBanner();
			Site.logDog(100080, 13)
		}
	};
	Fai.top.panelFunc.changeBannerBg = function(a0) {
		var aZ;
		aZ = Site.getBannerBackgroundData();
		if(a0 == 1) {
			$("#cusBannerPanel").hide();
			aZ.y = 1;
			Site.hideBannerBg()
		} else {
			if(a0 == 2) {
				var aY = "";
				$("#cusBannerPanel").show();
				aZ.y = 2;
				aY = o(aZ);
				Site.setBannerBg(aY)
			} else {
				$("#cusBannerPanel").hide();
				aZ.y = 0;
				Site.removeBannerBg()
			}
		}
		Site.saveBannerBackgroundData(aZ);
		if(!aj) {
			B("banner");
			Site.logDog(100080, 6)
		}
	};
	Fai.top.panelFunc.bannerBgRepeatChange = function(a1) {
		var aZ;
		aZ = Site.getBannerBackgroundData();
		var aY = "";
		var a0 = $("#bannerBgDisplay").val();
		a0 = parseInt(a0);
		aZ.r = a0;
		if(!aZ.f) {
			if(a1.value != -1) {
				Fai.ing("请先添加背景图片。", true);
				return
			}
		}
		Site.showRepeatTip(a0);
		aZ.y = 2;
		Site.saveBannerBackgroundData(aZ);
		aY = o(aZ);
		Site.setBannerBg(aY);
		B("banner")
	};
	Fai.top.panelFunc.changeBannerScaleType = function(aZ) {
		var aY;
		aY = Site.getWebBackgroundData();
		if(aZ == 0) {
			aY.wbs = 0
		} else {
			if(aZ == 1) {
				aY.wbs = 1
			}
		}
		if(Fai.top._bannerData.n.length > 0 && Fai.top._bannerData.s == 4) {
			Fai.top.Site.refreshBannerImageSwitch(0)
		}
		if(!aj) {
			B("banner");
			Site.logDog(100080, 23)
		}
	};
	Fai.top.panelFunc.changeContentBg = function(a0) {
		var aY;
		aY = Site.getContentBackgroundData();
		if(a0 == 1) {
			$("#cusContentPanel").hide();
			aY.y = 1;
			Site.hideContentBg()
		} else {
			if(a0 == 2) {
				var aZ = "";
				$("#cusContentPanel").show();
				aY.y = 2;
				aZ = J(aY);
				Site.setContentBg(aZ, "none")
			} else {
				$("#cusContentPanel").hide();
				aY.y = 0;
				Site.removeContentBg()
			}
		}
		Site.saveContentBackgroundData(aY);
		if(!aj) {
			B("content");
			Site.logDog(100080, 7)
		}
	};
	Fai.top.panelFunc.contentBgRepeatChange = function(a1) {
		var aY;
		aY = Site.getContentBackgroundData();
		var aZ = "";
		var a0 = $("#contentBgDisplay").val();
		a0 = parseInt(a0);
		aY.r = a0;
		if(!aY.f) {
			if(a1.value != -1) {
				Fai.ing("请先添加背景图片。", true);
				return
			}
		}
		Site.showRepeatTip(a0);
		aY.y = 2;
		Site.saveContentBackgroundData(aY);
		aZ = J(aY);
		Site.setContentBg(aZ, "none");
		B("content")
	};
	Fai.top.panelFunc.changeContentMiddleBg = function(a0) {
		var aY;
		aY = Site.getContentMiddleBackgroundData();
		if(a0 == 1) {
			$("#cusContentMiddlePanel").hide();
			aY.y = 1;
			Site.hideContentMiddleBg()
		} else {
			if(a0 == 2) {
				var aZ = "";
				$("#cusContentMiddlePanel").show();
				aY.y = 2;
				aZ = U(aY);
				Site.setContentMiddleBg(aZ)
			} else {
				$("#cusContentMiddlePanel").hide();
				aY.y = 0;
				Site.removeContentMiddleBg()
			}
		}
		Site.saveContentMiddleBackgroundData(aY);
		if(!aj) {
			B("content");
			Site.logDog(100080, 14)
		}
	};
	Fai.top.panelFunc.contentMiddleBgRepeatChange = function(a1) {
		var aY;
		aY = Site.getContentMiddleBackgroundData();
		var aZ = "";
		var a0 = $("#contentMiddleBgDisplay").val();
		a0 = parseInt(a0);
		aY.r = a0;
		if(!aY.f) {
			if(a1.value != -1) {
				Fai.ing("请先添加背景图片。", true);
				return
			}
		}
		Site.showRepeatTip(a0);
		aY.y = 2;
		Site.saveContentMiddleBackgroundData(aY);
		aZ = U(aY);
		Site.setContentMiddleBg(aZ);
		B("content")
	};
	Fai.top.panelFunc.changeContentLeftWidth = function(aZ) {
		var aY;
		aY = Site.getWebBackgroundData();
		if(aZ == 0) {
			$("#setContentLeftWidth-box").hide();
			aY.clw = -1;
			Site.autoContentLeftWidth()
		} else {
			aY.clw = cusNowContentLeftWidth;
			Site.setContentLeftWidth(cusNowContentLeftWidth);
			$("#setContentLeftWidth-box").show()
		}
		if(!aj) {
			Site.saveWebBackgroundData(aY);
			B("content");
			Site.logDog(100080, 15)
		}
	};
	Fai.top.panelFunc.changeContentRightWidth = function(aZ) {
		var aY;
		aY = Site.getWebBackgroundData();
		if(aZ == 0) {
			$("#setContentRightWidth-box").hide();
			aY.crw = -1;
			Site.autoContentRightWidth()
		} else {
			aY.crw = cusNowContentRightWidth;
			Site.setContentRightWidth(cusNowContentRightWidth);
			$("#setContentRightWidth-box").show()
		}
		if(!aj) {
			Site.saveWebBackgroundData(aY);
			B("content");
			Site.logDog(100080, 16)
		}
	};
	Fai.top.panelFunc.changeContentPaddingType = function(a0) {
		var aY, aZ;
		aY = Site.getWebBackgroundData(), aZ = aY.cp || (aY.cp = {
			y: 0
		});
		if(a0 == 0) {
			$(".J_contentPaddingSet").hide();
			aZ.y = 0;
			Site.autoContentPaddingValue("padding-top");
			Site.autoContentPaddingValue("padding-bottom")
		} else {
			aZ.y = 1;
			$(".J_contentPaddingSet").show();
			Fai.top.panelFunc.changeContentPaddingValue()
		}
		if(!aj) {
			Site.saveWebBackgroundData(aY);
			B("content")
		}
	};
	Fai.top.panelFunc.changeContentPaddingValue = function() {
		var aY, a1, a3 = $(".J_contentPaddingSet"),
			a4 = a3.find(".J_top"),
			aZ = parseInt(a4.val()),
			a2 = a3.find(".J_bottom"),
			a0 = parseInt(a2.val());
		aY = Site.getWebBackgroundData(), a1 = aY.cp || (aY.cp = {
			y: 0
		});
		if(aZ >= 0 && aZ <= 999) {
			a1.t = aZ;
			Site.setContentPaddingValue("padding-top", a1.t)
		} else {
			Fai.ing("请输入0到999之间的数值", true);
			if(isNaN(aZ)) {
				a1.t = 0
			}
		}
		if(a0 >= 0 && a0 <= 999) {
			a1.b = a0;
			Site.setContentPaddingValue("padding-bottom", a1.b)
		} else {
			Fai.ing("请输入0到999之间的数值", true);
			if(isNaN(a0)) {
				a1.b = 0
			}
		}
		if(!aj) {
			Site.saveWebBackgroundData(aY);
			B("content")
		}
	};
	Fai.top.panelFunc.changeFooterAlign = function(aY) {
		if(aj) {
			return
		}
		Fai.top._Global._useTemplateBackground ? Fai.top._footerStyleData.fa = parseInt(aY) : Fai.top._customFooterStyleData.fa = parseInt(aY);
		Site.refreshFooterAlign(aY);
		az();
		if(!aj) {
			Site.logDog(100080, 8)
		}
	};
	Fai.top.panelFunc.onPaddingChange = function() {
		var aY;
		aY = Site.getFooterStyleData();
		var a2 = parseInt($("#leftFooterPadding").val() || 0);
		var aZ = parseInt($("#rightFooterPadding").val() || 0);
		var a1 = parseInt($("#upFooterPadding").val() || 0);
		var a3 = parseInt($("#downFooterPadddng").val() || 0);
		if(a2 < 0 || a1 < 0 || a3 < 0 || aZ < 0) {
			return
		}
		a2 = parseInt(a2);
		if(isNaN(a2)) {
			a2 = aY.f.l
		}
		if(a2 < 0 || a2 > 999) {
			Fai.ing("请输入0到999之间的数值", true);
			$("#leftFooterPadding").val(aY.f.l);
			return
		}
		aZ = parseInt(aZ);
		if(isNaN(aZ)) {
			aZ = aY.f.r
		}
		if(aZ < 0 || aZ > 999) {
			Fai.ing("请输入0到999之间的数值", true);
			$("#rightFooterPadding").val(aY.f.r);
			return
		}
		a1 = parseInt(a1);
		if(isNaN(a1)) {
			a1 = aY.f.u
		}
		if(a1 < 0 || a1 > 999) {
			Fai.ing("请输入0到999之间的数值", true);
			$("#upFooterPadding").val(aY.f.u);
			return
		}
		a3 = parseInt(a3);
		if(isNaN(a3)) {
			a3 = aY.f.d
		}
		if(a3 < 0 || a3 > 999) {
			Fai.ing("请输入0到999之间的数值", true);
			$("#downFooterPadddng").val(aY.f.d);
			return
		}
		aY.f.u = a1;
		aY.f.l = a2;
		aY.f.r = aZ;
		aY.f.d = a3;
		var a0 = "";
		a0 = "0 " + aZ + "px 0 " + a2 + "px";
		Fai.top.Fai.setCtrlStyleCssList("stylefooter", "footer", [{
			cls: ".footerContent",
			key: "padding-top",
			value: a1 + "px"
		}, {
			cls: ".footerContent",
			key: "padding-bottom",
			value: a3 + "px"
		}, {
			cls: ".footerNav",
			key: "padding",
			value: a0
		}, {
			cls: ".footerInfo",
			key: "padding",
			value: a0
		}, {
			cls: ".footerSupport",
			key: "padding",
			value: a0
		}, {
			cls: ".visitorCounterWrap",
			key: "padding",
			value: a0
		}]);
		Site.saveFooterStyleData(aY);
		az()
	};
	Fai.top.panelFunc.changefooterPaddingType = function(a1) {
		var aY = Site.getFooterStyleData();
		if(a1 == 1) {
			if(aY.f.d < 0) {
				aY.f.d = -aY.f.d;
				$("#downFooterPadddng").val(aY.f.d)
			} else {
				$("#downFooterPadddng").val(aY.f.d)
			}
			if(aY.f.l > 0) {
				$("#leftFooterPadding").val(aY.f.l)
			}
			if(aY.f.r > 0) {
				$("#rightFooterPadding").val(aY.f.r)
			}
			if(aY.f.t > 0) {
				$("#upFooterPadding").val(aY.f.u)
			}
			$("#footerPaddingCus").show();
			Fai.top.panelFunc.onPaddingChange()
		} else {
			$("#footerPaddingCus").hide();
			$("#upFooterPadding").val(0);
			$("#downFooterPadddng").val(0);
			var a0 = "0 0 0 0",
				a2 = 0,
				aZ = 0;
			Fai.top.Fai.setCtrlStyleCssList("stylefooter", "footer", [{
				cls: ".footerContent",
				key: "padding-top",
				value: aZ + "px"
			}, {
				cls: ".footerContent",
				key: "padding-bottom",
				value: a2 + "px"
			}, {
				cls: ".footerNav",
				key: "padding",
				value: a0
			}, {
				cls: ".footerInfo",
				key: "padding",
				value: a0
			}, {
				cls: ".footerSupport",
				key: "padding",
				value: a0
			}, {
				cls: ".visitorCounterWrap",
				key: "padding",
				value: a0
			}]);
			aY.f.u = 0;
			aY.f.d = 0;
			Site.saveFooterStyleData(aY);
			az()
		}
		Fai.top._Global._useTemplateBackground ? Fai.top._footerStyleData.f.t = parseInt(a1) : Fai.top._customFooterStyleData.f.t = parseInt(a1);
		if(aj) {
			return
		}
		if(!aj) {
			Site.logDog(100080, 9);
			jzUtils.run({
				name: "_elemZone.refreshFooterHeight",
				base: Fai.top
			})
		}
	};
	Fai.top.panelFunc.changeRegularTextType = function(aY) {
		if(aY == 1) {
			$("#footerRegularTextCus").show()
		} else {
			$("#footerRegularTextCus").hide()
		}
		if(aj) {
			return
		}
		Fai.top._Global._useTemplateBackground ? Fai.top._footerStyleData.rt.y = parseInt(aY) : Fai.top._customFooterStyleData.rt.y = parseInt(aY);
		if(aY == 1) {
			W()
		} else {
			Site.autoRegularText()
		}
		jzUtils.run({
			name: "floatPanelUISetting.refreshFooterTextFW"
		});
		az();
		if(!aj) {
			Site.logDog(100080, 10)
		}
		aH()
	};
	Fai.top.panelFunc.regularTextSizeChange = function(aZ) {
		var aY;
		aY = Site.getFooterStyleData();
		$("#regularTextSize").val(aZ);
		aY.rt.s = parseInt(aZ);
		W();
		az();
		aH()
	};
	Fai.top.panelFunc.regularTextFamilyChange = function(aY) {
		W();
		az();
		Site && Site.logFontFamilyUse && Site.logFontFamilyUse($("#regularTextFamily").val())
	};
	Fai.top.panelFunc.changeFooterNavTextType = function(aY) {
		if(aY == 1) {
			$("#footerNavTextCus").show()
		} else {
			$("#footerNavTextCus").hide()
		}
		if(aj) {
			return
		}
		Fai.top._Global._useTemplateBackground ? Fai.top._footerStyleData.gt.y = parseInt(aY) : Fai.top._customFooterStyleData.gt.y = parseInt(aY);
		if(aY == 1) {
			v()
		} else {
			Site.autoFooterNavGeneralText()
		}
		az();
		if(!aj) {
			Site.logDog(100080, 11)
		}
	};
	Fai.top.panelFunc.footerNavTextSizeChange = function(aZ) {
		var aY;
		aY = Site.getFooterStyleData();
		$("#footerNavTextSize").val(aZ);
		aY.gt.s = parseInt(aZ);
		v();
		az()
	};
	Fai.top.panelFunc.footerNavTextBoldCheck = function(aY) {
		v();
		az()
	};
	Fai.top.panelFunc.footerDecorationCheck = function(aY) {
		v();
		az()
	};
	Fai.top.panelFunc.footerNavTextFamilyChange = function(aY) {
		v();
		az();
		Site && Site.logFontFamilyUse && Site.logFontFamilyUse($("#footerNavTextFamily").val())
	};
	Fai.top.panelFunc.changeFooterBgType = function(aZ) {
		if(aZ == 1) {
			$("#footerBgCus").hide()
		} else {
			if(aZ == 2) {
				$("#footerBgCus").show()
			} else {
				$("#footerBgCus").hide()
			}
		}
		if(aj) {
			return
		}
		var aY;
		aY = Site.getFooterStyleData();
		if(aZ == 1) {
			aY.fb.y = 1;
			Site.hideFooterBg()
		} else {
			if(aZ == 2) {
				aY.fb.y = 2;
				M()
			} else {
				aY.fb.y = 0;
				Site.autoFooterBg()
			}
		}
		Site.saveFooterStyleData(aY);
		az();
		if(!aj) {
			Site.logDog(100080, 12)
		}
	};
	Fai.top.panelFunc.footerBgRepeatChange = function(aZ) {
		var aY;
		aY = Site.getFooterStyleData();
		if(!aY.fb.f) {
			if(aZ.value != -1) {
				Fai.ing("请先添加背景图片。", true);
				return
			}
		}
		Site.showRepeatTip(aZ.value);
		M();
		az()
	};
	Fai.top.panelFunc.resetDefault = function(aY) {
		Fai.top.panelResetDefaultFlag = true;
		if(!aY) {
			$("#useSysSiteWidth").trigger("click")
		}
		$("#useSysBackground").trigger("click");
		$("#topStyleCustom").attr("checked", false);
		$("#topStyleDefault").trigger("click");
		$("#settingHeightInputWrap").hide();
		if(!aj) {
			Fai.top.panelFunc.refreshHeaderTop()
		}
		$("#topBannerCustom").attr("checked", false);
		$("#topBannerDefault").trigger("click");
		$("#J_TopBorderAddition_sys").attr("checked", "checked");
		$("#J_TopBorderAddition_sys").trigger("click");
		$("#settingBannerHeightInputWrap").hide();
		$("#useSysBannerWidth").trigger("click");
		if(!aj) {
			Fai.top.panelFunc.refreshBannerBgHeight()
		}
		$("#tfooterHeightCustom").attr("checked", false);
		$("#footerHeightDefault").trigger("click");
		$("#footerHeightInputWrap").hide();
		if(!aj) {
			b()
		}
		$("#headBg0").trigger("click");
		$("#useSysBannerBg").trigger("click");
		$("#useSysContentBg").trigger("click");
		$("#useSysContentMiddleBg").trigger("click");
		$("#useSysContentLeftWidth").trigger("click");
		$("#useSysContentRightWidth").trigger("click");
		$("#useSysContentPadding").trigger("click");
		$("#footerAlignDefault").trigger("click");
		$("#footerEdgeDistance0").trigger("click");
		$("#regularText1").trigger("click");
		$("#footerNavText0").trigger("click");
		$("#footerBg0").trigger("click");
		$("#J_FooterBorderAddition_sys").attr("checked", "checked");
		$("#J_FooterBorderAddition_sys").trigger("click");
		aW();
		Fai.top.panelResetDefaultFlag = false;
		Fai.top.$("#g_main").scrollTop(0)
	};

	function aW() {
		$("#patternChoice-normal").trigger("click");
		$("#normalItemPic").trigger("click");
		$("#sysItemWidth").trigger("click");
		$("#sysItemHeight").trigger("click");
		$("#sysFirstItemword").trigger("click");
		$("#normalItemSpacing").trigger("click");
		$("#sysItemVerticalLine").trigger("click");
		$("#autoDirection").trigger("click");
		$("#firstItemNoHref").trigger("click");
		$("#sysSecondItemHeight").trigger("click");
		$("#cusSecondItemHeight").trigger("click");
		$("#sysSecondItemword").trigger("click")
	}
	Fai.top.panelFunc.changeFooterBorderAddition = function(aY) {
		switch(aY) {
			case 1:
				aN();
				break;
			case 2:
				L();
				break;
			default:
				aN();
				L()
		}
	};

	function aN() {
		var a0 = Site.getFooterStyleData().b,
			aY = Fai.top.$("#panelItemContainer_foot"),
			aZ = aY.find(".J_FooterBorderAdditionContent");
		if($("#J_FooterBorderAddition_cus").prop("checked")) {
			aZ.find(".J_borderSet").show();
			a0.y = 2;
			a0.w ? a0.w : a0.w = 1;
			if(typeof a0.w != "undefined") {
				aZ.find(".J_width").val(a0.w)
			}
		} else {
			if($("#J_FooterBorderAddition_hide").prop("checked")) {
				aZ.find(".J_borderSet").hide();
				a0.y = 1
			} else {
				if($("#J_FooterBorderAddition_sys").prop("checked")) {
					aZ.find(".J_borderSet").hide();
					a0.y = 0
				}
			}
		}
		if($("#J_FooterBorderAddition_cusColor").prop("checked")) {
			aZ.find(".J_color").show();
			if(!a0.c) {
				a0.c = "transparent"
			}
		} else {
			if($("#J_FooterBorderAddition_sysColor").prop("checked")) {
				aZ.find(".J_color").hide();
				if(typeof a0.c != "undefined") {
					delete a0.c
				}
				aZ.find(".J_color").css("background-color", "transparent")
			}
		}
		Site.addInputEventUnit("#J_footerBorderWidth");
		Site.refreshFooterBorder();
		az()
	}

	function L() {
		var a2 = Site.getFooterStyleData().b,
			aY = Fai.top.$("#panelItemContainer_foot"),
			aZ = aY.find(".J_FooterBorderAdditionContent"),
			a1 = parseInt(aZ.find(".J_width").val()),
			a0 = parseInt(aZ.find(".J_style").val());
		if(aZ.find(".J_top").prop("checked")) {
			a2.t = 1
		} else {
			a2.t = 0
		}
		if(aZ.find(".J_bottom").prop("checked")) {
			a2.b = 1
		} else {
			a2.b = 0
		}
		if(Fai.top._uiMode) {
			if(aZ.find(".J_right").prop("checked")) {
				a2.r = 1
			} else {
				a2.r = 0
			}
			if(aZ.find(".J_left").prop("checked")) {
				a2.l = 1
			} else {
				a2.l = 0
			}
		}
		if(a1 >= 0 && a1 <= 99) {
			a2.w = parseInt(a1)
		} else {
			Fai.ing("请输入0到99之间的数值", true);
			if(!Fai.top.isNaN(a1)) {
				aZ.find(".J_width").val(a2.w)
			}
			return
		}
		if(a0 != "undefined") {
			a2.s = a0
		} else {
			delete a2.s
		}
		Site.refreshFooterBorder();
		az()
	}
	at.ready(function() {
		var a9, a3;
		var br;
		a9 = Site.getWebBackgroundData();
		var a4 = a9.o;
		if(a9.o == "") {
			a4 = "#fff"
		}
		$("#colorPicker").faiColorPicker({
			onchange: p,
			defaultcolor: a4,
			advance: true
		});
		var bf = 740;
		var bo = 1440;
		var be = parseInt(top.$(top.document).find("#webContainer").width()) || 960;
		ar = be;
		if(a9.sw == -1) {
			$("#useSysSiteWidth").attr("checked", "checked");
			Fai.top.panelFunc.changeSiteWidth(0)
		} else {
			$("#useCusSiteWidth").attr("checked", "checked");
			ar = (a9.sw == -1) ? be : a9.sw;
			Fai.top.panelFunc.changeSiteWidth(1)
		}
		var bs = {
				animate: true,
				max: bo,
				min: bf,
				orientation: "horizontal",
				step: 40,
				value: ar,
				start: bF,
				slide: bk,
				stop: bO
			},
			bE = $("#setBackgroundWidthContainer");
		$("#setBackgroundWidth").slider(bs);
		bE.append("<input id='ui-slider-value' style='float:left;' value='" + ar + "px' /> ");
		bE.find("#ui-slider-value").off("blur.validate").on("blur.validate", D);

		function bF(bS, bT) {
			$("#setBackgroundWidth").addClass("w-resize");
			br = Site.getWebBackgroundData();
			br.sw = bT.value;
			ar = bT.value;
			Site.setSiteWidth(bT.value);
			B()
		}

		function bk(bS, bT) {
			$(bT.handle).focus();
			$("#ui-slider-value").val(bT.value + "px");
			br = Site.getWebBackgroundData();
			Site.setSiteWidth(bT.value);
			Site.averageMulMColContent(bT.value, bT.value - ar);
			br.sw = bT.value;
			ar = bT.value;
			Site.LayoutMiddleLeftRightReset();
			Site.adjustPhotoCard();
			Site.adjustPhotoNewCard();
			Site.adjustPhotoMoreCard();
			Site.FitMemberProfilePanelImgSize()
		}

		function bO(bS, bT) {
			$("#setBackgroundWidth").removeClass("w-resize");
			$("#ui-slider-value").val(bT.value + "px");
			br = Site.getWebBackgroundData();
			br.sw = bT.value;
			ar = bT.value;
			Site.setSiteWidth(bT.value);
			Site.averageMulMColContent(bT.value, bT.value - ar);
			Site.fixSiteWidth(Fai.top._manageMode);
			Site.adjustBannerWidth();
			Site.refreshBanner();
			Site.bannerV2.refreshBanner();
			Site.adjustPhotoCard();
			Site.adjustPhotoNewCard();
			Site.adjustPhotoMoreCard();
			D()
		}
		var bM = {
			select: "#ui-slider-value",
			min: 740,
			max: 1440,
			defaultVal: 960,
			unit: "px",
			controlSlider: "#setBackgroundWidth",
			onChange: a5,
			blurCheck: true
		};
		Site.sliderInputUnit(bM);

		function a5(bS) {
			br = Site.getWebBackgroundData();
			br.sw = bS;
			Site.setSiteWidth(bS);
			Site.averageMulMColContent(bS, bS - ar);
			ar = bS;
			Site.LayoutMiddleLeftRightReset();
			Site.adjustPhotoCard();
			Site.adjustPhotoNewCard();
			Site.adjustPhotoMoreCard();
			B()
		}
		if(a9.s) {
			$("#useSysBackground").click()
		} else {
			if(a9.h) {
				$("#hideBackground").click()
			} else {
				$("#useCusBackground").click()
			}
		}
		$("#bgDisplay").val(a9.r);
		if(a9.id) {
			$("#uploadmsgBg").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + a9.id + "\");return false;'>查看</a>");
			$("#cusPanel").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#cusPanel").find(".J_preview").html("<img class='f-previewImg' src='" + a9.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />")
		}
		if(!z && Fai.top._oem) {
			$("#useSysBackground").click();
			$("#useCusBackground").attr("disabled", true);
			$("#hideBackground").attr("disabled", true)
		}
		var bK = aV;
		if(Fai.top._internal) {
			bK = 3
		}
		var bz = {
			title: "添加图片",
			maxSize: parseInt(bK),
			type: ["jpg", "jpeg", "gif", "png", "bmp"],
			from: "bg",
			entry: "webBg"
		};
		Site.fileUpload2("#fileUploadV2", bz, ab);
		var bC;
		bC = Site.getHeaderStyleData();
		if(bC.f) {
			$("#uploadmsg").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + bC.f + "\");return false;'>查看</a>");
			$("#headBgCus").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#headBgCus").find(".J_preview").html("<img class='f-previewImg' src='" + bC.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />")
		}
		var by = {
			title: "添加图片",
			maxSize: parseInt(aV),
			type: ["jpg", "jpeg", "gif", "png"],
			imgMode: Fai.top._panelOptionData.imgMode,
			from: "bg",
			entry: "headBg"
		};
		Site.fileUpload2("#headBgFileButton", by, aF);
		ah();
		aA();
		e();
		if(aC) {
			$("#headBg0").click();
			Fai.top.panelFunc.changeHeadBgType(0);
			Site.removeHeaderBg();
			$(".freeDisable").attr("disabled", true)
		} else {
			$(".freeDisable").removeAttr("disabled")
		}
		m();
		aX();
		if(top._templateLayout == 0 || top._templateLayout == 1 || top._templateLayout == 7 || top._templateLayout == 9 || top._templateLayout == 10) {
			$("#panelItemContainer_banner").show();
			$("#bannerStyleLine").show();
			$("#menu_bannerStyleLine").show()
		} else {
			$("#panelItemContainer_banner").hide();
			$("#bannerStyleLine").hide();
			$("#menu_bannerStyleLine").hide()
		}
		var bb = a9.bBg;
		if(bb.f) {
			$("#uploadmsgBannerBg").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + bb.f + "\");return false;'>查看</a>");
			$("#cusBannerPanel").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#cusBannerPanel").find(".J_preview").html("<img class='f-previewImg' src='" + bb.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />")
		}
		var bx = {
			title: "添加图片",
			maxSize: parseInt(aV),
			type: ["jpg", "jpeg", "gif", "png"],
			imgMode: Fai.top._panelOptionData.imgMode,
			from: "bg",
			entry: "bannerBg"
		};
		Site.fileUpload2("#bannerFileUploadV2", bx, aR);
		var bA = 740;
		var bB = 1440;
		var bP = parseInt(top.$(top.document).find("#webBanner").width());
		if(bP > 1440) {
			bP = 1440
		}
		var bv = bP || 740;
		A = bv;
		if(Fai.top._isTemplateVersion2) {
			if(a9.wbws == 2) {
				if(Fai.top._wideBanner) {
					$("#useSysBannerWidth").click()
				} else {
					$("#wideScreenBannerWidth").click()
				}
			} else {
				if(a9.wbws == 1) {
					A = (a9.wbw == -1) ? bv : a9.wbw;
					$("#useCusBannerWidth").click()
				} else {
					if(a9.wbws == 0) {
						$("#useSysBannerWidth").click()
					} else {
						if(a9.wbw == -1) {
							$("#useSysBannerWidth").click()
						} else {
							A = (a9.wbw == -1) ? bv : a9.wbw;
							$("#useCusBannerWidth").click()
						}
					}
				}
			}
		} else {
			if(a9.wbw == -1) {
				$("#useSysBannerWidth").click()
			} else {
				A = (a9.wbw == -1) ? bv : a9.wbw;
				$("#useCusBannerWidth").click()
			}
		}
		if(a9.wbs == 1) {
			$("#bannerScaleAuto").click()
		} else {
			$("#bannerScaleDefault").click()
		}
		var bp = {
			animate: true,
			max: bB,
			min: bA,
			orientation: "horizontal",
			step: 20,
			value: A,
			start: bL,
			slide: bN,
			stop: ba
		};
		$("#setBannerWidth").slider(bp);
		$("#setBannerWidthContainer").append("<input id='banner-width-slider-value' style='float:left;' value='" + A + "px'/>");

		function bL(bS, bT) {
			$("#setBannerWidth").addClass("w-resize");
			br = Site.getWebBackgroundData();
			br.wbw = bT.value;
			A = bT.value;
			Site.setWebBannerWidth(bT.value);
			B("banner")
		}

		function bN(bS, bT) {
			$(bT.handle).focus();
			$("#banner-width-slider-value").val(bT.value + "px");
			br = Site.getWebBackgroundData();
			br.wbw = bT.value;
			A = bT.value;
			Site.setWebBannerWidth(bT.value)
		}

		function ba(bS, bT) {
			$("#setBannerWidth").removeClass("w-resize");
			$("#banner-width-slider-value").val(bT.value + "px");
			br = Site.getWebBackgroundData();
			br.wbw = bT.value;
			A = bT.value;
			Site.setWebBannerWidth(bT.value);
			Site.saveWebBackgroundData(br);
			Site.adjustBannerWidth();
			Site.refreshBanner()
		}
		var bg = {
			select: "#banner-width-slider-value",
			min: 740,
			max: 1440,
			defaultVal: 960,
			unit: "px",
			controlSlider: "#setBannerWidth",
			onChange: a2,
			blurCheck: true
		};
		Site.sliderInputUnit(bg);

		function a2(bS) {
			br = Site.getWebBackgroundData();
			br.wbw = bS;
			A = bS;
			Site.setWebBannerWidth(bS);
			Site.saveWebBackgroundData(br);
			Site.adjustBannerWidth();
			Site.refreshBanner();
			B("banner")
		}
		if(aC) {
			$("#useSysBannerBg").click();
			$("#hideBannerBg").attr("disabled", true);
			$("#useCusBannerBg").attr("disabled", true);
			$("#useCusBannerWidth").attr("disabled", true);
			$("#useSysBannerWidth").click()
		} else {
			$("#hideBannerBg").removeAttr("disabled");
			$("#useCusBannerBg").removeAttr("disabled");
			$("#useCusBannerWidth").removeAttr("disabled")
		}
		var bj = at.find("#panelOptionBox-contentLeftWdith");
		var bR = at.find("#panelOptionBox-contentRightWdith");
		r();
		ae();
		if(aC) {
			$("#useSysContentBg").click();
			$("#hideContentBg").attr("disabled", true);
			$("#useCusContentBg").attr("disabled", true);
			$("#useSysContentMiddleBg").click();
			$("#hideContentMiddleBg").attr("disabled", true);
			$("#useCusContentMiddleBg").attr("disabled", true);
			$("#useSysContentLeftWidth").click();
			$("#useCusContentLeftWidth").attr("disabled", true);
			$("#useSysContentRightWidth").click();
			$("#useCusContentRightWidth").attr("disabled", true)
		} else {
			$("#hideContentBg").removeAttr("disabled");
			$("#useCusContentBg").removeAttr("disabled");
			$("#hideContentMiddleBg").removeAttr("disabled");
			$("#useCusContentMiddleBg").removeAttr("disabled");
			$("#useCusContentLeftWidth").removeAttr("disabled");
			$("#useCusContentRightWidth").removeAttr("disabled")
		}
		var bm = a9.cBg;
		if(bm.f) {
			$("#uploadmsgContentBg").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + bm.f + "\");return false;'>查看</a>");
			$("#cusContentPanel").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#cusContentPanel").find(".J_preview").html("<img class='f-previewImg' src='" + bm.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />")
		}
		var aY = a9.cmBg;
		if(aY.f) {
			$("#uploadmsgContentMiddleBg").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + aY.f + "\");return false;'>查看</a>");
			$("#cusContentMiddlePanel").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#cusContentMiddlePanel").find(".J_preview").html("<img class='f-previewImg' src='" + aY.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />")
		}
		var bw = {
			title: "添加图片",
			maxSize: parseInt(aV),
			type: ["jpg", "jpeg", "gif", "png"],
			imgMode: Fai.top._panelOptionData.imgMode,
			from: "bg",
			entry: "contentBg"
		};
		Site.fileUpload2("#contentFileUploadV2", bw, aP);
		var bt = {
			title: "添加图片",
			maxSize: parseInt(aV),
			type: ["jpg", "jpeg", "gif", "png"],
			imgMode: Fai.top._panelOptionData.imgMode,
			from: "bg",
			entry: "contentBg"
		};
		Site.fileUpload2("#contentMiddleFileUploadV2", bt, w);
		var bd = 200;
		var bi = 400;
		var aZ = parseInt(top.$(top.document).find("#containerFormsLeft").width());
		if(aZ > bi) {
			aZ = bi
		}
		var bn = aZ || 200;
		cusNowContentLeftWidth = bn;
		if(a9.clw == -1) {
			$("#useSysContentLeftWidth").click()
		} else {
			cusNowContentLeftWidth = (a9.clw == -1) ? bn : a9.clw;
			$("#useCusContentLeftWidth").click()
		}
		var a8 = {
			animate: true,
			max: bi,
			min: bd,
			orientation: "horizontal",
			step: 10,
			value: cusNowContentLeftWidth,
			start: a1,
			slide: bc,
			stop: bG
		};
		$("#setContentLeftWidth").slider(a8);
		$("#setContentLeftWidthContainer").append("<input id='contentLeft-width-slider-value' style='float:left;' value='" + cusNowContentLeftWidth + "px'/>");

		function a1(bS, bT) {
			$("#setContentLeftWidth").addClass("w-resize");
			br = Site.getWebBackgroundData();
			br.clw = bT.value;
			cusNowContentLeftWidth = bT.value;
			Site.setContentLeftWidth(bT.value);
			B("content")
		}

		function bc(bS, bT) {
			$(bT.handle).focus();
			$("#contentLeft-width-slider-value").val(bT.value + "px");
			br = Site.getWebBackgroundData();
			br.clw = bT.value;
			cusNowContentLeftWidth = bT.value;
			Site.setContentLeftWidth(bT.value)
		}

		function bG(bS, bT) {
			$("#setContentLeftWidth").removeClass("w-resize");
			$("#contentLeft-width-slider-value").val(bT.value + "px");
			br = Site.getWebBackgroundData();
			br.clw = bT.value;
			cusNowContentLeftWidth = bT.value;
			Site.setContentLeftWidth(bT.value);
			Site.saveWebBackgroundData(br)
		}
		var a6 = {
			select: "#contentLeft-width-slider-value",
			min: 200,
			max: 400,
			defaultVal: 210,
			unit: "px",
			controlSlider: "#setContentLeftWidth",
			onChange: bh,
			blurCheck: true
		};
		Site.sliderInputUnit(a6);

		function bh(bS) {
			br = Site.getWebBackgroundData();
			br.clw = bS;
			cusNowContentLeftWidth = bS;
			Site.setContentLeftWidth(bS);
			Site.saveWebBackgroundData(br);
			Site.styleChanged()
		}
		var bD = 200;
		var bI = 400;
		var bQ = parseInt(top.$(top.document).find("#containerFormsRight").width());
		if(bQ > bI) {
			bQ = bI
		}
		var bH = bQ || 200;
		cusNowContentRightWidth = bH;
		if(a9.crw == -1) {
			$("#useSysContentRightWidth").click()
		} else {
			cusNowContentRightWidth = (a9.crw == -1) ? bH : a9.crw;
			$("#useCusContentRightWidth").click()
		}
		var a7 = {
			animate: true,
			max: bI,
			min: bD,
			orientation: "horizontal",
			step: 10,
			value: cusNowContentRightWidth,
			start: bq,
			slide: bJ,
			stop: a0
		};
		$("#setContentRightWidth").slider(a7);
		$("#setContentRightWidthContainer").append("<span id='contentRight-width-slider-value' style='float:left;'>" + cusNowContentRightWidth + "px</span>");

		function bq(bS, bT) {
			$("#setContentRightWidth").addClass("w-resize");
			br = Site.getWebBackgroundData();
			br.crw = bT.value;
			cusNowContentRightWidth = bT.value;
			Site.setContentRightWidth(bT.value);
			B("content")
		}

		function bJ(bS, bT) {
			$(bT.handle).focus();
			$("#contentRight-width-slider-value").text(bT.value + "px");
			br = Site.getWebBackgroundData();
			br.crw = bT.value;
			cusNowContentRightWidth = bT.value;
			Site.setContentRightWidth(bT.value)
		}

		function a0(bS, bT) {
			$("#setContentRightWidth").removeClass("w-resize");
			$("#contentRight-width-slider-value").text(bT.value + "px");
			br = Site.getWebBackgroundData();
			br.crw = bT.value;
			cusNowContentRightWidth = bT.value;
			Site.setContentRightWidth(bT.value);
			Site.saveWebBackgroundData(br)
		}
		Site.isLayoutHidden(1) ? bj.hide() : bj.show();
		Site.isLayoutHidden(3) ? bR.hide() : bR.show();
		aE();
		if(aC) {
			$("#footerAlignLeft").attr("disabled", true);
			$("#footerAlignCenter").attr("disabled", true);
			$("#footerNavText1").attr("disabled", true);
			$("#footerAlignRight").attr("disabled", true);
			$("#footerBg1").attr("disabled", true);
			$("#freeDisable").attr("disabled", true);
			$("#footerBg2").attr("disabled", true);
			$("#footerEdgeDistance1").attr("disabled", true);
			var bl;
			bl = Site.getFooterStyleData();
			bl.fa = 0;
			bl.gt.y = 0;
			bl.rt.y = 0;
			bl.fb.y = 0;
			bl.f.t = 0;
			bl.ht.c = null;
			Site.saveFooterStyleData(bl);
			Site.autoFooterBg()
		}
		$(".numeric").numeric();
		aQ();
		var bu = {
			title: "添加图片",
			maxSize: parseInt(aV),
			type: ["jpg", "jpeg", "gif", "png"],
			from: "bg",
			entry: "footerBg"
		};
		Site.fileUpload2("#footerBgFileButton", bu, aU);
		Site.faiFloatPanelModuleDraggable();
		Site.faiFloatPanelDraggable();
		Site.bindGobalEvent("siteLayoutChange", function(bT, bS) {
			Site.isLayoutHidden(1) ? bj.hide() : bj.show();
			Site.isLayoutHidden(3) ? bR.hide() : bR.show()
		});
		Site.bindGobalEvent("changeTemplateType", function(bT, bU) {
			Site.resetBackgroundStyleDefault(false);
			Fai.top.panelFunc.resetDefault(true);
			if(top._templateLayout == 0 || top._templateLayout == 1 || top._templateLayout == 7 || top._templateLayout == 9 || top._templateLayout == 10) {
				$("#panelItemContainer_banner").show();
				$("#bannerStyleLine").show();
				$("#menu_bannerStyleLine").show()
			} else {
				$("#panelItemContainer_banner").hide();
				$("#bannerStyleLine").hide();
				$("#menu_bannerStyleLine").hide()
			}
			var bV = !Fai.top._panelOptionData.allowedStyle && (top._templateType == Fai.top._panelOptionData.templateType_free);
			if(bV) {
				$("#useSysBackground").click();
				$("#useCusBackground").attr("disabled", true);
				$("#hideBackground").attr("disabled", true)
			} else {
				$("#useCusBackground").removeAttr("disabled");
				$("#hideBackground").removeAttr("disabled")
			}
			if(bV) {
				$("#headBg0").click();
				Fai.top.panelFunc.changeHeadBgType(0);
				Site.removeHeaderBg();
				$(".freeDisable").attr("disabled", true)
			} else {
				$(".freeDisable").removeAttr("disabled")
			}
			if(bV) {
				$("#useSysBannerBg").click();
				$("#topBannerDefault").click();
				$("#useSysBannerWidth").click();
				$("#bannerScaleDefault").click();
				$("#hideBannerBg").attr("disabled", true);
				$("#useCusBannerBg").attr("disabled", true);
				$("#useCusBannerWidth").attr("disabled", true);
				$("#bannerScaleDefault").attr("disabled", true)
			} else {
				$("#hideBannerBg").removeAttr("disabled");
				$("#useCusBannerBg").removeAttr("disabled");
				$("#useCusBannerWidth").removeAttr("disabled")
			}
			if(bV) {
				$("#useSysContentBg").click();
				$("#hideContentBg").attr("disabled", true);
				$("#useCusContentBg").attr("disabled", true);
				$("#useSysContentMiddleBg").click();
				$("#hideContentMiddleBg").attr("disabled", true);
				$("#useCusContentMiddleBg").attr("disabled", true);
				$("#useSysContentLeftWidth").click();
				$("#useCusContentLeftWidth").attr("disabled", true);
				$("#useSysContentRightWidth").click();
				$("#useCusContentRightWidth").attr("disabled", true)
			} else {
				$("#hideContentBg").removeAttr("disabled");
				$("#useCusContentBg").removeAttr("disabled");
				$("#hideContentMiddleBg").removeAttr("disabled");
				$("#useCusContentMiddleBg").removeAttr("disabled");
				$("#useCusContentLeftWidth").removeAttr("disabled");
				$("#useCusContentRightWidth").removeAttr("disabled")
			}
			Site.isLayoutHidden(1) ? bj.hide() : bj.show();
			Site.isLayoutHidden(3) ? bR.hide() : bR.show();
			if(bV) {
				$("#footerAlignLeft").attr("disabled", true);
				$("#footerAlignCenter").attr("disabled", true);
				$("#footerNavText1").attr("disabled", true);
				$("#footerAlignRight").attr("disabled", true);
				$("#footerBg1").attr("disabled", true);
				$("#freeDisable").attr("disabled", true);
				$("#footerBg2").attr("disabled", true);
				$("#footerEdgeDistance1").attr("disabled", true);
				var bS;
				bS = Site.getFooterStyleData();
				bS.fa = 0;
				bS.gt.y = 0;
				bS.rt.y = 0;
				bS.fb.y = 0;
				bS.f.t = 0;
				bS.ht.c = null;
				Site.saveFooterStyleData(bS);
				Site.autoFooterBg()
			} else {
				$("#footerAlignLeft").removeAttr("disabled");
				$("#footerAlignCenter").removeAttr("disabled");
				$("#footerNavText1").removeAttr("disabled");
				$("#footerAlignRight").removeAttr("disabled");
				$("#footerBg1").removeAttr("disabled");
				$("#freeDisable").removeAttr("disabled");
				$("#footerBg2").removeAttr("disabled");
				$("#footerEdgeDistance1").removeAttr("disabled")
			}
		});
		if(!(Fai.isIE6() || Fai.isIE7())) {
			at.find(".panelContentContainer").mCustomScrollbar({
				theme: "dark-3",
				scrollButtons: {
					enable: true
				},
				advanced: {
					updateOnContentResize: true
				},
				axis: "y",
				callbacks: {
					whileScrolling: function() {
						var bS = $(this).attr("id");
						if(bS == "sectionModuleContentContainer") {
							return
						}
						var bV = $("#" + bS + "TopLine").offset().top - 20;
						var bU = $("#" + bS).siblings(".panelMenuContainer").find("li");
						var bT = 0;
						$.each(Fai.top.$("#" + bS + " .splitLine"), function(bW, bX) {
							if($(bX).offset().top - bV < 50) {
								bT = bW
							} else {
								return false
							}
						});
						bU.removeClass("on").eq(bT).addClass("on")
					}
				}
			})
		}
		at.delegate(".sectionModuleIcon", "mouseleave", function() {
			$(this).children(".nowModuleButtonDiv").hide()
		});
		at.delegate(".sectionModuleIcon > .panelModuleIcon", "mouseover", function() {
			$(this).siblings(".nowModuleButtonDiv").show()
		});
		at.delegate(".sectionModuleIcon > .panelModuleTitleInput", "mouseover", function(bS) {
			bS.stopPropagation();
			$(this).siblings(".nowModuleButtonDiv").hide()
		});
		Site.bindGobalEvent("site_delModule", function(bS, bT) {
			Site.updateCurrentSectionModule();
			Site.sectionModuleSelectChange(false);
			Site.removeOverlay()
		});
		Site.bindGobalEvent("site_hideModule", function(bS, bT) {
			if(!Fai.top.panelModuleIconClick) {
				Site.updateCurrentSectionModule()
			}
			Site.sectionModuleSelectChange(false);
			Site.removeOverlay()
		});
		Site.bindGobalEvent("site_addNewModule", function(bS, bT) {
			Site.addHoverTitleAllowEdit(bT);
			Site.updateCurrentSectionModule();
			Site.sectionModuleSelectChange(false)
		});
		Site.bindGobalEvent("site_refreshModule", function(bS, bT) {
			Site.updateCurrentSectionModule();
			Site.sectionModuleSelectChange(false)
		});
		Site.bindGobalEvent("showFindModuleDiv", function(bS, bT) {
			var bV = Fai.top.$("#faiFloatPanel");
			if(bV.attr("status") == 1) {
				var bU = Fai.top.$("#module" + bT);
				if(bU.length < 1) {
					return
				}
				var bW = bV.offset().left;
				var b0 = bW + bV.outerWidth();
				var bY = bU.offset().left;
				var bX = bY + bU.outerWidth();
				var bZ = false;
				if(bY <= bW && bX >= bW) {
					bZ = true
				} else {
					if(bY <= b0 && bX >= b0) {
						bZ = true
					} else {
						if(bY >= bW && bX <= b0) {
							bZ = true
						} else {
							if(bY < bW && bX > b0) {
								bZ = true
							}
						}
					}
				}
				if(bZ) {
					if(!bV.is(":animated")) {
						bV.stop().animate({
							opacity: "0.1"
						}, 800)
					}
					setTimeout(function() {
						if(!bV.is(":animated")) {
							bV.stop().animate({
								opacity: "1"
							}, 900)
						}
					}, 1000)
				} else {
					bV.css({
						opacity: "1"
					})
				}
			}
		});
		jzUtils.run({
			name: "baseStyleTool.initData"
		});
		jzUtils.run({
			name: "floatPanelUISetting.init"
		});
		aj = false;
		Fai.top.faiFloatPanelReady = true
	}).click(function() {
		$(this).css({
			opacity: "1"
		})
	});

	function j(aY) {
		var aZ = "";
		if(aY.o) {
			aZ += aY.o
		}
		if(aY.p) {
			aZ += aa(aY.r, "web", "siteBg")
		}
		if(aZ == "") {
			aZ = "none"
		}
		return aZ
	}

	function p(aZ) {
		var aY;
		aY = Site.getWebBackgroundData();
		if(aY.s) {
			Site.hideSiteBg()
		}
		aY.o = aZ;
		aY.s = false;
		Site.saveWebBackgroundData(aY);
		if(!aY.h) {
			var a0 = "";
			a0 = j(aY);
			Site.setSiteBg(a0, aY.o)
		}
		B()
	}

	function ab(aZ) {
		if(aZ) {
			var a1 = $.parseJSON(aZ);
			var a0 = a1.data[0] || {};
			var a2 = "";
			$("#useCusBackground").attr("checked", true);
			var aY = Site.getWebBackgroundData();
			aY.p = a0.filePath;
			aY.id = a0.fileId;
			aY.s = false;
			aY.newSelect = true;
			if(a0.isMatBg) {
				aY.r = 3;
				$("#bgDisplay").val(3)
			}
			Site.saveWebBackgroundData(aY);
			$("#uploadmsgBg").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + a0.fileId + "\");return false;'>查看</a>");
			$("#cusPanel").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#cusPanel").find(".J_preview").html("<img class='f-previewImg' src='" + aY.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />");
			$("#bgDisplay").change()
		}
	}

	function aF(aY) {
		if(aY) {
			var a1 = $.parseJSON(aY);
			var aZ = a1.data[0] || {};
			var a0 = Site.getHeaderStyleData();
			a0.f = aZ.fileId;
			a0.p = aZ.filePath;
			a0.newSelect = true;
			if(aZ.isMatBg) {
				a0.r = 3;
				$("#headBgRepeat").val(3)
			}
			ap();
			aO();
			$("#uploadmsg").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + aZ.fileId + "\");return false;'>查看</a>");
			$("#headBgCus").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#headBgCus").find(".J_preview").html("<img class='f-previewImg' src='" + a0.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />")
		}
	}

	function ah() {
		var aY;
		Fai.top._Global._useTemplateBackground ? aY = Fai.top._headerTopStyle : aY = Fai.top._customHeaderTopStyle;
		$("#topStyleDefault").bind("click", function() {
			$("#settingHeightInputWrap").hide();
			if(!aj) {
				Fai.top.panelFunc.refreshHeaderTop()
			}
		});
		$("#topStyleCustom").bind("click", function() {
			$("#settingHeightInputWrap").show();
			if(!aj) {
				if($("#settingHeightInput").val() !== "") {
					Fai.top.panelFunc.refreshHeaderTop()
				}
			}
		});
		if(aY.hts == -1) {
			$("#topStyleDefault").click()
		} else {
			$("#topStyleCustom").click();
			$("#settingHeightInput").val(aY.hts)
		}
		Site.addInputEventUnit("#settingHeightInput")
	}

	function ap() {
		var a0;
		a0 = Site.getHeaderStyleData();
		a0.c = ac;
		var aZ = a0.r;
		var aY = "";
		aY += ac;
		var a2 = a0.p;
		if(a2) {
			if(aZ != -1) {
				var a1 = "";
				if(aZ == 0 || aZ == 6 || aZ == 7 || aZ == 8 || aZ == 9 || aZ == 13 || aZ == 14 || aZ == 15 || aZ == 16) {
					a1 = "no-repeat"
				}
				if(aZ == 1 || aZ == 11 || aZ == 12) {
					a1 = "repeat-x"
				}
				if(aZ == 2 || aZ == 21 || aZ == 22) {
					a1 = "repeat-y"
				}
				if(aZ == 3) {
					a1 = "repeat"
				}
				if(aZ == 4 || aZ == 5) {
					a1 = "repeat"
				}
				var a3 = "center";
				if(aZ == 9 || aZ == 12) {
					a3 = "bottom"
				}
				if(aZ == 6 || aZ == 21) {
					a3 = "left"
				}
				if(aZ == 7 || aZ == 22) {
					a3 = "right"
				}
				if(aZ == 4 || aZ == 5 || aZ == 8 || aZ == 11) {
					a3 = "top"
				}
				if(aZ == 13) {
					a3 = "left top"
				}
				if(aZ == 14) {
					a3 = "right top"
				}
				if(aZ == 15) {
					a3 = "left bottom"
				}
				if(aZ == 16) {
					a3 = "right bottom"
				}
				aY += " url(" + a2 + ") " + a1 + " " + a3
			}
		}
		Site.setHeaderBg(aY)
	}

	function aO() {
		if(aj) {
			return
		}
		top._headerTopStyleChanged++;
		Site.styleChanged();
		Site.showSectionOfSitePage("head");
		Site.setRefreshInfo("siteStyleSetting", true)
	}

	function aA() {
		var aY;
		aY = Site.getHeaderStyleData();
		if(aY.y == 1) {
			$("#headBg1").click()
		} else {
			if(aY.y == 2) {
				$("#headBg2").click()
			} else {
				$("#headBg0").click()
			}
		}
		if(Fai.isNull(aY.r)) {
			aY.r = 0
		}
		$("#headBgRepeat").val(aY.r);
		if(Fai.isNull(aY.c)) {
			aY.c = "#000"
		}
		ac = aY.c;
		$("#headBgColorPicker").faiColorPicker({
			onchange: ax,
			defaultcolor: ac
		})
	}

	function ax(aY) {
		ac = aY;
		ap();
		aO()
	}

	function e() {
		if(!Fai.top._isTemplateVersion2) {
			return
		}
		var a0;
		Fai.top._Global._useTemplateBackground ? a0 = Fai.top._headerTopStyle : a0 = Fai.top._customHeaderTopStyle;
		var a3 = a0.bb || (a0.bb = {
				y: 0
			}),
			a4 = Fai.top.$("#panelItemContainer_top"),
			aY = a4.find(".J_TopBorderAdditionContent"),
			a2 = aY.find(".J_color"),
			a1 = a3.c || "";
		if(a3.y == 2) {
			$("#J_TopBorderAddition_cus").attr("checked", "checked");
			aY.find(".J_borderSet").show();
			if(typeof a3.s != "undefined") {
				aY.find(".J_style").val(a3.s)
			}
			if(typeof a3.w != "undefined") {
				aY.find(".J_width").val(a3.w)
			}
		} else {
			if(a3.y == 1) {
				$("#J_TopBorderAddition_hide").attr("checked", "checked");
				aY.find(".J_borderSet").hide()
			} else {
				if(a3.y == 0) {
					$("#J_TopBorderAddition_sys").attr("checked", "checked");
					aY.find(".J_borderSet").hide()
				}
			}
		}
		if(typeof a3.c != "undefined") {
			$("#J_TopBorderAddition_cusColor").attr("checked", "checked");
			a2.show()
		} else {
			$("#J_TopBorderAddition_sysColor").attr("checked", "false");
			a2.hide()
		}
		a2.faiColorPicker({
			onchange: aZ,
			defaultcolor: a1
		});

		function aZ(a5) {
			a3.c = a5;
			Site.refreshTopBorder();
			aO()
		}
		Site.addInputEventUnit("#J_topBorderWidth")
	}

	function m() {
		var aY;
		aY = Site.getBannerBackgroundData();
		if(aY != null) {
			if(aY.y == 1) {
				$("#hideBannerBg").click()
			} else {
				if(aY.y == 2) {
					$("#useCusBannerBg").click()
				} else {
					$("#useSysBannerBg").click()
				}
			}
		}
		if(Fai.isNull(aY.r)) {
			aY.r = 0
		}
		$("#bannerBgDisplay").val(aY.r);
		if(Fai.isNull(aY.c)) {
			aY.c = "#000"
		}
		$("#bannerColorPicker").faiColorPicker({
			onchange: aJ,
			defaultcolor: aY.c
		})
	}

	function aJ(aY) {
		var a0;
		a0 = Site.getBannerBackgroundData();
		var aZ = "";
		if(a0.y == 0) {
			Site.hideBannerBg()
		}
		a0.c = aY;
		Site.saveBannerBackgroundData(a0);
		aZ = o(a0);
		Site.setBannerBg(aZ);
		B("banner")
	}

	function o(aZ) {
		var aY = "";
		if(aZ.c) {
			aY += aZ.c
		}
		if(aZ.p) {
			aY += aa(aZ.r, "webBannerTable")
		}
		if(aY == "") {
			aY = "none"
		}
		return aY
	}

	function aX() {
		var aY = Site.getWebBackgroundData();
		$("#topBannerDefault").bind("click", function() {
			$("#settingBannerHeightInputWrap").hide();
			if(!aj) {
				Fai.top.panelFunc.refreshBannerBgHeight()
			}
		});
		$("#topBannerCustom").bind("click", function() {
			var aZ = aY.wbh == -1 ? parseInt(top.$("#webBanner").height()) : aY.wbh;
			$("#settingBannerHeightInputWrap").show();
			$("#settingBannerHeightInput").val(aZ);
			if(!aj) {
				if($("#settingBannerHeightInput").val() !== "") {
					Fai.top.panelFunc.refreshBannerBgHeight()
				}
			}
		});
		if(aY.wbh == -1) {
			$("#topBannerDefault").click()
		} else {
			$("#topBannerCustom").click();
			$("#settingBannerHeightInput").val(aY.wbh)
		}
		Site.addInputEventUnit("#settingBannerHeightInput")
	}

	function aR(aY) {
		if(aY) {
			var a2 = $.parseJSON(aY);
			var a0 = a2.data[0] || {};
			var a1 = Site.getBannerBackgroundData();
			var aZ = "";
			a1.f = a0.fileId;
			a1.p = a0.filePath;
			a1.id = a0.fileId;
			a1.y = 2;
			a1.newSelect = true;
			if(a0.isMatBg) {
				a1.r = 3;
				$("#bannerBgDisplay").val(3)
			}
			Site.saveBannerBackgroundData(a1);
			aZ = o(a1);
			Site.setBannerBg(aZ);
			$("#uploadmsgBannerBg").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + a0.fileId + "\");return false;'>查看</a>");
			$("#cusBannerPanel").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#cusBannerPanel").find(".J_preview").html("<img class='f-previewImg' src='" + a1.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />");
			B("banner")
		}
	}

	function o(aZ) {
		var aY = "";
		if(aZ.c) {
			aY += aZ.c
		}
		if(aZ.p) {
			aY += aa(aZ.r, "webBannerTable")
		}
		if(aY == "") {
			aY = "none"
		}
		return aY
	}

	function K() {
		if(aj) {
			return
		}
		Fai.top._bannerChanged++;
		Site.styleChanged();
		Site.showSectionOfSitePage("banner");
		Site.setRefreshInfo("siteStyleSetting", true)
	}

	function r() {
		var aY;
		aY = Site.getContentBackgroundData();
		if(aY != null) {
			if(aY.y == 1) {
				$("#hideContentBg").click()
			} else {
				if(aY.y == 2) {
					$("#useCusContentBg").click()
				} else {
					$("#useSysContentBg").click()
				}
			}
		}
		if(Fai.isNull(aY.r)) {
			aY.r = 0
		}
		$("#contentBgDisplay").val(aY.r);
		if(Fai.isNull(aY.c)) {
			aY.c = "#000"
		}
		$("#contentColorPicker").faiColorPicker({
			onchange: aI,
			defaultcolor: aY.c
		});
		$("#contentColorPicker").on("click.bg", function() {
			B("content")
		})
	}

	function aI(aY) {
		var aZ;
		aZ = Site.getContentBackgroundData();
		var a0 = "";
		if(aZ.y == 0) {
			Site.hideContentBg()
		}
		aZ.c = aY;
		Site.saveContentBackgroundData(aZ);
		a0 = J(aZ);
		Site.setContentBg(a0, "none")
	}

	function J(aY) {
		var aZ = "";
		if(aY.c) {
			aZ += aY.c
		}
		if(aY.p) {
			aZ += aa(aY.r, "webContainerTable")
		}
		if(aZ == "") {
			aZ = "none"
		}
		return aZ
	}

	function aP(aY) {
		if(aY) {
			var a2 = $.parseJSON(aY);
			var aZ = a2.data[0] || {};
			var a1 = "";
			var a0 = Site.getContentBackgroundData();
			a0.f = aZ.fileId;
			a0.p = aZ.filePath;
			a0.id = aZ.fileId;
			a0.y = 2;
			a0.newSelect = true;
			if(aZ.isMatBg) {
				a0.r = 3;
				$("#contentBgDisplay").val(3)
			}
			Site.saveContentBackgroundData(a0);
			a1 = J(a0);
			Site.setContentBg(a1, "none");
			$("#uploadmsgContentBg").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + aZ.fileId + "\");return false;'>查看</a>");
			$("#cusContentPanel").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#cusContentPanel").find(".J_preview").html("<img class='f-previewImg' src='" + a0.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />");
			B("content")
		}
	}

	function ae() {
		var aY;
		aY = Site.getContentMiddleBackgroundData();
		if(aY != null) {
			if(aY.y == 1) {
				$("#hideContentMiddleBg").click()
			} else {
				if(aY.y == 2) {
					$("#useCusContentMiddleBg").click()
				} else {
					$("#useSysContentMiddleBg").click()
				}
			}
		}
		if(Fai.isNull(aY.r)) {
			aY.r = 0
		}
		$("#contentMiddleBgDisplay").val(aY.r);
		if(Fai.isNull(aY.c)) {
			aY.c = "#000"
		}
		$("#contentMiddleColorPicker").faiColorPicker({
			onchange: G,
			defaultcolor: aY.c
		});
		$("#contentMiddleColorPicker").on("click.bg", function() {
			B("content")
		})
	}

	function G(aY) {
		var a0;
		a0 = Site.getContentMiddleBackgroundData();
		var aZ = "";
		if(a0.y == 0) {
			Site.hideContentMiddleBg()
		}
		a0.c = aY;
		Site.saveContentMiddleBackgroundData(a0);
		aZ = U(a0);
		Site.setContentMiddleBg(aZ)
	}

	function U(aZ) {
		var aY = "";
		if(aZ.c) {
			aY += aZ.c
		}
		if(aZ.p) {
			aY += aa(aZ.r, "container")
		}
		if(aY == "") {
			aY = "none"
		}
		return aY
	}

	function w(aY) {
		if(aY) {
			var a2 = $.parseJSON(aY);
			var aZ = a2.data[0] || {};
			var a0 = "";
			var a1 = Site.getContentMiddleBackgroundData();
			a1.f = aZ.fileId;
			a1.p = aZ.filePath;
			a1.id = aZ.fileId;
			a1.y = 2;
			a1.newSelect = true;
			if(aZ.isMatBg) {
				a1.r = 3;
				$("#contentMiddleBgDisplay").val(3)
			}
			Site.saveContentMiddleBackgroundData(a1);
			a0 = U(a1);
			Site.setContentMiddleBg(a0);
			$("#uploadmsgContentMiddleBg").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + aZ.fileId + "\");return false;'>查看</a>");
			$("#cusContentMiddlePanel").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#cusContentMiddlePanel").find(".J_preview").html("<img class='f-previewImg' src='" + a1.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />");
			B("content")
		}
	}

	function aE() {
		if(!Fai.top._isTemplateVersion2) {
			return
		}
		var aY, aZ, a1 = $(".J_contentPaddingSet"),
			a2 = a1.find(".J_top"),
			a0 = a1.find(".J_bottom");
		aY = Site.getWebBackgroundData(), aZ = aY.cp || (aY.cp = {
			y: 0
		}), topVal = aZ.t || (aZ.t = 0), bottomVal = aZ.b || (aZ.b = 0);
		if(aZ.y == 1) {
			$("#useCusContentPadding").attr("checked", true);
			$(".J_contentPaddingSet").show();
			a2.val(topVal);
			a0.val(bottomVal)
		} else {
			$("#useSysContentPadding").attr("checked", true);
			$(".J_contentPaddingSet").hide()
		}
		Site.addInputEventUnit(".J_contentPaddingSet .J_top");
		Site.addInputEventUnit(".J_contentPaddingSet .J_bottom")
	}

	function az() {
		if(aj) {
			return
		}
		top._footerStyleChanged++;
		Site.styleChanged();
		Site.showSectionOfSitePage("foot");
		Site.setRefreshInfo("siteStyleSetting", true)
	}

	function I() {
		if(aj) {
			return
		}
		top._footerStyleChanged++;
		Site.styleChanged();
		Site.setRefreshInfo("siteStyleSetting", true)
	}

	function aQ() {
		av();
		an();
		E();
		aS();
		ag();
		H();
		O();
		n();
		Q()
	}

	function av() {
		$("#footerHeightDefault").bind("click", function() {
			$("#footerHeightInputWrap").hide();
			if(!aj) {
				b()
			}
		});
		$("#footerHeightCustom").bind("click", function() {
			var aY = Site.getFooterStyleData().fh == -1 ? parseInt(top.$("#webFooterTable").height()) : Site.getFooterStyleData().fh;
			$("#footerHeightInputWrap").show();
			$("#footerHeightInput").val(aY);
			if(!aj) {
				if($("#footerHeightInput").val() != "") {
					b()
				}
			}
		});
		if(Fai.top._footerStyleData.fh == -1) {
			$("#footerHeightDefault").click()
		} else {
			$("#footerHeightCustom").click();
			$("#footerHeightInput").val(Site.getFooterStyleData().fh)
		}
	}

	function an() {
		var aY;
		aY = Site.getFooterStyleData();
		if(aY.fa == 1) {
			$("#footerAlignLeft").click();
			if(typeof aY.fp != "undefined") {
				$("#leftFooterPadding").val(aY.fp)
			}
		} else {
			if(aY.fa == 2) {
				$("#footerAlignCenter").click()
			} else {
				if(aY.fa == 3) {
					$("#footerAlignRight").click();
					if(typeof aY.fp != "undefined") {
						$("#rightFooterPadding").val(aY.fp)
					}
				} else {
					$("#footerAlignDefault").click()
				}
			}
		}
		Site.addInputEventUnit("#leftFooterPadding");
		Site.addInputEventUnit("#rightFooterPadding")
	}

	function Y(aY) {
		var aZ = $("#firstItemTextSize");
		aZ.val(aY);
		Site.setFooterFristItemFontSize(aZ)
	}

	function S(aZ) {
		var aY = $("#secondItemTextSize");
		aY.val(aZ);
		Site.setFooterSecondItemFontSize(aY)
	}

	function E() {
		var aY;
		aY = Site.getFooterStyleData();
		if(aY.gt.y == 1) {
			$("#footerNavText1").click()
		} else {
			$("#footerNavText0").click()
		}
		if(Fai.isNull(aY.gt.s) || aY.gt.s < 0) {
			aY.gt.s = 12
		}
		Site.addFontsizeCombobox($("#footerNavTextSizeBox"), "footerNavTextSize", aY.gt.s, Fai.top.panelFunc.footerNavTextSizeChange);
		if(Fai.isNull(aY.gt.f) || !aY.gt.f) {
			aY.gt.f = "微软雅黑"
		}
		$("#footerNavTextFamily").val(aY.gt.f);
		var aZ = $("#footerNavTextFamily");
		if(aZ.val() == null && aZ.children("option").length > 0) {
			aZ[0].selectedIndex = 0
		}
		if(Fai.isNull(aY.gt.w)) {
			aY.gt.w = 0
		}
		if(aY.gt.w == 1) {
			$("#footerNavTextBold").attr("checked", true)
		}
		if(Fai.isNull(aY.gt.d)) {
			aY.gt.d = 0
		}
		if(aY.gt.d == 1) {
			$("#footerDecorationCheck").attr("checked", true)
		}
		if(Fai.isNull(aY.gt.c)) {
			aY.gt.c = "#000"
		}
		al = aY.gt.c;
		Site.saveFooterStyleData(aY);
		$("#footerNavTextColorPicker").faiColorPicker({
			onchange: N,
			defaultcolor: al
		});
		$("#footerNavTextColorPicker").on("click.fc", function() {
			Site.showSectionOfSitePage("foot")
		})
	}

	function aS() {
		var aY;
		aY = Site.getFooterStyleData();
		if(Fai.isNull(aY.ht.c)) {
			aY.ht.c = "#000"
		}
		aK = aY.ht.c;
		Site.saveFooterStyleData(aY);
		$("#footerNavHoverTextColorPicker").faiColorPicker({
			onchange: ad,
			defaultcolor: aK
		});
		$("#footerNavHoverTextColorPicker").on("click.fc", function() {
			Site.showSectionOfSitePage("foot")
		})
	}

	function ag() {
		var aY;
		aY = Site.getFooterStyleData();
		if(aY.fb.y == 1) {
			$("#footerBg1").click()
		} else {
			if(aY.fb.y == 2) {
				$("#footerBg2").click()
			} else {
				$("#footerBg0").click()
			}
		}
		if(Fai.isNull(aY.fb.r)) {
			aY.fb.r = 0
		}
		$("#footerBgRepeat").val(aY.fb.r);
		if(Fai.isNull(aY.fb.c)) {
			aY.fb.c = "#000"
		}
		ay = aY.fb.c;
		$("#footerBgColorPicker").faiColorPicker({
			onchange: aG,
			defaultcolor: ay
		});
		$("#footerBgColorPicker").on("click.fc", function() {
			Site.showSectionOfSitePage("foot")
		});
		if(aY.fb.f) {
			$("#uploadmsgFooter").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + aY.fb.f + "\");return false;'>查看</a>");
			$("#footerBgCus").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#footerBgCus").find(".J_preview").html("<img class='f-previewImg' src='" + aY.fb.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />")
		}
		Site.saveFooterStyleData(aY)
	}

	function H() {
		var aY;
		aY = Site.getFooterStyleData();
		if(aY.f.t == 0) {
			$("#footerEdgeDistance0").click()
		} else {
			$("#footerEdgeDistance1").click()
		}
		var a1 = aY.f.l;
		var aZ = aY.f.r;
		var a0 = aY.f.u;
		var a2 = aY.f.d;
		if(a2 < 0) {
			a2 = -a2
		}
		if(isNaN(a1)) {
			a1 = 0
		}
		if(isNaN(aZ)) {
			aZ = 0
		}
		if(isNaN(a0)) {
			a0 = 0
		}
		if(isNaN(a2)) {
			a2 = 0
		}
		$("#leftFooterPadding").val(a1);
		$("#rightFooterPadding").val(aZ);
		$("#upFooterPadding").val(a0);
		$("#downFooterPadddng").val(a2);
		Site.addInputEventUnit("#leftFooterPadding");
		Site.addInputEventUnit("#rightFooterPadding");
		Site.addInputEventUnit("#upFooterPadding");
		Site.addInputEventUnit("#downFooterPadddng")
	}

	function O() {
		var aY;
		aY = Site.getFooterStyleData();
		if(aY.rt.y == 1) {
			$("#regularText2").click()
		} else {
			$("#regularText1").click()
		}
		if(Fai.isNull(aY.rt.s) || aY.rt.s < 0) {
			aY.rt.s = 12
		}
		Site.addFontsizeCombobox($("#regularTextSizeBox"), "regularTextSize", aY.rt.s, Fai.top.panelFunc.regularTextSizeChange);
		if(Fai.isNull(aY.rt.f) || !aY.rt.f) {
			aY.rt.f = "微软雅黑"
		}
		$("#regularTextFamily").val(aY.rt.f);
		var aZ = $("#regularTextFamily");
		if(aZ.val() == null && aZ.children("option").length > 0) {
			aZ[0].selectedIndex = 0
		}
		if(Fai.isNull(aY.rt.c)) {
			aY.rt.c = "#000"
		}
		q = aY.rt.c;
		Site.saveFooterStyleData(aY);
		$("#regularTextColorPicker").faiColorPicker({
			onchange: k,
			defaultcolor: q
		});
		$("#regularTextColorPicker").on("click.fc", function() {
			Site.showSectionOfSitePage("foot")
		})
	}

	function n() {
		if(!Fai.top._isTemplateVersion2) {
			return
		}
		var a2 = Site.getFooterStyleData().b,
			a0 = Fai.top.$("#panelItemContainer_foot"),
			a1 = a0.find(".J_FooterBorderAdditionContent"),
			aZ = a1.find(".J_color"),
			a3 = a2.c || "";
		if(a2.y == 2) {
			$("#J_FooterBorderAddition_cus").attr("checked", "checked");
			a1.find(".J_borderSet").show();
			if(typeof a2.s != "undefined") {
				a1.find(".J_style").val(a2.s)
			}
			if(typeof a2.w != "undefined") {
				a1.find(".J_width").val(a2.w)
			}
			if(a2.b == 1) {
				a1.find(".J_bottom").attr("checked", "checked")
			}
			if(a2.t == 1) {
				a1.find(".J_top").attr("checked", "checked")
			}
			if(Fai.top._uiMode) {
				if(a2.l == 1) {
					a1.find(".J_left").attr("checked", "checked")
				}
				if(a2.r == 1) {
					a1.find(".J_right").attr("checked", "checked")
				}
			}
		} else {
			if(a2.y == 1) {
				$("#J_FooterBorderAddition_hide").attr("checked", "checked");
				a1.find(".J_borderSet").hide()
			} else {
				if(a2.y == 0) {
					$("#J_FooterBorderAddition_sys").attr("checked", "checked");
					a1.find(".J_borderSet").hide()
				}
			}
		}
		if(typeof a2.c != "undefined") {
			$("#J_FooterBorderAddition_cusColor").attr("checked", "checked");
			aZ.show()
		} else {
			$("#J_FooterBorderAddition_sysColor").attr("checked", "false");
			aZ.hide()
		}
		aZ.faiColorPicker({
			onchange: aY,
			defaultcolor: a3
		});

		function aY(a4) {
			a2.c = a4;
			Site.refreshFooterBorder();
			az()
		}
		Site.addInputEventUnit("#J_footerBorderWidth")
	}

	function Q() {
		var ba = Site.getFooterStyleData();
		var a1 = $("#patternChoiceBox").find(".patternChoice");
		if(ba.fis <= 0) {
			$("#patternChoice-normal").addClass("patternChoice-selected")
		} else {
			if(ba.fis == 1) {
				$("#patternChoice-level").addClass("patternChoice-selected")
			} else {
				if(ba.fis == 2) {
					$("#patternChoice-vertical").addClass("patternChoice-selected")
				}
			}
		}
		a1.click(function() {
			a1.removeClass("patternChoice-selected");
			$(this).addClass("patternChoice-selected")
		});
		if(ba.fip <= 0) {
			ba.fip = 0;
			$("#normalItemPic").attr("checked", "checked")
		} else {
			if(ba.fip == 1) {
				$("#useItemPic").attr("checked", "checked")
			} else {
				if(ba.fip == 2) {
					$("#noItemPic").attr("checked", "checked")
				}
			}
		}
		if(ba.fiw < 0) {
			$("#sysItemWidth").attr("checked", "checked");
			$("#setFooterWidth").hide();
			$("#cusItemWidthNum").val(60)
		} else {
			$("#cusItemWidth").attr("checked", "checked");
			$("#setFooterWidth").show();
			$("#cusItemWidthNum").val(ba.fiw)
		}
		Site.addInputEventUnit("#cusItemWidthNum");
		if(ba.fih < 0) {
			$("#sysItemHeight").attr("checked", "checked");
			$("#setFooterHeight").hide();
			$("#cusItemHeightNum").val(32)
		} else {
			$("#cusItemHeight").attr("checked", "checked");
			$("#setFooterHeight").show();
			$("#cusItemHeightNum").val(ba.fih)
		}
		Site.addInputEventUnit("#cusItemHeightNum");
		if(ba.fift.y == 0) {
			$("#sysFirstItemword").attr("checked", "checked");
			$("#cusFirstItemText").hide()
		} else {
			if(ba.fift.y == 1) {
				$("#cusFirstItemword").attr("checked", "checked");
				$("#cusFirstItemText").show()
			}
		}
		if(ba.fift.w == 1) {
			$("#firstItemTextBold").attr("checked", "checked")
		}
		if(ba.fift.d == 1) {
			$("#firstItemTextUnderline").attr("checked", "checked")
		}
		if(ba.fisp < 0) {
			$("#normalItemSpacing").attr("checked", "checked");
			$("#setItemSpaceWidth").hide();
			$("#cusItemSpacingWidth").val(10)
		} else {
			$("#cusItemSpacing").attr("checked", "checked");
			$("#setItemSpaceWidth").show();
			$("#cusItemSpacingWidth").val(ba.fisp).show()
		}
		Site.addInputEventUnit("#cusItemSpacingWidth");
		if(ba.fiv.y == 0) {
			$("#sysItemVerticalLine").attr("checked", "checked");
			$("#cusItemVerticalLineSetting").hide()
		} else {
			$("#cusItemVerticalLine").attr("checked", "checked");
			$("#cusItemVerticalLineSetting").show()
		}
		if(ba.fiv.w > -1) {
			$("#cusItemVerticalLineWidth").val(ba.fiv.w)
		}
		Site.addInputEventUnit("#cusItemVerticalLineWidth");
		$("#firstItemTextColorPicker").faiColorPicker({
			onchange: l,
			defaultcolor: ba.fift.c
		});
		$("#firstItemTextColorPicker").on("click.fc", function() {
			Site.showSectionOfSitePage("foot")
		});
		$("#firstItemSelectedTextColorPicker").faiColorPicker({
			onchange: x,
			defaultcolor: ba.fift.hc
		});
		$("#firstItemSelectedTextColorPicker").on("click.fc", function() {
			Site.showSectionOfSitePage("foot")
		});
		$("#cusItemVerticalLineColorPicker").faiColorPicker({
			onchange: f,
			defaultcolor: ba.fiv.c
		});
		$("#cusItemVerticalLineColorPicker").on("click.fc", function() {
			Site.showSectionOfSitePage("foot")
		});
		$("#secondItemTextColorPicker").faiColorPicker({
			onchange: a,
			defaultcolor: ba.fist.c
		});
		$("#secondItemTextColorPicker").on("click.fc", function() {
			Site.showSectionOfSitePage("foot")
		});
		$("#secondItemSelectedTextColorPicker").faiColorPicker({
			onchange: s,
			defaultcolor: ba.fist.hc
		});
		$("#secondItemSelectedTextColorPicker").on("click.fc", function() {
			Site.showSectionOfSitePage("foot")
		});
		if(Fai.top._footerItemHasSecondChild) {
			$(".J_footerSecondType").show();
			$(".J_footerSecondText").show()
		} else {
			$(".J_footerSecondType").hide();
			$(".J_footerSecondText").hide();
			$(".J_cusItemVerticalLine").css("margin-bottom", "70px")
		}
		if(!ba.fifc) {
			$("#firstItemHref").attr("checked", "checked")
		} else {
			$("#firstItemNoHref").attr("checked", "checked")
		}
		$("#firstItemHref").click(function() {
			Site.changeFooterDataFixToZero();
			Site.refreshFooterFirstItemClickStatus(false);
			Site.showSectionOfSitePage("foot")
		});
		$("#firstItemNoHref").click(function() {
			Site.changeFooterDataFixToZero();
			Site.refreshFooterFirstItemClickStatus(true);
			Site.showSectionOfSitePage("foot")
		});
		if(ba.fiss == 0) {
			$("#autoDirection").attr("checked", "checked")
		} else {
			if(ba.fiss == 1) {
				$("#levelDirection").attr("checked", "checked")
			} else {
				if(ba.fiss == 2) {
					$("#verticalDirection").attr("checked", "checked")
				}
			}
		}
		if(ba.fish < 0) {
			$("#sysSecondItemHeight").attr("checked", "checked");
			$("#cusSecondItemHeightNum").hide()
		} else {
			$("#cusSecondItemHeight").attr("checked", "checked");
			$("#cusSecondItemHeightNum").val(ba.fish).show()
		}
		if(ba.fist.y == 0) {
			$("#sysSecondItemword").attr("checked", "checked");
			$("#setFooterSecondText").hide()
		} else {
			if(ba.fist.y == 1) {
				$("#cusSecondItemword").attr("checked", "checked");
				$("#setFooterSecondText").show()
			}
		}
		if(ba.fist.w == 1) {
			$("#secondItemTextBold").attr("checked", "checked")
		}
		if(ba.fist.d == 1) {
			$("#secondItemTextUnderline").attr("checked", "checked")
		}
		setTimeout(function() {
			if(Fai.isNull(ba.fift.s) || ba.fift.s < 0) {
				ba.fift.s = 12
			}
			if(Fai.isNull(ba.fist.s) || ba.fist.s < 0) {
				ba.fist.s = 12
			}
			Site.addFontsizeCombobox($("#firstItemTextSizeBox"), "firstItemTextSize", ba.fift.s, Y);
			if(!ba.fift.f) {
				ba.fift.f = "微软雅黑"
			}
			$("#firstItemTextfamily").val(ba.fift.f);
			Site.addFontsizeCombobox($("#secondItemTextSizeBox"), "secondItemTextSize", ba.fist.s, S);
			if(!ba.fist.f) {
				ba.fift.f = "微软雅黑"
			}
			$("#secondItemTextfamily").val(ba.fist.f)
		}, 0);
		if(Fai.top._footerItemHasSecondChild) {
			$("#footerSecondItemContainer").show()
		} else {
			$("#footerSecondItemContainer").hide()
		}
		var a2 = Fai.top.$(".footerFirstItemword");
		a2.off("click.footer").on("click.footer", function() {
			ba.fift.y = parseInt($(this).index(a2));
			Site.saveFooterStyleData(ba);
			top._footerStyleChanged++;
			Site.styleChanged()
		});
		var bc = Fai.top.$("#sysFirstItemword"),
			a8 = Fai.top.$("#cusFirstItemword");
		bc.off("click.footer").on("click.footer", function() {
			i(0);
			au(false, "cusFirstItemText")
		});
		a8.off("click.footer").on("click.footer", function() {
			i(1);
			au(true, "cusFirstItemText")
		});
		var a7 = Fai.top.$("#sysItemVerticalLine"),
			a0 = Fai.top.$("#cusItemVerticalLine");
		a7.off("click.footer").on("click.footer", function() {
			ak(0);
			au(false, "cusItemVerticalLineSetting")
		});
		a0.off("click.footer").on("click.footer", function() {
			ak(1);
			au(true, "cusItemVerticalLineSetting")
		});
		var a6 = Fai.top.$("#sysItemWidth"),
			aZ = Fai.top.$("#cusItemWidth");
		a6.off("click.footer").on("click.footer", function() {
			au(false, "setFooterWidth")
		});
		aZ.off("click.footer").on("click.footer", function() {
			au(true, "setFooterWidth")
		});
		var a4 = Fai.top.$("#sysItemHeight"),
			a5 = Fai.top.$("#cusItemHeight");
		a4.off("click.footer").on("click.footer", function() {
			au(false, "setFooterHeight")
		});
		a5.off("click.footer").on("click.footer", function() {
			au(true, "setFooterHeight")
		});
		var a9 = Fai.top.$("#normalItemSpacing"),
			bb = Fai.top.$("#cusItemSpacing");
		a9.off("click.footer").on("click.footer", function() {
			au(false, "setItemSpaceWidth")
		});
		bb.off("click.footer").on("click.footer", function() {
			au(true, "setItemSpaceWidth")
		});
		var a3 = Fai.top.$("#sysSecondItemword"),
			aY = Fai.top.$("#cusSecondItemword");
		a3.off("click.footer").on("click.footer", function() {
			au(false, "setFooterSecondText");
			aD(0);
			au(false, "cusSecondItemText")
		});
		aY.off("click.footer").on("click.footer", function() {
			au(true, "setFooterSecondText");
			aD(1);
			au(true, "cusSecondItemText")
		})
	}

	function au(aY, aZ) {
		aY ? $("#" + aZ).show() : $("#" + aZ).hide()
	}

	function i(aZ) {
		var aY = Site.getFooterStyleData();
		aY.fift.y = parseInt(aZ);
		Site.saveFooterStyleData(aY);
		top._footerStyleChanged++;
		Site.showSectionOfSitePage("foot");
		Site.styleChanged()
	}

	function aD(aZ) {
		var aY = Site.getFooterStyleData();
		aY.fist.y = parseInt(aZ);
		Site.saveFooterStyleData(aY);
		top._footerStyleChanged++;
		Site.showSectionOfSitePage("foot");
		Site.styleChanged()
	}

	function ak(aZ) {
		var aY = Site.getFooterStyleData();
		aY.fiv.y = parseInt(aZ);
		Site.saveFooterStyleData(aY);
		top._footerStyleChanged++;
		Site.showSectionOfSitePage("foot");
		Site.styleChanged()
	}

	function f(aY) {
		Site.setFooterVerticalLineColor(aY)
	}

	function l(aY) {
		Site.setFooterFristItemFontColor(aY)
	}

	function x(aY) {
		Site.setFooterFristItemFontHoverColor(aY)
	}

	function a(aY) {
		Site.setFooterSecondItemFontColor(aY)
	}

	function s(aY) {
		Site.setFooterSecondItemFontHoverColor(aY)
	}

	function N(aY) {
		al = aY;
		v();
		I()
	}

	function ad(aY) {
		aK = aY;
		am();
		I()
	}

	function aG(aY) {
		ay = aY;
		M();
		I()
	}

	function k(aY) {
		q = aY;
		W();
		I()
	}

	function v() {
		var aY;
		aY = Site.getFooterStyleData();
		if($("#footerNavTextBold").attr("checked")) {
			aY.gt.w = 1
		} else {
			aY.gt.w = 0
		}
		aY.gt.f = $("#footerNavTextFamily").val();
		aY.gt.c = al;
		am();
		var aZ = "none";
		if($("#footerDecorationCheck").attr("checked")) {
			aY.gt.d = 1;
			aZ = "underline"
		} else {
			aY.gt.d = 0
		}
		Site.saveFooterStyleData(aY);
		Site.setFooterNavGeneralText(aY)
	}

	function am() {
		var aY = Site.getFooterStyleData();
		aY.ht.c = aK;
		Site.saveFooterStyleData(aY);
		Site.setFooterNavHoverText(aY)
	}

	function M() {
		var aY;
		aY = Site.getFooterStyleData();
		aY.fb.c = ay;
		var a0 = parseInt($("#footerBgRepeat").val());
		aY.fb.r = a0;
		var aZ = "";
		aZ += ay;
		var a2 = aY.fb.p;
		if(a2) {
			if(a0 != -1) {
				var a1 = "";
				if(a0 == 0 || a0 == 6 || a0 == 7 || a0 == 8 || a0 == 9 || a0 == 13 || a0 == 14 || a0 == 15 || a0 == 16) {
					a1 = "no-repeat"
				}
				if(a0 == 1 || a0 == 11 || a0 == 12) {
					a1 = "repeat-x"
				}
				if(a0 == 2 || a0 == 21 || a0 == 22) {
					a1 = "repeat-y"
				}
				if(a0 == 3) {
					a1 = "repeat"
				}
				if(a0 == 4 || a0 == 5) {
					a1 = "repeat"
				}
				var a3 = "center";
				if(a0 == 9 || a0 == 12) {
					a3 = "bottom"
				}
				if(a0 == 6 || a0 == 21) {
					a3 = "left"
				}
				if(a0 == 7 || a0 == 22) {
					a3 = "right"
				}
				if(a0 == 4 || a0 == 5 || a0 == 8 || a0 == 11) {
					a3 = "top"
				}
				if(a0 == 13) {
					a3 = "left top"
				}
				if(a0 == 14) {
					a3 = "right top"
				}
				if(a0 == 15) {
					a3 = "left bottom"
				}
				if(a0 == 16) {
					a3 = "right bottom"
				}
				aZ += " url(" + a2 + ") " + a1 + " " + a3
			}
		}
		Site.saveFooterStyleData(aY);
		Site.setFooterBg(aZ)
	}

	function W() {
		var aY;
		aY = Site.getFooterStyleData();
		aY.rt.f = $("#regularTextFamily").val();
		aY.rt.c = q;
		Site.saveFooterStyleData(aY);
		Site.setRegularText(aY, true);
		Site.optimizeFooterAlign()
	}

	function aH() {
		if($("#footerSupport")) {
			var aZ = $("#footerSupport").css("font-size");
			var aY = parseInt(aZ.substring(0, aZ.length - 2)) + 3;
			$("#faisco-icons-logo").css("font-size", aY + "px")
		}
	}

	function aU(aZ) {
		if(aZ) {
			var a1 = $.parseJSON(aZ);
			var a0 = a1.data[0] || {};
			var aY = Site.getFooterStyleData();
			aY.fb.f = a0.fileId;
			aY.fb.p = a0.filePath;
			aY.fb.newSelect = true;
			Site.saveFooterStyleData(aY);
			if(a0.isMatBg) {
				aY.r = 3;
				$("#footerBgRepeat").val(3)
			}
			M();
			az();
			$("#uploadmsgFooter").html("<a href='javascript:;' onclick='Fai.top.panelFunc.view(\"" + a0.fileId + "\");return false;'>查看</a>");
			$("#footerBgCus").find(".J_previewContent").removeClass("f-previewContent-none");
			$("#footerBgCus").find(".J_preview").html("<img class='f-previewImg' src='" + aY.fb.p + "' onload='Fai.Img.optimize(this, {width:180, height:75, mode:Fai.Img.MODE_SCALE_DEFLATE_FILL});' alt='' />")
		}
	}

	function b() {
		var aZ;
		if($("#footerHeightCustom").attr("checked")) {
			var aY = $("#footerHeightInput").val();
			if(aY == "") {
				Fai.ing("高度设置不能为空", true);
				return
			} else {
				if(aY < 0 || aY > 1000) {
					Fai.ing("只能设置0~1000的高度", true);
					return
				}
			}
			if(!isNaN(parseInt(aY))) {
				aZ = Site.getFooterStyleData();
				aZ.fh = parseInt(aY);
				Site.setWebFooterHeight(aY)
			}
		} else {
			aZ = Site.getFooterStyleData();
			aZ.fh = -1;
			Site.autoWebFooterHeight()
		}
		Site.saveFooterStyleData(aZ);
		az()
	}

	function B(aY) {
		if(!aj) {
			top._bgImgChanged++;
			Site.styleChanged();
			Site.showSectionOfSitePage(aY);
			Site.setRefreshInfo("siteStyleSetting", true)
		}
	}

	function aa(a0, aY, aZ) {
		var a1 = "";
		var a3 = "";
		var a2;
		a2 = Site.getWebBackgroundData();
		if(aY == "web") {
			a1 = a2.p
		} else {
			if(aY == "webBannerTable") {
				a1 = a2.bBg.p
			} else {
				if(aY == "webContainerTable") {
					a1 = a2.cBg.p
				} else {
					if(aY == "container") {
						a1 = a2.cmBg.p
					} else {}
				}
			}
		}
		if(a0 == -1) {} else {
			a3 += " url(" + a1 + ")";
			if(a0 == 0) {
				a3 += " no-repeat center center"
			} else {
				if(a0 == 11) {
					a3 += " repeat-x top center"
				} else {
					if(a0 == 1) {
						a3 += " repeat-x center center "
					} else {
						if(a0 == 12) {
							a3 += " repeat-x bottom center"
						} else {
							if(a0 == 21) {
								if(aZ == "siteBg") {
									a3 += " repeat-y top left"
								} else {
									a3 += " repeat-y center left"
								}
							} else {
								if(a0 == 2) {
									if(aZ == "siteBg") {
										a3 += " repeat-y top center"
									} else {
										a3 += " repeat-y center center"
									}
								} else {
									if(a0 == 22) {
										if(aZ == "siteBg") {
											a3 += " repeat-y top right"
										} else {
											a3 += " repeat-y center right"
										}
									} else {
										if(a0 == 3) {
											if(aZ == "siteBg") {
												a3 += " repeat top"
											} else {
												a3 += " repeat center"
											}
										} else {
											if(a0 == 4 || a0 == 5) {
												if(aZ == "siteBg") {
													a3 += " repeat top"
												} else {
													a3 += " repeat top"
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return a3
	}
};
Site.bindEventToFloatPanel_addNewModule = function(j) {
	if(Fai.top.Site.sortData.getReceive() == "pack" && j.length > 0) {
		if("tab mulModuleColMulti mulModuleColTwo mulModuleColThree mulModuleColFour mulModuleColFive fullmeasure pack".indexOf(j) > -1) {
			return
		}
	}
	var l = Fai.top._colId;
	var a = Fai.top._extId;
	var f = Fai.top._panelOptionData ? Fai.top._panelOptionData.sysIndex : "";
	var i = Fai.top._panelOptionData ? Fai.top._panelOptionData.schemeCust : "";
	var h = Fai.top.draggableDiv_out ? Site.faiFloatPanel : undefined;
	var b;
	if(j == "product") {
		b = top.Fai.popupWindow({
			closeFunc: h,
			title: "添加模块（产品展示）",
			frameSrcUrl: "manage/productModuleEdit.jsp?pos=centerTopForms&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
			width: 600,
			height: 500
		});
		Fai.top._popupOptions["popup" + b].closeArgs = 0;
		Fai.top.draggableDiv_out ? Site.logDog(100079, 48) : Site.logDog(100079, 12)
	} else {
		if(j == "article") {
			b = top.Fai.popupWindow({
				closeFunc: h,
				title: "添加模块（文章列表）",
				frameSrcUrl: "manage/newsModuleEdit.jsp?pos=centerTopForms&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
				width: 600,
				height: 495
			});
			Fai.top._popupOptions["popup" + b].closeArgs = 0;
			Fai.top.draggableDiv_out ? Site.logDog(100079, 54) : Site.logDog(100079, 18)
		} else {
			if(j == "photo") {
				b = top.Fai.popupWindow({
					closeFunc: h,
					title: "添加模块（图册展示）",
					frameSrcUrl: "manage/photoModuleEdit.jsp?pos=centerTopForms&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
					width: 600,
					height: 555
				});
				Fai.top._popupOptions["popup" + b].closeArgs = 0;
				Fai.top.draggableDiv_out ? Site.logDog(100079, 55) : Site.logDog(100079, 19)
			} else {
				if(j == "list_photos") {
					b = top.Fai.popupWindow({
						closeFunc: h,
						title: "添加模块（列表多图）",
						frameSrcUrl: "manage/listPhotosModuleEdit.jsp?pos=centerTopForms&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
						width: 670,
						height: 430
					});
					Fai.top._popupOptions["popup" + b].closeArgs = 0;
					Fai.top.draggableDiv_out ? Site.logDog(100079, 96) : Site.logDog(100079, 95)
				} else {
					if(j == "carousel_photos") {
						b = top.Fai.popupWindow({
							closeFunc: h,
							title: "添加模块（轮播多图）",
							frameSrcUrl: "manage/carouselPhotosModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
							width: 670,
							height: 470
						});
						Fai.top._popupOptions["popup" + b].closeArgs = 0;
						Fai.top.draggableDiv_out ? Site.logDog(100079, 98) : Site.logDog(100079, 97)
					} else {
						if(j == "file") {
							b = top.Fai.popupWindow({
								closeFunc: h,
								title: "添加模块（文件下载）",
								frameSrcUrl: "manage/fileModuleEdit.jsp?pos=centerTopForms&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
								width: 530,
								height: 330
							});
							Fai.top._popupOptions["popup" + b].closeArgs = 0;
							Fai.top.draggableDiv_out ? Site.logDog(100079, 59) : Site.logDog(100079, 23)
						} else {
							if(j == "nav") {
								var m = Site.getTopWindow().location.href.indexOf("_showHideCol=true") != -1 ? true : false;
								b = top.Fai.popupWindow({
									closeFunc: h,
									title: "添加模块（栏目导航）",
									frameSrcUrl: "manage/navModuleEdit.jsp?_showHideCol=" + m + "&pos=centerTopForms&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
									width: 710,
									height: 500
								});
								Fai.top._popupOptions["popup" + b].closeArgs = 0;
								Fai.top.draggableDiv_out ? Site.logDog(100079, 42) : Site.logDog(100079, 6)
							} else {
								if(j == "rich") {
									b = top.Fai.popupWindow({
										closeFunc: h,
										title: "添加模块（图文展示）",
										frameSrcUrl: "manage/richEdit.jsp?pos=centerTopForms&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
										width: 850,
										height: 500
									});
									Fai.top._popupOptions["popup" + b].closeArgs = 0;
									Fai.top.draggableDiv_out ? Site.logDog(100079, 37) : Site.logDog(100079, 1)
								} else {
									if(j == "filter") {
										b = top.Fai.popupWindow({
											closeFunc: h,
											title: "添加模块（产品筛选）",
											frameSrcUrl: "manage/productFilterModuleEdit.jsp?pos=centerTopForms&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
											width: 620,
											height: 380
										});
										Fai.top._popupOptions["popup" + b].closeArgs = 0;
										Fai.top.draggableDiv_out ? Site.logDog(100079, 52) : Site.logDog(100079, 16)
									} else {
										if(j == "flash") {
											b = top.Fai.popupWindow({
												closeFunc: h,
												title: "添加模块（Flash）",
												frameSrcUrl: "manage/flashModuleEdit.jsp?pos=centerTopForms&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
												width: 400,
												height: 240
											});
											Fai.top._popupOptions["popup" + b].closeArgs = 0;
											Fai.top.draggableDiv_out ? Site.logDog(100079, 58) : Site.logDog(100079, 22)
										} else {
											if(j == "map") {
												b = top.Fai.popupWindow({
													closeFunc: h,
													title: "添加模块（在线地图）",
													frameSrcUrl: "manage/mapModuleEdit.jsp?pos=centerTopForms&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
													width: 640,
													height: 500
												});
												Fai.top._popupOptions["popup" + b].closeArgs = 0;
												Fai.top.draggableDiv_out ? Site.logDog(100079, 40) : Site.logDog(100079, 4)
											} else {
												if(j == "iframe") {
													b = top.Fai.popupWindow({
														closeFunc: h,
														title: "添加模块（嵌入页面）",
														frameSrcUrl: "manage/iframeModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
														width: 490,
														height: 210
													});
													Fai.top._popupOptions["popup" + b].closeArgs = 0;
													Fai.top.draggableDiv_out ? Site.logDog(100079, 68) : Site.logDog(100079, 32)
												} else {
													if(j == "catalog") {
														b = top.Fai.popupWindow({
															closeFunc: h,
															title: "添加模块（产品目录）",
															frameSrcUrl: "manage/productCatalogModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
															width: 560,
															height: 375
														});
														Fai.top._popupOptions["popup" + b].closeArgs = 0;
														Fai.top.draggableDiv_out ? Site.logDog(100079, 51) : Site.logDog(100079, 15)
													} else {
														if(j == "qqonline") {
															b = top.Fai.popupWindow({
																closeFunc: h,
																title: "添加模块（QQ在线）",
																frameSrcUrl: "manage/qqOnlineModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																width: 550,
																height: 350
															});
															Fai.top._popupOptions["popup" + b].closeArgs = 0
														} else {
															if(j == "vote") {
																b = top.Fai.popupWindow({
																	closeFunc: h,
																	title: "添加模块（在线投票）",
																	frameSrcUrl: "manage/voteModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																	width: 570,
																	height: 468
																});
																Fai.top._popupOptions["popup" + b].closeArgs = 0;
																Fai.top.draggableDiv_out ? Site.logDog(100079, 61) : Site.logDog(100079, 25)
															} else {
																if(j == "siteForm") {
																	b = top.Fai.popupWindow({
																		closeFunc: h,
																		title: "添加模块（在线表单）",
																		frameSrcUrl: "manage/siteFormModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																		width: 560,
																		height: 390
																	});
																	Fai.top._popupOptions["popup" + b].closeArgs = 0;
																	Fai.top.draggableDiv_out ? Site.logDog(100079, 62) : Site.logDog(100079, 26)
																} else {
																	if(j == "newsgroup") {
																		b = top.Fai.popupWindow({
																			closeFunc: h,
																			title: "添加模块（文章分类）",
																			frameSrcUrl: "manage/newsGroupModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																			width: 500,
																			height: 280
																		});
																		Fai.top._popupOptions["popup" + b].closeArgs = 0;
																		Fai.top.draggableDiv_out ? Site.logDog(100079, 72) : Site.logDog(100079, 36)
																	} else {
																		if(j == "photoGroupNav") {
																			b = top.Fai.popupWindow({
																				closeFunc: h,
																				title: "添加模块（图册分类）",
																				frameSrcUrl: "manage/photoGroupNavModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																				width: 500,
																				height: 280
																			});
																			Fai.top._popupOptions["popup" + b].closeArgs = 0;
																			Fai.top.draggableDiv_out ? Site.logDog(100079, 100) : Site.logDog(100079, 99)
																		} else {
																			if(j == "productGroup") {
																				b = top.Fai.popupWindow({
																					closeFunc: h,
																					title: "添加模块（产品分类旧版）",
																					frameSrcUrl: "manage/productGroupModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																					width: 560,
																					height: 390
																				});
																				Fai.top._popupOptions["popup" + b].closeArgs = 0;
																				Fai.top.draggableDiv_out ? Site.logDog(100079, 49) : Site.logDog(100079, 13)
																			} else {
																				if(j == "productMallGroup") {
																					b = top.Fai.popupWindow({
																						closeFunc: h,
																						title: "添加模块（商城导航）",
																						frameSrcUrl: "manage/productMallGroupModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																						width: 720,
																						height: 360
																					});
																					Fai.top._popupOptions["popup" + b].closeArgs = 0;
																					Fai.top.draggableDiv_out ? Site.logDog(100079, 92) : Site.logDog(100079, 91)
																				} else {
																					if(j == "productLabel") {
																						b = top.Fai.popupWindow({
																							closeFunc: h,
																							title: "添加模块（产品标签）",
																							frameSrcUrl: "manage/productLabelModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																							width: 500,
																							height: 296
																						});
																						Fai.top._popupOptions["popup" + b].closeArgs = 0;
																						Fai.top.draggableDiv_out ? Site.logDog(100079, 50) : Site.logDog(100079, 14)
																					} else {
																						if(j == "productNav") {
																							b = top.Fai.popupWindow({
																								closeFunc: Site.faiFloatPanel,
																								title: "添加模块（产品分类）",
																								frameSrcUrl: "manage/productNavModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																								width: 594,
																								height: 565
																							});
																							Fai.top._popupOptions["popup" + b].closeArgs = 0;
																							Fai.top.draggableDiv_out ? Site.logDog(100079, 94) : Site.logDog(100079, 93)
																						} else {
																							if(j == "weather") {
																								var d = top.Fai.popupWindowVersionTwo.createPopupWindow({
																									closeFunc: h,
																									title: "添加模块（天气信息）",
																									frameSrcUrl: "manage_v2/weatherModuleEditV2.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																									width: 662,
																									height: 600
																								});
																								var b = d.popupWindowId;
																								Fai.top._popupOptions["popup" + b].closeArgs = 0;
																								Fai.top.draggableDiv_out ? Site.logDog(100079, 45) : Site.logDog(100079, 9)
																							} else {
																								if(j == "floatImg") {
																									$.ajax({
																										type: "post",
																										url: "ajax/module_h.jsp?cmd=add&style=79&colId=" + l + "&extId=" + a,
																										data: "name=" + Fai.encodeUrl("图片"),
																										error: function() {
																											Fai.ing("服务繁忙，请稍候重试", false)
																										},
																										success: function(o) {
																											var n = $.parseJSON(o);
																											if(Fai.successHandle(o, "", "系统错误", "", 3, 1)) {
																												Site.addNewModule(n.id, n.div, null, null, {
																													returnModuledata: n.moduleData
																												})
																											}
																										}
																									});
																									Fai.top.draggableDiv_out ? Site.logDog(100079, 80) : Site.logDog(100079, 79)
																								} else {
																									if(j == "simpleText") {
																										$.ajax({
																											type: "post",
																											url: "ajax/module_h.jsp?cmd=add&style=86&colId=" + l + "&extId=" + a,
																											data: "name=" + Fai.encodeUrl("文本"),
																											error: function() {
																												Fai.ing("服务繁忙，请稍候重试", false)
																											},
																											success: function(o) {
																												var n = $.parseJSON(o);
																												if(Fai.successHandle(o, "", "系统错误", "", 3, 1)) {
																													Site.addNewModule(n.id, n.div, null, null, {
																														returnModuledata: n.moduleData
																													});
																													if($("#module" + n.id).length > 0) {
																														$("#module" + n.id).data("breakWord", true).find(".fk-editor").addClass("fk-editor-break-word")
																													}
																												}
																											}
																										});
																										Fai.top.draggableDiv_out ? Site.logDog(100079, 92) : Site.logDog(100079, 91)
																									} else {
																										if(j == "photoGroup") {
																											b = top.Fai.popupWindow({
																												closeFunc: h,
																												title: "添加模块（图册目录）",
																												frameSrcUrl: "manage/photoGroupModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																												width: 600,
																												height: 495
																											});
																											Fai.top._popupOptions["popup" + b].closeArgs = 0;
																											Fai.top.draggableDiv_out ? Site.logDog(100079, 56) : Site.logDog(100079, 20)
																										} else {
																											if(j == "tabHorizonal") {
																												addLayoutModuleAjax(29, "标签模块", l, a, false);
																												Fai.top.draggableDiv_out ? Site.logDog(100079, 46) : Site.logDog(100079, 10)
																											} else {
																												if(j == "tabVertical") {
																													addLayoutModuleAjax(29, "标签模块", l, a, true);
																													Fai.top.draggableDiv_out ? Site.logDog(100079, 46) : Site.logDog(100079, 10)
																												} else {
																													if(j == "mulModuleColMulti") {
																														b = top.Fai.popupWindow({
																															closeFunc: h,
																															title: "添加多列排版",
																															frameSrcUrl: "manage/mulModuleColEdit.jsp?num=2&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																															width: 585,
																															height: 300
																														});
																														Fai.top._popupOptions["popup" + b].closeArgs = 0
																													} else {
																														if(j == "link") {
																															b = top.Fai.popupWindow({
																																closeFunc: h,
																																title: "添加模块（图文链接）",
																																frameSrcUrl: "manage/linkModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																width: 650,
																																height: 360
																															});
																															Fai.top._popupOptions["popup" + b].closeArgs = 0;
																															Fai.top.draggableDiv_out ? Site.logDog(100079, 38) : Site.logDog(100079, 2)
																														} else {
																															if(j == "table") {
																																b = top.Fai.popupWindow({
																																	closeFunc: h,
																																	title: "添加模块（简易表格）",
																																	frameSrcUrl: "manage/tableModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																	width: 630,
																																	height: 355
																																});
																																Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																Fai.top.draggableDiv_out ? Site.logDog(100079, 60) : Site.logDog(100079, 24)
																															} else {
																																if(j == "flv") {
																																	b = top.Fai.popupWindow({
																																		closeFunc: h,
																																		title: "添加模块（在线视频）",
																																		frameSrcUrl: "manage/flvModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																		width: 400,
																																		height: 220
																																	});
																																	Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																	Fai.top.draggableDiv_out ? Site.logDog(100079, 57) : Site.logDog(100079, 21)
																																} else {
																																	if(j == "code") {
																																		b = top.Fai.popupWindow({
																																			closeFunc: h,
																																			title: "添加模块（插件代码）",
																																			frameSrcUrl: "manage/codeModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																			width: 560,
																																			height: 380
																																		});
																																		Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																		Fai.top.draggableDiv_out ? Site.logDog(100079, 69) : Site.logDog(100079, 33)
																																	} else {
																																		if(j == "weiboShow") {
																																			b = top.Fai.popupWindow({
																																				closeFunc: h,
																																				title: "添加模块（新浪微博秀）",
																																				frameSrcUrl: "manage/weiboShowModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																				width: 500,
																																				height: 350
																																			});
																																			Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																			Fai.top.draggableDiv_out ? Site.logDog(100079, 70) : Site.logDog(100079, 34)
																																		} else {
																																			if(j == "notice") {
																																				b = top.Fai.popupWindow({
																																					closeFunc: h,
																																					title: "添加模块（滚动公告）",
																																					frameSrcUrl: "manage/noticeModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																					width: 705,
																																					height: 345
																																				});
																																				Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																				Fai.top.draggableDiv_out ? Site.logDog(100079, 39) : Site.logDog(100079, 3)
																																			} else {
																																				if(j == "serviceOnline") {
																																					b = top.Fai.popupWindow({
																																						closeFunc: h,
																																						title: "添加模块（在线客服）",
																																						frameSrcUrl: "manage/serviceOnlineModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																						width: 655,
																																						height: 340
																																					});
																																					Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																					Fai.top.draggableDiv_out ? Site.logDog(100079, 41) : Site.logDog(100079, 5);
																																					Site.logDog(200173, 2)
																																				} else {
																																					if(j == "uicheck") {
																																						b = top.Fai.popupWindow({
																																							closeFunc: h,
																																							title: "添加模块（ui检查）",
																																							frameSrcUrl: "manage/uicheckEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																							width: 300,
																																							height: 100
																																						});
																																						Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																						Fai.top.draggableDiv_out ? Site.logDog(100079, 71) : Site.logDog(100079, 35)
																																					} else {
																																						if(j == "memberLogin") {
																																							b = top.Fai.popupWindow({
																																								closeFunc: h,
																																								title: "添加模块（会员登录）",
																																								frameSrcUrl: "manage/memberModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																								width: 515,
																																								height: 280
																																							});
																																							Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																							Fai.top.draggableDiv_out ? Site.logDog(100079, 43) : Site.logDog(100079, 7)
																																						} else {
																																							if(j == "siteSearch") {
																																								b = top.Fai.popupWindow({
																																									closeFunc: h,
																																									title: "添加模块（全站搜索）",
																																									frameSrcUrl: "manage/siteSearchModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																									width: 716,
																																									height: 500
																																								});
																																								Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																								Fai.top.draggableDiv_out ? Site.logDog(100079, 44) : Site.logDog(100079, 8)
																																							} else {
																																								if(j == "productSearch") {
																																									b = top.Fai.popupWindow({
																																										closeFunc: h,
																																										title: "添加模块（产品搜索）",
																																										frameSrcUrl: "manage_v2/productSearchModuleEdit.jsp?&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																										width: 716,
																																										height: 500
																																									});
																																									Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																									Fai.top.draggableDiv_out ? Site.logDog(100079, 53) : Site.logDog(100079, 17)
																																								} else {
																																									if(j == "siteQrCode") {
																																										b = top.Fai.popupWindow({
																																											closeFunc: h,
																																											title: "添加模块（网站二维码）",
																																											frameSrcUrl: "manage/webSiteQRCodeModuleEdit.jsp?&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																											width: 425,
																																											height: 270
																																										});
																																										Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																										Fai.top.draggableDiv_out ? Site.logDog(100079, 66) : Site.logDog(100079, 30)
																																									} else {
																																										if(j == "date") {
																																											b = top.Fai.popupWindow({
																																												closeFunc: h,
																																												title: "添加模块（当前时间）",
																																												frameSrcUrl: "manage/dateModuleEdit.jsp?&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																												width: 550,
																																												height: 360
																																											});
																																											Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																											Fai.top.draggableDiv_out ? Site.logDog(100079, 64) : Site.logDog(100079, 28)
																																										} else {
																																											if(j == "location") {
																																												if(l == f) {
																																													Fai.ing("首页不能添加当前位置模块");
																																													return
																																												}
																																												b = top.Fai.popupWindow({
																																													closeFunc: h,
																																													title: "添加模块（当前位置）",
																																													frameSrcUrl: "manage/locationModuleEdit.jsp?&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																													width: 340,
																																													height: 80
																																												});
																																												Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																												Fai.top.draggableDiv_out ? Site.logDog(100079, 65) : Site.logDog(100079, 29)
																																											} else {
																																												if(j == "indexFavorite") {
																																													b = top.Fai.popupWindow({
																																														closeFunc: h,
																																														title: "添加模块（收藏本站）",
																																														frameSrcUrl: "manage/favoriteModuleEdit.jsp?&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																														width: 340,
																																														height: 80
																																													});
																																													Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																													Fai.top.draggableDiv_out ? Site.logDog(100079, 67) : Site.logDog(100079, 31)
																																												} else {
																																													if(j == "shareTo") {
																																														b = top.Fai.popupWindow({
																																															closeFunc: h,
																																															title: "添加模块（分享网站）",
																																															frameScrolling: "no",
																																															frameSrcUrl: "manage/shareToModuleEdit.jsp?&colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																															width: 500,
																																															height: 450
																																														});
																																														Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																														Fai.top.draggableDiv_out ? Site.logDog(100079, 63) : Site.logDog(100079, 27)
																																													} else {
																																														if(j == "cust" && i) {
																																															var c = Fai.top._panelOptionData.schemeCust_popupUrl;
																																															var k = Fai.top._panelOptionData.schemeCust_popupWidth;
																																															var g = Fai.top._panelOptionData.schemeCust_popupHeight;
																																															b = top.Fai.popupWindow({
																																																closeFunc: h,
																																																title: "添加模块（定制模块）",
																																																frameSrcUrl: "cust/" + c + "&ram=" + Math.random(),
																																																width: '"' + k + '"',
																																																height: '"' + g + '"'
																																															});
																																															Fai.top._popupOptions["popup" + b].closeArgs = 0
																																														} else {
																																															if(j == "msgSubmit") {
																																																b = top.Fai.popupWindow({
																																																	closeFunc: h,
																																																	title: "添加模块（留言提交）",
																																																	frameSrcUrl: "manage/msgSubmitModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																																	width: 560,
																																																	height: 390
																																																});
																																																Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																																Fai.top.draggableDiv_out ? Site.logDog(100079, 74) : Site.logDog(100079, 73)
																																															} else {
																																																if(j == "fullmeasure") {
																																																	b = top.Fai.popupWindow({
																																																		closeFunc: h,
																																																		title: "添加模块（通栏模块）",
																																																		frameSrcUrl: "manage/styleFullmeasure.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																																		width: 715,
																																																		height: 445
																																																	});
																																																	Fai.top._popupOptions["popup" + b].closeArgs = 0;
																																																	Fai.top.draggableDiv_out ? Site.logDog(100079, 78) : Site.logDog(100079, 77)
																																																} else {
																																																	if(j == "floatBtn") {
																																																		b = top.Fai.popupWindow({
																																																			closeFunc: h,
																																																			title: "添加模块（按钮模块）",
																																																			frameSrcUrl: "manage/floatBtnEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																																			width: 650,
																																																			height: 500
																																																		});
																																																		Fai.top.draggableDiv_out ? Site.logDog(100079, 82) : Site.logDog(100079, 81);
																																																		Fai.top._popupOptions["popup" + b].closeArgs = 0
																																																	} else {
																																																		if(j == "shoppingCart") {
																																																			if(!Fai.top._mallOpen) {
																																																				Fai.ing("该模块开通商城功能后可用。 <a id='J_openMall' href='javascript:;'>立即开通</a>。");
																																																				Fai.top.$("#J_openMall").off("click.sC").on("click.sC", function() {
																																																					Site.showTopManageFrame("manageFrameMallEdit")
																																																				});
																																																				return
																																																			}
																																																			b = top.Fai.popupWindow({
																																																				closeFunc: h,
																																																				title: "添加模块（购物车）",
																																																				frameSrcUrl: "manage/shoppingCartModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																																				width: 548,
																																																				height: 468
																																																			});
																																																			Fai.top.draggableDiv_out ? Site.logDog(100079, 84) : Site.logDog(100079, 83);
																																																			Fai.top._popupOptions["popup" + b].closeArgs = 0
																																																		} else {
																																																			if(j == "photoCard") {
																																																				b = top.Fai.popupWindow({
																																																					closeFunc: h,
																																																					title: "添加模块（魔方图册）",
																																																					frameSrcUrl: "manage/photoCardModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																																					width: 666,
																																																					height: 594
																																																				});
																																																				Fai.top.draggableDiv_out ? Site.logDog(100079, 86) : Site.logDog(100079, 85);
																																																				Fai.top._popupOptions["popup" + b].closeArgs = 0
																																																			} else {
																																																				if(j == "mallCoupon") {
																																																					b = top.Fai.popupWindow({
																																																						closeFunc: h,
																																																						title: "编辑模块（优惠券）",
																																																						frameSrcUrl: "manage/couponModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																																						width: 500,
																																																						height: 280
																																																					});
																																																					Fai.top.draggableDiv_out ? Site.logDog(100079, 88) : Site.logDog(100079, 87);
																																																					Fai.top._popupOptions["popup" + b].closeArgs = 0
																																																				} else {
																																																					if(j == "photoMoreCard") {
																																																						b = top.Fai.popupWindow({
																																																							closeFunc: h,
																																																							title: "添加模块（魔方多图）",
																																																							frameSrcUrl: "manage/photoMoreCardModuleEdit.jsp?colId=" + l + "&extId=" + a + "&ram=" + Math.random(),
																																																							width: 666,
																																																							height: 594
																																																						});
																																																						Fai.top.draggableDiv_out ? Site.logDog(100079, 90) : Site.logDog(100079, 89);
																																																						Fai.top._popupOptions["popup" + b].closeArgs = 0
																																																					} else {
																																																						if(j == "pack") {
																																																							var e = {};
																																																							e.e = 1;
																																																							e.d = {
																																																								y: 1
																																																							};
																																																							$.ajax({
																																																								type: "post",
																																																								url: "ajax/module_h.jsp?cmd=add&style=87&colId=" + l + "&extId=" + a + "&pattern=" + Fai.encodeUrl($.toJSON(e)),
																																																								data: "name=" + Fai.encodeUrl("自由容器"),
																																																								error: function() {
																																																									Fai.ing("服务繁忙，请稍候重试", false)
																																																								},
																																																								success: function(o) {
																																																									var n = $.parseJSON(o);
																																																									if(Fai.successHandle(o, "", "系统错误", "", 3, 1)) {
																																																										Site.addNewModule(n.id, n.div, null, null, {
																																																											returnModuledata: n.moduleData
																																																										})
																																																									}
																																																								}
																																																							});
																																																							Fai.top.draggableDiv_out ? Site.logDog(100079, 94) : Site.logDog(100079, 93)
																																																						}
																																																					}
																																																				}
																																																			}
																																																		}
																																																	}
																																																}
																																															}
																																														}
																																													}
																																												}
																																											}
																																										}
																																									}
																																								}
																																							}
																																						}
																																					}
																																				}
																																			}
																																		}
																																	}
																																}
																															}
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	Site.setRefreshInfo("moduleEdit", true);
	Site.addModuleWithLogDog(j)
};
Site.faiFloatPanelDraggable = function() {
	Fai.top.$("#faiFloatPanel").draggable({
		axis: "x",
		scroll: false,
		cursor: "move",
		distance: 3,
		opacity: 0.8,
		cancel: ".panelContentContainer, #otherSectionSelecterContainer",
		start: function() {
			Fai.top.$("#faiFloatPanelOverLay").show();
			Fai.top.$("#colorpanel").remove();
			Fai.top.$(".faiColorPicker").remove()
		},
		stop: function() {
			var d = Fai.top.$(".floatRightTop").offset().left;
			var c = d / 2;
			var e = d - $(this).outerWidth() + 1;
			var b = 300;
			var a = Fai.top.$("#faiFloatPanelIconContainer");
			var h = 56;
			var g = h;
			var f = d - h - a.outerWidth();
			if(($(this).offset().left + ($(this).outerWidth() / 2)) < c) {
				$(this).attr("location", "left").removeClass("faiFloatPanel_right").addClass("faiFloatPanel_left").animate({
					left: "0"
				}, b);
				a.attr({
					location: "left"
				}).css({
					top: "40%",
					left: g + "px"
				})
			} else {
				$(this).attr("location", "right").removeClass("faiFloatPanel_left").addClass("faiFloatPanel_right").animate({
					left: e + "px"
				}, b);
				a.attr({
					location: "right"
				}).css({
					top: "40%",
					left: f + "px"
				})
			}
			a.show();
			a.removeClass("faiFloatPanelIconContainer_left faiFloatPanelIconContainer_right");
			$.cookie("faiFloatPanelIcon_left", a.offset().left, {
				expires: 365,
				path: "/"
			});
			$.cookie("faiFloatPanelIcon_top", a.offset().top, {
				expires: 365,
				path: "/"
			});
			a.hide();
			Fai.top.$("#faiFloatPanelOverLay").hide()
		}
	})
};
Site.faiFloatPanelModuleDraggable = function() {
	var b = Fai.top.$("#faiFloatPanel"),
		d = b.find("#addModuleContentContainer").find(".panelModuleIconContent"),
		i = d.filter(".panelModuleIcon_fullmeasure");
	d.draggable("destroy").draggable({
		helper: function() {
			return "<div id='faiFloatPanelDragDiv' class='panelContentContainer' style='width:80px;height:80px;cursor:move;'><div class='" + $(this).attr("class") + " good' style='width:80px;height:80px;padding:0;margin:0;'></div></div>"
		},
		appendTo: "#g_main",
		cursor: "move",
		zIndex: 9999,
		opacity: 0.6,
		connectToSortable: ".J_moduleZone:visible, .column:visible, .fullmeasureContent:visible, .J_packContent:visible, .formTabButtonList:visible, .formTabButtonYList:visible",
		beforeStart: function(j, k) {
			if($(this).hasClass("panelModuleIcon_productMallGroup")) {
				Fai.top.$(".fk-inBannerListZone").sortable("destroy")
			} else {
				jzUtils.run({
					name: "_elemZone.sortModuleZone",
					base: Fai.top
				})
			}
		},
		start: function(j, k) {
			if($(this).hasClass("panelModuleIcon_pack")) {
				Fai.top.Site.sortData.setFrom("dragAddPack")
			}
			Fai.top.draggableDiv_out = false;
			Fai.top.draggableDiv_enable = true;
			if(Fai.top._appendLayout == 24 || Fai.top._appendLayout == 25) {
				Fai.top._appendLayout == 2
			}
			Fai.top._appendLayout = Site.getAppendLayoutNum();
			Fai.top.dragToAddModule = true;
			Fai.top.dragInSortable = false;
			Fai.top.inSortableList = [];
			Fai.top._cancelAdd = false
		},
		drag: function(j, k) {
			e(j, k, false)
		},
		stop: function(j, k) {
			if(Fai.top._cancelAdd) {} else {
				if(Fai.top.draggableDiv_out && Fai.top.draggableDiv_enable) {
					Fai.top.draggableDiv_pageX = j.pageX;
					Fai.top.draggableDiv_pageY = j.pageY;
					Fai.top.draggableDiv_scrollTop = Fai.top.$("#g_main").scrollTop() || 0;
					$(this).children().eq(0).trigger("click")
				} else {
					$(this).children().eq(0).trigger("click")
				}
			}
			Site.sortableHelper.replaceAddModuleBtn(k);
			Fai.top.$("#g_main").find("li.panelModuleIconContent").remove();
			Fai.top.dragToAddModule = false;
			Fai.top.dragInSortable = false;
			if($.inArray("fullmeasureContent", Fai.top.inSortableList) > -1) {
				$(".fullmeasureContent").each(function(l, m) {
					if($(m).data("_sortabletmpForm")) {
						$(m).data("_sortabletmpForm").remove()
					}
				});
				$(".mulMColList").sortable("option", "disabled", false);
				$(".mulMColList").addClass("column");
				$(".formTabCntId").sortable("option", "disabled", false);
				$(".form").removeClass("formUnsortable");
				$(".formTabButtonList").sortable("option", "disabled", false);
				$(".formTab").sortable("option", "disabled", false);
				Site.displayAddModule();
				Site.enableEditLayer();
				Fai.top.$("body").enableSelection();
				Fai.startInterval(null)
			}
			if($.inArray("column", Fai.top.inSortableList) > -1) {
				Site.enableEditLayer();
				Fai.top.$("body").enableSelection();
				Fai.startInterval(null);
				Fai.top.$(".column .form, .floatForms .form, .absForms .form").each(function(l, m) {
					if($(m).hasClass("formStyle35")) {
						$(m).find(".form .formTab").addClass("column")
					}
				});
				Fai.top.$(".column .form[_inpack='0']").each(function(m, n) {
					var l = $(n);
					l.removeAttr("style")
				});
				Fai.top.$(".column").each(function(m, n) {
					var l = $(n);
					if(l.data("_sortabletmpForm")) {
						l.data("_sortabletmpForm").remove()
					}
				});
				$(".mulMColList").sortable("option", "disabled", false);
				$(".mulMColList").addClass("column");
				$(".mulMColList").sortable("option", "placeholder", "g_middlePlaceholder");
				$(".formTabCntId").sortable("option", "disabled", false);
				$(".form").removeClass("formUnsortable");
				$(".formTabButtonList").sortable("option", "disabled", false);
				$(".formTab").sortable("option", "disabled", false)
			}
			Site.addModuleWithLogDog()
		}
	});
	i.draggable("destroy").draggable({
		helper: function() {
			return "<div id='faiFloatPanelDragDiv' class='panelContentContainer' style='width:80px;height:80px;cursor:move;z-index:99999;'><div class='" + $(this).attr("class") + " good' style='width:80px;height:80px;padding:0;margin:0;'></div></div>"
		},
		appendTo: "#g_main",
		cursor: "move",
		zIndex: 9999,
		opacity: 0.6,
		connectToSortable: ".fullmeasureContainer",
		start: function(j, k) {
			Fai.top.draggableDiv_out = false;
			Fai.top.draggableDiv_enable = true;
			Fai.top.dragToAddModule = true;
			Fai.top.dragInSortable = false;
			Fai.top.inSortableList = [];
			k.helper.webContainer_disabled = false
		},
		drag: function(j, k) {
			e(j, k, true)
		},
		stop: function(j, k) {
			if(Fai.top.draggableDiv_out) {
				a(j, k)
			}
			if(Fai.top.draggableDiv_out && Fai.top.draggableDiv_enable) {
				$(this).children().eq(0).trigger("click")
			}
			Fai.top.$("#g_main").find("li.panelModuleIconContent").remove();
			Fai.top.dragToAddModule = false;
			Fai.top.dragInSortable = false;
			if($.inArray("fullmeasureContainer", Fai.top.inSortableList) > -1) {
				Site.displayAddModule();
				Site.enableEditLayer();
				Fai.top.$("body").enableSelection();
				Fai.startInterval(null)
			}
		}
	});

	function e(k, l, j) {
		if(Fai.top.dragInSortable) {
			Site.hideFaiFloatPanel();
			Fai.top.draggableDiv_out = true
		}
		if(!Fai.top.draggableDiv_out) {
			if(c(k, l)) {
				Site.hideFaiFloatPanel();
				Fai.top.draggableDiv_out = true
			}
		} else {
			if(j && !l.helper.webContainer_disabled) {
				f(k, l);
				l.helper.webContainer_disabled = true
			}
			Site.sortableHelper.replaceAddModuleBtn(l)
		}
	}

	function c(o, p) {
		var j = p.offset.left,
			m = b.offset().left,
			q = b.width(),
			k = b.attr("location"),
			l = 80,
			n = 64;
		if(k == "left") {
			if((j + (l - n)) > (m + q)) {
				return true
			}
		} else {
			if((j + l) < m) {
				return true
			}
		}
		return false
	}

	function f(j, k) {
		g(j, k, false);
		h(j, k, false)
	}

	function a(j, k) {
		g(j, k, true);
		h(j, k, true)
	}

	function g(m, n, l) {
		var k = Fai.top.$("#webContainer"),
			j = Fai.top.$("#webContainerCover");
		if(l === true) {
			k.removeClass("webContainer-disabled");
			j.remove()
		} else {
			if(l === false) {
				if(j.length < 1) {
					k.addClass("webContainer-disabled").append("<div id='webContainerCover' class='webContainerCover'></div>")
				}
			}
		}
	}

	function h(l, m, k) {
		var j = Fai.top.$(".fullmeasureContainer");
		if(k === true) {
			j.css("height", "")
		} else {
			if(k === false) {
				j.each(function() {
					var o = $(this);
					if(o.children(".form").length < 1) {
						var n = 62;
						o.css("height", n).sortable("refreshPositions")
					}
				})
			}
		}
	}
	b.find(".panelModuleIcon_shoppingCart").draggable("option", "connectToSortable", ".J_moduleZone:visible, .J_packContent:visible");
	b.find(".panelModuleIcon_productMallGroup").draggable("option", "connectToSortable", ".J_moduleZone:visible, .J_packContent:visible")
};
Site.faiFloatPanelPrompt = function() {
	$.cookie("faiFloatPanelPrompt", true, {
		expires: 365,
		path: "/"
	});
	Fai.top.$("#panelAddNewModulePrompt").remove()
};
Site.fixFaiFloatPanelData = function() {
	var b = Site.getWebBackgroundData();
	if($("#topBannerCustom").attr("checked")) {
		var a = parseInt($("#settingBannerHeightInput").val() || 0);
		if(a == "") {
			if(b.wbh == -1) {
				Site.autoWebBannerHeight();
				$("#topBannerDefault").attr({
					checked: "checked"
				});
				$("#topBannerCustom").attr({
					checked: false
				});
				$("#settingBannerHeightInputWrap").hide();
				return
			} else {
				a = b.wbh;
				$("#settingBannerHeightInput").val(a)
			}
		} else {
			if(a < 0 || a > 1000) {
				if(b.wbh == -1) {
					Site.autoWebBannerHeight();
					$("#topBannerDefault").attr({
						checked: "checked"
					});
					$("#topBannerCustom").attr({
						checked: false
					});
					$("#settingBannerHeightInputWrap").hide();
					return
				} else {
					a = b.wbh;
					$("#settingBannerHeightInput").val(a)
				}
			} else {
				if(!Fai.isNumber(a)) {
					if(b.wbh == -1) {
						Site.autoWebBannerHeight();
						$("#topBannerDefault").attr({
							checked: "checked"
						});
						$("#topBannerCustom").attr({
							checked: false
						});
						$("#settingBannerHeightInputWrap").hide();
						return
					} else {
						a = b.wbh;
						$("#settingBannerHeightInput").val(a)
					}
				}
			}
		}
		if(!isNaN(parseInt(a))) {
			b.wbh = parseInt(a);
			Site.setWebBannerHeight(a)
		}
		Site.addInputEventUnit("#settingBannerHeightInput")
	} else {
		b.wbh = -1;
		Site.autoWebBannerHeight()
	}
	Site.saveWebBackgroundData(b);
	var c;
	Fai.top._Global._useTemplateBackground ? c = Fai.top._headerTopStyle : c = Fai.top._customHeaderTopStyle;
	if($("#topStyleCustom").attr("checked")) {
		var a = parseInt($("#settingHeightInput").val() || 0);
		if(a === "" || isNaN(a)) {
			if(c.hts == -1) {
				$("#topStyleDefault").attr({
					checked: "checked"
				});
				$("#topStyleCustom").attr({
					checked: false
				});
				$("#settingHeightInputWrap").hide();
				return
			} else {
				a = c.hts;
				$("#settingHeightInput").val(a)
			}
		} else {
			if(a < 0 || a > 1000) {
				if(c.hts == -1) {
					$("#topStyleDefault").attr({
						checked: "checked"
					});
					$("#topStyleCustom").attr({
						checked: false
					});
					$("#settingHeightInputWrap").hide();
					return
				} else {
					a = c.hts;
					$("#settingHeightInput").val(a)
				}
			} else {
				if(!Fai.isNumber(a)) {
					if(c.hts == -1) {
						$("#topStyleDefault").attr({
							checked: "checked"
						});
						$("#topStyleCustom").attr({
							checked: false
						});
						$("#settingHeightInputWrap").hide();
						return
					} else {
						a = c.hts;
						$("#settingHeightInput").val(a)
					}
				}
			}
		}
		if(!isNaN(parseInt(a))) {
			Site.setHeaderTopHeight(a)
		}
		Site.addInputEventUnit("#settingHeightInput")
	}
};
Site.getAppendLayoutNum = function() {
	var a = Fai.top._appendLayout;
	if(Site.isLayoutHidden(a)) {
		if(!Site.isLayoutHidden(2)) {
			a = 2
		} else {
			if(!Site.isLayoutHidden(1)) {
				a = 1
			} else {
				if(!Site.isLayoutHidden(3)) {
					a = 3
				} else {
					if(!Site.isLayoutHidden(4)) {
						a = 4
					} else {
						if(!Site.isLayoutHidden(5)) {
							a = 5
						} else {
							if(!Site.isLayoutHidden(6)) {
								a = 6
							} else {
								if(!Site.isLayoutHidden(7)) {
									a = 7
								} else {
									if(!Site.isLayoutHidden(8)) {
										a = 8
									} else {
										a = -1
									}
								}
							}
						}
					}
				}
			}
		}
	}
	return a
};
Site.showSectionOfSitePage = function(a) {
	if(!!Fai.top.panelResetDefaultFlag) {
		return
	} else {
		Fai.top.panelResetDefaultFlag = false
	}
	if(typeof a == "undefined") {
		return
	}
	Fai.top.$("#g_main").scrollTop(0);
	if(a == "head") {
		Site.scrollToModuleDiv(Fai.top.$("#webHeader"))
	} else {
		if(a == "banner") {
			Site.scrollToModuleDiv(Fai.top.$("#webBanner"))
		} else {
			if(a == "content") {
				Site.scrollToModuleDiv(Fai.top.$("#webContainer"))
			} else {
				if(a == "foot") {
					Site.scrollToModuleDiv(Fai.top.$("#webFooter"))
				}
			}
		}
	}
};
Site.hideModuleAnimate = function(c) {
	if(!c.show) {
		return
	}
	var b = $("<div>");
	Fai.top.$("body").append(b);
	b.css({
		border: "2px solid #ff4400",
		position: "absolute",
		zIndex: "9999",
		top: c.top,
		left: c.left,
		height: c.height + "px",
		width: c.width + "px"
	});
	var f = Fai.top.$("#faiFloatPanel");
	var e = f.find("#sectionModuleContentContainer");
	var d = f.find("#sectionModuleContentContainerTopLine");
	var a = 0;
	if(Fai.isIE6() || Fai.isIE7()) {
		e.scrollTop(0).scrollTop(f.find("#panelNowModule" + c.id).offset().top - d.offset().top);
		a = 400
	} else {
		e.mCustomScrollbar("scrollTo", "#panelNowModule" + c.id, {
			scrollInertia: 300
		});
		if(e.find(".mCSB_scrollTools_vertical").is(":visible")) {
			a = 400
		}
	}
	setTimeout(function() {
		var g = f.find("#panelNowModule" + c.id);
		if(g.length < 1) {
			g = f.find("#panelSectionModuleTab")
		}
		b.animate({
			top: g.offset().top + "px",
			left: g.offset().left + "px",
			width: g.outerWidth() + "px",
			height: g.outerHeight() + "px"
		}, 850, function() {
			b.remove()
		})
	}, a)
};
Site.panelModuleCheck = function(e, d, o) {
	var f = Fai.top.$("#module" + e);
	if(Site.cantRemoveOrHideModule(f, "含有系统模块，无法隐藏。")) {
		return false
	}
	Site.removeOverlay();
	Fai.top.panelModuleIconClick = true;
	var n = $.parseJSON(Fai.top._panelOptionData.moduleStyleList);
	var k = Fai.top.$("#" + o + e).children(".panelModuleIcon");
	var m = Site.checkNestModule(f);
	var h = f.hasClass("formStyle29") ? true : false;
	var q = f.hasClass("formStyle35") ? true : false;
	var p = f.hasClass("formStyle80") ? true : false;
	var c = k.attr("title");
	if(!Fai.top._mallOpen && d == n.shoppingCart) {
		Fai.ing("该模块开通商城功能后可用。 <a id='J_openMall' href='javascript:;'>立即开通</a>。");
		Fai.top.$("#J_openMall").off("click.sC").on("click.sC", function() {
			Site.showTopManageFrame("manageFrameMallEdit")
		});
		return
	}
	if(d == 76) {
		if(Fai.top.$("script[src='" + Fai.top.productGroupScriptLink + "']").length == 0) {
			var i = document.createElement("script");
			i.type = "text/javascript";
			i.src = Fai.top.productGroupScriptLink;
			Fai.top.$("head")[0].appendChild(i)
		}
	}
	if(k.siblings(".panelCheckTip").is(":hidden")) {
		o == "panelNowModule" ? Site.logDog(100082, 11) : Site.logDog(100082, 21);
		c = c.replace("使用", "隐藏");
		k.attr("title", c);
		if(d == n.sysIndexFavorite || d == n.sysDate || d == n.sysShareTo || d == n.sysSiteSearch || d == n.productMallGroup || d == n.floatImg || d == n.floatBtn || d == n.shoppingCart || d == n.photoCard || d == n.photoNewCard || d == n.photoMoreCard) {
			Fai.top.Site.addModule(e, Fai.top._colId, Fai.top._extId, {
				callback: l
			})
		} else {
			if(d == n.sysProductSearch || d == n.sysMember || d == n.newsGroup || d == n.productGroup || d == n.productFilter || d == n.productCatalog || d == n.navList || d == n.serviceOnline || e == n.sysWebsiteQrcode) {
				var j = Fai.top._appendLayout;
				if(Fai.top._appendLayout == 2) {
					Fai.top._appendLayout = 1
				}
				Fai.top.Site.addModule(e, Fai.top._colId, Fai.top._extId, {
					callback: a
				});
				Fai.top._appendLayout = j
			} else {
				if(d == n.fullmeasure) {
					var j = Fai.top._appendLayout;
					Fai.top._appendLayout = 24;
					Fai.top.Site.addModule(e, Fai.top._colId, Fai.top._extId, {
						callback: a
					});
					Fai.top._appendLayout = j
				} else {
					Fai.top.Site.addModule(e, Fai.top._colId, Fai.top._extId, {
						callback: a
					})
				}
			}
		}
		var b = k.siblings(".nowModuleButtonDiv");
		b.find(".findButton").show();
		b.find(".setButton").show();
		b.find(".delButton").show();
		k.siblings(".panelCheckTip").show()
	} else {
		o == "panelNowModule" ? Site.logDog(100082, 12) : Site.logDog(100082, 22);
		if(f.length > 0 && f.attr("_global") == "true" && f.attr("_independent") == "false") {
			Site.hideGlobalModule(e, true, g)
		} else {
			c = c.replace("隐藏", "使用");
			k.attr("title", c);
			if(e == n.sysIndexFavorite || e == n.sysDate) {
				top.Fai.closeTip("#module" + e)
			}
			Site.hideModule(e, true, g);
			var b = k.siblings(".nowModuleButtonDiv");
			b.find(".findButton").hide();
			b.find(".setButton").hide();
			k.siblings(".panelCheckTip").hide()
		}
	}

	function g() {
		var r = Fai.top.$("#module" + e),
			s = Site.checkNestModule(r);
		if(s.isTab || s.isCol || s.isFullmeasure || s.isPack) {
			Site.updateCurrentSectionModule()
		}
	}

	function a(s) {
		if($(s).hasClass("formStyle29")) {
			Site.updateCurrentSectionModule();
			Fai.top.Site.bindInTabSwitch()
		} else {
			if($(s).hasClass("formStyle35")) {
				Site.updateCurrentSectionModule()
			} else {
				if($(s).hasClass("formStyle80")) {
					Site.updateCurrentSectionModule()
				} else {
					if($(s).hasClass("formStyle87")) {
						Site.updateCurrentSectionModule()
					}
				}
			}
		}
		var r = $(s).attr("id").replace("module", "");
		Site.showThisModule(r)
	}

	function l(D, r) {
		var C = D.attr("id"),
			w = C.replace(/module/, "");
		if(r) {
			Site.showThisModule(w);
			return
		}
		top.Site.absModule(C);
		top.Site.absTopModule(C);
		Site.getModuleAttrPattern(C.replace("module", "")).changed = true;
		var B = D.attr("class").split(" ");
		var u = 0;
		$.each(B, function(K, L) {
			if(L.length < 10) {
				return true
			}
			if(L.slice(0, 9) != "formStyle") {
				return true
			}
			if(u <= 0) {
				u = parseInt(L.slice(9));
				return false
			}
		});
		if(u == n.sysShareTo) {
			var y = 170,
				z = D.children("table.formMiddle");
			var J = z.find("td.formMiddleLeft");
			if(J.length > 0 && J.is(":visible")) {
				y += J.outerWidth(true)
			}
			var H = z.find("td.formMiddleRight");
			if(H.length > 0 && H.is(":visible")) {
				y += H.outerWidth(true)
			}
			var I = z.find("td.formMiddleCenter").children("div.formMiddleContent");
			var t = I.outerWidth(true) - I.width();
			y += t;
			y += z.outerWidth(true) - z.width();
			var A = "100px";
			var x = 0;
			var s = false;
			$.each(Fai.top.$(".formStyle" + n.sysShareTo), function(M, K) {
				if($(K).attr("id") === C) {
					return true
				}
				var L = $(K).css("top");
				if(L === A) {
					s = true
				}
				if(x < L.replace(/px/, "")) {
					x = parseInt(L.replace(/px/, ""))
				}
			});
			if(s) {
				x += 50;
				A = x + "px"
			}
			D.css({
				width: y + "px",
				left: "auto",
				right: "100px",
				top: A,
				height: "auto"
			});
			top.Site.lock(C);
			top.$("#" + C).css({
				top: A
			});
			D.attr("_side", 0);
			top.Site.sideModule(C)
		} else {
			if(u == n.sysDate) {
				var A = "10px";
				var x = 0;
				var s = false;
				$.each(Fai.top.$(".formStyle" + n.sysDate), function(M, K) {
					if($(K).attr("id") === C) {
						return true
					}
					var L = $(K).css("top");
					if(L === A) {
						s = true
					}
					if(x < L.replace(/px/, "")) {
						x = parseInt(L.replace(/px/, ""))
					}
				});
				if(s) {
					x += 20;
					A = x + "px"
				}
				D.css({
					width: "140px",
					left: "120px",
					right: "auto",
					top: A
				});
				var E = Site.getModuleAttrPattern(w).contentBg;
				E.y = 1;
				top.Site.hideModuleContentBg(w);
				var F = Site.getModuleAttrPattern(w);
				F.bannerType = 1;
				F.border.y = 1;
				F.inner.t = 0;
				F.inner.b = 0;
				F.inner.l = 0;
				F.inner.r = 0;
				F.inner.y = 1;
				top.Site.setModuleHeight(w, 20);
				top.Site.setModuleStyleCssList(w, [{
					cls: ".formMiddleContent",
					key: "margin-right",
					value: "0px"
				}, {
					cls: ".formMiddleContent",
					key: "margin-left",
					value: "0px"
				}, {
					cls: ".formMiddleContent",
					key: "margin-top",
					value: "0px"
				}, {
					cls: ".formMiddleContent",
					key: "margin-bottom",
					value: "0px"
				}]);
				top.Site.setModuleStyleCss(w, ".formBanner" + w, "display", "none");
				top.Site.hideModuleBorder(w)
			} else {
				if(u == n.sysSiteSearch) {
					var A = "40px";
					var x = 0;
					var s = false;
					$.each(Fai.top.$(".formStyle" + n.sysSiteSearch), function(M, K) {
						if($(K).attr("id") === C) {
							return true
						}
						var L = $(K).css("top");
						if(L === A) {
							s = true
						}
						if(x < L.replace(/px/, "")) {
							x = parseInt(L.replace(/px/, ""))
						}
					});
					if(s) {
						x += 20;
						A = x + "px"
					}
					D.css({
						width: "250px",
						left: "auto",
						right: "0px",
						top: A,
						height: "auto"
					});
					var E = Site.getModuleAttrPattern(w).contentBg;
					E.y = 1;
					top.Site.hideModuleContentBg(w);
					var F = Site.getModuleAttrPattern(w);
					F.bannerType = 1;
					F.border.y = 1;
					F.inner.t = 0;
					F.inner.b = 0;
					F.inner.l = 0;
					F.inner.r = 0;
					F.inner.y = 0;
					top.Site.setModuleStyleCssList(w, [{
						cls: ".formMiddleContent",
						key: "margin-right",
						value: "0px"
					}, {
						cls: ".formMiddleContent",
						key: "margin-left",
						value: "10px"
					}, {
						cls: ".formMiddleContent",
						key: "margin-top",
						value: "10px"
					}, {
						cls: ".formMiddleContent",
						key: "margin-bottom",
						value: "0px"
					}]);
					top.Site.setModuleStyleCss(w, ".formBanner" + w, "display", "none");
					top.Site.hideModuleBorder(w)
				} else {
					if(u == n.sysIndexFavorite) {
						var A = "10px";
						var x = 0;
						var s = false;
						$.each(Fai.top.$(".formStyle" + n.sysIndexFavorite), function(M, K) {
							if($(K).attr("id") === C) {
								return true
							}
							var L = $(K).css("top");
							if(L === A) {
								s = true
							}
							if(x < L.replace(/px/, "")) {
								x = parseInt(L.replace(/px/, ""))
							}
						});
						if(s) {
							x += 20;
							A = x + "px"
						}
						D.css({
							width: "140px",
							left: "auto",
							right: "120px",
							top: A,
							height: "auto"
						});
						var E = Site.getModuleAttrPattern(w).contentBg;
						E.y = 1;
						top.Site.hideModuleContentBg(w);
						var F = Site.getModuleAttrPattern(w);
						F.bannerType = 1;
						F.border.y = 1;
						F.inner.t = 0;
						F.inner.b = 0;
						F.inner.l = 0;
						F.inner.r = 0;
						F.inner.y = 0;
						top.Site.setModuleStyleCssList(w, [{
							cls: ".formMiddleContent",
							key: "margin-right",
							value: "0px"
						}, {
							cls: ".formMiddleContent",
							key: "margin-left",
							value: "10px"
						}, {
							cls: ".formMiddleContent",
							key: "margin-top",
							value: "10px"
						}, {
							cls: ".formMiddleContent",
							key: "margin-bottom",
							value: "0px"
						}]);
						top.Site.setModuleStyleCss(w, ".formBanner" + w, "display", "none");
						top.Site.hideModuleBorder(w)
					} else {
						if(u == n.floatImg) {
							D.find(".float_in_img").width(D.width());
							Site.cacheModuleFunc.run(D.attr("id"))
						} else {
							if(u == n.floatBtn) {
								if(top.$("head").find("link[href='" + _floatBtnCssLink + "']").length == 0) {
									top.$("<link class='floatBtnCss' type='text/css' href='" + _floatBtnCssLink + "' rel='stylesheet'>").appendTo(top.$("head"));
									var v = $(".floatBtnCss");
									v.load(function() {
										var K = D.find(".floatBtn");
										D.css({
											width: K.outerWidth() + "px",
											height: K.outerHeight() + "px"
										});
										Site.setFlBtnResizeHandleSize(D)
									})
								} else {
									var G = D.find(".floatBtn");
									D.css({
										width: G.outerWidth() + "px",
										height: G.outerHeight() + "px"
									});
									Site.setFlBtnResizeHandleSize(D)
								}
							} else {
								if(u == n.shoppingCart) {
									if(top.$("head").find("link[href='" + _shoppingCartCssLink + "']").length == 0) {
										top.$("<link type='text/css' href='" + _shoppingCartCssLink + "' rel='stylesheet'>").appendTo(top.$("head"))
									}
									D.css({
										width: "auto",
										height: "auto"
									})
								} else {
									if(u == n.photoCard) {
										if(top.$("head").find("link[href='" + _photoCardCssLink + "']").length == 0) {
											top.$("<link type='text/css' href='" + _photoCardCssLink + "' rel='stylesheet'>").appendTo(top.$("head"))
										}
										Site.initPhotoCard(D.attr("id").replace("module", ""))
									} else {
										if(u == n.photoNewCard) {
											if(top.$("head").find("link[href='" + _photoNewCardCssLink + "']").length == 0) {
												top.$("<link type='text/css' href='" + _photoNewCardCssLink + "' rel='stylesheet'>").appendTo(top.$("head"))
											}
											Site.initPhotoNewCard(D.attr("id").replace("module", ""))
										} else {
											if(u == n.photoMoreCard) {
												if(top.$("head").find("link[href='" + _photoMoreCardCssLink + "']").length == 0) {
													top.$("<link type='text/css' href='" + _photoMoreCardCssLink + "' rel='stylesheet'>").appendTo(top.$("head"))
												}
												Site.initPhotoMoreCard(D.attr("id").replace("module", ""))
											} else {
												if(u == n.productMallGroup) {
													D.css({
														width: "241px",
														left: "auto",
														right: "120px",
														top: A,
														height: "50px"
													});
													top.$("#module" + C.substring(6)).find(".mallHead").click().click()
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		top.Site.refreshAbsFloatForm(D);
		top.Site.scrollToDiv(D);
		Site.showThisModule(e)
	}
	Fai.top.panelModuleIconClick = false;
	Site.setRefreshInfo("moduleEdit", true)
};

function addLayoutModuleAjax(h, c, e, g, j) {
	var d = "ajax/module_h.jsp?cmd=add&style=" + h + "&colId=" + e + "&extId=" + g,
		f = [],
		a, b, k;
	f.push("name=" + Fai.encodeUrl(c));
	if(h == 35) {
		b = j;
		if(b > 5 || b < 2) {
			b = 3
		}
		d += "&prop2=" + b
	}
	if(h == 29) {
		k = j || false;
		f.push("&flag4=" + k)
	}
	if(!Fai.top._isTemplateVersion2) {
		var i = {};
		i.e = 1;
		f.push("&pattern=" + Fai.encodeUrl($.toJSON(i)))
	}
	$.ajax({
		type: "post",
		url: d,
		data: f.join(""),
		error: function() {
			Fai.ing("服务繁忙，请稍候重试", false)
		},
		success: function(l) {
			var m = $.parseJSON(l);
			if(Fai.successHandle(l, "", "系统错误", "", 3, 1)) {
				if(h == 29) {
					top.Site.addNewModule(m.id, m.div, null, null, {
						callback: top.Site.addNewModuleCallBack,
						allCheckList: [],
						parentId: m.id,
						colId: e,
						extId: g,
						returnModuledata: m.moduleData
					});
					Fai.top.$("#module" + m.id).attr("_autoHeight", "1");
					Site.autoModuleHeight(m.id);
					Site.sortable()
				} else {
					if(h == 35) {
						a = {
							realOpenColNum: b,
							inThisMulMColList: [{
								cId: "",
								cList: []
							}],
							inThisMulMColListWidth: [],
							mulColSpacing: -1
						};
						top.Site.addNewModule(m.id, m.div, null, null, {
							callback: top.Site.addNewMulMColModuleCallBack,
							allCheckList: $.toJSON(a),
							parentId: m.id,
							colId: e,
							extId: g,
							returnModuledata: m.moduleData
						});
						top.Site.refreshMulMColModule(m.id, e, g, $.toJSON(a), c)
					}
				}
			}
		}
	})
};