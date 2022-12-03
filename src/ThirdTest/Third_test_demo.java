package ThirdTest;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import util.appUtil;

public class Third_test_demo extends appUtil 
{
@Test(priority=1)
public void admin() throws Throwable
{
driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
Reporter.log("exucuting Admin",true);
Thread.sleep(5000);
}
@Test(invocationCount=3,priority=1)
public void pim() throws Throwable
{
	driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
	Reporter.log("exucuting PIM",true);
	Thread.sleep(5000);
}

@Test(priority=0)
public void leave() throws Throwable
{
	driver.findElement(By.xpath("//b[normalize-space()='Leave']")).click();
	Reporter.log("exucuting leave",true);
	Thread.sleep(5000);
}

}