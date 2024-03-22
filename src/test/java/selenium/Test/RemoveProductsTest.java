package selenium.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;
import selenium.pageObjects.CartPage;
import selenium.pageObjects.ProductPage;

public class RemoveProductsTest extends BaseTest {
	@Test
	public void remove()
	{
	ProductPage productpage = loginPage.productslink();
	productpage.addProductToCart();
    CartPage cartPage =loginPage.ViewCartLink();
	String cartPageTitle = loginPage.getPageTitle();
	Assert.assertTrue(cartPageTitle.equalsIgnoreCase("Automation Exercise - Checkout"));
	cartPage.deleteProduct();
	String emptyMsg = cartPage.getCartEmpty();
	if(emptyMsg.equalsIgnoreCase("Cart is empty!"))
	{
		System.out.println("Product is deleted");
	}
	else
	{
		System.out.println("Product is not deleted");
	}
	
	
	}
}
