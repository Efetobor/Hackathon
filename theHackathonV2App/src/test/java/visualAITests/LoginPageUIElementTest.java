package visualAITests;

import org.testng.annotations.Test;
import baseTests.Base;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LoginPageUIElementTest {
	static WebDriver driver;

	@BeforeTest
	public void startUp() throws IOException {
		Base driverInstance = new Base(driver);
		driver = driverInstance.initiateBrowser();
	}

	@Test(priority = 1)
	public void loginPageUIElementsValidation() throws IOException {	
		Base navigateTo = new Base(driver);
		navigateTo.url();
		Base eyes = new Base(driver);
		eyes.validatePageWithEyes("loginPageUIElementsValidation");
		System.out.println("LoginUIElements, Successful Test");
	}

	@AfterTest
	public void shutDown() {
		driver.quit();
	}

}
