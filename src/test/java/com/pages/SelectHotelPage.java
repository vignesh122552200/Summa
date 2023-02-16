package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Vignesh
 * @see Select hotel for POM
 * @date 26/01/2023
 *
 */
public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@class='login_title']")
	private WebElement txtHotelSuccessmsg;
	@FindBy(id="radiobutton_0")
	private WebElement rdoHotelName;
	@FindBy(id="continue")
	private WebElement btnContinue;
	@FindBy(id="radiobutton_span")
	private WebElement txtContinueErrormsg;
	
	public WebElement getHotelSuccessmsg() {
		return txtHotelSuccessmsg;
	}
	public WebElement getBtnHotelName() {
		return rdoHotelName;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public WebElement getContinueErrormsg() {
		return txtContinueErrormsg;
	}
	/**
	 * @see select the hotel
	 */
	public void selectHotel() {
		getClick(getBtnHotelName());
		getClick(getBtnContinue());
	}
	/**
	 * @see without select hotel click continue
	 */
	public void clickContinue() {
		getClick(getBtnContinue());
	}	
}
