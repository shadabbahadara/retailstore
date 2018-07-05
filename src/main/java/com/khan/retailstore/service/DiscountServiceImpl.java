package com.khan.retailstore.service;

import com.khan.retailstore.model.Bill;
import com.khan.retailstore.model.Item;

/**
 * See {@link DiscountService}.
 * 
 * @author shadabkhan
 *
 */
public class DiscountServiceImpl implements DiscountService {

	@Override
	public double applyPercentageDiscount(Bill bill) {
		int percentageDiscount = bill.getCustomer().discount();
		double totalDiscountedAmount = 0;
		for (Item item : bill.getItems()) {
			double totalMarkedPrice = item.getQuantity() * item.getMarkedPrice();
			if (item.isGrocery()) {
				totalDiscountedAmount = totalDiscountedAmount + totalMarkedPrice;
			} else {
				int discountFactor = 100 - percentageDiscount;
				double discountedAmount = (discountFactor * totalMarkedPrice) / 100;
				totalDiscountedAmount = totalDiscountedAmount + discountedAmount;
			}
		}
		return totalDiscountedAmount;
	}

	@Override
	public double applyLargeBillDiscount(double totalAmount) {
		if (totalAmount >= 100) {
			long largeBillDiscount = ((long) totalAmount / 100) * 5;
			totalAmount = totalAmount - largeBillDiscount;
		}
		return totalAmount;
	}
}
