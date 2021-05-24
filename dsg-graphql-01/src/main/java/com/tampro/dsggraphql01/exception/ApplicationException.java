package com.tampro.dsggraphql01.exception;

import com.tampro.dsggraphql01.response.APIStatus;

public class ApplicationException extends RuntimeException {
	 private String message;
	 private int status;
 
	public ApplicationException() {
		 
	}
	public ApplicationException(String message, int status) {
		super(message);
		this.message = message;
		this.status = status;
	}
	
	
	
	public ApplicationException(APIStatus apiStatus) {
		if(apiStatus == null) {
			throw new IllegalArgumentException("Argument incorrect");
		}
		this.message = apiStatus.getDescription();
		this.status = apiStatus.getCode();
	}
	public String getMsg() {
		return message;
	}
	public void setMsg(String msg) {
		this.message = msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	 
	 
	 
	
	

}
