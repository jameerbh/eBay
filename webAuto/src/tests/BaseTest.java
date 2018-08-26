package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import interfaces.Constants;
import webPage.HomePage;

public class BaseTest {
	
	protected WebDriver driver;
	protected static HomePage homePage;
	
	/**
     * startBrowser
     * @param browserIdentifier
     * @return NONE
     */
	
	@Parameters("browsers")
	@BeforeClass
	public void startBrowser(String browserIdentifier)
	{
		try
		{
			driver = new BrowserFactory(Constants.WEB_URL, browserIdentifier).startBrowser();
			String currentURL=driver.getCurrentUrl();
			Assert.assertTrue(currentURL.contains(Constants.WEB_URL_STR), "URL not contains expected value");
			Assert.assertEquals(driver.getTitle(), Constants.WEB_TITLE, "URL not mactches expected value");
			//Reporter.log("=== Application started ===", true);
			homePage = new HomePage();
			homePage.setWebDriver(driver);
		}
		
		catch(WebDriverException element)
		{
			System.out.println("Webdriver exception: " + element.getMessage());
		}
	}
	
	/**
     * closeBrowser
     * @param NONE
     * @return NONE
     */
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		//Reporter.log("=== Browser session closed ===", true);
	}
}
