package com.RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/MyCucumberProject/MyCucumberProject/F07DDT_OHRM_Login.feature",
					glue = "com.StepDefinition")
public class R07DDT_OHRM_Login {

}
