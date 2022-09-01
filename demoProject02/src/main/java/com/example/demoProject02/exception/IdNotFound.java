package com.example.demoProject02.exception;

public class IdNotFound extends RuntimeException {
String message="Invalid ID";
@Override
public String getMessage() {
	return message;
}
}
