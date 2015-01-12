package pages.staticPages;

import org.openqa.selenium.By;

/**
 * This Page Object contains only static By locators to be used in tests (no behavior)
 */
public class SimpleStaticPageObject {
    public static final By USERNAME_FIELD = By.id("username");
    public static final By PASSWORD_FIELD = By.id("passwd");
    public static final By LOGIN_BUTTON = By.id("login");
}
