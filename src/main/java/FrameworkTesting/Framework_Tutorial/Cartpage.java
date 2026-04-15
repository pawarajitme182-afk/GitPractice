package FrameworkTesting.Framework_Tutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.cache.AbstractCache;

import FrameworkTesting.AbstractCompenent.AbstractCompenent;

public class Cartpage extends AbstractCompenent {

	WebDriver driver;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;


	
	public boolean verfifyProductDisplay(String productName) {

		boolean match = cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	public void goToCheckout() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

	

		js.executeScript("arguments[0].click();", checkout);

		
	}

}
