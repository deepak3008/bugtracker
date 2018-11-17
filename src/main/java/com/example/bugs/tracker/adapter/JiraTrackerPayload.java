package com.example.bugs.tracker.adapter;

import com.example.bugs.tracker.BugTrackerPayload;

/**
 * Payload structure for the Jira bug tracking system
 * 
 * @author pherry
 * @version 1.0
 * 
 * @see PayloadAdapter
 * @see BugTrackerPayload
 */
public class JiraTrackerPayload {

	private Fields fields;

	private String project, summary, description, label;

	public JiraTrackerPayload(BugTrackerPayload payload) {
		this.summary = payload.getTitle();
		this.description = payload.getDescription();
		this.label = payload.getLabel();
		this.fields = new Fields(project, summary, description, label);
	}
	
	public JiraTrackerPayload(BugTrackerPayload payload, String project) {
		this.summary = payload.getTitle();
		this.description = payload.getDescription();
		this.label = payload.getLabel();
		this.project = project;
		this.fields = new Fields(project, summary, description, label);
	}

	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
		this.fields = new Fields(project, summary, description, label);
	}

	public class Fields {

		private Project project;

		private String summary;

		private String description;

		private IssueType issuetype;

		public Fields(String project, String summary, String description, String issueType) {

			this.project = new Project(project);
			this.summary = summary;
			this.description = description;
			this.issuetype = new IssueType(issueType);
		}

		public Project getProject() {
			return project;
		}

		public void setProject(Project project) {
			this.project = project;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public IssueType getIssuetype() {
			return issuetype;
		}

		public void setIssuetype(IssueType issuetype) {
			this.issuetype = issuetype;
		}

		public class Project {

			private String key;

			public Project(String key) {
				this.key = key;
			}

			public String getKey() {
				return key;
			}

			public void setKey(String key) {
				this.key = key;
			}

		}

		public class IssueType {
			private String name;

			public IssueType(String name) {
				this.name = name;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

		}

	}

}
