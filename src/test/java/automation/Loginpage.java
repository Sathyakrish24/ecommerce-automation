package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Loginpage {
    WebDriver driver;

//	public Loginpage(WebDriver driver) {
//		this.driver=driver;
//	}


    @BeforeSuite
    public void SetUp() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://magento.softwaretestingboard.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(2000);
        WebElement signin = driver.findElement(By.linkText("Sign In"));
        signin.click();
    }

    @DataProvider(name = "dataSet")
    public Object[][] givecredentials() {
        return new Object[][]{
                {"sspoorni1@gmail.com", "Telephone1!"}
        };
    }

    @Test(dataProvider = "dataSet")
    public void testlogin(String username, String password) throws InterruptedException {

        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("send2")).click();

    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }


}
