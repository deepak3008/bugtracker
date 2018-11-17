package com.example.bugs.tracker;


import org.springframework.web.client.RestTemplate;

/**
 * This class crates instance of {@link IBugTracker} implementation based on the given parameter
 * Right now it only support two implementation, but with more condition it can support more Bug tracking system 
 * @author pherry
 * @version 1.0
 * 
 * @see GithubBugTracker
 * @see JiraBugTracker
 *
 */
public class BugTrackerFactory {

	/**
	 * Static factory method which create instance of the {@link IBugTracker} implementation 
	 * @param clazz
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static IBugTracker getBugTracker(Class<? extends IBugTracker> clazz, RestTemplate restClient, AbstractProperties config) throws ClassNotFoundException {
		if (clazz.equals(JiraBugTracker.class)) {
			return new JiraBugTracker(restClient, (JiraConfiguration)config);
		} else if (clazz.equals(GithubBugTracker.class)) {
			return new GithubBugTracker(restClient, (GithubConfiguration)config);
		}
		throw new ClassNotFoundException("Provided class " + clazz + " could not be found");

	}

}
