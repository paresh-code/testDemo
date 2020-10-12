package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegGrievanceExternal {
	
	public WebDriver driver;
	By reg_grie_link = By.linkText("Register Grievance");
	By griev_category = By.xpath("//select[@id='gc']");
	By griev_subCategory = By.xpath("//select[@id='gsc']");
	By adm_location = By.xpath("//select[@id='lo']");
	
	By district = By.xpath("//select[@id='sel1']");
	By block = By.xpath("//select[@id='blo']");
	By gp = By.xpath("//select[@id='gp']");
	By village = By.xpath("//select[@id='vg']");
	By hab = By.xpath("//select[@id='hab']");
	
	By name = By.id("nam");
	By add1 = By.id("ad");
	By add2 = By.xpath("//div[@class='subStagOutDiv']//div[3]//input[1]");
	By pincode = By.id("pinc");
	By mobile = By.id("mobi");
	By email = By.id("emails");
	By complaintText = By.id("com");
	By checkbox = By.id("decl");
	By save = By.id("save");
	By OK = By.id("create");
	By OTP = By.id("otpans")	;
	By captcha= By.id("captchaText");
			
	
	public RegGrievanceExternal(WebDriver driver) 
	{
		this.driver =driver;
	}
		
	
	
	public WebElement reg_grievance()
	{
		return driver.findElement(reg_grie_link);
	}
	
	public WebElement select_category()
	{
		return driver.findElement(griev_category);
		
	}
	
	public WebElement select_subCategory()
	{
		return driver.findElement(griev_subCategory);
		
	}
	public WebElement select_Adm_location()
	{
		return driver.findElement(adm_location);
		
	}
	
	public WebElement select_District()
	{
		return driver.findElement(district);
		
	}
	public WebElement select_Block()
	{
		return driver.findElement(block);
		
	}
	public WebElement select_GP()
	{
		return driver.findElement(gp);
		
	}
	public WebElement select_Village()
	{
		return driver.findElement(village);
		
	}
	
	public WebElement select_Habitation()
	{
		return driver.findElement(hab);
		
	}

	public WebElement enterName()
	{
		return driver.findElement(name);
		
	}
	
	public WebElement enterPincode()
	{
		return driver.findElement(pincode);
		
	}
	
	public WebElement enterAdd1()
	{
		return driver.findElement(add1);
		
	}
	
	public WebElement enterAdd2()
	{
		return driver.findElement(add2);
		
	}
	
	public WebElement enterMobile()
	{
		return driver.findElement(mobile);
		
	}
	
	public WebElement enterEmail()
	{
		return driver.findElement(email);
		
	}
	
	public WebElement enterComplaintText()
	{
		return driver.findElement(complaintText);
		
	}
	
	public WebElement selectCheckBox()
	{
		return driver.findElement(checkbox);
		
	}
	
	public WebElement save()
	{
		return driver.findElement(save);
		
	}
	
	
	public WebElement otp()
	{
		return driver.findElement(OTP);
		
	}
	
	public WebElement captcha()
	{
		return driver.findElement(captcha);
		
	}
	
	public WebElement click_OK()
	{
		return driver.findElement(OK);
		
	}
/*	public void select_griev_category()
	{
		RegGrievanceExternal reg1 = new RegGrievanceExternal(driver);
	
		
	}*/
	
	
}
