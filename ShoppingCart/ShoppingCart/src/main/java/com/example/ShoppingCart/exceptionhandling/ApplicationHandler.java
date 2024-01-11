package com.example.ShoppingCart.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ShoppingCart.Response.Response;

@RestControllerAdvice//-->handles the exceptions globally in project
public class ApplicationHandler
{
	
	@ExceptionHandler
public ResponseEntity<Response<String>>cartByIdNotFound(CartNotFoundException ex)
{
	Response<String>rs=new Response<>();
	rs.setStatuscode(HttpStatus.NOT_FOUND.value());
	rs.setMessage(ex.getMessage());
	rs.setExceptiondata("the specified CartId is not present");
	return new ResponseEntity<Response<String>>(rs,HttpStatus.NOT_FOUND);
}
}
