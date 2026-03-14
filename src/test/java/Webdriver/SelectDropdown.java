package Webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		
		Select drp= new Select(dropdown);
		
		drp.selectByVisibleText("Option2");
		/*
		 * drp.selectByContainsVisibleText("Option1"); 
		 * drp.selectByIndex(2); drp.deselectByValue("Option3");
		 */
		
		List <WebElement> ele= drp.getOptions();
		for(WebElement x: ele)
		{
			System.out.println(x.getText());
		}
		
		
		

	}

}
