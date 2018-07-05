package com.khan.retailstore.service;

import com.khan.retailstore.model.Bill;

/**
 * See {@link BillService}.
 * 
 * Assumption: percentage discount will be applied first and then large bill
 * discount.
 * 
 * @author shadabkhan
 *
 */
public class BillServiceImpl implements BillService {

	private DiscountService discountService;

	public BillServiceImpl(DiscountService discountService) {
		this.discountService = discountService;
	}

	@Override
	public double netPayableAmount(Bill bill) {
		double totalAmount = discountService.applyPercentageDiscount(bill);
		return discountService.applyLargeBillDiscount(totalAmount);
	}

}
