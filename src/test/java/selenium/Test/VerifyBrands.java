package selenium.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;
import selenium.pageObjects.ProductPage;

public class VerifyBrands extends BaseTest {
	@Test
	public void brand() throws InterruptedException
	{
		ProductPage productpage = loginPage.productslink();
		String brand = productpage.getBrandTxt();
		Assert.assertTrue(brand.equalsIgnoreCase("Brands"));
		productpage.brandName();
		String madame = productpage.getbrandMadameTxt();
		Assert.assertTrue(madame.equalsIgnoreCase("Brand - Madame Products"));
		productpage.brandPolo();
		String polo = productpage.getBrandPoloTxt();
		Assert.assertTrue(polo.equalsIgnoreCase("Brand - Polo Products"));
	}

}
