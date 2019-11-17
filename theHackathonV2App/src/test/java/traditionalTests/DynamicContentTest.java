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
	
	@Test(priority = 1)
	public void validateDynamic2ndElementIsPresent() throws IOException {
		Base launch = new Base(driver);
		launch.dynamicUrl();
		
		LoginScreen loginTest = new LoginScreen(driver);
		loginTest.enterUsernameInUserNameField("usr");
		loginTest.enterPasswordInPasswordField("pwd");
		loginTest.clickOnLoginButton();
		
		Dashboard user = new Dashboard(driver);
		user.validateDynamicElement3IsPresent();
		System.out.println("Dynamic2ndElementIsPresent, Successful Test");
	}

	@AfterTest
	public void shutDown() {
		driver.quit();
	}

}
