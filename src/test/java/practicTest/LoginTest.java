package practicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	@Test
	public void loginTest() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.linkedin.com/home");

		driver.findElement(By.id("session_key")).sendKeys("smitappatil@gmail.com");
		driver.findElement(By.id("session_password")).sendKeys("Aradhya18");
		driver.findElement(By.xpath("//button[@class='sign-in-form__submit-button']")).click();
		// driver.findElement(By.xpath("//button[@class='primary-action-new']")).click();
		String actualURL = driver.getCurrentUrl();
		String expecteURL = "https://www.linkedin.com/feed/";
		actualURL.contains(expecteURL);
		Assert.assertTrue(actualURL.contains(expecteURL), "Actual URL is not same as Expected URL so test case failed");

		driver.quit();
	}

}
