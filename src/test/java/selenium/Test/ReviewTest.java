package selenium.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;
import selenium.pageObjects.ProductPage;

public class ReviewTest extends BaseTest{
	@Test(dataProvider="getData")
	public void review(HashMap<String,String> map)
	{
		ProductPage productpage = loginPage.productslink();
		String productPageTitle = productpage.getProductPageTitle();
		Assert.assertTrue(productPageTitle.equalsIgnoreCase("Automation Exercise - All Products"));
		productpage.firstProduct(map.get("product1"));
		productpage.viewProductbutton(map.get("product1"));
		String txt = productpage.getwriteReview();
		Assert.assertTrue(txt.equalsIgnoreCase("Write Your Review"));
		productpage.writeReview(map.get("myName"), map.get("myEmail"),map.get("myReview"));
		String thankyou = productpage.getThankyouMsg();
		Assert.assertTrue(thankyou.equalsIgnoreCase("Thank you for your review."));
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJasonData(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\data\\product.jason");
		return new Object[][] {{data.get(0)}};
		
	}
	

}
