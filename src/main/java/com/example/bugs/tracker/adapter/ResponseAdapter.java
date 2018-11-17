package com.example.bugs.tracker.adapter;

import com.example.bugs.tracker.BugTrackerResponse;

/**
 * This adapter class is used to convert {@link JiraTrackerResponse} 
 * and {@link GithubTrackerResponse} into platform specific response {@link BugTrackerResponse} 
 * @author pherry
 * @version 1.0
 * 
 * @see GithubTrackerResponse
 * @see JiraTrackerResponse
 * @see BugTrackerResponse
 */
public class ResponseAdapter implements IResponseAdapter {

	@Override
	public BugTrackerResponse getJiraTrackerResponse(JiraTrackerResponse response) {
		BugTrackerResponse res = new BugTrackerResponse();
		res.setId(response.getId());
		res.setIssueUrl(response.getSelf());
		return res;
	}

	@Override
	public BugTrackerResponse getGithubTrackerResponse(GithubTrackerResponse response) {
		
		BugTrackerResponse res = new BugTrackerResponse();
		res.setId(response.getNumber());
		res.setIssueUrl(response.getUrl());
		return res;
	}

}
