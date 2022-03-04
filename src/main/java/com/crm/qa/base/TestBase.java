package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.utili.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop=new Properties();
		try {
		
			FileInputStream ip=new FileInputStream("C:\\Users\\krishan\\Desktop\\Eclipse Workspace Java Basic\\Project 1\\FreeCrmtest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public static void initialzation() 
		{
		String Browser =prop.getProperty("browser");
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\krishan\\Desktop\\Eclipse Workspace Java Basic\\Project 1\\automation\\lib\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		 else
				
			 if(Browser.equals("Firefox")) 
				{
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\krishan\\Desktop\\Eclipse Workspace Java Basic\\Project 1\\automation\\lib\\geckodriver.exe");
		 driver=new FirefoxDriver();

				}
			 else
				 
			 if(Browser.equals("IE"))
			 {
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\krishan\\Desktop\\Eclipse Workspace Java Basic\\Project 1\\automation\\lib\\geckodriver.exe");
					 driver=new InternetExplorerDriver();
					 
					
			 }
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Page_Load_Time));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.Implicit_wait_Time));
		driver.get(prop.getProperty("URL"));
	
		}
		
	}
	


