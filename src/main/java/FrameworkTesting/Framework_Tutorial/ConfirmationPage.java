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

public class ConfirmationPage extends AbstractCompenent {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='hero-primary']")
	WebElement message;

	public String confirmOrder() {

		return message.getText();

	}

}
