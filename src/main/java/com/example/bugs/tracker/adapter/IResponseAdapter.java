package com.example.bugs.tracker.adapter;

import com.example.bugs.tracker.BugTrackerResponse;

/**
 * An Adapter interface which provides a contract for class implementing this
 * interface to convert Vendor specific payload into platform specific payload
 * 
 * @author pherry
 * @version 1.0
 *
 */
public interface IResponseAdapter {

	/**
	 * Convert jira response into platform specific response
	 * @param response
	 * @return
	 */
	public BugTrackerResponse getJiraTrackerResponse(JiraTrackerResponse response);

	/**
	 * Convert githib response into platform specific response
	 * @param response
	 * @return
	 */
	public BugTrackerResponse getGithubTrackerResponse(GithubTrackerResponse response);

}
