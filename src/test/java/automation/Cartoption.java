package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Cartoption {
	
	WebDriver driver;
	
	@BeforeSuite
	public void SetUp() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://magento.softwaretestingboard.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test(priority=0)
	
	public void yoga() {
		WebElement yogabutton = driver.findElement(By.xpath("//span[contains(text(),'Shop New Yoga')]"));
		yogabutton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		

	}
	
	@Test(priority=1)
	public void fetchlink() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for (int i=0;i<links.size();i++) {
			String linkName = links.get(i).getText();
			String url = links.get(i).getAttribute("href");
			System.out.println((i+1)+ "." + linkName+ "----->" +url+ "abc");
			
		}
	}
	
	
	
	@Test(priority=2)
		public void dress() throws InterruptedException {
			WebElement selectdress =driver.findElement(By.linkText("Gwen Drawstring Bike Short"));
			selectdress.click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			WebElement selectsize = driver.findElement(By.xpath("//div[@option-label='28']"));
			selectsize.click();
			WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
			
			
			WebElement selectcolor = driver.findElement(By.xpath("//div[@option-label='Orange']"));
			selectcolor.click();			
			WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
			
			WebElement quantity = driver.findElement(By.id("qty"));
			quantity.clear();
			quantity.sendKeys("2");
			
			WebElement addcart = driver.findElement(By.id("product-addtocart-button"));
			addcart.submit();	
			
			Thread.sleep(6000);
			
			System.out.println("items added successfully to the cart");
			
		}
@Test (priority=3)
	public void checkcart() {
	
		WebElement cart = driver.findElement(By.cssSelector("a.action.showcart"));
		cart.click();
		System.out.println("click cart successfull");
		
		
	}

@Test (priority = 4)
public void removecart() throws InterruptedException {
	WebElement remcart = driver.findElement(By.cssSelector("a.action.delete"));
	remcart.click();
	Thread.sleep(2000);
	
	WebElement accept =driver.findElement(By.cssSelector("button.action-primary.action-accept"));
	accept.click();
	
	
}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
	
	}
	
	
	


