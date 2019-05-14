package com.blog.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

/** 
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月26日 下午9:52:28 
* @version 1.0 
 */
public class HttpServletRequestUtil {
	
	/**
	 * 方法一：返回请求body的字符串内容
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static String getBodyString(HttpServletRequest request) throws IOException{
		BufferedReader br = request.getReader();
		String str, wholeStr = "";
		while((str = br.readLine()) != null){
		wholeStr += str;
		}
		return wholeStr;
	}
	/**
	 * 方法二：返回请求body的字符流内容
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static ServletInputStream getBodyInputStream(HttpServletRequest request) throws IOException{
		int len = request.getContentLength();
		ServletInputStream iii = request.getInputStream();
		byte[] buffer = new byte[len];
		iii.read(buffer, 0, len);
		return iii;
	}

}
