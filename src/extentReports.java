import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extentReports 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void reportGeneration()
	{
		report = new ExtentReports("ExtentReport/reports/Demo.html");
	}
	@BeforeMethod
	public void setUp() throws Throwable
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
	}
	@Test
	public void PassTest()
	{
		test= report.startTest("Validate Title");
		test.assignAuthor("GSM");
		test.assignCategory("Functional test");
		String expectedTitle = "Google";
		String ActualTitle = driver.getTitle();
		if (expectedTitle.equalsIgnoreCase(ActualTitle))
		{
			test.log(LogStatus.PASS,"Title is matching"+expectedTitle+"  "+ActualTitle);
		}
		else 
		{
			test.log(LogStatus.FAIL,"Title is not matching"+expectedTitle+"  "+ActualTitle);
		}
	}
	@Test
	public void FailTest()
	{
		test= report.startTest("Validate Title");
		test.assignAuthor("GSM");
		test.assignCategory("Functional test");
		String expectedTitle = "Gamil";
		String ActualTitle = driver.getTitle();
		if (expectedTitle.equalsIgnoreCase(ActualTitle))
		{
			test.log(LogStatus.PASS,"Title is matching"+expectedTitle+"  "+ActualTitle);
		}
		else 
		{
			test.log(LogStatus.FAIL,"Title is not matching"+expectedTitle+"  "+ActualTitle);
		}	
	}
	@AfterMethod
	public void TearDown()
	{
		report.endTest(test);
		report.flush();
		driver.close();
	}
}













