package Asserts_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testA2 {
	WebDriver driver;
	@Test
	public void validate_title()throws Throwable
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://google.com");
		String expected= "Google";
		String actual= driver.getTitle();
		try {
			Assert.assertFalse(actual.contains(expected),"Title matching");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}
}
