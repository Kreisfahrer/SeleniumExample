import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Acer on 22.12.2014.
 */
public class ElementsTest {
    private static final String BASE_URL = "http://the-internet.herokuapp.com";
    private WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException, IOException {
        driver = new PhantomJSDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void checkboxTest() throws InterruptedException, IOException {
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File("D:/screen.png"));
        WebElement ref = driver.findElement(By.linkText("Checkboxes"));
        ref.click();
        Thread.sleep(3000);
        List<WebElement> checkboxes = driver.findElements(
                By.cssSelector("input[type=checkbox]"));
        checkboxes.get(0).click();
        checkboxes.get(1).click();
        Assert.assertTrue(checkboxes.get(0).isSelected());
        Assert.assertFalse(checkboxes.get(1).isSelected());
    }

    @Test
    public void buttonTest() throws InterruptedException {
        WebElement ref = driver.findElement(By.linkText("Dynamic Controls"));
        ref.click();
        Thread.sleep(3000);
        WebElement removeButton = driver.findElement(By.id("btn"));
        WebElement div = driver.findElement(By.cssSelector("div#checkbox"));
        WebElement checkbox = driver.findElement(
                By.cssSelector("input[type=checkbox]"));
        Assert.assertFalse(checkbox.isSelected());
        Assert.assertEquals(div.getText().trim(), "A checkbox");
        Assert.assertEquals(removeButton.getText(), "Remove");
        removeButton.click();
        Thread.sleep(8000);
        Assert.assertEquals(removeButton.getText(), "Add");
        Assert.assertTrue(driver.getPageSource().contains("It's gone!"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("input[type=checkbox]")));
    }
}
