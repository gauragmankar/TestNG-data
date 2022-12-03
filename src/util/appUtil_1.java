package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class appUtil_1 
{
	public static WebDriver driver;
	@BeforeSuite
	public static void SetUp() throws Throwable
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://calc.qedgetech.com/");
		Thread.sleep(5000);
	}
	@AfterSuite
	public static void teardown()
	{
		driver.close();
	}

}
