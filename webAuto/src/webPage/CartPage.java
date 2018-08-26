package webPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import dataObjects.Cart;
import interfaces.Constants;

public class CartPage extends HomePage
{
	
	/**
     * addProductToCart
     * @param NONE
     * @return Cart
     */
	
	public static Cart  addProductToCart() {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(40, TimeUnit.SECONDS)
			.pollingEvery(5, TimeUnit.SECONDS)
			.ignoring(WebDriverException.class);
				
			WebElement element1 = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
				return driver.findElement(searchedProduct);}
			});			
			if(element1.isDisplayed()) {
				driver.findElement(searchedProduct).click();
			}
			
			WebElement element2 = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
				return driver.findElement(addToCart);}
			});			
			if(element2.isDisplayed()) {
				driver.findElement(addToCart).click();
			}
				
			WebElement element3 = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
				return driver.findElement(goToCart);}
			});			
				
			if(element3.isDisplayed()) {
				driver.findElement(goToCart).click();
			}
			
			WebElement element4 = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
				return driver.findElement(cartItem);}
			});			
				
			if(element4.isDisplayed()) {
				String productCountInCart=driver.findElement(cartItem).getText();
				return new Cart(Integer.parseInt(productCountInCart));
			}		
		}
		
		catch(NoSuchElementException element) {
			System.out.println("Exception found-1: " + element.getMessage());
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try { 
				FileUtils.copyFile(src, new File(Constants.SCREENSHOTS+System.currentTimeMillis()+".png"));
			} 
			catch (IOException io) { 
				System.out.println("IO exception-1: " + io.getMessage());
			}
		}
		catch(WebDriverException element) {
				System.out.println("Exception found-2: " + element.getMessage());
				File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try { 
					FileUtils.copyFile(src, new File(Constants.SCREENSHOTS+System.currentTimeMillis()+".png"));
				} 
				catch (IOException io) { 
					System.out.println("IO exception-2: " + io.getMessage());
				}
		}	
		return null;
	}
}