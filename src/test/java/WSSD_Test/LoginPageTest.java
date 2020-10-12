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
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginPageTest extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	

	@BeforeTest
	public void initalize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {

		driver.manage().window().maximize();
		Base b = new Base();
		ArrayList<String> data = b.getData("Login", "Login Page");
		LoginPage lp = new LoginPage(driver);

		lp.getUsername().sendKeys(data.get(1));
		lp.getPassword().sendKeys(data.get(2));
		lp.captcha().sendKeys(data.get(3));

		HomePage hp = lp.submit();
		hp.waitForVisibility(hp.lang_dropdown());

		hp.lang_dropdown().click();
		hp.selectEnglish().click();
		hp.clickWSSD().click();
		hp.groudWaterPageNav().click();

	}

	@AfterTest
	public void teardown() throws IOException {
		System.out.println("Login Test case completed");
		driver.close();
		log.info("Login Test case completed");
	}

}
