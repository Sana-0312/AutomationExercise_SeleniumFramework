package selenium.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.pageObjects.CartPage;
import selenium.pageObjects.CheckoutPage;
import selenium.pageObjects.ContactUsForm;
import selenium.pageObjects.ProductPage;



public class abstractComponents  {
	WebDriver driver;
	public ContactUsForm contact;
	public ProductPage productpage;
	public CheckoutPage checkoutpage;
	public CartPage cartPage;
	public abstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="a[href='/login']")
	WebElement signUpheader;
	
	@FindBy(css="a[href='/test_cases']")
	WebElement testcaseHeader;

	@FindBy(css="a[href='/logout']")
	WebElement logoutheader;
	
	@FindBy(xpath="(//ul[@class='nav navbar-nav']/li/a)[2]")
	WebElement productsHeader;
	
	@FindBy(xpath="//div[@class='login-form']/h2")
	WebElement loginText;
	
	@FindBy(xpath="(//ul[@class='nav navbar-nav']/li/a)[10]")
	WebElement getLoggedInAs;
	
	@FindBy(xpath="(//ul[@class='nav navbar-nav']/li/a)[5]")
	WebElement deleteAccount;
	
	@FindBy(xpath="//div[@id='form-section']/a")
	WebElement homeButton;
	
	@FindBy(xpath="//h2[@data-qa='account-deleted']")
	WebElement confirmAccDlt;
	
	@FindBy(css="a[href='/contact_us']")
	WebElement contactheader;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav'] //a[@href='/view_cart']")
	WebElement cartheader;

	@FindBy(id="scrollUp")
	WebElement scrollUp;
	
	@FindBy(css="div[class='item active'] div[class='col-sm-6'] h2")
	WebElement fullFledgeTxt;
	
	@FindBy(xpath="//div[@class='single-widget']/h2")
	WebElement subsTxt;
	
	@FindBy(id="susbscribe_email")
	WebElement subscriberEmail;
	
	@FindBy(id="subscribe")
	WebElement arrowbutton;
	
	@FindBy(css=".btn.btn-default.check_out")
	WebElement checkoutButton;
	
	@FindBy(id="success-subscribe")
	WebElement successSubscribe;
	
	@FindBy(css="p[class='text-center'] a[href='/login']")
	WebElement register;
	
	@FindBy(linkText="View Cart")
	WebElement viewCart;

	
	public void goTo()
	{
		driver.get("http://automationexercise.com");
	}
	
	public void goToSignUp()
	{
		signUpheader.click();
	}
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	public String visibleLoginText()
	{
		return loginText.getText();
	}
	public String verifyUser()
	{
		return getLoggedInAs.getText();
	}
	public void DeleteAcc()
	{
		deleteAccount.click();
		waitForElementsToAppear(confirmAccDlt);
		
	}
	//Delete account
	public String AccountDeletion()
	{
		return confirmAccDlt.getText();
	}
	public void userLogout()
	{
		logoutheader.click();
	}
	public ContactUsForm contactLink()
	{
		contactheader.click();
		contact = new ContactUsForm(driver);
		return contact;
	}
	public void alert()
	{
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	public void goTOCart()
	{
		waitForElementsToAppear(cartheader);
		cartheader.click();
	}
	public void testcaseLink()
	{
		testcaseHeader.click();
	}
	public ProductPage productslink()
	{
		productsHeader.click();
		productpage = new ProductPage(driver);
		return productpage;
	}
	public CartPage ViewCartLink()
	{
		viewCart.click();
		return cartPage = new CartPage(driver);
	}
	public void scrolling(String scroll)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript(scroll);
	}
	public void scrollToElement(String scroll,WebElement element)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript(scroll,element);
	}
	public void waitForElementsToAppear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForListElementsToAppear(List<WebElement> elements) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		
	}
	public void goBack()
	{
		driver.navigate().back();
	}
	public void scrollUpArrow()
	{
		scrollUp.click();
	}
	public void homeLink()
	{
		homeButton.click();
		waitForElementsToAppear(signUpheader);	
	}
	public String getfullFledgeTxt()
	{
		return fullFledgeTxt.getText();
	}
	public void scrollToBottom()
	{
		scrolling("window.scrollBy(0,document.body.scrollHeight)");
	}
	public void scrollToTop()
	{
		scrolling("window.scrollBy(0,0)");
	}
	public String getSubscriptionTxt()
	{
		return subsTxt.getText();
	}
	public void subscribe(String email)
	{
		subscriberEmail.sendKeys(email);
		arrowbutton.click();
	}
	public String successText()
	{
		return successSubscribe.getText();
	}
	public CheckoutPage proceedTocheckout()
	{
		checkoutButton.click();
		checkoutpage = new CheckoutPage(driver);
		return checkoutpage;
		
	}
	public void registerOrLogin()
	{
		register.click();
	}
}
