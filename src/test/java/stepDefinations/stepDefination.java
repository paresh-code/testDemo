package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.RegGrievanceExternal;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import WSSD.Base;


public class stepDefination extends Base{

	

    @Given("^User navigates to Register Grievance Page through WSSD$")
    public void user_navigates_to_register_grievance_page_through_wssd() throws Throwable {
    	driver = initializeDriver();
		driver.get(prop.getProperty("url"));
    }
	


	@When("^User Enter Grievance related details$")
	public void user_Enter_Grievance_related_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		RegGrievanceExternal regGri = new RegGrievanceExternal(driver);
		regGri.reg_grievance().click();
		driver.manage().window().maximize();
		
		
	}
	
    @And("^Enter (.+), (.+), (.+) , (.+), (.+), (.+), (.+) , (.+)$")
    public void enter_(String category, String subCat, String level, String district, String block, String gp, String habitation, String village) throws Throwable {
    	RegGrievanceExternal regGri = new RegGrievanceExternal(driver);
    	//Select s = new Select(regGri.select_category());
    	regGri.select_category().sendKeys(category);
    	regGri.select_category().sendKeys(subCat);
    	
    }



	@Then("^Grievance is registered sucessfully$")
	public void grievance_is_registered_sucessfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

}