package selenium.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;
import selenium.pageObjects.ProductPage;

public class ProductDetailTest extends BaseTest {
	@Test(dataProvider="getData")
	public void productVerification(HashMap<String,String> map) throws InterruptedException
	{
		ProductPage productpage = loginPage.productslink();
		String productPageTitle = productpage.getProductPageTitle();
		Assert.assertTrue(productPageTitle.equalsIgnoreCase("Automation Exercise - All Products"));
		productpage.firstProduct(map.get("product1"));
		productpage.viewProductbutton(map.get("product1"));
		productpage.productQuantity(map.get("quantity"));
		String p = productpage.VerifyProduct();
		Assert.assertTrue(p.equalsIgnoreCase(map.get("product1")));
		String p1 = productpage.verifyPrice();
		Assert.assertTrue(p1.equalsIgnoreCase(map.get("P1price")));
		String C= productpage.verifyCategory();
		Assert.assertTrue(C.equalsIgnoreCase(map.get("category")));
		String a= productpage.verifyAvailabilty();
		Assert.assertTrue(a.equalsIgnoreCase(map.get("availability")));
		String C1 = productpage.verifyCondition();
		Assert.assertTrue(C1.equalsIgnoreCase(map.get("condition")));
		String b = productpage.verifyBrand();
		Assert.assertTrue(b.equalsIgnoreCase(map.get("brandName")));
		productpage.addToCartProductDetail();
		productpage.ViewCartLink();
		String q = productpage.quantityInCartPage();
		Assert.assertTrue(q.equalsIgnoreCase(map.get("quantity")));
		
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJasonData(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\data\\product.jason");
		return new Object[][] {{data.get(0)}};
		
	}
	
}
