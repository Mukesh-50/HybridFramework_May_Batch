package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridDemo {

	
	@Test
	public void sampleTestOnGrid() throws MalformedURLException, InterruptedException
	{
		FirefoxOptions opt=new FirefoxOptions();
		
		URL seleniumHub=new URL("http://98.80.8.144:4444/wd/hub");
		
		WebDriver driver=new RemoteWebDriver(seleniumHub, opt);
		
		driver.get("http://google.com");
		
		Thread.sleep(60000);
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		
	}
	
	
}
