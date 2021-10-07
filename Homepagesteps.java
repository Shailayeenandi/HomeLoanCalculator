package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Homepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Homepagesteps{
	WebDriver driver;

	
	@Given("^user is on borrowing calculator page$")
	public void user_is_on_borrowing_calculator_page() throws Throwable {
//		Homepage hm=new Homepage(driver);
//		hm.openurl();
		String projectpath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectpath+"/src/test/resources/Drivers/chromedriver.exe" );
		driver= new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.navigate().to("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		  driver.manage().window().maximize();
	}

	@When("^user enters (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+)$")
	public void user_enters(String applicationtype, String dependents, String income, String otherincome, String livingexpenses, String homeloan, String otherloan, String ommitments, String cclimit) throws Throwable {
		Homepage hm=new Homepage(driver);
		hm.enterdata(applicationtype, dependents,  income,  otherincome,  livingexpenses,  homeloan,  otherloan,  ommitments,  cclimit);
	}
		
	

	@Then("^user has borrowing estimate of (.+)$")
	public void user_has_borrowing_estimate_of(String totalamount) throws Throwable {
		Homepage hm=new Homepage(driver);
		hm.verifyborrowamount(totalamount);

	}

	@And("^user clicks on workout how much i borrow button$")
	public void user_clicks_on_workout_how_much_i_borrow_button() throws Throwable {
		Homepage hm=new Homepage(driver);
		hm.clickonborrowbutton();
	}
	@Then("User clicks on start-over button and clear the form")
	public void user_clicks_on_start_over_button_and_clear_the_form() throws InterruptedException {
		Homepage hm=new Homepage(driver);
		hm.clickonstartover();
	}
	@Then("user is getting an error message")
	public void user_is_getting_an_error_message() {
		Homepage hm=new Homepage(driver);
		hm.verifyerrormessage();
	
	}

	@When("^user enters  (.+)$")
	public void user_enters(String livingexpenses) {
	    
    	Homepage hm=new Homepage(driver);
		hm.enterlivingexpense(livingexpenses);
    }
	@Then("user closes the borrowing calculator page")
	public void user_closes_the_borrowing_calculator_page() {
		Homepage hm=new Homepage(driver);
		hm.closeurl();
	}
	

	
	
}

