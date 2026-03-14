package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {

	public static void main(String[] args) throws IOException {
		
		  WebDriver driver= new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.manage().window().maximize();
		 
		
		
		 driver.get("https://www.facebook.com/");
		 
		 WebElement username= driver.findElement(By.xpath("//input[@id='email']"));
		 
		 WebElement password=
		 driver.findElement(By.xpath("//input[@type='password']"));
		  
		 WebElement login= driver.findElement(By.xpath("//button[@name='login']"));
		 
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\testdata\\myfile1.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(file); 
		XSSFSheet sheet= workbook.getSheet("data");
		
		int r= sheet.getLastRowNum();
		XSSFRow row= sheet.getRow(1);
		int c= row.getLastCellNum();
		
		for(int i=0;i<=r;i++)
		{
			if(i==1)
			{
				break;
			}
			XSSFRow currentRow= sheet.getRow(i);
			for(int j=0;j<c;j++)
			{
				XSSFCell currentCell= currentRow.getCell(j);
				if(j==0) {
				username.sendKeys(currentCell.toString());
				}
				else
					password.sendKeys(currentCell.toString());
				
			}
			login.click();
			
			
		}
		
		workbook.close();
		file.close();
		
		//int c= sheet.getLastColNum(); this will get from row, not directly from sheet variable
		
		
	}

}
