package com.demo.exceptions;

public class EmployeeNotFound extends RuntimeException {
	public EmployeeNotFound(){
		
	}
	public EmployeeNotFound(String msg){
		super(msg);
	}
}
