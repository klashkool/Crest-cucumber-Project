package com.Crest_Scenarios_TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.Utils.Base;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\Projects\\CrestCucumber\\Crest_Modules_Scenarios\\com\\Crest_Scenarios_Feature_Files", // the
																														// path
																														// of
																														// the
																														// feature
																														// files
				glue = {"com.Crest_Scenarios_StepDefinitions"}, // the path of
																// the step
																// definition
																// files
				plugin = {"pretty", "html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml",
								"com.cucumber.listener.ExtentCucumberFormatter:D:\\Projects\\CrestCucumber\\Reports\\report.html"}, // to
																																	// generate
																																	// different
																																	// types
																																	// of
																																	// reporting
				monochrome = true, // display the console output in a proper
									// readable format
				strict = true, // it will check if any step is not defined in
								// step definition file
				dryRun = false,
				// dryRun = true,
				// to check the mapping is proper between feature file and
				// stepdef file

				// Sales Offline Payment
				// tags = {"@Test32,@Test33,@Test34,@Test35"}
				// PO
				// tags = {"@Test2,@Test3,@Test4,@Test5,@Test6"}
				// PO Adhoc
// tags = {"@Test10,@Test11,@Test12,@Test13"}
				// SO Billing Acct Flow
// tags = {"@Test43,@Test44,@Test45,@Test46"}

// Test
				tags = {"@Test72,@Test73"}
)

public class Crest_TestRunner extends Base {

	@AfterClass
	public static void reportSetup() {
		try {
			Reporter.loadXMLConfig(new File("D:\\Projects\\CrestCucumber\\src\\main\\java\\com\\Config\\extend-config.xml"));
		} catch (Exception e) {
			System.out.println(e);
		}

		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("64 Bit", "Windows 10");
		Reporter.setSystemInfo("2.53.0", "Selenium");
		Reporter.setSystemInfo("3.3.9", "Maven");
		Reporter.setSystemInfo("1.8.0_66", "Java Version");
		Reporter.setTestRunnerOutput("Cucumber JUnit Test Runner");
	}

}