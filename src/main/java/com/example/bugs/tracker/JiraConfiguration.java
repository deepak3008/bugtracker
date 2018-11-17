package com.example.bugs.tracker;

import java.util.Base64;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * This class provides the necessary configuration for jira bug tracking system
 * This class picks configuration setting from application.properties. So make sure to 
 * specify the valid values or else system will not start 
 * @author pherry
 * @version 1.0
 *
 */
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "bug.tracking.jira")
@ConditionalOnProperty(name="bug.tracking.profile", havingValue="com.example.bugs.tracker.JiraBugTracker")
public class JiraConfiguration extends AbstractProperties {

	
	@NotBlank
	private String username;

	@NotBlank
	private String password;

	private String auth;

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuth() {
		if (auth == null) {
			String userAndPAss = getUsername() + ":" + getPassword();
			auth = Base64.getEncoder().encodeToString(userAndPAss.getBytes());
		}
		return auth;

	}

}
