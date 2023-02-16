package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Vignesh
 * @see Booking confirmation for POM
 * @date 26/01/2023
 *
 */
public class BookingConfirmationPage extends BaseClass {
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_no")
	private WebElement txtOrderNO;

	public WebElement getTextOrderNO() {
		return txtOrderNO;
	}
	/**
	 * @see get the order ID
	 * @return
	 */
	public String getOrderID() {
		String orderNumber = getAttributevalue(txtOrderNO);
		return orderNumber;
	}
}
