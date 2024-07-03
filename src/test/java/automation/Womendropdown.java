package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Womendropdown {
	WebDriver driver;
	
	@BeforeSuite
	
	public void SetUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://magento.softwaretestingboard.com/");
		
		
	}
	
	@Test(priority=0)
	public void dropdown() throws InterruptedException{
		 
		 List<WebElement> options = driver.findElements(By.cssSelector("a.level-top.ui-corner-all"));
		 
		 for (WebElement option : options) {
	            System.out.println("Dropdown value: " + option.getText());
	        }
		
	}
	
	@Test(priority=1)
		public void dress() throws InterruptedException{
		
		WebElement women = driver.findElement(By.xpath("//a[@id=\"ui-id-4\"]"));
		women.click();
		Thread.sleep(2000);
		
		WebElement jacket = driver.findElement(By.xpath("//div[@class=\"categories-menu\"]/child::ul/child::li[2]/child::a[contains(text(),'Jackets')]"));
		jacket.click();
		
		WebElement firstImage = driver.findElement(By.cssSelector(".product-image-photo"));
        firstImage.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        }
	


}
	


