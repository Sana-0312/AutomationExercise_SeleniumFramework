package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.AbstractComponents.abstractComponents;

public class CheckoutPage extends abstractComponents{
	WebDriver driver;
	public CartPage cartPage;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2[normalize-space()='Address Details']")
	WebElement addresstxt;
	
	@FindBy(xpath="//html[1]/body[1]/section[1]/div[1]/div[4]/h2[1]")
	WebElement reviewtxt;
	
	@FindBy(css="textarea[name='message']")
	WebElement message;
	
	@FindBy(xpath="//input[@name='name_on_card']")
	WebElement name;
	
	@FindBy(xpath="//input[@name='cvc']")
	WebElement cvc;
	
	@FindBy(xpath="//input[@name='expiry_month']")
	WebElement expirymonth;
	
	@FindBy(xpath="//input[@name='expiry_year']")
	WebElement expiryyear;
	
	@FindBy(xpath="//input[@name='card_number']")
	WebElement number;
	
	@FindBy(id="submit")
	WebElement submit;
	
	@FindBy(xpath="//div[@class='col-sm-9 col-sm-offset-1']/p")
	WebElement ordersuccessmsg;
	
	@FindBy(xpath="//a[@href='/download_invoice/500']")
	WebElement invoice;
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement ctnButton;
	
	@FindBy(xpath="(//ul[@id='address_delivery']/li[@class='address_address1 address_address2'])[2]")
	WebElement deliveryAdd;
	
	@FindBy(xpath="(//ul[@id='address_invoice']/li[@class='address_address1 address_address2'])[2]")
	WebElement billingAdd;
	
	public String getAddressTxt()
	{
		return addresstxt.getText();
	}
	public String getReviewTxt()
	{
		scrolling("window.scrollBy(0,600)");
		return reviewtxt.getText();
	}
	public void enterComment(String Message)
	{
		scrolling("window.scrollBy(0,500)");
		message.sendKeys(Message);
	}
	public void cardDetails(String cardName,String cardNumber,String cvv,String expMonth,String expYear)
	{
		name.sendKeys(cardName);
		number.sendKeys(cardNumber);
		cvc.sendKeys(cvv);
		expirymonth.sendKeys(expMonth);
		expiryyear.sendKeys(expYear);
		submit.click();
		waitForElementsToAppear(ordersuccessmsg);
	}
	public String getOrderSuccessMsg()
	{
		return ordersuccessmsg.getText();
	}
	public void downloadInvoice()
	{
		invoice.click();
	}
	public void continueButton()
	{
		ctnButton.click();
	}
	public String getDeliveryAddress()
	{
		return deliveryAdd.getText();
	}
	public String getBillingAddress()
	{
		return billingAdd.getText();
	}
	

}
