package datadriven;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDatatoExcel {

	public static void main(String[] args) throws IOException {
		
		Scanner sc= new Scanner(System.in);
		
		FileOutputStream file= new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile1.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet= workbook.createSheet("data");
		
		System.out.println("enter no.of rows and columns: ");
		int r= sc.nextInt();
		int c= sc.nextInt();
		
		for(int i=0;i<=r;i++)
		{
			XSSFRow row= sheet.createRow(i);
			
			for(int j=0;j<c;j++)
			{
				XSSFCell cell= row.createCell(j);
				System.out.println("cell value: ");
				cell.setCellValue(sc.next());
				
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is Created.....");

	}

}
