package com.example.bugs.tracker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientResponseException;

import com.example.bugs.exceptions.BugTrackerException;
import com.example.bugs.exceptions.TaskTrackingException;


/**
 * This class handles all the know and unknown exception
 * @author pherry
 * @version 1.0
 */
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class ExceptionHandlerAdvice {

	protected final Log logger = LogFactory.getLog(getClass());

	@ExceptionHandler(BugTrackerException.class)
	public ResponseEntity<?> bugTrackerException(BugTrackerException ex) {
		String error = "It seems we have encountered some Hight priority bug in our system. We are working on it, "
				+ "and will be fixed it as soon as possible";
		if (ex.getMessage() != null && !ex.getMessage().isEmpty()) {
			error = ex.getMessage();
		}
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error, ex), ex);
	}
	
	@ExceptionHandler(TaskTrackingException.class)
	public ResponseEntity<?> warningTrackingException(TaskTrackingException ex) {
		String error = "It seems there were some minor performance issue in the system. We are looking into.";
		if (ex.getMessage() != null && !ex.getMessage().isEmpty()) {
			error = ex.getMessage();
		}
		return buildResponseEntity(new ApiError(HttpStatus.OK, error, ex), ex);
	}
	
	@ExceptionHandler(BindException.class)
	public ResponseEntity<?> handleBindException(BindException ex) {
		String error = (ex.getMessage() != null && !ex.getMessage().isEmpty()) ? ex.getMessage()
				: "Payload validation error";
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex), ex);
	}
	
	@ExceptionHandler(RestClientResponseException.class)
	public ResponseEntity<?> restClientResponseException(RestClientResponseException ex) {
		String error = "Bug tracking system is not responding right now.";
		if (ex.getMessage() != null && !ex.getMessage().isEmpty()) {
			error = ex.getMessage();
		}
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error, ex), ex);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception ex) {
		String error = "Our system is currently not able to handle this kind of request."
				+ " Please contact our support team";
		if (ex.getMessage() != null && !ex.getMessage().isEmpty()) {
			error = ex.getMessage();
		}
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error, ex), ex);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError, Exception ex) {

		logger.debug(ex.getStackTrace().toString());

		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
