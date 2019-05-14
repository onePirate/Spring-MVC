package com.blog.co_controller;

import com.alibaba.fastjson.JSONObject;
import com.blog.bean.BindBean;
import com.blog.util.JSONUtil;
import com.blog.util.ResultUtil;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 
 * @function 
 * @author  作者 : gaodawei
 * @Email   邮箱 : 695390275@qq.com
 * @date    创建时间：2017年12月28日 上午2:55:06 
 * @version 1.0 
 */
@Controller
@RequestMapping("param")
public class ParamDataBindController {

	private static Logger log=LoggerFactory.getLogger(ParamDataBindController.class);

	@RequestMapping("int")
	public void getBlogIntParam(int weight,Integer age,HttpServletResponse resp) throws IOException {
		log.info("*****weight:"+weight);
		log.info("*****age:"+age);
		resp.getWriter().print(ResultUtil.success());
	}

	@RequestMapping("string")
	public void getBlogStringParam(String msg,HttpServletResponse resp) throws IOException {
		log.info("*****msg:"+msg);
		resp.getWriter().print(ResultUtil.success());
	}

	@RequestMapping("jsonToBean")
	public void getBlogBeanParam(BindBean bindBean,HttpServletResponse resp) throws IOException {
		log.info("*****bindBean请求参数:"+ReflectionToStringBuilder.toString(bindBean));
		bindBean.setToken(false);
		log.info("*****bindBean相应数据:"+JSONUtil.toJSONString(bindBean));
		resp.getWriter().print(ResultUtil.success());
	}

	@RequestMapping(value = "json",consumes = "application/json")
	public void getBlogJsonParam(@RequestBody JSONObject json,HttpServletResponse resp) throws IOException {
		log.info("*****json:"+json);
		resp.getWriter().print(ResultUtil.success());
	}



}
