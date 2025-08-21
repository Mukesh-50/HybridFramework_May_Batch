package helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BrowserFactory;

public class Utility 
{

	public static String captureScreenshot()
	{
		
		WebDriver driver=BrowserFactory.getDriver();
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		String str=ts.getScreenshotAs(OutputType.BASE64);
		
		return str;
		
	}
	
	public static Object captureScreenshot(String type)
	{
		Object result=null;
		
		WebDriver driver=BrowserFactory.getDriver();
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		if(type.equalsIgnoreCase("file"))
		{
			result=ts.getScreenshotAs(OutputType.FILE);
		}
		else if(type.equalsIgnoreCase("base64"))
		{
			result=ts.getScreenshotAs(OutputType.BASE64);
		}
		else if(type.equalsIgnoreCase("byte"))
		{
			result=ts.getScreenshotAs(OutputType.BYTES);
		}
		
		return result;
		
	}
	
}
