package com.prevail.utilgeneric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetData {

	static String data;
	static File f;
	
	public static void writeDataToExcel(String filePath,String sheetName,int rowNum,int colNum,String val) throws Exception {
		
		f=new File(filePath);
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row r=sh.createRow(rowNum);
		r=sh.getRow(rowNum);
		Cell c=r.getCell(colNum,r.RETURN_BLANK_AS_NULL);
		
		System.out.println(c);
		
		if(c==null)
		{
		r.createCell(colNum).setCellValue(val);
		}
		else
		{
		c.setCellValue(val);
		}
		
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		
	}
	
	public static void writeDataToProperties(String filePath,String propName,String propVal) throws Exception {
		
		f=new File(filePath);
		FileInputStream fis=new FileInputStream(f);
		Properties p=new Properties();
		p.load(fis);
		p.put(propName, propVal);
		
		FileOutputStream fos=new FileOutputStream(f);
		p.store(fos, "");
	}
	
}
