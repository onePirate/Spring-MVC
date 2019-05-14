package com.blog.exHandle;

import com.blog.util.ResultUtil;
import com.blog.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: gaodawei
 * @Date: created in 12:49 2017/12/30
 * @function:
 * @version: v1.0.0
 * @ModifyBy:
 * @ModifyBy:
 */
public class SpecialExceptionHandle {

    @ExceptionHandler
    @ResponseBody
    public Result<?> exceptionProcess(HttpServletRequest request,
                                   HttpServletResponse response,
                                   RuntimeException ex) {
        return ResultUtil.success(ex.getMessage());
    }
}
