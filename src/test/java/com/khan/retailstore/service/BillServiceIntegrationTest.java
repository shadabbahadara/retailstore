package com.khan.retailstore.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.khan.retailstore.model.Bill;
import com.khan.retailstore.model.CustomerType;

/**
 * Integration test class to test the discounts on a bill.
 * 
 * @author shadabkhan
 *
 */
public class BillServiceIntegrationTest {

	private DiscountService discountService = new DiscountServiceImpl();

	private BillService billService = new BillServiceImpl(discountService);

	@Test
	public void netPayableAmountShouldApplyAllAplicableDiscounts() {
		Bill bill = BillTestFactory.createBillWithItems();
		bill.setCustomer(CustomerType.EMPLOYEE);
		double expectedAmopunt = 165.0;
		double actualAmount = billService.netPayableAmount(bill);
		assertThat("Discount is deducted inappropriately: ", expectedAmopunt, equalTo(actualAmount));
	}

}
