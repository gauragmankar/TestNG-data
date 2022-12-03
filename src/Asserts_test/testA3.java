package Asserts_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testA3 {
	WebDriver driver;
	@Test
	public void validate_title()throws Throwable
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://yahoo.com");
		String expected= "Google";
		String actual= driver.getTitle();
		try {
			Assert.assertTrue(actual.equalsIgnoreCase(expected),"Title is matching");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}
}
