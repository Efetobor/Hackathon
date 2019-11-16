package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen {
	private WebDriver driver;
	public By usernameField = By.id("username");
	public By passwordField = By.id("password");
	public By loginButton = By.id("log-in");
	public By loginButtonLabel = By.xpath("//*[contains(@id,'log-in') and contains(text(), 'Log In')]");
	public By emptyUsernameAndEmptyPasswordErrorMessage = By.xpath("//*[contains(@class, 'alert alert-warning') and contains(text(),'Both Username and Password must be present')]");
	public By passwordMustBePresentErrorMessage = By.xpath("//*[contains(@class, 'alert alert-warning') and contains(text(),'Password must be present')]");
	public By usernameMustBePresentErrorMessage = By.xpath("//*[contains(@class, 'alert alert-warning') and contains(text(),'Username must be present')]");
	public By dashboardElement = By.xpath("//div[@class='logged-user-w']//div[@class='avatar-w']");
	public By usernameLabel = By.xpath("//label[contains(text(),'Username')]");
	public By passwordLabel = By.xpath("//label[contains(text(),'Password')]");
	public By usernamePlaceholderText = By.xpath("//*[contains(@id, 'username') and contains(@placeholder,'Enter your username')]");
	public By passwordPlaceholderText = By.xpath("//*[contains(@id, 'password') and contains(@placeholder,'Enter your password')]");
	public By checkbox = By.xpath("//input[@class='form-check-input']");
	public By rememberMeText = By.xpath("//label[@class='form-check-label']");
	public By twitterIcon = By.xpath("//form//a[1]//img[1]");
	public By facebookIcon = By.xpath("//a[2]//img[1]");
	public By linkedInIcon = By.xpath("//a[3]//img[1]");
	public By pageTitle = By.xpath("//h4[@class='auth-header']");
	public By pageLogo = By.xpath("//div[@class='logo-w']//a//img");
	

	public LoginScreen(WebDriver driver) {
		this.driver  = driver;
	}

	public void validateThatADashBoardElementIsPresent() {
		driver.findElement(dashboardElement).isDisplayed();
	}
	
	public void validateUsernameMustBePresentErrorMessageIsPresent() {
		driver.findElement(usernameMustBePresentErrorMessage).isDisplayed();
	}
	
	public void validatePasswordMustBePresentErrorMessageIsPresent() {
		driver.findElement(passwordMustBePresentErrorMessage).isDisplayed();
	}
	
	public void enterUsernameInUserNameField(String text) {
		driver.findElement(usernameField).sendKeys(text);
		System.out.println("username Successfully Entered");
	}
	
	public void enterPasswordInPasswordField(String text) {
		driver.findElement(passwordField).sendKeys(text);
		System.out.println("password Successfully Entered");
	}
	
	public void validatePasswordFieldIsPresent() {
		driver.findElement(passwordField).isDisplayed();
	}
	
	public void validateUsernameFieldIsPresent() {
		driver.findElement(usernameField).isDisplayed();
	}
	
	public void validateEmptyUsernameAndEmptyPasswordErrorMessageIsPresent() {
		driver.findElement(emptyUsernameAndEmptyPasswordErrorMessage).isDisplayed();
	}
	
	public void validateLoginButtonTextIsPresent(){
		driver.findElement(loginButtonLabel).isDisplayed();
	}
	
	public void clickOnLoginButton(){
		driver.findElement(loginButton).click();
		System.out.println("loginButton Clicked");
	}
	
	public void validateUsernameLabelIsPresent() {
			driver.findElement(usernameLabel).isDisplayed();
		}
	
	public void validatePasswordLabelIsPresent() {
			driver.findElement(passwordLabel).isDisplayed();
	}
	
	public void validateUsernamePlaceholderTextIsPresent() {
			driver.findElement(usernamePlaceholderText).isDisplayed();
	}
	
	public void validatePasswordPlaceholderTextIsPresent() {
			driver.findElement(passwordPlaceholderText).isDisplayed();
	}
	
	public void validateCheckBoxIsPresent() {
			driver.findElement(checkbox).isDisplayed();
	}
	
	public void validateCheckBoxIsCheckable() {
		driver.findElement(checkbox).click();
		System.out.println("Checkbox clicked");
		}
	
	public void validateRememberMeTextIsPresent() {
			driver.findElement(rememberMeText).isDisplayed();
	}
	
	public void validateTwitterIconIsPresent() {
			driver.findElement(twitterIcon).isDisplayed();
	}
	
	public void validateFacebookIconIsPresent() {
			driver.findElement(facebookIcon).isDisplayed();
	}
	
	
	public void validatePageTitleIsPresent() {
			driver.findElement(pageTitle).isDisplayed();
	}
	
	public void validatePageLogoIsPresent() {
			driver.findElement(pageLogo).isDisplayed();
}
}

