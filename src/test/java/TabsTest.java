import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by andreystakhievich on 1/9/2015.
 */
public class TabsTest {
    private static final String BASE_URL = "http://www.html5rocks.com/en/tutorials/dnd/basics/";
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
        driver.quit();
    }

    @Test
    public void dragNDropTest() throws InterruptedException {
        //driver.findElement(By.cssSelector(".tryitbtn")).click();
//        for (String handle : driver.getWindowHandles()) {
//            driver.switchTo().window(handle);
//            System.out.println(driver.getTitle());
//            Thread.sleep(3000);
//        }
        //System.out.println(driver.getTitle());
        //driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
//        Thread.sleep(4000);
//        WebElement div = driver.findElement(By.id("columns-full"));
//        List<WebElement> dragables = div.findElements(By.cssSelector("div.column"));
//        Actions actions = new Actions(driver);
//        dragables.get(0).click();
//        actions.clickAndHold(dragables.get(0)).build().perform();
//        actions.moveToElement(dragables.get(3)).build().perform();
//        actions.release().build().perform();
//        actions.dragAndDrop(dragables.get(0), dragables.get(1)).build().perform();
//        actions.dragAndDrop(dragables.get(1), dragables.get(2)).build().perform();
//        actions.dragAndDrop(dragables.get(2), dragables.get(3)).build().perform();
//        actions.moveToElement(dragables.get(0)).clickAndHold().moveToElement(dragables.get(3)).perform();
//        actions.moveToElement(dragables.get(0)).clickAndHold().perform();
//        actions.moveToElement(dragables.get(3)).perform();
//        actions.moveByOffset(0, 5).perform();
//        actions.release().perform();
//        Thread.sleep(5000);
    }
}
