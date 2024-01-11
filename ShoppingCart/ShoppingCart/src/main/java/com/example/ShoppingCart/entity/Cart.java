package com.example.ShoppingCart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cart 
{
	@Id
private int cid;
private String cname;
private int citems;

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public int getCitems() {
	return citems;
}
public void setCitems(int citems) {
	this.citems = citems;
}
@Override
public String toString() {
	return "Cart [cid=" + cid + ", cname=" + cname + ", citems=" + citems + "]";
}


}
