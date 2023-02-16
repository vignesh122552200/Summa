package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Vignesh
 * @see Cancel booking for POM
 * @date 26/01/2023
 *
 */
public class CancelBookingPage extends BaseClass {
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),\"Booked Itinerary\")]")
	private WebElement btnBookedItinerary;
	@FindBy(id="order_id_text")
	private WebElement txtSearchOrderId;
	@FindBy(id="search_hotel_id")
	private WebElement btnGo;
	@FindBy(xpath="//input[@name='ids[]']")
	private WebElement chkBox;
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement btnCancel;
	@FindBy(xpath="//label[contains(text(),'The booking has been cancelled.')]")
	private WebElement txtBookingCancelSucessMsg;
	
	public WebElement getBtnBookedItinerary() {
		return btnBookedItinerary;
	}
	public WebElement getTextSearchOrderId() {
		return txtSearchOrderId;
	}
	public WebElement getBtnGo() {
		return btnGo;
	}
	public WebElement getCheckBox() {
		return chkBox;
	}
	public WebElement getBtnCancel() {
		return btnCancel;
	}
	public WebElement getBookingCancelSucessMsg() {
		return txtBookingCancelSucessMsg;
	}
	/**
	 * @see cancel the order ID
	 * @param orderId
	 */
	public void cancelOrderId(String orderId) {
		getClick(btnBookedItinerary);
		sendvalue(txtSearchOrderId, orderId);
		getClick(btnGo);
		getClick(chkBox);
		getClick(btnCancel);
		getAcceptAlert();
	}
	
}
