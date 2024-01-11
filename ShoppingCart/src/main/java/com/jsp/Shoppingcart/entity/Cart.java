package com.jsp.Shoppingcart.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Cart
{
	@Id
	private int cId;
	private String cName;
	private int cItems;
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getcItems() {
		return cItems;
	}
	public void setcItems(int cItems) {
		this.cItems = cItems;
	}
	@Override
	public String toString() {
		return "Cart [cId=" + cId + ", cName=" + cName + ", cItems=" + cItems + "]";
	}
	
	

}
