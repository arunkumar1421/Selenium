package Webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement name= driver.findElement(By.id("name"));
		WebElement male= driver.findElement(By.id("male"));
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		//alternate to sendKeys()
		js.executeScript("arguments[0].setAttribute('value','arun kumar')", name);
		//alternate to click()
		js.executeScript("arguments[0].click()", male);
		
		//Scrolling action
		
		//scrolling by pixels
		js.executeScript("window.scrollBy(0,1000)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scrolling into element
		Thread.sleep(1000);
		WebElement head= driver.findElement(By.xpath("//h2[text()='Pagination Web Table']"));
		
		js.executeScript("arguments[0].scrollIntoView()", head);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scrolling to end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scrolling to page intial status
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//we can page zoom out & zoom in using javascriptexecutor
		
		driver.manage().window().minimize();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(3000);
		js.executeScript("document.body.style.zoom='100%'");
		
	}

}
