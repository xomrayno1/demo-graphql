package com.tampro.response;

public enum APIStatus {
	
	OK(200, "Ok"),
	ERR_EMPLOYEE_NOT_FOUND(504, "Employee not found exception"),
	ERR_STUDENT_NOT_FOUND(604, "Student not found exception");
	
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
