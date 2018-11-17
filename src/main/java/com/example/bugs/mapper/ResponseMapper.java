package com.example.bugs.mapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This is common response class 
 * @author pherry
 *
 */
@ApiModel(description="This is the general class for sending the response to the client")
public class ResponseMapper {
	
	@ApiModelProperty(readOnly=true)
	private boolean success;
	
	@ApiModelProperty(readOnly=true)
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
