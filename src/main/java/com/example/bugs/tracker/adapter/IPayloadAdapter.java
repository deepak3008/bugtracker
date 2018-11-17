package com.example.bugs.tracker.adapter;

import com.example.bugs.tracker.BugTrackerPayload;

/**
 * An Adapter interface which provides a contract for class implementing this
 * interface to convert Platform specific payload into vendorm specific payload
 * 
 * @author pherry
 * @version 1.0
 * 
 *
 */
public interface IPayloadAdapter {

	/**
	 * Convert platform specific payload into {@link JiraTrackerPayload}
	 * @param payload
	 * @return
	 */
	public JiraTrackerPayload getJiraPayloaFromBugTrackerPayload(BugTrackerPayload payload);

	/**
	 * Convert platform specific payload into {@link GithubTrackerPayload}
	 * @param payload
	 * @return
	 */
	public GithubTrackerPayload getGuthubPayloadFromBugTrackerPayload(BugTrackerPayload payload);
}
