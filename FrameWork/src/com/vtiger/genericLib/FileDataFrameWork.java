package com.vtiger.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileDataFrameWork {
	public String fetchDataFromProperty(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("D:\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(file);
		String value = pobj.getProperty(key);
		return value;
		
	}
	public String fetchDataFromExcel(String sheet,int rollnum,int cellnum) throws Throwable, IOException
	{
		FileInputStream file = new FileInputStream("biswanath.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheet);
		Row row = sh.getRow(rollnum);
			Cell cell = row.getCell(cellnum);
			String value = cell.getStringCellValue();
			return value;
		
	}
	public void addDataToExcel(String sheet,int rollnum,int cellnum,String newData) throws  IOException
	{
		FileInputStream file = new FileInputStream("D:\\ExcelData.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheet);
		Row row = sh.createRow(rollnum);
			Cell cell = row.createCell(cellnum);
			cell.setCellValue(newData);
			FileOutputStream fileout = new FileOutputStream("D:\\ExcelData.xlsx");
			book.write(fileout);
			fileout.flush();
	}
}
