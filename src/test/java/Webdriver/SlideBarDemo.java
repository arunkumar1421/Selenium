package Webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SlideBarDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement left = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		WebElement right = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		
		Actions act= new Actions(driver);
		System.out.println("left button:" + left.getLocation());
		System.out.println("right button:" + right.getLocation());
		
		act.dragAndDropBy(left, 50, 247).perform();
		act.dragAndDropBy(right, -50, 247).perform();
		
		System.out.println("left button:" + left.getLocation());
		System.out.println("right button:" + right.getLocation());
	
		

	}

}
