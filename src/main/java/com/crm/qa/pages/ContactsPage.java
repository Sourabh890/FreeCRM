package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement createNewContact;
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;
		
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath = "//i[@class='save icon'][1]")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void verifyClickOnCreateBtn() {
		createNewContact.click();
	}
	
	public void createNewContact(String ftname, String ltname) {
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		saveBtn.click();
		
	}
	
}
