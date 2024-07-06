package automation;

import java.net.BindException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Forgotpassword {
	WebDriver driver;
	
	@BeforeSuite
	public void SetUp() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://magento.softwaretestingboard.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement signin = driver.findElement(By.linkText("Sign In"));
		signin.click();
		
	}
	
	
	@Test(priority=0)
	public void forgotpassword() throws InterruptedException {
		
		WebElement forgot = driver.findElement(By.xpath("//div[@class='secondary']/child::a"));
		forgot.click();
		
		String titlename = driver.getTitle();
		
		System.out.println("Page landed title is  " +titlename);
		
	}
	
	@Test(priority=1)
	public void entermailid() throws BindException {
		driver.findElement(By.id("email_address")).sendKeys("abc@gmail.com");
		
		WebElement resetbutton = driver.findElement(By.xpath("//button[@class=\"action submit primary\"]"));
		resetbutton.click();
		

		
		
	}

}
