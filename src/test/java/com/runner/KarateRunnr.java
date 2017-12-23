package com.runner;

import org.junit.runner.RunWith;

import com.intuit.karate.junit4.Karate;

import cucumber.api.CucumberOptions;

@RunWith(Karate.class)
@CucumberOptions(
		monochrome = true,
		features="./src/test/java/com/runner/karatefeature.feature",
		plugin= {"pretty","json:target/cucumber-report.json"},
		tags="@test5",
		glue="com.runner"
	
		)

public class KarateRunnr {

}
