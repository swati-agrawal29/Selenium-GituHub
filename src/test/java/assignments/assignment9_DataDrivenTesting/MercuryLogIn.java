package assignments.assignment9_DataDrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MercuryLogIn {
	WebDriver driver;
	ReadExcelData data;

	@DataProvider(name = "LC")
	public Object[][] loginCredential() {
		data = new ReadExcelData();
		Object[][] cred = data.createDataArray("C:\\Users\\swati\\Desktop\\Selenium\\TestData-Mercury.xlsx", "Data");
		return cred;

	}

	@Test(dataProvider = "LC")
	public void logIn(String userName, String pwd) {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\swati\\Desktop\\Selenium\\Browser Exe files\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://newtours.demoaut.com/");
			driver.findElement(By.name("userName")).sendKeys(userName);
			driver.findElement(By.name("password")).sendKeys(pwd);
			driver.findElement(By.name("login")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
}
