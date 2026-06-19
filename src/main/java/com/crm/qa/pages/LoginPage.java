package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	/* ********* Page factory -> OR (Object repository) - Page libraries defined********** */

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[contains(@class, 'submit')]")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	/* **********Initializing the page objects************ */
	
	public LoginPage() {
		/* How will you initialize your PageFactory- So, for this we have one method inside PageFactory class as 'initElements'. 
		  'this' keyword refers to current class objects. All the class objects are initialized with driver */
	
		PageFactory.initElements(driver, this);
	}

	/* ********Actions/Features******************** */
	
	public String validateLoginPageTitle() 
	{
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) 
	{
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	// After clicking on login button it will redirect to home page.
		return new HomePage();
	}

}
