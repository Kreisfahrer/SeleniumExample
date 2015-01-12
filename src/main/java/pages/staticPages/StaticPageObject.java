package pages.staticPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Static page object + behavior (static methods)
 */
public class StaticPageObject {
    public static final By USERNAME_FIELD = By.id("username");
    public static final By PASSWORD_FIELD = By.id("passwd");
    public static final By LOGIN_BUTTON = By.id("login");

    public static void fillForm(WebDriver driver, String user, String password) {
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public static void login(WebDriver driver) {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
