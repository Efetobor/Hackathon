package traditionalTests;

import org.testng.annotations.Test;
import baseTests.Base;
import objectRepository.LoginScreen;
import objectRepository.Dashboard;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public void validateAmountColumnIsInAscendingOrder() throws InterruptedException, IOException {
		Base launch = new Base(driver);
		launch.dynamicUrl();
		
		LoginScreen loginTest = new LoginScreen(driver);
		loginTest.enterUsernameInUserNameField("usr");
		loginTest.enterPasswordInPasswordField("pwd");
		loginTest.clickOnLoginButton();
		
		Dashboard user = new Dashboard(driver);
		ArrayList<Double> initialList = new ArrayList<Double>();
		java.util.List<WebElement> amountList = driver.findElements(user.amountColumnValues);
		for(int i=0; i < amountList.size(); i++) {
			String[] SplitValue = amountList.get(i).getText().split(" ");
			String addValue = String.format("%s%s", SplitValue[0], SplitValue[1]);
			double value = Double.parseDouble(addValue.replace(",", ""));
			initialList.add(value);
		}
		
		System.out.println("Initial Amount List "+ initialList);
		
		Thread.sleep(4000);
		user.clickAmountHeader();
		Thread.sleep(4000);
		
		ArrayList<Double> actualAmountList = new ArrayList<Double>();
		
		java.util.List<WebElement> orderedList = driver.findElements(user.amountColumnValues);
		for(int i=0; i < orderedList.size(); i++) {
			String[] SplitValue = orderedList.get(i).getText().split(" ");
			double value = Double.parseDouble(String.format("%s%s", SplitValue[0], SplitValue[1]).replace(",", ""));
			actualAmountList.add(value);
		}
		System.out.println("Actual Amount List "+ actualAmountList);
		
		Collections.sort(initialList);
		System.out.println("Sorted List "+ initialList);
		assertTrue(initialList.equals(actualAmountList));
		System.out.println("Amount is in acsending order");
	}

	@AfterTest
	public void shutDown() {
		driver.quit();
	}

}
