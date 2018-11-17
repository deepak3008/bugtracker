package com.example.bugs.tracker;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.bugs.exceptions.IssueTrackingException;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BugTracking {
	
	Class<? extends IssueTrackingException> expecting() default IssueTrackingException.class;

}
