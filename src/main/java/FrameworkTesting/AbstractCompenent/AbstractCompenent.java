package FrameworkTesting.AbstractCompenent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractCompenent {

	WebDriver driver;

	public AbstractCompenent(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;


	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	
	public void goToCartPage() {

		cartHeader.click();
	}

	public void orderPage() {

		orderHeader.click();
	}
	
	public void waitdriverElementApp(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void errorWaitElement(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void invisiblewait(By elememt) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(elememt));

	}

}
