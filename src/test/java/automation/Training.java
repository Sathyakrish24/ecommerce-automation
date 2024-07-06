
package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Training extends Gear {

    @Test(priority = 0)

    public void trainingoption() {
        WebElement selecttraining = driver.findElement(By.id("ui-id-7"));
        selecttraining.click();
    }

    @AfterSuite
    public void closeBrowser() {

        driver.quit();
    }
}
