package com.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blog.enums.ConstantEnum;

/** 
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月27日 下午1:31:29 
* @version 1.0 
 */
@WebFilter(filterName = "httpServletRequestWrapperFilter", urlPatterns = "/*")
public class HttpServletRequestWrapperFilter implements Filter {
	
	private static Logger log= LoggerFactory.getLogger(HttpServletRequestWrapperFilter.class);
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        String contentType="";
        if (request instanceof HttpServletRequest) {
        	HttpServletRequest req=(HttpServletRequest) request;
        	contentType=req.getHeader("Content-type");
        	log.info("\n******contentType:"+contentType);
        	if(ConstantEnum.CONTENT_TYPE_JSON.getValue().equals(contentType)) {
        		requestWrapper = new BodyReaderHttpServletRequestWrapper(req);
        	}
        }
        if (null == requestWrapper) {
            chain.doFilter(request, response);
        } else {
        	chain.doFilter(requestWrapper, response);
        }
    }
    
    @Override
    public void destroy() {}
}
