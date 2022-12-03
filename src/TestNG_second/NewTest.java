package TestNG_second;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class NewTest {
	WebDriver Driver;
	@BeforeMethod
	  public void Setup() 
	{
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.get("http://primusbank.qedgetech.com/");
	  }
  @Test(enabled= true)
  public void pbanking() 
  {
	  Driver.findElement(By.xpath("//input[@name='personal']")).click();
	  Reporter.log("Executing pbanking test",true);
  }
  @Test (priority= 0)
  public void cbanking() 
  {
	  Driver.findElement(By.xpath("//input[@name='corporate']")).click();
	  Reporter.log("Executing Cbanking test",true);
  }
  @Test
  public void ibanking() 
  {
	  Driver.findElement(By.xpath("//input[@name='NRI']")).click();
	  Reporter.log("Executing Ibanking test",true);
  }

  @AfterMethod
  public void tearDown() {
	  Driver.close();
	  Reporter.log("executing Postcondition, true");
  }

}
