package com.blog.exception;
/** 
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月22日 上午2:00:46 
* @version 1.0 
 */
public class UnifyException  extends RuntimeException{

	private static final long serialVersionUID = 7278885658363211688L;
	
	private Throwable exception;
    private Integer code;

    public UnifyException(String msg){
        super(msg);
        this.code = 500;
    }
    
    public UnifyException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }

    public UnifyException(Throwable thrown) {
        this.exception = thrown;
    }

    public UnifyException(String msg, Integer code, Throwable thrown) {
        super(msg);
        this.code = code;
        this.exception = thrown;
    }
    
	public Throwable getException() {
		return exception;
	}
	public void setException(Throwable exception) {
		this.exception = exception;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}

}
