package com.stepdefinition;

import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
/**
 * 
 * @author vignesh
 * @see Step for cancel booking
 * @date 26/01/2023
 *
 */
public class TC5_CancelBookingStep {
	PageObjectManager pom = new PageObjectManager();
	/**
	 * @see Booking confirm hotel
	 */
	@Then("User should perfom cancel Booking")
	public void user_should_perfom_cancel_booking() {
		String orderID = pom.getBookingConfirmationPage().getOrderID();
		System.out.println("Booking order number: "+orderID);
		pom.getCancelBookingPage().cancelOrderId(orderID);
	}
	/**
	 * @see Cancel Booking confirm hotel
	 */
	@Then("User should perfom cancel Booking {string}")
	public void user_should_perfom_cancel_booking(String orderId) {
		pom.getCancelBookingPage().cancelOrderId(orderId);
	}
}
