package com.jsp.Shoppingcart;

import java.util.List;

public class Response<T> 
{
	private int statusCode;
	private String message;
	private T data;
	private List<T> list;
	private Object exceptionData;
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Object getExceptionData() {
		return exceptionData;
	}
	public void setExceptionData(Object exceptionData) {
		this.exceptionData = exceptionData;
	}
	
	
	
	
	

}
