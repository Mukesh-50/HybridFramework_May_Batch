package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By username=By.id("email1");

	private By password=By.id("password1");

	private By signInButton=By.className("submit-btn1");
	
	public void loginToApplication(String uname,String pass)
	{
		
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
		
		driver.findElement(signInButton).click();
	}


}
