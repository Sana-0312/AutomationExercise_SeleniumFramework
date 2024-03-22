package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import selenium.AbstractComponents.abstractComponents;

public class UserRegistration extends abstractComponents {
	WebDriver driver;
	public UserRegistration(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='signup-form']/h2")
	WebElement newUser;
	
	@FindBy(css="input[placeholder='Name']")
	WebElement nameOfUser;
	
	@FindBy(css="input[data-qa='signup-email']")
	WebElement signupEmail;
	
	@FindBy(css="button[data-qa='signup-button']")
	WebElement signUp;
	
	@FindBy(xpath="(//h2)[1]")
	WebElement accountText;
	
	@FindBy(id="id_gender2")
	WebElement salutation;
	
	@FindBy(id="password")
	WebElement userPassword;
	
	@FindBy (id="days")
	WebElement day;
	
	@FindBy (id="months")
	WebElement month;
	
	@FindBy (id="years")
	WebElement year;
	
	@FindBy(id="newsletter")
	WebElement newsLetter;
	
	@FindBy(id="optin")
	WebElement offersCheckbox;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id = "last_name")
	WebElement lastName;
	
	@FindBy(id="address1")
	WebElement address;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="zipcode")
	WebElement zipcode;
	
	@FindBy(id="mobile_number")
	WebElement mobile_number;
	
	@FindBy(xpath="//button[@data-qa='create-account']")
	WebElement createAccount;
	
	@FindBy(xpath="//h2[@data-qa='account-created']")
	WebElement confirmMsg;
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	WebElement loginPassword;
	
	@FindBy(css="button[data-qa='login-button']")
	WebElement login;
	
	@FindBy(xpath="//form[@action='/signup']/p")
	WebElement RegisteredMsg;
	
	@FindBy(xpath="//form[@action='/login']/p")
	WebElement inCorrectMsg;
	
	@FindBy(xpath="//div[@class='recommended_items']/h2")
	WebElement itemsRecommended;
	
	@FindBy(xpath="//div[@id='recommended-item-carousel'] //a[@data-product-id='4']")
	WebElement product4;
	
	@FindBy(xpath="//td[@class='cart_description']/h4/a")
	WebElement product4Cart;
	
    //verify New User Signup text is visible
	public String verifyNewUserSignup()
	{
		waitForElementsToAppear(newUser);
		return newUser.getText();
	}
	//New User Signup
	public void NewUserSignup(String userName,String userEmail)
	{
		nameOfUser.sendKeys(userName);
		signupEmail.sendKeys(userEmail);
		signUp.click();
	}
	//verify Enter Account Information is visible
	public String verifyAccountText()
	{
		waitForElementsToAppear(accountText);
		return accountText.getText();
	}
	//Filling the details
	public void registerAccount(String password,String fName,String lName,String add,String userState,String userCity,String code,String userNumber)
	{
		salutation.click();
		userPassword.sendKeys(password);
		scrolling("window.scrollBy(0,500)");
		//DOB
		day.click();
		Select dayOption = new Select(day);
		dayOption.selectByValue("3");;
		month.click();
		Select monthOption = new Select(month);
		monthOption.selectByVisibleText("April");
		year.click();
		Select yearOption = new Select(year);
		yearOption.selectByValue("2001");
		//Checkboxes
		newsLetter.click();
		offersCheckbox.click();
		//User Information
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		address.sendKeys(add);
		scrolling("window.scrollBy(0,800)");
		country.click();
		Select cOption = new Select(country);
		cOption.selectByVisibleText("India");
		state.sendKeys(userState);
		city.sendKeys(userCity);
		zipcode.sendKeys(code);
		mobile_number.sendKeys(userNumber);	
	}
	//creating account
	public void createAcc()
	{
		createAccount.click();
	}
	//Verify account created message
	public String getMessage()
	{
		return confirmMsg.getText();
	}
	public void userLogin(String userEmail,String password)
	{
		loginEmail.sendKeys(userEmail);
		loginPassword.sendKeys(password);
		login.click();
		
	}
	public void Registereduser(String userName,String userEmail)
	{
		nameOfUser.sendKeys(userName);
		signupEmail.sendKeys(userEmail);
		signUp.click();
	}
	//click on continue
	public void Continue()
	{
		waitForElementsToAppear(continueButton);
		continueButton.click();
		
	}
	public String getRegisteredtxt()
	{
		return RegisteredMsg.getText();
	}
	public void inValidLogin(String inValidEmail,String inValidPassword)
	{
		loginEmail.sendKeys(inValidEmail);
		loginPassword.sendKeys(inValidPassword);
		login.click();
	}
	public String getInvalidMsg()
	{
		return inCorrectMsg.getText();
	}
	
	public String getItemsRecommendedTxt()
	{
		scrollToElement("arguments[0].scrollIntoView(true);", itemsRecommended);
		waitForElementsToAppear(itemsRecommended);
		return itemsRecommended.getText();
	}
	public void product()
	{
		product4.click();
	}
	public String getCartItemTxt()
	{
		return product4Cart.getText();
	}
}
