package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Vignesh
 * @see search hotel for POM
 * @date 26/01/2023
 *
 */
public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location_span")
	private WebElement txtLocationErrorMessage;
	@FindBy(id = "username_show")
	private WebElement txtLoginSucess;
	@FindBy(id = "location")
	private WebElement dDnLocation;
	@FindBy(id = "hotels")
	private WebElement dDnHotel;
	@FindBy(id = "room_type")
	private WebElement dDnRoomType;
	@FindBy(id = "room_nos")
	private WebElement dDnNumberOfRoom;
	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;
	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;
	@FindBy(id = "adult_room")
	private WebElement dDnAdultPerRoom;
	@FindBy(id = "child_room")
	private WebElement dDnChildPerRoom;
	@FindBy(id = "Submit")
	private WebElement btnSearch;
	@FindBy(id = "checkin_span")
	private WebElement txtCheckInErrorMessage;
	@FindBy(id = "checkout_span")
	private WebElement txtCheckOutErrorMessage;

	public WebElement getCheckInErrorMessage() {
		return txtCheckInErrorMessage;
	}

	public WebElement getCheckOutErrorMessage() {
		return txtCheckOutErrorMessage;
	}

	public WebElement getErrorMessage() {
		return txtLocationErrorMessage;
	}

	public WebElement getTextLoginSucess() {
		return txtLoginSucess;
	}

	public WebElement getdDnlocation() {
		return dDnLocation;
	}

	public WebElement getdDnhotel() {
		return dDnHotel;
	}

	public WebElement getdDnroomType() {
		return dDnRoomType;
	}

	public WebElement getdDnnumberOfRoom() {
		return dDnNumberOfRoom;
	}

	public WebElement getTextCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTextCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getdDnadultPerRoom() {
		return dDnAdultPerRoom;
	}

	public WebElement getdDnchildPerRoom() {
		return dDnChildPerRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	/**
	 * @see Search hotel common steps
	 * @param location
	 * @param numberOfRoom
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultPerRoom
	 */
	public void searchCommonStep(String location, String numberOfRoom, String checkInDate, String checkOutDate,
			String adultPerRoom) {

		dropDownText(getdDnlocation(), location);
		dropDownText(getdDnnumberOfRoom(), numberOfRoom);
		textClear(getTextCheckInDate());
		sendvalue(getTextCheckInDate(), checkInDate);
		textClear(getTextCheckOutDate());
		sendvalue(getTextCheckOutDate(), checkOutDate);
		dropDownText(getdDnadultPerRoom(), adultPerRoom);

	}
	/**
	 * @see search hotel
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param numberOfRoom
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultPerRoom
	 * @param childPerRoom
	 */
	public void searchHotel(String location, String hotel, String roomType, String numberOfRoom, String checkInDate,
			String checkOutDate, String adultPerRoom, String childPerRoom) {
		searchCommonStep(location, numberOfRoom, checkInDate, checkOutDate, adultPerRoom);
		dropDownText(getdDnhotel(), hotel);
		dropDownText(getdDnroomType(), roomType);
		dropDownText(getdDnnumberOfRoom(), numberOfRoom);
		dropDownText(getdDnchildPerRoom(), childPerRoom);
		getClick(getBtnSearch());
	}
	/**
	 * @see Search hotel using mandatory fields
	 * @param location
	 * @param numberOfRoom
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultPerRoom
	 */
	public void searchHotelMandatory(String location, String numberOfRoom, String checkInDate, String checkOutDate,
			String adultPerRoom) {
		searchCommonStep(location, numberOfRoom, checkInDate, checkOutDate, adultPerRoom);
		getClick(getBtnSearch());
	}
	/**
	 * @see Search hotel using invalid date
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param numberOfRoom
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultPerRoom
	 * @param childPerRoom
	 */
	public void seacrhHotelByInvalidDate(String location, String hotel, String roomType, String numberOfRoom,
			String checkInDate, String checkOutDate, String adultPerRoom, String childPerRoom) {
		searchCommonStep(location, numberOfRoom, checkInDate, checkOutDate, adultPerRoom);
		dropDownText(getdDnroomType(), roomType);
		dropDownText(getdDnnumberOfRoom(), numberOfRoom);
		dropDownText(getdDnchildPerRoom(), childPerRoom);
		getClick(getBtnSearch());
	}
	/**
	 * @see Search the hotel with out entered any fields 
	 */
	public void searchHotelWithEnterAnyFields() {
		getClick(getBtnSearch());
	}

}
