package Webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverwait {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Explicitly wait
		
		WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
	WebElement Element = mywait.until(ExpectedConditions.elementToBeClickable(By.id("sdgj")));
	mywait.until(ExpectedConditions.elementToBeClickable(By.id("sdgj"))).click();
	
	WebElement ele= driver.findElement(By.id("sdgj"));
		WebElement element = mywait.until(ExpectedConditions.elementToBeClickable(ele));
		element.click();
	}

}
