package Webdriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List <WebElement> radio=driver.findElements(By.xpath("//div [@id='radio-btn-example']//input"));
		List <WebElement> labels=driver.findElements(By.xpath("//div [@id='radio-btn-example']//label"));
		
		/*
		 * Iterator it= radio.iterator();
		 * 
		 * while(it.hasNext()) { WebElement ele= (WebElement) it.next(); ele.click(); }
		 * 
		 * for(int i=0;i<radio.size();i++) { if(i==1) radio.get(i).click(); }
		 */
		
		String label="Radio1";
		
		switch(label)
		{
		
		case "Radio1": driver.findElement(By.xpath("//input[@value='radio1']")).click();
		        break;
		case "Radio2": driver.findElement(By.xpath("//input[@value='radio1']")).click();
                break;
		case "Radio3": driver.findElement(By.xpath("//input[@value='radio1']")).click();
                break;
		default : System.out.println("No radio button is available");
		}
		
	}

}
