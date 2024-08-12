package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
	public WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[@class='title']")
	WebElement products;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement menu;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logout;
	
	public boolean isMyProductsExists()
	{
		try
		{
		return(products.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void clickLogout() {
		menu.click();
		logout.click();
	}

}
