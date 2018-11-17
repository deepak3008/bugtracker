package com.example.bugs;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bugs.exceptions.BugTrackerException;
import com.example.bugs.exceptions.TaskTrackingException;
import com.example.bugs.mapper.ResponseMapper;
import com.example.bugs.mapper.UserStoryMapper;
import com.example.bugs.services.IBusinessLogicService;
import com.example.bugs.tracker.ApiError;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This controller class provides two method just to test if the bug tracking
 * module is working or not
 * 
 * @author pherry
 * @version 1.0
 */
@RestController
public class Controller {

	private IBusinessLogicService service;

	public Controller(IBusinessLogicService service) {

		this.service = service;
	}

	/**
	 * It maps the root url so that user can get welcome message
	 * 
	 * @return
	 */
	@ApiOperation(value = "Root of application")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = ResponseMapper.class),
			@ApiResponse(code = 400, message = "Bad request", response = ApiError.class) })
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> index() {
		ResponseMapper response = new ResponseMapper();
		response.setSuccess(true);
		response.setMessage("Welcome to the api");
		return ResponseEntity.ok(response);
	}

	/**
	 * This method will add new bug in bug tracker system if bug parameter of true
	 * 
	 * @param bug
	 *            <ul>
	 *            <li>If true then add a bug in the bug tracking system</li>
	 *            <li>If false then proceed normally</li>
	 *            </ul>
	 * @return
	 * @throws BugTrackerException
	 */
	@ApiOperation(value = "This api endpoint is to verify that when query parameter "
			+ "bug is true then new issue is added to the bug tracking other wise not")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = ResponseMapper.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class) })
	@RequestMapping(value = "/bug", method = RequestMethod.GET)
	public ResponseEntity<?> methodBug(
			@RequestParam(value = "bug", required = false, defaultValue = "true") boolean bug)
			throws BugTrackerException {
		ResponseMapper response = new ResponseMapper();
		response.setSuccess(service.addBug(bug));
		response.setMessage("No bug was registerd");
		return ResponseEntity.ok(response);
	}

	/**
	 * This method will add new task in bug tracker system if task parameter of true
	 * 
	 * @param warning
	 *                <ul>
	 *                <li>If true then add a warning in the bug tracking system</li>
	 *                <li>If false then proceed normally</li>
	 *                </ul>
	 * @return
	 * @throws TaskTrackingException
	 */
	@ApiOperation(value = "This api endpoint is to verify that when query parameter "
			+ "task is true then new issue is added to the bug tracking system otherwise not")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = ResponseMapper.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class) })
	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public ResponseEntity<?> methodWarning(
			@RequestParam(value = "task", required = false, defaultValue = "true") boolean task)
			throws TaskTrackingException {
		ResponseMapper response = new ResponseMapper();
		response.setSuccess(service.addTask(task));
		response.setMessage("No task was registerd");
		return ResponseEntity.ok(response);

	}
	
	/**
	 * This api endpoint will add new user story in bug tracking system
	 * @param mapper
	 * @param errors
	 * @return
	 * @throws BindException 
	 */
	@ApiOperation(value = "This api endpoint will add new user story in bug tracking system")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = ResponseMapper.class),
		@ApiResponse(code = 400, message = "Bad Request", response = ApiError.class), 
			@ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class) })
	@RequestMapping(value = "/story", method = RequestMethod.POST)
	public ResponseEntity<?> validation(@Validated() @RequestBody() UserStoryMapper mapper, BindingResult errors) throws BindException {
		if (errors.hasErrors()) {
			throw new BindException(errors);
		}
		service.addStory(mapper);
		ResponseMapper response = new ResponseMapper();
		response.setSuccess(true);
		response.setMessage("New story was registerd");
		return ResponseEntity.ok(response);
		
		
	}
}
