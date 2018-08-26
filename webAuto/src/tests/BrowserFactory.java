package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import interfaces.Constants;

public class BrowserFactory implements Constants {
	public String url;
	public String browserName;
    static WebDriver driver;
	
    /**
     * BrowserFactory
     * @param urlParam browserNameParam
     * @return NONE
     */
	public BrowserFactory(String urlParam,String browserNameParam) {
		if(urlParam ==  null || browserNameParam == null) {
			throw new IllegalArgumentException("Input parameter is null");
		}
		url = urlParam;		
		browserName = browserNameParam;
	}
	
	/**
	 * startBrowser
	 * @param NONE
	 * @return driver
	 */
	public WebDriver startBrowser() {
		try {
			if(browserName.equalsIgnoreCase("firefox")) {
				//System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH+"geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH2+"chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", Constants.DRIVER_PATH2+"iedriver.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
		}
		
		catch(WebDriverException dr) {
			System.out.println("Webdriver exception: " + dr.getMessage());
		}
		
		return driver;
	}

}
