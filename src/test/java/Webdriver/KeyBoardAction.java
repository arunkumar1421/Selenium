package Webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class KeyBoardAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		WebElement name= driver.findElement(By.id("userName"));
		
		WebElement email= driver.findElement(By.id("userEmail"));
		WebElement currAddress= driver.findElement(By.id("currentAddress"));
		WebElement perAddress= driver.findElement(By.id("permanentAddress"));
		Actions act= new Actions(driver);
		
		name.sendKeys("arun kumar");
		email.sendKeys("test@gmail.com");
		currAddress.sendKeys("Navi Mumbai,loma IT park");
		Thread.sleep(1000);
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		 /* WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		 * WebElement btn= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//button[text()='Submit']"))); btn.submit();
		 */
        WebElement ele= driver.findElement(By.xpath("//button[text()='Submit']"));
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement home=driver.findElement(By.linkText("Home"));
		
		act.keyDown(Keys.CONTROL).click(home).keyUp(Keys.CONTROL).perform();
		
		

	}

}
