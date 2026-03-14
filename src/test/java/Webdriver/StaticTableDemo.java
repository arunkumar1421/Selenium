package Webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTableDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> rows= driver.findElements(By.xpath("//table[@class='table-display']//tr"));
		
		List<WebElement> colums= driver.findElements(By.xpath("//table[@class='table-display']//th"));
		
		int r= rows.size();
		int c= colums.size();
		
		for(int i=2;i<=r;i++)
		{
			for(int j=1;j<=c;j++)
			{
				System.out.print(driver.findElement(By.xpath("//table[@class='table-display']//tr["+i+"]//td["+j+"]")).getText()+"  ");
			}
			System.out.println();
		}
		
	}
}
