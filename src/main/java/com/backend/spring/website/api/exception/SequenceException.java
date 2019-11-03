package com.backend.spring.website.api.exception;

public class SequenceException extends RuntimeException{

	private String errCode;
	private String errMsg;
	
	public SequenceException(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
