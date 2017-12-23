package com.runner;

import org.junit.runner.RunWith;

import com.intuit.karate.junit4.Karate;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		features="./src/test/java/com/runner/cucumber.feature",
		plugin= {"pretty","json:target/cucumber-report.json"},
		tags="@test1",
		glue="com.runner"
	
		)

public class CucumberRunnr {

}
