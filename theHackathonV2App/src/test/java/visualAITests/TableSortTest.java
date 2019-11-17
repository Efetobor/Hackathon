package visualAITests;

import org.testng.annotations.Test;
import baseTests.Base;
import objectRepository.Dashboard;
import objectRepository.LoginScreen;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TableSortTest {
	static WebDriver driver;

	@BeforeTest
	public void startUp() throws IOException {
		Base driverInstance = new Base(driver);
		driver = driverInstance.initiateBrowser();
	}

	@Test(priority = 1)
	public void validateAmountColumnIsInAscendingOrder() throws IOException {
		Base launch = new Base(driver);
		launch.url();
		
		LoginScreen login = new LoginScreen(driver);
		login.enterUsernameInUserNameField("usr");
		login.enterPasswordInPasswordField("pwd");
		login.clickOnLoginButton();
		Base eyes = new Base(driver);
		
		eyes.validatePageWithEyes("screenShotB4SortingInAscendingOrder");
		
		Dashboard dashboard = new Dashboard(driver);
		dashboard.clickAmountHeader();
		
		eyes.validatePageWithEyes("validateAmountColumnIsInAscendingOrder");
		System.out.println("AmountColumnIsInAscendingOrder, Successful Test");
	}

	@AfterTest
	public void shutDown() {
		driver.quit();
	}

}
