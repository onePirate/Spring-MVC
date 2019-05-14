package com.blog.util;
/** 
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月28日 上午3:35:52 
* @version 1.0 
 */

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JSONUtil {
	
	/**
	 * 处理输出值为null的字段，原来不输出，现在输出
	 * @param obj
	 * @return
	 */
	public static String toJSONString(Object obj) {
		return JSONObject.toJSONString(obj,SerializerFeature.WriteMapNullValue);
	}

}
