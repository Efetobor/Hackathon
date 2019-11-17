package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
	private WebDriver driver;
	public By displayDataForNextYearLink = By.xpath("//button[@id='addDataset']");
	public By ExpensesLink = By.id("showExpensesChart");
	public By canvasChart = By.xpath("//canvas[@id='canvas']");
	public By dynamicElement1 = By.xpath("//img[contains(@src, 'flashSale.gif')]");
	public By dynamicElement2 = By.xpath("//img[contains(@src, 'flashSale2.gif')]");
	public By dynamicElement3 = By.xpath("//img[contains(@src, 'flaseSale3.gif')]");
	public By amountColumn = By.xpath("//*[contains(@id, 'amount')]");
	public By amountColumnValues = By.cssSelector("tr td:nth-child(5)");
	
	public Dashboard(WebDriver driver) {
		this.driver  = driver;
	}
	
	public void validateDynamicElement1IsPresent() {
		 driver.findElement(dynamicElement1).isDisplayed();
		}

		public void validateDynamicElement3IsPresent() {
			driver.findElement(dynamicElement3).isDisplayed();
		}
		
		public void validateDynamicElement2IsPresent() {
			driver.findElement(dynamicElement2).isDisplayed();
		}
		
		public void validateChartPresent() {
			driver.findElement(canvasChart).isDisplayed();
		}
		
	public void clickOnCompareExpensesLink(){
		driver.findElement(ExpensesLink).click();
		System.out.println("compareExpensesLink Clicked");
	}
	
	public void clickOnDisplayDataForNextYearLink(){
		driver.findElement(displayDataForNextYearLink).click();
		System.out.println("showDataForNextYearLink Clicked");
	}
	
	public void clickAmountHeader() {
		driver.findElement(amountColumn).click();
		System.out.println("Amount Section Clicked");
	}
	

	
}

