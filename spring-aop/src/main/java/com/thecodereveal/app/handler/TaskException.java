package com.thecodereveal.app.handler;

import org.springframework.http.HttpStatus;

public class TaskException extends RuntimeException{

	private String message;
	private HttpStatus httpStatus;
	
	
	
	public TaskException(String message) {
		super();
		this.message = message;
	}
	
	public TaskException(HttpStatus httpStatus,String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}
