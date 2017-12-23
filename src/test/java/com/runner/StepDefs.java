package com.runner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.intuit.karate.cucumber.CucumberRunner;

import cucumber.api.Scenario;
import cucumber.api.cli.Main;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class StepDefs {

	public WebDriver driver = null;

	@Before
	public void setUp(Scenario scenario){

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() throws IOException{



		/*driver.close();
		driver.quit();*/


	}

	@Given("^I launch website URL$")
	public void i_launch_website(){

		driver.get("https://www.gmail.com");
		System.out.println("Running karate now...");

	}

	//call karate feature
	@Given("^I run karate test1$")
	public void testCallingFeatureFromJava() throws Throwable {
		//Running a feature file from cucumber
		Map<String, Object> args = new HashMap();
		args.put("name", "World");
		Map<String, Object> result = CucumberRunner.runFeature(getClass(), "karatefeature.feature", args);

		//Running a feature file from cucumber
		// Main.main(new String[]{"-g", "StepDefs.java","-t", "@test1", "./src/test/java/com/runner/karatefeature.feature"});


	}

}
