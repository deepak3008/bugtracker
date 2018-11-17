package com.example.bugs.services;

import com.example.bugs.exceptions.BugTrackerException;
import com.example.bugs.exceptions.TaskTrackingException;
import com.example.bugs.mapper.UserStoryMapper;

public interface IBusinessLogicService {

	/**
	 * Based on the boolean parameter new bug might get registered
	 * 
	 * @param needBug
	 *                <ul>
	 *                <li>If true then new bug will be registered in bug tracking
	 *                system</li>
	 *                <li>If false then operation will proceed normally</li>
	 *                </ul>
	 * @return
	 * @throws BugTrackerException
	 */
	public boolean addBug(boolean needBug) throws BugTrackerException;

	/**
	 * Based on the boolean parameter new task might get registered
	 * 
	 * @param needTask
	 *                 <ul>
	 *                 <li>If true then new task will be registered in bug tracking
	 *                 system</li>
	 *                 <li>If false then operation will proceed normally</li>
	 *                 </ul>
	 * @return
	 * @throws TaskTrackingException
	 */
	public boolean addTask(boolean needTask) throws TaskTrackingException;
	
	
	/**
	 * Register new user story
	 * @param mapper
	 * @return
	 */
	public UserStoryMapper addStory(UserStoryMapper mapper) ;

}
