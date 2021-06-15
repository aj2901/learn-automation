import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Open_Firefox {

    public static void main(String[] args) {
        
        //Creating a driver object referencing WebDriver interface
        WebDriver driver_Firefox;
        
        //Setting webdriver.gecko.driver property
        System.setProperty("webdriver.gecko.driver", "D:\\jee-2021-03\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        
        //Instantiating driver object and launching browser
        driver_Firefox = new FirefoxDriver();
        
        //Using get() method to open a webpage
        driver_Firefox.get("https://www.arsenal.com");
        
        //Closing the browser
        //driver_Firefox.quit();
        
        
    }
 
}
