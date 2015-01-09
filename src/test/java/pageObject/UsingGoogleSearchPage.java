package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by andreystakhievich on 1/9/2015.
 */
public class UsingGoogleSearchPage {
    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of a driver
        WebDriver driver = new ChromeDriver();

        // Navigate to the right place
        driver.get("http://www.google.com/");

        // Create a new instance of the search page class
        // and initialise any WebElement fields in it.
        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);

        // And now do the search.
        page.searchFor("Cheese");
        Thread.sleep(5000);

        driver.quit();
    }
}
