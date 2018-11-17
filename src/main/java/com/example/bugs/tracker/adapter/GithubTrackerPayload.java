package com.example.bugs.tracker.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.bugs.tracker.BugTrackerPayload;

/**
 * Payload structure for the Github bug tracking system
 * 
 * @author pherry
 * @version 1.0
 */
public class GithubTrackerPayload {

	private String title;

	private String body;

	private List<String> labels = new ArrayList<>(0);

	public GithubTrackerPayload() {

	}

	public GithubTrackerPayload(BugTrackerPayload payload) {

		this.title = payload.getTitle();
		this.body = payload.getDescription();
		this.labels.add(payload.getLabel());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

}
