package com.khan.retailstore.service;

import com.khan.retailstore.model.Bill;

/**
 * This service will cater discounts on items offered by retail store.
 * 
 * @author shadabkhan
 *
 */
public interface DiscountService {

	/**
	 * This method will first check if discount is applicable at any item.
	 * Deduct the amount on eligible items. return the discounted amount
	 * 
	 * @param bill
	 * @return
	 */
	double applyPercentageDiscount(Bill bill);

	/**
	 * This method will first check if discount is applicable at total amount.
	 * Deduct the amount if amount exceeding 100.
	 * 
	 * @param totalAmount
	 * @return
	 */
	double applyLargeBillDiscount(double totalAmount);
}
