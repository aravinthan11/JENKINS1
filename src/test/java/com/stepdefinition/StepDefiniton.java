package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.Base;
import com.pageobjectmodel.PageObjectModel;
import com.pages.BookHotel;
import com.pages.ConfirmationPage;
import com.pages.LoginPage;
import com.pages.SearchHotel;
import com.pages.SelectHotel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefiniton extends Base {
	PageObjectModel page;
	LoginPage loginPage;
	SearchHotel searchHotel;
	SelectHotel selectHotel;
	BookHotel bookHotel;
	ConfirmationPage confirmationPage;

	@Given("User is on the Adactin homepage")
	public void user_is_on_the_Adactin_homepage() {
		//driver = getDriver();
		//loadURL("https://adactin.com/HotelApp/");
		//screenShot();
	}

	@When("User enters his details")
	public void user_enters_his_details(io.cucumber.datatable.DataTable data) {
		page = new PageObjectModel();
		
		List<Map<String, String>> emp = data.asMaps();
		String s1 = emp.get(0).get("userName");
		fill(page.getLoginPage().getTxtUser(), s1);
		String s2 = emp.get(0).get("password");		
		fill(page.getLoginPage().getTxtPass(), s2);
	}

	@When("User clicks the login button")
	public void user_clicks_the_login_button() {
		WebElement btn = page.getLoginPage().getBtnlog();
		btnClick(btn);
		//screenShot();
	}

	@When("User should verify the message")
	public void user_should_verify_the_message() {
		System.out.println("Mesage Verifyied With The User");
		//Assert.assertEquals("Verify Title", getTitle().contains("Welcome to AdactIn Group of Hotels"));
	}

	@When("User should search hotel")
	public void user_should_search_hotel(io.cucumber.datatable.DataTable data) {
		//searchHotel = new SearchHotel();
		//selectHotel = new SelectHotel();
		page = new PageObjectModel();
		List<Map<String, String>> emp = data.asMaps();
		String s3 = emp.get(0).get("location");
		fill(page.getSearchHotel().getLoc(), s3);
		String s4 = emp.get(0).get("Hotels");
		fill(page.getSearchHotel().getHotels(), s4);
		String s5 = emp.get(0).get("roomtypes");
		fill(page.getSearchHotel().getRoomType(), s5);
		String s6 = emp.get(0).get("numberofrooms");
				fill(page.getSearchHotel().getRoomNos(), s6);
		String s7 = emp.get(0).get("adultsperroom");
				fill(page.getSearchHotel().getAdult(), s7);
		String s8 = emp.get(0).get("childrenperroom");
				fill(page.getSearchHotel().getChild(), s8);
		WebElement btn = page.getSearchHotel().getSubmit();
		btnClick(btn);
		screenShot();
		WebElement btn1 = page.getSelectHotel().getRadio();
		btnClick(btn1);
		WebElement btnCon = page.getSelectHotel().getCnt();
		btnClick(btnCon);
		//screenShot();

	}

	@When("User enters payment")
	public void user_enters_payment(io.cucumber.datatable.DataTable data) {
		page= new PageObjectModel();
		List<Map<String, String>> emp = data.asMaps();
		String s9 = emp.get(0).get("firstname");
				fill(page.getBookHotel().getFirstName(), s9);
		String s10 = emp.get(0).get("lastname");
				fill(page.getBookHotel().getLastName(), s10);
		String s11 = emp.get(0).get("billingaddress");
				fill(page.getBookHotel().getAddress(), s11);
		String s12 = emp.get(0).get("creditcardnumber");
				fill(page.getBookHotel().getCreditnum(), s12);
		String s13 = emp.get(0).get("creditcardtype");
				fill(page.getBookHotel().getCreditTyp(), s13);
		String s14 = emp.get(0).get("expirymonth");
		fill(page.getBookHotel().getExpMonth(), s14);
		String s15 = emp.get(0).get("expiryyear");
		
		fill(page.getBookHotel().getExpYear(), s15);
		String s16 = emp.get(0).get("cvvnumber");
			fill(page.getBookHotel().getCvv(),s16);
	}

	@When("User gets orderid")
	public void user_gets_orderid() throws AWTException {
		page = new PageObjectModel();
		WebElement btnCon = page.getBookHotel().getBookNow();
		btnClick(btnCon);
		screenShot();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement order = page.getConfirmationPage().getOrdNo();
		String txt = order.getAttribute("value");
		System.out.println(txt);
		WebElement it = page.getConfirmationPage().getMyIt();
		btnClick(it);
		screenShot();
		WebElement txtOrder = driver.findElement(By.xpath("//input[@value='" + txt + "']/parent::td/preceding-sibling::td"));
		btnClick(txtOrder);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement ord = page.getConfirmationPage().getCancel();
		btnClick(ord);
		Alert a= driver.switchTo().alert();
		a.accept();
			}

	@Then("User has canceled the booking")
	public void user_has_canceled_the_booking() throws AWTException {
		System.out.println("Booking Cancelled");
	
	}

}
