package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPoM {
	
	WebDriver driver;
	
	public LoginPoM(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (linkText="Sign In") WebElement sign;
	@FindBy (id="email") WebElement email;
	@FindBy (id="pass") WebElement pswd;
	@FindBy (id="send2") WebElement signin;
	
	public void url() {
		driver.get("https://magento.softwaretestingboard.com/");
	}
	
	public void signs () {
		
		sign.click();
	}
	
	public void enteremail (String em) {
		email.sendKeys(em);
	}
	
	public void enterpswd (String pwd) {
		pswd.sendKeys(pwd);
	}
	
	public void clicksignin() {
		signin.click();
	}
	
}
