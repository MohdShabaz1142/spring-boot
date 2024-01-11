package com.jsp.Shoppingcart.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.Shoppingcart.Response;

@RestControllerAdvice
public class ApplicationHandler 
{
	

	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<Response<String>> CartNotFoundException(CartNotFoundException ex){
		Response<String> res=new Response<>();
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		res.setMessage("Cart  not Found With Id");
		res.setData(ex.getMessage());
		
		return new ResponseEntity<Response<String>>(res,HttpStatus.NOT_FOUND);
	}
}
