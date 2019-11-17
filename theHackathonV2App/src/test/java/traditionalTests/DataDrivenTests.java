package traditionalTests;

import org.testng.annotations.Test;

import baseTests.Base;
import objectRepository.LoginScreen;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DataDrivenTests {
	static WebDriver driver;

	@BeforeTest
	public void startUp() throws IOException {
		Base driverInstance = new Base(driver);
		driver = driverInstance.initiateBrowser();
	}

	@Test(priority = 1)
	public void loginWithNoUserNameNoPassword() throws IOException {
		Base launch = new Base(driver);
		launch.url();

		LoginScreen loginTest = new LoginScreen(driver);
		loginTest.clickOnLoginButton();
		loginTest.validateEmptyUsernameAndEmptyPasswordErrorMessageIsPresent();
		System.out.println("loginWithNoUserNameNoPassword Successful Test");
	}

	@Test(priority = 2)
	public void loginWithUserNameAndNoPassword() throws IOException {
		Base launch = new Base(driver);
		launch.url();

		LoginScreen loginTest = new LoginScreen(driver);
		loginTest.enterUsernameInUserNameField("usr");
		loginTest.clickOnLoginButton();
		loginTest.validatePasswordMustBePresentErrorMessageIsPresent();
		System.out.println("loginWithUserNameAndNoPassword Successful Test");
	}

	@Test(priority = 3)
	public void loginWithPasswordbutEmptyUsername() throws IOException {
		Base launch = new Base(driver);
		launch.url();

		LoginScreen loginTest = new LoginScreen(driver);
		loginTest.enterPasswordInPasswordField("pwd");
		loginTest.clickOnLoginButton();
		loginTest.validateUsernameMustBePresentErrorMessageIsPresent();
		System.out.println("loginWithPasswordbutEmptyUsername Successful Test");
	}

	@Test(priority = 4)
	public void loginSuccessfullyWithUsernameAndPassword() throws IOException {
		Base launch = new Base(driver);
		launch.url();

		LoginScreen loginTest = new LoginScreen(driver);
		loginTest.enterUsernameInUserNameField("usr");
		loginTest.enterPasswordInPasswordField("pwd");
		loginTest.clickOnLoginButton();
		loginTest.validateThatADashBoardElementIsPresent();
		System.out.println("loginSuccessfullyWithUsernameAndPassword Successful Test");
	}
	@AfterTest
	public void shutDown() {
		driver.quit();
	}

}
