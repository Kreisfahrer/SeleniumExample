package pages.pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class AutoHomePage {
    @FindBy(className = "b-search")
    private SearchArrow searchArrow;

    // Other blocks and elements here

    public AutoHomePage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void search(String request) {
        searchArrow.search(request);
    }
}
