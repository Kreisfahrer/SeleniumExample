package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.staticPages.StaticPageObject;

import java.util.concurrent.TimeUnit;

/**
 * Simple prototype code (not working) for using StaticPageObject
 */
public class StaticPageObjectTest {
    private static final String BASE_URL = "url";
    private WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void sampleTest() {
        StaticPageObject.fillForm(driver, "userName", "password");
        StaticPageObject.login(driver);
        Assert.assertTrue(IsOnHomePage());
    }

    private boolean IsOnHomePage() {
        return true;
    }
}
