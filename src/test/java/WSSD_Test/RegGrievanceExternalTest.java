package WSSD_Test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WSSD.Base;
import pageObjects.RegGrievanceExternal;

public class RegGrievanceExternalTest extends Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initalize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		

	}

	@Test
	public void createComplaint() throws IOException, InterruptedException {
		RegGrievanceExternal regGri = new RegGrievanceExternal(driver);
		regGri.reg_grievance().click();
		driver.manage().window().maximize();
		
		Base b =new Base();
		ArrayList<String> data=b.getData("Grievance","GRM");
		
		Select s = new Select(regGri.select_category());
		s.selectByValue("0");
		
		Select s1 = new Select(regGri.select_subCategory());
		s1.selectByValue("2");
		
		/*regGri.enterName().sendKeys("Test Automation");
		regGri.enterAdd1().sendKeys("Automation Add1");
		regGri.enterAdd2().sendKeys("Automation Add2");
		regGri.enterPincode().sendKeys("400606");
		
		
		Select s2 = new Select(regGri.select_Adm_location());
		s2.selectByVisibleText("Habitation");
		
		Select s3 = new Select(regGri.select_District());
		s3.selectByVisibleText("NANDED");
		
		Select s4 = new Select(regGri.select_Block());
		s4.selectByVisibleText("NANDED");
		
		Select s5 = new Select(regGri.select_GP());
		s5.selectByVisibleText("ALEGAON");
		
		Select s6 = new Select(regGri.select_Village());
		s6.selectByVisibleText("ALEGAON");

		Select s7 = new Select(regGri.select_Habitation());
		s7.selectByVisibleText("ALEGAON");
		
		regGri.enterMobile().sendKeys("9833948772");
		regGri.enterEmail().sendKeys("paresh.lokhande@mastek.com");
		regGri.enterComplaintText().sendKeys("Enter Complaint text here");
		*/
		regGri.enterName().sendKeys(data.get(1));
		regGri.enterAdd1().sendKeys(data.get(2));
		regGri.enterAdd2().sendKeys(data.get(3));
		regGri.enterPincode().sendKeys(data.get(4));		
		Select s2 = new Select(regGri.select_Adm_location());
		s2.selectByVisibleText(data.get(5));		
		Select s3 = new Select(regGri.select_District());
		s3.selectByVisibleText(data.get(6));		
		Select s4 = new Select(regGri.select_Block());
		s4.selectByVisibleText(data.get(7));		
		Select s5 = new Select(regGri.select_GP());
		s5.selectByVisibleText(data.get(8));		
		Select s6 = new Select(regGri.select_Village());
		s6.selectByVisibleText(data.get(9));
		Select s7 = new Select(regGri.select_Habitation());
		s7.selectByVisibleText(data.get(10));
		
		
		//Select s2 = new Select(regGri.select_Adm_location());
		/*String adm_loc=s2.selectByVisibleText(data.get(5));

		if(adm_loc=data.get(5))
		{
				Select s3 = new Select(regGri.select_District());
				s3.selectByVisibleText(data.get(6));		
				Select s4 = new Select(regGri.select_Block());
				s4.selectByVisibleText(data.get(7));		
				Select s5 = new Select(regGri.select_GP());
				s5.selectByVisibleText(data.get(8));		
				Select s6 = new Select(regGri.select_Village());
				s6.selectByVisibleText(data.get(9));
				Select s7 = new Select(regGri.select_Habitation());
				s7.selectByVisibleText(data.get(10));	
		}
		else if (adm_loc="District"){

				Select s3 = new Select(regGri.select_District());
				s3.selectByVisibleText(data.get(6));
		}
	
		*/	
		
		
		
		regGri.enterMobile().sendKeys(data.get(11));
		regGri.enterEmail().sendKeys(data.get(12));
		regGri.enterComplaintText().sendKeys(data.get(13));
		regGri.selectCheckBox().click();
		regGri.otp().sendKeys(data.get(14));
		regGri.captcha().sendKeys(data.get(15));
		//Thread.sleep(50000);
		regGri.save().click();
		regGri.click_OK().click();
		regGri.click_OK().click();
	}

	@AfterTest
	public void teardown() throws IOException {
		System.out.println("reg griv test case completed");
		driver.close();
		log.info("regi test case completed");
	}

}
