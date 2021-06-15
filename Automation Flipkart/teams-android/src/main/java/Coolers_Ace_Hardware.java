import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Coolers_Ace_Hardware extends Open_Chrome {

	static WebDriver driver1;

	static void waitForCopyright() {
		waitForElement(driver1, "//div[@id='copyright']");
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\jee-2021-03\\chromedriver_win32\\chromedriver.exe");

		driver1 = new ChromeDriver();
		driver1.manage().window().maximize();

		driver1.get("https://www.acehardware.com/");

		waitForCopyright();

		waitForElement(driver1, "//input[@title='Search Box']");
		WebElement searchBox = driver1.findElement(By.xpath("//input[@title='Search Box']"));
		searchBox.sendKeys("Coolers");

		waitForElement(driver1, "//a[@href='https://www.acehardware.com/c/256']");
		WebElement suggestedSearch = driver1.findElement(By.xpath("//a[@href='https://www.acehardware.com/c/256']"));
		suggestedSearch.click();

		waitForCopyright();
		waitForElement(driver1, "//a[@class='mz-productlisting-title']");
		List<WebElement> productTitle = driver1.findElements(By.xpath("//a[@class='mz-productlisting-title']"));

		ArrayList<String> products = new ArrayList<String>();

		System.out.println("\nList of products" + "\n");

		for (int i = 0; i < productTitle.size(); i++) {
			WebElement title = productTitle.get(i);
			String titleValue = title.getAttribute("innerText");

			products.add(titleValue);

		}

		// Sorting Arraylist
		Collections.sort(products);

		// Printing Arraylist
		for (int i = 0; i < products.size(); i++) {
			System.out.println("Product " + (i + 1) + ":" + "\n" + "Name: " + products.get(i) + "\n");
		}

	}

}
