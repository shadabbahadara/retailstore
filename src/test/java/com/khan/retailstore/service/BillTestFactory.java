package com.khan.retailstore.service;

import java.util.ArrayList;
import java.util.List;

import com.khan.retailstore.model.Bill;
import com.khan.retailstore.model.Item;

/**
 * test data repository.
 * 
 * @author shadabkhan
 *
 */
public class BillTestFactory {

	public static Bill createBillWithGrtoceryItems() {

		List<Item> items = new ArrayList<>();
		items.add(createGroceryItem());

		Bill bill = new Bill();
		bill.setItems(items);
		return bill;
	}

	public static Bill createBillWithNonGrtoceryItems() {

		List<Item> items = new ArrayList<>();
		items.add(createNonGroceryItem());

		Bill bill = new Bill();
		bill.setItems(items);
		return bill;
	}

	public static Bill createBillWithItems() {

		List<Item> items = new ArrayList<>();
		items.add(createGroceryItem());
		items.add(createNonGroceryItem());

		Bill bill = new Bill();
		bill.setItems(items);
		return bill;
	}

	private static Item createGroceryItem() {
		Item chocolate = new Item();
		chocolate.setGrocery(true);
		chocolate.setMarkedPrice(100);
		chocolate.setQuantity(1);
		return chocolate;
	}

	private static Item createNonGroceryItem() {
		Item toothpaste = new Item();
		toothpaste.setGrocery(false);
		toothpaste.setMarkedPrice(100);
		toothpaste.setQuantity(1);
		return toothpaste;
	}

}
