package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;




/*1) TestNG execute test methods based on alphabetical order.
2) @Test(priority=num)  controls the order of execution.
3) Once you provide priorty to the test methods, then order of methods is not considered.
4) priorities can be random numbers( no need to have consecutive numbers)
5) If you dont provide priority then default value is Zero (0).
6) If the priorities are same then again execute methods in alphabetical order.
7) Negitive values are allowed in priority.
8)  TestNG execute test methods only if they are having @Test annotation.*/

public class LoginTestDemo {
	WebDriver driver;
	Properties prop= new Properties();
	
	FileInputStream file;
	
     @Test
	void openApp() throws IOException
	{
		Properties prop= new Properties();
	    file= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		prop.load(file);
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	
	@Test
	void login()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if(driver.getTitle().equals("OrangHRM"))
		{
			System.out.println(" Test case passed \n" + "page title: " +driver.getTitle());
		}
		
	}

}
