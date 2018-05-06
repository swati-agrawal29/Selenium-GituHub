
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Amazon {
	WebDriver driver;

	@Test
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\swati\\Desktop\\Selenium\\Browser Exe files\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("https://amazon.in");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	public static void main(String[] args) {
		Amazon myObj = new Amazon();
		myObj.invokeBrowser();

	}

}
