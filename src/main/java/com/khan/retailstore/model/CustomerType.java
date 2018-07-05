package com.khan.retailstore.model;

/**
 * Represents the Customer type and applicable discounts. discounts can be moved
 * in property file if time allows.
 * 
 * @author shadabkhan
 *
 */
public enum CustomerType {
	EMPLOYEE(30), AFFILIATE(10), PRIVILEGED_CUSTOMER(5);

	private int discount;

	CustomerType(int discount) {
		this.discount = discount;
	}

	public int discount() {
		return discount;
	}
}
