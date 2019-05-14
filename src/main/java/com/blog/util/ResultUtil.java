package com.blog.util;

import com.blog.enums.StateEnum;
import com.blog.vo.Result;

/** 
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月21日 上午12:41:12 
* @version 1.0 
 */
public class ResultUtil {
	
	@SuppressWarnings("unchecked")
	public static Result<Object> success(Object object) {
        @SuppressWarnings("rawtypes")
		Result<Object> result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result<?> success() {
        return success(null);
    }

    public static Result<?> error(Integer code, String msg) {
        @SuppressWarnings("rawtypes")
		Result<?> result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result<?> error(){
	    return error(StateEnum.STATE_500.getState(),StateEnum.STATE_500.getDesc());
    }

    public static Result<?> error(String errMsg){
        return error(StateEnum.STATE_500.getState(),errMsg);
    }

}
