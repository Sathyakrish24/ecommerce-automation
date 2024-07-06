package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPom {
    WebDriver driver;

    public LogoutPom(WebDriver idriver) {
        driver = idriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "button[@class='action switch']")
    WebElement profile;
    @FindBy(linkText = "Sign Out")
    WebElement signout;


    public void Clickonprofile() {

        profile.click();
    }

    public void Clickonsignout() {

        signout.click();
    }


}
