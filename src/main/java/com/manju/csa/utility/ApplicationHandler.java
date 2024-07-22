package com.manju.csa.utility;

import javax.management.ServiceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.manju.csa.exception.CarNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> carNotFoundByIdException(CarNotFoundException ce)
	{
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(ce.getMessage());
		es.setData("Car with the requested Id is not present in the Database");
		return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> serviceNotFoundException (ServiceNotFoundException se)
	{ ErrorStructure<String> es = new ErrorStructure<String>();
	es.setStatusCode(HttpStatus.NOT_FOUND.value());
	es.setMessage(se.getMessage());
	es.setData("Service with the requested Id is not present in the Database");
	return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);

	}
}
