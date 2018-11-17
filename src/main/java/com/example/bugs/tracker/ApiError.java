package com.example.bugs.tracker;

import org.springframework.http.HttpStatus;

public class ApiError {

	private int code;

	private HttpStatus status;

	private Long timestamp;

	private String message;

	public ApiError() {
		timestamp = System.currentTimeMillis();
	}

	public ApiError(HttpStatus status) {
		this();
		this.status = status;
		this.code = status.value();
	}

	public ApiError(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.code = status.value();
		this.message = "Unexpected error";
	}

	public ApiError(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.code = status.value();
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
