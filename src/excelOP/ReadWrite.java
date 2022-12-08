package excelOP;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWrite {

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fi= new FileInputStream("E://SampleTest.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Login");
		int rowCount = ws.getLastRowNum();
		System.out.println("No. of rows= "+rowCount);
		for (int i = 1; i <= rowCount; i++) 
		{
			// Get first cell all row
			String user = ws.getRow(i).getCell(0).getStringCellValue();
			// Get second cell all row
			String pass = ws.getRow(i).getCell(1).getStringCellValue();
			System.out.println(user +"   "+pass);
			
			// write some text into result cells
			ws.getRow(i).createCell(2).setCellValue("I am Don");
		}
		fi.close();
		// Now Write this result into another output file
		FileOutputStream fo= new FileOutputStream("E://results.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();

	}

}
