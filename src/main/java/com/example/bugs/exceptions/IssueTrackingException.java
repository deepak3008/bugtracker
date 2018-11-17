package com.example.bugs.exceptions;

import com.example.bugs.tracker.BugTrackingAspectConfiguration;
import com.example.bugs.tracker.ExceptionHandlerAdvice;

/**
 * This exception class is base exception class with is implemented
 * by{@link BugTrackerException} and {@link TaskTrackingException}. Any
 * custom bug tracking system exception class must extend this base exception
 * class in order for system to identify Kind of bug system encountered. Also
 * the custom exception class must be present in the
 * {@link BugTrackingAspectConfiguration} This exception is handled by
 * {@link BugTrackingAspectConfiguration} and {@link ExceptionHandlerAdvice}
 * 
 * @author pherry
 * @version 1.0
 * 
 * @see ExceptionHandlerAdvice
 * @see BugTrackingAspectConfiguration
 * @see BugTrackerException
 * @see TaskTrackingException
 */
public class IssueTrackingException extends RuntimeException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8382562169404021051L;
	private String msg;

	public IssueTrackingException() {
	}

	public IssueTrackingException(String msg) {
		this.msg = msg;
	}

	public IssueTrackingException(String msg, Throwable t) {
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
		
		IssueTrackingException i = (IssueTrackingException)o;
		return i.getMsg()==getMsg();
	}
	
	@Override
	public int hashCode() {
		return (int)serialVersionUID;
	}

}
