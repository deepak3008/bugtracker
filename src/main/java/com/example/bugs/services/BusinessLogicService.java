package com.example.bugs.services;

import org.springframework.stereotype.Service;

import com.example.bugs.exceptions.BugTrackerException;
import com.example.bugs.exceptions.WarningTrackingException;
import com.example.bugs.tracker.BugTracking;

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
	public boolean someBusinessLogic(boolean needBug) throws BugTrackerException {
		if (needBug) {
			throw new BugTrackerException("Some bug occured");
		}
		return true;

	}

	@BugTracking(expecting = WarningTrackingException.class)
	@Override
	public boolean someOtherBusinessLogic(boolean needWarning) throws WarningTrackingException {

		if (needWarning) {
			throw new WarningTrackingException("New warning will be registed in bug tracking system ");
		}
		return true;
	}

}
