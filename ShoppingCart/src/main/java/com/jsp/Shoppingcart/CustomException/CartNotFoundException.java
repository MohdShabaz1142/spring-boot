package com.jsp.Shoppingcart.CustomException;

public class CartNotFoundException extends RuntimeException {
	
	private String message;
	public CartNotFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
}
