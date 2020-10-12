# MONEYCORP AUTOMATION

# Introduction
Create automation framework for the website http://qa-travelmoney.moneycorp.com/ using Java programming language with BDD framework

# Pre-requiste 
- Java 8 installed on machine and in system environment variables HOME and path
- Eclipse IDE or intellij needed to run the automation
- Chromedriver from selenium needs to be installed

# Creating automation framework

1. Create maven repository which is a software project managemen and build management tool for java frameworks

2. Get dependencies such as selenium, cucumber, testng etc which is located in https://github.com/Pavster84/moneycorp/blob/master/pom.xml

3. Create features file locted in "src/test/java/features"
  - This contains the five features in the automation test
  - The files contains Scenario Outline and Examples keyword together will form a set of test cases 
  
  Features example below for the second automated example provided in the docx;
  
Feature: Use the website to order USD currency
        So that I can order US Dollars
        As a customer
        I want to be able to select USD and place an order
        
    Scenario Outline: Place order for USD
        Given I want to "order USD"
        And I enter an <amount> in the Currency I Have
        And select <currency> from the Currency I Want
        And I proceed
        Then I should see the <currencyorder> in the basket
        And I populate the order form
        And I proceed1
        Then I should see the confirmation page

        
        
	    Examples:
	    | amount | currency  | currencyorder |
	    | 500	 | USD       | USD			 |
  
 
4. After creating features, create a Test Runner class and a steps to run class for further execution this is located in "src/test/java/cucumberOptions"

5. Created package 'StepDefinations' this contains all the code to perform the features when run

6. Created page objects located in "src/main/java/pageObjects" this contains all the web elements, get and set methods.
 - Easy to maintain
 - Reusability of code
 - Reduce or eliminate duplicate code
 
 Example below of orderPage:
 
 public class orderPage {

public WebDriver driver;
	
	public orderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By currencyHave = By.id("CurrencyFrom");
	By currencyWant = By.id("CurrencyTo");
	By currencyInput = By.xpath("//strong[contains(text(),'GBP')]");
	By currencyToSelect = By.id("CurrencyToSelect");
	By orderTotal = By.cssSelector(".pull-right.no-margin > strong");
	By orderNowBtn = By.xpath("//span[contains(text(),'Order now')]");
	By addNewCurrency = By.id("AddAnotherCurrency");
	By h2Title = By.tagName("h2");
	By proceedBtn = By.xpath("//body/div[@id='content']/div[2]/div[1]/div[1]/fieldset[1]/div[3]/button[1]");
	By trashIcon = By.xpath("//tbody/tr[1]/td[4]/a[1]/i[1]");
	
	public WebElement getCurrencyFrom()
	{
		return driver.findElement(currencyHave);
	}
	
	public WebElement getCurrencyTo()
	{
		return driver.findElement(currencyWant);		
	}
 
7. The "src/main/java/resources" stores the following
- Base file which is the login url to the site opening in chrome or firefox
- Data.properties file to ensure data driven values in one file
- chromedriver.exe used is located here

# Run all automation tests

To run all the feature files the following code in "src/test/java/cucumberOptions"

package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//feature
//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/",
		glue="stepDefinations")
public class TestRunner extends AbstractTestNGCucumberTests {

# Run specific automation 

package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//feature
//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/moneycorpEX3.feature",
		glue="stepDefinations")
public class TestRunner extends AbstractTestNGCucumberTests {

}

# Improvements
- Need to create hooks
- Excerise 3 for automation needs refactoring
- Reporting required when test is executed




  


