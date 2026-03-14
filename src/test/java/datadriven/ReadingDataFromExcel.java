package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
       FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(file); 
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		
		int r= sheet.getLastRowNum();
		XSSFRow row= sheet.getRow(1);
		int c= row.getLastCellNum();
		
		for(int i=0;i<=r;i++)
		{
			XSSFRow currentRow= sheet.getRow(i);
			for(int j=0;j<c;j++)
			{
				XSSFCell currentCell= currentRow.getCell(j);
				
				System.out.print(currentCell.toString()+"\t");
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();

	}

}
