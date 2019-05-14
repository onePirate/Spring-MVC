package com.blog.model;
/** 
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2018年1月17日 下午12:23:05 
* @version 1.0 
 */

import java.io.Serializable;

public class Keys implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String publicKey;
	private String privateKey;
	private String desKey;
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	public String getDesKey() {
		return desKey;
	}
	public void setDesKey(String desKey) {
		this.desKey = desKey;
	}
}
