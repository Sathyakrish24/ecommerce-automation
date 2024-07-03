package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @DataProvider(name = "shippingdetails")
    public Object[] giveDetails() {
        return new Object[][]{{"abc@gmail.com", "sathya", "poorani", "ABC Pvt Ltd", "no13 xyz street", " Dallas", "12345-6789", "9999999"}};
    }

    @Test(priority = 1, dataProvider = "shippingdetails")
    public void testCheckOut(String email, String firstName, String lastName, String company, String street, String city, String zip, String telephone) throws InterruptedException {
        selectItem();
        enterShippingDetails(email, firstName, lastName, company, street, city, zip, telephone);
        checkoutoption();
    }

    public void selectItem() throws InterruptedException {
        WebElement menoption = driver.findElement(By.id("ui-id-5"));
        menoption.click();

        WebElement pantoption = driver.findElement(By.linkText("Pants"));
        pantoption.click();

        WebElement selectpant = driver.findElement(By.linkText("Aether Gym Pant"));
        selectpant.click();

        WebElement selectsize = driver.findElement(By.id("option-label-size-143-item-177"));
        selectsize.click();

        WebElement selectcolor = driver.findElement(By.id("option-label-color-93-item-53"));
        selectcolor.click();

        WebElement addcart = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
        addcart.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        //	WebElement selectcart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='action showcart']")));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[@class='action showcart']/span[@class='counter qty']"), "1"));

        WebElement selectcart = driver.findElement(By.xpath("//a[@class='action showcart']"));
        selectcart.click();

        WebElement proceedcart = driver.findElement(By.id("top-cart-btn-checkout"));
        proceedcart.click();

    }


    public void enterShippingDetails(String email, String firstName, String lastName, String company, String street, String city, String zip, String telephone) throws InterruptedException {
        //	WebDriver wait1 = new WebDriverWait(driver,Duration.ofSeconds(30));
        //	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-email")));
        Thread.sleep(3000);
        driver.findElement(By.id("customer-email")).sendKeys(email);
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("company")).sendKeys(company);
        driver.findElement(By.name("street[0]")).sendKeys(street);
        driver.findElement(By.name("city")).sendKeys(city);
        Select statevalue = new Select(driver.findElement(By.name("region_id")));
        statevalue.selectByVisibleText("Texas");

        driver.findElement(By.name("postcode")).sendKeys(zip);
        //driver.findElement(By.name("country_id")).sendKeys(country);
        driver.findElement(By.name("telephone")).sendKeys(telephone);

        WebElement radiooption = driver.findElement(By.name("ko_unique_1"));
        radiooption.click();

        Thread.sleep(2000);
        WebElement nextbutton = driver.findElement(By.xpath("//button[@class='button action continue primary']"));
        nextbutton.click();
        Thread.sleep(2000);
    }


    public void checkoutoption() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.primary.checkout")));

        By locator = By.cssSelector("button.action.primary.checkout");
        WebElement checkout = driver.findElement(locator);
        checkout.click();
        login();

        String pagelanded = driver.getTitle();

        System.out.println("Page landed now is    " + pagelanded);

    }


}
