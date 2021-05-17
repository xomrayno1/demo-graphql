package com.tampro.dsggraphql01.model;

import java.io.Serializable;

import com.tampro.dsggraphql01.response.APIStatus;

public class APIResponse<T> implements Serializable{
	private T data;
	private String message;
	private int status;
	
	public APIResponse() {
		 
	}
	public APIResponse(T data, String message, int status) {
		 
		this.data = data;
		this.message = message;
		this.status = status;
	}
	
	public APIResponse(T data, APIStatus apiStatus) {
		
		if(apiStatus == null) {
			//throw new IgArgumentException
		}
		this.data = data;
		this.message = apiStatus.getDescription();
		this.status = apiStatus.getCode();
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
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
