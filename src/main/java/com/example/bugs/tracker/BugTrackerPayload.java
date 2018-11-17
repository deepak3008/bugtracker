package com.example.bugs.tracker;

public class BugTrackerPayload {

	private String title;

	private String description;

	private String label;

	public BugTrackerPayload() {

	}

	public BugTrackerPayload(String title, String description, String label) {
		super();
		this.title = title;
		this.description = description;
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
