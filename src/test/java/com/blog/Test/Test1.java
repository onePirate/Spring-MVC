package com.blog.Test;

/**
 * @function
 * @author 作者 : gaodawei
 * @Email 邮箱 : 695390275@qq.com
 * @date 创建时间：2018年1月29日 下午6:41:17
 * @version 1.0
 */
public class Test1 {
	public static void changeStr(String str) {
		str = "welcome1";
		str = "welcome2";
		str = "welcome3";
		str = "welcome4";
	}

	public static void changeStr2(String str) {
		str = "welcome1";
		str = "welcome2";
		str = "welcome3";
		str = "welcome4";
	}

	public static void main(String[] args) {
		String str = "1234";
		changeStr(str);
		changeStr2(str);
		System.out.println(str);

	}
}
