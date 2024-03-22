package selenium.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.TestComponents.BaseTest;
import selenium.pageObjects.ContactUsForm;

public class Signup_LoginTest extends BaseTest {
	@Test(dataProvider="getData")
	public void SignupPage(HashMap<String,String> input)
	{
		
		String pageTitle = loginPage.getPageTitle();
		Assert.assertTrue(pageTitle.equalsIgnoreCase("Automation Exercise"));
		loginPage.goToSignUp();
		String confirmText = loginPage.verifyNewUserSignup();
		Assert.assertTrue(confirmText.equalsIgnoreCase("New User Signup!"));
		loginPage.NewUserSignup(input.get("userName"), input.get("userEmail"));
		String accountVerify = loginPage.verifyAccountText();
		Assert.assertTrue(accountVerify.equalsIgnoreCase("Enter Account Information"));
		loginPage.registerAccount(input.get("password"),input.get("fName"),input.get("lName"),input.get("add"),input.get("userState"),input.get("userCity"),input.get("code"),input.get("userNumber"));
		loginPage.createAcc();
		String successMsg = loginPage.getMessage();
		Assert.assertTrue(successMsg.equalsIgnoreCase("Account Created!"));
		loginPage.Continue();
		loginPage.userLogout();
		//login and logout
		loginPage.goToSignUp();
		String loginTxt= loginPage.visibleLoginText();
		Assert.assertTrue(loginTxt.equalsIgnoreCase("Login to your account"));
		loginPage.userLogin(input.get("userEmail"), input.get("password"));
		String LoggedName = loginPage.verifyUser();
		Assert.assertTrue(LoggedName.equalsIgnoreCase("Logged in as Sana"));
		loginPage.userLogout();
		//Registered User
		String signupPageTitle = loginPage.getPageTitle();
		Assert.assertTrue(signupPageTitle.equalsIgnoreCase("Automation Exercise - Signup / Login"));
		loginPage.NewUserSignup(input.get("userName"), input.get("userEmail"));
		String existMsg = loginPage.getRegisteredtxt();
		Assert.assertTrue(existMsg.equalsIgnoreCase("Email Address already exist!"));
		//Delete account
		loginPage.userLogin(input.get("userEmail"), input.get("password"));
		loginPage.DeleteAcc();
		String accDlt = loginPage.AccountDeletion();
		Assert.assertTrue(accDlt.equalsIgnoreCase("Account Deleted!"));	
		//Test case link
		loginPage.testcaseLink();
		String Title = loginPage.getPageTitle();
		Assert.assertTrue(Title.equalsIgnoreCase("Automation Practice Website for UI Testing - Test Cases"));
		//invalid email and password
		loginPage.goToSignUp();
		loginPage.inValidLogin(input.get("inValidEmail"),input.get("inValidPassword"));
		String invalidMsg = loginPage.getInvalidMsg();
		Assert.assertTrue(invalidMsg.equalsIgnoreCase("Your email or password is incorrect!"));
		//contactus Form
		ContactUsForm contact = loginPage.contactLink();
		String text = contact.getInTouch();
		Assert.assertTrue(text.equalsIgnoreCase("Get In Touch"));
		contact.contactForm(input.get("userName"), input.get("userEmail"), input.get("Subject"), input.get("Message"));
		contact.fileUpload("C:\\Users\\alasa\\Documents\\DemoTest.xlsx");
		contact.submitButton();
		contact.alert();
		String successtxt = contact.successMsg();
		Assert.assertTrue(successtxt.equalsIgnoreCase("Success! Your details have been submitted successfully."));
		contact.homeLink();
		String homeTitle = contact.getPageTitle();
		Assert.assertTrue(homeTitle.equalsIgnoreCase("Automation Exercise"));
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJasonData(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\data\\UserInfo.jason");
		return new Object[][] {{data.get(0)}};
		
	}

}
