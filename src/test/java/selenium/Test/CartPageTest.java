package selenium.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.TestComponents.BaseTest;
import selenium.pageObjects.CartPage;
import selenium.pageObjects.ProductPage;

public class CartPageTest extends BaseTest {
	@Test(dataProvider="getData")
	public void cart(HashMap<String,String> map) throws InterruptedException 
	{
		ProductPage productpage = loginPage.productslink();
		productpage.moveToProduct();
		CartPage cartPage = productpage.ViewCartLink();
		String p1 = cartPage.productName1();
		if(p1.equals(map.get("product1")))
		{
			System.out.println("product1 is added to cart");
		}
		else
		{
			System.out.println("product1 is not added to cart");
		}		
		String price1 = cartPage.checkPrice1();
		Assert.assertTrue(price1.equalsIgnoreCase(map.get("P1price")));
		String prod1Quantity = cartPage.checkQuantity1();
		Assert.assertTrue(prod1Quantity.equalsIgnoreCase(map.get("P1Quantity")));
		String totalPrice = cartPage.checkTotalPrice1();
		String cartTotal = cartPage.cartTotalPrice1();
		if(cartTotal.equals(totalPrice))
		{
			System.out.println("Total price of P1 is equal");
		}
		else
		{
			System.out.println("Total price of P1 is not equal");
		}
		String p2 = cartPage.productName2();
		if(p2.equals(map.get("product2")))
		{
			System.out.println("product2 is added to cart");
		}
		else
		{
			System.out.println("product2 is not added to cart");
		}		
		String price2 = cartPage.checkPrice2();
		Assert.assertTrue(price2.equalsIgnoreCase(map.get("P2price")));
		String prod2Quantity = cartPage.checkQuantity1();
		Assert.assertTrue(prod2Quantity.equalsIgnoreCase(map.get("P1Quantity")));
		String totalPrice2 = cartPage.checkTotalPrice2();
		String cartTotal2 = cartPage.cartTotalPrice2();
		if(cartTotal2.equals(totalPrice2))
		{
			System.out.println("Total price of P2 is equal");
		}
		else
		{
			System.out.println("Total price of P2 is not equal");
		}
		
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJasonData(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\data\\product.jason");
		return new Object[][] {{data.get(0)}};
		
	}

}
