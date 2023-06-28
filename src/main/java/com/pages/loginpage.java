package com.pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class loginpage {
	private WebDriver driver;
	
	public loginpage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	

public String geturl() {
	return driver.getTitle();
}
		@FindBy(xpath = "//input[@type='text']")
	     WebElement txt_Username;		
		public void username(String name) {
			txt_Username.sendKeys(name);
		}
		@FindBy(id = "password")
     	public WebElement Txt_password ;
		
		@FindBy(name = "login-button")
     	public WebElement Btn_login ;
		
		@FindBy(id = "add-to-cart-sauce-labs-backpack")
     	public WebElement btn_cart1 ;
		
		@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
     	public WebElement lbl_product ;
		
		@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
     	public WebElement lbl_product1 ;

		@FindBy(id = "back-to-products")
     	public WebElement btn_back ;
		
		@FindBy(id = "add-to-cart-sauce-labs-bike-light")
     	public WebElement btn_cart2 ;
		
		@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
     	public WebElement btn_cart3 ;
		
		@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
     	public WebElement btn_cart4 ;
     	
     	@FindBy(xpath = "//a[@class='shopping_cart_link']")
     	public WebElement btn_cart ;
     	
     	@FindBy(id = "remove-sauce-labs-backpack")
     	public WebElement btn_remove ;
     	
     	@FindBy(xpath = "//select[@class='product_sort_container']")
     	public WebElement btn_sort ;
     	
     	@FindBy(xpath = "//div[@class='inventory_item_name']")
     	public List<WebElement>  lbl_products;
     	
     	@FindBy(xpath = "//div[@class='inventory_item_price']")
     	public List<WebElement>  lbl_price;
     	
     	@FindBy(id = "checkout")
     	public WebElement  btn_checkout;
     	
     	@FindBy(id = "first-name")
     	public WebElement Txt_firstname;
     	
     	@FindBy(id = "last-name")
     	public WebElement Txt_lastname ;
     	
     	@FindBy(id = "postal-code")
     	public WebElement Txt_postalcode ;
     	
     	@FindBy(id = "continue")
     	public WebElement Btn_continue ;     	

     	@FindBy(xpath = "//*[@class='summary_value_label']")
     	public List<WebElement>  lbl_shippinginfo;
     	
     	@FindBy(xpath = "//*[@class='summary_info_label summary_total_label']")
     	public WebElement  lbl_priceinfo;
     	
     	@FindBy(id = "finish")
     	public WebElement Btn_finish ;
     	
     	@FindBy(xpath = "//*[@class='complete-header']")
     	public WebElement Lbl_order ;  
		
	}

