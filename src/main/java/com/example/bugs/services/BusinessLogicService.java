package com.example.bugs.services;

import org.springframework.stereotype.Service;

import com.example.bugs.exceptions.BugTrackerException;
import com.example.bugs.exceptions.TaskTrackingException;
import com.example.bugs.mapper.UserStoryMapper;
import com.example.bugs.tracker.annotation.BugTracking;
import com.example.bugs.tracker.annotation.StoryTracking;

/**
 * A dummy business logic the support the functionality of {@link BugTracking}
 * annotation to bug tracking system
 * 
 * @author pherry
 * @version 1.0
 *
 */
@Service
public class BusinessLogicService implements IBusinessLogicService {

	@BugTracking(expecting = BugTrackerException.class)
	@Override
	public boolean addBug(boolean needBug) throws BugTrackerException {
		if (needBug) {
			throw new BugTrackerException("New bug will be registed in bug tracking system");
		}
		return true;

	}

	@BugTracking(expecting = TaskTrackingException.class)
	@Override
	public boolean addTask(boolean needTask) throws TaskTrackingException {

		if (needTask) {
			throw new TaskTrackingException("New task will be registed in bug tracking system ");
		}
		return true;
	}

	@StoryTracking
	@Override
	public UserStoryMapper addStory(UserStoryMapper mapper) {
		// TODO Auto-generated method stub
		return mapper;
	}
	

}
