package testcases;

import org.testng.annotations.Test;

public class SampleTest 
{
	@Test
	public void sampleTestMethod()
	{
		System.out.println("This is a sample test method.");

		System.out.println("TestStep 1");
		System.out.println("Login");
    
		System.out.println("TestStep 2");
		System.out.println("Added to account");
    
		System.out.println("TestStep 3");
		System.out.println("Logout");

	}
	
	@Test
	public void sampleTestMethod2()
	{
		System.out.println("This is a sample test method 2.");
	}
	
	@Test
	public void sampleTestMethod3()
	{
		System.out.println("This is a sample test method 3.");
	}

}
