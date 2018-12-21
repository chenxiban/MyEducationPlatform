/*
 Highcharts JS v6.1.0 (2018-04-13)

 (c) 2009-2016 Torstein Honsi

 License: www.highcharts.com/license
*/
(function(w) {
	"object" === typeof module && module.exports ? module.exports = w : w(Highcharts)
})(function(w) {
	(function(b) {
		function r(b, a) {
			this.init(b, a)
		}
		var v = b.CenteredSeriesMixin,
			u = b.each,
			n = b.extend,
			q = b.merge,
			g = b.splat;
		n(r.prototype, {
			coll: "pane",
			init: function(b, a) {
				this.chart = a;
				this.background = [];
				a.pane.push(this);
				this.setOptions(b)
			},
			setOptions: function(b) {
				this.options = q(this.defaultOptions, this.chart.angular ? {
					background: {}
				} : void 0, b)
			},
			render: function() {
				var b = this.options,
					a = this.options.background,
					c = this.chart.renderer;
				this.group || (this.group = c.g("pane-group").attr({
					zIndex: b.zIndex || 0
				}).add());
				this.updateCenter();
				if(a)
					for(a = g(a), b = Math.max(a.length, this.background.length || 0), c = 0; c < b; c++) a[c] && this.axis ? this.renderBackground(q(this.defaultBackgroundOptions, a[c]), c) : this.background[c] && (this.background[c] = this.background[c].destroy(), this.background.splice(c, 1))
			},
			renderBackground: function(b, a) {
				var c = "animate";
				this.background[a] || (this.background[a] = this.chart.renderer.path().add(this.group), c = "attr");
				this.background[a][c]({
					d: this.axis.getPlotBandPath(b.from,
						b.to, b)
				}).attr({
					fill: b.backgroundColor,
					stroke: b.borderColor,
					"stroke-width": b.borderWidth,
					"class": "highcharts-pane " + (b.className || "")
				})
			},
			defaultOptions: {
				center: ["50%", "50%"],
				size: "85%",
				startAngle: 0
			},
			defaultBackgroundOptions: {
				shape: "circle",
				borderWidth: 1,
				borderColor: "#cccccc",
				backgroundColor: {
					linearGradient: {
						x1: 0,
						y1: 0,
						x2: 0,
						y2: 1
					},
					stops: [
						[0, "#ffffff"],
						[1, "#e6e6e6"]
					]
				},
				from: -Number.MAX_VALUE,
				innerRadius: 0,
				to: Number.MAX_VALUE,
				outerRadius: "105%"
			},
			updateCenter: function(b) {
				this.center = (b || this.axis || {}).center =
					v.getCenter.call(this)
			},
			update: function(b, a) {
				q(!0, this.options, b);
				this.setOptions(this.options);
				this.render();
				u(this.chart.axes, function(c) {
					c.pane === this && (c.pane = null, c.update({}, a))
				}, this)
			}
		});
		b.Pane = r
	})(w);
	(function(b) {
		var r = b.addEvent,
			v = b.Axis,
			u = b.each,
			n = b.extend,
			q = b.map,
			g = b.merge,
			l = b.noop,
			a = b.pick,
			c = b.pInt,
			d = b.Tick,
			k = b.wrap,
			f = b.correctFloat,
			e, p, t = v.prototype,
			h = d.prototype;
		b.radialAxisExtended || (b.radialAxisExtended = !0, e = {
			getOffset: l,
			redraw: function() {
				this.isDirty = !1
			},
			render: function() {
				this.isDirty = !1
			},
			setScale: l,
			setCategories: l,
			setTitle: l
		}, p = {
			defaultRadialGaugeOptions: {
				labels: {
					align: "center",
					x: 0,
					y: null
				},
				minorGridLineWidth: 0,
				minorTickInterval: "auto",
				minorTickLength: 10,
				minorTickPosition: "inside",
				minorTickWidth: 1,
				tickLength: 10,
				tickPosition: "inside",
				tickWidth: 2,
				title: {
					rotation: 0
				},
				zIndex: 2
			},
			defaultRadialXOptions: {
				gridLineWidth: 1,
				labels: {
					align: null,
					distance: 15,
					x: 0,
					y: null,
					style: {
						textOverflow: "none"
					}
				},
				maxPadding: 0,
				minPadding: 0,
				showLastLabel: !1,
				tickLength: 0
			},
			defaultRadialYOptions: {
				gridLineInterpolation: "circle",
				labels: {
					align: "right",
					x: -3,
					y: -2
				},
				showLastLabel: !1,
				title: {
					x: 4,
					text: null,
					rotation: 90
				}
			},
			setOptions: function(a) {
				a = this.options = g(this.defaultOptions, this.defaultRadialOptions, a);
				a.plotBands || (a.plotBands = [])
			},
			getOffset: function() {
				t.getOffset.call(this);
				this.chart.axisOffset[this.side] = 0
			},
			getLinePath: function(c, d) {
				c = this.center;
				var m = this.chart,
					e = a(d, c[2] / 2 - this.offset);
				this.isCircular || void 0 !== d ? (d = this.chart.renderer.symbols.arc(this.left + c[0], this.top + c[1], e, e, {
					start: this.startAngleRad,
					end: this.endAngleRad,
					open: !0,
					innerR: 0
				}), d.xBounds = [this.left + c[0]], d.yBounds = [this.top + c[1] - e]) : (d = this.postTranslate(this.angleRad, e), d = ["M", c[0] + m.plotLeft, c[1] + m.plotTop, "L", d.x, d.y]);
				return d
			},
			setAxisTranslation: function() {
				t.setAxisTranslation.call(this);
				this.center && (this.transA = this.isCircular ? (this.endAngleRad - this.startAngleRad) / (this.max - this.min || 1) : this.center[2] / 2 / (this.max - this.min || 1), this.minPixelPadding = this.isXAxis ? this.transA * this.minPointOffset : 0)
			},
			beforeSetTickPositions: function() {
				if(this.autoConnect =
					this.isCircular && void 0 === a(this.userMax, this.options.max) && f(this.endAngleRad - this.startAngleRad) === f(2 * Math.PI)) this.max += this.categories && 1 || this.pointRange || this.closestPointRange || 0
			},
			setAxisSize: function() {
				t.setAxisSize.call(this);
				this.isRadial && (this.pane.updateCenter(this), this.isCircular && (this.sector = this.endAngleRad - this.startAngleRad), this.len = this.width = this.height = this.center[2] * a(this.sector, 1) / 2)
			},
			getPosition: function(c, d) {
				return this.postTranslate(this.isCircular ? this.translate(c) :
					this.angleRad, a(this.isCircular ? d : this.translate(c), this.center[2] / 2) - this.offset)
			},
			postTranslate: function(a, c) {
				var d = this.chart,
					e = this.center;
				a = this.startAngleRad + a;
				return {
					x: d.plotLeft + e[0] + Math.cos(a) * c,
					y: d.plotTop + e[1] + Math.sin(a) * c
				}
			},
			getPlotBandPath: function(d, e, b) {
				var f = this.center,
					m = this.startAngleRad,
					k = f[2] / 2,
					h = [a(b.outerRadius, "100%"), b.innerRadius, a(b.thickness, 10)],
					p = Math.min(this.offset, 0),
					x = /%$/,
					t, B = this.isCircular;
				"polygon" === this.options.gridLineInterpolation ? f = this.getPlotLinePath(d).concat(this.getPlotLinePath(e, !0)) : (d = Math.max(d, this.min), e = Math.min(e, this.max), B || (h[0] = this.translate(d), h[1] = this.translate(e)), h = q(h, function(a) {
					x.test(a) && (a = c(a, 10) * k / 100);
					return a
				}), "circle" !== b.shape && B ? (d = m + this.translate(d), e = m + this.translate(e)) : (d = -Math.PI / 2, e = 1.5 * Math.PI, t = !0), h[0] -= p, h[2] -= p, f = this.chart.renderer.symbols.arc(this.left + f[0], this.top + f[1], h[0], h[0], {
					start: Math.min(d, e),
					end: Math.max(d, e),
					innerR: a(h[1], h[0] - h[2]),
					open: t
				}));
				return f
			},
			getPlotLinePath: function(a, c) {
				var d = this,
					e = d.center,
					f = d.chart,
					b = d.getPosition(a),
					h, m, k;
				d.isCircular ? k = ["M", e[0] + f.plotLeft, e[1] + f.plotTop, "L", b.x, b.y] : "circle" === d.options.gridLineInterpolation ? (a = d.translate(a)) && (k = d.getLinePath(0, a)) : (u(f.xAxis, function(a) {
					a.pane === d.pane && (h = a)
				}), k = [], a = d.translate(a), e = h.tickPositions, h.autoConnect && (e = e.concat([e[0]])), c && (e = [].concat(e).reverse()), u(e, function(c, d) {
					m = h.getPosition(c, a);
					k.push(d ? "L" : "M", m.x, m.y)
				}));
				return k
			},
			getTitlePosition: function() {
				var a = this.center,
					c = this.chart,
					d = this.options.title;
				return {
					x: c.plotLeft + a[0] + (d.x || 0),
					y: c.plotTop + a[1] - {
						high: .5,
						middle: .25,
						low: 0
					}[d.align] * a[2] + (d.y || 0)
				}
			}
		}, r(v, "init", function(a) {
			var c = this.chart,
				d = c.angular,
				f = c.polar,
				b = this.isXAxis,
				h = d && b,
				k, m = c.options;
			a = a.userOptions.pane || 0;
			a = this.pane = c.pane && c.pane[a];
			if(d) {
				if(n(this, h ? e : p), k = !b) this.defaultRadialOptions = this.defaultRadialGaugeOptions
			} else f && (n(this, p), this.defaultRadialOptions = (k = b) ? this.defaultRadialXOptions : g(this.defaultYAxisOptions, this.defaultRadialYOptions));
			d || f ? (this.isRadial = !0, c.inverted = !1, m.chart.zoomType = null) :
				this.isRadial = !1;
			a && k && (a.axis = this);
			this.isCircular = k
		}), r(v, "afterInit", function() {
			var c = this.chart,
				d = this.options,
				e = this.pane,
				f = e && e.options;
			c.angular && this.isXAxis || !e || !c.angular && !c.polar || (this.angleRad = (d.angle || 0) * Math.PI / 180, this.startAngleRad = (f.startAngle - 90) * Math.PI / 180, this.endAngleRad = (a(f.endAngle, f.startAngle + 360) - 90) * Math.PI / 180, this.offset = d.offset || 0)
		}), k(t, "autoLabelAlign", function(a) {
			if(!this.isRadial) return a.apply(this, [].slice.call(arguments, 1))
		}), r(d, "afterGetPosition", function(a) {
			this.axis.getPosition &&
				n(a.pos, this.axis.getPosition(this.pos))
		}), r(d, "afterGetLabelPosition", function(c) {
			var d = this.axis,
				e = this.label,
				f = d.options.labels,
				b = f.y,
				h, k = 20,
				p = f.align,
				m = (d.translate(this.pos) + d.startAngleRad + Math.PI / 2) / Math.PI * 180 % 360;
			d.isRadial && (h = d.getPosition(this.pos, d.center[2] / 2 + a(f.distance, -25)), "auto" === f.rotation ? e.attr({
				rotation: m
			}) : null === b && (b = d.chart.renderer.fontMetrics(e.styles && e.styles.fontSize).b - e.getBBox().height / 2), null === p && (d.isCircular ? (this.label.getBBox().width > d.len * d.tickInterval /
				(d.max - d.min) && (k = 0), p = m > k && m < 180 - k ? "left" : m > 180 + k && m < 360 - k ? "right" : "center") : p = "center", e.attr({
				align: p
			})), c.pos.x = h.x + f.x, c.pos.y = h.y + b)
		}), k(h, "getMarkPath", function(a, c, d, e, f, b, h) {
			var k = this.axis;
			k.isRadial ? (a = k.getPosition(this.pos, k.center[2] / 2 + e), c = ["M", c, d, "L", a.x, a.y]) : c = a.call(this, c, d, e, f, b, h);
			return c
		}))
	})(w);
	(function(b) {
		var r = b.each,
			v = b.pick,
			u = b.defined,
			n = b.seriesType,
			q = b.seriesTypes,
			g = b.Series.prototype,
			l = b.Point.prototype;
		n("arearange", "area", {
			lineWidth: 1,
			threshold: null,
			tooltip: {
				pointFormat: '\x3cspan style\x3d"color:{series.color}"\x3e\u25cf\x3c/span\x3e {series.name}: \x3cb\x3e{point.low}\x3c/b\x3e - \x3cb\x3e{point.high}\x3c/b\x3e\x3cbr/\x3e'
			},
			trackByArea: !0,
			dataLabels: {
				align: null,
				verticalAlign: null,
				xLow: 0,
				xHigh: 0,
				yLow: 0,
				yHigh: 0
			}
		}, {
			pointArrayMap: ["low", "high"],
			dataLabelCollections: ["dataLabel", "dataLabelUpper"],
			toYData: function(a) {
				return [a.low, a.high]
			},
			pointValKey: "low",
			deferTranslatePolar: !0,
			highToXY: function(a) {
				var c = this.chart,
					d = this.xAxis.postTranslate(a.rectPlotX, this.yAxis.len - a.plotHigh);
				a.plotHighX = d.x - c.plotLeft;
				a.plotHigh = d.y - c.plotTop;
				a.plotLowX = a.plotX
			},
			translate: function() {
				var a = this,
					c = a.yAxis,
					d = !!a.modifyValue;
				q.area.prototype.translate.apply(a);
				r(a.points, function(b) {
					var f = b.low,
						e = b.high,
						k = b.plotY;
					null === e || null === f ? (b.isNull = !0, b.plotY = null) : (b.plotLow = k, b.plotHigh = c.translate(d ? a.modifyValue(e, b) : e, 0, 1, 0, 1), d && (b.yBottom = b.plotHigh))
				});
				this.chart.polar && r(this.points, function(c) {
					a.highToXY(c);
					c.tooltipPos = [(c.plotHighX + c.plotLowX) / 2, (c.plotHigh + c.plotLow) / 2]
				})
			},
			getGraphPath: function(a) {
				var c = [],
					d = [],
					b, f = q.area.prototype.getGraphPath,
					e, p, t;
				t = this.options;
				var h = this.chart.polar && !1 !== t.connectEnds,
					m = t.connectNulls,
					x = t.step;
				a = a || this.points;
				for(b = a.length; b--;) e = a[b], e.isNull || h || m || a[b + 1] && !a[b + 1].isNull || d.push({
					plotX: e.plotX,
					plotY: e.plotY,
					doCurve: !1
				}), p = {
					polarPlotY: e.polarPlotY,
					rectPlotX: e.rectPlotX,
					yBottom: e.yBottom,
					plotX: v(e.plotHighX, e.plotX),
					plotY: e.plotHigh,
					isNull: e.isNull
				}, d.push(p), c.push(p), e.isNull || h || m || a[b - 1] && !a[b - 1].isNull || d.push({
					plotX: e.plotX,
					plotY: e.plotY,
					doCurve: !1
				});
				a = f.call(this, a);
				x && (!0 === x && (x = "left"), t.step = {
					left: "right",
					center: "center",
					right: "left"
				}[x]);
				c = f.call(this, c);
				d = f.call(this, d);
				t.step = x;
				t = [].concat(a,
					c);
				this.chart.polar || "M" !== d[0] || (d[0] = "L");
				this.graphPath = t;
				this.areaPath = a.concat(d);
				t.isArea = !0;
				t.xMap = a.xMap;
				this.areaPath.xMap = a.xMap;
				return t
			},
			drawDataLabels: function() {
				var a = this.data,
					c = a.length,
					d, b = [],
					f = this.options.dataLabels,
					e = f.align,
					p = f.verticalAlign,
					t = f.inside,
					h, m, x = this.chart.inverted;
				if(f.enabled || this._hasPointLabels) {
					for(d = c; d--;)
						if(h = a[d]) m = t ? h.plotHigh < h.plotLow : h.plotHigh > h.plotLow, h.y = h.high, h._plotY = h.plotY, h.plotY = h.plotHigh, b[d] = h.dataLabel, h.dataLabel = h.dataLabelUpper, h.below =
							m, x ? e || (f.align = m ? "right" : "left") : p || (f.verticalAlign = m ? "top" : "bottom"), f.x = f.xHigh, f.y = f.yHigh;
					g.drawDataLabels && g.drawDataLabels.apply(this, arguments);
					for(d = c; d--;)
						if(h = a[d]) m = t ? h.plotHigh < h.plotLow : h.plotHigh > h.plotLow, h.dataLabelUpper = h.dataLabel, h.dataLabel = b[d], h.y = h.low, h.plotY = h._plotY, h.below = !m, x ? e || (f.align = m ? "left" : "right") : p || (f.verticalAlign = m ? "bottom" : "top"), f.x = f.xLow, f.y = f.yLow;
					g.drawDataLabels && g.drawDataLabels.apply(this, arguments)
				}
				f.align = e;
				f.verticalAlign = p
			},
			alignDataLabel: function() {
				q.column.prototype.alignDataLabel.apply(this,
					arguments)
			},
			drawPoints: function() {
				var a = this.points.length,
					c, d;
				g.drawPoints.apply(this, arguments);
				for(d = 0; d < a;) c = this.points[d], c.origProps = {
					plotY: c.plotY,
					plotX: c.plotX,
					isInside: c.isInside,
					negative: c.negative,
					zone: c.zone,
					y: c.y
				}, c.lowerGraphic = c.graphic, c.graphic = c.upperGraphic, c.plotY = c.plotHigh, u(c.plotHighX) && (c.plotX = c.plotHighX), c.y = c.high, c.negative = c.high < (this.options.threshold || 0), c.zone = this.zones.length && c.getZone(), this.chart.polar || (c.isInside = c.isTopInside = void 0 !== c.plotY && 0 <= c.plotY &&
					c.plotY <= this.yAxis.len && 0 <= c.plotX && c.plotX <= this.xAxis.len), d++;
				g.drawPoints.apply(this, arguments);
				for(d = 0; d < a;) c = this.points[d], c.upperGraphic = c.graphic, c.graphic = c.lowerGraphic, b.extend(c, c.origProps), delete c.origProps, d++
			},
			setStackedPoints: b.noop
		}, {
			setState: function() {
				var a = this.state,
					c = this.series,
					d = c.chart.polar;
				u(this.plotHigh) || (this.plotHigh = c.yAxis.toPixels(this.high, !0));
				u(this.plotLow) || (this.plotLow = this.plotY = c.yAxis.toPixels(this.low, !0));
				c.stateMarkerGraphic && (c.lowerStateMarkerGraphic =
					c.stateMarkerGraphic, c.stateMarkerGraphic = c.upperStateMarkerGraphic);
				this.graphic = this.upperGraphic;
				this.plotY = this.plotHigh;
				d && (this.plotX = this.plotHighX);
				l.setState.apply(this, arguments);
				this.state = a;
				this.plotY = this.plotLow;
				this.graphic = this.lowerGraphic;
				d && (this.plotX = this.plotLowX);
				c.stateMarkerGraphic && (c.upperStateMarkerGraphic = c.stateMarkerGraphic, c.stateMarkerGraphic = c.lowerStateMarkerGraphic, c.lowerStateMarkerGraphic = void 0);
				l.setState.apply(this, arguments)
			},
			haloPath: function() {
				var a = this.series.chart.polar,
					c = [];
				this.plotY = this.plotLow;
				a && (this.plotX = this.plotLowX);
				this.isInside && (c = l.haloPath.apply(this, arguments));
				this.plotY = this.plotHigh;
				a && (this.plotX = this.plotHighX);
				this.isTopInside && (c = c.concat(l.haloPath.apply(this, arguments)));
				return c
			},
			destroyElements: function() {
				r(["lowerGraphic", "upperGraphic"], function(a) {
					this[a] && (this[a] = this[a].destroy())
				}, this);
				this.graphic = null;
				return l.destroyElements.apply(this, arguments)
			}
		})
	})(w);
	(function(b) {
		var r = b.seriesType;
		r("areasplinerange", "arearange", null, {
			getPointSpline: b.seriesTypes.spline.prototype.getPointSpline
		})
	})(w);
	(function(b) {
		var r = b.defaultPlotOptions,
			v = b.each,
			u = b.merge,
			n = b.noop,
			q = b.pick,
			g = b.seriesType,
			l = b.seriesTypes.column.prototype;
		g("columnrange", "arearange", u(r.column, r.arearange, {
			pointRange: null,
			marker: null,
			states: {
				hover: {
					halo: !1
				}
			}
		}), {
			translate: function() {
				var a = this,
					c = a.yAxis,
					d = a.xAxis,
					b = d.startAngleRad,
					f, e = a.chart,
					p = a.xAxis.isRadial,
					t = Math.max(e.chartWidth, e.chartHeight) + 999,
					h;
				l.translate.apply(a);
				v(a.points, function(k) {
					var m = k.shapeArgs,
						l = a.options.minPointLength,
						y, g;
					k.plotHigh = h = Math.min(Math.max(-t, c.translate(k.high, 0, 1, 0, 1)), t);
					k.plotLow = Math.min(Math.max(-t, k.plotY), t);
					g = h;
					y = q(k.rectPlotY, k.plotY) - h;
					Math.abs(y) < l ? (l -= y, y += l, g -= l / 2) : 0 > y && (y *= -1, g -= y);
					p ? (f = k.barX + b, k.shapeType = "path", k.shapeArgs = {
						d: a.polarArc(g + y, g, f, f + k.pointWidth)
					}) : (m.height = y, m.y = g, k.tooltipPos = e.inverted ? [c.len + c.pos - e.plotLeft - g - y / 2, d.len + d.pos - e.plotTop - m.x - m.width / 2, y] : [d.left - e.plotLeft + m.x + m.width / 2, c.pos - e.plotTop + g + y / 2, y])
				})
			},
			directTouch: !0,
			trackerGroups: ["group",
				"dataLabelsGroup"
			],
			drawGraph: n,
			getSymbol: n,
			crispCol: l.crispCol,
			drawPoints: l.drawPoints,
			drawTracker: l.drawTracker,
			getColumnMetrics: l.getColumnMetrics,
			pointAttribs: l.pointAttribs,
			animate: function() {
				return l.animate.apply(this, arguments)
			},
			polarArc: function() {
				return l.polarArc.apply(this, arguments)
			},
			translate3dPoints: function() {
				return l.translate3dPoints.apply(this, arguments)
			},
			translate3dShapes: function() {
				return l.translate3dShapes.apply(this, arguments)
			}
		}, {
			setState: l.pointClass.prototype.setState
		})
	})(w);
	(function(b) {
		var r = b.each,
			v = b.isNumber,
			u = b.merge,
			n = b.pick,
			q = b.pInt,
			g = b.Series,
			l = b.seriesType,
			a = b.TrackerMixin;
		l("gauge", "line", {
			dataLabels: {
				enabled: !0,
				defer: !1,
				y: 15,
				borderRadius: 3,
				crop: !1,
				verticalAlign: "top",
				zIndex: 2,
				borderWidth: 1,
				borderColor: "#cccccc"
			},
			dial: {},
			pivot: {},
			tooltip: {
				headerFormat: ""
			},
			showInLegend: !1
		}, {
			angular: !0,
			directTouch: !0,
			drawGraph: b.noop,
			fixedBox: !0,
			forceDL: !0,
			noSharedTooltip: !0,
			trackerGroups: ["group", "dataLabelsGroup"],
			translate: function() {
				var a = this.yAxis,
					d = this.options,
					b = a.center;
				this.generatePoints();
				r(this.points, function(c) {
					var e = u(d.dial, c.dial),
						f = q(n(e.radius, 80)) * b[2] / 200,
						k = q(n(e.baseLength, 70)) * f / 100,
						h = q(n(e.rearLength, 10)) * f / 100,
						m = e.baseWidth || 3,
						x = e.topWidth || 1,
						g = d.overshoot,
						l = a.startAngleRad + a.translate(c.y, null, null, null, !0);
					v(g) ? (g = g / 180 * Math.PI, l = Math.max(a.startAngleRad - g, Math.min(a.endAngleRad + g, l))) : !1 === d.wrap && (l = Math.max(a.startAngleRad, Math.min(a.endAngleRad, l)));
					l = 180 * l / Math.PI;
					c.shapeType = "path";
					c.shapeArgs = {
						d: e.path || ["M", -h, -m / 2, "L", k, -m / 2, f, -x / 2, f,
							x / 2, k, m / 2, -h, m / 2, "z"
						],
						translateX: b[0],
						translateY: b[1],
						rotation: l
					};
					c.plotX = b[0];
					c.plotY = b[1]
				})
			},
			drawPoints: function() {
				var a = this,
					d = a.yAxis.center,
					b = a.pivot,
					f = a.options,
					e = f.pivot,
					p = a.chart.renderer;
				r(a.points, function(c) {
					var d = c.graphic,
						b = c.shapeArgs,
						e = b.d,
						k = u(f.dial, c.dial);
					d ? (d.animate(b), b.d = e) : (c.graphic = p[c.shapeType](b).attr({
						rotation: b.rotation,
						zIndex: 1
					}).addClass("highcharts-dial").add(a.group), c.graphic.attr({
						stroke: k.borderColor || "none",
						"stroke-width": k.borderWidth || 0,
						fill: k.backgroundColor ||
							"#000000"
					}))
				});
				b ? b.animate({
					translateX: d[0],
					translateY: d[1]
				}) : (a.pivot = p.circle(0, 0, n(e.radius, 5)).attr({
					zIndex: 2
				}).addClass("highcharts-pivot").translate(d[0], d[1]).add(a.group), a.pivot.attr({
					"stroke-width": e.borderWidth || 0,
					stroke: e.borderColor || "#cccccc",
					fill: e.backgroundColor || "#000000"
				}))
			},
			animate: function(a) {
				var c = this;
				a || (r(c.points, function(a) {
						var d = a.graphic;
						d && (d.attr({
							rotation: 180 * c.yAxis.startAngleRad / Math.PI
						}), d.animate({
							rotation: a.shapeArgs.rotation
						}, c.options.animation))
					}), c.animate =
					null)
			},
			render: function() {
				this.group = this.plotGroup("group", "series", this.visible ? "visible" : "hidden", this.options.zIndex, this.chart.seriesGroup);
				g.prototype.render.call(this);
				this.group.clip(this.chart.clipRect)
			},
			setData: function(a, d) {
				g.prototype.setData.call(this, a, !1);
				this.processData();
				this.generatePoints();
				n(d, !0) && this.chart.redraw()
			},
			drawTracker: a && a.drawTrackerPoint
		}, {
			setState: function(a) {
				this.state = a
			}
		})
	})(w);
	(function(b) {
		var r = b.each,
			v = b.noop,
			u = b.pick,
			n = b.seriesType,
			q = b.seriesTypes;
		n("boxplot",
			"column", {
				threshold: null,
				tooltip: {
					pointFormat: '\x3cspan style\x3d"color:{point.color}"\x3e\u25cf\x3c/span\x3e \x3cb\x3e {series.name}\x3c/b\x3e\x3cbr/\x3eMaximum: {point.high}\x3cbr/\x3eUpper quartile: {point.q3}\x3cbr/\x3eMedian: {point.median}\x3cbr/\x3eLower quartile: {point.q1}\x3cbr/\x3eMinimum: {point.low}\x3cbr/\x3e'
				},
				whiskerLength: "50%",
				fillColor: "#ffffff",
				lineWidth: 1,
				medianWidth: 2,
				whiskerWidth: 2
			}, {
				pointArrayMap: ["low", "q1", "median", "q3", "high"],
				toYData: function(b) {
					return [b.low, b.q1, b.median,
						b.q3, b.high
					]
				},
				pointValKey: "high",
				pointAttribs: function() {
					return {}
				},
				drawDataLabels: v,
				translate: function() {
					var b = this.yAxis,
						l = this.pointArrayMap;
					q.column.prototype.translate.apply(this);
					r(this.points, function(a) {
						r(l, function(c) {
							null !== a[c] && (a[c + "Plot"] = b.translate(a[c], 0, 1, 0, 1))
						})
					})
				},
				drawPoints: function() {
					var b = this,
						l = b.options,
						a = b.chart.renderer,
						c, d, k, f, e, p, t = 0,
						h, m, x, q, n = !1 !== b.doQuartiles,
						v, A = b.options.whiskerLength;
					r(b.points, function(g) {
						var r = g.graphic,
							y = r ? "animate" : "attr",
							B = g.shapeArgs,
							w = {},
							D = {},
							J = {},
							K = {},
							C = g.color || b.color;
						void 0 !== g.plotY && (h = B.width, m = Math.floor(B.x), x = m + h, q = Math.round(h / 2), c = Math.floor(n ? g.q1Plot : g.lowPlot), d = Math.floor(n ? g.q3Plot : g.lowPlot), k = Math.floor(g.highPlot), f = Math.floor(g.lowPlot), r || (g.graphic = r = a.g("point").add(b.group), g.stem = a.path().addClass("highcharts-boxplot-stem").add(r), A && (g.whiskers = a.path().addClass("highcharts-boxplot-whisker").add(r)), n && (g.box = a.path(void 0).addClass("highcharts-boxplot-box").add(r)), g.medianShape = a.path(void 0).addClass("highcharts-boxplot-median").add(r)),
							D.stroke = g.stemColor || l.stemColor || C, D["stroke-width"] = u(g.stemWidth, l.stemWidth, l.lineWidth), D.dashstyle = g.stemDashStyle || l.stemDashStyle, g.stem.attr(D), A && (J.stroke = g.whiskerColor || l.whiskerColor || C, J["stroke-width"] = u(g.whiskerWidth, l.whiskerWidth, l.lineWidth), g.whiskers.attr(J)), n && (w.fill = g.fillColor || l.fillColor || C, w.stroke = l.lineColor || C, w["stroke-width"] = l.lineWidth || 0, g.box.attr(w)), K.stroke = g.medianColor || l.medianColor || C, K["stroke-width"] = u(g.medianWidth, l.medianWidth, l.lineWidth), g.medianShape.attr(K),
							p = g.stem.strokeWidth() % 2 / 2, t = m + q + p, g.stem[y]({
								d: ["M", t, d, "L", t, k, "M", t, c, "L", t, f]
							}), n && (p = g.box.strokeWidth() % 2 / 2, c = Math.floor(c) + p, d = Math.floor(d) + p, m += p, x += p, g.box[y]({
								d: ["M", m, d, "L", m, c, "L", x, c, "L", x, d, "L", m, d, "z"]
							})), A && (p = g.whiskers.strokeWidth() % 2 / 2, k += p, f += p, v = /%$/.test(A) ? q * parseFloat(A) / 100 : A / 2, g.whiskers[y]({
								d: ["M", t - v, k, "L", t + v, k, "M", t - v, f, "L", t + v, f]
							})), e = Math.round(g.medianPlot), p = g.medianShape.strokeWidth() % 2 / 2, e += p, g.medianShape[y]({
								d: ["M", m, e, "L", x, e]
							}))
					})
				},
				setStackedPoints: v
			})
	})(w);
	(function(b) {
		var r = b.each,
			v = b.noop,
			u = b.seriesType,
			n = b.seriesTypes;
		u("errorbar", "boxplot", {
			color: "#000000",
			grouping: !1,
			linkedTo: ":previous",
			tooltip: {
				pointFormat: '\x3cspan style\x3d"color:{point.color}"\x3e\u25cf\x3c/span\x3e {series.name}: \x3cb\x3e{point.low}\x3c/b\x3e - \x3cb\x3e{point.high}\x3c/b\x3e\x3cbr/\x3e'
			},
			whiskerWidth: null
		}, {
			type: "errorbar",
			pointArrayMap: ["low", "high"],
			toYData: function(b) {
				return [b.low, b.high]
			},
			pointValKey: "high",
			doQuartiles: !1,
			drawDataLabels: n.arearange ? function() {
				var b =
					this.pointValKey;
				n.arearange.prototype.drawDataLabels.call(this);
				r(this.data, function(g) {
					g.y = g[b]
				})
			} : v,
			getColumnMetrics: function() {
				return this.linkedParent && this.linkedParent.columnMetrics || n.column.prototype.getColumnMetrics.call(this)
			}
		})
	})(w);
	(function(b) {
		var r = b.correctFloat,
			v = b.isNumber,
			u = b.pick,
			n = b.Point,
			q = b.Series,
			g = b.seriesType,
			l = b.seriesTypes;
		g("waterfall", "column", {
			dataLabels: {
				inside: !0
			},
			lineWidth: 1,
			lineColor: "#333333",
			dashStyle: "dot",
			borderColor: "#333333",
			states: {
				hover: {
					lineWidthPlus: 0
				}
			}
		}, {
			pointValKey: "y",
			showLine: !0,
			translate: function() {
				var a = this.options,
					c = this.yAxis,
					b, k, f, e, p, t, h, m, g, n, q = u(a.minPointLength, 5),
					v = q / 2,
					w = a.threshold,
					F = a.stacking,
					z;
				l.column.prototype.translate.apply(this);
				m = g = w;
				k = this.points;
				b = 0;
				for(a = k.length; b < a; b++) f = k[b], h = this.processedYData[b], e = f.shapeArgs, p = F && c.stacks[(this.negStacks && h < w ? "-" : "") + this.stackKey], z = this.getStackIndicator(z, f.x, this.index), n = u(p && p[f.x].points[z.key], [0, h]), f.isSum ? f.y = r(h) : f.isIntermediateSum && (f.y = r(h - g)), t = Math.max(m, m + f.y) +
					n[0], e.y = c.translate(t, 0, 1, 0, 1), f.isSum ? (e.y = c.translate(n[1], 0, 1, 0, 1), e.height = Math.min(c.translate(n[0], 0, 1, 0, 1), c.len) - e.y) : f.isIntermediateSum ? (e.y = c.translate(n[1], 0, 1, 0, 1), e.height = Math.min(c.translate(g, 0, 1, 0, 1), c.len) - e.y, g = n[1]) : (e.height = 0 < h ? c.translate(m, 0, 1, 0, 1) - e.y : c.translate(m, 0, 1, 0, 1) - c.translate(m - h, 0, 1, 0, 1), m += p && p[f.x] ? p[f.x].total : h), 0 > e.height && (e.y += e.height, e.height *= -1), f.plotY = e.y = Math.round(e.y) - this.borderWidth % 2 / 2, e.height = Math.max(Math.round(e.height), .001), f.yBottom =
					e.y + e.height, e.height <= q && !f.isNull ? (e.height = q, e.y -= v, f.plotY = e.y, f.minPointLengthOffset = 0 > f.y ? -v : v) : f.minPointLengthOffset = 0, e = f.plotY + (f.negative ? e.height : 0), this.chart.inverted ? f.tooltipPos[0] = c.len - e : f.tooltipPos[1] = e
			},
			processData: function(a) {
				var c = this.yData,
					b = this.options.data,
					k, f = c.length,
					e, p, t, h, m, g;
				p = e = t = h = this.options.threshold || 0;
				for(g = 0; g < f; g++) m = c[g], k = b && b[g] ? b[g] : {}, "sum" === m || k.isSum ? c[g] = r(p) : "intermediateSum" === m || k.isIntermediateSum ? c[g] = r(e) : (p += m, e += m), t = Math.min(p, t), h = Math.max(p,
					h);
				q.prototype.processData.call(this, a);
				this.options.stacking || (this.dataMin = t, this.dataMax = h)
			},
			toYData: function(a) {
				return a.isSum ? 0 === a.x ? null : "sum" : a.isIntermediateSum ? 0 === a.x ? null : "intermediateSum" : a.y
			},
			pointAttribs: function(a, c) {
				var b = this.options.upColor;
				b && !a.options.color && (a.color = 0 < a.y ? b : null);
				a = l.column.prototype.pointAttribs.call(this, a, c);
				delete a.dashstyle;
				return a
			},
			getGraphPath: function() {
				return ["M", 0, 0]
			},
			getCrispPath: function() {
				var a = this.data,
					c = a.length,
					b = this.graph.strokeWidth() +
					this.borderWidth,
					b = Math.round(b) % 2 / 2,
					k = this.xAxis.reversed,
					f = this.yAxis.reversed,
					e = [],
					p, g, h;
				for(h = 1; h < c; h++) {
					g = a[h].shapeArgs;
					p = a[h - 1].shapeArgs;
					g = ["M", p.x + (k ? 0 : p.width), p.y + a[h - 1].minPointLengthOffset + b, "L", g.x + (k ? p.width : 0), p.y + a[h - 1].minPointLengthOffset + b];
					if(0 > a[h - 1].y && !f || 0 < a[h - 1].y && f) g[2] += p.height, g[5] += p.height;
					e = e.concat(g)
				}
				return e
			},
			drawGraph: function() {
				q.prototype.drawGraph.call(this);
				this.graph.attr({
					d: this.getCrispPath()
				})
			},
			setStackedPoints: function() {
				var a = this.options,
					c, b;
				q.prototype.setStackedPoints.apply(this,
					arguments);
				c = this.stackedYData ? this.stackedYData.length : 0;
				for(b = 1; b < c; b++) a.data[b].isSum || a.data[b].isIntermediateSum || (this.stackedYData[b] += this.stackedYData[b - 1])
			},
			getExtremes: function() {
				if(this.options.stacking) return q.prototype.getExtremes.apply(this, arguments)
			}
		}, {
			getClassName: function() {
				var a = n.prototype.getClassName.call(this);
				this.isSum ? a += " highcharts-sum" : this.isIntermediateSum && (a += " highcharts-intermediate-sum");
				return a
			},
			isValid: function() {
				return v(this.y, !0) || this.isSum || this.isIntermediateSum
			}
		})
	})(w);
	(function(b) {
		var r = b.Series,
			v = b.seriesType,
			u = b.seriesTypes;
		v("polygon", "scatter", {
			marker: {
				enabled: !1,
				states: {
					hover: {
						enabled: !1
					}
				}
			},
			stickyTracking: !1,
			tooltip: {
				followPointer: !0,
				pointFormat: ""
			},
			trackByArea: !0
		}, {
			type: "polygon",
			getGraphPath: function() {
				for(var b = r.prototype.getGraphPath.call(this), q = b.length + 1; q--;)(q === b.length || "M" === b[q]) && 0 < q && b.splice(q, 0, "z");
				return this.areaPath = b
			},
			drawGraph: function() {
				this.options.fillColor = this.color;
				u.area.prototype.drawGraph.call(this)
			},
			drawLegendSymbol: b.LegendSymbolMixin.drawRectangle,
			drawTracker: r.prototype.drawTracker,
			setStackedPoints: b.noop
		})
	})(w);
	(function(b) {
		var r = b.arrayMax,
			v = b.arrayMin,
			u = b.Axis,
			n = b.color,
			q = b.each,
			g = b.isNumber,
			l = b.noop,
			a = b.pick,
			c = b.pInt,
			d = b.Point,
			k = b.Series,
			f = b.seriesType,
			e = b.seriesTypes;
		f("bubble", "scatter", {
			dataLabels: {
				formatter: function() {
					return this.point.z
				},
				inside: !0,
				verticalAlign: "middle"
			},
			animationLimit: 250,
			marker: {
				lineColor: null,
				lineWidth: 1,
				fillOpacity: .5,
				radius: null,
				states: {
					hover: {
						radiusPlus: 0
					}
				},
				symbol: "circle"
			},
			minSize: 8,
			maxSize: "20%",
			softThreshold: !1,
			states: {
				hover: {
					halo: {
						size: 5
					}
				}
			},
			tooltip: {
				pointFormat: "({point.x}, {point.y}), Size: {point.z}"
			},
			turboThreshold: 0,
			zThreshold: 0,
			zoneAxis: "z"
		}, {
			pointArrayMap: ["y", "z"],
			parallelArrays: ["x", "y", "z"],
			trackerGroups: ["group", "dataLabelsGroup"],
			specialGroup: "group",
			bubblePadding: !0,
			zoneAxis: "z",
			directTouch: !0,
			pointAttribs: function(a, c) {
				var b = this.options.marker.fillOpacity;
				a = k.prototype.pointAttribs.call(this, a, c);
				1 !== b && (a.fill = n(a.fill).setOpacity(b).get("rgba"));
				return a
			},
			getRadii: function(a, c, b, d) {
				var e,
					f, h, k = this.zData,
					g = [],
					p = this.options,
					m = "width" !== p.sizeBy,
					t = p.zThreshold,
					l = c - a;
				f = 0;
				for(e = k.length; f < e; f++) h = k[f], p.sizeByAbsoluteValue && null !== h && (h = Math.abs(h - t), c = l = Math.max(c - t, Math.abs(a - t)), a = 0), null === h ? h = null : h < a ? h = b / 2 - 1 : (h = 0 < l ? (h - a) / l : .5, m && 0 <= h && (h = Math.sqrt(h)), h = Math.ceil(b + h * (d - b)) / 2), g.push(h);
				this.radii = g
			},
			animate: function(a) {
				!a && this.points.length < this.options.animationLimit && (q(this.points, function(a) {
					var c = a.graphic,
						b;
					c && c.width && (b = {
						x: c.x,
						y: c.y,
						width: c.width,
						height: c.height
					}, c.attr({
						x: a.plotX,
						y: a.plotY,
						width: 1,
						height: 1
					}), c.animate(b, this.options.animation))
				}, this), this.animate = null)
			},
			translate: function() {
				var a, c = this.data,
					d, f, k = this.radii;
				e.scatter.prototype.translate.call(this);
				for(a = c.length; a--;) d = c[a], f = k ? k[a] : 0, g(f) && f >= this.minPxSize / 2 ? (d.marker = b.extend(d.marker, {
					radius: f,
					width: 2 * f,
					height: 2 * f
				}), d.dlBox = {
					x: d.plotX - f,
					y: d.plotY - f,
					width: 2 * f,
					height: 2 * f
				}) : d.shapeArgs = d.plotY = d.dlBox = void 0
			},
			alignDataLabel: e.column.prototype.alignDataLabel,
			buildKDTree: l,
			applyZones: l
		}, {
			haloPath: function(a) {
				return d.prototype.haloPath.call(this,
					0 === a ? 0 : (this.marker ? this.marker.radius || 0 : 0) + a)
			},
			ttBelow: !1
		});
		u.prototype.beforePadding = function() {
			var b = this,
				d = this.len,
				e = this.chart,
				f = 0,
				k = d,
				l = this.isXAxis,
				n = l ? "xData" : "yData",
				u = this.min,
				w = {},
				F = Math.min(e.plotWidth, e.plotHeight),
				z = Number.MAX_VALUE,
				G = -Number.MAX_VALUE,
				H = this.max - u,
				E = d / H,
				I = [];
			q(this.series, function(d) {
				var f = d.options;
				!d.bubblePadding || !d.visible && e.options.chart.ignoreHiddenSeries || (b.allowZoomOutside = !0, I.push(d), l && (q(["minSize", "maxSize"], function(a) {
					var b = f[a],
						d = /%$/.test(b),
						b = c(b);
					w[a] = d ? F * b / 100 : b
				}), d.minPxSize = w.minSize, d.maxPxSize = Math.max(w.maxSize, w.minSize), d = d.zData, d.length && (z = a(f.zMin, Math.min(z, Math.max(v(d), !1 === f.displayNegative ? f.zThreshold : -Number.MAX_VALUE))), G = a(f.zMax, Math.max(G, r(d))))))
			});
			q(I, function(a) {
				var c = a[n],
					d = c.length,
					e;
				l && a.getRadii(z, G, a.minPxSize, a.maxPxSize);
				if(0 < H)
					for(; d--;) g(c[d]) && b.dataMin <= c[d] && c[d] <= b.dataMax && (e = a.radii[d], f = Math.min((c[d] - u) * E - e, f), k = Math.max((c[d] - u) * E + e, k))
			});
			I.length && 0 < H && !this.isLog && (k -= d, E *= (d + f - k) / d, q([
				["min",
					"userMin", f
				],
				["max", "userMax", k]
			], function(c) {
				void 0 === a(b.options[c[0]], b[c[1]]) && (b[c[0]] += c[2] / E)
			}))
		}
	})(w);
	(function(b) {
		var r = b.each,
			v = b.pick,
			u = b.Series,
			n = b.seriesTypes,
			q = b.wrap,
			g = u.prototype,
			l = b.Pointer.prototype;
		b.polarExtended || (b.polarExtended = !0, g.searchPointByAngle = function(a) {
				var c = this.chart,
					b = this.xAxis.pane.center;
				return this.searchKDTree({
					clientX: 180 + -180 / Math.PI * Math.atan2(a.chartX - b[0] - c.plotLeft, a.chartY - b[1] - c.plotTop)
				})
			}, g.getConnectors = function(a, c, b, k) {
				var d, e, g, l, h, m, n, q;
				e = k ?
					1 : 0;
				d = 0 <= c && c <= a.length - 1 ? c : 0 > c ? a.length - 1 + c : 0;
				c = 0 > d - 1 ? a.length - (1 + e) : d - 1;
				e = d + 1 > a.length - 1 ? e : d + 1;
				g = a[c];
				e = a[e];
				l = g.plotX;
				g = g.plotY;
				h = e.plotX;
				m = e.plotY;
				e = a[d].plotX;
				d = a[d].plotY;
				l = (1.5 * e + l) / 2.5;
				g = (1.5 * d + g) / 2.5;
				h = (1.5 * e + h) / 2.5;
				n = (1.5 * d + m) / 2.5;
				m = Math.sqrt(Math.pow(l - e, 2) + Math.pow(g - d, 2));
				q = Math.sqrt(Math.pow(h - e, 2) + Math.pow(n - d, 2));
				l = Math.atan2(g - d, l - e);
				n = Math.PI / 2 + (l + Math.atan2(n - d, h - e)) / 2;
				Math.abs(l - n) > Math.PI / 2 && (n -= Math.PI);
				l = e + Math.cos(n) * m;
				g = d + Math.sin(n) * m;
				h = e + Math.cos(Math.PI + n) * q;
				n = d + Math.sin(Math.PI +
					n) * q;
				e = {
					rightContX: h,
					rightContY: n,
					leftContX: l,
					leftContY: g,
					plotX: e,
					plotY: d
				};
				b && (e.prevPointCont = this.getConnectors(a, c, !1, k));
				return e
			}, q(g, "buildKDTree", function(a) {
				this.chart.polar && (this.kdByAngle ? this.searchPoint = this.searchPointByAngle : this.options.findNearestPointBy = "xy");
				a.apply(this)
			}), g.toXY = function(a) {
				var c, b = this.chart,
					k = a.plotX;
				c = a.plotY;
				a.rectPlotX = k;
				a.rectPlotY = c;
				c = this.xAxis.postTranslate(a.plotX, this.yAxis.len - c);
				a.plotX = a.polarPlotX = c.x - b.plotLeft;
				a.plotY = a.polarPlotY = c.y - b.plotTop;
				this.kdByAngle ? (b = (k / Math.PI * 180 + this.xAxis.pane.options.startAngle) % 360, 0 > b && (b += 360), a.clientX = b) : a.clientX = a.plotX
			}, n.spline && (q(n.spline.prototype, "getPointSpline", function(a, c, b, k) {
				this.chart.polar ? k ? (a = this.getConnectors(c, k, !0, this.connectEnds), a = ["C", a.prevPointCont.rightContX, a.prevPointCont.rightContY, a.leftContX, a.leftContY, a.plotX, a.plotY]) : a = ["M", b.plotX, b.plotY] : a = a.call(this, c, b, k);
				return a
			}), n.areasplinerange && (n.areasplinerange.prototype.getPointSpline = n.spline.prototype.getPointSpline)),
			b.addEvent(u, "afterTranslate", function() {
				var a = this.chart,
					c, d;
				if(a.polar) {
					this.kdByAngle = a.tooltip && a.tooltip.shared;
					if(!this.preventPostTranslate)
						for(c = this.points, d = c.length; d--;) this.toXY(c[d]);
					this.hasClipCircleSetter || (this.hasClipCircleSetter = !!b.addEvent(this, "afterRender", function() {
						var c;
						a.polar && (c = this.yAxis.center, this.group.clip(a.renderer.clipCircle(c[0], c[1], c[2] / 2)), this.setClip = b.noop)
					}))
				}
			}), q(g, "getGraphPath", function(a, c) {
				var b = this,
					g, f, e;
				if(this.chart.polar) {
					c = c || this.points;
					for(g =
						0; g < c.length; g++)
						if(!c[g].isNull) {
							f = g;
							break
						}!1 !== this.options.connectEnds && void 0 !== f && (this.connectEnds = !0, c.splice(c.length, 0, c[f]), e = !0);
					r(c, function(a) {
						void 0 === a.polarPlotY && b.toXY(a)
					})
				}
				g = a.apply(this, [].slice.call(arguments, 1));
				e && c.pop();
				return g
			}), u = function(a, c) {
				var b = this.chart,
					g = this.options.animation,
					f = this.group,
					e = this.markerGroup,
					l = this.xAxis.center,
					n = b.plotLeft,
					h = b.plotTop;
				b.polar ? b.renderer.isSVG && (!0 === g && (g = {}), c ? (a = {
						translateX: l[0] + n,
						translateY: l[1] + h,
						scaleX: .001,
						scaleY: .001
					}, f.attr(a),
					e && e.attr(a)) : (a = {
					translateX: n,
					translateY: h,
					scaleX: 1,
					scaleY: 1
				}, f.animate(a, g), e && e.animate(a, g), this.animate = null)) : a.call(this, c)
			}, q(g, "animate", u), n.column && (n = n.column.prototype, n.polarArc = function(a, c, b, g) {
				var d = this.xAxis.center,
					e = this.yAxis.len;
				return this.chart.renderer.symbols.arc(d[0], d[1], e - c, null, {
					start: b,
					end: g,
					innerR: e - v(a, e)
				})
			}, q(n, "animate", u), q(n, "translate", function(a) {
				var c = this.xAxis,
					b = c.startAngleRad,
					g, f, e;
				this.preventPostTranslate = !0;
				a.call(this);
				if(c.isRadial)
					for(g = this.points,
						e = g.length; e--;) f = g[e], a = f.barX + b, f.shapeType = "path", f.shapeArgs = {
						d: this.polarArc(f.yBottom, f.plotY, a, a + f.pointWidth)
					}, this.toXY(f), f.tooltipPos = [f.plotX, f.plotY], f.ttBelow = f.plotY > c.center[1]
			}), q(n, "alignDataLabel", function(a, b, d, k, f, e) {
				this.chart.polar ? (a = b.rectPlotX / Math.PI * 180, null === k.align && (k.align = 20 < a && 160 > a ? "left" : 200 < a && 340 > a ? "right" : "center"), null === k.verticalAlign && (k.verticalAlign = 45 > a || 315 < a ? "bottom" : 135 < a && 225 > a ? "top" : "middle"), g.alignDataLabel.call(this, b, d, k, f, e)) : a.call(this, b,
					d, k, f, e)
			})), q(l, "getCoordinates", function(a, b) {
				var c = this.chart,
					g = {
						xAxis: [],
						yAxis: []
					};
				c.polar ? r(c.axes, function(a) {
					var d = a.isXAxis,
						f = a.center,
						k = b.chartX - f[0] - c.plotLeft,
						f = b.chartY - f[1] - c.plotTop;
					g[d ? "xAxis" : "yAxis"].push({
						axis: a,
						value: a.translate(d ? Math.PI - Math.atan2(k, f) : Math.sqrt(Math.pow(k, 2) + Math.pow(f, 2)), !0)
					})
				}) : g = a.call(this, b);
				return g
			}), b.SVGRenderer.prototype.clipCircle = function(a, c, d) {
				var g = b.uniqueKey(),
					f = this.createElement("clipPath").attr({
						id: g
					}).add(this.defs);
				a = this.circle(a, c, d).add(f);
				a.id = g;
				a.clipPath = f;
				return a
			}, b.addEvent(b.Chart, "getAxes", function() {
				this.pane || (this.pane = []);
				r(b.splat(this.options.pane), function(a) {
					new b.Pane(a, this)
				}, this)
			}), b.addEvent(b.Chart, "afterDrawChartBox", function() {
				r(this.pane, function(a) {
					a.render()
				})
			}), q(b.Chart.prototype, "get", function(a, c) {
				return b.find(this.pane, function(a) {
					return a.options.id === c
				}) || a.call(this, c)
			}))
	})(w)
});