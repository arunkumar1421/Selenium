package Webdriver;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Get methods of web driver
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/*String title= driver.getTitle();
		String url=driver.getCurrentUrl();
		String pagesrc=driver.getPageSource();
		String Parentwindow= driver.getWindowHandle();
		
		Set <String> windowhandles =driver.getWindowHandles();
		System.out.println("title of the page: "+ title);
		System.out.println("Current url of the page: "+ url);
		System.out.println("source code of the page: "+ pagesrc);
		System.out.println("Id of parent window: "+Parentwindow);
		System.out.println("Ids of all windows: "+ windowhandles);
		*/
	//	driver.findElement(By.id("opentab")).click();
		
	
		//Conditional Methods
		
	/*	WebElement logo= driver.findElement(By.className("logoClass"));
		boolean logo_status= logo.isDisplayed();
		System.out.println("logo displayed: "+ logo_status);
		
		boolean radio1= driver.findElement(By.xpath("//input[@value='radio1']")).isEnabled();
		System.out.println("radio1 is enabled: "+ radio1);
		
		WebElement radio= driver.findElement(By.cssSelector("input[value='radio2']"));
		boolean radiostatus= radio.isSelected();
		System.out.println("radio is selected: "+ radiostatus);*/
		
		//Browser methods
		//driver.close(); // used to close current window or parent window which was open by selenium
		//driver.quit(); // used to close all the browser windows opened by the selenium 
		
		//Navigation methods
		
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Home']")).click();
		
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		driver.quit();
		

	}

}
