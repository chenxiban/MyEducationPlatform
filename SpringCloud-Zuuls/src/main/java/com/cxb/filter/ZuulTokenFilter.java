package com.cxb.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Token令牌过滤器
 * https://blog.csdn.net/liuchuanhong1/article/details/62236793
 * @Description:
 * @ClassName: ZuulTokenFilter.java
 * @author Chenyongjia
 * @Date 2018年12月03日 晚上20:29:06
 * @Email 867647213@qq.com
 */
@Component
public class ZuulTokenFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(ZuulTokenFilter.class);

	@Override
	public String filterType() {
		return "pre";// 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。这里定义为pre，代表会在请求被路由之前执行。
	}

	@Override
	public int filterOrder() {
		return 0;// 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
	}

	@Override
	public boolean shouldFilter() {
		return true;// 判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。实际运用中我们可以利用该函数来指定过滤器的有效范围。
	}

	/**
	 * 过滤器的具体逻辑。 这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，
	 * 然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，
	 * 当然我们也可以进一步优化我们的返回，比如，通过ctx.getResponse()对响应内容进行编辑等。
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");

		/*if (accessToken != null) {
			return null;// 网关路由放行
		}
		log.warn("token is empty");
		ctx.setSendZuulResponse(false);// 网关路由过滤不路由
		ctx.setResponseStatusCode(401);
		try {
			// 令牌是空的! ! !请先登录! ! !
			ctx.getResponse().getWriter().write("Token is empty ！！！Please log in first ！！！");
		} catch (Exception e) {
			
		}*/
		//ctx.getResponse().setHeader("x-frame-options","SAMEORIGIN");
		return null;// 网关路由放行

	}
	
}
