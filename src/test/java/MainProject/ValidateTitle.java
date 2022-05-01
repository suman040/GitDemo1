package MainProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import PageObjects.Landingpage;

import Resources.base;

public class ValidateTitle extends base{
	WebDriver driver;
	public Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initial() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Landed on ValidateTitle");
	}
	
	@Test
	public void Landingpage() throws IOException
	{
	
		Landingpage l=new Landingpage(driver);
		l.popup().click();
		//l.getLogin().click();
		String title=l.getTitle().getText();
		Assert.assertEquals(title, "FEATURED COURSES1");
		Assert.assertTrue(l.getNav().isDisplayed());
		log.info("Checking the title name");

		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
