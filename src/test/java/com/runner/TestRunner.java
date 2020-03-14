package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.JVMReport;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources" }, glue = {
		"com.stepdefinition" }, monochrome = true, dryRun = false, plugin = {
				"json:src\\test\\resources\\Reportss\\Cucumber.json" })
public class TestRunner {

	@AfterClass
	public static void afterExecution() {
		JVMReport.generateJVM(
				"C:\\Users\\Admin\\Desktop\\DESKTOP\\JAVA\\eclipse\\scott\\AdactinOrderId\\src\\test\\resources\\Reportss\\Cucumber.json");

	}

}
