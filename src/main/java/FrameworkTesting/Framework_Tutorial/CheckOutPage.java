package FrameworkTesting.Framework_Tutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.cache.AbstractCache;

import FrameworkTesting.AbstractCompenent.AbstractCompenent;

public class CheckOutPage extends AbstractCompenent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "//button [@class='ta-item list-group-item ng-star-inserted'][2]")
	WebElement SelectCountry;

	@FindBy(css = ".action__submit")
	WebElement submit;

	By results = By.cssSelector("[class='ta-results list-group ng-star-inserted']");

	public void selectCountry(String countryname) {

		Actions a = new Actions(driver);

		a.sendKeys(country, countryname).build().perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		waitdriverElementApp(results);

		SelectCountry.click();

	}

	public void submitOrder() {

		submit.click();

	}

}
