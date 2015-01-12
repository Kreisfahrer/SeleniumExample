package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.factoryPages.ExplicitFactoryPageObject;

import java.util.concurrent.TimeUnit;

/**
 * Created by andreystakhievich on 1/12/2015.
 */
public class FactoryPageObjectTest {
    private static final String BASE_URL = "url";
    private WebDriver driver;
    private ExplicitFactoryPageObject loginPage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        loginPage = PageFactory.initElements(driver, ExplicitFactoryPageObject.class);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void sampleTest() throws InterruptedException {
        loginPage.searchFor("Cheese");
        Thread.sleep(5000);

        driver.quit();
        Assert.assertTrue(IsOnHomePage());
    }

    private boolean IsOnHomePage() {
        return true;
    }
}
