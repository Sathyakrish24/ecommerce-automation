package automation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Createaccount {
	WebDriver driver;
	
	@BeforeSuite
	public void SetUp() throws InterruptedException{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");		
	}
	
	
	@Test(priority=0)
	public void account() throws IOException{
		WebElement accounts = driver.findElement(By.xpath("//ul[@class=\"header links\"]/child::li[3]/child::a"));
		accounts.click();
		
		String filepath="C:/Users/sspoo/Documents/personal/personal/Execlr/Selenium/selenium assignment/project data.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rows = sheet.getLastRowNum();
		System.out.println("Get number of rows" +rows);
		
		for(int i=1; i<rows;i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell firstname = row.getCell(0);
			XSSFCell lastname =row.getCell(1);
			XSSFCell email = row.getCell(2);
			XSSFCell password = row.getCell(3);
			XSSFCell confirmpassword = row.getCell(4);
			
			System.out.println("Firstname" +firstname+ "Lastname" +lastname);
			
			try {	
			
			driver.findElement(By.id("firstname")).sendKeys(firstname.toString());
			driver.findElement(By.id("lastname")).sendKeys(lastname.toString());
			driver.findElement(By.id("email_address")).sendKeys(email.toString());
			driver.findElement(By.id("password")).sendKeys(password.toString());
			driver.findElement(By.id("password-confirmation")).sendKeys(confirmpassword.toString());
			driver.findElement(By.xpath("//span[contains( text(), \"Create an Account\")]")).submit();
			}
			catch(Exception e) {
				System.out.println("Invalid data");
			}
		}
			fis.close();
			workbook.close();
	}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
	
