package traditionalTests;

import org.testng.annotations.Test;

import baseTests.Base;

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
	public void verifyThatTheDataForNextYearAddsToChart() {
		/*
		 * Unable to distinguish between the chart elements. The test cannot be automated with this tool.
		 */
	}

	@AfterTest
	public void shutDown() {
		driver.quit();
	}

}
