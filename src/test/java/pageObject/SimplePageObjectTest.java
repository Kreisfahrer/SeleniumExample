package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.nonStaticPages.SimplePageObject;

import java.util.concurrent.TimeUnit;

/**
 * Simple prototype code (not working) for using SimplePageObject
 */
public class SimplePageObjectTest {
    private static final String BASE_URL = "url";
    private SimplePageObject loginPage;
    private WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        loginPage = new SimplePageObject(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void sampleTest() {
        loginPage.getUsernameField().sendKeys("userName");
        loginPage.getPasswordField().sendKeys("password");
        loginPage.getLoginButton().click();
        Assert.assertTrue(IsOnHomePage());
    }

    private boolean IsOnHomePage() {
        return true;
    }
}
