package Resources;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	static ExtentReports extent;

	public static ExtentReports getReport()
	{
		// Extent Reports, ExtentSparkReporter
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path); // Need to pass path to where your test report should be created
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Main Project");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Suman");
		return extent;
	}
	

}
