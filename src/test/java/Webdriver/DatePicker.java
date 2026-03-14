package Webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	
	public static void SelectDate( WebDriver driver,String month,String year,String date)
	{
		while(true)
		{
			WebElement cur_mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			WebElement cur_year= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
			
			if(cur_mon.getText().equals(month)&& (cur_year.getText().equals(year)))
			{
				break;
			}
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			
		}
			List <WebElement> dates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//a"));
			
			for(WebElement x: dates)
			{
				if(x.getText().equals(date))
				{
					x.click();
				}
			}
	}
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		String month= "June";
		String year= "2026";
		String date="21";
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		SelectDate(driver,month,year,date);
		
		
			
	

	}

}
