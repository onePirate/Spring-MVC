package com.blog.enums;
/** 
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月27日 下午4:30:50 
* @version 1.0 
 */
public enum ConstantEnum {
	
	CONTENT_TYPE_JSON("application/json");
	
	private ConstantEnum(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
