package com.example.bugs.services;

import com.example.bugs.exceptions.BugTrackerException;
import com.example.bugs.exceptions.WarningTrackingException;

public interface IBusinessLogicService {
	
	
	/**
	 * Based on the boolean parameter new bug might get registered
	 * @param needBug 
	 * 		<ul><li>If true then new bug will be registered in bug tracking system</li>
	 * 		<li>If false then operation will proceed normally</li></ul>
	 * @return
	 * @throws BugTrackerException
	 */
	public boolean someBusinessLogic(boolean needBug) throws BugTrackerException;
	
	
	/**
	 * Based on the boolean parameter new waring might get registered
	 * @param needWarning
	 * @return
	 * @throws WarningTrackingException
	 */
	public boolean someOtherBusinessLogic(boolean needWarning) throws WarningTrackingException;

}
