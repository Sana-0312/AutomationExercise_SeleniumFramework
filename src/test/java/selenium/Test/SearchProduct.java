package selenium.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;
import selenium.pageObjects.ProductPage;

public class SearchProduct extends BaseTest {
	@Test(dataProvider="getData")
	public void search(HashMap<String,String> map)
	{
		
		ProductPage productpage = loginPage.productslink();
		productpage.search(map.get("searchProduct"));
		String sP = productpage.getSearchedProduct();
		Assert.assertTrue(sP.equalsIgnoreCase(map.get("searchProduct")));
		if(map.get("searchProduct").equals(sP))
		{
			System.out.println("products related to search are visible");
			}
		else
		{
			System.out.println("products related to search are not visible");
			}
		
		productpage.addWinterTop();
		productpage.ViewCartLink();
		String top = productpage.getProductName();
		Assert.assertTrue(top.equalsIgnoreCase(map.get("searchProduct")));
		loginPage.goToSignUp();
		loginPage.userLogin(map.get("myEmail"), map.get("password"));
		loginPage.goTOCart();
		if(map.get("searchProduct").equals(top))
		{
			System.out.println("product is in cart");
			}
		else
		{
			System.out.println("products is not in cart");
			}
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJasonData(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\data\\product.jason");
		return new Object[][] {{data.get(0)}};
		
	}
	

}
