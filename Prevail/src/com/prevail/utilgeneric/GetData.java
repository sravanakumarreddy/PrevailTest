package com.prevail.utilgeneric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetData {

	static String data;
	static File f;
	
	
	public static String getDataFromExcel(String filePath,String sheetName,int rowNum,int cellNum) throws Exception {
		try
		{
		f=new File(System.getProperty("user.dir")+filePath);
		System.out.println(System.getProperty("user.dir"));
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row r=sh.getRow(rowNum);
		data=r.getCell(cellNum).toString();
		}
		catch(NullPointerException e)
		{
			System.out.println("Requested cell is empty please verify");
		}
		return data;
	}
	
	public static String getDataFromProperties(String filePath,String propName) throws Exception {
		
		f=new File(System.getProperty("user.dir")+filePath);
		FileInputStream fis=new FileInputStream(f);
		Properties p=new Properties();
		p.load(fis);
		data=p.getProperty(propName);
		return data;
	}
	
	  public static int getRowCount(String filePath,String sheetName) throws InvalidFormatException, IOException{
		  
		f=new File(System.getProperty("user.dir")+filePath);
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
	    int rowCount = sh.getLastRowNum()+1;
	    return rowCount;
	    
	   }
	  
	  public static int getColumnCount(String filePath,String sheetName,int RowNo) throws InvalidFormatException, IOException{
		  
			f=new File(System.getProperty("user.dir")+filePath);
			FileInputStream fis=new FileInputStream(f);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetName);
			Row row = sh.getRow(RowNo);
			int colCount = row.getLastCellNum();
			return colCount;
	       
	   }
	  
	
}
