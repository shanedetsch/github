package com.pi.spring.ppmtool.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

@ControllerAdvice  // helps you breakaway having exception handlers that are controller specific
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler
	public static final ResponseEntity<Object> handleProjectIdException(ProjectIdException ex, WebRequest request) {
		ProjectIdExceptionResponse exceptionResponse = new ProjectIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
