package com.example.bugs.tracker;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.example.bugs.exceptions.BugTrackerException;
import com.example.bugs.exceptions.BugTrackerProfileNotFoundException;
import com.example.bugs.exceptions.IssueTrackingException;
import com.example.bugs.exceptions.WarningTrackingException;

/**
 * This class provides the configuration need to setup the Bug tracking cross
 * cutting concern in enterprise application
 * 
 * @author pherry
 * @version 1.0
 * 
 *
 */
@Aspect
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class BugTrackingAspectConfiguration {

	@Autowired
	private Environment env;

	private Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private AbstractProperties config;

	/**
	 * Load the appropriate class based on the active bug tracking profile and
	 * create the coresponding instance from the {@link BugTrackerFactory}
	 * 
	 * @return
	 * @throws BugTrackerProfileNotFoundException
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Bean
	public IBugTracker getBugTracker() throws BugTrackerProfileNotFoundException {

		Class<? extends IBugTracker> clazz;
		try {
			String className = env.getProperty("bug.tracking.profile");
			clazz = (Class<? extends IBugTracker>) ClassLoader.getSystemClassLoader().loadClass(className);
			return BugTrackerFactory.getBugTracker(clazz, getRestTemplete(), config);
		} catch (ClassNotFoundException e) {
			log.debug(e.getStackTrace());
			// If no class found then prevent the application from starting
			// as it is crucial for our application
			throw new BugTrackerProfileNotFoundException("No valid bug tracking profile found");
		}

	}

	/**
	 * Create the singleton restTemplete bean 
	 * @return
	 */
	@Bean
	public RestTemplate getRestTemplete() {
		return new RestTemplate();
	}

	/**
	 * This method defines join point for {@link BugTracking} point cut for advice
	 * will be executed
	 * 
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value = "@annotation(com.example.bugs.tracker.BugTracking)", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, IssueTrackingException ex) {
		// Since join pint contains the information about the function point cut e.g.
		// function that id being executed
		// we extract the method signature and then annotation information
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();

		String methodName = signature.getName() + " of " + signature.getClass();

		BugTracking b = signature.getMethod().getAnnotation(BugTracking.class);
		Object e = b.expecting();
		BugTrackerPayload payload = new BugTrackerPayload();
		StringWriter sr = new  StringWriter();		
		PrintWriter pr = new PrintWriter(sr);
		ex.printStackTrace(pr);
		if (e.equals(BugTrackerException.class)) {
			payload.setTitle("Bug In " + methodName);
			payload.setLabel("Bug");
			payload.setDescription(sr.toString());
		} else if (e.equals(WarningTrackingException.class)) {
			payload.setTitle("Warning In " + methodName);
			payload.setLabel("Warning");
			payload.setDescription(sr.toString());
		} else {
			payload.setTitle("Unknown Bug in " + methodName);
			payload.setLabel("Bug");
			payload.setDescription(sr.toString());
		}
		try {
			getBugTracker().addIssue(payload);	
		} catch (RestClientResponseException ee) {
			throw ee;
		}
		throw ex;

	}

}
