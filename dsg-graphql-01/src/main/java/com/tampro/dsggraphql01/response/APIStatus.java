package com.tampro.dsggraphql01.response;

public enum APIStatus {
	
	OK(200, "Ok"),
	
	//error
	ERR_STUDENT_NOT_FOUND(604, "Student not found exception"),
	ERR_STUDENT_EMAIL_CONFLICT(603,"Student email conflict"),
	
	//success
	SUCCESS_CREATE_STUDENT(601, "Create student success"),
	SUCCESS_UPDATE_STUDENT(602, "Update student success"),
	SUCCESS_DELETE_STUDENT(603, "Delete student success");
	
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
