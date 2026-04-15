package FrameworkTesting.StepDefiner;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import FrameworkTesting.Framework_Tutorial.Cartpage;
import FrameworkTesting.Framework_Tutorial.CheckOutPage;
import FrameworkTesting.Framework_Tutorial.ConfirmationPage;
import FrameworkTesting.Framework_Tutorial.LandingPage;
import FrameworkTesting.Framework_Tutorial.ProductCatalog;
import FrameworkTesting.test.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDEfinerImplement extends BaseTest {

	public LandingPage landingpage;
	public ProductCatalog productcatologue;

	@Given("I landed on ecommerce page")

	public void Landed_on_ecommerce_page() throws IOException {

		landingpage = launchapp();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_with_Username_Password(String username, String password) {

		landingpage.landingApp(username, password);
	}

	@When("^I add product (.+) to cart$")
	public void add_product_toCart(String productName) {

		 productcatologue = new ProductCatalog(driver);
		List<WebElement> products = productcatologue.getProductList();
		productcatologue.addProdyctToCart(productName);
		productcatologue.goToCartPage();
	}
	
	@When ("^Checkout (.+) and submit the order$")
	
	public void check_out_Submit_order(String productName) {
		
		Cartpage cartpage = new Cartpage(driver);
		boolean match = cartpage.verfifyProductDisplay(productName);
		Assert.assertTrue(match);
		cartpage.goToCheckout();
		CheckOutPage checkoutpage = new CheckOutPage(driver);

		checkoutpage.selectCountry("India");
		checkoutpage.submitOrder();
	}
	
	@Then ("{string} message is displayed on confirmation page")
	
	public void message_displayed_confirmpage(String string) {
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		
		String message = confirmationpage.confirmOrder();

		Assert.assertTrue(message.equalsIgnoreCase(string));
		
		driver.close();
		
	}
	
	  @Then ("{string} message is displayed")
	  
	  public void Error_Message_Displayed( String strArg) {
	
	Assert.assertEquals(strArg, landingpage.erromessageValidation());
	
	driver.close();

	  }
}
