package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory -OR 
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginbutton;
	
	@FindBy(xpath ="//a[contains(text(),'Sign Up')]")
	WebElement signupbutton;
	
	@FindBy(xpath ="//a[text()='Forgot your password?']")
	WebElement forgotpasswordbutton;
	
	//initialize the Page Object 
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions --different type of feature
	
	public String validateloginpagetitle()
	{
		return driver.getTitle();
	}
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		return new HomePage ();
		
	}
	
	public boolean validatesignuplink()
	{
	return signupbutton.isDisplayed();
	}

}
