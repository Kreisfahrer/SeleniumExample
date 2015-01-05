import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by andreystakhievich on 1/5/2015.
 */
public class InteractionsTest {
    private static final String BASE_URL = "http://the-internet.herokuapp.com";
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
    public void keysTest() throws InterruptedException {
        driver.findElement(By.linkText("Key Presses")).click();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Actions actions = new Actions(driver);
        for (int i = 0; i < letters.length(); i++){
            String letter = String.valueOf(letters.charAt(i));
            actions.sendKeys(letter).perform();
            WebElement result = driver.findElement(By.id("result"));
            Assert.assertTrue(result.getText().contains(String.valueOf(letters.charAt(i))));
        }
    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        WebElement promptButton = driver.findElement(By.cssSelector("button[onclick*=jsAlert]"));
        promptButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        Thread.sleep(2000);
        alert.accept();
        Assert.assertFalse(isAlertPresent(driver));
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You successfuly clicked an alert");
        Thread.sleep(2000);
    }

    @Test
    public void confirmTest() throws InterruptedException {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        WebElement promptButton = driver.findElement(By.cssSelector("button[onclick*=jsConfirm]"));
        promptButton.click();
        Alert confirm = driver.switchTo().alert();
        Assert.assertEquals(confirm.getText(), "I am a JS Confirm");
        Thread.sleep(2000);
        confirm.dismiss();
        Assert.assertFalse(isAlertPresent(driver));
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("Cancel"));
        Thread.sleep(2000);
    }

    @Test
    public void promptTest() throws InterruptedException {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        WebElement promptButton = driver.findElement(By.cssSelector("button[onclick*=jsPrompt]"));
        promptButton.click();
        Alert prompt = driver.switchTo().alert();
        Assert.assertEquals(prompt.getText(), "I am a JS prompt");
        String message = "I have accepted this alert";
        prompt.sendKeys(message);
        Thread.sleep(2000);
        prompt.accept();
        Assert.assertFalse(isAlertPresent(driver));
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains(message));
        Thread.sleep(2000);
    }

    @Test
    public void contextClickTest() throws InterruptedException {
        driver.findElement(By.linkText("Context Menu")).click();
        WebElement actionField = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(actionField).perform();
        Thread.sleep(500);
        actions
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.RETURN)
                .perform();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
        Assert.assertFalse(isAlertPresent(driver));
    }

    @Test
    public void dragNDropTest() throws InterruptedException {
        driver.findElement(By.linkText("Drag and Drop")).click();
        Thread.sleep(5000);
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        Assert.assertEquals(columnA.findElement(By.tagName("header")).getText(), "A");
        Assert.assertEquals(columnB.findElement(By.tagName("header")).getText(), "B");
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(columnA.findElement(By.tagName("header"))).clickAndHold().moveToElement(columnB).release().build().perform();
        actions.dragAndDrop(columnA.findElement(By.tagName("header")), columnB.findElement(By.tagName("header"))).perform();
        Thread.sleep(500);
        Assert.assertEquals(columnA.findElement(By.tagName("header")).getText(), "B");
        Assert.assertEquals(columnB.findElement(By.tagName("header")).getText(), "A");
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.findElement(By.linkText("Hovers")).click();
        List<WebElement> figures = driver.findElements(By.cssSelector(".figure"));
        Actions actions = new Actions(driver);
        for (WebElement figure: figures) {
            actions.moveToElement(figure).perform();
            Thread.sleep(2000);
            Assert.assertTrue(figure.findElement(By.tagName("h5")).isDisplayed());
        }
    }

    private static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    public static void waitForJquery(WebDriver driver) throws InterruptedException {
        new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }
}
