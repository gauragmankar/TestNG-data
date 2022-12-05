import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import util.appUtil_1;

public class Fourth_calculateTest extends appUtil_1
{
@Test( priority= 1, enabled=true)
public static void addition() throws Throwable
{
	// tap on C to clear text
	driver.findElement(By.xpath("(//input[@value='C'])[1]")).click();
	driver.findElement(By.xpath("(//input[@name='display'])[1]")).sendKeys("200");
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//input[@value='+'])[1]")).click();
	driver.findElement(By.xpath("(//input[@name='display'])[1]")).sendKeys("240");
	driver.findElement(By.xpath("(//input[@value='='])[1]")).click();
	String addresult= driver.findElement(By.xpath("(//input[@name='display'])[1]")).getAttribute("value");
	Reporter.log(addresult,true);
}
@Test(description= " Validate multiplication", priority= -1, enabled=true)
public static void Multiplication() throws Throwable
{
	// tap on C to clear text
	driver.findElement(By.xpath("(//input[@value='C'])[1]")).click();
	driver.findElement(By.xpath("(//input[@name='display'])[1]")).sendKeys("200");
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//input[@value='x'])[1]")).click();
	driver.findElement(By.xpath("(//input[@name='display'])[1]")).sendKeys("3");
	driver.findElement(By.xpath("(//input[@value='='])[1]")).click();
	String multiresult= driver.findElement(By.xpath("(//input[@name='display'])[1]")).getAttribute("value");
	Reporter.log(multiresult,true);
}
@Test( priority= 0, enabled=true)
public static void division() throws Throwable
{
	// tap on C to clear text from
	driver.findElement(By.xpath("(//input[@value='C'])[1]")).click();
	driver.findElement(By.xpath("(//input[@name='display'])[1]")).sendKeys("200");
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//input[@value='/'])[1]")).click();
	driver.findElement(By.xpath("(//input[@name='display'])[1]")).sendKeys("20");
	driver.findElement(By.xpath("(//input[@value='='])[1]")).click();
	String divresult= driver.findElement(By.xpath("(//input[@name='display'])[1]")).getAttribute("value");
	Reporter.log(divresult,true);
}

}
