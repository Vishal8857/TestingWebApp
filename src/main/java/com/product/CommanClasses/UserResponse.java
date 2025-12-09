package com.product.CommanClasses;


public class UserResponse {
	private String message;
	private String name;

	public UserResponse(String message) {
		super();
		this.message = message;
	}
	public UserResponse(String message, String name) {
		super();
		this.message = message;
		this.name=name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
