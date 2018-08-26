package webPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import dataObjects.Product;
import interfaces.Constants;

public class SearchPage extends HomePage
{
	
	/**
     * validateSearchProduct
     * @param eProductName
     * @return NONE
     */
	
	public static Product validateSearchProduct(String eProductName) {
		driver.findElement(input).click();		
		try {	
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		    .withTimeout(20, TimeUnit.SECONDS)
		    .pollingEvery(4, TimeUnit.SECONDS)
		    .ignoring(NoSuchElementException.class, WebDriverException.class);
		    //.ignoring(WebDriverException.class);
			
			WebElement element1 = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
				return driver.findElement(searchResults);}
				});			
			if(element1.isDisplayed()) {
				boolean status = driver.findElement(searchResults).getText().equals("0 results");
				if(!status) {
					String aProductName=driver.findElement(searchedProduct).getText();
					return new Product(aProductName, null, null, eProductName);		
				}			
			}
		}
		
		catch(ElementNotVisibleException element) {
			System.out.println("Exception found-1: " + element.getMessage());
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try { 
				FileUtils.copyFile(src, new File(Constants.SCREENSHOTS+System.currentTimeMillis()+".png"));
			} 
			catch (IOException io) {
					System.out.println("IO exception: " + io.getMessage());
			}
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
		return null;
	}
}
