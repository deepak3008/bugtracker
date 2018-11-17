package com.example.bugs.exceptions;

import com.example.bugs.tracker.GithubBugTracker;
import com.example.bugs.tracker.IBugTracker;
import com.example.bugs.tracker.JiraBugTracker;

/**
 * This exception class is thrown when application can not find the {@link IBugTracker} implementation class
 * 
 * @author pherry
 * @version 1.0
 * 
 * @see IBugTracker
 * @see JiraBugTracker
 * @see GithubBugTracker
 */
public class BugTrackerProfileNotFoundException extends BugTrackerException {

	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public BugTrackerProfileNotFoundException() {
		
	}
	
	public BugTrackerProfileNotFoundException(String msg) {
		this.msg = msg;
	}
	
	public BugTrackerProfileNotFoundException(String msg, Throwable t) {
		this.msg= msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
