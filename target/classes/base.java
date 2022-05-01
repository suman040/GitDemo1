package Resources;

import java.io.File;



import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\suman\\eclipse-workspace\\E2E\\src\\main\\java\\Resources\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Chromedriver\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else if(browserName.equals("Edge"))
	{
		System.setProperty("webdriver.edge.driver", "C:\\Chromedriver\\msedge.exe");
		driver=new EdgeDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	
	
	
	}
	public void getScreenshot(String Testmethodname, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationfolder=System.getProperty("user.dir")+"\\reports\\"+Testmethodname+".png";
		FileUtils.copyFile(source, new File(destinationfolder));
		return destinationfolder;
		
	}
	

}
