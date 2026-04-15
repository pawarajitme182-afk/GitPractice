package FrameworkTesting.Framework_Tutorial;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		String productName="ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		// Disable password manager & leak detection
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);

		options.setExperimentalOption("prefs", prefs);

		// Extra strong arguments
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-save-password-bubble");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.findElement(By.id("userEmail")).sendKeys("pawarajitme182@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ajit@9767");
		driver.findElement(By.id("login")).click();

		LandingPage landingpage= new LandingPage(driver);
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		WebElement ck = prod.findElement(By.cssSelector(".card-body button:last-of-type"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", ck);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));



		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
	List<WebElement> cartProducts=	driver.findElements(By.cssSelector(".cartSection h3"));
	
	boolean match=cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
	Assert.assertTrue(match);
	WebElement checkout=driver.findElement(By.cssSelector(".totalRow button"));
	
	js.executeScript("arguments[0].click();", checkout);

	Actions a= new Actions(driver);
	
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
	
	js.executeScript("window.scrollBy(0,500)");
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='ta-results list-group ng-star-inserted']")));
	
	driver.findElement(By.xpath("//button [@class='ta-item list-group-item ng-star-inserted'][2]")).click();
	

	
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	String message=driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
	Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
	driver.close();
	
	
	
	}


	}

