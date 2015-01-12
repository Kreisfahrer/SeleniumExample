package pages.factoryPages;

import org.openqa.selenium.WebElement;

/**
 * Page Object with implicit Factory
 */
public class ImplicitFactoryPageObject {

    private WebElement q;

    public void searchFor(String text) {
        q.sendKeys(text);
        q.submit();
    }
}
