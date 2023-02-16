package com.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
/**
 * 
 * @author vignesh
 * @see Step for login
 * @date 26/01/2023
 *
 */
public class TC1_LoginStep extends BaseClass {
	
	PageObjectManager pom=new PageObjectManager();
	/**
	 * @see Launch the browser
	 * @throws IOException
	 */
	@Given("User is on the Adactin page")
	public void user_is_on_the_adactin_page() throws IOException {
	/**
	 * @see login
	 */
	}
	@When("User should perform login {string} , {string}")
	public void user_should_perform_login(String userName, String password) {
		pom.getLoginPage().login(userName, password);
		
		
	}
	/**
	 * Login with enter key
	 * @param userName
	 * @param password
	 * @throws AWTException
	 */
	@When("User should perform login {string} , {string} with Enter key")
	public void user_should_perform_login_with_enter_key(String userName, String password) throws AWTException {
		pom.getLoginPage().loginWithEnterKey(userName, password);
			
	}
	/**
	 * @see verif
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * y after login with invalid credential error message contains
	 * @param expLoginErrormsg
	 */
	@Then("User should verify after login with invalid credential error message contains {string}")
	public void user_should_verify_after_login_with_invalid_credential_error_message_contains(String expLoginErrormsg) {
		WebElement txtErrorMsg = pom.getLoginPage().getTextErrorMsg();
		String actLoginErrormsg = txtErrorMsg.getText();
		boolean validation = actLoginErrormsg.contains(expLoginErrormsg);
		Assert.assertTrue("Verify after login with invalid credential", validation);
		
	}

}
