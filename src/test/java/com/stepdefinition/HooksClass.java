package com.stepdefinition;

import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
/**
 * 
 * @author vignesh
 * @see Excecute all scenario before and after
 *
 */
public class HooksClass extends BaseClass {

	/**
	 * @see Before scenario
	 * @throws IOException
	 */
@Before
public void beforeScenario() throws IOException {
	getDriver(getPropertyFileValue("browser"));
	getURL(getPropertyFileValue("url"));
	maxiWindow();
	implicitywait(30);
}
/**
 * @see after scenario
 * @param scenario
 */
@After
public void afterScenario(Scenario scenario) {
	boolean failed = scenario.isFailed();
	if(failed) {
		scenario.attach(screenshot(), "image/png", "Every Scenario");
	}else {
		scenario.attach(screenshot(), "image/png", "Every Scenario");
	}
	closeAllwin();
}

}
