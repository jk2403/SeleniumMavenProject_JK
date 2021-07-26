package utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsFunction {

	public static String projectpath = System.getProperty("user.dir");
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtilsFunction(String Excelpath, String sheetname)
	{
		try {
		System.out.println(projectpath);
		workbook = new XSSFWorkbook(Excelpath);
		sheet = workbook.getSheet(sheetname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExcelUtilsFunction excel = new ExcelUtilsFunction(projectpath+"\\excel\\data.xlsx", "sheet1");
		excel.getRowCount();
		excel.getStringCellData(0,0);
		excel.getNumericCellData(1,1);
	}*/

	public static int getRowCount()
	{
		int rowcount = 0;
		try {
			//System.out.println(projectpath);
			rowcount = sheet.getPhysicalNumberOfRows();
			/*FileInputStream fis = new FileInputStream(projectpath+"\\excel\\data.xlsx");
		HSSFWorkbook workbook1 = new HSSFWorkbook(fis);
		HSSFSheet sheet1 = workbook1.getSheet("sheet1");
		int rowcount = sheet1.getPhysicalNumberOfRows();*/
			System.out.println("No. of Rows: "+rowcount);
		}
		catch(Exception exp)
		{
			System.out.println("exception messgae is: "+exp.getMessage());
			System.out.println("exception cause is: "+exp.getCause());
			//System.out.println("exception printstack trace is: "+exp.printStackTrace());
			exp.printStackTrace();
		}
		return rowcount;
	}
	
	public static int getColCount()
	{
		int colcount = 0;
		try {
			//System.out.println(projectpath);
			colcount = sheet.getRow(0).getPhysicalNumberOfCells();
			/*FileInputStream fis = new FileInputStream(projectpath+"\\excel\\data.xlsx");
		HSSFWorkbook workbook1 = new HSSFWorkbook(fis);
		HSSFSheet sheet1 = workbook1.getSheet("sheet1");
		int rowcount = sheet1.getPhysicalNumberOfRows();*/
			System.out.println("No. of Columss: "+colcount);
		}
		catch(Exception exp)
		{
			System.out.println("exception messgae is: "+exp.getMessage());
			System.out.println("exception cause is: "+exp.getCause());
			//System.out.println("exception printstack trace is: "+exp.printStackTrace());
			exp.printStackTrace();
		}
		return colcount;
	}
	
	public static String getStringCellData(int rowNum, int cellNum)
	{
		String CellData1 = null;
		try {
	
		CellData1 = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		//System.out.println(CellData1);
		}
		catch(Exception exp)
		{
			System.out.println("Exception message is: "+exp.getMessage());
			System.out.println("Exception Cause is: "+exp.getCause());
			exp.printStackTrace();
		}
		return CellData1;
	}
	
	public static void getNumericCellData(int rowNum, int cellNum)
	{
		try {

			//int celldata2= (int) sheet.getRow(1).getCell(1).getNumericCellValue();
			double celldata2= sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
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
