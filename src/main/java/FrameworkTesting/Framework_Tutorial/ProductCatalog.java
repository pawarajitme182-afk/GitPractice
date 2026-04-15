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

public class ProductCatalog extends AbstractCompenent {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By productBy = By.cssSelector(".mb-3");

	By addToCart = By.cssSelector(".card-body button:last-of-type");

	By toastmss = By.cssSelector("#toast-container");

	By loader = By.cssSelector(".ng-animating");

	public List<WebElement> getProductList() {

		waitdriverElementApp(productBy);
		return products;
	}

	public WebElement getProductByname(String productName) {

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProdyctToCart(String productName) {

		WebElement prod = getProductByname(productName);

		invisiblewait(toastmss);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", prod.findElement(addToCart));

		// prod.findElement(addToCart).click();

		waitdriverElementApp(toastmss);
		invisiblewait(loader);

	}

}
