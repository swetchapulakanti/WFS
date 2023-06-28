package stepdefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import com.factory.DriverFactory;
import com.pages.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sortsteps {

	private loginpage lg = new loginpage(DriverFactory.getDriver());

	@Given("user login in to the home page")
	public void user_login_in_to_the_home_page() {
		DriverFactory.getDriver().get("https://www.saucedemo.com");
		lg.username("standard_user");
		lg.Txt_password.sendKeys("secret_sauce");
		lg.Btn_login.click();
		Reporter.log("login successfull");
	}

	@When("sort the products by name z-a by using sort dropdown")
	public void sort_the_products_by_name_z_a_by_using_sort_dropdown() {
		lg.btn_sort.click();
		Select dropZA = new Select(lg.btn_sort);
		dropZA.selectByValue("za");
	}

	@Then("verify products are sorted")
	public void verify_products_are_sorted() {
		System.out.println(lg.lbl_products.size());
		for (WebElement webElement : lg.lbl_products) {
			String name = webElement.getText();
			System.out.println(name);
			Reporter.log(name);
		}
	}

	@Then("sort the products by price low to high by using sort dropdown")
	public void sort_the_products_by_price_low_to_high_by_using_sort_dropdown() {
		lg.btn_sort.click();
		Select dropZA = new Select(lg.btn_sort);
		dropZA.selectByValue("lohi");
	}

	@Then("verify products are sorted by price")
	public void verify_products_are_sorted_by_price() {

		System.out.println(lg.lbl_price.size());

		for (WebElement webElement : lg.lbl_price) {
			String name = webElement.getText();
			System.out.println(name);
			Reporter.log(name);
		}

	}

}
