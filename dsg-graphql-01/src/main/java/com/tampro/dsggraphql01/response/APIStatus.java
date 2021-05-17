package com.tampro.dsggraphql01.response;

public enum APIStatus {
	
	OK(200, "Ok"),
	
	//error
	ERR_STUDENT_NOT_FOUND(604, "Student not found exception"),
	
	//success
	SUCCESS_CREATE_STUDENT(601, "Create student success");
	
	private final int code;
	private final String description;
	
	
	private APIStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}
	public int getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
	

}
