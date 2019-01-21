package com.pi.spring.ppmtool.services;

import java.util.*;

import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;

@Service
public class MapValidationErrorService
{

	public ResponseEntity<Map<String, String>> mapValidationService(BindingResult result) {

		if(result.hasErrors()) {
			
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError fieldError: result.getFieldErrors()) {
				errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}
		
		return null;
	}
}
