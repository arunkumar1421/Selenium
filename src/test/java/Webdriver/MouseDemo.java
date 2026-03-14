package Webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Actions act= new Actions(driver);
		/*
		 * WebElement pointMe=
		 * driver.findElement(By.xpath("//button[text()='Point Me']"));
		 * 
		 * WebElement mobiles=
		 * driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
		 * 
		 * //Mouse hovering action using moveToElement() method
		 * act.scrollToElement(pointMe); Thread.sleep(3000);
		 * //act.moveToElement(pointMe).moveToElement(mobiles).click().build().perform()
		 * ;
		 */		
		/*
		 * WebElement doubleClick=
		 * driver.findElement(By.xpath("//button[text()='Copy Text']"));
		 * 
		 * act.doubleClick(doubleClick).build().perform(); WebElement ele=
		 * driver.findElement(By.xpath("//input[@id='field2']")); String
		 * text=ele.getAttribute("value"); System.out.println(text); driver.quit();
		 */
		
		//Drag and Drop by
		
		WebElement srcEle= driver.findElement(By.id("draggable"));
		
		WebElement tarELe = driver.findElement(By.id("droppable"));
		//act.dragAndDrop(srcEle, tarELe).build().perform();
		act.clickAndHold(srcEle).moveToElement(tarELe).release().perform();
		
	
		 String s=driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		 
		  if(s.equals("Dropped!")) 
		  { 
			  System.out.println("Dropped!");
		  }
		

	}

}
