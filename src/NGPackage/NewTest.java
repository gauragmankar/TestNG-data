package NGPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class NewTest {
	WebDriver driver;

	@BeforeMethod
	public void SetUP() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Reporter.log("Executing Setup",true);
	}

	@Test(priority= -1, enabled= false, invocationCount=2)
	public void TC1() 
	{
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		String text= driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		Reporter.log("Executing test",true);

	}
	@Test(priority= 1)
	public void TC2() 
	{
		String text1= driver.getTitle();
		System.out.println(text1);
		Reporter.log("Executing title",true);

	}
	@Test(priority= 0, enabled= true)
	public void TC3() 
	{
		String text3= driver.getCurrentUrl();
		System.out.println(text3);
		Reporter.log("Executing URL",true);
	}
	@Test(priority= 2, enabled= true)
	public void TC4() 
	{
		driver.findElement(By.name("proceed")).click();;
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
		Reporter.log("Executing TearDown",true);
	}

}
