package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super(); //Calling super class/base class constructor as I need to initialize my properties also before calling initialization method from base class.
	}
	
	@BeforeMethod
	public void setUp()
	{
	initialization(); 
	loginpage = new LoginPage(); //Create login page class object
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String loginpagetitle=loginpage.validateLoginPageTitle();
		Assert.assertEquals(loginpagetitle, "Free CRM");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		homepage=loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
