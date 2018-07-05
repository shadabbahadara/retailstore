package com.khan.retailstore.service;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.khan.retailstore.model.Bill;
import com.khan.retailstore.model.CustomerType;

/**
 * unit under test {@link BillService}.
 * 
 * @author shadabkhan
 *
 */
public class BillServiceTest {

	private DiscountService discountService = mock(DiscountService.class);

	private BillService testee = testee();

	@Test
	public void netPayableAmount() {
		Bill employeeBill = BillTestFactory.createBillWithItems();
		employeeBill.setCustomer(CustomerType.EMPLOYEE);
		testee.netPayableAmount(employeeBill);
		verify(discountService).applyPercentageDiscount(employeeBill);
		verify(discountService).applyLargeBillDiscount(anyDouble());
	}

	private BillService testee() {
		return new BillServiceImpl(discountService);
	}

}
