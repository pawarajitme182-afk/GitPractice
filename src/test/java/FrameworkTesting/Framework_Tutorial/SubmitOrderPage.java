package FrameworkTesting.Framework_Tutorial;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameworkTesting.test.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderPage extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = "Purchase")

	public void submotorder(HashMap<String, String> input) throws IOException {

		landingpage.landingApp(input.get("email"), input.get("password"));

		ProductCatalog productcatologue = new ProductCatalog(driver);

		List<WebElement> products = productcatologue.getProductList();
		productcatologue.addProdyctToCart(input.get("product"));
		productcatologue.goToCartPage();

		Cartpage cartpage = new Cartpage(driver);
		boolean match = cartpage.verfifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		cartpage.goToCheckout();
		CheckOutPage checkoutpage = new CheckOutPage(driver);

		checkoutpage.selectCountry("India");
		checkoutpage.submitOrder();

		ConfirmationPage confirmationpage = new ConfirmationPage(driver);

		String message = confirmationpage.confirmOrder();

		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(message);

	}

	@Test(dependsOnMethods = { "submotorder" })

	public void orderHistoryTest() throws InterruptedException {

		landingpage.landingApp("pawarajitme182@gmail.com", "Ajit@9767");

		OrderPage orderpage = new OrderPage(driver);
		orderpage.orderPage();
		Assert.assertTrue(orderpage.orderDisplay(productName));

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		/*
		 * HashMap<String, String> map = new HashMap<String, String>();
		 * 
		 * map.put("email", "pawarajitme182@gmail.com"); map.put("password",
		 * "Ajit@9767"); map.put("product", "ZARA COAT 3");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * 
		 * map1.put("email", "Ajit123@gmail.com"); map1.put("password", "Ajit@9767");
		 * map1.put("product", "ADIDAS ORIGINAL");
		 */

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\FrameworkTesting\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
