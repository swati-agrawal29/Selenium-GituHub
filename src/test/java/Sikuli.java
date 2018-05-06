import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Sikuli {
	WebDriver driver;

	@Test
	public void invokeBrowser() throws InterruptedException {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\swati\\Desktop\\Selenium\\Browser Exe files\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://www.amazon.com/");
			Screen s = new Screen();
			Pattern signin = new Pattern("C:\\Users\\swati\\Desktop\\Selenium\\Sikuli Images\\Amazon_Sign_in.PNG");
			s.wait(signin, 5);
			s.click(signin);
			// s.getScreen().click("C:\\Users\\swati\\Desktop\\Selenium\\Sikuli
			// Images\\Amazon_Sign_in.PNG");
			Thread.sleep(4000);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Sikuli myObj = new Sikuli();
		myObj.invokeBrowser();

	}
}
