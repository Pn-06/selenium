package com.saucelab.qa.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.saucelab.qa.baseclass.BaseClass;

public class Excel extends BaseClass{
	private static XSSFWorkbook workbook;
	public static XSSFSheet Sheet;
	private static XSSFCell Celldata;
	
	public static void createExcel(String path , String sheet) throws Exception {
		FileInputStream file = new FileInputStream(path);
		workbook= new XSSFWorkbook(file);
		Sheet =workbook.getSheet(sheet);
	}
	
	public static String getCellData(int row , int cell) {
		Celldata =Sheet.getRow(row).getCell(cell);
		String data = Celldata.getStringCellValue();
		
		return data;
		
	}
	
	
	public static int getNumericCellData(int row , int cell) {
		Celldata =Sheet.getRow(row).getCell(cell);
		int data = (int) Celldata.getNumericCellValue();
		
		return data;
	}
	

}
