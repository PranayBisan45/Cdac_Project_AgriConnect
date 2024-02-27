package com.demo.Model;

public class Order_Front {
	
	private String OrderID;
	private String OrderedOn;
	private String OrderPrice;
	
	public Order_Front() {
		super();
	}

	public Order_Front(String orderID, String orderedOn, String orderPrice) {
		super();
		OrderID = orderID;
		OrderedOn = orderedOn;
		OrderPrice = orderPrice;
	}

	public String getOrderID() {
		return OrderID;
	}

	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	public String getOrderedOn() {
		return OrderedOn;
	}

	public void setOrderedOn(String orderedOn) {
		OrderedOn = orderedOn;
	}

	public String getOrderPrice() {
		return OrderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		OrderPrice = orderPrice;
	}

	@Override
	public String toString() {
		return "Order_Front [OrderID=" + OrderID + ", OrderedOn=" + OrderedOn + ", OrderPrice=" + OrderPrice + "]";
	}
	
}
