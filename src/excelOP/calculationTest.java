package excelOP;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class calculationTest 
{
WebDriver driver;
XSSFWorkbook wb;

@BeforeTest
public void setup()
{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
}

@Test
public void verifyPercentage() throws Throwable
{
	FileInputStream fi= new FileInputStream("D://calculate");
	wb = new XSSFWorkbook(fi);
	XSSFSheet ws = wb.getSheetAt(0);
	int rowCount = ws.getLastRowNum();
	System.out.println("No. of rows::"+ rowCount);
	
	for (int i = 2; i <= rowCount; i++) 
	{
		driver.get("https://www.calculator.net/percent-calculator.html");
	}
	
}
@AfterTest
public void TearDown()
{
	driver.close();
}
}
