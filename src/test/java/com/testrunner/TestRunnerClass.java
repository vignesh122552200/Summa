package com.testrunner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/**
 * 
 * @author vignesh
 * @see Excecute the all feature file
 * @date 26/01/2023
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(dryRun=false,features="src\\test\\resources\\Features",monochrome=true,plugin= {"pretty","rerun:target/failed.text","json:target\\adactin.json"},stepNotifications=false,glue="com.stepdefinition")

public class TestRunnerClass extends BaseClass {
	/**
	 * @see Run the after excecution
	 * @throws IOException
	 */
	@AfterClass
	public static void afterClass() throws IOException {
		Reporting.getJVMReports(getProjectPath()+getPropertyFileValue("jsonpath"));
	}

}
