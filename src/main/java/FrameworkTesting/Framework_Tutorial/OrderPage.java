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

public class OrderPage extends AbstractCompenent {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	By toastmss = By.cssSelector("#toast-container");


	public void waituntilLoginpageDisappear() {
		
		invisiblewait(toastmss);
	}
	
	public boolean orderDisplay(String productName) {

		boolean match = productNames.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	
		
	}


