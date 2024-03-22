package selenium.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;
import selenium.pageObjects.ProductPage;

public class VerifySidebar extends BaseTest{
	@Test
	public void sidebar() throws InterruptedException {
		ProductPage productpage = loginPage.productslink();
		String category = productpage.getSidebarTxt1();
		Assert.assertTrue(category.equalsIgnoreCase("CATEGORY"));
		productpage.womenCategory();
		String Title = productpage.getWomenCategoryTitle();
		if(Title.equalsIgnoreCase("Women - Dress Products"))
		{
			System.out.println("women category is Displayed");
		}
		else {
			System.out.println("women category is not displayed");
		}
		String pageTitle = loginPage.getPageTitle();
		Assert.assertTrue(pageTitle.equalsIgnoreCase("Automation Exercise - Dress Products"));
		productpage.menCategory();
		String menTitle = productpage.getMenCategoryTitle();
		if(menTitle.equalsIgnoreCase("Men - Tshirts Products"))
		{
			System.out.println("Men category is Displayed");
		}
		else {
			System.out.println("Men category is not displayed");
		}
	}

}
