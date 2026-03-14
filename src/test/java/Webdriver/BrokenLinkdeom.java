package Webdriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*1. get the href value
2. convert into URL and open connection
3. compare status code>=400 ====>broken link
4. staus code<400 ====>not abroken link*/

public class BrokenLinkdeom {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		int brokenLinks=0;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		System.out.println("Total no.of.links: " +links.size());
		
		for(WebElement x: links)
		{
			String hrefvalue= x.getAttribute("href");
			
			if(hrefvalue==null || hrefvalue.isEmpty())
			{
				System.out.println("There is no href value present. So not possible to check link");
				continue;
			}
			//System.out.println("links: " +hrefvalue);
			
			try {
		       URL linkURL=	new URL(hrefvalue);
		       HttpURLConnection conn= (HttpURLConnection) linkURL.openConnection();
		       conn.connect();
		       
		       if(conn.getResponseCode()>=400)
		       {
		    	   System.out.println(hrefvalue+" ====>Broken link");
		    	   brokenLinks++;
		       }
		       else
		       {
		    	   System.out.println(hrefvalue+" ====> Not a broken link");
		       
		       }
			}catch(Exception e)
			{
				
			}
		}
		System.out.println("No.of broken Links: "+ brokenLinks);
		
		
		
		

	}

}
