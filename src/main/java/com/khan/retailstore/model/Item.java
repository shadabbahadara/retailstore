package com.khan.retailstore.model;

/**
 * Represents Items offered by retails store.
 * 
 * @author shadabkhan
 *
 */
public class Item {
	private boolean isGrocery;
	private double markedPrice;
	private long quantity;

	public boolean isGrocery() {
		return isGrocery;
	}

	public void setGrocery(boolean isGrocery) {
		this.isGrocery = isGrocery;
	}

	public double getMarkedPrice() {
		return markedPrice;
	}

	public void setMarkedPrice(double itemPrice) {
		this.markedPrice = itemPrice;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

}
