import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleTest {
    private static final String FIRST_SITE = "http://www.tut.by";
    private static final String SECOND_SITE = "http://www.habrahabr.ru/";
    private WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.get(FIRST_SITE);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void getTest() throws InterruptedException {
        Assert.assertTrue(driver.getCurrentUrl().contains(FIRST_SITE));
    }

    @Test
    public void backTest() throws InterruptedException {
        driver.get(SECOND_SITE);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains(FIRST_SITE));
    }

    @Test
    public void forwardTest() throws InterruptedException {
        driver.get(SECOND_SITE);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains(SECOND_SITE));
    }

    @Test
    public void refreshTest() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains(FIRST_SITE));
    }
}
