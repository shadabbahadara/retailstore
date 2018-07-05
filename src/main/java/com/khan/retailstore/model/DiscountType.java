package com.khan.retailstore.model;

public enum DiscountType {
	EMPLOYEE(30), AFFILIATE(10), PRIVILEGED_CUSTOMER(5), LARGE_BILL(5);

	private int discount;

	DiscountType(int discount) {
		this.discount = discount;
	}

	public int discount() {
		return discount;
	}
}
