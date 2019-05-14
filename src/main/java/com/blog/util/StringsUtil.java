package com.blog.util;

/** 
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月28日 上午12:01:01 
* @version 1.0 
 */
public class StringsUtil {

    /**
     * 判断字符串是否有值
     * 如果为null或者是空字符串或者只有空格或者为"null"字符串，则返回true，否则则返回false。
     * @param value
     * @Return boolean
     */
    public static boolean isEmpty(String value) {
        if (value != null && !"".equalsIgnoreCase(value.trim()) && !"null".equalsIgnoreCase(value.trim())) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
	 * byte 数组转换为 String.
	 * @return byte[]
	 */
	public static String bytesToString(byte[] encrytpByte) {
		String result = "";
		for (Byte bytes : encrytpByte) {
			result += (char) bytes.intValue();
		}
		return result;
	}
	
}
