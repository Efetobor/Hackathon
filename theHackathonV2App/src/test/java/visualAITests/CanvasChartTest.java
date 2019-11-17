package visualAITests;

import org.testng.annotations.Test;

import baseTests.Base;
import objectRepository.Dashboard;
import objectRepository.LoginScreen;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CanvasChartTest {
	static WebDriver driver = null;

	@BeforeTest
	public void startUp() throws IOException {
		Base driverInstance = new Base(driver);
		driver = driverInstance.initiateBrowser();
	}

	@Test(priority = 1)
	public void validateThatTheDataForNextYearAddsToChart() throws IOException {
		Base launch = new Base(driver);
		launch.url();

		LoginScreen login = new LoginScreen(driver);
		login.enterUsernameInUserNameField("usr");
		login.enterPasswordInPasswordField("pwd");
		login.clickOnLoginButton();
		
		Dashboard user = new Dashboard(driver);
		user.clickOnCompareExpensesLink();
		
		Base eyes = new Base(driver);
		eyes.validatePageWithEyes("screenShotBeforeAddingDataForNextYear");
		user.clickOnDisplayDataForNextYearLink();
		eyes.validatePageWithEyes("screenShotAfterAddingTheDataForNextYear");
		
		System.out.println("ThatTheDataForNextYearAddsToChart, Successful Test");
	}

	@AfterTest
	public void shutDown() {
		driver.quit();
	}

}
