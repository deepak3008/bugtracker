package com.example.bugs.tracker;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Not fully implemented as github does support the standard basic authentication protocol 
 * @author pherry
 * @version 1.0
 * @deprecated
 *
 */
@Configuration("guthubConfig")
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "bug.tracking.github")
@ConditionalOnProperty(name="bug.tracking.profile", havingValue="com.example.bugs.tracker.GithubBugTracker")
public class GithubConfiguration extends AbstractProperties {

}
