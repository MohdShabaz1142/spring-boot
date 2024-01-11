package com.example.ShoppingCart.exceptionhandling;

public class CartNotFoundException extends RuntimeException
{
private String message;

public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

public CartNotFoundException (String message)
{
	super(message);
}
}
