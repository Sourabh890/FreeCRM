package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	//To fetch the data from excel with the help of data driven approach. Below is the code for it.
	public static String TESTDATA_SHEET_PATH = "C:\\workspace\\TestPom\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";

	static Workbook workbook;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream fis= null;
		try {
			fis=new FileInputStream(TESTDATA_SHEET_PATH);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
	
		try {
			workbook=WorkbookFactory.create(fis);
	    } catch (IOException e) {
	       e.printStackTrace();
	    }
		sheet=workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
			
		}
		return data;
		
	}

	//To take a screenshot of failed tests below is the utility method:
	public static void takeScreenshotAtEndOfTest() throws IOException{
		// TODO Auto-generated method stub
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir= System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir+"/screenshots/"+ System.currentTimeMillis() +".png"));
		
	}
}

