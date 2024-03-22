package selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.AbstractComponents.abstractComponents;

public class CartPage extends abstractComponents {
	WebDriver driver;
	int tP = 0;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@id='cart_info'] //h4/a")
	List<WebElement> items;
	
	@FindBy(xpath="//td[@class='cart_quantity']/button")
	WebElement quantityCart;

	
	@FindBy(css="a[href='/product_details/1']")
	WebElement p1Name;
	
	@FindBy(css="a[href='/product_details/2']")
	WebElement p2Name;
	
	@FindBy(css="tr[id='product-1'] button[class='disabled']")
	WebElement p1Quantity;
	
	@FindBy(css="tr[id='product-2'] button[class='disabled']")
	WebElement p2Quantity;
	
	@FindBy(css="tr[id='product-1'] td[class='cart_price'] p")
	WebElement p1Price;
	

	@FindBy(css="tr[id='product-2'] td[class='cart_price'] p")
	WebElement p2Price;
	
	@FindBy(css="tr[id='product-1'] p[class='cart_total_price']")
	WebElement tp1;
	
	@FindBy(css="tr[id='product-2'] p[class='cart_total_price']")
	WebElement tp2;
	
	@FindBy(xpath="//a[@class='cart_quantity_delete']")
	WebElement delete;
	
	@FindBy(xpath="//span[@id='empty_cart'] //p/b")
	WebElement cartEmpty;
	
	By productQuantity = By.xpath("//td[@class='cart_quantity']/button");
	By productPrice = By.xpath("//td[@class='cart_price']/p");
	By cartPrice = By.xpath("//td[@class='cart_total']/p");
	
	public String productName1()
	{
		return p1Name.getText();
	}
	public String productName2()
	{
		return p2Name.getText();
	}
	public String checkQuantity1()
	{
		return p1Quantity.getText();
	}
	
	public String checkQuantity2()
	{
		return p2Quantity.getText();
	}
	public String checkPrice1()
	{
		String[] p = p1Price.getText().split(" ");
		String prodPrice = p[1].trim();
		return prodPrice;
	}
	public String checkPrice2()
	{
		String[] p2 = p2Price.getText().split(" ");
		String prodPrice2 = p2[1].trim();
		return prodPrice2;
	}
	public String checkTotalPrice1()
	{
		String prodQuantity1 = p1Quantity.getText();
		String[] p = p1Price.getText().split(" ");
		String prodPrice = p[1].trim();
		int quantity1 = Integer.parseInt(prodQuantity1);
		int price1 = Integer.parseInt(prodPrice);
	    int tP1 = quantity1 * price1;
	    String totalPrice1 = Integer.toString(tP1); 
	    return totalPrice1;
	}
	public String checkTotalPrice2()
	{
		String prodQuantity2 = p2Quantity.getText();
		String[] p2 = p2Price.getText().split(" ");
		String prodPrice2 = p2[1].trim();
		int quantity2 = Integer.parseInt(prodQuantity2);
		int price2 = Integer.parseInt(prodPrice2);
	    int tP2 = quantity2 * price2;
	    String totalPrice2 = Integer.toString(tP2); 
	    return totalPrice2;
	}
	public String cartTotalPrice1()
	{
		String[] prodtotal1 = tp1.getText().split(" ");
		String cartTotal1 = prodtotal1[1].trim();
		return cartTotal1;
	}
	public String cartTotalPrice2()
	{
		String[] prodtotal2 = tp2.getText().split(" ");
		String cartTotal2 = prodtotal2[1].trim();
		return cartTotal2;
	}
	public void deleteProduct()
	{
		delete.click();
	}
	public String getCartEmpty()
	{
		waitForElementsToAppear(cartEmpty);
		return cartEmpty.getText();
	}
	
	
}
