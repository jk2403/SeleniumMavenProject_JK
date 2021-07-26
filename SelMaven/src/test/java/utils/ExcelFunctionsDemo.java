package utils;


public class ExcelFunctionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String projectpath = System.getProperty("user.dir");
		ExcelUtilsFunction excel = new ExcelUtilsFunction(projectpath+"\\excel\\data.xlsx", "sheet1");
		ExcelUtilsFunction.getRowCount();
		ExcelUtilsFunction.getStringCellData(0,0);
		ExcelUtilsFunction.getNumericCellData(1,1);
	}
}
