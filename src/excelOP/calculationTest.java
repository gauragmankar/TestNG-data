package excelOP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;
import org.openqa.selenium.By;
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
		FileInputStream fi= new FileInputStream("E://calculate.xlsx");
		wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheetAt(0);
		int rowCount = ws.getLastRowNum();
		System.out.println("No. of rows::"+ rowCount);

		for (int i = 1; i <= rowCount; i++) 
		{
			driver.get("https://www.calculator.net/percent-calculator.html");
			Thread.sleep(3000);
			if (wb.getSheetAt(0).getRow(i).getCell(0).getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				int cellData1 = (int)wb.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue();
				String Percentage= String.valueOf(cellData1);
				if (wb.getSheetAt(0).getRow(i).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC) 
				{
					int cellData2 = (int)wb.getSheetAt(0).getRow(i).getCell(1).getNumericCellValue();
					String Amount= String.valueOf(cellData2);	

					// Locate the web elements
					driver.findElement(By.name("cpar1")).sendKeys(Percentage);
					driver.findElement(By.name("cpar2")).sendKeys(Amount);
					driver.findElement(By.xpath("(//input[@value='Calculate'])[1]")).click();
					Thread.sleep(3000);
					String result = driver.findElement(By.xpath("(//p[@class='verybigtext'])[1]")).getText();
					ws.getRow(i).createCell(2).setCellValue(result);
				}
			}
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("E://calResult.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
}
