package com.example.ShoppingCart.Response;

import java.util.List;

import com.example.ShoppingCart.entity.Cart;

public class Response<Cart>
{
private int statuscode;
private String message;
private Cart data;
private List<Cart> list;
private String Exceptiondata;



public String getExceptiondata() {
	return Exceptiondata;
}
public void setExceptiondata(String exceptiondata) {
	Exceptiondata = exceptiondata;
}
public int getStatuscode() {
	return statuscode;
}
public void setStatuscode(int statuscode) {
	this.statuscode = statuscode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Cart getData() {
	return data;
}
public void setData(Cart data) {
	this.data = data;
}
public List<Cart> getList() {
	return list;
}
public void setList(List<Cart> list) {
	this.list = list;
}



}
