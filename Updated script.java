package NexGen;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assessment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
// Navigate to a website
		driver.get("https://thesportstak.com/");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println("No of links are" +  links.size());
		
		List<String>urlList = new ArrayList<String>();

		
		for(WebElement e : links){
		    String url = e.getAttribute("href");
		    urlList.add(url);
		}

		Long stTime= System.currentTimeMillis();
		urlList.parallelStream().forEach(e->checkBrokenLink(e));
		Long endTime=System.currentTimeMillis();
		System.out.println("total time taken:" +(endTime - stTime));
		
		
//Maximize current window
		driver.manage().window().maximize();

//Delay execution for 3 seconds to view the maximize operation 
		Thread.sleep(3000);
		 
//Click on the menu button 
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/header/div/button/span[1]")).click();
//Change the Language to English to Hindi		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div[2]/div[2]/div/button/span[1]/a")).click();
		Thread.sleep(3000);
		
//Click on the menu button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/header/div/button/span[1]")).click();
		
		driver.navigate().to("https://thesportstak.com/");	
		Thread.sleep(3000);
		//Click on the Buzz 
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/a[2]")).click();
		Thread.sleep(3000);
		//Click on the Webstory
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/a[5]")).click();
		Thread.sleep(5000);
		driver.navigate().to("https://thesportstak.com/");
		Thread.sleep(5000);
		driver.quit();
	}		
		

public static void checkBrokenLink(String linkUrl) {
    try{
        URL url=new URL(linkUrl);
        HttpURLConnection httpUrlConnection=(HttpURLConnection)url.openConnection();
        httpUrlConnection.setConnectTimeout(5000);
        httpUrlConnection.connect();
        if(httpUrlConnection.getResponseCode()  >=400){
            System.out.println(linkUrl+"--->" +httpUrlConnection.getResponseMessage()+"is a broken link");
        
        }
        else{
        	 System.out.println(linkUrl+"--->"+httpUrlConnection.getResponseMessage());
        }
  
    }
    catch(Exception e){
    } 

}
	}
                                           
                                                  
           
