package com.example.bugs.exceptions;

import com.example.bugs.tracker.BugTrackingAspectConfiguration;
import com.example.bugs.tracker.ExceptionHandlerAdvice;

/**
 * This exception class is thrown when application see warning level of problem in the system.
 * This exception is handled by {@link BugTrackingAspectConfiguration} and {@link ExceptionHandlerAdvice}
 * @author pherry
 * @version 1.0
 * 
 * @see ExceptionHandlerAdvice
 * @see BugTrackingAspectConfiguration
 */
public class WarningTrackingException extends IssueTrackingException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6163802916463916734L;
	private String msg;

	public WarningTrackingException() {
		super();
	}

	public WarningTrackingException(String msg) {
		super(msg);
		this.msg = msg;

	}

	public WarningTrackingException(String msg, Throwable t) {
		super(msg, t);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
            return false;
        }
		
		WarningTrackingException i = (WarningTrackingException)o;
		return i.getMsg()==getMsg();
	}
	
	@Override
	public int hashCode() {
		return (int)serialVersionUID;
	}
	
	

}
