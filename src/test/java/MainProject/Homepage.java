package MainProject;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Landingpage;
import PageObjects.Signinpage;
import Resources.base;


public class Homepage extends base{
	WebDriver driver;
	public Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initial() throws IOException
	{
		driver=initializeDriver(); 	
		log.info("Driver Initialized");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Landed on HomePage");
		Landingpage l=new Landingpage(driver);
		l.popup().click();
		l.getLogin().click();
	
	}
	
	@Test(dataProvider="sendData")
	public void Landingpage(String username, String password) throws IOException
	{
		
		
		Signinpage sin=new Signinpage(driver);
		sin.getEmail().sendKeys(username);
		sin.getPasswrd().sendKeys(password);
		sin.getLogin().click();
		log.error("Invalid Username and Password");		
		
	
	}

	
	@DataProvider // Parameterizing the data with Dataprovider annotation
	public Object[][] sendData()
	{
		
		// First [] is row- stands for how many differenct data types test should run.
		// Second [] is column- stands for how many values as per each test.
		//0th row
		Object[][] data=new Object[2][2];
		data[0][0]="abc@gmail.com";
		data[0][1]="3493834";
		//1st row
		data[1][0]="xyz@gmail.com";
		data[1][1]="39394";
		
		return data;		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
