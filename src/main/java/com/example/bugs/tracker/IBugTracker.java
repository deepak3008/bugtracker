package com.example.bugs.tracker;

import org.springframework.web.client.RestClientResponseException;

/**
 * This interface provides a api contract for the client to implement 
 * @author pherry
 * @version 1.0
 */
public interface IBugTracker {
	
	/**
	 * This method will add new issue on active bug tracking system
	 * @param payload
	 * @return
	 * @throws RestClientResponseException
	 */
	public BugTrackerResponse addIssue(BugTrackerPayload payload)  throws RestClientResponseException;

}
