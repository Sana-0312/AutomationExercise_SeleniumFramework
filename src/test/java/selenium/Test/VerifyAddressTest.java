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

public class VerifyAddressTest extends BaseTest {
	@Test(dataProvider="getData")
	public void address(HashMap<String,String> input)
	{
		loginPage.goToSignUp();
		loginPage.NewUserSignup(input.get("userName"), input.get("userEmail"));
		loginPage.registerAccount(input.get("password"),input.get("fName"),input.get("lName"),input.get("add"),input.get("userState"),input.get("userCity"),input.get("code"),input.get("userNumber"));
		loginPage.createAcc();
		String successMsg = loginPage.getMessage();
		Assert.assertTrue(successMsg.equalsIgnoreCase("Account Created!"));
		loginPage.Continue();
		String LoggedName = loginPage.verifyUser();
		Assert.assertTrue(LoggedName.equalsIgnoreCase("Logged in as Sana"));
		ProductPage productpage = loginPage.productslink();
		productpage.addProductToCart();
		productpage.continueShopping();
		productpage.goTOCart();
		String cartPageTitle = loginPage.getPageTitle();
		Assert.assertTrue(cartPageTitle.equalsIgnoreCase("Automation Exercise - Checkout"));
		CheckoutPage checkoutpage = loginPage.proceedTocheckout();
		String deliveryAddress = checkoutpage.getDeliveryAddress();
		if(deliveryAddress.equalsIgnoreCase(input.get("add")))
		{
			System.out.println("Delivery address is  same address filled at the time registration of account");
		}
		else
		{
			System.out.println("Delivery address is not same address filled at the time registration of account");
		}
		String billingAddress = checkoutpage.getBillingAddress();
		if(billingAddress.equalsIgnoreCase(input.get("add")))
		{
			System.out.println("Billing address is  same address filled at the time registration of account");
		}
		else
		{
			System.out.println("Billing address is not same address filled at the time registration of account");
		}
		
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJasonData(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\data\\UserInfo.jason");
		return new Object[][] {{data.get(0)}};
		
	}
	}


