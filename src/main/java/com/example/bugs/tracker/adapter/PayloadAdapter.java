package com.example.bugs.tracker.adapter;

import com.example.bugs.tracker.BugTrackerPayload;

/**
 * This adapter class is used to convert {@link JiraTrackerPayload} 
 * and {@link GithubTrackerPayload} into platform specific response {@link BugTrackerPayload} 
 * @author pherry
 * @version 1.0
 * 
 * @see GithubTrackerPayload
 * @see JiraTrackerPayload
 * @see BugTrackerPayload
 */
public class PayloadAdapter implements IPayloadAdapter {
	

	@Override
	public JiraTrackerPayload getJiraPayloaFromBugTrackerPayload(BugTrackerPayload payload) {

		return new JiraTrackerPayload(payload); 
	}

	@Override
	public GithubTrackerPayload getGuthubPayloadFromBugTrackerPayload(BugTrackerPayload payload) {
		
		return new GithubTrackerPayload(payload);
	}

	

}
