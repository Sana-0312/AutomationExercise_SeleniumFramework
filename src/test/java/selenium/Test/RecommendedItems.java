package selenium.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;

public class RecommendedItems extends BaseTest {
	@Test
	public void userSubscription() throws InterruptedException
	{
		String recommendedItems = loginPage.getItemsRecommendedTxt();
		Assert.assertTrue(recommendedItems.equals("RECOMMENDED ITEMS"));
		loginPage.product();
		loginPage.ViewCartLink();
		String dress = loginPage.getCartItemTxt();
		Assert.assertTrue(dress.equalsIgnoreCase("Stylish Dress"));
	}
}
