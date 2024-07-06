package automation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.io.FileHandler;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Mendropdown {
    WebDriver driver;

    @BeforeSuite

    public void SetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @Test(priority = 0)
    public void men() throws InterruptedException {
        WebElement selectmen = driver.findElement(By.id("ui-id-5"));
        selectmen.click();

        WebElement selectoption = driver.findElement(By.xpath("//div[@class='categories-menu']/child::ul/child::li[2]/child::a[contains(text(),'Jackets')]"));
        selectoption.click();

        WebElement saleoption = driver.findElement(By.xpath("//div[@class='filter-options-title' and contains(text(),'Sale')]"));
        saleoption.click();

        WebElement yesoption = driver.findElement(By.partialLinkText("Yes"));
        yesoption.click();

        Thread.sleep(2000);

    }

    @Test(priority = 1)
    public void keyboardshortcut() throws InterruptedException {

        driver.navigate().back();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.navigate().forward();
        Thread.sleep(1000);
        driver.navigate().refresh();

    }

    @Test(priority = 2)
    public void screenshot() {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File desc = new File("C:\\Users\\sspoo\\Pictures\\Saved Pictures\\image2.jpeg");
            FileHandler.copy(src, desc);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @AfterSuite
    public void closeBrowser() {

        driver.quit();
    }

}
