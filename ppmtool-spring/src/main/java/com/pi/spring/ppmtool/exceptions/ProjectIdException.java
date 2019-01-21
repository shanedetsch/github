package com.pi.spring.ppmtool.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException
{
	

	private static final long serialVersionUID = 1L;

	public ProjectIdException(String message) {
		super(message);
	}

}
