package com.example.bugs.tracker;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.example.bugs.tracker.adapter.PayloadAdapter;
import com.example.bugs.tracker.adapter.ResponseAdapter;

/**
 * This class provides the implements of {@link IBugTracker} interface for Github
 * bug tracker system. This system is not fully implimented as github does not support 
 * standard Basic authentication mechanism, So standard rest client can not complete the authentication challenge
 * @author pherry
 * @version 1.0
 * @deprecated 
 */
public class GithubBugTracker implements IBugTracker {

//	private RestTemplate restClient;
//
//	private HttpHeaders headers = new HttpHeaders();
//
//	private PayloadAdapter payloadAdapter;
//
//	private ResponseAdapter responseAdapter;
//	
//	private GithubConfiguration config;

	public GithubBugTracker(RestTemplate restClient, GithubConfiguration config) {
//		this.restClient = restClient;
//		this.config = config;
	}

	@Override
	public BugTrackerResponse addIssue(BugTrackerPayload payload) {
		// TODO Auto-generated method stub
		return null;
	}

}
