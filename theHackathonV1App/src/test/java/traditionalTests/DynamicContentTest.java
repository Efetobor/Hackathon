package traditionalTests;

import org.testng.annotations.Test;

import baseTests.Base;
import objectRepository.Dashboard;
import objectRepository.LoginScreen;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DynamicContentTest {
	static WebDriver driver;

	@BeforeTest
	public void startUp() throws IOException {
		Base driverInstance = new Base(driver);
		driver = driverInstance.initiateBrowser();
	}
	
	@Test(priority = 2)
	public void validateDynamic2ndElementIsPresent() throws IOException {
		Base launch = new Base(driver);
		launch.dynamicUrl();
		
		LoginScreen loginTest = new LoginScreen(driver);
		loginTest.enterUsernameInUserNameField("usr");
		loginTest.enterPasswordInPasswordField("pwd");
		loginTest.clickOnLoginButton();
		
		Dashboard user = new Dashboard(driver);
		user.validateDynamicElement2IsPresent();
		System.out.println("Dynamic2ndElementIsPresent, Successful Test");
	}

	@Test(priority = 1)
	public void validateDynamic1stElementIsPresent() throws IOException {
		Base launch = new Base(driver);
		launch.dynamicUrl();
		
		LoginScreen loginTest = new LoginScreen(driver);
		loginTest.enterUsernameInUserNameField("usr");
		loginTest.enterPasswordInPasswordField("pwd");
		loginTest.clickOnLoginButton();
		
		Dashboard user = new Dashboard(driver);
		user.validateDynamicElement1IsPresent();
		System.out.println("verifyFlashSale1stElementIsPresent, Test Passed");
	}
	@AfterTest
	public void shutDown() {
		driver.quit();
	}

}
