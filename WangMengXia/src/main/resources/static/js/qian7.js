(function() {
	function x(a, b) {
		for(var c in b) a.setAttribute(c, b[c])
	}

	function n(a, b) {
		a.onload = function() {
			this.onerror = this.onload = null;
			b(null, a)
		};
		a.onerror = function() {
			this.onerror = this.onload = null;
			b(Error("Failed to load " + this.src), a)
		}
	}

	function y(a, b) {
		a.onreadystatechange = function() {
			if("complete" == this.readyState || "loaded" == this.readyState) this.onreadystatechange = null, b(null, a)
		}
	}

	function p() {}

	function t(a, b, c) {
		for(var d in b) !b.hasOwnProperty(d) || void 0 !== a[d] && !0 !== c || (a[d] = b[d]);
		return a
	}

	function u(a,
		b, c) {
		var d = function(a) {
			return a.replace(/(^\/)|(\/$)/g, "")
		};
		b = d(b.replace(/^https?:\/\//i, ""));
		return(c = c ? d(c) : "") ? a + "://" + b + "/" + c : a + "://" + b
	}

	function z(a, b, c) {
		function d() {
			h.parentNode && h.parentNode.removeChild(h);
			window[e] = p;
			l && clearTimeout(l)
		}
		"function" === typeof b && (c = b, b = {});
		b || (b = {});
		var f = b.prefix || "__jp",
			e = b.name || f + A++,
			f = b.param || "cb",
			g = null != b.timeout ? b.timeout : 6E4;
		b = encodeURIComponent;
		var k = document.getElementsByTagName("script")[0] || document.head,
			h, l;
		g && (l = setTimeout(function() {
				d();
				c && c(Error("Timeout"))
			},
			g));
		window[e] = function(a) {
			d();
			c && c(null, a)
		};
		g = (new Date).getTime();
		a += (~a.indexOf("?") ? "\x26" : "?") + f + "\x3d" + b(e) + "\x26t\x3d" + g;
		a = a.replace("?\x26", "?");
		h = document.createElement("script");
		h.src = a;
		k.parentNode.insertBefore(h, k);
		return function() {
			window[e] && d()
		}
	}

	function B(a) {
		try {
			var b = localStorage.getItem(a).split(q);
			if(+b.splice(-1) >= v()) return b.join(q);
			localStorage.removeItem(a);
			return ""
		} catch(c) {
			return ""
		}
	}

	function C(a, b) {
		var c = a.pn,
			d = a.protocol,
			f = a.timeout,
			e = a.__serverConfig__;
		void 0 === e && (e = {});
		c = u(d, e.configServer || "ac.dun.163yun.com", "/v2/config/js?pn\x3d" + c);
		z(c, {
			timeout: f
		}, b)
	}

	function D(a) {
		return {
			start: function() {
				a._start()
			},
			stop: function() {
				a._stop()
			},
			getToken: function(b, c, d) {
				if(!b) throw Error("Missing business key");
				a._getToken(b, c, d)
			},
			getNdInfo: function(b) {
				a._getNdInfo(b)
			},
			getInstance: function() {
				return a
			}
		}
	}

	function E(a, b, c) {
		var d = a.productNumber,
			f = a.merged,
			e = a.pn || d;
		if(!e) throw Error("[NEWatchman] required product number");
		d = location.protocol.replace(":", "");
		a = t(t({
				onload: b,
				onerror: c
			},
			a), {
			protocol: d,
			auto: !0,
			onload: p,
			onerror: p,
			timeout: 0,
			pn: e
		});
		"http" !== a.protocol && "https" !== a.protocol && (a.protocol = "https");
		if(!f) return w(a);
		var g = window.initWatchman.__instances__;
		if(g[e]) g[e].callback.push(a.onload), g[e].instance && (g[e].callback.forEach(function(a) {
			return a(g[e].instance)
		}), g[e].callback.length = 0);
		else return g[e] = {
			instance: null,
			callback: [a.onload]
		}, w(a)
	}
	var F = function(a, b, c) {
			var d = document.head || document.getElementsByTagName("head")[0],
				f = document.createElement("script");
			"function" ===
			typeof b && (c = b, b = {});
			b = b || {};
			c = c || function() {};
			f.type = b.type || "text/javascript";
			f.charset = b.charset || "utf8";
			f.async = "async" in b ? !!b.async : !0;
			f.src = a;
			b.attrs && x(f, b.attrs);
			b.text && (f.text = "" + b.text);
			("onload" in f ? n : y)(f, c);
			f.onload || n(f, c);
			d.appendChild(f)
		},
		A = 0,
		q = ",",
		v = function(a) {
			void 0 === a && (a = 0);
			return(new Date).getTime() + parseInt(a, 10)
		},
		w = function(a) {
			function b(a, b) {
				var c = a.protocol,
					d = a.onerror,
					h = a.__serverConfig__;
				void 0 === h && (h = {});
				var l = a.attrs;
				void 0 === l && (l = {});
				var r = b.split(","),
					p = r[0],
					q =
					r[1],
					n = r[2],
					m = t({
						configHash: n,
						sConfig: n,
						staticServer: h.staticServer || p,
						apiServer: h.apiServer || q,
						buildVersion: r[3]
					}, a),
					h = m.buildVersion + "/watchman.min",
					c = u(c, m.staticServer) + "/" + h + ".js";
				F(c, {
					charset: "UTF-8",
					attrs: l
				}, function(a) {
					if(a) return d("[NEWatchman] load js file error");
					a = m.pn;
					var b = m.onload,
						c = m.merged,
						e = D(new Watchman(m)),
						f = window.initWatchman.__instances__;
					c && f[a] ? (f[a].instance = e, f[a].callback.forEach(function(a) {
						return a(e)
					}), f[a].callback.length = 0) : b(e)
				})
			}
			var c = a.merged ? a.pn + ":wm_cf" : "default:wm_cf",
				d = B(c);
			d ? b(a, d) : C(a, function(d, e) {
				var g = a.onerror;
				if(d) return g(Error("[NEWatchman] fetch config timeout"));
				if(e && 200 === e.code) {
					var k = e.result,
						g = k.ivp,
						k = [k.s, k.as, k.conf, k.v].join();
					try {
						var h = v(g);
						localStorage.setItem(c, k + q + h)
					} catch(l) {}
					b(a, k)
				} else g(Error("[NEWatchman] fetch config error"))
			})
		};
	window.initWatchman || (window.initWatchman = window.initNEWatchman = E, window.initWatchman.version = 3, window.initWatchman.__instances__ = {}, window.initWatchman.__supportCaptcha__ = !0)
})();