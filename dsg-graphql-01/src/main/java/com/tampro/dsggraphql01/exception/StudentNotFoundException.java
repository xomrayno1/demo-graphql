package com.tampro.dsggraphql01.exception;

public class StudentNotFoundException  extends RuntimeException{
	
	private String msg;

	public StudentNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
 
	
}
