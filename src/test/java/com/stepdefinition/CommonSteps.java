package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import junit.framework.Assert;
import org.junit.*;
/**
 * 
 * @author vignesh
 * @see Maintain the common steps
 * @date 26/01/2023
 *
 */
public class CommonSteps {
	PageObjectManager pom=new PageObjectManager();
	private String text;
	
	@Then("User should verify after login success message {string}")
	public void user_should_verify_after_login_success_message(String expLoginSuccessmsg) {
		WebElement textLoginSucess = pom.getSearchHotelPage().getTextLoginSucess();
		String actLoginmsg = textLoginSucess.getAttribute("value");
		Assert.assertEquals("Verify after login sucess message", expLoginSuccessmsg,actLoginmsg);
	}
	@Then("User should verify after search hotel sucess message {string}")
	public void user_should_verify_after_search_hotel_sucess_message(String expSearchSuccessMsg) {
		WebElement element = pom.getSelectHotelPage().getHotelSuccessmsg();
		String actSuccessMessage = element.getText();
		Assert.assertEquals("Verify the after search hotel success message", expSearchSuccessMsg,actSuccessMessage);	
	}
	
	@Then("User should verify sucess message after continue {string}")
	public void user_should_verify_sucess_message_after_continue(String expBookAHotelSuccessMsg) {
		WebElement bookAHotelSuccessmsg = pom.getBookHotelPage().getBookAHotelSuccessmsg();
		String actBookAHotelMsg = bookAHotelSuccessmsg.getText();
		System.out.println("Message: "+actBookAHotelMsg);
		Assert.assertEquals("Verify the after select hotel sucess message", expBookAHotelSuccessMsg,actBookAHotelMsg);
	}
	@Then("User should verify success message after cancel Booking {string}")
	public void user_should_verify_success_message_after_cancel_booking(String expBookingCanccelMsg) {
	   WebElement bookingCancelSucessMsg = pom.getCancelBookingPage().getBookingCancelSucessMsg();
	   String actBookingCancelSuccessMsg  = bookingCancelSucessMsg.getText();
	   Assert.assertEquals("Verify the booking cancel Success Message", expBookingCanccelMsg,actBookingCancelSuccessMsg);
	}

}
