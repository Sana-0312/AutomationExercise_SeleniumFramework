package selenium.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;
import selenium.pageObjects.CheckoutPage;
import selenium.pageObjects.ProductPage;

public class LoginBeforeCheckoutTest extends BaseTest {
	@Test(dataProvider="getData")
	public void login(HashMap<String,String> input) throws InterruptedException 
	{
		loginPage.goToSignUp();
		loginPage.userLogin(input.get("validEmail"), input.get("validPassword"));
		String LoggedName = loginPage.verifyUser();
		Assert.assertTrue(LoggedName.equalsIgnoreCase("Logged in as alasana"));
		ProductPage productpage = loginPage.productslink();
		productpage.addProductToCart();
		productpage.continueShopping();
		productpage.goTOCart();
		String cartPageTitle = loginPage.getPageTitle();
		Assert.assertTrue(cartPageTitle.equalsIgnoreCase("Automation Exercise - Checkout"));
		CheckoutPage checkoutpage = loginPage.proceedTocheckout();
		String add = checkoutpage.getAddressTxt();
		Assert.assertTrue(add.equalsIgnoreCase("Address Details"));
		String review = checkoutpage.getReviewTxt();
		Assert.assertTrue(review.equalsIgnoreCase("Review Your Order"));
		checkoutpage.enterComment(input.get("Message"));
		loginPage.proceedTocheckout();
		checkoutpage.cardDetails(input.get("cardName"),input.get("cardNumber"),input.get("cvv"),input.get("expMonth"),input.get("expYear"));
		String successMsg2 = checkoutpage.getOrderSuccessMsg();
		Assert.assertTrue(successMsg2.equalsIgnoreCase("Congratulations! Your order has been confirmed!"));
		//loginPage.DeleteAcc();
		//String dltTxt = loginPage.AccountDeletion();
		//Assert.assertTrue(dltTxt.equalsIgnoreCase("Account Deleted!"));	
		
		
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJasonData(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\data\\UserInfo.jason");
		return new Object[][] {{data.get(0)}};
		
	}

}
