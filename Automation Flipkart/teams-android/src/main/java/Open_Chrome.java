
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Open_Chrome {

	// Creating a driver object referencing WebDriver interface
	static WebDriver driver_Chrome;

	//Method created for setting explicit wait of 10 seconds on desired element using its xpath
	
	static void waitForElement(WebDriver driver01, String locator01) {
		WebDriverWait wait_Explicit = new WebDriverWait(driver01, 10);
		wait_Explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator01)));
		
	}
	public static void main(String[] args) throws InterruptedException {

		// Setting the webdriver.chrome.driver property to its executable's location
		System.setProperty("webdriver.chrome.driver", "D:\\jee-2021-03\\chromedriver_win32\\chromedriver.exe");

		// Instantiating driver object
		driver_Chrome = new ChromeDriver();
		driver_Chrome.manage().window().maximize();

		// Setting implicit wait time
		// driver_Chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Using get() method to open a webpage
		driver_Chrome.get("https://www.flipkart.com");

		// Get the Web Element corresponding to the Enter Email text field
		// wait_Explicit.until(ExpectedConditions.visibilityOfElementLocated(By.className("_1fqY3P")));
		WebElement userName = driver_Chrome.findElement(By.xpath("(//input[@type='text'])[2]"));

		// Get the Web Element corresponding to the Enter Password text field
		WebElement password = driver_Chrome.findElement(By.xpath("//input[@type='password']"));

		userName.sendKeys("9339067488");
		password.sendKeys("Ajay@2901");

		// userName.clear();
		// password.clear();

		// userName.sendKeys("9339067488");
		// password.sendKeys("Ajay@2901");

		WebElement login_Button = driver_Chrome.findElement(By.xpath("(//span[text()='Login'])[2]"));
		login_Button.click();
		
		//Calling method created for explicit wait on the element
		waitForElement(driver_Chrome, "//span[text()='Sell On Flipkart']");
		WebElement searchInput = driver_Chrome
				.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		searchInput.sendKeys("arsenal");
		// searchInput.sendKeys(Keys.ENTER);

		WebElement searchButton = driver_Chrome.findElement(By.xpath("//button[@type='submit']"));
		searchButton.click();

		waitForElement(driver_Chrome, "//a[@title='ImmortalDragon Arsenal FC FIFA Gaming Mousepad Mousepad']");
		WebElement select_Product = driver_Chrome
				.findElement(By.xpath("//a[@title='ImmortalDragon Arsenal FC FIFA Gaming Mousepad Mousepad']"));
		select_Product.click();

		ArrayList<String> tabs_Chrome = new ArrayList<String>(driver_Chrome.getWindowHandles());
		driver_Chrome.switchTo().window(tabs_Chrome.get(1));
		
		/*
		 * WebElement searchInput1 = driver_Chrome .findElement(By.
		 * xpath("//input[@title='Search for products, brands and more']"));
		 * searchInput1.sendKeys("arsenal");
		 */
		
		//WebElement select_Size = driver_Chrome.findElement(By.xpath("//li[@id='swatch-1-size']//a"));
		//select_Size.click();
		
		waitForElement(driver_Chrome, "//button[text()='ADD TO CART']");

		WebElement addToCart = driver_Chrome.findElement(By.xpath("//button[text()='ADD TO CART']"));
	//	Actions action = new Actions(driver_Chrome);
	//	action.click(addToCart).build().perform();
		addToCart.click();
		
		/*
		 * WebElement goToCart =
		 * driver_Chrome.findElement(By.xpath("//button[text()='GO TO CART']"));
		 * goToCart.click();
		 */

		waitForElement(driver_Chrome, "//form[@method='post']//button");
		WebElement placeOrder = driver_Chrome.findElement(By.xpath("//form[@method='post']//button"));
		placeOrder.click();

		waitForElement(driver_Chrome,"//label[@for='CNTCTCC323401802D41F0B773848BA']");
		WebElement selectAddress = driver_Chrome.findElement(By.xpath("//label[@for='CNTCTCC323401802D41F0B773848BA']"));
		selectAddress.click();
		
		WebElement clickDeliverHereButton = driver_Chrome.findElement(By.xpath("//button[text()='Deliver Here']"));
		clickDeliverHereButton.click();
		
		WebElement orderSummaryContinue = driver_Chrome.findElement(By.xpath("//button[text()='CONTINUE']"));
		orderSummaryContinue.click();

		// Closing the browser
		// driver_Chrome.quit();
	}

}
