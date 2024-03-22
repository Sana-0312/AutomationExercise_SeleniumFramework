package selenium.pageObjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.AbstractComponents.abstractComponents;

public class ProductPage extends abstractComponents {
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='product-image-wrapper']")
	List<WebElement> products;
	
	@FindBy(xpath="//div[@class='product-information']/h2")
	WebElement nameOfProduct;
	
	@FindBy(xpath="//div[@class='product-information']/p[1]")
	WebElement category;
	
	@FindBy(xpath="//div[@class='product-information']/span/span")
	WebElement price;
	
	@FindBy(xpath="//div[@class='product-information']/p[2]")
	WebElement availabilty;
	
	@FindBy(xpath="//div[@class='product-information']/p[3]")
	WebElement condition;
	
	@FindBy(xpath="//div[@class='product-information']/p[4]")
	WebElement brand;
	
	@FindBy(id="search_product")
	WebElement searchBox;
	
	@FindBy(id="submit_search")
	WebElement submitSearch;
	
	@FindBy(id="quantity")
	WebElement quantity;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="review")
	WebElement review;
	
	@FindBy(id="button-review")
	WebElement submitReview;
	
	@FindBy(xpath="//td[@class='cart_quantity']/button")
	WebElement quantityCart;
	
	@FindBy(css=".btn-default.cart")
	WebElement addToCart;
	
	@FindBy(css="div[class='productinfo text-center'] p")
	WebElement searchedProduct;
	
	@FindBy(xpath="//div[@class='productinfo text-center'] //a[@data-product-id='5']")
	WebElement winterTop;
	
	@FindBy(xpath="(//div[@class='productinfo text-center'] //a[@data-product-id='1'])[1]")
	WebElement product1;
	
	@FindBy(css=".btn.btn-success.close-modal.btn-block")
	WebElement ctnShopping;
	
	@FindBy(xpath="(//div[@class='productinfo text-center'] //a[@data-product-id='2'])[1]")
	WebElement product2;
	
	@FindBy(xpath="//div[@class='productinfo text-center'] //a[@data-product-id='3']")
	WebElement product3;
	
	@FindBy(xpath="//td[@class='cart_description']/h4/a")
	WebElement product5;
	
	@FindBy(xpath="//li[@class='active']/a")
	WebElement writeReview;
	
	@FindBy(xpath="//h2[normalize-space()='Category']")
	WebElement sidebar1;

	@FindBy(xpath="(//span[@class='badge pull-right'])[1]")
	WebElement ctgWomen;
	
	@FindBy(xpath="(//div[@class='panel-collapse in']/div/ul/li/a)[1]")
	WebElement dress;
	
	@FindBy(xpath="(//i[@class='fa fa-plus'])[2]")
	WebElement ctgMen;
	
	@FindBy(xpath="//h2[normalize-space()='Women - Dress Products']")
	WebElement womenCategoryTitle;
	
	@FindBy(css="a[href='/category_products/3']")
	WebElement Tshirts;
	
	@FindBy(xpath="//h2[normalize-space()='Men - Tshirts Products']")
	WebElement menCategoryTitle;
	
	@FindBy(xpath="//div[@class='brands_products']/h2")
	WebElement brandTxt;
	
	@FindBy(xpath="(//div[@class='brands-name']/ul/li)[3]")
	WebElement madameBrand;
	
	@FindBy(xpath="//div[@class='features_items']/h2")
	WebElement brandMadameTxt;
	
	@FindBy(xpath="(//div[@class='brands-name']/ul/li)[1]")
	WebElement poloBrand;
	
	@FindBy(xpath="//div[@class='features_items']/h2")
	WebElement brandPoloTxt;
	
	@FindBy(xpath="//div[@class='alert-success alert']/span")
	WebElement thankyouMsg;
	
	By productNames = By.xpath("//div[@class='productinfo text-center']/p");
	By veiwProduct = By.cssSelector("a[href='/product_details/1']");
	
	public String getProductPageTitle()
	{
		waitForListElementsToAppear(products);
		return driver.getTitle();
	}
	public List<WebElement> getProductList() 
	{
		return products;
	}
	public WebElement firstProduct(String productName)
	{
		scrolling("window.scrollBy(0,500)");
		WebElement product1 = getProductList().stream().filter(product->
		product.findElement(productNames).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return product1;
	}
	public void viewProductbutton(String productName)
	{
		WebElement product1 = firstProduct(productName);
		product1.findElement(veiwProduct).click();
	}
	
	public void productQuantity(String Qno)
	{
		quantity.clear();
		quantity.sendKeys(Qno);
	}
	public void addToCartProductDetail()
	{
		addToCart.click();
	}
	public String quantityInCartPage()
	{
		return quantityCart.getText();
	}
	public String VerifyProduct()
	{
		return nameOfProduct.getText();
	}
	public String verifyCategory()
	{
		String[] c = category.getText().split(":");
		String[] w = c[1].split(">");
		return w[0].trim();
			
	}
	public String verifyPrice()
	{
		return price.getText();
	}
	public String verifyAvailabilty()
	{
		String[] a = availabilty.getText().split(":");
		return a[1].trim();
	}
	public String verifyCondition()
	{
		String[] c1 = condition.getText().split(":");
		return c1[1].trim();
	}
	public String verifyBrand()
	{
		String[] b = brand.getText().split(":");
		return b[1].trim();
	}
	public void search(String searchProduct)
	{
		scrolling("window.scrollBy(0,-200)");
		searchBox.sendKeys(searchProduct);
		submitSearch.click();
	}
	
	public String getSearchedProduct()
	{
		scrolling("window.scrollBy(0,500)");
		waitForElementsToAppear(searchedProduct);
		return searchedProduct.getText();
	}
	public void moveToProduct() throws InterruptedException
	{
		
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		a.moveToElement(product1).click().build().perform();
		ctnShopping.click();
		a.moveToElement(product2).click().build().perform();
	}
	
	public void addProductToCart()
	{
		waitForListElementsToAppear(products);
		scrolling("window.scrollBy(0,500)");
		product3.click();
	}
	public void continueShopping()
	{
		ctnShopping.click();
	}
	public String getSidebarTxt1()
	{
		scrolling("window.scrollBy(0,500)");
		return sidebar1.getText();
	}

	public void womenCategory() throws InterruptedException
	{
		Thread.sleep(3000);
		ctgWomen.click();
		Thread.sleep(3000);
		dress.click();
		
	}
	public String getWomenCategoryTitle()
	{
		waitForElementsToAppear(womenCategoryTitle);
		return womenCategoryTitle.getText();
	}
	public void menCategory() throws InterruptedException
	{
		Thread.sleep(3000);		
		ctgMen.click();
		Thread.sleep(3000);	
		Tshirts.click();
		waitForElementsToAppear(menCategoryTitle);
	}
	public String getMenCategoryTitle()
	{
		return menCategoryTitle.getText();
	}
	public String getBrandTxt() throws InterruptedException
	{
		scrolling("window.scrollBy(0,700)");
		Thread.sleep(3000);
		return brandTxt.getText();
	}
	public void brandName()
	{
		madameBrand.click();
	}
	public String getbrandMadameTxt() throws InterruptedException
	{
		Thread.sleep(3000);	
		return brandMadameTxt.getText();
	}
	public void brandPolo() throws InterruptedException
	{
		Thread.sleep(3000);	
		poloBrand.click();
	}
	public String getBrandPoloTxt()
	{
		return brandPoloTxt.getText();
	}
	public void addWinterTop()
	{
		winterTop.click();
	}
	public String getProductName()
	{
		return product5.getText();
	}
	public String getwriteReview()
	{
		return writeReview.getText();
	}
	public void writeReview(String myName,String myEmail,String myReview)
	{
		scrolling("window.scrollBy(0,600)");
		name.sendKeys(myName);
		email.sendKeys(myEmail);
		review.sendKeys(myReview);
		submitReview.click();
		
	}
	public String getThankyouMsg()
	{
		return thankyouMsg.getText();
	}

}
