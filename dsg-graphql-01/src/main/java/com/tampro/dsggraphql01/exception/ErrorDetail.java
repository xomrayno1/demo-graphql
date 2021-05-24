package com.tampro.dsggraphql01.exception;

import java.util.Date;

 

public class ErrorDetail {
	private Date date;
	private String message;
	private int status;
	
	
	public ErrorDetail() {
		 
	}
	public ErrorDetail(Date date,  String message, int status) {
		 
		this.date = date;
		this.message = message;
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
 
	
	
	
	
}
