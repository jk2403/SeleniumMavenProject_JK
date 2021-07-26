package utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProviderDemo {

	static String projectpath = System.getProperty("user.dir");
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getRowCount();
		getColCount();
		getStringCellData();
		getNumericCellData();
	}

	public static void getRowCount()
	{
		try {
			System.out.println(projectpath);
			workbook = new XSSFWorkbook(projectpath+"\\excel\\data.xlsx");
			sheet = workbook.getSheet("sheet1");
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("No. of Rows: "+rowcount);

		}
		catch(Exception exp)
		{
			System.out.println("exception messgae is: "+exp.getMessage());
			System.out.println("exception cause is: "+exp.getCause());
			//System.out.println("exception printstack trace is: "+exp.printStackTrace());
			exp.printStackTrace();
		}
	}
	public static void getColCount()
	{
		try {
			workbook = new XSSFWorkbook(projectpath+"\\excel\\data.xlsx");
			sheet = workbook.getSheet("sheet1");
			int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No. of Columns: "+colcount);

		}
		catch(Exception exp)
		{
			System.out.println("exception messgae is: "+exp.getMessage());
			System.out.println("exception cause is: "+exp.getCause());
			exp.printStackTrace();
		}
	}
	public static void getStringCellData()
	{
		try {
		workbook = new XSSFWorkbook(projectpath+"\\excel\\data.xlsx");
		sheet = workbook.getSheet("sheet1");
		String CellData1 = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println("String CellData1 is: "+CellData1);
		}
		catch(Exception exp)
		{
			System.out.println("Exception message is: "+exp.getMessage());
			System.out.println("Exception Cause is: "+exp.getCause());
			exp.printStackTrace();
		}
	}
	
	public static void getNumericCellData()
	{
		try {
			workbook = new XSSFWorkbook(projectpath+"\\excel\\data.xlsx");
			sheet = workbook.getSheet("sheet1");
			//int celldata2= (int) sheet.getRow(1).getCell(1).getNumericCellValue();
			double celldata2= sheet.getRow(1).getCell(1).getNumericCellValue();
			System.out.println("Numeric CellData2 is: "+celldata2);
			}
		catch(Exception exp)
		{
			System.out.println("Exception message is: "+exp.getMessage());
			System.out.println("Exception Cause is: "+exp.getCause());
			exp.printStackTrace();
		}
	}
}
