import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Facebook_Sikuli {
	WebDriver driver;

	@Test
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\swati\\Desktop\\Selenium\\Browser Exe files\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/");
			Screen s = new Screen();
			Pattern email = new Pattern("C:\\Users\\swati\\Desktop\\Selenium\\Sikuli Images\\FB_Email.PNG");
			Pattern password = new Pattern("C:\\Users\\swati\\Desktop\\Selenium\\Sikuli Images\\FB_Pwd.PNG");
			Pattern login = new Pattern("C:\\Users\\swati\\Desktop\\Selenium\\Sikuli Images\\FB_Login.PNG");
			s.wait(email, 5);
			s.type(email, "sweety299@gmail.com");
			s.type(password, "password");
			s.click(login);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	public static void main(String[] args) {
		Facebook_Sikuli myObj = new Facebook_Sikuli();
		myObj.invokeBrowser();

	}

}
