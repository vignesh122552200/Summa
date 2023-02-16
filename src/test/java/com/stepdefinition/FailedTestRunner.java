package com.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/**
 * 
 * @author vignesh
 * @see Maintain the failed test case
 * @date 26/01/2023
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="@target/failed.text",glue="com.stepdefinition")
public class FailedTestRunner {

}
