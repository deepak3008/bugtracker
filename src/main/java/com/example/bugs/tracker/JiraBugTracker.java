package com.example.bugs.tracker;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.example.bugs.tracker.adapter.JiraTrackerPayload;
import com.example.bugs.tracker.adapter.JiraTrackerResponse;
import com.example.bugs.tracker.adapter.PayloadAdapter;
import com.example.bugs.tracker.adapter.ResponseAdapter;

/**
 * This class provides the implements of {@link IBugTracker} interface for jira
 * bug tracker system
 * 
 * @author pherry
 * @version 1.0
 *
 */
public class JiraBugTracker implements IBugTracker {

	private RestTemplate restClient;

	private JiraConfiguration config;

	private HttpHeaders headers = new HttpHeaders();

	private PayloadAdapter payloadAdapter;

	private ResponseAdapter responseAdapter;

	public JiraBugTracker(RestTemplate restlient, JiraConfiguration config) {
		this.restClient = restlient;
		this.config = config;
		payloadAdapter = new PayloadAdapter();
		responseAdapter = new ResponseAdapter();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Basic " + config.getAuth());

	}

	@Override
	public BugTrackerResponse addIssue(BugTrackerPayload payload) throws RestClientResponseException {

		JiraTrackerPayload jiraPayload = payloadAdapter.getJiraPayloaFromBugTrackerPayload(payload);
		jiraPayload.setProject(config.getProject());

		HttpEntity<JiraTrackerPayload> request = new HttpEntity<JiraTrackerPayload>(jiraPayload, headers);
		ResponseEntity<JiraTrackerResponse> response = restClient.postForEntity(config.getUrl(), request,
				JiraTrackerResponse.class);
		return responseAdapter.getJiraTrackerResponse(response.getBody());
	}

}
