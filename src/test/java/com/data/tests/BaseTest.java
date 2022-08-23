package com.data.tests;

import com.context.Constants;
import com.context.WebDriverContext;
import com.listeners.ListenerForTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Every test class should extend this calss.
 */
@Listeners({ ListenerForTest.class })
public class BaseTest {

	/** The driver. */
	protected WebDriver driver;

	/**
	 * Global setup.
	 */
	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		System.out.println("************************** Test Execution Started ************************************");
	}

	/**
	 * Wrap all up.
	 *
	 * @param context the context
	 */
	@AfterSuite(alwaysRun = true)
	public void wrapAllUp(ITestContext context) {
		int total = context.getAllTestMethods().length;
		int passed = context.getPassedTests().size();
		int failed = context.getFailedTests().size();
		int skipped = context.getSkippedTests().size();
		System.out.println("Total number of testcases : " + total);
		System.out.println("Number of testcases Passed : " + passed);
		System.out.println("Number of testcases Failed : " + failed);
		System.out.println("Number of testcases Skipped  : " + skipped);
	}

	/**
	 * Setup.
	 */
	@BeforeClass
	protected void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		//System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("disable-infobars");
		driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverContext.setDriver(driver);
	}

	/**
	 * Wrap up.
	 */
	@AfterClass
	public void wrapUp() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

}
