package Pages;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepage {
	private static final Object S = null;
	WebDriver driver;
    public static String borrowamount;
    public static String  borrowactualerror;
    public static String expectederror="Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641.";
	@FindBy(id="application_type_single")
	WebElement application_type;
    @FindBy(xpath="//div[@class='borrow__question__answer borrow__question__answer--select']/select")
	WebElement dependentscount;
	@FindBy(xpath="//li/label/input[@id='borrow_type_home']")
	WebElement property;
	@FindBy(xpath="//div/span[@id='q2q1i1']/following-sibling::input")
	WebElement yourincome;
	@FindBy(xpath="//div/span[@id='q2q2i1']/following-sibling::input")
	WebElement yourotherincome;
	@FindBy(xpath="//div/span[@id='q3q1i1']/following-sibling::input")
	WebElement yourlivingexpenses;
	@FindBy(xpath="//div/span[@id='q3q2i1']/following-sibling::input")
	WebElement yourhomeloan;
	@FindBy(xpath="//div/span[@id='q3q3i1']/following-sibling::input")
	WebElement yourotherloan;
	@FindBy(xpath="//div/span[@id='q3q4i1']/following-sibling::input")
	WebElement yourcommitments;
	@FindBy(xpath="//div/span[@id='q3q5i1']/following-sibling::input")
	WebElement yourcclimit;
    @FindBy(id="btnBorrowCalculater")
	WebElement borrowcalculator;
	@FindBy(id="borrowResultTextAmount")
	WebElement borrowresultamount;
	@FindBy(className="start-over")
	WebElement startover;
	@FindBy(className="borrow__error__text")
	WebElement borrowerror;


	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public void openurl()
//	{
//		String projectpath=System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver",projectpath+"/src/test/resources/Drivers/chromedriver.exe" );
//		driver= new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.navigate().to("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
//        driver.manage().window().maximize();
//	}

	public void enterdata(String applicationtype, String dependents, String income, String otherincome, String livingexpenses, String homeloan, String otherloan, String ommitments, String cclimit)
	{


    Select sc=new Select(dependentscount);
    sc.selectByVisibleText(dependents);
   
      yourincome.sendKeys(income);
      yourotherincome.sendKeys(otherincome);
      yourlivingexpenses.sendKeys(livingexpenses);
      yourhomeloan.sendKeys(homeloan);
      yourotherloan.sendKeys(otherloan);
      yourcommitments.sendKeys(ommitments);
      yourcclimit.sendKeys(cclimit);

	}
	
	public void clickonborrowbutton() throws InterruptedException
	{
		borrowcalculator.click();
	    Thread.sleep(4000);
	    if(borrowresultamount.isDisplayed())
	    {
	    borrowamount= borrowresultamount.getText();
	    System.out.println(borrowamount);
	    }
	    if(borrowerror.isDisplayed())
	    {
	    	borrowactualerror= borrowerror.getText();
		    System.out.println(borrowactualerror);
	    }
	    
	    
	}
	
	public void verifyborrowamount(String totalamount)
	{
		
		
		try {
		    Assert.assertEquals(totalamount, borrowamount);
		} catch (AssertionError e) {
		    System.out.println("Not equal");
		    throw e;
		}
		System.out.println("The user has a brrowsing estimate of"+totalamount+"which matches the expectations");	
		
		
	}
	
	public void clickonstartover() throws InterruptedException
	{
		startover.click();
		Thread.sleep(3000);
		System.out.println("the form is reset");
		
		try {
		    Assert.assertEquals((yourincome.getAttribute("value")),"0");
		    Assert.assertEquals((yourotherincome.getAttribute("value")),"0");
		    Assert.assertEquals((yourlivingexpenses.getAttribute("value")),"0");
		    Assert.assertEquals((yourhomeloan.getAttribute("value")),"0");
		    Assert.assertEquals((yourotherloan.getAttribute("value")),"0");
		    Assert.assertEquals((yourcommitments.getAttribute("value")),"0");
		    Assert.assertEquals((yourcclimit.getAttribute("value")),"0");
		    Assert.assertFalse(startover.isDisplayed());
		} catch (AssertionError e) {
		    System.out.println("start-over not working properly");
		    throw e;
		}
		System.out.println("All field value reset to  0.Start-over working properly.");	
		
		
	
		
	}
	
	public void verifyerrormessage()
	{
		String S=borrowerror.getText();
		System.out.println(S);
		try {
		    Assert.assertEquals(S,expectederror);
		} catch (AssertionError e) {
		    System.out.println("Not equal");
		    throw e;
		}
		System.out.println("the error message is same");	
		
		
		
	}
	public void enterlivingexpense(String livingexpenses)
	{
		yourlivingexpenses.sendKeys(livingexpenses);
	}
	
	public void closeurl()
	{
	driver.quit();
	}
}
