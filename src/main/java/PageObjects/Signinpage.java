package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Signinpage {
	
	public WebDriver driver;
	

	By email=By.xpath("//input[@type='email']");
	By password=By.xpath("//input[@type='password']");
	By login=By.cssSelector("input[value='Log In']");
	By msg=By.cssSelector("div[role='alert']");
	public Signinpage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
		
	}

	
	public WebElement getPasswrd()
	{
		return driver.findElement(password);
		
	}
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	
	public WebElement getmsg()
	{
		return driver.findElement(msg);
	}

}
