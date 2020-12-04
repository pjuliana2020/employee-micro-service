package com.brighttalk.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeRecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmployeeRecordNotFoundException(String message) {
		super(message);
	}
	
	public EmployeeRecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
