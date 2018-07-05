package com.khan.retailstore.service;

import com.khan.retailstore.model.Bill;

/**
 * This service will cater all the applicable discounts on a particular Bill.
 * 
 * @author shadabkhan
 *
 */
public interface BillService {

	/**
	 * This method will deduct applicable percentage and large bill discounts
	 * respectively. Return net amount payable by the customer at the bill
	 * counter.
	 * 
	 * @param bill
	 * @return double
	 */
	double netPayableAmount(Bill bill);
}
