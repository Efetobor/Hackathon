package baseTests;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

public class Base {
	private WebDriver driver;
	private static EyesRunner runner;
	private static Eyes eyes;
	private static BatchInfo batch;
		
	public Base(WebDriver driver) {
		this.driver  = driver;
	}
	public WebDriver initiateBrowser() throws IOException {
		Properties config = new Properties(); 
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		config.load(fis);
		String browser = config.getProperty("browser");
		if (browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		this.driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver\\geckodriver.exe");	
		this.driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriver\\IEDriverServer.exe");	
			driver = new FirefoxDriver();
		}		
		System.out.println("Browser Successfully Selected. This is Fun");
		initiateEyes();
		return driver;
	
	}

	public void initiateEyes() throws IOException {
		Properties config = new Properties(); 
		FileInputStream fileIS = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		config.load(fileIS);
		String applitoolsApiKey = config.getProperty("applitoolsApiKey");

		batch = new BatchInfo("Hackathon");
		runner = new ClassicRunner();
		eyes = new Eyes(runner);
		eyes.setApiKey(applitoolsApiKey);
		eyes.setBatch(batch);
	}
	
	public void validatePageWithEyes(String EnterTheTestNameHere) {
		eyes.open(driver, "theHackathonV2App", EnterTheTestNameHere);
		eyes.setForceFullPageScreenshot(true);
		eyes.checkWindow(EnterTheTestNameHere);
		eyes.closeAsync();
	}
	
	public void url() throws IOException {
		Properties config = new Properties(); 
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		config.load(fis);
		String baseUrl = config.getProperty("baseUrl");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();	
		System.out.println("HackathonV2App Successfully Initiated");
	}
	public void dynamicUrl() throws IOException {
		Properties config = new Properties(); 
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		config.load(fis);
		String baseUrlDynamicApp = config.getProperty("baseUrlDynamicApp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrlDynamicApp);
		driver.manage().window().maximize();	
		System.out.println("HackathonDynamicV2App Successfully Initiated");
	}
	}

