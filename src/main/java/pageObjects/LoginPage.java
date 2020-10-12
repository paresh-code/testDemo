package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By username = By.xpath("//input[@id='username']");
	By password = By.xpath("//input[@id='password']");
	By captcha = By.id("captchaText");
	By login = By.xpath("//button[@id='submit']");
	
	
	//creating constructor to give life to the driver argument
	public LoginPage(WebDriver driver) 
	{
		this.driver =driver;
	}

	public WebElement getUsername()
	{
		return driver.findElement(username);
	}

	public WebElement getPassword() 
	{
		
		return driver.findElement(password);
	}
	
	public WebElement login() 
	{
		
		return driver.findElement(login);
	}
	
	
	public WebElement captcha() 
	{
		
		return driver.findElement(captcha);
	}
	
	
	public HomePage submit() throws InterruptedException
	{
		driver.findElement(login).click();
		Thread.sleep(20000);
		HomePage hp = new HomePage(driver);
		System.out.println(hp + "-------------------------Test-------------------------------------");
		return hp;
		//return driver.findElement(login);

		 
	}
	



	

}
