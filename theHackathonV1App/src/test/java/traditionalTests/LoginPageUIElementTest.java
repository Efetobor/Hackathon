package traditionalTests;

import org.testng.annotations.Test;

import baseTests.Base;
import objectRepository.LoginScreen;
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
		Base launch = new Base(driver);
		launch.url();

		LoginScreen loginTest = new LoginScreen(driver);
		loginTest.validatePageLogoIsPresent();
		loginTest.validatePageTitleIsPresent();
		loginTest.validateUsernameFieldIsPresent();
		loginTest.validateUsernameLabelIsPresent();
		loginTest.validateUsernamePlaceholderTextIsPresent();
		loginTest.validatePasswordFieldIsPresent();
		loginTest.validatePasswordLabelIsPresent();
		loginTest.validatePasswordPlaceholderTextIsPresent();
		loginTest.validateLoginButtonTextIsPresent();
		loginTest.validateCheckBoxIsPresent();
		loginTest.validateCheckBoxIsCheckable();
		loginTest.validateRememberMeTextIsPresent();
		loginTest.validateTwitterIconIsPresent();
		loginTest.validateFacebookIconIsPresent();
		
		System.out.println("LoginUIElements, Successful Test");
	}

	@AfterTest
	public void shutDown() {
		driver.quit();
	}

}
