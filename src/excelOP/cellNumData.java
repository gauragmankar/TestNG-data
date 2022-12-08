package excelOP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class cellNumData {

	public static void main(String[] args) throws Throwable	{
		FileInputStream fi= new FileInputStream("E://SampleTest.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Login");
		int rowCount = ws.getLastRowNum();
		System.out.println("No. of rows= "+rowCount);
		for (int i = 1; i <= rowCount; i++) 
		{
			// Get first cell all row
			String user = ws.getRow(i).getCell(0).getStringCellValue();
			// read integer type cell and store
			int celldata = (int) wb.getSheet("Login").getRow(i).getCell(1).getNumericCellValue();
			// convert cell data into string type
			String pass= String.valueOf(celldata);
			System.out.println(user +"   "+pass);
			
			// write some text into result cells
			ws.getRow(i).createCell(2).setCellValue("I am Don");
		}
		fi.close();
		wb.close();
	}

}
