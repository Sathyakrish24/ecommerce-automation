package projectpom;


import automation.LoginPoM;
import automation.LogoutPom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MasterClass {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LoginPoM ol = new LoginPoM(driver);
        ol.url();
        ol.signs();
        ol.enteremail("sspoorni1@gmail.com");
        ol.enterpswd("Telephone1!");
        ol.clicksignin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {

            LogoutPom ul = new LogoutPom(driver);
            ul.Clickonprofile();
            //ul.Clickonsignout();
        } catch (Exception e) {
            System.out.println("Invalid");
        }


    }
}
