package com.stepdefinition;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.netty.handler.codec.http.multipart.Attribute;
import junit.framework.Assert;

/**
 * 
 * @author vignesh
 * @see Step for book hotel
 * @date 26/01/2023
 *
 */
public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();
	
	/**
	 * @see book hotel
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 */
	@Then("User should perform book hotel {string} , {string} and {string}")
	public void user_should_perform_book_hotel_and(String firstName, String lastName, String address, io.cucumber.datatable.DataTable dataTable) {
		pom.getBookHotelPage().bookHotel(firstName, lastName, address, dataTable);
		WebElement txtBookingOrderNumber = pom.getBookHotelPage().getBookingOrderNumber();
		String txtOrdernumber = txtBookingOrderNumber.getAttribute("value");
		System.out.println(txtOrdernumber);
	}
	/**
	 * @see verify the success message
	 * @param expBookingConfirmationSucessMessage
	 */
	@Then("User should verify sucess message after book hotel {string} and save the order id")
	public void user_should_verify_sucess_message_after_book_hotel_and_save_the_order_id(String expBookingConfirmationSucessMessage) {
		
		WebElement bookAHotelSuccessmsg = pom.getBookHotelPage().getBookingSuccessMessage();
		String actBookingConfirmationMessage = bookAHotelSuccessmsg.getText();
		Assert.assertEquals("Verify the Booking confirmation message", expBookingConfirmationSucessMessage,actBookingConfirmationMessage);
	}
	/**
	 * @see without select any fields
	 */
	@Then("User should perform book hotel without select any fields")
	public void user_should_perform_book_hotel_without_select_any_fields() {
		pom.getBookHotelPage().bookHotel();
	 
	}
	/**
	 * @see verify the error message
	 * @param expFirstNameErrorMsg
	 * @param expLastNameErrorMsg
	 * @param expAddressMsg
	 * @param exp16DigitCardMsg
	 * @param expCreditCardTypeMsg
	 * @param expCreditCardExMonthMsg
	 * @param expCCVNumberMsg
	 */
	@Then("User should verify error message after book hotel {string} , {string} , {string} , {string} , {string} , {string} and {string}")
	public void user_should_verify_error_message_after_book_hotel_and(String expFirstNameErrorMsg, String expLastNameErrorMsg, String expAddressMsg, String exp16DigitCardMsg, String expCreditCardTypeMsg, String expCreditCardExMonthMsg, String expCCVNumberMsg) {
		WebElement txtErrorMsgFirstName = pom.getBookHotelPage().getErrorMsgFirstName();
		String actErrorMsgFirstName = txtErrorMsgFirstName.getText();
		System.out.println(actErrorMsgFirstName);
		
		WebElement errorMsgLastName = pom.getBookHotelPage().getErrorMsgLastName();
		String actErrorMsgLastName = errorMsgLastName.getText();
		System.out.println(actErrorMsgLastName);
		
		WebElement errorMsgAddress = pom.getBookHotelPage().getErrorMsgAddress();
		String actErrorMsgAddress = errorMsgAddress.getText();
		System.out.println(actErrorMsgAddress);
		
		WebElement ErrorMsg16DigitCreditCard = pom.getBookHotelPage().getErrorMsg16DigitCreditCard();
		String actErrorMsg16DigitCreditCard = ErrorMsg16DigitCreditCard.getText();
		System.out.println(actErrorMsg16DigitCreditCard);
		
		WebElement ErrorMsgCreditCardType = pom.getBookHotelPage().getErrorMsgCreditCardType();
		String actErrorMsgCreditCardType = ErrorMsgCreditCardType.getText();
		System.out.println(actErrorMsgCreditCardType);
		
		WebElement ErrorMsgCreditCardExMonth = pom.getBookHotelPage().getErrorMsgCreditCardExMonth();
		String actErrorMsgCreditCardExMonth = ErrorMsgCreditCardExMonth.getText();
		System.out.println(actErrorMsgCreditCardExMonth);
		
		WebElement ErrorMsgCCVNumber = pom.getBookHotelPage().getErrorMsgCCVNumber();
		String actErrorMsgCCVNumber = ErrorMsgCCVNumber.getText();
		System.out.println(actErrorMsgCCVNumber);
		
		Assert.assertEquals("Verify the error message firstName", expFirstNameErrorMsg,actErrorMsgFirstName);
		Assert.assertEquals("Verify the error message lastName", expLastNameErrorMsg,actErrorMsgLastName);
//		Assert.assertEquals("Verify the error message address", expAddressMsg,actErrorMsgAddress);
		Assert.assertEquals("Verify the error message creditcardnumber", exp16DigitCardMsg,actErrorMsg16DigitCreditCard);
		Assert.assertEquals("Verify the error message creditcardtype", expCreditCardTypeMsg,actErrorMsgCreditCardType);
		Assert.assertEquals("Verify the error message month", expCreditCardExMonthMsg,actErrorMsgCreditCardExMonth);
		Assert.assertEquals("Verify the error message ccvNumber", expCCVNumberMsg,actErrorMsgCCVNumber);
		
	    
	}











}
