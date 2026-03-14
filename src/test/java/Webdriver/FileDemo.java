package Webdriver;

/*// Selenium don't recommend automating file uploading and downloading because while uploadingit trigers desktop application for file storage to select open file
to upload that we can't automate with selenium but we can automate still using sendKeys method
*/
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDemo {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//uploading single file
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Arun\\example.txt");
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("example.txt"))
		{
			System.out.println("File uploaded successfully");
		}
		else
		{
			System.out.println("Uploading failed");
		}
		/*
		 * //uploading multiple files String file1="C:\\Arun\\example.txt"; String
		 * file2="C:\\Arun\\doc.txt";
		 * driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+
		 * "\n"+file2); List <WebElement>
		 * files=driver.findElements(By.xpath("//ul[@id='fileList']//li"));
		 * 
		 * System.out.println("Uploaded files...."); for(WebElement x: files) {
		 * System.out.println(x.getText()); }
		 */
		

	}

}
