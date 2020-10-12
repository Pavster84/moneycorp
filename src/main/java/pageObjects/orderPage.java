package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public WebElement getInputCurrency()
	{
		return driver.findElement(currencyInput);
	}
	
	public WebElement getOrderTotal()
	{
		return driver.findElement(orderTotal);
	}
	
	public WebElement getCurrencyToSelect()
	{
		return driver.findElement(currencyToSelect);
	}
	
	public WebElement getOrderNowBtn()
	{
		return driver.findElement(orderNowBtn);
	}
	
	public void clickAddCurrency()
	{
		driver.findElement(addNewCurrency).click();
	}
	
	public WebElement getPageTitle()
	{
		return driver.findElement(h2Title);
	}
	
	public WebElement getProceedBtn()
	{
		return driver.findElement(proceedBtn);
	}
	
	public WebElement clickFirstTrashCan()
	{
		return driver.findElement(trashIcon);
	}
	
	
}


