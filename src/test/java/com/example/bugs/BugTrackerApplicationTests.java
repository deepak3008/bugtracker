package com.example.bugs;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import com.example.bugs.exceptions.BugTrackerException;
import com.example.bugs.exceptions.TaskTrackingException;
import com.example.bugs.services.BusinessLogicService;

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
		boolean bool = service.addBug(false);
		
		assertThat(bool, is(true));
	}
	
	
	@Test(expected=BugTrackerException.class)
	public void whenTrueGivenInBug_thenThrowException () {
		service.addBug(true);
		
	}
	
	@Test
	public void whenFalseGivenInWarning_thenReturnTrue () {
		boolean bool = service.addTask(false);
		
		assertThat(bool, is(true));
	}
	
	
	@Test(expected=TaskTrackingException.class)
	public void whenTrueGivenInWarning_thenThrowException () {
		service.addTask(true);	
		
	}

}
