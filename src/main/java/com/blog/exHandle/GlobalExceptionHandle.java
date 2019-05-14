package com.blog.exHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.exception.UnifyException;
import com.blog.util.ResultUtil;
import com.blog.vo.Result;

/** 
* @function 注解方法处理异常
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月21日 上午12:08:56 
* @version 1.0 
 */
@ControllerAdvice
public class GlobalExceptionHandle {
	
	private static Logger log=LoggerFactory.getLogger(GlobalExceptionHandle.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result<?> handle(Exception ex) {
        log.info("【全局异常开始执行】");
	    if (ex instanceof UnifyException) {
        	UnifyException exception = (UnifyException) ex;
            return ResultUtil.error(exception.getCode(), exception.getMessage());
        }else {
            log.error("【系统异常】{}", ex);
            return ResultUtil.error(-1, "未知错误");
        }
    }

}
