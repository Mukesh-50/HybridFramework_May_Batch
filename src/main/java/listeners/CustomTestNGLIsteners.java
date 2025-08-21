package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.chaintest.plugins.ChainTestListener;
import dataproviders.ConfigReader;
import helper.Utility;

public class CustomTestNGLIsteners implements ITestListener
{

	public void onTestSuccess(ITestResult result) 
	{
	  
		ChainTestListener.log("Test Executed : Test Passed "+result.getMethod().getMethodName());
		
		
		String value=ConfigReader.getValue("screenshot_on_success");
		
		if(value.equalsIgnoreCase("true"))
		{
			ChainTestListener.embed(Utility.captureScreenshot(), "image/png");
		}
	
				
	}
	
	public void onTestFailure(ITestResult result) 
	{
	   
		ChainTestListener.log("Test Executed : Test Failed "+result.getMethod().getMethodName() + " "+result.getThrowable().getMessage());
		
	
		String value=ConfigReader.getValue("screenshot_on_failure");
		
		if(value.equalsIgnoreCase("true"))
		{
			ChainTestListener.embed(Utility.captureScreenshot(), "image/png");
		}
		
	
		
	}
	
	 public void onTestSkipped(ITestResult result) 
	 {
		 
		 ChainTestListener.log("Test Executed : Test Skipped "+result.getMethod().getMethodName()+ " "+result.getThrowable().getMessage());
		 
		
		 String value=ConfigReader.getValue("screenshot_on_skip");
			
			if(value.equalsIgnoreCase("true"))
			{
				ChainTestListener.embed(Utility.captureScreenshot(), "image/png");
			}
	  
	 }
	
}
