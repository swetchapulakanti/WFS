package com.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {
	
@DataProvider(name="logindata")
	public String[][] getData() throws Exception {
		
		File excelFile=new File("./src/test/resources/TestData.xlsx");
		System.out.print(excelFile.exists());
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		int noofrows=sheet.getPhysicalNumberOfRows();
		int noofcol=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[noofrows-1][noofcol];
		for (int i=1;i<noofrows;i++)
		{
			for(int j=0;j<noofcol;j++) {
				
				DataFormatter df= new DataFormatter();
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();				
			}
		}
		workbook.close();
		fis.close();
		
	return data;
}}
