package pageObject;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    @CacheLookup
    @FindBy(how = How.NAME, using = "q")
    private WebElement searchBox;

    public void searchFor(String text) {
        searchBox.sendKeys(text);
        searchBox.submit();
    }
}
