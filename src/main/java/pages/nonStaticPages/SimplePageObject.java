package pages.nonStaticPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This Page Object contains private static By locators and public getters which return WebElements (no behavior)
 */
public class SimplePageObject {
    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("passwd");
    private static final By LOGIN_BUTTON = By.id("login");

    private WebDriver driver;

    public SimplePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(USERNAME_FIELD);
    }

    public WebElement getPasswordField() {
        return driver.findElement(PASSWORD_FIELD);
    }

    public WebElement getLoginButton() {
        return driver.findElement(LOGIN_BUTTON);
    }
}
