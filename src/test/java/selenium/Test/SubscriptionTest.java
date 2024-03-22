package selenium.Test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;

public class SubscriptionTest extends BaseTest {
	String text = "Full-Fledged practice website for Automation Engineers";
	@Test
	public void userSubscription()
	{
		//verify subscription in home page
		loginPage.scrollToBottom();
		String sub = loginPage.getSubscriptionTxt();
		Assert.assertTrue(sub.equalsIgnoreCase("SUBSCRIPTION"));
		loginPage.subscribe("sana@gmail.com");
		String success = loginPage.successText();
		Assert.assertTrue(success.equalsIgnoreCase("You have been successfully subscribed!"));
		loginPage.scrollUpArrow();
	    String h2 = loginPage.getfullFledgeTxt();
	    Assert.assertTrue(h2.equalsIgnoreCase("Full-Fledged practice website for Automation Engineers"));
	    //verify subscription in home page without using arrowbutton
	    loginPage.scrollToBottom();
		loginPage.scrollToTop();
		String text1 = loginPage.getfullFledgeTxt();
		if(text1.equals(text))
		{
			System.out.println("is visible on screen");
		}
		else
		{
			System.out.println("is not visible on screen");
		}
		//verify subscription in cart page
		loginPage.goTOCart();
		loginPage.scrollToBottom();
		loginPage.subscribe("sana@gmail.com");
		String cartSuccess = loginPage.successText();
		Assert.assertTrue(cartSuccess.equalsIgnoreCase("You have been successfully subscribed!"));
		
	   
	    
		
		
	
	}


	
	

}
