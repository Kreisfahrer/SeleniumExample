package pages.nonStaticPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Non-static page object + behavior (non-static methods)
 */
public class PageObject {
    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("passwd");
    private static final By LOGIN_BUTTON = By.id("login");

    private WebDriver driver;

    public PageObject(WebDriver driver) {
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

    public void fillForm(String user, String pass) {
        getUsernameField().sendKeys(user);
        getPasswordField().sendKeys(pass);
    }

    public void login() {
        getLoginButton().click();
    }
}
