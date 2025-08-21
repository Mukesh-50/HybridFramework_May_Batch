package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import dataproviders.ConfigReader;

public class RetryAnalyzer implements IRetryAnalyzer{

	
	private int retryCount = 0;
	
	private static final int maxRetryCount = Integer.parseInt(ConfigReader.getValue("retry"));

	 
	  public boolean retry(ITestResult result) 
	  {
	    if (retryCount < maxRetryCount) 
	    {
	      retryCount++;
	      
	      return true;
	    }
	    
	    return false;
	  }

}
