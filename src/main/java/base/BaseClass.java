package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import dataproviders.ConfigReader;
import factory.BrowserFactory;

public class BaseClass {

	protected WebDriver driver;

	
	@BeforeClass
	public void setup() 
	{
		System.out.println("**** Running Before Class ");
		
		String browserName= ConfigReader.getValue("browser");
		
		String url= ConfigReader.getValue("qaURL");
		
		driver=BrowserFactory.startBrowser(browserName,url);
		

		System.out.println("**** Application is up and running");

	}

	@AfterClass
	public void teardown() 
	{
		System.out.println("**** Running After Class ");
		
		driver.quit();
		
		System.out.println("**** Closing the application ");


	}

}
