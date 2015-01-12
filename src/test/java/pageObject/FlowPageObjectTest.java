package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.flowPages.HomePage;
import pages.flowPages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by andreystakhievich on 1/12/2015.
 */
public class FlowPageObjectTest {
    private static final String BASE_URL = "url";
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void sampleTest() throws InterruptedException {
        loginPage
                .typeUsername("userName")
                .typePassword("password")
                .submitLogin()
                .verifyThatOnHomePage();
    }
}
