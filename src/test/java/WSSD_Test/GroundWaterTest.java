package WSSD_Test;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import WSSD.Base;
import pageObjects.GroundWaterPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class GroundWaterTest extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initalize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void ground_water_obs() throws Exception {

		
		driver.manage().window().maximize();
		Base b = new Base();
		ArrayList<String> data = b.getData("Login", "Login Page");
		LoginPage lp = new LoginPage(driver);

		lp.getUsername().sendKeys(data.get(1));
		lp.getPassword().sendKeys(data.get(2));
		//lp.captcha().sendKeys(data.get(3));
		Thread.sleep(10000);

		HomePage hp = lp.submit();
		hp.waitForVisibility(hp.lang_dropdown());

		hp.lang_dropdown().click();
		hp.selectEnglish().click();
		hp.clickWSSD().click();
		hp.groudWaterPageNav().click();
		
	
	
		ArrayList<String> data1 = b.getData("Ground Water", "GW Page");
		GroundWaterPage gw = new GroundWaterPage(driver);

		
		gw.gw_obs_well_nav().click();
		gw.gw_obs_well_page().click();
		gw.gw_add_Button().click();
		
		hp.waitForVisibility(gw.select_block()).click();
		hp.waitForVisibility(gw.getBlockValue(data1.get(1))).click();
		//gw.getBlockValue(data1.get(1)).click();
		gw.select_block().click();
		gw.getGPValue(data1.get(2)).click();


		gw.select_block().click();
		gw.getVillageValue(data1.get(3)).click();


		gw.select_block().click();
		gw.getHabValue(data1.get(4)).click();

		gw.enter_well_name().sendKeys(data1.get(5));
		gw.gis_location().sendKeys(data1.get(6));

		gw.select_rockType().click();
		gw.getRockType(data1.get(7)).click();
		gw.enter_diameter().sendKeys(data1.get(8));
		gw.enter_depth().sendKeys(data1.get(9));


		gw.select_fun_status().click();
		gw.getFunSts(data1.get(10)).click();;
		gw.UploadTest();
		
		
		gw.submit_ver().click();
		gw.final_ok().click();
		

		/*gw.select_block().click();
		hp.waitForVisibility(gw.getBlockValue(data1.get(1))).click();
		hp.waitForVisibility(gw.select_block()).click();
		hp.waitForVisibility(gw.getGPValue(data1.get(2))).click();
		
		//hp.waitForVisibility(gw.select_village()).click();
		hp.waitForVisibility(gw.select_block()).click();
		hp.waitForVisibility(gw.getVillageValue(data1.get(3))).click();
		
		//hp.waitForVisibility(gw.select_hab()).click();
		hp.waitForVisibility(gw.select_block()).click();
		hp.waitForVisibility(gw.getHabValue(data1.get(4))).click();

		gw.enter_well_name().sendKeys(data1.get(5));
		gw.gis_location().sendKeys(data1.get(6));
		
		hp.waitForVisibility(gw.select_rockType()).click();
		hp.waitForVisibility(gw.getRockType(data1.get(7))).click();;
		
	    gw.enter_diameter().sendKeys(data1.get(8));
		gw.enter_depth().sendKeys(data1.get(9));
		
		
		hp.waitForVisibility(gw.select_fun_status()).click();
		hp.waitForVisibility(gw.getFunSts(data1.get(10))).click();;*/
		

	

	

	}

	@AfterTest
	public void teardown() throws IOException {
		System.out.println("Login Test case completed");
		driver.close();
		log.info("Login Test case completed");
	}

}
