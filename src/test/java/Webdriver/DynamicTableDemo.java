package Webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableDemo {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com/TlbeVW/");
		WebElement name= driver.findElement(By.name("username"));
		name.clear();
		name.sendKeys("demo");
		WebElement pass= driver.findElement(By.name("password"));
		pass.clear();
		pass.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		

	}

}
