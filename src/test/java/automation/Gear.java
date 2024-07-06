package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Gear {
	 WebDriver driver;
    private Loginpage loginPage;
	
	@BeforeSuite
	
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");

	}
	
	@Test(priority =0)
	
	public void gearoption() {
		
		
		WebElement selectgear = driver.findElement(By.id("ui-id-6"));
		selectgear.click();
		
		WebElement fitness = driver.findElement(By.partialLinkText("Fitness Equipment"));
		fitness.click();
		
		WebElement gridview = driver.findElement(By.id("mode-list"));
		gridview.click();
		
		String title = driver.getTitle();
		System.out.println("Title " +title);
		
	}
	
	@Test(priority =1)
	
	public void sortby() {
		WebElement sortdropdown = driver.findElement(By.id("sorter"));
		Select sort = new Select(sortdropdown);
		sort.selectByVisibleText("Price");
	}
	
	@Test(priority =2)
	public void wishlist() {
		WebElement addwish = driver.findElement(By.cssSelector("a.action.towishlist"));
		addwish.click();
}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
