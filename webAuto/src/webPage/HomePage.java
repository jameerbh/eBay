package webPage;

import interfaces.Constants;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class HomePage 
{
	protected static WebDriver driver;
	
	static By input=By.xpath("//*[@id=\"gh-ac\"]");
	static By submitButton=By.xpath("//*[@id=\"gh-btn\"]");
	static By eBayLabel=By.xpath("//*[@id=\"gh-la\"]");
	static By productFound=By.xpath("//*[@id=\"srp-river-results-listing1\"]/div/div[2]/a/h3");
	static By allListings=By.xpath("//*[@id=\"srp-river-results-SEARCH_STATUS_MODEL_V2-w0\"]/div[1]/div[2]/div/ul/li[1]/h2");
	static By searchResults=By.xpath("//*[@id=\"srp-river-results-SEARCH_STATUS_MODEL_V2-w0\"]/div[2]/div[1]/div[1]/h1");
	static By searchedProduct=By.xpath("//*[@id=\"srp-river-results-listing1\"]/div/div[2]/a/h3");
	static By addToCart=By.xpath("//*[@id=\"atcRedesignId_btn\"]");
	static By goToCart=By.xpath("//*[@class=\"btn btn-scnd vi-VR-btnWdth-XL\"]");
	static By cartItem = By.xpath("//*[@id=\"gh-cart-n\"]");
	
	public void setWebDriver(WebDriver driver) {
		try {
			HomePage.driver = driver;
		}
		
		catch(WebDriverException element) {
			System.out.println("Webdriver exception: " + element.getMessage());
		}
	}
	
	public static void searchText(String query) {
		try {
			driver.findElement(input).sendKeys(query + Keys.ENTER);
		}
		
		catch(WebDriverException element) {
			System.out.println("Webdriver exception: " + element.getMessage());
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File(Constants.SCREENSHOTS+System.currentTimeMillis()+".png"));
		} 
		
		catch (IOException io) {
			System.out.println("IO exception: " + io.getMessage());
		}
		}	
	}	
}