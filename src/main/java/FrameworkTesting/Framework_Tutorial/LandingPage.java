package FrameworkTesting.Framework_Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkTesting.AbstractCompenent.AbstractCompenent;

public class LandingPage extends AbstractCompenent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userpassword;
	
	@FindBy(id="login")
	WebElement submit;
	

	@FindBy(css ="[class*=flyInOut]")
	WebElement errorMessage;
	
	public void landingApp(String email, String pass) {
		
		userEmail.sendKeys(email);
		userpassword.sendKeys(pass);
		submit.click();
		
	}
	
	public String erromessageValidation() {
		errorWaitElement(errorMessage);
		return 	errorMessage.getText();
		
	}
	
	
	public void Goto()
	{
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
	}


}


