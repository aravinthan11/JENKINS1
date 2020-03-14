package com.pageobjectmodel;

import com.pages.BookHotel;
import com.pages.ConfirmationPage;
import com.pages.LoginPage;
import com.pages.SearchHotel;
import com.pages.SelectHotel;

public class PageObjectModel {
	private LoginPage loginPage;
	private SearchHotel searchHotel;
	private SelectHotel selectHotel;
	private BookHotel bookHotel;
	private ConfirmationPage confirmationPage;

public LoginPage getLoginPage() {
	return (loginPage == null)?loginPage= new LoginPage():loginPage;
}

	public SearchHotel getSearchHotel() {
		return (searchHotel == null)?searchHotel= new SearchHotel():searchHotel;
	}

	public SelectHotel getSelectHotel() {
		return (selectHotel == null)?selectHotel= new SelectHotel():selectHotel;
	}

	public BookHotel getBookHotel() {
		return (bookHotel == null)?bookHotel= new BookHotel():bookHotel;
	}

	public ConfirmationPage getConfirmationPage() {
		return (confirmationPage == null)?confirmationPage= new ConfirmationPage():confirmationPage;
	}
}
