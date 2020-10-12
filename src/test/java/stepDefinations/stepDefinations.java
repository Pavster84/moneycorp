package stepDefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.confirmationPage;
import pageObjects.orderPage;
import pageObjects.personalDetailsPage;
import resources.base;

public class stepDefinations extends base{
	

	String euroTotalTxt = "EUR";
	String personDetailsUrl = "https://qa-travelmoney.moneycorp.com/checkout/collect/index";
	
   
    @Given("^I want to \"([^\"]*)\"$")
    public void i_want_to_something(String strArg1) throws Throwable {

		driver = initalizeDriver();
		driver.manage().window().maximize();	
		
		driver.get(prop.getProperty("url"));
		System.out.println("Given I order " + strArg1);
    }
    
    @When("^I enter an (.+) in the Currency I Have$")
    public void i_enter_an_in_the_currency_i_have(String amount) throws Throwable {   	
    	orderPage op = new orderPage(driver);
    	Assert.assertEquals(op.getInputCurrency().getText(), "GBP");
    	op.getCurrencyFrom().sendKeys(amount);
    }


    @Then("^I should see the Euro exchange rate$")
    public void i_should_see_the_euro_exchange_rate() throws Throwable {
    	Thread.sleep(2000);
    	orderPage op = new orderPage(driver);
    	String total = op.getOrderTotal().getText();
    	Assert.assertTrue(total.contains(euroTotalTxt));
    	
    	driver.close();
    	
    }
    
    @Then("^I should see the (.+) in the basket$")
    public void i_should_see_the_in_the_basket(String currencyorder) throws Throwable {
        personalDetailsPage pd = new personalDetailsPage(driver);
        
        Thread.sleep(1500);
        
        String currencyCode = pd.getCurrencyCodeFromBasket().getText();
    	Assert.assertTrue(currencyCode.contains(currencyorder));
    	
    	pd.getAnotherCurrencyBtn().isDisplayed();
    }

    @Then("^I should see the confirmation page$")
    public void i_should_see_the_confirmation_page() throws Throwable {
    	confirmationPage cp=new confirmationPage(driver);
    	
    	WebElement orderTxt = cp.getProcessingformTxt();
    	
    	//WebDriverWait w=new WebDriverWait(driver, 0);
    	//w.until(ExpectedConditions.visibilityOf(orderTxt()));
    	
    	Thread.sleep(10000);
    	
    	String getTxt = orderTxt.getText();
    	
    	Assert.assertTrue(getTxt.contentEquals("We will now start processing your order. Please remember to bring proof of ID and confirmation of your order upon collection."));
    	
    	driver.close();

    }


    private WebElement orderTxt() {
		// TODO Auto-generated method stub
		return null;
	}

	@And("^select (.+) from the Currency I Want$")
    public void select_from_the_currency_i_want(String currency) throws Throwable {
    	Thread.sleep(3000);
    	orderPage op = new orderPage(driver);
    	op.getCurrencyToSelect().click();
    	
    	Select selectCurrency = new Select (op.getCurrencyToSelect());
    	selectCurrency.selectByValue(currency);
    	
    	op.getCurrencyTo().click();
    	Thread.sleep(1000);
    			

    }

    @And("^I proceed$")
    public void i_proceed() throws Throwable {
    	Thread.sleep(1500);
    	orderPage op = new orderPage(driver); 
    	personalDetailsPage pd = new personalDetailsPage(driver);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        //WebElement orderNowBtn = op.getOrderNowBtn();
        
          
        Thread.sleep(2000);
    /*     
    if(op.getOrderNowBtn().isDisplayed())
    {
    	op.getOrderNowBtn().click();
    } else {
    	pd.getProceedBtn().click(); 	  	
    } */
    
    
        try {
        	WebElement orderNowBtn = op.getOrderNowBtn();
            if (orderNowBtn.isDisplayed()){
            	orderNowBtn.click();
                System.out.println("This works");
            } else if (!orderNowBtn.isDisplayed()) {
            	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
            	WebElement proceed = pd.getProceedBtn();
                proceed.click(); 
                System.out.println("Test2");
            }
          } catch ( org.openqa.selenium.NoSuchElementException e){

          }
        }
        	 
        
    @And("^I proceed1$")
    public void i_proceed1() throws Throwable {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	personalDetailsPage pd = new personalDetailsPage(driver);
    	
    	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");  
    	System.out.println("Navigated to end");
    	
        //WebElement orderNowBtn = op.getOrderNowBtn();
        pd.getProceedBtn().click();
    }
    
    @And("^proceed$")
    public void proceed() throws Throwable {
    	orderPage op = new orderPage(driver); 
    	op.getProceedBtn().click();
        
          
        
    }


	@And("^I populate the order form$")
    public void i_populate_the_order_form() throws Throwable {
		personalDetailsPage pd = new personalDetailsPage(driver);
		
		// set location
		pd.getLocation().click();
		
		Thread.sleep(3500);
		
    	Select selectLocation = new Select (pd.getLocation());
    	selectLocation.selectByValue("7");
    	
    	Thread.sleep(1000);
    	
    	// set date today
    	WebElement dateCurrent = pd.getDate();
    	dateCurrent.click();
    	dateCurrent.sendKeys(Keys.ENTER);
    	
    	// set personal details
    	Select selectTitle = new Select (pd.getTitle());
    	selectTitle.selectByValue("1");
    	
    	pd.setFirstName("Pavan");
    	pd.setLastName("Rai");
    	pd.setEmail("pavanrai@hotmail.co.uk");
    	pd.setConfirmEmail("pavanrai@hotmail.co.uk");
    	pd.setMobileNumber("07912345678");
    	
    }
	
    @Given("^I want to order 600000 VND and 100 OMR$")
    public void i_want_to_order_600000_vnd_and_100_omr() throws Throwable {
    	driver = initalizeDriver();
		driver.manage().window().maximize();	
		
		driver.get(prop.getProperty("url"));
    }

    @Then("^I should see the Enter Purchase Amount screen$")
    public void i_should_see_the_enter_purchase_amount_screen() throws Throwable {
    	orderPage op = new orderPage(driver);
    	op.getCurrencyFrom().isDisplayed();
    	op.getCurrencyTo().isDisplayed();
    	Assert.assertEquals(op.getPageTitle().getText(), "Order travel money");
    	
    }   	

    @And("^I add another currency$")
    public void i_add_another_currency() throws Throwable {
    	orderPage op = new orderPage(driver);
    	op.clickAddCurrency();
    }
    
    @Then("^I should remove the \"([^\"]*)\" currency$")
    public void i_should_remove_the_something_currency(String strArg1) throws Throwable {
    	orderPage op = new orderPage(driver);
    	Thread.sleep(1000);
    	op.clickFirstTrashCan().click();
    	driver.close();
    }

}

	
	


