package stepdefinitions;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.factory.DriverFactory;
import com.pages.baseclass;
import com.pages.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class checkoutsteps extends baseclass {
	private loginpage lg = new loginpage(DriverFactory.getDriver());

	@Given("user added few products to the cart")
	public void user_added_few_products_to_the_cart() {
     	lg.btn_cart1.click();
		lg.btn_cart2.click();
		lg.btn_cart3.click();
		lg.btn_cart4.click();
		lg.btn_cart.click();
	}

	@Then("verify the products and proceed for checkout")
	public void verify_the_products_and_proceed_for_checkout() {		
		System.out.println(lg.lbl_products.size());
		for (WebElement webElement : lg.lbl_products) {
			String name = webElement.getText();
			System.out.println(name);
			Reporter.log(name);
		}
		lg.btn_checkout.click();
	}

	@Then("add firstname, lastname, postal code")
	public void add_firstname_lastname_postal_code() {	
		lg.Txt_firstname.sendKeys("swetcha");
		lg.Txt_lastname.sendKeys("reddy");
		lg.Txt_postalcode.sendKeys("50070");
		Reporter.log("added info");
	}

	@Then("click on continue")
	public void click_on_continue() {		
		lg.Btn_continue.click();

	}

	@Then("verify the payment info and shipping details")
	public void verify_the_payment_info_and_shipping_details() {		
		for (WebElement webElement : lg.lbl_shippinginfo) {
			String name = webElement.getText();
			System.out.println(name);
			Reporter.log(name);
		}

		String price = lg.lbl_priceinfo.getText();

		Reporter.log(price);
	}

	@Then("click on finish")
	public void click_on_finish() {
		lg.Btn_finish.click();
	}

	@Then("verify order should be placed successfully")
	public void verify_order_should_be_placed_successfully() {		
		String order = lg.Lbl_order.getText();
		System.out.println(order);
	}

}
