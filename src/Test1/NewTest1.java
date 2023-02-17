package Test1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest1 
{
	@BeforeMethod
	public void beforeMethod() 
	{
		Reporter.log("Running as an beforeMethod", true);
	}
	
	
	@Test
	public void Login() 
	{
		Reporter.log("Executing Login test", true); 
	}
	@Test
	public void Compose() 
	{
		Reporter.log("Executing Compose test", true); 
	}
	@Test
	public void reply() 
	{
		Reporter.log("Executing reply test", true); 
	}


	@AfterMethod
	public void afterMethod() {
		Reporter.log("Running as an afterMethod", true);
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("Running as an beforeClass", true);
	}

	@AfterClass
	public void afterClass() {
		Reporter.log("Running as an afterClass", true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("Running as an beforeTest", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("Running as an afterTest", true);
	}

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Running as an beforeSuite", true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("Running as an afterSuite", true);
	}

}
