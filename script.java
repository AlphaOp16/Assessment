package NexGen;
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
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/a[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/a[5]")).click();
		
}
}
