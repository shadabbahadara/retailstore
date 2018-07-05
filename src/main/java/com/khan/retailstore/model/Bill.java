package com.khan.retailstore.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This model class represents Bill. Assuming bill will have customer type on
 * basis of which we can fetch the eligible discount.
 * 
 * @author shadabkhan
 *
 */
public class Bill {
	private CustomerType customer;
	private List<Item> items;

	public CustomerType getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerType customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		if (items == null) {
			items = new ArrayList<Item>();
		}
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
