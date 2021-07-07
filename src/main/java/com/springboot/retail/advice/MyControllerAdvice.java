package com.springboot.retail.advice;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.retail.exception.AccCreationEmptyInputException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(AccCreationEmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(AccCreationEmptyInputException emptyInputException){
		return new ResponseEntity<String>("Name & Role Fields Cannot Be Empty" , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException){
		return new ResponseEntity<String>("Customer Id is invalid , Please provide a valid Id" , HttpStatus.NOT_FOUND);
	}
}
