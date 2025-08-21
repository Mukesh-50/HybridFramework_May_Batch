package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import dataproviders.ExcelReader;
import pages.LoginPage;

/*
 * 
 *  OOPS Concepts Used In Framework 
 *  
 *  We are using Inheritance using BaseClass
 *  
 *  Page Object Model - We are encapsulation where each locator is private and only that class methods can access the locators
 *  
 *  We have used Config Reader - which reads properties from property file or config file and we have used the values in framework at different places
 *  
 *  We have also created BrowserFactory which deals with Browser Invocation
 *  
 *  We have also added DataProvider in our test which takes data from excel and pass into our test methods
 *  
 *  We will add listeners 2 listeners 1-Listener which will capture the result of each test at run time and capture screenshot
 *  
 *  Second listener which will be IRetryAnalyzer which will retry our test if it fails and in order to make it global we have to use IAnnotationTransformer interface
 * 
 *  We have also used Abstraction via Listeners - We have implemented unimplemented method for retry listeners and testnglisters
 *  
 *  We have also used polymorphism - overloading (Utility) and overridding (Listeners)
 * 
 */

public class LoginTest extends BaseClass
{
	
	@Test(dataProvider = "logindata")
	public void testLoginWithValidCredentials(String uname,String pass)
	{
		
		LoginPage login=new LoginPage(driver);
		
		login.loginToApplication(uname, pass);
			
	}
	
	
	@DataProvider(name="logindata")
	public Object[][] getData()
	{
		Object [][]arr=ExcelReader.getDataFromExcel("login");
		
		return arr;
	}
	
}
