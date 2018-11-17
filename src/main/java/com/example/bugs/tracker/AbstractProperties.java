package com.example.bugs.tracker;

import org.hibernate.validator.constraints.NotBlank;

/**
 * This is based class for bug tracking system module configuration. 
 * Vendor specific implementation system must extends this class other wise system will not work
 * @author pherry
 * @version 1.0
 *
 */
public abstract class AbstractProperties {

	@NotBlank
	protected String url;

	@NotBlank
	protected String project;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
}
