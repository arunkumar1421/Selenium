package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUsingProperties {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Properties prop= new Properties();
		
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		prop.load(file);
		driver.get(prop.getProperty("url"));
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("URL: "+driver.getCurrentUrl()+"\n"+ "page title: " +driver.getTitle());
		
		driver.quit();
		
	}

}
