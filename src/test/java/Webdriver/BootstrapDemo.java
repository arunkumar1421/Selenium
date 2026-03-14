package Webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BootstrapDemo {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("/html[1]/body[1]/ins[2]/div[1]")).click();
		
		//List <WebElement> drop= driver.findElements(By.xpath("//div[@id='msdd']"));
		driver.findElement(By.xpath("//div[@id='msdd']")).click();
		
		List <WebElement> drop =driver.findElements(By.xpath("//li[@class='ng-scope']//a"));
		
		System.out.println(drop.getFirst().getText());
		
		System.out.println("Size: "+drop.size());
		for(WebElement x: drop)
		{
			System.out.println(x.getText());
		}
		
		/* selecting multiple options
		 * for(WebElement x: drop) { if(x.getText().equals("Bulgarian") ||
		 * (x.getText().equals("Croatian"))) { x.click(); } }
		 */
		
		 for(int i=0;i<drop.size();i++)
		   {
			 if(drop.get(i).getText().equals("Bulgarian") || (drop.get(i).getText().equals("Croatian")))
			 {
				 drop.get(i).click();
			 }
		   }
		 
		 List <WebElement> selected= driver.findElements(By.xpath("//div[@class='ui-autocomplete-multiselect-item']"));
		 
		 System.out.println("selected Size options: "+selected.size());
			for(WebElement x: selected)
			{
				System.out.println(x.getText());
			}
			
			for(WebElement x: selected)
			{
				 if(x.getText().equals("Bulgarian"))
				 {
					 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-close']")).click();
				 }
			}
			
	}

}
