package Webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDOB {

	public static void selectDate( WebDriver driver, String mont,String yea,String d)
	{
		WebElement month= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		WebElement drp_year= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		
		Select mon= new Select(month);
		Select year= new Select (drp_year);
	
		//year.selectByContainsVisibleText("2026");
		//mon.selectByVisibleText("Jul");
		
		year.selectByContainsVisibleText(yea);
		mon.selectByVisibleText(mont);
	
		
		List <WebElement> dates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//a"));
		
		for(WebElement x: dates)
		{
			if(x.getText().equals(d))
			{
				x.click();
				//break;
			}
		}
	}
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.name("SelectedDate")).click();
		String d= "14";
		String yea= "2026";
		String mont="Jul";
		selectDate(driver,mont,yea,d);
		
		

	}

}
