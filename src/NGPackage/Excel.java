package NGPackage;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream("D://calResult.xlsx");
		// create workbook
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		// get sheet from workbook
		XSSFSheet ws= wb.getSheet("Sheet1");
		// get row from sheet
		XSSFRow row = ws.getRow(0);
		
		// count no of rows
		int rowcount = ws.getLastRowNum();
		//no. of cells
		int cellcount = row.getLastCellNum();
		System.out.println("Row::"+rowcount+"   "+"cells::  "+cellcount);
		fi.close();
		wb.close();
		

	}

}
