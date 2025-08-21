package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import dataproviders.ConfigReader;

public class BrowserFactory 
{
	
	static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		
		return driver;
		
	}
	

	public static WebDriver startBrowser(String browserName, String applicationURL) 
	{

		System.out.println("Application will be running on " + browserName + " with url " + applicationURL);

		if (browserName.toLowerCase().equals("chrome") || browserName.toLowerCase().equals("gc")
				|| browserName.toLowerCase().equals("google")) 
		{
			driver = new ChromeDriver();
		} 
		else if (browserName.toLowerCase().equals("firefox") || browserName.toLowerCase().equals("mozila")
				|| browserName.toLowerCase().equals("ff")) 
		{
			driver = new FirefoxDriver();
		
		} else if (browserName.toLowerCase().equals("edge") || browserName.toLowerCase().equals("msedge")
				|| browserName.toLowerCase().equals("microsoft edge")) 
		{
			driver = new EdgeDriver();
		} else if (browserName.toLowerCase().equals("safari") || browserName.toLowerCase().equals("apple safari")) 
		{
			driver = new SafariDriver();
			
		} else 
		{
			System.out.println("Sorry - currently our framework does not support " + browserName + " browser");
		}

		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getValue("pageloadtimeout"))));

		driver.get(applicationURL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getValue("implicitwait"))));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getValue("scripttimeout"))));
		
		System.out.println("Application is up and running");

		return driver;
	}


}
