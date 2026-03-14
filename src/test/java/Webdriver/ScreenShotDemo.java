package Webdriver;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotDemo {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// full page screen shot
		/*
		 * TakesScreenshot ts= (TakesScreenshot)driver; File
		 * sourcefile=ts.getScreenshotAs(OutputType.FILE); File targetfile= new
		 * File(System.getProperty("user.dir")+"\\Schreenshots\\fullpage.png");
		 * sourcefile.renameTo(targetfile);
		 */
        
        
        // specific section of webpage by using same method from web element
        
		/*
		 * WebElement ele= driver.findElement(By.xpath("//div[@id='HTML1']")); File
		 * srcfile=ele.getScreenshotAs(OutputType.FILE); File trgfile= new
		 * File(System.getProperty("user.dir")+"\\Schreenshots\\section.png");
		 * srcfile.renameTo(trgfile);
		 */
		
		// specific web element 
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.pavanonlinetrainings.com/p/udemy-courses.html");
		WebElement ele = driver.findElement(By.xpath("//div[@id='header-inner']"));
		
		File srcphoto= ele.getScreenshotAs(OutputType.FILE);
		File trgphoto = new File(System.getProperty("user.dir")+"\\Screenshots\\header.png");
		srcphoto.renameTo(trgphoto);
	}

}
