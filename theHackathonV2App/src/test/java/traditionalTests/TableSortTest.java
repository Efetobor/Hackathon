package traditionalTests;

import org.testng.annotations.Test;
import baseTests.Base;
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
	public void verifyAmountColumnIsInAscendingOrder() {
		/*
		 * Unable to determine the ordering of the amount.
		 */
	}

	@AfterTest
	public void shutDown() {
		driver.quit();
	}

}
