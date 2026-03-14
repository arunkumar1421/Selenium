package datadriven;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatadrivenTesting {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//Web Application
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		WebElement princi = driver.findElement(By.xpath("//input[@id='principal']"));
		WebElement rateOI= driver.findElement(By.xpath("//input[@id='interest']"));
		WebElement tenure= driver.findElement(By.xpath("//input[@id='tenure']"));
		Select drperiod= new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
		Select frqdrp= new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
		WebElement calculate= driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));
		
		//excel file
		String file= System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		int r=ExcelUtils.getRowCount(file, "Sheet1");
		
		for(int i=1;i<=r;i++)
		{
			//extract data from excel
			String principle= ExcelUtils.getCellData(file, "Sheet1", i, 0);
			String roi= ExcelUtils.getCellData(file, "Sheet1", i, 1);
			String period= ExcelUtils.getCellData(file, "Sheet1", i, 2);
			String period_type= ExcelUtils.getCellData(file, "Sheet1", i, 3);
			String frequency= ExcelUtils.getCellData(file, "Sheet1", i, 4);
			String matur_value= ExcelUtils.getCellData(file, "Sheet1", i, 5);
			
			//pass data to elements
			princi.sendKeys(principle);
			rateOI.sendKeys(roi);
			tenure.sendKeys(period);
			drperiod.selectByVisibleText(period_type);
			frqdrp.selectByVisibleText(frequency);
		//	WebElement no= driver.findElement(By.xpath("//button[@class='No thanks']"));
		/*
		 * if(driver.findElement(By.xpath("//button[@class='No thanks']")).isDisplayed()
		 * ) { driver.findElement(By.xpath("//button[@class='No thanks']")).click(); }
		 */
			calculate.click();
			
			Thread.sleep(3000);
			//driver.switchTo().alert().accept();
		  String actualvalue=driver.findElement(By.xpath("//span[@class='gL_27']//strong")).getText();
		//validate results
		 if(Double.parseDouble(matur_value)==(Double.parseDouble(actualvalue)))
			{
			  System.out.println("Test case passed..");
				ExcelUtils.setCellData(file, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(file, "Sheet1", i, 7);
			}
		  else
		  {
			  System.out.println("Test case failed..");
			  ExcelUtils.setCellData(file, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(file, "Sheet1", i, 7);
		  }
			
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			
			
		}
	}

}
