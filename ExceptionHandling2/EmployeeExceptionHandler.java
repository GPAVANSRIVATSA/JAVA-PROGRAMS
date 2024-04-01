package com.Exception.ExceptionHandler.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<EmployeeError> employeeNotFound(EmployeeNotFoundException exc)
	{
		EmployeeError employeeError=new EmployeeError();
		employeeError.setStatus(HttpStatus.NOT_FOUND.value());
		employeeError.setMessage(exc.getMessage());
		employeeError.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(employeeError,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<EmployeeError> employeeNotFound(Exception exc)
	{
		EmployeeError employeeError=new EmployeeError();
		employeeError.setStatus(HttpStatus.BAD_REQUEST.value());
		employeeError.setMessage(exc.getMessage());
		employeeError.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(employeeError,HttpStatus.BAD_REQUEST);
	}

}
