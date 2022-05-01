package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	public WebDriver driver;
	

	By signin=By.cssSelector("a[href*='sign_in']");
	By Pop=By.xpath("//button[normalize-space()='NO THANKS']");
	By title=By.xpath("//div[@class='text-center']/h2");
	By navbar=By.cssSelector("div[class='container'] nav");
	
	public Landingpage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement popup()
	{
		return driver.findElement(Pop);
		
	}

	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
		
	}
	
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNav()
	{
		return driver.findElement(navbar);
	}

}
