package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	//Object Repository
	
	@FindBy(xpath="//span[contains(text(),'Sourabh Soni')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage(){
		//Initialize page objects
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage verifyContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage verifyDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage verifyTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
		
}

