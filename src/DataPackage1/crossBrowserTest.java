package DataPackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class crossBrowserTest 
{
	WebDriver driver;
	@Parameters ({"Browser"})

	@BeforeTest
	public void SetUp(String brw) 
	{
		switch (brw) 
		{
		case "Chrome":
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		case "Firefox":
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		default:
			Reporter.log("Browser value not matching");
			break;
		}
	}

	@DataProvider
	public Object[][] supplyData()
	{
		String Login[][]= new String[5][2];
		Login [0][0]= "Admin";
		Login [0][1]= "Qedge123!@#";
		Login [1][0]= "Admin";
		Login [1][1]= "Qedge123!#";
		Login [2][0]= "Admin";
		Login [2][1]= "Qedge123!@#";
		Login [3][0]= "Admi";
		Login [3][1]= "Qedge123!#";
		Login [4][0]= "Admin";
		Login [4][1]= "Qedge123!@#";
		return Login;

	}

	@Test(dataProvider = "supplyData")
	public void validateLogin(String Username, String PassWord) throws Throwable 
	{
		driver.get("http://orangehrm.qedgetech.com/");
		driver.findElement(By.name("txtUsername")).sendKeys(Username);
		driver.findElement(By.name("txtPassword")).sendKeys(PassWord);
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		String expected = "dashboard";
		String Actual = driver.getCurrentUrl();
		if (Actual.contains(expected)) 
		{
			Reporter.log("Login success.."+Actual+"  "+expected,true);
		}
		else {
			Reporter.log("Login not success.."+Actual+"  "+expected,true);
		}
	}

	@AfterTest
	public void tearDown() 
	{
		driver.close();
	}
}
