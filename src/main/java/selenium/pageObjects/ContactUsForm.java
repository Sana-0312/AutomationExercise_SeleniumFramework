package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.AbstractComponents.abstractComponents;

public class ContactUsForm extends abstractComponents {
	WebDriver driver;
	public ContactUsForm(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="div[class='contact-form'] h2")
	WebElement inTounchTxt;
	
	@FindBy(css="input[placeholder='Name']")
	WebElement enterName;
	
	@FindBy(css="input[placeholder='Email']")
	WebElement enterEmail;
	
	@FindBy(css="input[placeholder='Subject']")
	WebElement enterSubject;
	
	@FindBy(id="message")
	WebElement enterMessage;
	
	@FindBy(css="input[name='upload_file']")
	WebElement file;
	
	@FindBy(css="input[value='Submit']")
	WebElement submit;
	
	@FindBy(css=".status.alert.alert-success")
	WebElement Success;
	
	public String getInTouch()
	{
		return inTounchTxt.getText();
	}
	public void contactForm(String name,String emailUser,String Subject,String Message)
	{
		enterName.sendKeys(name);
		enterEmail.sendKeys(emailUser);
		enterSubject.sendKeys(Subject);
		enterMessage.sendKeys(Message);	
	}
	public void fileUpload(String filepath)
	{
		file.sendKeys(filepath);
	}
	public void submitButton() {
		scrolling("window.scrollBy(0,500)");
		submit.click();
		
	}
	public String successMsg()
	{
		return Success.getText();
	}
	
	
}




