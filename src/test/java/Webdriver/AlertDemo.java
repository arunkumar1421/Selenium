package Webdriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.cssSelector("button[class='btn btn-danger']")).click();
		
		Alert ok= driver.switchTo().alert();
		ok.accept();
		
		// Alert with OK & Cancel
		driver.findElement(By.linkText("Alert with OK & Cancel")).click();
		driver.findElement(By.className("btn-primary")).click();
		driver.switchTo().alert().accept();
		
		//Alert with Textbox 
		
		driver.findElement(By.linkText("Alert with Textbox")).click();
		driver.findElement(By.className("btn-info")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Automation testing");
		driver.switchTo().alert().accept();
		
		
		

	}

}
