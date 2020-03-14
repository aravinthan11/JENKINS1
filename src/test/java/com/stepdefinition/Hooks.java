package com.stepdefinition;




import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.base.Base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks extends Base {
	WebDriver driver;
@Before()
public void beforeScenario1() {
	driver = getDriver();
	loadURL("https://adactin.com/HotelApp/");
System.out.println("Before1");
}

@After()
public void afterScenario(Scenario sc) {
TakesScreenshot tk= (TakesScreenshot)driver;
byte[] screen = tk.getScreenshotAs(OutputType.BYTES);
sc.embed(screen, "images/png");
}
}