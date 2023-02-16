package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
/**
 * 
 * @author Vignesh
 * @see Generate the JVM report
 * @date 26/01/2023
 *
 */
public class Reporting {
	/**
	 * @see JVM report
	 * @param jsonFile
	 * 
	 */
	public static void getJVMReports(String jsonFile) {
		File file =new File("C:\\Users\\ggowt\\OneDrive\\Desktop\\Cucumber\\OMRBranchAPIAutomation\\target");
		
		Configuration configuration=new Configuration(file, "API Automation");
		
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Version", "1.2");
		configuration.addClassifications("OS", "Windows10");
		configuration.addClassifications("Sprint", "2");
		
		List<String> json=new ArrayList<String>();
		json.add(jsonFile);
		
		ReportBuilder reportBuilder=new ReportBuilder(json, configuration);
		
		reportBuilder.generateReports();
	}

}
