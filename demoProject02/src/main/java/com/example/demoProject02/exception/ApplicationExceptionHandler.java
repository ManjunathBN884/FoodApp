package com.example.demoProject02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demoProject02.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
@ExceptionHandler(IdNotFound.class)
public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler( IdNotFound idNotFound){
	ResponseStructure<String> structure=new ResponseStructure<String>();
	structure.setMessage(idNotFound.getMessage());
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	structure.setT("No ID Found");
	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
}
}
