package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;

	By homeText = By.xpath("//h3[@class='inHeading']");
	By lang = By.xpath("//li[@class='dropdown-submenu lang']//select[@class='ng-pristine ng-untouched ng-valid']");
	By eng_lang = By.xpath("//option[contains(text(),'English')]");
	By wssd_button = By.xpath("//section[@class='sidebar']/div/ul/li[5]/i");
	
	
	By gw_page= By.xpath("//div[@role='tablist']/ul/li[5]/div/ul/li[9]/i[1]");

	public HomePage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getHomeText() {
		return driver.findElement(homeText);
	}

	public WebElement lang_dropdown() {
		return driver.findElement(lang);
	}

	public WebElement selectEnglish() {
		return driver.findElement(eng_lang);
	}

	public WebElement clickWSSD() {
		return driver.findElement(wssd_button);
	}

	public WebElement waitForVisibility(WebElement element) throws Error {
		return new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement groudWaterPageNav(){
		
		return driver.findElement(gw_page);
		
	}

}
