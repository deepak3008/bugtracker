package com.example.bugs;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bugs.exceptions.BugTrackerException;
import com.example.bugs.exceptions.WarningTrackingException;
import com.example.bugs.services.BusinessLogicService;
import com.example.bugs.services.IBusinessLogicService;
import com.example.bugs.tracker.BugTrackingAspectConfiguration;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class BugTrackerApplicationTests {

//	@Autowired
	private BusinessLogicService service;
	
//	@Autowired
//	private BugTrackingAspectConfiguration config;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		service = new BusinessLogicService();
	}
	
	@Test
	public void whenFalseGivenInBug_thenReturnTrue () {
		boolean bool = service.someBusinessLogic(false);
		
		assertThat(bool, is(true));
	}
	
	
	@Test(expected=BugTrackerException.class)
	public void whenTrueGivenInBug_thenThrowException () {
		service.someBusinessLogic(true);
		
	}
	
	@Test
	public void whenFalseGivenInWarning_thenReturnTrue () {
		boolean bool = service.someOtherBusinessLogic(false);
		
		assertThat(bool, is(true));
	}
	
	
	@Test(expected=WarningTrackingException.class)
	public void whenTrueGivenInWarning_thenThrowException () {
		service.someOtherBusinessLogic(true);
		
		
	}

}
