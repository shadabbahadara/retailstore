package com.khan.retailstore.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.khan.retailstore.model.Bill;
import com.khan.retailstore.model.CustomerType;

/**
 * unit under test {@link DiscountService}.
 * 
 * @author shadabkhan
 *
 */
public class DiscountServiceTest {

	private DiscountService testee = testee();

	// Employee
	@Test
	public void applyPercentageDiscountOnEployeeBillShouldNotDiscountOnGroceryItems() {
		Bill bill = BillTestFactory.createBillWithGrtoceryItems();
		bill.setCustomer(CustomerType.EMPLOYEE);
		double expectedAmount = 100.0;
		double actualAmount = testee.applyPercentageDiscount(bill);
		assertThat("Discount is deducted inappropriately: ", expectedAmount, equalTo(actualAmount));
	}

	@Test
	public void applyPercentageDiscountOnEployeeBillShouldDiscountOnNonGroceryItems() {
		Bill bill = BillTestFactory.createBillWithNonGrtoceryItems();
		bill.setCustomer(CustomerType.EMPLOYEE);
		double expectedAmount = 70.0; // 30% discount
		double actualAmount = testee.applyPercentageDiscount(bill);
		assertThat("Discount is deducted inappropriately: ", expectedAmount, equalTo(actualAmount));
	}

	@Test
	public void applyPercentageDiscountOnEployeeBillShouldDiscountOnlyonNonGroceryItems() {
		Bill bill = BillTestFactory.createBillWithItems();
		bill.setCustomer(CustomerType.EMPLOYEE);
		double expectedAmount = 170.0;
		double actualAmount = testee.applyPercentageDiscount(bill);
		assertThat("Discount is deducted inappropriately: ", expectedAmount, equalTo(actualAmount));
	}

	// Affiliate
	@Test
	public void applyPercentageDiscountOnAffiliateBillShouldNotDiscountOnGroceryItems() {
		Bill bill = BillTestFactory.createBillWithGrtoceryItems();
		bill.setCustomer(CustomerType.AFFILIATE);
		double expectedAmount = 100.0;
		double actualAmount = testee.applyPercentageDiscount(bill);
		assertThat("Discount is deducted inappropriately: ", expectedAmount, equalTo(actualAmount));
	}

	@Test
	public void applyPercentageDiscountOnAffiliateBillShouldDiscountOnNonGroceryItems() {
		Bill bill = BillTestFactory.createBillWithNonGrtoceryItems();
		bill.setCustomer(CustomerType.AFFILIATE);
		double expectedAmount = 90.0; // 10% discount
		double actualAmount = testee.applyPercentageDiscount(bill);
		assertThat("Discount is deducted inappropriately: ", expectedAmount, equalTo(actualAmount));
	}

	@Test
	public void applyPercentageDiscountOnAffiliateBillShouldDiscountOnlyonNonGroceryItems() {
		Bill bill = BillTestFactory.createBillWithItems();
		bill.setCustomer(CustomerType.AFFILIATE);
		double expectedAmount = 190.0;
		double actualAmount = testee.applyPercentageDiscount(bill);
		assertThat("Discount is deducted inappropriately: ", expectedAmount, equalTo(actualAmount));
	}

	// PRIVILEGED - customer for more than 2 years
	@Test
	public void applyPercentageDiscountOnPrivilegedBillShouldNotDiscountOnGroceryItems() {
		Bill bill = BillTestFactory.createBillWithGrtoceryItems();
		bill.setCustomer(CustomerType.PRIVILEGED_CUSTOMER);
		double expectedAmount = 100.0;
		double actualAmount = testee.applyPercentageDiscount(bill);
		assertThat("Discount is deducted inappropriately: ", expectedAmount, equalTo(actualAmount));
	}

	@Test
	public void applyPercentageDiscountOnPrivilegedBillShouldDiscountOnNonGroceryItems() {
		Bill bill = BillTestFactory.createBillWithNonGrtoceryItems();
		bill.setCustomer(CustomerType.PRIVILEGED_CUSTOMER);
		double expectedAmount = 95.0; // 5% discount
		double actualAmount = testee.applyPercentageDiscount(bill);
		assertThat("Discount is deducted inappropriately: ", expectedAmount, equalTo(actualAmount));
	}

	@Test
	public void applyPercentageDiscountOnPrivilegedBillShouldDiscountOnlyonNonGroceryItems() {
		Bill bill = BillTestFactory.createBillWithItems();
		bill.setCustomer(CustomerType.PRIVILEGED_CUSTOMER);
		double expectedAmount = 195.0;
		double actualAmount = testee.applyPercentageDiscount(bill);
		assertThat("Discount is deducted inappropriately: ", expectedAmount, equalTo(actualAmount));
	}

	@Test
	public void applyLargeBillDiscountShouldNotDiscountOnSmallBill() {
		double expectedAmount = 99.5;
		double actualAmount = testee.applyLargeBillDiscount(expectedAmount);
		assertThat("Discount is deducted inspite of small bill: ", expectedAmount, equalTo(actualAmount));
	}

	@Test
	public void applyLargeBillDiscountShouldDiscountOnLargeBill() {
		double expectedAmount = 954.5;
		double actualAmount = testee.applyLargeBillDiscount(999.5);
		assertThat("Discount is deducted inappropriately: ", expectedAmount, equalTo(actualAmount));
	}

	private DiscountService testee() {
		return new DiscountServiceImpl();
	}
}
