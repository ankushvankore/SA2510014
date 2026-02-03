package com.RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/MyCucumberProject/MyCucumberProject/F04SeleniumTest.feature",
					glue = "com.StepDefinition",
					tags = "@AllSeleniumTests")
public class R04SeleniumTest {
	/*
	 * Execute Single Scenario:			tags = "@DownloadTest"
	 * Execute Multiple Scenarios:		tags = "@DownloadTest or @DocumentationTest"
	 * Skip Single Scenario:			tags = "not @ProjectTest"
	 * Skip Multiple Scenarios:			tags = "not @ProjectTest and not @DocumentationTest"
	 * Execute All Scenarios:		
	 */

}
