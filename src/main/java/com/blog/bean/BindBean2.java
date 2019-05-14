package com.blog.bean;
/** 
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月27日 下午5:20:36 
* @version 1.0 
 */
public class BindBean2 {

	public BindBean2(String code, boolean token, String loginAccount) {
		this.code = code;
		this.token = token;
		this.loginAccount = loginAccount;
	}

	private String code;
	
	private boolean token;
	
	private String loginAccount;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isToken() {
		return token;
	}

	public void setToken(boolean token) {
		this.token = token;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	
}
