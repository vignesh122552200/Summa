package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
/**
 * 
 * @author vignesh
 * @see Step for search hotel
 * @date 26/01/2023
 *
 */
public class TC2_SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	/**
	 * @see search the hotel
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param numberOfRoom
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultPerRoom
	 * @param childPerRoom
	 */
	@Then("User should perform search hotel {string} , {string} , {string} , {string} , {string} , {string} , {string} and {string}")
	public void user_should_perform_search_hotel_and(String location, String hotel, String roomType,
			String numberOfRoom, String checkInDate, String checkOutDate, String adultPerRoom, String childPerRoom) {
		pom.getSearchHotelPage().searchHotel(location, hotel, roomType, numberOfRoom, checkInDate, checkOutDate,
				adultPerRoom, childPerRoom);

	}
	/**
	 * @see select mandatory fields
	 * @param location
	 * @param numberOfRoom
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultPerRoom
	 */
	@Then("User should perform only mandatory fields {string} , {string} , {string} , {string} and {string}")
	public void user_should_perform_only_mandatory_fields_and(String location, String numberOfRoom, String checkInDate,
			String checkOutDate, String adultPerRoom) {
		pom.getSearchHotelPage().searchHotelMandatory(location, numberOfRoom, checkInDate, checkOutDate, adultPerRoom);

	}
	/**
	 * @see verify the error message
	 * @param expCheckInDateErrorMsg
	 * @param expCheckOutDateErrorMsg
	 * @throws InterruptedException
	 */
	@Then("User should verify error message after search hotel by using invalid date {string} , {string}")
	public void user_should_verify_error_message_after_search_hotel_by_using_invalid_date(String expCheckInDateErrorMsg,
			String expCheckOutDateErrorMsg) throws InterruptedException {
		staticWait();
		WebElement checkInErrorMessage = pom.getSearchHotelPage().getCheckInErrorMessage();
		String actCheckInErrorMessage = checkInErrorMessage.getText();
		System.out.println("checkIn :"+actCheckInErrorMessage );
		WebElement checkOutErrorMessage = pom.getSearchHotelPage().getCheckOutErrorMessage();
		String actCheckOutDateErrorMessage = checkOutErrorMessage.getText();
		System.out.println("checkIn :"+actCheckOutDateErrorMessage );

		Assert.assertEquals("Verify the error message in checkInDate field", expCheckInDateErrorMsg,
				actCheckInErrorMessage);
		Assert.assertEquals("Verify the error message in checkInDate field", expCheckOutDateErrorMsg,
				actCheckOutDateErrorMessage);
	}
	/**
	 * @see search hotel without Enter any fields
	 */
	@Then("User should perform search hotel without Enter any fields")
	public void user_should_perform_search_hotel_without_enter_any_fields() {
		pom.getSearchHotelPage().searchHotelWithEnterAnyFields();
	}
	/**
	 * @see verify error message after search hotel in location field
	 * @param expErrorMessage
	 */
	@Then("User should verify error message after search hotel in location field {string}")
	public void user_should_verify_error_message_after_search_hotel_in_location_field(String expErrorMessage) {
		WebElement txtErrorMessage = pom.getSearchHotelPage().getErrorMessage();
		String actErrorMessage = txtErrorMessage.getText();
		Assert.assertEquals("Verify the error  message After without select any field ", expErrorMessage,
				actErrorMessage);

	}

}
