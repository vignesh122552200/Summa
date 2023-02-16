package com.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

import io.cucumber.datatable.DataTable;
/**
 * 
 * @author Vignesh
 * @see BookHotel for POM
 * @date 26/01/2023
 *
 */
public class BookHotelPage extends BaseClass {
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[contains(text(),'Book A Hotel ')]")
	private WebElement txtBookAHotelSuccessmsg;
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	@FindBy(id="last_name")
	private WebElement txtLastName;
	@FindBy(id="address")
	private WebElement txtAddress;
	@FindBy(id="cc_num")
	private WebElement txtCreditCardNumber;
	@FindBy(id="cc_type")
	private WebElement dDnCreditCardType;
	@FindBy(id="cc_exp_month")
	private WebElement dDnMonth;
	@FindBy(id="cc_exp_year")
	private WebElement dDnYear;
	@FindBy(id="cc_cvv")
	private WebElement txtCCVNumber;
	@FindBy(id="book_now")
	private WebElement btnBookNow;
	@FindBy(id="first_name_span")
	private WebElement txtErrorMsgFirstName;
	@FindBy(id="last_name_span")
	private WebElement txtErrorMsgLastName;
	@FindBy(id="address_span")
	private WebElement txtErrorMsgAddress;
	@FindBy(id="cc_num_span")
	private WebElement txtErrorMsg16DigitCreditCard;
	@FindBy(id="cc_type_span")
	private WebElement txtErrorMsgCreditCardType;
	@FindBy(id="cc_expiry_span")
	private WebElement txtErrorMsgCreditCardExMonth;
	@FindBy(id="cc_cvv_span")
	private WebElement txtErrorMsgCCVNumber;
	@FindBy(xpath="//td[contains(text(),'Booking Confirmation ')]")
	private WebElement txtBookingSuccessMessage;
	@FindBy(id="order_no")
	private WebElement txtBookingOrderNumber;
	
	
	public WebElement getBookAHotelSuccessmsg() {
		return txtBookAHotelSuccessmsg;
	}
	public WebElement getTextFirstName() {
		return txtFirstName;
	}
	public WebElement getTextLastName() {
		return txtLastName;
	}
	public WebElement getTextAddress() {
		return txtAddress;
	}
	public WebElement getTextCreditCardNumber() {
		return txtCreditCardNumber;
	}
	public WebElement getdDnCreditCardType() {
		return dDnCreditCardType;
	}
	public WebElement getdDnMonth() {
		return dDnMonth;
	}
	public WebElement getdDnYear() {
		return dDnYear;
	}
	public WebElement getTextCCVNumber() {
		return txtCCVNumber;
	}
	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
	
	public WebElement getErrorMsgFirstName() {
		return txtErrorMsgFirstName;
	}
	public WebElement getErrorMsgLastName() {
		return txtErrorMsgLastName;
	}
	public WebElement getErrorMsgAddress() {
		return txtErrorMsgAddress;
	}
	public WebElement getErrorMsg16DigitCreditCard() {
		return txtErrorMsg16DigitCreditCard;
	}
	public WebElement getErrorMsgCreditCardType() {
		return txtErrorMsgCreditCardType;
	}
	public WebElement getErrorMsgCreditCardExMonth() {
		return txtErrorMsgCreditCardExMonth;
	}
	public WebElement getErrorMsgCCVNumber() {
		return txtErrorMsgCCVNumber;
	}
	
	public WebElement getBookingSuccessMessage() {
		return txtBookingSuccessMessage;
	}
	public WebElement getBookingOrderNumber() {
		return txtBookingOrderNumber;
	}
	/**
	 * @see book hotel select all fields
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 */
	public void bookHotel(String firstName,String lastName,String address,DataTable dataTable) {
		sendvalue(getTextFirstName(), firstName);
		sendvalue(getTextLastName(), lastName);
		sendvalue(getTextAddress(), address);
		
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
		
		sendvalue(getTextCreditCardNumber(), (data.get(1).get("creditCardNo")));
		dropDownText(getdDnCreditCardType(), (data.get(1).get("creditCardType")));
		dropDownText(getdDnMonth(), (data.get(1).get("expiryMonth")));
		dropDownText(getdDnYear(), (data.get(1).get("expiryYear")));
		sendvalue(getTextCCVNumber(), (data.get(1).get("cVVNumber")));
		getClick(getBtnBookNow());
		implicitywait(60);
		
	}
	/**
	 * @see without select any field to click book a hotel
	 */
	public void bookHotel() {
		getClick(getBtnBookNow());
	}
	/**
	 * @see Get the booking order number
	 */
	public void bookingordernumber() {
		String ordernumber = valueTextbox(getBookingOrderNumber());
		System.out.println(ordernumber);
	}
	
	

}
