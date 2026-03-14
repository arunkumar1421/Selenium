package Webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List <WebElement> checkbox= driver.findElements(By.xpath("//div[@id='checkbox-example']//input"));
		List <WebElement> labels= driver.findElements(By.xpath("//div[@id='checkbox-example']//label"));
		
		/*
		 * for(WebElement x: checkbox) { x.click(); }
		 */
		
		/*
		 * for (int i= 0;i<checkbox.size();i++) { if(i==1) checkbox.get(i).click(); }
		 */
		
		/*
		 * String option= "Option2";
		 * 
		 * switch(option) { case "Option1":
		 * driver.findElement(By.xpath("//div[@id='checkbox-example']//input[0]")).click
		 * (); }
		 */
		
		
		for (int i=0; i<labels.size(); i++) 
		{ System.out.println(labels.get(i).getText());
			if (labels.get(i).getText().equals("Option2"))
			{
				
				checkbox.get(i).click();
			}
			
			// we use (==) to compare string reference of 2 variables
			// .equals() to compare string values of 2 variables
			
		}
	}

}
