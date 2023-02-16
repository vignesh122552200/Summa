package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import junit.framework.Assert;
/**
 * 
 * @author vignesh
 * @see Step for loselect hotel
 * @date 26/01/2023
 *
 */
public class TC3_SelectHotelStep {
	
	PageObjectManager pom=new PageObjectManager();
	/**
	 * @see select a hotel
	 */
	@Then("User should perform select hotel and continue")
	public void user_should_perform_select_hotel_and_continue() {
		pom.getSelectHotelPage().selectHotel();
		
	}
	/**
	 * @see click the continue
	 */
	@Then("User should perform continue")
	public void user_should_perform_continue() {
		pom.getSelectHotelPage().clickContinue();
		
	}
	/**
	 * @see verify the error message
	 * @param expContinueErrorMessage
	 */
	@Then("User should verify error message after continue {string}")
	public void user_should_verify_error_message_after_continue(String expContinueErrorMessage) {
		WebElement txtContinueErrormsg = pom.getSelectHotelPage().getContinueErrormsg();
		String actContinueErrorMessage = txtContinueErrormsg.getText();
		Assert.assertEquals("Verify the error message with select hotel by click continue", expContinueErrorMessage,actContinueErrorMessage);
		
	}

}
