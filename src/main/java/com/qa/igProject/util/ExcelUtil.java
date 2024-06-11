package com.qa.igProject.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public static final String TEST_DATA_SHEET_PATH = "./src/test/resource/testData/TESTDATASHEET.xlsx";

	private static Workbook book;
	private static  Sheet sheet;

	public static Object[][]  getTestData(String sheetName)
	{
		Object data[][] = null;

		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; // object [total number of rows] [total number of columns]

			for(int i = 0 ; i< sheet.getLastRowNum();i++) 
			{ // for the row 
				for(int j = 0 ; j<sheet.getRow(0).getLastCellNum(); j++)   //we do not add <= as index start from 0 and sheet from 1 then, if there are 3 rows in xcell then first row index will be 0 and 3rd last row infdex will be 2
				{ //for column
					data[i][j]= sheet.getRow(i+1).getCell(j).toString();	
				}	
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}


}






