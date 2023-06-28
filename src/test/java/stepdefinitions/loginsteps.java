package stepdefinitions;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.factory.DriverFactory;
import com.pages.loginpage;
import com.testdata.ExcelDataSupplier;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginsteps {

	private loginpage lg = new loginpage(DriverFactory.getDriver());

	@Given("user navigate to the https:\\/\\/www.saucedemo.com in browser")
	public void user_navigate_to_the_https_www_saucedemo_com_in_browser() {
		DriverFactory.getDriver().get("https://www.saucedemo.com");
	}
	
    @Test(dataProvider="logindata",dataProviderClass=ExcelDataSupplier.class)
	@When("enter the username and password")
	public void enter_the_standard_user_and_secret_sauce(String Username, String Password ) {
		lg.username(Username);
		lg.Txt_password.sendKeys(Password);

	}

	@And("click on login")
	public void click_on_login() {
		lg.Btn_login.click();
	}

	@Then("login is successful and home page should be displayed")
	public void login_is_successful_and_home_page_should_be_displayed() {
		String actualUrl = "Swag Labs";
		String expectedUrl = lg.geturl();
		Assert.assertEquals(expectedUrl, actualUrl);

	}

	@Given("select the product user required")
	public void select_the_product_user_required() {
		DriverFactory.getDriver().get("https://www.saucedemo.com");
		lg.username("standard_user");
		lg.Txt_password.sendKeys("secret_sauce");
		lg.Btn_login.click();
		String productname = lg.lbl_product.getText();
		System.out.println(productname);
		lg.lbl_product.click();

	}

	@When("Add the product to the cart")
	public void add_the_product_to_the_card() {
		lg.btn_cart1.click();
		lg.btn_back.click();
	}

	@When("repeat the above steps for multiple products")
	public void repeat_the_above_steps_for_multiple_products() {
		lg.btn_cart2.click();
		lg.btn_cart3.click();
		lg.btn_cart4.click();
		}

	@Then("verify products should be added to the cart")
	public void verify_products_should_be_added_to_the_cart() {
		lg.btn_cart.click();
		String productname = lg.lbl_product.getText();
		System.out.println(productname);
		Assert.assertEquals(productname, "Sauce Labs Backpack");
		String product = lg.lbl_product1.getText();
		System.out.println(product);
		Assert.assertEquals(product, "Sauce Labs Bike Light");

	}

	@Then("remove to few products in the cart")
	public void remove_to_few_products_in_the_cart() {
		lg.btn_remove.click();

	}

	@Then("verify products are removed")
	public void verify_products_are_removed() {
		// loginpage lg = new loginpage(driver);

//		boolean isElementPresent(By locatorKey) {
//		    try {
//		        driver.findElement(locatorKey);
//		        return true;
//		    } catch (org.openqa.selenium.NoSuchElementException e) {
//		        return false;
//		    }
//		}
//
//		boolean isElementVisible(String cssLocator){
//		    return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
//		}

	}

}
