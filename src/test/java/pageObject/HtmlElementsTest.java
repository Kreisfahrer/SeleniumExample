package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.pageElements.SearchPage;

import java.util.concurrent.TimeUnit;

public class HtmlElementsTest {
    private static final String BASE_URL = "http://www.yandex.com";
    private WebDriver driver;
    private SearchPage searchPage;


    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        searchPage = new SearchPage(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void sampleTest() throws InterruptedException {
        searchPage.search("yandex");
        Thread.sleep(3000);
    }
}
