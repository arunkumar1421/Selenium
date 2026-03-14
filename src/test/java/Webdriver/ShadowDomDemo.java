package Webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		// xpath don't work to locate shadow dom elements use only cssSsselector 
		
		//Shadow element 1
		SearchContext shadow=driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		String shadowelement=shadow.findElement(By.cssSelector("#shadow-element")).getText();
		System.out.println(shadowelement);
		
		// inner Shadow element
		SearchContext root1=shadow.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		String nested_element = root1.findElement(By.cssSelector("#nested-shadow-element")).getText();
		System.out.println(nested_element);
		
		// nested Shadow element 3
		
		 SearchContext root2=root1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		 Thread.sleep(1000);
		String nested_element2 = root2.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
		System.out.println(nested_element2);

	}

}
