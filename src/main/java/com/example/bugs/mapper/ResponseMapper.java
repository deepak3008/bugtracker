package com.example.bugs.mapper;

/**
 * This is common response class 
 * @author pherry
 *
 */
public class ResponseMapper {
	
	private boolean success;
	
	private String message;
	
	public ResponseMapper() {
		
	}

	public ResponseMapper(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
