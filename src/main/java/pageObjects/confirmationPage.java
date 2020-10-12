package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class confirmationPage {
	
public WebDriver driver;
	
	public confirmationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By orderConfirmTxt = By.xpath("//p[contains(text(),'We will now start processing your order. Please re')]");
	By currencyWant = By.id("CurrencyTo");
	By currencyInput = By.xpath("//strong[contains(text(),'GBP')]");
	By currencyToSelect = By.id("CurrencyToSelect");
	By orderTotal = By.cssSelector(".pull-right.no-margin > strong");
	By orderNowBtn = By.xpath("//span[contains(text(),'Order now')]");
	
	
	public WebElement getProcessingformTxt()
	{
		return driver.findElement(orderConfirmTxt);
	}

}
