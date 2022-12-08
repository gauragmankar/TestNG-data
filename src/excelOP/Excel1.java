package excelOP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel1 {

	public static void main(String[] args) throws Throwable
	{
		// read path of excel file
		FileInputStream fi= new FileInputStream("E://SampleTest.xlsx");
		// get workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		// get sheet from wb
		XSSFSheet ws = wb.getSheet("Login");
		// get first row from Login sheet
		XSSFRow row = ws.getRow(0);
		
		// count number of rows in a sheet
		int rowCount = ws.getLastRowNum();
		
		//	count number of cells in a sheet
		int cellsCount = row.getLastCellNum();
		
		System.out.println("No. of rows=="+rowCount+"  "+"No. of cells== "+cellsCount);
		
		// Print second row first cell data
		String username = ws.getRow(9).getCell(0).getStringCellValue();
		// Print second row second cell data
		
		String password= ws.getRow(9).getCell(1).getStringCellValue();
		
		System.out.println(username+"   "+password);
		fi.close();
		wb.close();

	}

}
