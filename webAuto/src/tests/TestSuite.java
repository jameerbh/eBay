package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import dataObjects.Cart;
import dataObjects.Product;
import interfaces.Constants;
import webPage.CartPage;
import webPage.HomePage;
import webPage.SearchPage;

//@Listeners(testListener.TestCaseListener.class)
public class TestSuite extends BaseTest
{
	
	@Test(priority=1, description="Test to search first product")	
	public void testSearchProduct() {
		HomePage.searchText(Constants.PRODUCT1);
		Product product = SearchPage.validateSearchProduct(Constants.PRODUCT1);
		Assert.assertNotNull(product, "Product1 not found\n");
		Assert.assertEquals(product.getName(), Constants.PRODUCT1, "Product1 title not equals to expected value\n");
		System.out.println("Test 1 Passed");	
	}
	
	@Test(dependsOnMethods="testSearchProduct", priority=2, description="Test to add first product to cart")	
	public void testAddProductToCart() {
		Cart cartCount = CartPage.addProductToCart();
		Assert.assertNotNull(cartCount, "Cart found empty\n");
		Assert.assertEquals(cartCount.getNumberOfItems(), 1, "Cart count not equals to expected value 1\n");
		System.out.println("Test 2 Passed");
	}
	
	//@Test(dependsOnMethods="testAddProductToCart", priority=3, description="Test to search second product")	
	public void testSearchSecondProduct() {
		HomePage.searchText(Constants.PRODUCT2);
		Product product = SearchPage.validateSearchProduct(Constants.PRODUCT2);
		Assert.assertNotNull(product, "Product2 not found\n");
		Assert.assertEquals(product.getName(), Constants.PRODUCT2, "Product2 title not equals to expected value\n");
		System.out.println("Test 3 Passed");	
	}
	
	//@Test(dependsOnMethods="testSearchSecondProduct", priority=4, description="Test to add second product to cart")	
	public void testAddSecondProductToCart() {
		Cart cartCount = CartPage.addProductToCart();
		Assert.assertNotNull(cartCount, "Cart found empty\n");
		Assert.assertEquals(cartCount.getNumberOfItems(), 2, "Cart count not equals to expected value 2\n");
		System.out.println("Test 4 Passed");
	}
	
}
 