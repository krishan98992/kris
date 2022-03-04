package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();  //to call constructor of test base 
	}
	
	@BeforeMethod
	public void setup()
	{
		initialzation();
		loginpage=new LoginPage();   //to create object of LoginPage 
	}
	
	@Test(priority = 1)
	public void loginpagetitleTest()
	{
		String title=loginpage.validateloginpagetitle();
		Assert.assertEquals(title,"Cogmento CRM","title is incorrect");
	}
	
	@Test(priority = 2)
	public void Signuplink()
	{
		boolean b=loginpage.validatesignuplink();
	Assert.assertTrue(true);
	}
	@Test(priority = 3)
	public void loginTest()
	{
		homepage=loginpage.login(prop.getProperty("Username"),prop.getProperty("Password"));
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
