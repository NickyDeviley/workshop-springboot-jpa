package com.educandoweb.course.services.exceptions;

public class DatabaseException extends RuntimeException {

	private static final long serialVersionID = 1L;
	
	public DatabaseException (String msg) {
		super(msg);
	}
	
}
