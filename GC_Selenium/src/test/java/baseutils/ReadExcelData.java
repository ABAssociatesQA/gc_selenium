package baseutils;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	
	
	public String[][] readExcel() {

		FileInputStream fis=null;
		Workbook workbook=null;
		
		try {
			fis=new FileInputStream("../GC_Selenium/ExcelFiles/Sample.xlsx");
			workbook=new XSSFWorkbook(fis);
		}catch(Exception e ) {
			System.out.println("File not found");
		}
		
		
		Sheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		Cell cell=row.getCell(0);
		
		System.out.println(cell.getStringCellValue());
		
		int lastRowNum=sheet.getLastRowNum();
		int lastCellNum=sheet.getRow(lastRowNum).getLastCellNum();
		System.out.println(lastRowNum); //0,1
		System.out.println(lastCellNum);//1---(0)
		
		String[][] arr=new String[lastRowNum][lastCellNum];
		
		for(int i=1;i<=lastRowNum;i++) {
			for(int j=0;j<lastCellNum;j++) {
				arr[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(arr[i][j]);
			}
		}
		
		System.out.println(Arrays.asList(arr));
		return arr;
	
	}
	
	public static void main(String[] args) {}

}
