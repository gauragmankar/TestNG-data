package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class appUtil {
public static WebDriver driver;
@BeforeTest
public static void setUp() throws Throwable
{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://orangehrm.qedgetech.com/");
	Thread.sleep(5000);
	// Login to site
	driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
	driver.findElement(By.name("Submit")).click();
	Reporter.log("Running as SetUp", true);
}
@AfterTest
public static void tearDown()
{
	driver.close();
	Reporter.log("Running as TearDown", true);
}
}
