package FrameworkTesting.Framework_Tutorial;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import FrameworkTesting.test.BaseTest;
import FrameworkTesting.test.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest {

	@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)

	public void LoginpageError() throws IOException {

	

		landingpage.landingApp("pawaraji@gmail.com", "Ajit@9767");

		Assert.assertEquals("Incorrect email or password.", landingpage.erromessageValidation());

		
	}

	
	
	
	
	
	
	@Test

	public void cartErrorValidation() throws IOException {

		String productName = "ZARA COAT 3";

		landingpage.landingApp("pawarajitme182@gmail.com", "Ajit@9767");

		ProductCatalog productcatologue = new ProductCatalog(driver);

		List<WebElement> products = productcatologue.getProductList();
		productcatologue.addProdyctToCart(productName);
		productcatologue.goToCartPage();

		Cartpage cartpage = new Cartpage(driver);
		boolean match = cartpage.verfifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}
}
