package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;
	
	public HomePageTest()
	{
		super();
	}
	
	//Testcases should be separated or independent with each other
	//before each testcase --launch the browser and login
	//@test- execute the test case
	//after each testcase-- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		contactspage= new ContactsPage();
		dealspage= new DealsPage();
		loginpage= new LoginPage();
		taskspage= new TasksPage();
		homepage=loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle,"Free CRM","Home page title not matched"); //the string message will be printed only when the test case is getting failed.
	}
	
	@Test(priority=2)
	public void verifyCorrectUserName()
	{
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactspage=homepage.verifyContactsLink();
	}
	
	@Test(priority=4)
	public void verifyDealssLinkTest() {
		dealspage=homepage.verifyDealsLink();
	}
	
	@Test(priority=5)
	public void verifyTasksLinkTest() {
		taskspage=homepage.verifyTasksLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
