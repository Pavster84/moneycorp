package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class personalDetailsPage {
	public WebDriver driver;


	public personalDetailsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By currencyBasketCountryCode = By.cssSelector("[data-bind='text: TermsCurrency.Code']");
	By currencyBasketOrder = By.cssSelector("[data-bind='text: QuantityTerm']");
	By currencyPaying = By.xpath("data-bind='text: QuantityBase']");
	By addAnotherCurrencyBtn = By.id("AddAnotherCurrency");
	By locationDropDown = By.id("Location");
	By titleDropDown = By.id("Title");
	By firstNameTxtBox = By.id("FirstName");
	By lastNameTxtBox = By.id("LastName");
	By emailTxtBox = By.id("Email");
	By emailConfirmTxtBox = By.id("ConfirmEmail");
	By mobNumberTxtBox = By.id("PhoneNumber");
	By dateTxtBox = By.xpath("//input[@id='When']");
	By proceedBtn = By.xpath("//body/div[@id='content']/div[@id='Checkout_ReserveAndCollect']/div[2]/div[1]/div[1]/fieldset[1]/div[4]/button[1]");
	By loadingDialog = By.cssSelector(".modal-content");

	
	
	public WebElement getCurrencyCodeFromBasket()
	{
		return driver.findElement(currencyBasketCountryCode);
	}
	
	public WebElement getOrderFromBasket()
	{
		return driver.findElement(currencyBasketOrder);		
	}
	
	public WebElement getPayingFromBasket()
	{
		return driver.findElement(currencyPaying);
	}
	
	public WebElement getAnotherCurrencyBtn()
	{
		return driver.findElement(addAnotherCurrencyBtn);
	}
	
	public WebElement getLocation()
	{
    	return driver.findElement(locationDropDown);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(titleDropDown);
	}
	
	public WebElement getDate()
	{
		return driver.findElement(dateTxtBox);
	}
	
	public void setFirstName(String fName)
	{
		driver.findElement(firstNameTxtBox).sendKeys(fName);;
	}
	
	public void setLastName(String lName)
	{
		driver.findElement(lastNameTxtBox).sendKeys(lName);;
	}
	
	public void setEmail(String email)
	{
		driver.findElement(emailTxtBox).sendKeys(email);;
	}
	
	public void setConfirmEmail(String confirmEmail)
	{
		driver.findElement(emailConfirmTxtBox).sendKeys(confirmEmail);;
	}
	
	public void setMobileNumber(String mob)
	{
		driver.findElement(mobNumberTxtBox).sendKeys(mob);
	}
	
	public WebElement getProceedBtn()
	{
		return driver.findElement(proceedBtn);
	}
	
	
	

	
	
}

