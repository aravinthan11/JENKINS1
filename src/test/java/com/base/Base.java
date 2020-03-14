package com.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Ordering;

public class Base {
	public static WebDriver driver;

	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Desktop\\DESKTOP\\JAVA\\eclipse\\scott\\AdactinCUCB\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public void loadURL(String url) {
		driver.get(url);
	}

	public void fill(WebElement ele, String name) {
		ele.sendKeys(name);
	}

	public void btnClick(WebElement ele) {
		ele.click();
	}

	public void selectByVisible(WebElement element, String name) {
		Select s = new Select(element);
		s.selectByVisibleText(name);
	}

	public String getAttValue(WebElement ele) {
		return ele.getAttribute("value");

	}

	public String getTitle() {
		return driver.getTitle();

	}

	public String genrateRandomData() {
		return new SimpleDateFormat("EEE_mmm_dd_yyyy_hh_mm_ss").format(new Date());
	}

	public void screenShot() {
		File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\Admin\\Desktop\\DESKTOP\\JAVA\\eclipse\\scott\\AdactinOrderId\\SreenShot\\"
				+ genrateRandomData() + ".png");
		try {
			FileUtils.copyFile(s, d);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void quitBrowser() {
		driver.quit();
	}
}
