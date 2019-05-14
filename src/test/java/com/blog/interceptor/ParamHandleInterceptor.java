package com.blog.interceptor;

import com.blog.enums.ConstantEnum;
import com.blog.util.HttpServletRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月22日 上午1:12:49 
* @version 1.0 
 */
public class ParamHandleInterceptor  implements HandlerInterceptor{
	
	private static Logger log= LoggerFactory.getLogger(ParamHandleInterceptor.class);

	/**
	 * 本来想试着在拦截器里面获取到body里面的参数
	 * 然后针对参数做相应验证，比如token过期，被迫下线等等，但是拦截器是做不到的!
	 * 
	 * 为什么做不到呢？因为不能使用 request.getInputStream();request.getReader(); 和request.getParameter("key");
	 * (流只能取一次，导致后台获取不到参数;request.getParameter(),获取不到 json格式参数);
	 * 
	 * 但是不是采用Content-Type=application/json的方式，而是采用如下：Content-Type:x-www-form-urlencode,text,text/plain方式
	 * 请求数据格式如：msg={"name":"gaodawei"}这种方式的话可以通过request.getParameter("msg")获取得到值，然后做json处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("***************请求在处理之前执行调用****************");
//		log.info("\n******request请求地址："+request.getRequestURL());
//		log.info("\n******request请求资源："+request.getRequestURI());
//		log.info("\n******request行中参数："+request.getQueryString());
//		log.info("\n******request请求地址："+request.getRemoteAddr());
//		log.info("\n******request请求主机："+request.getRemoteHost());
//		log.info("\n******request请求端口："+request.getRemotePort());
//		log.info("\n******request请求用户："+request.getRemoteUser());
//		log.info("\n******request本地地址："+request.getLocalAddr());
//		log.info("\n******request本地名称："+request.getLocalName());
//		log.info("\n******request本地端口："+request.getLocalPort());
//		log.info("\n******request请求方式："+request.getMethod());
//		log.info("\n******request额外信息："+request.getPathInfo());
//		Cookie[] cookieArr=request.getCookies();
//		for(Cookie cookie:cookieArr) {
//			log.info("\n******request请求cookie："+JSONObject.toJSONString(cookie));
//			log.info("\n******cookieName："+cookie.getName());
//			log.info("\n******cookieValue："+cookie.getValue());
//		}
//		log.info("\n******request认证方案："+request.getAuthType());
//		log.info("\n******Cache-Control："+request.getHeader("Cache-Control"));
//		log.info("\n******Connection："+request.getHeader("Connection"));
//		log.info("\n******Content-Length："+request.getHeader("Content-Length"));
//		log.info("\n******Content-Type："+request.getHeader("Content-type"));
//		log.info("\n******Date："+request.getHeader("Date"));
//		log.info("\n******X-Frame-Options："+request.getHeader("X-Frame-Options"));
//		log.info("\n******X-UA-Compatible："+request.getHeader("X-UA-Compatible"));
		String paramStr="";
		if(ConstantEnum.CONTENT_TYPE_JSON.getValue().equals(request.getHeader("Content-type"))) {
			paramStr=HttpServletRequestUtil.getBodyString(request);
			log.info("\n******多次请求request.getReader():"+paramStr);
		}else {
			paramStr=request.getParameter("msg");
			log.info("\n******request获得非JSON类型的json数据请求参数信息："+paramStr);
		}
//		JSONObject json=JSONObject.parseObject(paramStr);
//		//这里开始进行token验证，以及权限验证等等
//		//这里是token验证
//		if(!json.getBooleanValue("token")) {
//			//如果没有通过验证，则扔出异常统一处理或者之间返回验证信息
//			response.getWriter().print(ResultUtil.error(101, "token过期"));
//			return false;
//		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("\n***************请求在处理之后执行调用****************\n");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("\n***************请求在结束之后执行调用****************\n");

	}
	

}
