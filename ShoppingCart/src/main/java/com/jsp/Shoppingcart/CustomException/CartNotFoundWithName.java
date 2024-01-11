package com.jsp.Shoppingcart.CustomException;

public class CartNotFoundWithName extends RuntimeException
{
	public CartNotFoundWithName(String message) {
		super(message);
	}

}
