! function(e) {
	if("function" == typeof define && window.define.amd) window.define([], e);
	else e()
}(function() {
	var e = {},
		t = {},
		i = {},
		n = {},
		o = [],
		r = 0;
	if(!Function.prototype.bind) Function.prototype.bind = function(e) {
		if("function" != typeof this) throw new TypeError("Function.prototype.bind - what is trying to be bound is not callable");
		var t = Array.prototype.slice.call(arguments, 1),
			i = this,
			n = function() {},
			o = function() {
				return i.apply(this instanceof n && e ? this : e, t.concat(Array.prototype.slice.call(arguments)))
			};
		n.prototype = this.prototype;
		o.prototype = new n;
		return o
	};
	var a = function() {
		var e = navigator.userAgent.toLowerCase();
		var t = /msie/.test(e) && !/opera/.test(e);
		var i = (e.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [0, "0"])[1];
		var n = {
			6: "2.0",
			7: "3.0",
			8: "4.0",
			9: "5.0",
			10: "6.0",
			11: "7.0"
		};
		var o = n[document.documentMode] || n[parseInt(i)];
		if(t && parseInt(o, 10) < 4) return 1;
		else return 0
	};
	var s = function(e, t, i) {
		if(window.addEventListener) e.addEventListener(t, i, !1);
		else e.attachEvent("on" + t, i)
	};
	var c = function(e, t, i) {
		if(window.removeEventListener) e.removeEventListener(t, i);
		else e.detachEvent("on" + t, i)
	};
	var l = function(e) {
		e = e || "";
		if(e.indexOf("passport.126.com/webzj") >= 0 || e.indexOf("passport.yeah.net/webzj") >= 0 || e.indexOf("dl.reg.163.com/webzj") >= 0) e = e.replace(/\:\/\/[^\/]+\/webzj\//, function(e) {
			return e + "b/"
		});
		else e = e.replace(/\:\/\/([^\/]+)/, function(e) {
			return e + "/b"
		});
		return e
	};
	var f = [];
	var u = function(e) {
		var t = "";
		var n = i[e];
		if(n.__coverBackground && v("animation")) t = n.__coverBackground.indexOf("background:") != -1 ? n.__coverBackground : "";
		return "position:fixed;_position:absolute;top:0;left:0;width:100%;height:100%;overflow:hidden;background:rgb(0,0,0); filter:progid:DXImageTransform.Microsoft.Alpha(opacity=60);-moz-opacity:0.6;-khtml-opacity:0.6;opacity:0.6;z-index:1000;" + t
	};
	var h = function(e, t) {
		return "position:fixed;_position:absolute;z-index:10000;left:50%;top:50%;width:" + e + "px;margin-left:-" + e / 2 + "px;height:" + t + "px;margin-top:-" + t / 2 + "px;"
	};
	var d = function(e) {
		var t = i[e];
		var n = null;
		if(t.__iframeShowAnimation) n = "-webkit-animation:" + t.__iframeShowAnimation + ";-moz-animation:" + t.__iframeShowAnimation + ";-ms-animation:" + t.__iframeShowAnimation + ";-o-animation:" + t.__iframeShowAnimation + ";animation:" + t.__iframeShowAnimation + ";";
		return "width:100%;height:100%;border:none;background:none;" + (n ? n : "")
	};
	var p = function() {
		var e = setInterval(function() {
			for(var t = 0; t < o.length; t++)
				if(o[t].readyDone) {
					e = clearInterval(e);
					o.shift();
					g(1);
					break
				}
		}, 200)
	};
	var g = function(e) {
		if(e || !r) {
			r = 1;
			var t = setInterval(function() {
				for(var e = 0; e < o.length; e++)
					if(!o[e].readyDone) {
						t = clearInterval(t);
						y.call(o[e]);
						p();
						break
					}
			}, 200)
		}
	};
	var m = function(e, t, n) {
		var r = n.id;
		var a = "x-URS-iframe" + r;
		var s = i[r];
		var c = document.getElementById(a),
			l = s._name || "";
		if(!c) {
			try {
				c = document.createElement('<iframe  name="' + l + '" allowTransparency=true ></iframe>')
			} catch(f) {
				c = document.createElement("iframe");
				c.allowTransparency = !0;
				c.name = l
			}
			c.frameBorder = 0;
			c.id = a;
			c.scrolling = "no";
			c.style.cssText = d(r)
		}
		if(t) e.appendChild(c);
		else {
			var p = 420,
				m = 408;
			if(s.frameSize) {
				p = s.frameSize.width;
				m = s.frameSize.height
			}
			var w = document.getElementById("x-discover" + r);
			if(!w) {
				w = document.createElement("div");
				w.id = "x-discover" + r;
				w.style.cssText = u(r)
			}
			var v = document.getElementById("x-panel" + r);
			if(!v) {
				v = document.createElement("div");
				v.id = "x-panel" + r;
				s._panel = v;
				v.style.cssText = h(p, m)
			}
			v.appendChild(c);
			e.appendChild(w);
			e.appendChild(v);
			e.style.display = "none"
		}
		if(!window.postMessage) {
			o.push(this);
			g(0)
		}
	};
	var w = function(e) {
		var t = "x-URS-iframe" + this.MGID;
		var i = document.getElementById(t);
		if(this._urs_options && this._urs_options.afterSetIframeSrc) this._urs_options.afterSetIframeSrc(i);
		window.setTimeout(function() {
			this.__loadTime = (new Date).getTime();
			i.src = this._url_cache
		}.bind(this), 0);
		this.sto = clearTimeout(this.sto);
		if(window._$needUrsBgp)
			if(1 != e) this.sto = setTimeout(function() {
				this.sto = clearTimeout(this.sto);
				this._url_cache = this._url_cache.replace("webzj.reg.163.com", "webzj2.reg.163.com");
				if(window._$passportNeedUrsBgp) this._url_cache = this._url_cache.replace("passport.", "passport2.").replace("reg.icourse163.org", "reg2.icourse163.org");
				if(this._urs_options.wdaId) this._url_cache = this._url_cache.replace(/wdaId=([^&]+)/, "wdaId=UA1482833332087");
				w.call(this, 1)
			}.bind(this), this._urs_options.bgpTime)
	};
	var v = function(e) {
		var t = ["webkit", "Moz", "ms", "o"],
			i, n = [],
			o = document.documentElement.style,
			r = function(e) {
				return e.replace(/-(\w)/g, function(e, t) {
					return t.toUpperCase()
				})
			};
		for(i in t) n.push(r(t[i] + "-" + e));
		n.push(r(e));
		for(i in n)
			if(n[i] in o) return !0;
		return !1
	};
	var b = function(e, t) {
		var i = document.getElementById("x-URS-iframe" + e);
		var n = window.name || "_parent";
		var o = {};
		o.data = t;
		o.data.from = "URS|";
		o.data.topURL = location.href || "";
		o.origin = "*";
		o.source = n;
		o.data.mv = "cdn_17011101_101";
		o.data.loadTime = (new Date).getTime() - this.__loadTime;
		M(i.contentWindow, o)
	};
	var y = function() {
		b.call(this, this.MGID, this._urs_options)
	};
	var _ = function() {
		var e = /^([\w]+?:\/\/.*?(?=\/|$))/i;
		return function(t) {
			t = t || "";
			if(e.test(t)) return RegExp.$1;
			else return "*"
		}
	}();
	var S = function(e, t) {
		try {
			t = t.toLowerCase();
			if(null === e) return "null" == t;
			if(void 0 === e) return "undefined" == t;
			else return Object.prototype.toString.call(e).toLowerCase() == "[object " + t + "]"
		} catch(i) {
			return !1
		}
	};
	var I = function(e, t, i) {
		if(!e) return "";
		var n = [];
		for(var o in e)
			if(e.hasOwnProperty(o)) {
				var r = e[o];
				if(r)
					if(!S(r, "function")) {
						if(S(r, "date")) r = r.getTime();
						else if(S(r, "array")) r = r.join(",");
						else if(S(r, "object")) r = JSON.stringify(r);
						if(i) r = encodeURIComponent(r);
						n.push(encodeURIComponent(o) + "=" + r)
					} else;
				else;
			} else;
		return n.join(t || ",")
	};
	var M = function() {
		var e = "MSG|";
		var t = function(t) {
			var i = {};
			t = t || {};
			i.origin = t.origin || "";
			i.ref = location.href;
			i.self = t.source;
			i.data = JSON.stringify(t.data);
			return e + I(i, "|", !0)
		};
		return function(e, i) {
			if(window.postMessage) {
				i = i || {};
				e.postMessage(JSON.stringify(i.data), _(i.origin))
			} else f.unshift({
				w: e,
				d: escape(t(i))
			})
		}
	}();
	var k = function() {
		var e = navigator.appName;
		if("Netscape" == e) {
			var t = window.open("about:blank", "_self");
			t.opener = null;
			t.close()
		} else if("Microsoft Internet Explorer" == e) {
			window.opener = null;
			window.open("", "_self");
			window.close()
		}
	};
	window.URS = function() {
		var o = function() {
			var e = (new Date).getTime() + Math.random();
			if(!n[e]) {
				n[e] = e;
				return e
			} else return o()
		};
		var r = function(e) {
			if(a()) e.needUrsBgp = 0;
			if("0" == e.needUrsBgp) {
				e.passportNeedUrsBgp = 0;
				window._$needUrsBgp = 0;
				window._$passportNeedUrsBgp = 0
			} else {
				if(e.crossDomainUrl || e.cookieDomain) {
					window._$passportNeedUrsBgp = 1;
					e.passportNeedUrsBgp = 1
				}
				window._$needUrsBgp = 1;
				e.needUrsBgp = 1
			}
			this.MGID = o();
			i[this.MGID] = {};
			this._$COM_NUM = 1 == this._$COM_NUM ? 1 : 2;
			var t = i[this.MGID];
			t.frameSize = e.frameSize;
			t.__coverBackground = e.coverBackground;
			t.__iframeShowAnimation = e.iframeShowAnimation;
			window.PTDOM = 0 != e.isHttps ? "https://" : "http://";
			if(e.cssDomain && e.cssFiles) {
				if(e.cssDomain.indexOf("http://") != -1) window.PTDOM = "http://";
				t.__cssStr = "cd=" + encodeURIComponent(e.cssDomain) + "&cf=" + encodeURIComponent(e.cssFiles)
			}
			this.isInclude = 0;
			if(e.includeBox)
				if("string" == typeof e.includeBox) this.isInclude = document.getElementById(e.includeBox) || 0;
				else this.isInclude = e.includeBox;
			t.needPrepare = e.needPrepare || 0;
			if("string" == typeof e.eventType) this._type = e.eventType;
			if("string" == typeof e.bid) this._btn = document.getElementById(e.bid);
			else this._btn = e.bid;
			if(e.logincb) this.logincb = e.logincb;
			if(e.closecb) this.closecb = e.closecb;
			if(e.regcb) this.regcb = e.regcb;
			if(e.loginCheckLock) this.loginCheckLock = e.loginCheckLock;
			if(e.regCheckLock) this.regCheckLock = e.regCheckLock;
			if(e.initReady) this.initReady = e.initReady;
			if(e.statecb) this.statecb = e.statecb;
			if(e.resize) this.resize = e.resize;
			if(e.changepage) this.changepage = e.changepage;
			if(e.moduleResize) this.moduleResize = e.moduleResize;
			if(e.loginstate) this.loginstate = e.loginstate;
			if(e.otherRegSuccess) this.otherRegSuccess = e.otherRegSuccess;
			if(e.lockMbLoginState) this.lockMbLoginState = e.lockMbLoginState;
			if(e.lockMbRegState) this.lockMbRegState = e.lockMbRegState;
			if(e.mbInitSuccess) this.mbInitSuccess = e.mbInitSuccess;
			if(e.mbChangeModule) this.mbChangeModule = e.mbChangeModule;
			if(e.loginInitSuccess) this.loginInitSuccess = e.loginInitSuccess;
			if(e.regInitSuccess) this.regInitSuccess = e.regInitSuccess;
			var n = document.createElement("div");
			n.id = "x-URS" + this.MGID;
			document.body.appendChild(n);
			this.box = n;
			var r = "index.html";
			if(e.single) {
				r = "index_dl.html";
				if("register" == e.page) r = "index_reg.html"
			}
			var c = e.crossDomainUrl || "webzj.reg.163.com/v1.0.1/pub/";
			this._url_cache = window.PTDOM + c + r;
			var f = parseInt(1e3 * Math.random());
			e.pathB = 0;
			if(window.URS._$pathBPercent)
				if(f <= window.URS._$pathBPercent) e.pathB = 1;
			if(e.pathB) this._url_cache = l(this._url_cache);
			if(t.__cssStr) this._url_cache += "?" + t.__cssStr + "&MGID=" + this.MGID + "&wdaId=" + (e.wdaId || "");
			else this._url_cache += "?MGID=" + this.MGID + "&wdaId=" + (e.wdaId || "");
			this._urs_options = e || {};
			this._urs_options.bgpTime = e.bgpTime || 1e4;
			this._url_cache += "&pkid=" + (this._urs_options.promark || "") + "&product=" + (this._urs_options.product || "");
			try {
				JSON.stringify(this._urs_options)
			} catch(u) {
				return null
			}
			if(!this.isInclude) {
				if(this._btn && this._type) s(this._btn, this._type, this.showIframe.bind(this))
			} else this.includeBox = this.isInclude
		};
		var u = function(e) {
			if(e) e.stopPropagation ? e.stopPropagation() : e.cancelBubble = !0
		};
		var h = function(t) {
			u(t);
			var i = t.data || "{}";
			if("string" == typeof i) try {
				i = JSON.parse(i)
			} catch(n) {
				i = {}
			}
			if(e[i.MGID]) e[i.MGID]({
				data: i,
				origin: _(t.origin)
			})
		};
		var d = function(e) {
			var n = e.data,
				o, r, a;
			if(n) {
				if("string" == typeof n) try {
					n = JSON.parse(n)
				} catch(s) {
					n = {}
				}
				if(n.MGID) {
					o = t[n.MGID];
					r = i[n.MGID];
					if(o.isInclude) a = o.includeBox;
					else a = r._panel;
					if(n["URS-READY-DONE"]) {
						o.readyDone = 1;
						o.sto = clearTimeout(o.sto);
						if(o.initReady) o.initReady()
					}
					if(n["URS-READY"]) o.ursReady = 1;
					if(!window.postMessage || !n["URS-READY"] || !o.isInclude && r.needPrepare) {
						if(n["URS-READY"] && !r._initReady) r._initReady = !0;
						if(!n["URS-CM-STATE"])
							if(!n || !n.fromOutLogin || n.toOpener) {
								if("moduleResize" == n.type) {
									if(o.moduleResize) o.moduleResize(n)
								} else if("regInitSuccess" == n.type) {
									if(o.regInitSuccess) o.regInitSuccess()
								} else if("loginInitSuccess" == n.type) {
									if(o.loginInitSuccess) o.loginInitSuccess()
								} else if("mbChangeModule" == n.type) {
									if(o.mbChangeModule) o.mbChangeModule()
								} else if("mbInitSuccess" == n.type) {
									if(o.mbInitSuccess) o.mbInitSuccess()
								} else if("lockMbLoginState" == n.type) {
									if(o.lockMbLoginState) o.lockMbLoginState(n)
								} else if("lockMbRegState" == n.type) {
									if(o.lockMbRegState) o.lockMbRegState(n)
								} else if("otherRegSuccess" == n.type) {
									if(o.otherRegSuccess) o.otherRegSuccess(n)
								} else if("success" == n.type) {
									if(o.logincb) o.logincb(n["username"], n["isOther"], n);
									if(!this.isInclude) {
										if(o._btn && o._type) c(o._btn, o._type, o.showIframe.bind(o));
										o.closeIframe()
									}
								} else if("close" == n.type) {
									if(o.closecb) o.closecb();
									o.closeIframe()
								} else if("resize" == n.type || "init" == n.type) {
									a.style.width = n.width + "px";
									a.style.height = n.height + "px";
									if(!o.isInclude) a.style.marginLeft = -1 * n.width / 2 + "px";
									if(o.resize) o.resize(n)
								} else if("register-success" == n.type) {
									if(o.regcb) o.regcb(n["username"], n["url"])
								} else if("lockLoginState" == n.type) {
									if(o.loginCheckLock) o.loginCheckLock(n.value)
								} else if("lockRegState" == n.type) {
									if(o.regCheckLock) o.regCheckLock(n.value)
								} else if("changepage" == n.type) {
									if(o.changepage) o.changepage(n.page)
								} else if("loginstate" == n.type)
									if(o.loginstate) o.loginstate(n)
							} else {
								try {
									window.opener.$outLogin(n)
								} catch(s) {}
								setTimeout(function() {
									k()
								}, 200)
							}
						else if(o.statecb) o.statecb(n["URS-CM-STATENAME"], n["URS-CM-STATE"])
					} else y.call(o)
				}
			}
		};
		var p = function() {
			var e = "MSG|";
			var t = function(e, t) {
				var i = S(t, "function") ? t : function(e) {
						return e === t
					},
					n = null;
				for(var o = 0, r = e.length - 1, a; o < r; o++) {
					a = e[o];
					if(i(a)) n = o
				}
				return null != n ? n : -1
			};
			var i = function() {
				var e;
				var i = function(i, n, o) {
					if(t(e, i.w) < 0) {
						e.push(i.w);
						o.splice(n, 1);
						i.w.name = i.d
					}
				};
				return function() {
					e = [];
					if(f && f.length)
						for(var t = f.length, n; t--; t >= 0) {
							n = f[t];
							i(n, t, f)
						}
					e = null
				}
			}();
			var n = function() {
				var t = unescape(window.name || "");
				if(t && 0 == t.indexOf(e)) {
					window.name = "";
					var i = t.replace(e, ""),
						n = i.split("|"),
						o = n.length,
						r = {};
					for(var a = 0; a < o; a++) {
						var s = n[a].split("=");
						if(!s || !s.length) return;
						var c = s.shift();
						if(!c) return;
						r[decodeURIComponent(c)] = decodeURIComponent(s.join("="))
					}
					i = r;
					var l = (i.origin || "").toLowerCase();
					if(!l || "*" == l || 0 == location.href.toLowerCase().indexOf(l)) d({
						data: i.data || "null",
						origin: _(i.ref || document.referrer)
					})
				}
			};
			return function() {
				setInterval(i, 100);
				setInterval(n, 20)
			}
		}();
		var g = function() {
			if(!window.__hasRun) {
				if(window.postMessage) s(window, "message", h);
				else p();
				window.__hasRun = 1
			}
		};
		return function(n) {
			r.call(this, n);
			var o = i[this.MGID];
			if(o.needPrepare || this.isInclude) this.prepareIframe();
			e[this.MGID] = d.bind(this);
			t[this.MGID] = this;
			return g()
		}
	}();
	window.URS.prototype.prepareIframe = function() {
		if(this.isInclude) {
			m.call(this, this.includeBox, 1, {
				id: this.MGID
			});
			w.call(this);
			this.showIframe()
		} else {
			m.call(this, this.box, 0, {
				id: this.MGID
			});
			w.call(this)
		}
	};
	window.URS.prototype.showIframe = function(e) {
		var t = i[this.MGID];
		if(!this.isInclude)
			if(!t.needPrepare) {
				m.call(this, this.box, 0, {
					id: this.MGID
				});
				w.call(this)
			} else if(!t._initReady) return;
		e = e || {};
		if(e.page) {
			if(e.page != this._urs_options.page && this._urs_options.single) {
				var n = "index_dl.html";
				if("register" == e.page) n = "index_reg.html";
				this._url_cache = window.PTDOM + "webzj.reg.163.com/v1.0.1/pub/" + n;
				var o = parseInt(1e3 * Math.random());
				e.pathB = 0;
				if(window.URS._$pathBPercent)
					if(o <= window.URS._$pathBPercent) e.pathB = 1;
				if(e.pathB) this._url_cache = l(this._url_cache);
				if(t.__cssStr) this._url_cache += "?" + t.__cssStr + "&MGID=" + this.MGID;
				else this._url_cache += "?MGID=" + this.MGID;
				this._url_cache += "&pkid=" + (e.promark || "") + "&product=" + (e.product || "")
			}
			w.call(this);
			this._urs_options.page = e.page
		}
		if(t.needPrepare && !this.isInclude) y.call(this);
		this.box.style.display = "block";
		if(this._urs_options.afterShow) this._urs_options.afterShow.call(this)
	};
	window.URS.prototype.closeIframe = function() {
		var e = i[this.MGID];
		if(!this.isInclude) {
			this.box.style.display = "none";
			w.call(this);
			if(!e.needPrepare) {
				if(navigator.userAgent.indexOf("MSIE") > 0) {
					var t = document.getElementById("x-URS-iframe" + this.MGID),
						n = t.contentWindow;
					if(t) {
						t.src = "about:blank";
						try {
							n.document.write("");
							n.document.clear()
						} catch(o) {}
					}
					var r = document.getElementById("x-panel" + this.MGID);
					r.removeChild(t);
					window.CollectGarbage()
				}
				this.box.innerHTML = ""
			}
		} else;
	};
	window.URS.prototype.loginUnlock = function() {
		var e = {
			fromLoginLock: 1,
			lock: 0
		};
		b.call(this, this.MGID, e)
	};
	window.URS.prototype.loginDolock = function() {
		var e = {
			fromLoginLock: 1,
			lock: 1
		};
		b.call(this, this.MGID, e)
	};
	window.URS.prototype.regUnlock = function() {
		var e = {
			fromRegLock: 1,
			lock: 0
		};
		b.call(this, this.MGID, e)
	};
	window.URS.prototype.regDolock = function() {
		var e = {
			fromRegLock: 1,
			lock: 1
		};
		b.call(this, this.MGID, e)
	};
	window.URS.prototype.doLoginProxy = function(e) {
		var t = {
			username: e.username,
			pwd: e.pwd,
			defaultUnLogin: e.defaultUnLogin,
			doLoginProxy: 1
		};
		b.call(this, this.MGID, t)
	};
	window.URS.prototype.loginUnlockMb = function() {
		var e = {
			fromLoginLockMb: 1,
			lock: 0
		};
		b.call(this, this.MGID, e)
	};
	window.URS.prototype.loginDolockMb = function() {
		var e = {
			fromLoginLockMb: 1,
			lock: 1
		};
		b.call(this, this.MGID, e)
	};
	window.URS.prototype.regUnlockMb = function() {
		var e = {
			fromRegLockMb: 1,
			lock: 0
		};
		b.call(this, this.MGID, e)
	};
	window.URS.prototype.regDolockMb = function() {
		var e = {
			fromRegLockMb: 1,
			lock: 1
		};
		b.call(this, this.MGID, e)
	};
	window.URS.setPkidAndPd = function() {
		var e = function(e) {
			var t;
			if(e && e.lgs) {
				t = e.lgs || "0";
				window.URS._$pathBPercent = parseInt(t)
			}
		};
		var t = function(t) {
			var i = t.pkid || "";
			var n = t.pd || "";
			var o;
			if(void 0 === t.mode) o = "3";
			else o = t.mode;
			if("3" != o && "0" != o) {
				var r = "URSJSONP" + (new Date).getTime();
				window[r] = e;
				var a = "//dl.reg.163.com/getConf?callback=" + r + "&pkid=" + i + "&pd=" + n + "&mode=" + o;
				var s = document.createElement("script");
				s.type = "text/javascript";
				s.id = "urs-script-" + r;
				s.src = a;
				document.getElementsByTagName("head")[0].appendChild(s);
				setTimeout(function() {
					document.getElementsByTagName("head")[0].removeChild(s)
				}, 5e3)
			}
		};
		return function(e) {
			t(e)
		}
	}();
	return window.URS
});
(function() {
	function e(t, n) {
		function r(e) {
			if(r[e] !== w) return r[e];
			var t;
			if("bug-string-char-index" == e) t = "a" != "a" [0];
			else if("json" == e) t = r("json-stringify") && r("json-parse");
			else {
				var i;
				if("json-stringify" == e) {
					t = n.stringify;
					var o = "function" == typeof t && v;
					if(o) {
						(i = function() {
							return 1
						}).toJSON = i;
						try {
							o = "0" === t(0) && "0" === t(new a) && '""' == t(new s) && t(p) === w && t(w) === w && t() === w && "1" === t(i) && "[1]" == t([i]) && "[null]" == t([w]) && "null" == t(null) && "[null,null,null]" == t([w, p, null]) && '{"a":[1,true,false,null,"\\u0000\\b\\n\\f\\r\\t"]}' == t({
								a: [i, !0, !1, null, "\0\b\n\f\r\t"]
							}) && "1" === t(null, i) && "[\n 1,\n 2\n]" == t([1, 2], null, 1) && '"-271821-04-20T00:00:00.000Z"' == t(new l((-864e13))) && '"+275760-09-13T00:00:00.000Z"' == t(new l(864e13)) && '"-000001-01-01T00:00:00.000Z"' == t(new l((-621987552e5))) && '"1969-12-31T23:59:59.999Z"' == t(new l((-1)))
						} catch(c) {
							o = !1
						}
					}
					t = o
				}
				if("json-parse" == e) {
					t = n.parse;
					if("function" == typeof t) try {
						if(0 === t("0") && !t(!1)) {
							i = t('{"a":[1,true,false,null,"\\u0000\\b\\n\\f\\r\\t"]}');
							var f = 5 == i.a.length && 1 === i.a[0];
							if(f) {
								try {
									f = !t('"\t"')
								} catch(u) {}
								if(f) try {
									f = 1 !== t("01")
								} catch(h) {}
								if(f) try {
									f = 1 !== t("1.")
								} catch(d) {}
							}
						}
					} catch(g) {
						f = !1
					}
					t = f
				}
			}
			return r[e] = !!t
		}
		t || (t = o.Object());
		n || (n = o.Object());
		var a = t.Number || o.Number,
			s = t.String || o.String,
			c = t.Object || o.Object,
			l = t.Date || o.Date,
			f = t.SyntaxError || o.SyntaxError,
			u = t.TypeError || o.TypeError,
			h = t.Math || o.Math,
			d = t.JSON || o.JSON;
		"object" == typeof d && d && (n.stringify = d.stringify, n.parse = d.parse);
		var c = c.prototype,
			p = c.toString,
			g, m, w, v = new l((-0xc782b5b800cec));
		try {
			v = -109252 == v.getUTCFullYear() && 0 === v.getUTCMonth() && 1 === v.getUTCDate() && 10 == v.getUTCHours() && 37 == v.getUTCMinutes() && 6 == v.getUTCSeconds() && 708 == v.getUTCMilliseconds()
		} catch(b) {}
		if(!r("json")) {
			var y = r("bug-string-char-index");
			if(!v) var _ = h.floor,
				S = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334],
				I = function(e, t) {
					return S[t] + 365 * (e - 1970) + _((e - 1969 + (t = +(1 < t))) / 4) - _((e - 1901 + t) / 100) + _((e - 1601 + t) / 400)
				};
			(g = c.hasOwnProperty) || (g = function(e) {
				var t = {},
					i;
				(t.__proto__ = null, t.__proto__ = {
					toString: 1
				}, t).toString != p ? g = function(e) {
					var t = this.__proto__;
					e = e in (this.__proto__ = null, this);
					this.__proto__ = t;
					return e
				} : (i = t.constructor, g = function(e) {
					var t = (this.constructor || i).prototype;
					return e in this && !(e in t && this[e] === t[e])
				});
				t = null;
				return g.call(this, e)
			});
			m = function(e, t) {
				var n = 0,
					o, r, a;
				(o = function() {
					this.valueOf = 0
				}).prototype.valueOf = 0;
				r = new o;
				for(a in r) g.call(r, a) && n++;
				o = r = null;
				n ? m = 2 == n ? function(e, t) {
					var i = {},
						n = "[object Function]" == p.call(e),
						o;
					for(o in e) n && "prototype" == o || g.call(i, o) || !(i[o] = 1) || !g.call(e, o) || t(o)
				} : function(e, t) {
					var i = "[object Function]" == p.call(e),
						n, o;
					for(n in e) i && "prototype" == n || !g.call(e, n) || (o = "constructor" === n) || t(n);
					(o || g.call(e, n = "constructor")) && t(n)
				} : (r = "valueOf toString toLocaleString propertyIsEnumerable isPrototypeOf hasOwnProperty constructor".split(" "), m = function(e, t) {
					var n = "[object Function]" == p.call(e),
						o, a = !n && "function" != typeof e.constructor && i[typeof e.hasOwnProperty] && e.hasOwnProperty || g;
					for(o in e) n && "prototype" == o || !a.call(e, o) || t(o);
					for(n = r.length; o = r[--n]; a.call(e, o) && t(o));
				});
				return m(e, t)
			};
			if(!r("json-stringify")) {
				var M = {
						92: "\\\\",
						34: '\\"',
						8: "\\b",
						12: "\\f",
						10: "\\n",
						13: "\\r",
						9: "\\t"
					},
					k = function(e, t) {
						return("000000" + (t || 0)).slice(-e)
					},
					R = function(e) {
						for(var t = '"', i = 0, n = e.length, o = !y || 10 < n, r = o && (y ? e.split("") : e); i < n; i++) {
							var a = e.charCodeAt(i);
							switch(a) {
								case 8:
								case 9:
								case 10:
								case 12:
								case 13:
								case 34:
								case 92:
									t += M[a];
									break;
								default:
									if(32 > a) {
										t += "\\u00" + k(2, a.toString(16));
										break
									}
									t += o ? r[i] : e.charAt(i)
							}
						}
						return t + '"'
					},
					U = function(e, t, i, n, o, r, a) {
						var s, c, l, f, h, d, v, b, y;
						try {
							s = t[e]
						} catch(S) {}
						if("object" == typeof s && s)
							if(c = p.call(s), "[object Date]" != c || g.call(s, "toJSON")) "function" == typeof s.toJSON && ("[object Number]" != c && "[object String]" != c && "[object Array]" != c || g.call(s, "toJSON")) && (s = s.toJSON(e));
							else if(s > -1 / 0 && s < 1 / 0) {
							if(I) {
								f = _(s / 864e5);
								for(c = _(f / 365.2425) + 1970 - 1; I(c + 1, 0) <= f; c++);
								for(l = _((f - I(c, 0)) / 30.42); I(c, l + 1) <= f; l++);
								f = 1 + f - I(c, l);
								h = (s % 864e5 + 864e5) % 864e5;
								d = _(h / 36e5) % 24;
								v = _(h / 6e4) % 60;
								b = _(h / 1e3) % 60;
								h %= 1e3
							} else c = s.getUTCFullYear(), l = s.getUTCMonth(), f = s.getUTCDate(), d = s.getUTCHours(), v = s.getUTCMinutes(), b = s.getUTCSeconds(), h = s.getUTCMilliseconds();
							s = (0 >= c || 1e4 <= c ? (0 > c ? "-" : "+") + k(6, 0 > c ? -c : c) : k(4, c)) + "-" + k(2, l + 1) + "-" + k(2, f) + "T" + k(2, d) + ":" + k(2, v) + ":" + k(2, b) + "." + k(3, h) + "Z"
						} else s = null;
						i && (s = i.call(t, e, s));
						if(null === s) return "null";
						c = p.call(s);
						if("[object Boolean]" == c) return "" + s;
						if("[object Number]" == c) return s > -1 / 0 && s < 1 / 0 ? "" + s : "null";
						if("[object String]" == c) return R("" + s);
						if("object" == typeof s) {
							for(e = a.length; e--;)
								if(a[e] === s) throw u();
							a.push(s);
							y = [];
							t = r;
							r += o;
							if("[object Array]" == c) {
								l = 0;
								for(e = s.length; l < e; l++) c = U(l, s, i, n, o, r, a), y.push(c === w ? "null" : c);
								e = y.length ? o ? "[\n" + r + y.join(",\n" + r) + "\n" + t + "]" : "[" + y.join(",") + "]" : "[]"
							} else m(n || s, function(e) {
								var t = U(e, s, i, n, o, r, a);
								t !== w && y.push(R(e) + ":" + (o ? " " : "") + t)
							}), e = y.length ? o ? "{\n" + r + y.join(",\n" + r) + "\n" + t + "}" : "{" + y.join(",") + "}" : "{}";
							a.pop();
							return e
						}
					};
				n.stringify = function(e, t, n) {
					var o, r, a, s;
					if(i[typeof t] && t)
						if("[object Function]" == (s = p.call(t))) r = t;
						else if("[object Array]" == s) {
						a = {};
						for(var c = 0, l = t.length, f; c < l; f = t[c++], (s = p.call(f), "[object String]" == s || "[object Number]" == s) && (a[f] = 1));
					}
					if(n)
						if("[object Number]" == (s = p.call(n))) {
							if(0 < (n -= n % 1))
								for(o = "", 10 < n && (n = 10); o.length < n; o += " ");
						} else "[object String]" == s && (o = 10 >= n.length ? n : n.slice(0, 10));
					return U("", (f = {}, f[""] = e, f), r, a, o, "", [])
				}
			}
			if(!r("json-parse")) {
				var C = s.fromCharCode,
					D = {
						92: "\\",
						34: '"',
						47: "/",
						98: "\b",
						116: "\t",
						110: "\n",
						102: "\f",
						114: "\r"
					},
					x, T, j = function() {
						x = T = null;
						throw f()
					},
					O = function() {
						for(var e = T, t = e.length, i, n, o, r, a; x < t;) switch(a = e.charCodeAt(x), a) {
							case 9:
							case 10:
							case 13:
							case 32:
								x++;
								break;
							case 123:
							case 125:
							case 91:
							case 93:
							case 58:
							case 44:
								return i = y ? e.charAt(x) : e[x], x++, i;
							case 34:
								i = "@";
								for(x++; x < t;)
									if(a = e.charCodeAt(x), 32 > a) j();
									else if(92 == a) switch(a = e.charCodeAt(++x), a) {
									case 92:
									case 34:
									case 47:
									case 98:
									case 116:
									case 110:
									case 102:
									case 114:
										i += D[a];
										x++;
										break;
									case 117:
										n = ++x;
										for(o = x + 4; x < o; x++) a = e.charCodeAt(x), 48 <= a && 57 >= a || 97 <= a && 102 >= a || 65 <= a && 70 >= a || j();
										i += C("0x" + e.slice(n, x));
										break;
									default:
										j()
								} else {
									if(34 == a) break;
									a = e.charCodeAt(x);
									for(n = x; 32 <= a && 92 != a && 34 != a;) a = e.charCodeAt(++x);
									i += e.slice(n, x)
								}
								if(34 == e.charCodeAt(x)) return x++, i;
								j();
							default:
								n = x;
								45 == a && (r = !0, a = e.charCodeAt(++x));
								if(48 <= a && 57 >= a) {
									for(48 == a && (a = e.charCodeAt(x + 1), 48 <= a && 57 >= a) && j(); x < t && (a = e.charCodeAt(x), 48 <= a && 57 >= a); x++);
									if(46 == e.charCodeAt(x)) {
										for(o = ++x; o < t && (a = e.charCodeAt(o), 48 <= a && 57 >= a); o++);
										o == x && j();
										x = o
									}
									a = e.charCodeAt(x);
									if(101 == a || 69 == a) {
										a = e.charCodeAt(++x);
										43 != a && 45 != a || x++;
										for(o = x; o < t && (a = e.charCodeAt(o), 48 <= a && 57 >= a); o++);
										o == x && j();
										x = o
									}
									return +e.slice(n, x)
								}
								r && j();
								if("true" == e.slice(x, x + 4)) return x += 4, !0;
								if("false" == e.slice(x, x + 5)) return x += 5, !1;
								if("null" == e.slice(x, x + 4)) return x += 4, null;
								j()
						}
						return "$"
					},
					B = function(e) {
						var t, i;
						"$" == e && j();
						if("string" == typeof e) {
							if("@" == (y ? e.charAt(0) : e[0])) return e.slice(1);
							if("[" == e) {
								for(t = [];; i || (i = !0)) {
									e = O();
									if("]" == e) break;
									i && ("," == e ? (e = O(), "]" == e && j()) : j());
									"," == e && j();
									t.push(B(e))
								}
								return t
							}
							if("{" == e) {
								for(t = {};; i || (i = !0)) {
									e = O();
									if("}" == e) break;
									i && ("," == e ? (e = O(), "}" == e && j()) : j());
									"," != e && "string" == typeof e && "@" == (y ? e.charAt(0) : e[0]) && ":" == O() || j();
									t[e.slice(1)] = B(O())
								}
								return t
							}
							j()
						}
						return e
					},
					L = function(e, t, i) {
						i = A(e, t, i);
						i === w ? delete e[t] : e[t] = i
					},
					A = function(e, t, i) {
						var n = e[t],
							o;
						if("object" == typeof n && n)
							if("[object Array]" == p.call(n))
								for(o = n.length; o--;) L(n, o, i);
							else m(n, function(e) {
								L(n, e, i)
							});
						return i.call(e, t, n)
					};
				n.parse = function(e, t) {
					var i, n;
					x = 0;
					T = "" + e;
					i = B(O());
					"$" != O() && j();
					x = T = null;
					return t && "[object Function]" == p.call(t) ? A((n = {}, n[""] = i, n), "", t) : i
				}
			}
		}
		n.runInContext = e;
		return n
	}
	var t = "function" == typeof define && define.amd,
		i = {
			"function": !0,
			object: !0
		},
		n = i[typeof exports] && exports && !exports.nodeType && exports,
		o = i[typeof window] && window || this,
		r = n && i[typeof module] && module && !module.nodeType && "object" == typeof global && global;
	!r || r.global !== r && r.window !== r && r.self !== r || (o = r);
	if(n && !t) e(o, n);
	else {
		var a = o.JSON,
			s = o.JSON3,
			c = !1,
			l = e(o, o.JSON3 = {
				noConflict: function() {
					c || (c = !0, o.JSON = a, o.JSON3 = s, a = s = null);
					return l
				}
			});
		o.JSON = {
			parse: l.parse,
			stringify: l.stringify
		}
	}
	t && define("URS-JSON3", function() {
		return l
	})
}).call(this);