package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Searchbar {
	
	WebDriver driver;
	
	@BeforeSuite
	
	public void SetUp() throws InterruptedException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);
		}

	@DataProvider (name="datavalues")
	public Object[] searchitems(){
		return new Object[]{"jacket", "shoes", "equipment"};
	}
	
	@Test(dataProvider ="datavalues")
	
	public void search(String values) throws InterruptedException
	{
		if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }

        WebElement searchField = driver.findElement(By.id("search"));
	    searchField.sendKeys(values);
		
	    Thread.sleep(2000);
	
	Actions act = new Actions(driver);
    act.sendKeys(Keys.ENTER);
        
        
        // Clear search field for next input
        searchField.clear();
	
}}
