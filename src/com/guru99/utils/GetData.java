package com.guru99.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetData {
	
	public static String fromExcel(String fileName, String sheetName, int rowIndex, int cellIndex)
	{
		String data=null;
		try{
			File file=new File("./data-lib/"+fileName+".xlsx");
			FileInputStream fis=new FileInputStream(file);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet st=wb.getSheet(sheetName);
			Row rw=st.getRow(rowIndex);
			Cell c=rw.getCell(cellIndex);
			data=c.toString();
		}
		catch(FileNotFoundException e)
		{
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	public static int lastRowIndex(String fileName, String sheetName)
	{
		int rowIndex=0;
			try
			{
				File file=new File("./data-lib/"+fileName+".xlsx");
				FileInputStream fis=new FileInputStream(file);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet st=wb.getSheet(sheetName);
				rowIndex= st.getLastRowNum();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return rowIndex;
	}
	public static int lastCellIndex(String fileName, String sheetName, int rowIndex)
	{
		int cellIndex=0;
			try
			{
				File file=new File("./data-lib/"+fileName+".xlsx");
				FileInputStream fis=new FileInputStream(file);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet st=wb.getSheet(sheetName);
				Row rw=st.getRow(rowIndex);
				cellIndex=rw.getLastCellNum()-1;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return cellIndex;
	}

}
