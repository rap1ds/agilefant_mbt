package org.tigris.mbt.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.*;

public class TestData {
	private InputStream myxls;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell cell;
	private String value;
	
	public TestData(String filename){
		try {
			myxls = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new HSSFWorkbook(myxls);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	String getValue(String sheetName, int rowIndex, int cellnum){
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowIndex);
		cell = row.getCell(cellnum);
		value = cell.toString();
		return value;
	}
}