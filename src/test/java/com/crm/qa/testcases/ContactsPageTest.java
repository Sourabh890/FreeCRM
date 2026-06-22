package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	ContactsPage contactspage;
	HomePage homepage;
	String sheetName="contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		contactspage = new ContactsPage();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		contactspage=homepage.verifyContactsLink();
	}

	@Test(priority=1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactspage.verifyContactsLabel(),"Contacts label is missing on the page");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName) {  
		contactspage.verifyClickOnCreateBtn();
		//contactspage.createNewContact("Tom", "Peter");
		contactspage.createNewContact(firstName, lastName);
	}
   
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
