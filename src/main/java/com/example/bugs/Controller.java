package com.example.bugs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bugs.exceptions.BugTrackerException;
import com.example.bugs.exceptions.WarningTrackingException;
import com.example.bugs.mapper.ResponseMapper;
import com.example.bugs.services.IBusinessLogicService;

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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> index() {
		ResponseMapper response = new ResponseMapper();
		response.setSuccess(true);
		response.setMessage("Welcome to the api");
		return ResponseEntity.ok(response);
	}

	/**
	 * This method will invoke the bug tracker module if bug parameter of true
	 * 
	 * @param bug
	 *            <ul>
	 *            <li>If true then add a bug in the bug tracking system</li>
	 *            <li>If false then proceed normally</li>
	 *            </ul>
	 * @return
	 * @throws BugTrackerException
	 */
	@RequestMapping(value = "/bug", method = RequestMethod.GET)
	public ResponseEntity<?> methodBug(
			@RequestParam(value = "bug", required = false, defaultValue = "true") boolean bug)
			throws BugTrackerException {
		ResponseMapper response = new ResponseMapper();
		response.setSuccess(service.someBusinessLogic(bug));
		response.setMessage("No bug was registerd");
		return ResponseEntity.ok(response);
	}

	/**
	 * This method will invoke the bug tracker module if warning parameter of true
	 * 
	 * @param warning
	 *                <ul>
	 *                <li>If true then add a warning in the bug tracking system</li>
	 *                <li>If false then proceed normally</li>
	 *                </ul>
	 * @return
	 * @throws WarningTrackingException
	 */
	@RequestMapping(value = "/warning", method = RequestMethod.GET)
	public ResponseEntity<?> methodWarning(
			@RequestParam(value = "warning", required = false, defaultValue = "true") boolean warning)
			throws WarningTrackingException {
		ResponseMapper response = new ResponseMapper();
		response.setSuccess(service.someOtherBusinessLogic(warning));
		response.setMessage("No warning was registerd");
		return ResponseEntity.ok(response);

	}
}
