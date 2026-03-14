package Webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvokeBrowser {

	public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//driver. get("https://www.w3schools.com/html/");
	
	/*
	 * driver.get(
	 * "https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php"
	 * ); //driver.navigate().to(
	 * "https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php"
	 * );
	 * 
	 * driver.manage().window().maximize();
	 * driver.findElement(By.id("email")).sendKeys("test@gmail.com");
	 * driver.findElement(By.id("password")).sendKeys("dfghjkllkjh");
	 * 
	 * driver.findElement(By.id("login")).click();
	 */
	
	driver.get("https://proleed.academy/exercises/selenium/selenium-element-name-locators-practice-form.php");
	
	driver.findElement(By.name("name")).sendKeys("fghjkl gfjs");
	driver.findElement(By.name("mobile")).sendKeys("9876483486");
	driver.findElement(By.name("email")).sendKeys("test@gmail.com");
	driver.findElement(By.name("password")).sendKeys("kjhgfgkjh");
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
	element.click();
	
	
	// Css selector locators
	/*
	 * driver.findElement(By.cssSelector(tag#id));
	 * driver.findElement(By.cssSelector(tag.classname));
	 * driver.findElement(By.cssSelector("tagname[attribute='value']"));
	 * driver.findElement(By.cssSelector("input[name^='arun']"));
	 * driver.findElement(By.cssSelector("input[name$='arun']"));
	 * driver.findElement(By.cssSelector("input[name*='arun']"));
	 * driver.findElement(By.cssSelector("input[name^='arun'][name^='arun']"));
	 */

	
	// xpath
	driver.findElement(By.xpath("//tagname[@attribute='value']"));
	driver.findElement(By.xpath("//tagname[@attribute='value and @attribute='value']"));
	driver.findElement(By.xpath("//tagname[contains(@attribute,'value')]"));
	driver.findElement(By.xpath("//tagname[text()='value']"));
	driver.findElement(By.xpath("//button[contains(text(),'Log')]"));
	driver.findElement(By.xpath("//tagname[starts_with(@attribute,'value')]"));
	
	
	
	}

}
