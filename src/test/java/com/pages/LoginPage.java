package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Vignesh
 * @see Login for POM
 * @date 26/01/2023
 *
 */
public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="username")
	private WebElement txtUserName;
	@FindBy(id="password")
	private WebElement txtPassword;
	@FindBy(id="login")
	private WebElement btnLogin;
	@FindBy(xpath="//b[contains(text(),'Invalid Login details or Your Password might have expired.')]")
	private WebElement txtErrorMsg;
	
	public WebElement getTextUserName() {
		return txtUserName;
	}
	public WebElement getTextPassword() {
		return txtPassword;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	/**
	 * @see login common steps
	 * @param userName
	 * @param password
	 */
	public void loginCommonStep(String userName,String password) {
		sendvalue(getTextUserName(), userName);
		sendvalue(getTextPassword(), password);
	}
	/**
	 * @see login to adactin
	 * @param userName
	 * @param password
	 */
	public void login(String userName,String password) {
		loginCommonStep(userName, password);
		getClick(getBtnLogin());
		
	}
	/**
	 * @see login with using enter key
	 * @param userName
	 * @param password
	 * @throws AWTException
	 */
	public void loginWithEnterKey(String userName,String password) throws AWTException {
		loginCommonStep(userName, password);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	/**
	 * @see get the login error message
	 * @return
	 */
	public WebElement getTextErrorMsg() {
		return txtErrorMsg;
	}
	
	
}
