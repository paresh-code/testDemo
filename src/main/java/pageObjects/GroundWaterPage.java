package pageObjects;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;






public class GroundWaterPage {
	
	
	public WebDriver driver;
	
	
	By gw_Obs_well = By.xpath("//div[@role='tablist']/ul/li[5]/div/ul/li[9]/div/ul/li[1]");
	By gw_obs_well_page = By.xpath("//div[@role='tablist']/ul/li[5]/div/ul/li[9]/div/ul/li[1]/div/ul/li/span");
	By gw_add_Button = By.xpath("//*[@id='div_btn']/button");
	By block =	By.xpath("(//button[text()='--Please Select-- '])[1]");
	By panchayat =	By.xpath("(//button[text()='--Please Select-- '])[2]");
	By village =	By.xpath("(//button[text()='--Please Select-- '])[3]");
	By habitation =	By.xpath("(//button[text()='--Please Select-- '])[4]");
	By obs_well_name =	By.xpath("//input[@id='ObservationWellName']");
	By gis_loc =	By.xpath("(//input[@id='Location'])[1]");
	By rockType =	By.xpath("(//button[text()='Rock Type '])[1]");
	By dia_well =	By.xpath("(//input[@id='DiameterofWell'])[1]");
	By depth_well =	By.xpath("(//input[@id='DepthofWell'])[1]");
	By fun_status =	By.xpath("(//button[text()='Functional Status '])[1]");
	By remarkID =	By.xpath("(//input[@placeholder='Enter remark'])[5]");
	By submitVer =	By.xpath("(//input[@id='submitFor'])[3]");
	By upload =	By.xpath("(//label[@id='uploadButton'])[1]");
	By final_ok = By.xpath("//div[@id='ModalId myModal2']//input[1]");
	
	
	public GroundWaterPage(WebDriver driver) {

		this.driver = driver;

	}
	
	
	public WebElement gw_obs_well_nav(){
		return driver.findElement(gw_Obs_well);
	}
	
	public WebElement gw_obs_well_page(){
		return driver.findElement(gw_obs_well_page);
	}
	
	public WebElement gw_add_Button(){
		return driver.findElement(gw_add_Button);
	}
	
	
	public WebElement select_block(){
		return driver.findElement(block);
	}
	   
	   
	   public WebElement getBlockValue(String block_name )
	{
		By locator=By.xpath("//span[text()='"+block_name+"']");
		return driver.findElement(locator);
	} 
	   
	   

	public WebElement select_gp(){
		return driver.findElement(panchayat);
	}
	
	public WebElement getGPValue(String gp_name )
		{
			By locator=By.xpath("//span[text()='"+gp_name+"']");
			return driver.findElement(locator);
		} 
		   
	
	public WebElement select_village(){
		return driver.findElement(village);
	}
	
	public WebElement getVillageValue(String vill_name )
	{
		By locator=By.xpath("//span[text()='"+vill_name+"']");
		return driver.findElement(locator);
	} 

	public WebElement select_hab(){
		return driver.findElement(habitation);
	}
	
	public WebElement getHabValue(String Hab )
	{
		By locator=By.xpath("//span[text()='"+Hab+"']");
		return driver.findElement(locator);
	} 
	
	
	public WebElement enter_well_name(){
		return driver.findElement(obs_well_name);
	}
	
	public WebElement gis_location(){
		return driver.findElement(gis_loc);
	}
	
	
	public WebElement select_rockType(){
		return driver.findElement(rockType);
	}
	
	public WebElement getRockType(String rockType )
	{
		By locator=By.xpath("//span[text()='"+rockType+"']");
		return driver.findElement(locator);
	} 
	
	public WebElement enter_diameter(){
		return driver.findElement(dia_well);
	}
	
	public WebElement enter_depth(){
		return driver.findElement(depth_well);
	}
	
	public WebElement select_fun_status(){
		return driver.findElement(fun_status);
	}
	
	public WebElement getFunSts(String funStatus )
	{
		By locator=By.xpath("//span[text()='"+funStatus+"']");
		return driver.findElement(locator);
	} 
	
	public WebElement enter_remark(){
		return driver.findElement(remarkID);
	}
	
	public WebElement submit_ver(){
		return driver.findElement(submitVer);
	}
	
	public WebElement upload(){
		return driver.findElement(upload);
	}
	
	public WebElement final_ok(){
		return driver.findElement(final_ok);
	}
	
	

	public void UploadTest1() throws Exception {
		
		
		WebElement element = driver.findElement(upload);
		element.click();
		//element.sendKeys("C://Users//paresh11490//Downloads//nanded.pdf");
		driver.switchTo()
	       .activeElement()
	       .sendKeys("C://Users//paresh11490//Downloads//nanded.pdf");
	

	}
	
	public void UploadTest() throws AWTException, InterruptedException
	{
		// File Location
        StringSelection select = new StringSelection("nanded.txt");

        // Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
        WebElement element = driver.findElement(upload);
        element.click();
        // Create object of Robot class
        Robot robot = new Robot();
        Thread.sleep(1000);
        // Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        // Wait
        Thread.sleep(1000);

        // Release CTRL+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // Wait
        Thread.sleep(1000);
        
        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        WebElement element1 = driver.findElement(By.xpath("//button[text()[normalize-space()='Upload']]"));
        element1.click();
        Thread.sleep(1000);

	}



	
	
	
	
	
	
}
